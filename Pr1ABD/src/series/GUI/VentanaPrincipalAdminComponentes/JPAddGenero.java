/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI.VentanaPrincipalAdminComponentes;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.EventListener;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import series.GUI.VistaInterfaz;
import series.modelo.UserLoged;

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
public class JPAddGenero extends javax.swing.JPanel implements VistaInterfaz {
	private JPanel jPanel1;
	private JButton jBBuscar;
	private JList<Object> jLListaGeneros;
	private JTextField jTFAnadeGenero;
	private JButton jBAnadeGenero;
	private JLabel jLAddGenero;
	private JPanel jPanel2;
	private JTextField jTFBuscar;
	private JLabel jLBuscar;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new JPAddGenero());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public JPAddGenero() {
		super();
		initGUI();
	}
	
	private void initGUI() {
			BorderLayout thisLayout = new BorderLayout();
			this.setLayout(thisLayout);
			setPreferredSize(new Dimension(400, 300));
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				this.add(jPanel1, BorderLayout.NORTH);
				jPanel1.setPreferredSize(new java.awt.Dimension(400, 35));
				{
					jLBuscar = new JLabel();
					jPanel1.add(jLBuscar, BorderLayout.WEST);
					jLBuscar.setText("Buscar genero");
					jLBuscar.setPreferredSize(new java.awt.Dimension(92, 35));
				}
				{
					jBBuscar = new JButton();
					jPanel1.add(jBBuscar, BorderLayout.EAST);
					jBBuscar.setText("Buscar");
					jBBuscar.setName("JBBuscarGenero");
					jBBuscar.setPreferredSize(new java.awt.Dimension(98, 35));
				}
				{
					jTFBuscar = new JTextField();
					jPanel1.add(jTFBuscar, BorderLayout.CENTER);
					jTFBuscar.setName("JTFBuscarGenero");
				}
			}
			{
				jPanel2 = new JPanel();
				BorderLayout jPanel2Layout = new BorderLayout();
				jPanel2.setLayout(jPanel2Layout);
				this.add(jPanel2, BorderLayout.SOUTH);
				jPanel2.setPreferredSize(new java.awt.Dimension(400, 34));
				{
					jLAddGenero = new JLabel();
					jPanel2.add(jLAddGenero, BorderLayout.WEST);
					jLAddGenero.setText("Añade Genero");
					jLAddGenero.setPreferredSize(new java.awt.Dimension(97, 34));
				}
				{
					jBAnadeGenero = new JButton();
					jPanel2.add(jBAnadeGenero, BorderLayout.EAST);
					jBAnadeGenero.setText("Añade");
					jBAnadeGenero.setPreferredSize(new java.awt.Dimension(92, 34));
					jBAnadeGenero.setName("JBAnadeGenero");
				}
				{
					jTFAnadeGenero = new JTextField();
					jPanel2.add(jTFAnadeGenero, BorderLayout.CENTER);
					jTFAnadeGenero.setName("JTFAnadeGenero");
				}
			}
			{
				jLListaGeneros = new JList<Object>();
				this.add(jLListaGeneros, BorderLayout.CENTER);
			}
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ListModel<Object> jList1Model = 	new DefaultComboBoxModel<Object>(((UserLoged)arg0).getGenerosBuscados().toArray());
		jLListaGeneros.setModel(jList1Model);
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		jBAnadeGenero.addActionListener((ActionListener)controlador);
		jBBuscar.addActionListener((ActionListener)controlador);
		
		jTFAnadeGenero.addFocusListener((FocusListener)controlador);
		jTFBuscar.addFocusListener((FocusListener)controlador);
		
	}

}
