/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI.VentanaPrincipalComponents;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.EventListener;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import series.GUI.VistaInterfaz;
import series.modelo.UserLoged;

@SuppressWarnings("serial")
public class VPPSFoto extends JButton implements VistaInterfaz {

	public VPPSFoto()
	{
		this.setName("JPFoto");
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Blob foto =((UserLoged)o).getImagen();
		if (foto!=null)
		{			
			ImageIcon imageIcon=null;
			try {
				byte[] bytesLeidos = foto.getBytes(1, (int)foto.length());
				imageIcon = new ImageIcon(bytesLeidos);
				imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			setIcon(imageIcon);
		}
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		//addFocusListener((FocusListener)controlador);
		addActionListener((ActionListener)controlador);
		
	}

}
