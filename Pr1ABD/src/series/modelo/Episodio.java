/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import bbdd.patterns.ActorMapper;
import bbdd.patterns.ComentarioEpisodioMapper;
import bbdd.patterns.InterpretaMapper;
import bbdd.patterns.PersonajeMapper;

public class Episodio {

	private String titulo;
	private EpisodioSerie episodioSerie;
	private int temporada;
	private String sinopsis;
	private Date fecha;
	private int notaMedia;
	private List<Actor> actores;
	private List<Personaje> personajes;
	private List<ComentarioEpisodio> comentarios;
	
	public Episodio (String titulo,EpisodioSerie episodioSerie, int temporada, String sinopsis, Date fecha)
	{
		this.titulo=titulo;
		this.episodioSerie=episodioSerie;
		this.temporada=temporada;
		this.sinopsis=sinopsis;
		this.fecha=fecha;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @return the capitulo
	 */
	public EpisodioSerie getEpisodioSerie() {
		return episodioSerie;
	}

	/**
	 * @return the temporada
	 */
	public int getTemporada() {
		return temporada;
	}

	/**
	 * @return the sinopsis
	 */
	public String getSinopsis() {
		return sinopsis;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	
	public String toString()
	{
		return titulo;
	}

	/**
	 * @return the notaMedia
	 */
	public int getNotaMedia() {
		return notaMedia;
	}

	/**
	 * @param notaMedia the notaMedia to set
	 */
	public void setNotaMedia(int notaMedia) {
		this.notaMedia = notaMedia;
	}

	public List<Actor> getListaActores() {
		if (actores==null)
			inicializaActoresPersonajes();
		return actores;
	}

	private void inicializaActoresPersonajes() {
		actores = new ArrayList<Actor>();
		personajes = new ArrayList<Personaje>();
		InterpretaMapper im = new InterpretaMapper();
		List<Interpreta> interpretacion = im.findAllActorPersonajesFrom(episodioSerie.getCapitulo(), episodioSerie.getIdSerie());
		ActorMapper am = new ActorMapper();
		PersonajeMapper pm = new PersonajeMapper();
		for (int i =0 ; i<interpretacion.size(); i++)
		{
			actores.add(am.findById(interpretacion.get(i).getIdActor()));
			personajes.add(pm.findById(interpretacion.get(i).getIdPersonaje()));
		}
		
		
	}

	public List<Personaje> getListaPersonaje() {
		if (personajes==null)
			inicializaActoresPersonajes();
		return personajes;
	}
	
	public List<ComentarioEpisodio> getComentarios()
	{
		ComentarioEpisodioMapper cem = new ComentarioEpisodioMapper();
		comentarios = cem.findAllComentsFromEpisodio(episodioSerie);
		return comentarios;
	}


}
