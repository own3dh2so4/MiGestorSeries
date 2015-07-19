/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.modelo;

public class UsuarioSerie {
	
	private String nombreUsuario;
	private int idSerie;
	
	public UsuarioSerie(String nU, int idS)
	{
		nombreUsuario = nU;
		idSerie = idS;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @return the idSerie
	 */
	public int getIdSerie() {
		return idSerie;
	}

	
}
