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
import series.modelo.Serie;


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
public class VentanaNuevoComentarioSerie extends javax.swing.JFrame implements VistaInterfaz{
	private JLabel jLNombreSerie;
	private JButton jBComenta;
	private JTextArea jTAComentario;
	private Serie serie;

	
	public VentanaNuevoComentarioSerie(Serie serie) {
		super("Comentar la serie");
		this.serie = serie;
		initGUI();
		setLocationRelativeTo(null);
	}
	
	private void initGUI() {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLNombreSerie = new JLabel();
				getContentPane().add(jLNombreSerie);
				jLNombreSerie.setText(serie.getNombre());
				jLNombreSerie.setBounds(12, 18, 352, 31);
			}
			{
				jTAComentario = new JTextArea();
				getContentPane().add(jTAComentario);
				jTAComentario.setBounds(12, 70, 352, 141);
				jTAComentario.setName("JTFComentarioAnadirSerie");
			}
			{
				jBComenta = new JButton();
				getContentPane().add(jBComenta);
				jBComenta.setText("Comentar");
				jBComenta.setName("JBComentaLaSerie");
				jBComenta.setBounds(277, 228, 95, 23);
			}
			pack();
			setSize(400, 300);
		
	}
	
	public Serie getSerie()
	{
		return serie;
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
