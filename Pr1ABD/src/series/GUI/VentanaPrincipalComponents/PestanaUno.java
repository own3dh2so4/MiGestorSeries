/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI.VentanaPrincipalComponents;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.EventListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import series.GUI.VistaInterfaz;
import series.modelo.Serie;
import series.modelo.UserLoged;

@SuppressWarnings("serial")
public class PestanaUno extends JPanel implements VistaInterfaz{

	private JPanel sup;
	private JPanel inf;
	private JPanel denInf;
	private JPanel folder;
	private JLabel busca;
	private JTextField escribe;
	private JButton botonBuscar;
	private JButton verInfo;
	private JButton puntuarSerie;
	private JButton comentarSerie;
	private ListaSeries listaS;
	
	public PestanaUno()
	{
		inicializaPestanaUno();
	}
	
	private void inicializaPestanaUno() {
		sup = new JPanel();
		inf = new JPanel();
		busca = new JLabel("Buscar serie:");
		escribe = new JTextField();
		botonBuscar = new JButton("Buscar");
		verInfo = new JButton("Ver Informacion");
		puntuarSerie = new JButton("Puntuar");
		denInf = new JPanel();
		folder = new JPanel();
		listaS = new ListaSeries();
		comentarSerie = new JButton("Comentar");
		
		botonBuscar.setName("JBBusca");
		escribe.setName("JTFEscribe");
		verInfo.setName("JBVerInformacion");
		puntuarSerie.setName("JBPuntuarSerie");
		comentarSerie.setName("JBComentarSeriePrincipal");
		
		folder.setSize(200,10);
		
		denInf.setLayout(new GridLayout(1,3));
		denInf.add(puntuarSerie);
		denInf.add(comentarSerie);
		denInf.add(verInfo);
		//denInf.add(folder);
		
		
		setLayout(new BorderLayout());
		add(sup,BorderLayout.NORTH);
		add(inf, BorderLayout.CENTER);
		add(denInf,BorderLayout.SOUTH);
		
		sup.setLayout(new BorderLayout());
		sup.add(busca,BorderLayout.WEST);
		sup.add(escribe,BorderLayout.CENTER);
		sup.add(botonBuscar,BorderLayout.EAST);
		
		inf.add(listaS);
		
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		//listaS.update(arg0, arg1);
		inf.removeAll();
		listaS = new ListaSeries(((UserLoged)arg0).getSeriesBuscadas().toArray());
		inf.add(listaS);
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		
		botonBuscar.addActionListener((ActionListener)controlador);
		verInfo.addActionListener((ActionListener)controlador);
		puntuarSerie.addActionListener((ActionListener)controlador);
		escribe.addFocusListener((FocusListener)controlador);
		comentarSerie.addActionListener((ActionListener)controlador);
		
		listaS.fijarControlador(controlador);
		
	}
	
	public ListaSeries getListaSeries()
	{
		return listaS;
	}
	
	public Serie getSerieSelecionada()
	{
		return listaS.getSerieJList();
	}

}
