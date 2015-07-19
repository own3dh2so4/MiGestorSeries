/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.modelo;

public class NotaSerie {

	private UsuarioSerie usuarioYSerie;
	private int nota;
	
	public NotaSerie(String nombreUser, int idSerie, int nota)
	{
		usuarioYSerie= new UsuarioSerie(nombreUser, idSerie);
		this.nota=nota;
	}

	/**
	 * @return the nombreUser
	 */
	public String getNombreUser() {
		return usuarioYSerie.getNombreUsuario();
	}

	/**
	 * @return the idSerie
	 */
	public int getIdSerie() {
		return usuarioYSerie.getIdSerie();
	}

	/**
	 * @return the nota
	 */
	public int getNota() {
		return nota;
	}

		
}
