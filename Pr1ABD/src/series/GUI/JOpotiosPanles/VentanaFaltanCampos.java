/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Rega�o										*
*								3�B												*
*********************************************************************************/

package series.GUI.JOpotiosPanles;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class VentanaFaltanCampos extends JOptionPane {

	/**
	 * Constructor por defecto.
	 */
	public VentanaFaltanCampos()
	{
		showMessageDialog(null, "Faltan algunos campos por rellenar.");
		setVisible(true);
	}
}