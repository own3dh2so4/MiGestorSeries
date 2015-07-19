/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI.VentanasInfo;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.EventListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import series.GUI.VistaInterfaz;
import series.modelo.Serie;

@SuppressWarnings("serial")
public class VentanaInfoSerie extends JFrame implements VistaInterfaz{

	private Container panelPrincipal;
	private JPanel panel;
	private JPanel panelBotones;
	private JTextField anoInicio;
	private JTextField anoFin;
	private JTextField tituloSerie;
	private JTextField titularSerie;
	private JLabel generoSerie;
	private JLabel sinopsis;
	private JTextArea sinopsisSerie;
	private JButton seguirSerie;
	private JButton cerrar;
	private JPanel cabecera;
	private JButton jBEpisodios;
	
	public VentanaInfoSerie(Serie serie, boolean admin)
	{
		super("Informacion de la serie: "+serie.getNombre());
		inicializaInfoSerie(admin);
		inicializaPanel(serie,admin);
	}
	
	private void inicializaPanel(Serie serie, boolean admin) {
		tituloSerie.setText(serie.getNombre());
		if (!admin)
			anoFin.setText("?");
		else
			anoFin.setText(serie.getAnoFin()+"");
		anoInicio.setText(serie.getAnoEstreno()+"");
		titularSerie.setText(serie.getTitular());
		generoSerie.setText("Genero: " + serie.generosToString());
		sinopsis.setText("Sinopsis");
		sinopsisSerie.setText(serie.getSinopsis());
	}

	private void inicializaInfoSerie(boolean admin) {
		panel = new JPanel();
		cabecera = new JPanel();
		panelBotones = new JPanel();
		tituloSerie = new JTextField();
		tituloSerie.setEditable(admin);
		titularSerie = new JTextField();
		titularSerie.setEditable(admin);
		generoSerie= new JLabel();
		sinopsis = new JLabel();
		sinopsisSerie = new JTextArea();
		sinopsisSerie.setEditable(admin);
		anoFin = new JTextField();
		anoFin.setEditable(admin);
		anoInicio = new JTextField();
		anoInicio.setEditable(admin);
		seguirSerie = new JButton("Seguir/Dejar Serie");
		if (admin)
			cerrar = new JButton("Aceptar");
		else
			cerrar = new JButton("Cerrar");
		panelPrincipal = getContentPane();
		jBEpisodios=new JButton("Ver Episodios");
		
		titularSerie.setName("JTFTitularSerieEditado");
		tituloSerie.setName("JTFTituloSerieEditado");
		sinopsisSerie.setName("JTFSinopsisSerieEditado");
		anoFin.setName("JTFAnoFinSerieEditado");
		anoInicio.setName("JTFAnoInicioSerieEditado");
		seguirSerie.setName("JBSeguirSerie");
		cerrar.setName("JBCerrar");
		jBEpisodios.setName("JBEpisodiosVentanaInfoSeries");
		
		anoFin.addKeyListener(new KeyAdapter()
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
		anoInicio.addKeyListener(new KeyAdapter()
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
		
		cabecera.setLayout(new GridLayout(1,3));
		cabecera.add(tituloSerie);
		cabecera.add(anoInicio);
		cabecera.add(anoFin);
		
		
		LayoutManager lyout = new GridLayout(1,3);
		panelBotones.setLayout(lyout);
		
		panelBotones.add(seguirSerie);
		panelBotones.add(jBEpisodios);
		panelBotones.add(cerrar);
		
		LayoutManager layout = new GridLayout(6, 1);
		panel.setLayout(layout);
		
		panel.add(cabecera);
		panel.add(titularSerie);
		panel.add(generoSerie);
		panel.add(sinopsis);
		panel.add(sinopsisSerie);
		panel.add(panelBotones);
		
		panelPrincipal.add(panel);
		setLocationRelativeTo(null);
		pack();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
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

	@Override
	public void fijarControlador(EventListener controlador) {
		seguirSerie.addActionListener((ActionListener)controlador);
		cerrar.addActionListener((ActionListener)controlador);
		jBEpisodios.addActionListener((ActionListener)controlador);
		
		titularSerie.addFocusListener((FocusListener)controlador);
		tituloSerie.addFocusListener((FocusListener)controlador);
		sinopsisSerie.addFocusListener((FocusListener)controlador);
		
	}
	
	public void cerrarVentana()
	{
		dispose();
	}

}
