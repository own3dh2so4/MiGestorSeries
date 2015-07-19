/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.modelo;

import java.sql.Date;

public class ComentarioEpisodio {

	private int idComentarioEpisodio;
	private String usuario;
	private int idSerie;
	private int capitulo;
	private String comentario;
	private Date fecha;
	
	public ComentarioEpisodio(int idComentarioEpisodio, String usuario, int idSerie, int capitulo,  String comentario,Date fecha)
	{
		this.idComentarioEpisodio=idComentarioEpisodio;
		this.usuario=usuario;
		this.idSerie=idSerie;
		this.capitulo = capitulo;
		this.comentario = comentario;
		this.fecha = fecha;
	}
	
	public ComentarioEpisodio( String usuario, int idSerie, int capitulo,  String comentario,Date fecha)
	{
		this.usuario=usuario;
		this.idSerie=idSerie;
		this.capitulo = capitulo;
		this.comentario = comentario;
		this.fecha = fecha;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the idComentarioEpisodio
	 */
	public int getIdComentarioEpisodio() {
		return idComentarioEpisodio;
	}

	/**
	 * @param idComentarioEpisodio the idComentarioEpisodio to set
	 */
	public void setIdComentarioEpisodio(int idComentarioEpisodio) {
		this.idComentarioEpisodio = idComentarioEpisodio;
	}

	/**
	 * @return the idSerie
	 */
	public int getIdSerie() {
		return idSerie;
	}

	/**
	 * @param idSerie the idSerie to set
	 */
	public void setIdSerie(int idSerie) {
		this.idSerie = idSerie;
	}

	/**
	 * @return the capitulo
	 */
	public int getCapitulo() {
		return capitulo;
	}

	/**
	 * @param capitulo the capitulo to set
	 */
	public void setCapitulo(int capitulo) {
		this.capitulo = capitulo;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
