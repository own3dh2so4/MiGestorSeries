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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.EventListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class VentanaNuevoActor extends javax.swing.JFrame implements VistaInterfaz {
	private JPanel jPFondo;
	private JTextField jTFNombre;
	private JButton jBCancelarNuevoActor;
	private JButton jBAceptarNuevoActor;
	private JButton jBBuscarFoto;
	private JLabel jLFoto;
	private JTextField jTFAno;
	private JTextField jTFMes;
	private JTextField jTFDia;
	private JLabel jLFecha;
	private JLabel jLNombre;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public void empieza() {
		EventQueue.invokeLater(new Runnable(){
	    	public void run() {
	    		setVisible(true);
	    	}
	    });	
	}
	
	public VentanaNuevoActor() {
		super("Actor");
		initGUI();
		setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPFondo = new JPanel();
				getContentPane().add(jPFondo, BorderLayout.CENTER);
				jPFondo.setLayout(null);
				{
					jLNombre = new JLabel();
					jPFondo.add(jLNombre);
					jLNombre.setText("Nombre");
					jLNombre.setBounds(12, 27, 80, 26);
				}
				{
					jTFNombre = new JTextField();
					jPFondo.add(jTFNombre);
					jTFNombre.setName("JTFNombreActorNuevo");
					jTFNombre.setBounds(92, 20, 259, 32);
				}
				{
					jLFecha = new JLabel();
					jPFondo.add(jLFecha);
					jLFecha.setText("Fecha");
					jLFecha.setBounds(12, 65, 80, 30);
				}
				{
					jTFDia = new JTextField();
					jPFondo.add(jTFDia);
					jTFDia.setName("JTFDiaActorNuevo");
					jTFDia.setBounds(92, 69, 47, 23);
					jTFDia.addKeyListener(new KeyAdapter()
			        { 
				     	   public void keyTyped(KeyEvent e)
				     	   {
				     	      char caracter = e.getKeyChar();

				     	      // Verificar si la tecla pulsada no es un digito
				     	      if(((caracter < '0') ||
				     	         (caracter > '9')) &&
				     	         (caracter != '\b' /*corresponde a BACK_SPACE*/))
				     	      {
				     	         e.consume();  // ignorar el evento de teclado
				     	      }
				     	   }
				     	});
				}
				{
					jTFMes = new JTextField();
					jPFondo.add(jTFMes);
					jTFMes.setName("JTFMesActorNuevo");
					jTFMes.setBounds(155, 69, 52, 23);
					jTFMes.addKeyListener(new KeyAdapter()
			        { 
				     	   public void keyTyped(KeyEvent e)
				     	   {
				     	      char caracter = e.getKeyChar();

				     	      // Verificar si la tecla pulsada no es un digito
				     	      if(((caracter < '0') ||
				     	         (caracter > '9')) &&
				     	         (caracter != '\b' /*corresponde a BACK_SPACE*/))
				     	      {
				     	         e.consume();  // ignorar el evento de teclado
				     	      }
				     	   }
				     	});
				}
				{
					jTFAno = new JTextField();
					jPFondo.add(jTFAno);
					jTFAno.setName("JTFAnoActorNuevo");
					jTFAno.setBounds(224, 69, 51, 23);
					jTFAno.addKeyListener(new KeyAdapter()
			        { 
				     	   public void keyTyped(KeyEvent e)
				     	   {
				     	      char caracter = e.getKeyChar();

				     	      // Verificar si la tecla pulsada no es un digito
				     	      if(((caracter < '0') ||
				     	         (caracter > '9')) &&
				     	         (caracter != '\b' /*corresponde a BACK_SPACE*/))
				     	      {
				     	         e.consume();  // ignorar el evento de teclado
				     	      }
				     	   }
				     	});
				}
				{
					jLFoto = new JLabel();
					jPFondo.add(jLFoto);
					jLFoto.setText("Foto");
					jLFoto.setBounds(12, 107, 80, 27);
				}
				{
					jBBuscarFoto = new JButton();
					jPFondo.add(jBBuscarFoto);
					jBBuscarFoto.setName("JBBuscarFotoActorNuevo");
					jBBuscarFoto.setText("Examinar foto");
					jBBuscarFoto.setBounds(139, 109, 103, 23);
				}
				{
					jBAceptarNuevoActor = new JButton();
					jPFondo.add(jBAceptarNuevoActor);
					jBAceptarNuevoActor.setName("JBAceptarActorNuevo");
					jBAceptarNuevoActor.setText("Aceptar");
					jBAceptarNuevoActor.setBounds(92, 187, 63, 23);
				}
				{
					jBCancelarNuevoActor = new JButton();
					jPFondo.add(jBCancelarNuevoActor);
					jBCancelarNuevoActor.setName("JBCancelarActorNuevo");
					jBCancelarNuevoActor.setText("Cancelar");
					jBCancelarNuevoActor.setBounds(216, 187, 69, 23);
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		jBAceptarNuevoActor.addActionListener((ActionListener)controlador);
		jBBuscarFoto.addActionListener((ActionListener)controlador);
		jBCancelarNuevoActor.addActionListener((ActionListener)controlador);
		
		jTFAno.addFocusListener((FocusListener)controlador);
		jTFDia.addFocusListener((FocusListener)controlador);
		jTFMes.addFocusListener((FocusListener)controlador);
		jTFNombre.addFocusListener((FocusListener)controlador);
		
	}
	
	public void cerrarVentana()
	{
		dispose();
	}

}
