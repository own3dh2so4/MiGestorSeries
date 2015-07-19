/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.modelo;

public class EpisodioVisto {

	private String usuario;
	private int capitulo;
	private int idSerie;
	
	public EpisodioVisto(String usuario, int capitulo, int idSerie) {
		this.usuario=usuario;
		this.capitulo=capitulo;
		this.idSerie=idSerie;
	}

	/**
	 * @return the capitulo
	 */
	public int getCapitulo() {
		return capitulo;
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

}
