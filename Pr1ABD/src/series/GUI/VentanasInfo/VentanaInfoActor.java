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
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.EventListener;
import java.util.GregorianCalendar;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import series.GUI.VistaInterfaz;
import series.modelo.Actor;


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
public class VentanaInfoActor extends javax.swing.JFrame implements VistaInterfaz{
	private JPanel jPFondo;
	private JButton jLFoto;
	private JPanel jLFecha;
	private JTextField dia;
	private JTextField mes;
	private JTextField ano;
	private JTextField jLNombre;
	private JButton jBAcepar;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public VentanaInfoActor(Actor actor, boolean admin) {
		super("Informacion del Actor: "+ actor.getNombre());
		initGUI(actor, admin);
		setLocationRelativeTo(null);
	}
	
	private void initGUI(Actor actor, boolean admin) {
		
			GregorianCalendar fechaActor = new GregorianCalendar();
			fechaActor.setTime(actor.getNacio());
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPFondo = new JPanel();
				getContentPane().add(jPFondo, BorderLayout.CENTER);
				jPFondo.setLayout(null);
				{
					Blob foto = actor.getFoto();
					jLFoto = new JButton();
					jPFondo.add(jLFoto);
					if (foto!=null)
					{
						ImageIcon imageIcon=null;
						try {
							byte[] bytesLeidos = foto.getBytes(1, (int)foto.length());
							imageIcon = new ImageIcon(bytesLeidos);
							imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(145, 143, Image.SCALE_DEFAULT));
						} catch (SQLException e) {
							e.printStackTrace();
						}
						jLFoto.setIcon(imageIcon);
					}
					jLFoto.setBounds(21, 21, 145, 143);
					jLFoto.setName("JBFotoVentanaInfoActor");
				}
				{
					jLNombre = new JTextField();
					jPFondo.add(jLNombre);
					jLNombre.setText(actor.getNombre());
					jLNombre.setBounds(193, 33, 108, 32);
					jLNombre.setName("JTFNombreVentanInfoActor");
					jLNombre.setEditable(admin);
				}
				{
					jLFecha = new JPanel();
					jPFondo.add(jLFecha);
					jLFecha.setBounds(193, 110, 126, 47);
					jLFecha.setName("JTFFechaVentanaInfoActor");
					jLFecha.setLayout(new GridLayout(1,3));
					{
						dia = new JTextField();
						jLFecha.add(dia);
						dia.setText(fechaActor.get(Calendar.DATE)+"");
						dia.setName("JTFDiaVentanaInfoActor");
						dia.setEditable(admin);
						
					}
					{
						mes = new JTextField();
						jLFecha.add(mes);
						mes.setText(fechaActor.get(Calendar.MONTH)+"");
						mes.setName("JTFMesVentanaInfoActor");
						mes.setEditable(admin);						
					}
					{
						ano = new JTextField();
						jLFecha.add(ano);
						ano.setText(fechaActor.get(Calendar.YEAR)+"");
						ano.setName("JTFAnoVentanaInfoActor");
						ano.setEditable(admin);
						
					}
				}
				{
					jBAcepar = new JButton("Aceptar");
					jPFondo.add(jBAcepar);
					jBAcepar.setBounds(193, 180, 106, 47);
					jBAcepar.setName("JBAceptarVentanaInfoActor");
				}
			}
			pack();
			setSize(400, 300);
		
	}
	
	/**
	 * Metodo para que la ventana se empiece ha hacerse visible en un nuevo hilo.
	 */
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

	@Override
	public void update(Observable arg0, Object arg1) {
		
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		jLNombre.addFocusListener((FocusListener)controlador);
		dia.addFocusListener((FocusListener)controlador);
		mes.addFocusListener((FocusListener)controlador);
		ano.addFocusListener((FocusListener)controlador);
		
		jLFoto.addActionListener((ActionListener)controlador);
		jBAcepar.addActionListener((ActionListener)controlador);
		
	}
	
	

}
