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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

import series.GUI.VistaInterfaz;
import series.modelo.ComentarioSerie;
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
public class JPAddComentarioSerie extends javax.swing.JPanel implements VistaInterfaz{
	private JPanel jPSuperiro;
	private JButton jBEliminar;
	private JScrollPane jScrollPane1;
	private JList<Object> jList1;
	private JPanel jPBot;
	private JTextField jTFNombreUusario;
	private JButton jBBuscarComentariosDelUsuario;
	private JLabel jLNombreUser;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
		
	public JPAddComentarioSerie() {
		super();
		initGUI();
	}
	
	private void initGUI() {
			BorderLayout thisLayout = new BorderLayout();
			this.setLayout(thisLayout);
			setPreferredSize(new Dimension(400, 300));
			{
				jPSuperiro = new JPanel();
				BorderLayout jPSuperiroLayout = new BorderLayout();
				jPSuperiro.setLayout(jPSuperiroLayout);
				this.add(jPSuperiro, BorderLayout.NORTH);
				jPSuperiro.setPreferredSize(new java.awt.Dimension(400, 45));
				{
					jLNombreUser = new JLabel();
					jPSuperiro.add(jLNombreUser, BorderLayout.WEST);
					jLNombreUser.setText("Nombre del usuario");
					jLNombreUser.setPreferredSize(new java.awt.Dimension(134, 45));
				}
				{
					jBBuscarComentariosDelUsuario = new JButton();
					jPSuperiro.add(jBBuscarComentariosDelUsuario, BorderLayout.EAST);
					jBBuscarComentariosDelUsuario.setText("Buscar");
					jBBuscarComentariosDelUsuario.setName("JBBuscarComentariosUsuario");
					jBBuscarComentariosDelUsuario.setPreferredSize(new java.awt.Dimension(96, 45));
				}
				{
					jTFNombreUusario = new JTextField();
					jPSuperiro.add(jTFNombreUusario, BorderLayout.CENTER);
					jTFNombreUusario.setName("JTFNombreUsuarioBuscarComentario");
				}
			}
			{
				jPBot = new JPanel();
				this.add(jPBot, BorderLayout.SOUTH);
				jPBot.setPreferredSize(new java.awt.Dimension(400, 31));
				jPBot.setLayout(null);
				{
					jBEliminar = new JButton();
					jPBot.add(jBEliminar);
					jBEliminar.setText("BorrarComentario");
					jBEliminar.setName("JBEliminarComentario");
					jBEliminar.setBounds(119, 8, 184, 23);
				}
			}
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1, BorderLayout.CENTER);
				{
					
					jList1 = new JList<Object>();
					jScrollPane1.setViewportView(jList1);
				}
			}
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ListModel<Object> jList1Model = 	new DefaultComboBoxModel<Object>(((UserLoged)arg0).getComentarioSerieBuscardos().toArray());
		jList1.setModel(jList1Model);
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		jBBuscarComentariosDelUsuario.addActionListener((ActionListener)controlador);
		jBEliminar.addActionListener((ActionListener)controlador);
		jTFNombreUusario.addFocusListener((FocusListener)controlador);
		
	}
	
	public ComentarioSerie getComentarioSerieSelecionado()
	{
		return (ComentarioSerie) jList1.getSelectedValue();
	}

}
