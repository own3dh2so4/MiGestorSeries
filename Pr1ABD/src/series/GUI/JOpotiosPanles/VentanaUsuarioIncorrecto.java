/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
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
		showMessageDialog(null, "Usuario o contraseña incorrectos");
		setVisible(true);
	}
}
