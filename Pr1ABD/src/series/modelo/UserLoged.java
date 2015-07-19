/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.modelo;

import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import bbdd.patterns.ActorMapper;
import bbdd.patterns.ComentarioEpisodioMapper;
import bbdd.patterns.ComentarioSerieMapper;
import bbdd.patterns.EpisodioMapper;
import bbdd.patterns.EpisodioVistoMapper;
import bbdd.patterns.GeneroMapper;
import bbdd.patterns.GeneroSerieMapper;
import bbdd.patterns.InterpretaMapper;
import bbdd.patterns.NotaEpisodioMapper;
import bbdd.patterns.NotaSerieMapper;
import bbdd.patterns.PersonajeMapper;
import bbdd.patterns.SerieMapper;
import bbdd.patterns.UsuarioMapper;
import bbdd.patterns.UsuarioSerieMapper;

public class UserLoged extends Observable {
	private Usuario userLog;
	private ArrayList<Serie> seriesSelecionadas;
	private ArrayList<Actor> actoresSelecionados;
	private ArrayList<Personaje> personajesSelecionados;
	private ArrayList<Genero> generosSelecionados;
	private ArrayList<Episodio> episodiosBuscados;
	private ArrayList<ComentarioSerie> comentariosSerieBuscados;
	private boolean isAdmin;
	
	public UserLoged (boolean admin)
	{
		userLog=null;
		seriesSelecionadas = new ArrayList<Serie>();
		actoresSelecionados = new ArrayList<Actor>();
		personajesSelecionados = new ArrayList<Personaje>();
		generosSelecionados = new ArrayList<Genero>();
		episodiosBuscados = new ArrayList<Episodio>();
		comentariosSerieBuscados = new ArrayList<ComentarioSerie>();
		isAdmin = admin;
	}
	
	public boolean getIsAdmin()
	{
		return isAdmin;
	}
	public boolean usuarioCorrecto(String nombre, String pass)
	{
		UsuarioMapper us= new UsuarioMapper();
		Usuario user = us.findById(nombre);
		if (user!= null && user.esTuPass(pass))
		{
			userLog=user;
			informarObservadores();
		}
		return userLog!=null;
	}
	
	 public boolean bucarSeries (String serie)
	  {
	    	SerieMapper se = new SerieMapper();
	    	seriesSelecionadas = (ArrayList<Serie>) se.findAllWithName(serie);
	    	NotaSerieMapper nsm = new NotaSerieMapper();
	    	for (int i=0; i<seriesSelecionadas.size(); i++)
	    	{
	    		seriesSelecionadas.get(i).setNotaMedia(nsm.getNotaMediaDeSerie(seriesSelecionadas.get(i).getId()));
	    	}
	    	if (seriesSelecionadas.isEmpty())
	    		return false;
	    	else
	    	{
	    		informarObservadores();
	    		return true;
	    	}
	    		
	  }
	 
	 public List<Serie> getSeriesDelUser()
	 {
		 return userLog.getSeriesFromUser();
	 }
	
	public boolean usuarioRegistrado()
	{
		if (userLog== null)
			return false;
		else
			return true;
	}
	
	/**
     * Indicar a los observadores que se ha actualizado el modelo.
     */
    private void informarObservadores(){
        setChanged(); // establece que ha habido un cambio.
        notifyObservers(); // notifica a los observadores.	
    }
    
    public Blob getImagen()
    {
    	return userLog.getFoto();
    }
    
    public String getNick()
    {
    	return userLog.getUser();
    }
    
    public Date getFecha()
    {
    	return userLog.getNacio();
    }
    
    public ArrayList<Serie> getSeriesBuscadas()
    {
    	return seriesSelecionadas;
    }
    
    public ArrayList<Actor> getActoresBuscados()
    {
    	return actoresSelecionados;
    }
    
    public ArrayList<Personaje> getPersonajesBuscados()
    {
    	return personajesSelecionados;
    }
    
    public ArrayList<Genero> getGenerosBuscados()
    {
    	return generosSelecionados;
    }

	public boolean seguirSerie(Serie ser) {
		
		if(userLog.areFollowTheSerie(ser))
		{
			userLog.unFollowSerie(ser);
			UsuarioSerieMapper userSerie = new UsuarioSerieMapper();
			UsuarioSerie nuevo = new UsuarioSerie(userLog.getUser(), ser.getId()); 
			if (userSerie.delete(nuevo))
			{
				informarObservadores();
				return true;
			}
			return false;
		}
		else
		{
			userLog.followSerie(ser);
			UsuarioSerieMapper userSerie = new UsuarioSerieMapper();
			UsuarioSerie nuevo = new UsuarioSerie(userLog.getUser(), ser.getId()); 
			if (userSerie.insert(nuevo))
			{
				informarObservadores();
				return true;
			}
			return false;
		}
		
	}

	public boolean agregarUsuarioNuevo(Usuario usuarioAgregar) {
		UsuarioMapper user = new UsuarioMapper();
		boolean ret = user.insert(usuarioAgregar);
		if (ret)
		{
			userLog= usuarioAgregar;
			informarObservadores();
		}
		return ret;
		
	}

