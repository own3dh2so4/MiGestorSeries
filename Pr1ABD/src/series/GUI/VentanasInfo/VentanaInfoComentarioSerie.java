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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import series.GUI.PanelesInfo.PanelInfoComentarioSerie;
import series.modelo.ComentarioSerie;
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
public class VentanaInfoComentarioSerie extends javax.swing.JFrame {
	private JScrollPane jScrollPane;
	private JPanel jPanel;
	private List<PanelInfoComentarioSerie> listaComentarios;
	private Serie serie;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public VentanaInfoComentarioSerie(Serie serie) {
		super("Comentarios de la serie: " +serie.getNombre());
		this.serie = serie;
		initGUI();
		setLocationRelativeTo(null);
	}
	
	private void iniLista() {
		List<ComentarioSerie> comentarios = serie.getComentarios();
		listaComentarios = new ArrayList<PanelInfoComentarioSerie>();
		for (int i=0; i<comentarios.size(); i++)
		{
			listaComentarios.add(new PanelInfoComentarioSerie(comentarios.get(i)));
		}
		
	}

	private void initGUI() {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			iniLista();
			{
				jScrollPane = new JScrollPane();
				getContentPane().add(jScrollPane, BorderLayout.CENTER);
			}
			{
				jPanel = new JPanel();
				jPanel.setLayout(new GridLayout(listaComentarios.size(),1));
				jPanel.setMaximumSize(new java.awt.Dimension(1000, 150));
				jScrollPane.setViewportView(jPanel);
				for (int i=0; i<listaComentarios.size(); i++)
				{
					jPanel.add(listaComentarios.get(i));
				}
			}
			pack();
			setSize(400, 300);
		
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
