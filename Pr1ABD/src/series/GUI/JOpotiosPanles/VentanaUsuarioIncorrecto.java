/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Rega�o										*
*								3�B												*
*********************************************************************************/

package series.GUI.JOpotiosPanles;

import javax.swing.JOptionPane;

/**
 * Esta clase es la que se utilza para crear la ventana que informa de un login incorrecto. 
 */
@SuppressWarnings("serial")
public class VentanaUsuarioIncorrecto extends JOptionPane {

	/**
	 * Constructor por defecto.
	 */
	public VentanaUsuarioIncorrecto()
	{
		showMessageDialog(null, "Usuario o contrase�a incorrectos");
		setVisible(true);
	}
}
