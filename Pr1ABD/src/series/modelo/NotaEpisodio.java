/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.modelo;

public class NotaEpisodio {

	private EpisodioVisto episodio;
	private int nota;
	
	public NotaEpisodio(String user, int idSerie, int capitulo, int nota)
	{
		episodio = new EpisodioVisto(user, capitulo, idSerie);
		this.nota=nota;
	}
	
	public String getUsuario()
	{
		return episodio.getUsuario();
	}
	
	public int getIdSerie()
	{
		return episodio.getIdSerie();
	}
	
	public int getCapitulo()
	{
		return episodio.getCapitulo();
	}
	
	public int getNota()
	{
		return nota;
	}
}
