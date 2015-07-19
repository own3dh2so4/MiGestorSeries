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
public class VentanaNuevaSerie extends javax.swing.JFrame implements VistaInterfaz {
	private JPanel jPanel1;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton jButton1;
	private JButton jButton2;
	private JTextField jTextField5;
	private JTextField jTextField4;
	private JTextArea jTextField3;
	private JTextField jTextField2;
	private JLabel jLabel2;
	private JTextField jTextField1;
	private JLabel jLabel1;

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
	
	public VentanaNuevaSerie() {
		super("Serie");
		initGUI();
		setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				jPanel1.setLayout(null);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Nombre");
					jLabel1.setBounds(0, 0, 131, 41);
				}
				{
					jTextField1 = new JTextField();
					jPanel1.add(jTextField1);
					jTextField1.setName("JTFNombreSerie");
					jTextField1.setBounds(72, 6, 307, 35);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("Titular");
					jLabel2.setBounds(5, 47, 67, 34);
				}
				{
					jTextField2 = new JTextField();
					jPanel1.add(jTextField2);
					jTextField2.setName("JTFTitular");
					jTextField2.setBounds(72, 49, 307, 32);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jLabel3.setText("Sinopsis");
					jLabel3.setBounds(0, 93, 72, 34);
				}
				{
					jTextField3 = new JTextArea();
					jPanel1.add(jTextField3);
					jTextField3.setName("JTFSinopsis");
					jTextField3.setBounds(72, 93, 307, 34);
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4);
					jLabel4.setText("Año Estreno");
					jLabel4.setBounds(0, 133, 72, 31);
				}
				{
					jTextField4 = new JTextField();
					jPanel1.add(jTextField4);
					jTextField4.setName("JTFAnoEstreno");
					jTextField4.addKeyListener(new KeyAdapter()
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
					jTextField4.setBounds(72, 137, 146, 32);
				}
				{
					jLabel5 = new JLabel();
					jPanel1.add(jLabel5);
					jLabel5.setText("Año fin");
					jLabel5.setBounds(0, 176, 72, 33);
				}
				{
					jTextField5 = new JTextField();
					jPanel1.add(jTextField5);
					jTextField5.setName("JTFAnoFin");
					jTextField5.addKeyListener(new KeyAdapter()
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
					jTextField5.setBounds(72, 181, 146, 34);
				}
				{
					jButton1 = new JButton();
					jPanel1.add(jButton1);
					jButton1.setText("Añadir");
					jButton1.setName("JBAnadir");
					jButton1.setBounds(240, 146, 125, 23);
				}
				{
					jButton2 = new JButton();
					jPanel1.add(jButton2);
					jButton2.setText("Cancelar");
					jButton2.setName("JBCancelarNuevaSerie");
					jButton2.setBounds(240, 192, 125, 23);
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
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		jButton1.addActionListener((ActionListener)controlador);
		jButton2.addActionListener((ActionListener)controlador);
		
		jTextField1.addFocusListener((FocusListener)controlador);
		jTextField2.addFocusListener((FocusListener)controlador);
		jTextField3.addFocusListener((FocusListener)controlador);
		jTextField4.addFocusListener((FocusListener)controlador);
		jTextField5.addFocusListener((FocusListener)controlador);
	}
	
	public void cerrarVentana()
	{
		dispose();
	}

}
