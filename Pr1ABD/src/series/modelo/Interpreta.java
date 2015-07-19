/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Rega�o										*
*								3�B												*
*********************************************************************************/

package series.modelo;

public class Interpreta {

	private int idActor;
	private int idPersonaje;
	private int idSerie;
	private int capitulo;
	
	public Interpreta(int idActor, int idPersonaje, int idSerie, int capitulo)
	{
		this.idActor = idActor;
		this.idPersonaje = idPersonaje;
		this.idSerie = idSerie;
		this.capitulo = capitulo;
	}

	/**
	 * @return the idActor
	 */
	public int getIdActor() {
		return idActor;
	}

	/**
	 * @return the idPersonaje
	 */
	public int getIdPersonaje() {
		return idPersonaje;
	}

	/**
	 * @return the idSerie
	 */
	public int getIdSerie() {
		return idSerie;
	}

	/**
	 * @return the capitulo
	 */
	public int getCapitulo() {
		return capitulo;
	}

}
