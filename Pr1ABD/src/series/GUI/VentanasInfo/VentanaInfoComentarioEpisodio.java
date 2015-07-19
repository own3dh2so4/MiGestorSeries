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

import series.GUI.PanelesInfo.PanelInfoComentarioEpisodio;
import series.modelo.ComentarioEpisodio;
import series.modelo.Episodio;

@SuppressWarnings("serial")
public class VentanaInfoComentarioEpisodio extends javax.swing.JFrame {
	private JScrollPane jScrollPane;
	private JPanel jPanel;
	private List<PanelInfoComentarioEpisodio> listaComentarios;
	private Episodio episodio;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public VentanaInfoComentarioEpisodio(Episodio episodio) {
		super("Comentarios del episodio: " + episodio.getTitulo());
		this.episodio = episodio;
		initGUI();
		setLocationRelativeTo(null);
	}
	
	private void iniLista() {
		List<ComentarioEpisodio> comentarios = episodio.getComentarios();
		listaComentarios = new ArrayList<PanelInfoComentarioEpisodio>();
		for (int i=0; i<comentarios.size(); i++)
		{
			listaComentarios.add(new PanelInfoComentarioEpisodio(comentarios.get(i)));
		}
		
	}

	private void initGUI() {
			iniLista();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