	public boolean modificaUsuario(Usuario usuarioAgregar) {
		
		UsuarioMapper user = new UsuarioMapper();
		boolean ret =  user.update(userLog, usuarioAgregar);
		if (ret)
		{
			userLog= usuarioAgregar;
			informarObservadores();
		}
		return ret;
	}

	public boolean anadirSerie(Serie ser) {
		SerieMapper seri = new SerieMapper();
		return seri.insert(ser);
		
	}

	public boolean bucarActor(String actorBuscar) {
		ActorMapper actor = new ActorMapper();
		actoresSelecionados = (ArrayList<Actor>) actor.findAllWithName(actorBuscar);
		if (actoresSelecionados.isEmpty())
    		return false;
    	else
    	{
    		informarObservadores();
    		return true;
    	}
	}

	public boolean anadirActor(Actor actorAnadir) {
		ActorMapper actor = new ActorMapper();
		return actor.insert(actorAnadir);
	}

	public boolean editarSerie(Serie serieVieja, Serie serieNueva) {
		
		SerieMapper ser = new SerieMapper();
		return ser.update(serieVieja, serieNueva);		
	}

	public boolean editarActor(Actor actorViejo, Actor actorNuevo) {
		
		ActorMapper actor = new ActorMapper();
		return actor.update(actorViejo, actorNuevo);
		
	}

	public boolean bucarPersonaje(String nombrePersonajeBuscar) {
		PersonajeMapper per = new PersonajeMapper();
		personajesSelecionados = (ArrayList<Personaje>) per.findAllWithName(nombrePersonajeBuscar);
		if(personajesSelecionados.isEmpty())
			return false;
		else
			informarObservadores();
		return true;
	}

	public boolean editarPersonaje(Personaje personajeViejo, Personaje personajeNuevo) {
		PersonajeMapper per = new PersonajeMapper();
		return per.update(personajeViejo, personajeNuevo);		
		
	}

	public boolean anadirPersonaje(Personaje perAnadir) {
		PersonajeMapper persona = new PersonajeMapper();
		return persona.insert(perAnadir);
	}

	public boolean buscarGenero(String generoABuscar) {
		GeneroMapper genero = new GeneroMapper();
		generosSelecionados = (ArrayList<Genero>) genero.findAllWithName(generoABuscar);
		if (generosSelecionados.isEmpty())
			return false;
		informarObservadores();	
		return true;
	}

	public boolean anadirGenero(Genero generoAAnadir) {
		GeneroMapper genero = new GeneroMapper();
		return genero.insert(generoAAnadir);
		
	}

	public boolean agregarGeneroASerie(Serie serie, Genero genero) {
		serie.setGenero(genero);
		GeneroSerieMapper genSerMapper = new GeneroSerieMapper();
		return genSerMapper.insert(new GeneroSerie(serie.getId(), genero.getGenero()));
		
	} 
	
	public boolean eliminarGeneroASerie(Serie serie, Genero genero)
	{
		serie.deleteGenero(genero);
		GeneroSerieMapper genSerMapper = new GeneroSerieMapper();
		return genSerMapper.delete(new GeneroSerie(serie.getId(), genero.getGenero()));
	}
	
	public List<Episodio> episodiosNoVistosDe(Serie serie)
	{
		EpisodioMapper episodio = new EpisodioMapper();
		EpisodioVistoMapper eVM = new EpisodioVistoMapper();
		List<EpisodioVisto> listaEV = eVM.findAllEspisodiosVistosPorDe(getNick(), serie.getId());
		int episodiosVistos[] = new int[listaEV.size()];
		for(int i=0; i<listaEV.size();i++)
			episodiosVistos[i]=listaEV.get(i).getCapitulo();
		
		List<Episodio> episodios =episodio.findAllFromSerieMenos(serie.getId(), episodiosVistos);
		NotaEpisodioMapper nem = new NotaEpisodioMapper();
		for (int i=0; i<episodios.size(); i++)
		{
			episodios.get(i).setNotaMedia(nem.getNotaMediaDeSerie(episodios.get(i).getEpisodioSerie().getIdSerie(), episodios.get(i).getEpisodioSerie().getCapitulo()));
		}
		return episodios;
	}

	public void marcarEpisodioComoVisto(Episodio episodio) {
		EpisodioVistoMapper eVM = new EpisodioVistoMapper();
		EpisodioVisto episodioVisto = new EpisodioVisto(getNick(), episodio.getEpisodioSerie().getCapitulo(), episodio.getEpisodioSerie().getIdSerie());
		if (eVM.insert(episodioVisto))
			informarObservadores();
		
	}

	public void marcarEpisodioComoNoVisto(Episodio episodio) {
		EpisodioVistoMapper eVM = new EpisodioVistoMapper();
		EpisodioVisto episodioVisto = new EpisodioVisto(getNick(), episodio.getEpisodioSerie().getCapitulo(), episodio.getEpisodioSerie().getIdSerie());
		if (eVM.delete(episodioVisto))
			informarObservadores();
		
	}

