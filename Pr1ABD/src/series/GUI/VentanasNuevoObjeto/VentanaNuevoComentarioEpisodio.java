/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI.VentanasNuevoObjeto;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.EventListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import series.GUI.VistaInterfaz;
import series.modelo.Episodio;

@SuppressWarnings("serial")
public class VentanaNuevoComentarioEpisodio extends javax.swing.JFrame implements VistaInterfaz{
	private JLabel jLNombreEpisodio;
	private JButton jBComenta;
	private JTextArea jTAComentario;
	private Episodio episodio;

	
	public VentanaNuevoComentarioEpisodio(Episodio episodio) {
		super("Comenta el episodio");
		this.episodio = episodio;
		initGUI();
		setLocationRelativeTo(null);
	}
	
	private void initGUI() {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLNombreEpisodio = new JLabel();
				getContentPane().add(jLNombreEpisodio);
				jLNombreEpisodio.setText(episodio.getTitulo());
				jLNombreEpisodio.setBounds(12, 18, 352, 31);
			}
			{
				jTAComentario = new JTextArea();
				getContentPane().add(jTAComentario);
				jTAComentario.setBounds(12, 70, 352, 141);
				jTAComentario.setName("JTFComentarioAnadirEpisodio");
			}
			{
				jBComenta = new JButton();
				getContentPane().add(jBComenta);
				jBComenta.setText("Comentar");
				jBComenta.setName("JBComentaElEpisodio");
				jBComenta.setBounds(277, 228, 95, 23);
			}
			pack();
			setSize(400, 300);
		
	}
	
	public Episodio getEpisodio()
	{
		return episodio;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		jBComenta.addActionListener((ActionListener)controlador);
		jTAComentario.addFocusListener((FocusListener)controlador);
		
	}
	
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

}
