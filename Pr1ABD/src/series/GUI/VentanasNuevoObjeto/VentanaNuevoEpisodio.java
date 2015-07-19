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
public class VentanaNuevoEpisodio extends javax.swing.JFrame implements VistaInterfaz{
	private JPanel jPFondo;
	private JLabel jLTitulo;
	private JButton jBAceptar;
	private JTextField jTFIdSerie;
	private JLabel jLIdSerie;
	private JTextField jTFAno;
	private JTextField jTFMes;
	private JTextField jTFDia;
	private JLabel jLFecha;
	private JTextArea jTASinopsis;
	private JLabel jLSinopsis;
	private JTextField jTFTemporada;
	private JLabel jLTemporada;
	private JTextField jTFCapitulo;
	private JLabel jLCapitulo;
	private JTextField jTFTitulo;

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
	
	public void cerrarVentana()
	{
		dispose();
	}
	
	public VentanaNuevoEpisodio() {
		super("Nuevo Episodio");
		initGUI();
		setLocationRelativeTo(null);
	}
	
	private void initGUI() {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPFondo = new JPanel();
				getContentPane().add(jPFondo, BorderLayout.CENTER);
				jPFondo.setLayout(null);
				{
					jLTitulo = new JLabel();
					jPFondo.add(jLTitulo);
					jLTitulo.setText("Titulo");
					jLTitulo.setBounds(12, 12, 143, 28);
				}
				{
					jTFTitulo = new JTextField();
					jPFondo.add(jTFTitulo);
					jTFTitulo.setBounds(160, 13, 298, 27);
					jTFTitulo.setName("JTFTItuloNuevoEpisodio");
				}
				{
					jLCapitulo = new JLabel();
					jPFondo.add(jLCapitulo);
					jLCapitulo.setText("Capitulo");
					jLCapitulo.setBounds(12, 59, 148, 24);
				}
				{
					jTFCapitulo = new JTextField();
					jPFondo.add(jTFCapitulo);
					jTFCapitulo.setBounds(160, 58, 298, 25);
					jTFCapitulo.setName("JTFCapituloNuevoEpisodio");
				}
				{
					jLTemporada = new JLabel();
					jPFondo.add(jLTemporada);
					jLTemporada.setText("Temporada");
					jLTemporada.setBounds(12, 106, 143, 22);
				}
				{
					jTFTemporada = new JTextField();
					jPFondo.add(jTFTemporada);
					jTFTemporada.setBounds(160, 104, 298, 25);
					jTFTemporada.setName("JTFTemporadaNuevoEpisodio");
				}
				{
					jLSinopsis = new JLabel();
					jPFondo.add(jLSinopsis);
					jLSinopsis.setText("Sinopsis");
					jLSinopsis.setBounds(12, 149, 148, 22);
				}
				{
					jTASinopsis = new JTextArea();
					jPFondo.add(jTASinopsis);
					jTASinopsis.setBounds(160, 150, 298, 73);
					jTASinopsis.setName("JTASinopsisCNuevoCapitulo");
				}
				{
					jLFecha = new JLabel();
					jPFondo.add(jLFecha);
					jLFecha.setText("Fecha");
					jLFecha.setBounds(12, 237, 148, 16);
				}
				{
					jTFDia = new JTextField();
					jPFondo.add(jTFDia);
					jTFDia.setBounds(160, 234, 43, 23);
					jTFDia.setName("JTFDiaNuevoEpisodio");
				}
				{
					jTFMes = new JTextField();
					jPFondo.add(jTFMes);
					jTFMes.setBounds(220, 234, 40, 23);
					jTFMes.setName("JTFMesNuevoEpisodio");
				}
				{
					jTFAno = new JTextField();
					jPFondo.add(jTFAno);
					jTFAno.setBounds(277, 234, 40, 23);
					jTFAno.setName("JTFAnoNuevoEpisodio");
				}
				{
					jLIdSerie = new JLabel();
					jPFondo.add(jLIdSerie);
					jLIdSerie.setText("ID Serie");
					jLIdSerie.setBounds(12, 287, 148, 19);
				}
				{
					jTFIdSerie = new JTextField();
					jPFondo.add(jTFIdSerie);
					jTFIdSerie.setBounds(160, 285, 100, 23);
					jTFIdSerie.setName("JTFIdSerieNuevoEpisodio");
				}
				{
					jBAceptar = new JButton();
					jPFondo.add(jBAceptar);
					jBAceptar.setText("Aceptar");
					jBAceptar.setBounds(348, 276, 94, 30);
					jBAceptar.setName("JBAceptarNuevoEpisodio");
				}
			}
			pack();
			this.setSize(510, 368);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		jTASinopsis.addFocusListener((FocusListener)controlador);
		jTFAno.addFocusListener((FocusListener)controlador);
		jTFCapitulo.addFocusListener((FocusListener)controlador);
		jTFDia.addFocusListener((FocusListener)controlador);
		jTFIdSerie.addFocusListener((FocusListener)controlador);
		jTFMes.addFocusListener((FocusListener)controlador);
		jTFTemporada.addFocusListener((FocusListener)controlador);
		jTFTitulo.addFocusListener((FocusListener)controlador);
		
		jBAceptar.addActionListener((ActionListener)controlador);
	}

}
