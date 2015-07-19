/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.util.EventListener;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;

import series.GUI.VentanaPrincipalComponents.VPPanelInferior;
import series.GUI.VentanaPrincipalComponents.VPPanelSuperior;
import series.modelo.Episodio;
import series.modelo.Serie;
import series.modelo.UserLoged;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame implements VistaInterfaz {

	private Container panelPrincipal;
	private VPPanelInferior panelIn;
	private VPPanelSuperior panelSu;
	private JPanel panel;
	
	
	public VentanaPrincipal()
	{
		super("Seguidores de Series");
		inicializaVentaPricipal();
	}
	
	private void inicializaVentaPricipal() {
		setMaximumSize(new Dimension(600, 800));
		setMinimumSize(new Dimension(600, 800)); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelPrincipal = getContentPane();
		
		panelIn = new VPPanelInferior();
		panelSu = new VPPanelSuperior();
		panel = new JPanel();
		
		LayoutManager layout = new BorderLayout();
		panel.setLayout(layout);
		
		panel.add(panelSu,BorderLayout.NORTH);
		panel.add(panelIn,BorderLayout.CENTER);
		
		panelPrincipal.add(panel);
		setLocationRelativeTo(null);
		pack();
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if(((UserLoged)o).usuarioRegistrado())
			setVisible(true);
		else
			{
				setVisible(false);
			}	
		panelIn.update(o, arg);
		panelSu.update(o, arg);
		validate();
		
	}
	
	/**
	 * Metodo para que la ventana se empiece ha hacerse visible en un nuevo hilo.
	 */
	public void empieza()
	{
		EventQueue.invokeLater(new Runnable(){
	    	public void run() {
	    		setVisible(false);
	    	}
	    });	
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		panelIn.fijarControlador(controlador);
		panelSu.fijarControlador(controlador);
		
	}
	
	
	
	public Serie getSerieSelecionada()
	{
		return panelIn.getSerieSelecionada();
	}
	
	public Serie getSerieComboBox()
	{
		return panelIn.getSerieComboBox();
	}
	
	public Episodio getEpisodioSelecionadoTabla()
	{
		return panelIn.getEpisodioSelecionadoTabla();
	}

}
