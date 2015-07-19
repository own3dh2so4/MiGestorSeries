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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.EventListener;
import java.util.GregorianCalendar;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import series.GUI.VistaInterfaz;
import series.modelo.Episodio;


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
public class VentanaInfoEpisodio extends javax.swing.JFrame implements VistaInterfaz {
	private JPanel jPanelFondo;
	private JLabel jLTitulo;
	private JButton jBNoVisto;
	private JButton jBAceptar;
	private JButton jBVisto;
	private JTextField jTFSerie;
	private JLabel jLSerie;
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
	private Episodio episodio;

	
	
	public VentanaInfoEpisodio(Episodio episodio, boolean isAdmin) {
		super("Informacion del episodio: " + episodio.getTitulo());
		this.episodio=episodio;
		initGUI(isAdmin);
		setLocationRelativeTo(null);
	}
	
	private void initGUI( boolean isAdmin) {
		GregorianCalendar fechaEpisodio = new GregorianCalendar();
		fechaEpisodio.setTime(episodio.getFecha());
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanelFondo = new JPanel();
				getContentPane().add(jPanelFondo, BorderLayout.CENTER);
				jPanelFondo.setLayout(null);
				{
					jLTitulo = new JLabel();
					jPanelFondo.add(jLTitulo);
					jLTitulo.setText("Titulo");
					jLTitulo.setBounds(12, 19, 97, 19);
				}
				{
					jTFTitulo = new JTextField();
					jPanelFondo.add(jTFTitulo);
					jTFTitulo.setText(episodio.getTitulo());
					jTFTitulo.setBounds(109, 17, 249, 23);
					jTFTitulo.setEditable(isAdmin);
					jTFTitulo.setName("JTFTituloEpisodio");
				}
				{
					jLCapitulo = new JLabel();
					jPanelFondo.add(jLCapitulo);
					jLCapitulo.setText("Capitulo");
					jLCapitulo.setBounds(12, 55, 97, 16);
				}
				{
					jTFCapitulo = new JTextField();
					jPanelFondo.add(jTFCapitulo);
					jTFCapitulo.setBounds(109, 52, 249, 23);
					jTFCapitulo.setEditable(isAdmin);
					jTFCapitulo.setText(episodio.getEpisodioSerie().getCapitulo()+"");
					jTFCapitulo.setName("JTFCapituloEpisodio");
					jTFCapitulo.addKeyListener(new KeyAdapter()
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
					jLTemporada = new JLabel();
					jPanelFondo.add(jLTemporada);
					jLTemporada.setText("Temporada");
					jLTemporada.setBounds(12, 87, 97, 16);
				}
				{
					jTFTemporada = new JTextField();
					jPanelFondo.add(jTFTemporada);
					jTFTemporada.setBounds(109, 84, 249, 23);
					jTFTemporada.setEditable(isAdmin);
					jTFTemporada.setText(episodio.getTemporada()+"");
					jTFTemporada.setName("JTFTemporadaEpisodio");
					jTFTemporada.addKeyListener(new KeyAdapter()
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
					jLSinopsis = new JLabel();
					jPanelFondo.add(jLSinopsis);
					jLSinopsis.setText("Sinopsis");
					jLSinopsis.setBounds(12, 115, 97, 24);
				}
				{
					jTASinopsis = new JTextArea();
					jPanelFondo.add(jTASinopsis);
					jTASinopsis.setBounds(109, 117, 249, 54);
					jTASinopsis.setEditable(isAdmin);
					jTASinopsis.setText(episodio.getSinopsis());
					jTASinopsis.setName("JTASinopsisEpisodio");
				}
				{
					jLFecha = new JLabel();
					jPanelFondo.add(jLFecha);
					jLFecha.setText("Fecha");
					jLFecha.setBounds(12, 171, 97, 28);
				}
				{
					jTFDia = new JTextField();
					jPanelFondo.add(jTFDia);
					jTFDia.setBounds(109, 177, 38, 23);
					jTFDia.setEditable(isAdmin);
					jTFDia.setText(fechaEpisodio.get(Calendar.DATE)+"");
					jTFDia.setName("JTFDiaEpisodio");
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
					jPanelFondo.add(jTFMes);
					jTFMes.setBounds(159, 177, 37, 23);
					jTFMes.setEditable(isAdmin);
					jTFMes.setText(fechaEpisodio.get(Calendar.MONTH)+"");
					jTFMes.setName("JTFMesEpisodio");
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
					jPanelFondo.add(jTFAno);
					jTFAno.setBounds(208, 177, 50, 23);
					jTFAno.setEditable(isAdmin);
					jTFAno.setText(fechaEpisodio.get(Calendar.YEAR)+"");
					jTFAno.setName("JTFAnoEpisodio");
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
					jLSerie = new JLabel();
					jPanelFondo.add(jLSerie);
					jLSerie.setText("Serie");
					jLSerie.setBounds(12, 211, 97, 29);
				}
				{
					jTFSerie = new JTextField();
					jPanelFondo.add(jTFSerie);
					jTFSerie.setBounds(109, 214, 149, 23);
					jTFSerie.setEditable(isAdmin);
					jTFSerie.setText(episodio.getEpisodioSerie().getIdSerie()+"");
					jTFSerie.setName("JTFIdSerieEpisodio");
					jTFSerie.addKeyListener(new KeyAdapter()
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
					jBAceptar = new JButton();
					jPanelFondo.add(jBAceptar);
					jBAceptar.setText("Aceptar");
					jBAceptar.setBounds(270, 177, 103, 23);
					jBAceptar.setName("JButonAceptarInfoEpisodio");
				}
				{
					jBVisto = new JButton();
					jPanelFondo.add(jBVisto);
					jBVisto.setText("Visto");
					jBVisto.setBounds(270, 205, 103, 21);
					jBVisto.setName("JBMarcarComoVisto");
				}
				{
					jBNoVisto = new JButton();
					jPanelFondo.add(jBNoVisto);
					jBNoVisto.setText("No visto");
					jBNoVisto.setBounds(270, 231, 103, 23);
					jBNoVisto.setName("JBMarcarComoNoVisto");
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
		jTASinopsis.addFocusListener((FocusListener)controlador);
		jTFAno.addFocusListener((FocusListener)controlador);
		jTFCapitulo.addFocusListener((FocusListener)controlador);
		jTFDia.addFocusListener((FocusListener)controlador);
		jTFMes.addFocusListener((FocusListener)controlador);
		jTFSerie.addFocusListener((FocusListener)controlador);
		jTFTemporada.addFocusListener((FocusListener)controlador);
		jTFTitulo.addFocusListener((FocusListener)controlador);
		
		jBAceptar.addActionListener((ActionListener)controlador);
		jBVisto.addActionListener((ActionListener)controlador);
		jBNoVisto.addActionListener((ActionListener)controlador);
		
	}
	
	public void cerrarVentana()
	{
		dispose();
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

	public Episodio getEpisodio() {
		return episodio;
	}

}
