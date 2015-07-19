/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.modelo;

import java.util.ArrayList;
import java.util.List;

import bbdd.patterns.ComentarioSerieMapper;
import bbdd.patterns.EpisodioMapper;
import bbdd.patterns.NotaEpisodioMapper;

public class Serie  implements Comparable<Serie>{
	private int id;
	private String nombre;
	private String titular;
	private String sinopsis;
	private int anoEstreno;
	private int anoFin;
	private int notaMedia;
	private List<Genero> generos;
	private List<Episodio> episodios;
	private List<ComentarioSerie> comentarios;
	
	public Serie(int i, String n, String t, String s, int ae, int af)
	{
		setId(i);
		setNombre(n);
		setTitular(t);
		setSinopsis(s);
		setAnoEstreno(ae);
		setAnoFin(af);
		generos = new ArrayList<Genero>();
		notaMedia=0;
	}
	
	public Serie( String n, String t, String s, int ae, int af)
	{
		setNombre(n);
		setTitular(t);
		setSinopsis(s);
		setAnoEstreno(ae);
		setAnoFin(af);
		setNotaMedia(0);
		generos = new ArrayList<Genero>();
		notaMedia=0;
	}
	
	public Serie(int i, String n, String t, String s, int ae)
	{
		setId(i);
		setNombre(n);
		setTitular(t);
		setSinopsis(s);
		setAnoEstreno(ae);
		setAnoFin(0);
		setNotaMedia(0);
		generos = new ArrayList<Genero>();
		notaMedia=0;
	}
	
	public Serie( String n, String t, String s, int ae)
	{
		setNombre(n);
		setTitular(t);
		setSinopsis(s);
		setAnoEstreno(ae);
		setAnoFin(0);
		setNotaMedia(0);
		generos = new ArrayList<Genero>();
		notaMedia=0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public int getAnoEstreno() {
		return anoEstreno;
	}

	public void setAnoEstreno(int anoEstreno) {
		this.anoEstreno = anoEstreno;
	}

	public int getAnoFin() {
		return anoFin;
	}

	public void setAnoFin(int anoFin) {
		this.anoFin = anoFin;
	}
	
	public void setGenero(Genero gen)
	{
		generos.add(gen);
	}
	
	public boolean deleteGenero(Genero gen)
	{
		Genero genero = null;
		for(int i=0; i<generos.size(); i++)
		{
			if (gen.getGenero().equalsIgnoreCase(generos.get(i).getGenero()))
			{
				genero = generos.get(i);
				generos.remove(genero);
			}
		}
		return genero!=null;		
	}
	
	public String generosToString()
	{
		String policrespo="";
		for(int i=0; i<generos.size(); i++)
		{
			policrespo= policrespo + " " + generos.get(i).toString();
		}
		return policrespo;
	}
	
	public String toString()
	{
		if (anoFin >0)
			if (notaMedia>0)
				return nombre + " (" + anoEstreno + " - " + anoFin + ")   " +"Nota:"+ notaMedia+""; 
			else
				return nombre + " (" + anoEstreno + " - " + anoFin + ")";
		else 
			if (notaMedia>0)
				return nombre + " (" + anoEstreno + " - ?)  " +"Nota:"+ notaMedia+""; 
			else
				return nombre + " (" + anoEstreno + " - ?)";
	}
	
	public boolean equals( Serie ser)
	{
		return id==ser.id;
	}

	@Override
	public int compareTo(Serie arg0) {
		if (id==arg0.id)
		{
			return 0;
		}
		else return 1;
	}
	
	public List<Episodio> getEpisodios()
	{
		if (episodios==null)
		{
			EpisodioMapper episodiosMapper = new EpisodioMapper();
			episodios = episodiosMapper.findAllFromSerie(id);
			NotaEpisodioMapper nem = new NotaEpisodioMapper();
			for (int i=0; i<episodios.size(); i++)
			{
				episodios.get(i).setNotaMedia(nem.getNotaMediaDeSerie(id, episodios.get(i).getEpisodioSerie().getCapitulo()));
			}
		}
		return episodios;
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

	public List<ComentarioSerie> getComentarios() {
		ComentarioSerieMapper csm = new ComentarioSerieMapper();
		comentarios = csm.findAllComentsFromSerie(id);
		return comentarios;
	}
	
	
}
