/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI.VentanasNuevoObjeto;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.EventListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import series.GUI.VistaInterfaz;


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
public class VentanaNuevoPersonaje extends javax.swing.JFrame implements VistaInterfaz{
	private JPanel panelFondo;
	private JLabel jLnombrePersonaje;
	private JTextField jTFNombrePersonaje;
	private JButton jBCancelar;
	private JButton jBAceptar;
	private JTextArea jTFDescripcion;
	private JLabel jLDescripcion;

	
	public VentanaNuevoPersonaje() {
		super("Nuevo personaje");
		initGUI();
		setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				panelFondo = new JPanel();
				getContentPane().add(panelFondo, BorderLayout.CENTER);
				panelFondo.setLayout(null);
				{
					jLnombrePersonaje = new JLabel();
					panelFondo.add(jLnombrePersonaje);
					jLnombrePersonaje.setText("Nombre");
					jLnombrePersonaje.setBounds(17, 26, 94, 27);
				}
				{
					jTFNombrePersonaje = new JTextField();
					panelFondo.add(jTFNombrePersonaje);
					jTFNombrePersonaje.setBounds(129, 12, 230, 41);
					jTFNombrePersonaje.setName("JTFNombreNuevoPersonaje");
				}
				{
					jLDescripcion = new JLabel();
					panelFondo.add(jLDescripcion);
					jLDescripcion.setText("Descripcion");
					jLDescripcion.setBounds(17, 82, 104, 35);
				}
				{
					jTFDescripcion = new JTextArea();
					panelFondo.add(jTFDescripcion);
					jTFDescripcion.setBounds(121, 82, 238, 93);
					jTFDescripcion.setName("JTFDescripcionNuevoPersonaje");
				}
				{
					jBAceptar = new JButton();
					panelFondo.add(jBAceptar);
					jBAceptar.setText("Aceptar");
					jBAceptar.setName("JBAceptarNuevoPerosnaje");
					jBAceptar.setBounds(56, 212, 112, 23);
				}
				{
					jBCancelar = new JButton();
					panelFondo.add(jBCancelar);
					jBCancelar.setText("Cancelar");
					jBCancelar.setName("JBCancelarNuevoPersonaje");
					jBCancelar.setBounds(217, 212, 121, 23);
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
		jTFDescripcion.addFocusListener((FocusListener)controlador);
		jTFNombrePersonaje.addFocusListener((FocusListener)controlador);
		
		jBAceptar.addActionListener((ActionListener)controlador);
		jBCancelar.addActionListener((ActionListener)controlador);
		
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
