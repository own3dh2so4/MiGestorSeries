/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI.VentanaPrincipalComponents;

import java.awt.event.FocusListener;
import java.util.EventListener;
import java.util.Observable;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import series.GUI.VistaInterfaz;
import series.modelo.Serie;

@SuppressWarnings("serial")
public class ListaSeries extends JPanel implements VistaInterfaz {

	private JList<Object> listaSeries;
	private JScrollPane panelDesplazamiento;
	
	public ListaSeries() {
		inicializaListaSeries();
	}
	
	public ListaSeries(Object[] list)
	{
		listaSeries = new JList<Object>(list);
		panelDesplazamiento = new JScrollPane(listaSeries);
		add(panelDesplazamiento);
		listaSeries.setName("JLListaSerie");
	}
	
	
	private void inicializaListaSeries() {
		listaSeries = new JList<Object>();
		panelDesplazamiento = new JScrollPane(listaSeries);
		add(panelDesplazamiento);
		listaSeries.setName("JLListaSerie");
	}
	


	@Override
	public void update(Observable arg0, Object arg1) {
		
	
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		listaSeries.addFocusListener((FocusListener)controlador);
		//listaSeries.add((ActionListener)controlador);
		
	}
	
	public JList<Object> getJList() {
		return listaSeries;
	}
	
	public Serie getSerieJList()
	{
		return (Serie) listaSeries.getSelectedValue();
	}

}
