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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.sql.Date;
import java.util.Calendar;
import java.util.EventListener;
import java.util.GregorianCalendar;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import series.GUI.VistaInterfaz;
import series.modelo.UserLoged;

@SuppressWarnings("serial")
public class VPPanelSuperior extends JPanel implements VistaInterfaz {

	private JPanel panelDr;
	private JPanel panelIz;
	private VPPSFoto panelFoto;
	private JLabel nomUser;
	private JLabel edad;
	private JPanel folder;

	
	public VPPanelSuperior()
	{
		inicializaVPPanelSuperior();
	}
	
	private void inicializaVPPanelSuperior() {
		//setSize(200,300);
		setMaximumSize(new Dimension(600, 200));
		setMinimumSize(new Dimension(600, 200));
		panelDr = new JPanel();
		panelIz = new JPanel();
		panelFoto = new VPPSFoto();
		nomUser = new JLabel();
		edad = new JLabel();
		folder = new JPanel();
		
		
		setName("VPPanelSuperior");
		panelDr.setName("VPPSPanelDr");
		panelDr.setMaximumSize(new Dimension(200, 400));
		panelDr.setMinimumSize(new Dimension(200, 400));
		panelIz.setName("VPPSPanelIz");
		panelIz.setMaximumSize(new Dimension(200, 200));
		panelIz.setMinimumSize(new Dimension(200, 200));
		panelFoto.setName("VPPSFPanelFoto");
		nomUser.setFont(new Font("Arial", Font.BOLD, 45));
		nomUser.setHorizontalAlignment(SwingConstants.CENTER);
		edad.setFont(new Font("Arial", 0, 15));
		edad.setHorizontalAlignment(SwingConstants.CENTER);
		
		LayoutManager elL = new BorderLayout();
		setLayout(elL);
		
		LayoutManager layaout = new GridLayout(4,3);
		panelDr.setLayout(layaout);
		
		
		panelIz.add(panelFoto);
		add(panelIz,BorderLayout.WEST);
		add(panelDr,BorderLayout.CENTER);
		panelDr.add(folder);
		panelDr.add(nomUser);
		panelDr.add(folder);
		panelDr.add(folder);
		panelDr.add(folder);
		panelDr.add(folder);
		panelDr.add(folder);
		panelDr.add(edad);
	}

	@Override
	public void update(Observable o, Object arg) {
		panelFoto.update(o, arg);
		nomUser.setText(((UserLoged)o).getNick());
		edad.setText(calculoAnos(((UserLoged)o).getFecha()));
		
		
	}
	
	private String calculoAnos(Date nacio)
	{
		Calendar nac = new GregorianCalendar();
		nac.setTime(nacio);
		Calendar hoy = new GregorianCalendar();
		String ret="";
		int anos= hoy.get(Calendar.YEAR)-nac.get(Calendar.YEAR);
		if (hoy.get(Calendar.MONTH)-nac.get(Calendar.MONTH)<0)
			anos--;
		else if (hoy.get(Calendar.MONTH)-nac.get(Calendar.MONTH)==0)
		{
			if (hoy.get(Calendar.DATE)-nac.get(Calendar.DATE)<0)
			{
				anos--;
			}
		}
		ret=ret+anos+" años";		
		
		return ret;
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		panelFoto.fijarControlador(controlador);
		
	}

}
