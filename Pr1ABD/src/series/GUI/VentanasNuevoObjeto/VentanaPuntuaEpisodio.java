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
import java.util.EventListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeListener;

import series.GUI.VistaInterfaz;
import series.modelo.Episodio;

@SuppressWarnings("serial")
public class VentanaPuntuaEpisodio extends javax.swing.JFrame implements VistaInterfaz{

	private JPanel jPFondo;
	private JLabel jLNombreEpisodio;
	private JPanel jPInferior;
	private JSlider jSNota;
	private JLabel jLPuntua;
	private JPanel jPCentral;
	private JButton jBPuntuar;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public VentanaPuntuaEpisodio(Episodio episodioAPuntuar) {
		super("Puntua el episodio: " + episodioAPuntuar.getTitulo());
		initGUI(episodioAPuntuar);
		setLocationRelativeTo(null);
	}
	
	private void initGUI(Episodio episodioAPuntuar) {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPFondo = new JPanel();
				BorderLayout jPFondoLayout = new BorderLayout();
				jPFondo.setLayout(jPFondoLayout);
				getContentPane().add(jPFondo, BorderLayout.CENTER);
				{
					jLNombreEpisodio = new JLabel();
					jPFondo.add(jLNombreEpisodio, BorderLayout.NORTH);
					jLNombreEpisodio.setText(episodioAPuntuar.getTitulo());
					jLNombreEpisodio.setPreferredSize(new java.awt.Dimension(386, 56));
				}
				{
					jPInferior = new JPanel();
					jPFondo.add(jPInferior, BorderLayout.SOUTH);
					jPInferior.setPreferredSize(new java.awt.Dimension(386, 48));
					jPInferior.setLayout(null);
					{
						jBPuntuar = new JButton();
						jPInferior.add(jBPuntuar);
						jBPuntuar.setText("Puntuar");
						jBPuntuar.setBounds(131, 6, 124, 35);
						jBPuntuar.setName("JBPuntuaElEpisodio");
					}
				}
				{
					jPCentral = new JPanel();
					BorderLayout jPCentralLayout = new BorderLayout();
					jPCentral.setLayout(jPCentralLayout);
					jPFondo.add(jPCentral, BorderLayout.CENTER);
					{
						jLPuntua = new JLabel();
						jPCentral.add(jLPuntua, BorderLayout.NORTH);
						jLPuntua.setText("Puntua el episodio");
						jLPuntua.setPreferredSize(new java.awt.Dimension(386, 36));
					}
					{
						jSNota = new JSlider();
						jPCentral.add(jSNota, BorderLayout.CENTER);
						jSNota.setMinorTickSpacing(0);
						jSNota.setMajorTickSpacing(1);
						jSNota.setPaintLabels(true);
						jSNota.setPaintTicks(true);
						jSNota.setMaximum(10);
						jSNota.setValue(episodioAPuntuar.getNotaMedia());
						jSNota.setName("JSNotaParaElEpisodio");
					}
				}
			}
			pack();
			this.setSize(402, 398);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		jBPuntuar.addActionListener((ActionListener)controlador);
		jSNota.addChangeListener((ChangeListener) controlador);;
		
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
