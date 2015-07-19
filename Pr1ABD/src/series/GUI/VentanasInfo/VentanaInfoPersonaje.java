/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI.VentanasInfo;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.EventListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import series.GUI.VistaInterfaz;
import series.modelo.Personaje;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("serial")
public class VentanaInfoPersonaje extends javax.swing.JFrame implements VistaInterfaz {
	private JPanel panelFondo;
	private JTextArea descripcionPersonaje;
	private JButton aceptar;
	private JTextField nombrePersonaje;

	

	
	public VentanaInfoPersonaje(Personaje p, boolean admin) {
		super("Informacion del personaje: " + p.getNombre());
		initGUI(p, admin);
		setLocationRelativeTo(null);
	}
	
	private void initGUI(Personaje p, boolean admin) {
		
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				panelFondo = new JPanel();
				getContentPane().add(panelFondo, BorderLayout.CENTER);
				panelFondo.setLayout(null);
				{
					nombrePersonaje = new JTextField();
					panelFondo.add(nombrePersonaje);
					nombrePersonaje.setText(p.getNombre());
					nombrePersonaje.setName("JTFNombrePersonajeEditar");
					nombrePersonaje.setEditable(admin);
					nombrePersonaje.setBounds(100, 12, 179, 41);
				}
				{
					descripcionPersonaje = new JTextArea();
					panelFondo.add(descripcionPersonaje);
					descripcionPersonaje.setText(p.getDescripcion());
					descripcionPersonaje.setName("JTFDescripcionPersonajeEditar");
					descripcionPersonaje.setEditable(admin);
					descripcionPersonaje.setBounds(12, 74, 354, 129);
				}
				{
					aceptar = new JButton();
					panelFondo.add(aceptar);
					aceptar.setText("Aceptar");
					aceptar.setName("JBAceptarVentanaInfoPerosnaje");
					aceptar.setBounds(271, 215, 88, 31);
				}
			}
			pack();
			setSize(400, 300);
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		nombrePersonaje.addFocusListener((FocusListener)controlador);
		descripcionPersonaje.addFocusListener((FocusListener)controlador);
		
		aceptar.addActionListener((ActionListener)controlador);
		
	}

	
	public void empieza()
	{
		EventQueue.invokeLater(new Runnable(){
	    	public void run() {
	    		setVisible(true);
	    	}
	    });	
	}
	
	public void cerrarVentana()
	{
		dispose();
	}
}
