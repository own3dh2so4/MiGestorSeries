/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.modelo;

import java.sql.Date;

public class ComentarioSerie {

	private int idComentarioSerie;
	private String usuario;
	private int idSerie;
	private String comentario;
	private Date fecha;
	
	
	public ComentarioSerie(int idComentrario,String usuario, int idSerie, String comentario, Date fecha)
	{
		idComentarioSerie= idComentrario;
		this.usuario = usuario;
		this.idSerie = idSerie;
		this.comentario = comentario;
		this.fecha = fecha;
	}
	
	public ComentarioSerie(String usuario, int idSerie, String comentario, Date fecha)
	{
		this.usuario = usuario;
		this.idSerie = idSerie;
		this.comentario = comentario;
		this.fecha = fecha;
	}

	/**
	 * @return the idComentarioSerie
	 */
	public int getIdComentarioSerie() {
		return idComentarioSerie;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @return the idSerie
	 */
	public int getIdSerie() {
		return idSerie;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}	
	
	public String toString()
	{
		return usuario+ " " + fecha.toString() +" " + comentario;
	}
}
