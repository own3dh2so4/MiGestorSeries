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
public class VentanaNoSeries extends JOptionPane {

	/**
	 * Constructor por defecto.
	 */
	public VentanaNoSeries()
	{
		showMessageDialog(null, "No hay ninguna serie con ese nombre");
		setVisible(true);
	}
}
