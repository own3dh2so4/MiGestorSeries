/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI.VentanaPrincipalComponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.EventListener;
import java.util.Observable;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import series.GUI.VistaInterfaz;
import series.modelo.Episodio;
import series.modelo.Serie;

@SuppressWarnings("serial")
public class VPPanelInferior extends JPanel implements VistaInterfaz {

	private  JTabbedPane panelPestanas;
	private PestanaUno panel1;
	private JPanelPestanaDos panel2;
	
	
	public VPPanelInferior()
	{
		inicializaVPPI();
	}
	
	private void inicializaVPPI() {
		setMaximumSize(new Dimension(600, 400));
		setMinimumSize(new Dimension(600, 400));
		
		panelPestanas= new JTabbedPane();
		panel1 = new PestanaUno();
		panelPestanas.addTab("Buscar Series", panel1);
		panel2 = new JPanelPestanaDos();
		panelPestanas.addTab("Mis Series", panel2);
		setLayout(new BorderLayout());
		add(panelPestanas,BorderLayout.CENTER);
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		panel1.update(o, arg);
		panel2.update(o, arg);
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		panel1.fijarControlador(controlador);
		panel2.fijarControlador(controlador);
		
	}
	
	public PestanaUno getPanel1()
	{
		return panel1;
	}
	
	public Serie getSerieSelecionada()
	{
		return panel1.getSerieSelecionada();
	}
	
	public Serie getSerieComboBox()
	{
		return panel2.getSerieComboBox();
	}
	
	public Episodio getEpisodioSelecionadoTabla()
	{
		return panel2.getEpisodioSelecionadoTabla();
	}

}
