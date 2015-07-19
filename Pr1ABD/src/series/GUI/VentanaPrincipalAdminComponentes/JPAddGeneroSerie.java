/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI.VentanaPrincipalAdminComponentes;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.EventListener;
import java.util.List;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
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
public class JPAddGeneroSerie extends javax.swing.JPanel implements VistaInterfaz {
	private JPanel jPSuperior;
	private JButton jBGenero;
	private JList<Object> jLListaSerie;
	private JList<Object> jLListaGenero;
	private JPanel jPCentral;
	private JButton jBEliminar;
	private JButton jBAsignar;
	private JPanel jPInferior;
	private JTextField jTFSerie;
	private JButton jBBuscarSerie;
	private JLabel jLSerie;
	private JPanel jPSuperiorDer;
	private JTextField jTGenero;
	private JLabel jLGenero;
	private JPanel jPSuperiorIz;

	
	
	public JPAddGeneroSerie() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			this.setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(574, 421));
			{
				jPSuperior = new JPanel();
				BorderLayout jPSuperiorLayout = new BorderLayout();
				jPSuperior.setLayout(jPSuperiorLayout);
				this.add(jPSuperior, BorderLayout.NORTH);
				jPSuperior.setPreferredSize(new java.awt.Dimension(574, 48));
				{
					jPSuperiorIz = new JPanel();
					BorderLayout jPSuperiorIzLayout = new BorderLayout();
					jPSuperiorIz.setLayout(jPSuperiorIzLayout);
					jPSuperior.add(jPSuperiorIz, BorderLayout.WEST);
					jPSuperiorIz.setPreferredSize(new java.awt.Dimension(297, 48));
					{
						jLGenero = new JLabel();
						jPSuperiorIz.add(jLGenero, BorderLayout.WEST);
						jLGenero.setText("Genero");
						jLGenero.setPreferredSize(new java.awt.Dimension(63, 48));
					}
					{
						jBGenero = new JButton();
						jPSuperiorIz.add(jBGenero, BorderLayout.EAST);
						jBGenero.setText("Buscar");
						jBGenero.setName("JBBuscarGenero");
						jBGenero.setPreferredSize(new java.awt.Dimension(85, 48));
					}
					{
						jTGenero = new JTextField();
						jPSuperiorIz.add(jTGenero, BorderLayout.CENTER);
						jTGenero.setName("JTFBuscarGenero");
					}
				}
				{
					jPSuperiorDer = new JPanel();
					BorderLayout jPSuperiorDerLayout = new BorderLayout();
					jPSuperiorDer.setLayout(jPSuperiorDerLayout);
					jPSuperior.add(jPSuperiorDer, BorderLayout.CENTER);
					{
						jLSerie = new JLabel();
						jPSuperiorDer.add(jLSerie, BorderLayout.WEST);
						jLSerie.setText("Serie");
						jLSerie.setPreferredSize(new java.awt.Dimension(50, 48));
					}
					{
						jBBuscarSerie = new JButton();
						jPSuperiorDer.add(jBBuscarSerie, BorderLayout.EAST);
						jBBuscarSerie.setText("Buscar");
						jBBuscarSerie.setName("JBBusca");
						jBBuscarSerie.setPreferredSize(new java.awt.Dimension(95, 48));
					}
					{
						jTFSerie = new JTextField();
						jPSuperiorDer.add(jTFSerie, BorderLayout.CENTER);
						jTFSerie.setName("JTFEscribe");
					}
				}
			}
			{
				jPInferior = new JPanel();
				jPInferior.setLayout(null);
				this.add(jPInferior, BorderLayout.SOUTH);
				jPInferior.setPreferredSize(new java.awt.Dimension(574, 47));
				{
					jBAsignar = new JButton();
					jPInferior.add(jBAsignar);
					jBAsignar.setText("Asignar");
					jBAsignar.setName("JBAsignarGeneroASerie");
					jBAsignar.setBounds(168, 6, 83, 30);
				}
				{
					jBEliminar = new JButton();
					jPInferior.add(jBEliminar);
					jBEliminar.setText("Eliminar");
					jBEliminar.setName("JBEliminarGeneroASerie");
					jBEliminar.setBounds(320, 6, 90, 30);
				}
			}
			{
				jPCentral = new JPanel();
				BorderLayout jPCentralLayout = new BorderLayout();
				jPCentral.setLayout(jPCentralLayout);
				this.add(jPCentral, BorderLayout.CENTER);
				{
					
					jLListaGenero = new JList<Object>();
					jPCentral.add(jLListaGenero, BorderLayout.WEST);
					jLListaGenero.setPreferredSize(new java.awt.Dimension(295, 326));
				}
				{
					
					jLListaSerie = new JList<Object>();
					jPCentral.add(jLListaSerie, BorderLayout.CENTER);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ListModel<Object> jList1Model = 	new DefaultComboBoxModel<Object>(((UserLoged)arg0).getGenerosBuscados().toArray());
		jLListaGenero.setModel(jList1Model);
		
		ListModel<Object> jList1Model1 = 	new DefaultComboBoxModel<Object>(((UserLoged)arg0).getSeriesBuscadas().toArray());
		jLListaSerie.setModel(jList1Model1);
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		jBAsignar.addActionListener((ActionListener)controlador);
		jBBuscarSerie.addActionListener((ActionListener)controlador);
		jBEliminar.addActionListener((ActionListener)controlador);
		jBGenero.addActionListener((ActionListener)controlador);
		
		jTFSerie.addFocusListener((FocusListener)controlador);
		jTGenero.addFocusListener((FocusListener)controlador);
		
		
	}
	
	public List<Object> getSelecionadoGenero()
	{
		return jLListaGenero.getSelectedValuesList();
	}
	
	public Object getSelecionadoSerie()
	{
		return jLListaSerie.getSelectedValue();
	}

}
