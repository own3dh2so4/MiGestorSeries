/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Rega�o										*
*								3�B												*
*********************************************************************************/

package series.GUI;

import java.util.EventListener;
import java.util.Observer;

/**
 * Esta interfaz se utiliza para que todas las clases que la implemente tengan el m�todo
 * fjarControlador.
 */
public interface VistaInterfaz extends Observer{

	/**
	 * Funci�n que fija el controlador para la vista.
	 * @param controlador, el controlador que se fija.
	 */
	 public void fijarControlador(EventListener controlador);
}