	public void buscarEpisodioDeSerie(String serieBuscar, int episodioBuscar) {
		if(bucarSeries(serieBuscar))
		{
			episodiosBuscados = new ArrayList<Episodio>();
			for (int i = 0; i<seriesSelecionadas.size(); i++)
			{
				EpisodioMapper em = new EpisodioMapper();
				episodiosBuscados.addAll(em.findByIdRelative(new EpisodioSerie(episodioBuscar,seriesSelecionadas.get(i).getId())));
			}
			
			informarObservadores();
		}
		
	}
	
	public List<Episodio> getEpisodiosBuscados()
	{
		return episodiosBuscados;
	}

	public void borrarEpisodios(List<Object> listEpisodios) {
		EpisodioMapper em = new EpisodioMapper();
		for(int i=0; i<listEpisodios.size();i++)
			em.delete((Episodio)listEpisodios.get(i));
		informarObservadores();		
	}

	public void addEpisodio(Episodio episodio) {
		EpisodioMapper em = new EpisodioMapper();
		em.insert(episodio);
		
	}

	public boolean editarEpisodio(Episodio episodioNuevo, Episodio episodioviejo) {
		EpisodioMapper em = new EpisodioMapper();
		boolean ret =  em.update(episodioviejo, episodioNuevo);
		if (ret)
			{
				informarObservadores();
			}
		return ret;
	}

	public void puntuaSerie(Serie serie, int notaAPoner) {
		NotaSerieMapper nsm = new NotaSerieMapper();
		NotaSerie ns = new NotaSerie(getNick(), serie.getId(), notaAPoner);
		if (!nsm.insert(ns))
		{
			nsm.delete(ns);
			nsm.insert(ns);
		}
		informarObservadores();
		
	}

	public void puntuaEpisodio(Episodio episodio,int notaAPonerEpisodio) {
		NotaEpisodioMapper nem = new NotaEpisodioMapper();
		NotaEpisodio ne = new NotaEpisodio(getNick(), episodio.getEpisodioSerie().getIdSerie(), episodio.getEpisodioSerie().getCapitulo(), notaAPonerEpisodio);
		if(!nem.insert(ne))
		{
			nem.delete(ne);
			nem.insert(ne);
		}
		informarObservadores();
	}

	public boolean creaInterpretacion(Episodio episodio,Actor actor,Personaje personaje) {
		InterpretaMapper im = new InterpretaMapper();
		Interpreta interpretacion = new Interpreta(actor.getId(), personaje.getId(), 
						episodio.getEpisodioSerie().getIdSerie(), episodio.getEpisodioSerie().getCapitulo());
		return im.insert(interpretacion);
	}

	public boolean borraInterpretacion(Episodio episodio,Actor actor,Personaje personaje) {
		InterpretaMapper im = new InterpretaMapper();
		Interpreta interpretacion = new Interpreta(actor.getId(), personaje.getId(), 
						episodio.getEpisodioSerie().getIdSerie(), episodio.getEpisodioSerie().getCapitulo());
		return im.delete(interpretacion);
		
	}

	public void anadirComentarioDeSerie(Serie serieAComentar, String comentarioAnadirSerie) {
		java.util.Date utilDate = new java.util.Date();
		ComentarioSerie  comentario = new ComentarioSerie(getNick(), serieAComentar.getId(), comentarioAnadirSerie, new java.sql.Date(utilDate.getTime()));
		ComentarioSerieMapper csm = new ComentarioSerieMapper();
		csm.insert(comentario);
		
	}

	public void anadirComentarioDeEpisodio(Episodio episodioAComentar,
			String comentarioAnadirSerie) {
		
		java.util.Date utilDate = new java.util.Date();
		ComentarioEpisodio comentario = new ComentarioEpisodio(getNick(), episodioAComentar.getEpisodioSerie().getIdSerie(), 
							episodioAComentar.getEpisodioSerie().getCapitulo(), comentarioAnadirSerie, new java.sql.Date(utilDate.getTime()));
		ComentarioEpisodioMapper cem =new ComentarioEpisodioMapper();
		cem.insert(comentario);
	}
	
	public List<ComentarioSerie> getComentarioSerieBuscardos()
	{
		return comentariosSerieBuscados;
	}

	public void buscaComentariosSerieDelUser(String nombreUsuarioComentario) {
		ComentarioSerieMapper csm = new ComentarioSerieMapper();
		comentariosSerieBuscados= (ArrayList<ComentarioSerie>) csm.findAllWithName(nombreUsuarioComentario);
		informarObservadores();
	}

	public void borrarComentarioSerie(
			ComentarioSerie comentarioSerieSelecionadoParaBorrar) {
		ComentarioSerieMapper csm = new ComentarioSerieMapper();
		csm.delete(comentarioSerieSelecionadoParaBorrar);
		comentariosSerieBuscados.remove(comentarioSerieSelecionadoParaBorrar);
		informarObservadores();
	}
   
 
}
