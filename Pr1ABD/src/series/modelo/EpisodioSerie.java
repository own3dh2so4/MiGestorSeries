/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.modelo;

public class EpisodioSerie {
	private int capitulo;
	private int idSerie;
	
	public EpisodioSerie(int capitulo, int idSerie )
	{
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
	 * @return the idSerie
	 */
	public int getIdSerie() {
		return idSerie;
	}

	

	

}
