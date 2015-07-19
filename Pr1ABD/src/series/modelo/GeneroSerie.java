/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Rega�o										*
*								3�B												*
*********************************************************************************/

package series.modelo;

public class GeneroSerie {
	
	private int idSerie;
	private String generoSerie;
	
	public GeneroSerie(int idS, String gS)
	{
		idSerie = idS;
		generoSerie = gS;
	}

	public String getGeneroSerie() {
		return generoSerie;
	}

	public int getIdSerie() {
		return idSerie;
	}

}
