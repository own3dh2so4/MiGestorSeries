/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI.JOpotiosPanles;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class VentanaNickExistente extends JOptionPane {

	/**
	 * Constructor por defecto.
	 */
	public VentanaNickExistente()
	{
		showMessageDialog(null, "Cambia de nick, ese ya esta ocupado");
		setVisible(true);
	}


}
