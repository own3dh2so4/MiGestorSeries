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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
public class JPAddEpisodio extends javax.swing.JPanel implements VistaInterfaz{
	private JPanel jPSuperior;
	private JLabel jLBuscarEpisodio;
	private JPanel jPanel1;
	private JPanel jPInferior;
	private JList<Object> jList;
	private JButton jBVerInformacion;
	private JButton jBNuevo;
	private JButton jBBorrar;
	private JTextField jTFSerie;
	private JLabel jLSerie;
	private JPanel jPanel2;
	private JTextField jTFCapitulo;
	private JButton jBuscar;

	
	public JPAddEpisodio() {
		super();
		initGUI();
	}
	
	private void initGUI() {
			BorderLayout thisLayout = new BorderLayout();
			this.setLayout(thisLayout);
			setPreferredSize(new Dimension(400, 300));
			{
				jPSuperior = new JPanel();
				BorderLayout jPSuperiorLayout = new BorderLayout();
				jPSuperior.setLayout(jPSuperiorLayout);
				this.add(jPSuperior, BorderLayout.NORTH);
				jPSuperior.setPreferredSize(new java.awt.Dimension(400, 44));
				{
					jLBuscarEpisodio = new JLabel();
					jPSuperior.add(jLBuscarEpisodio, BorderLayout.WEST);
					jLBuscarEpisodio.setText("Buscar episodio");
					jLBuscarEpisodio.setPreferredSize(new java.awt.Dimension(93, 44));
				}
				{
					jBuscar = new JButton();
					jPSuperior.add(jBuscar, BorderLayout.EAST);
					jBuscar.setText("Buscar");
					jBuscar.setName("JBBuscarEpisodio");
					jBuscar.setPreferredSize(new java.awt.Dimension(86, 44));
				}
				{
					jPanel1 = new JPanel();
					BorderLayout jPanel1Layout = new BorderLayout();
					jPanel1.setLayout(jPanel1Layout);
					jPSuperior.add(jPanel1, BorderLayout.CENTER);
					{
						jTFCapitulo = new JTextField();
						jPanel1.add(jTFCapitulo, BorderLayout.WEST);
						jTFCapitulo.setPreferredSize(new java.awt.Dimension(69, 44));
						jTFCapitulo.setName("JTFCapituloEpisodioBuscar");
						jTFCapitulo.addKeyListener(new KeyAdapter()
				        { 
					     	   public void keyTyped(KeyEvent e)
					     	   {
					     	      char caracter = e.getKeyChar();

					     	      // Verificar si la tecla pulsada no es un digito
					     	      if(((caracter < '0') ||
					     	         (caracter > '9')) &&
					     	         (caracter != '\b' /*corresponde a BACK_SPACE*/))
					     	      {
					     	         e.consume();  // ignorar el evento de teclado
					     	      }
					     	   }
					     	});
					
					}
					{
						jPanel2 = new JPanel();
						BorderLayout jPanel2Layout = new BorderLayout();
						jPanel2.setLayout(jPanel2Layout);
						jPanel1.add(jPanel2, BorderLayout.CENTER);
						{
							jLSerie = new JLabel();
							jPanel2.add(jLSerie, BorderLayout.WEST);
							jLSerie.setText("Serie");
							jLSerie.setPreferredSize(new java.awt.Dimension(46, 44));
						}
						{
							jTFSerie = new JTextField();
							jPanel2.add(jTFSerie, BorderLayout.CENTER);
							jTFSerie.setName("JTFEscribe");
						}
					}
				}
			}
			{
				jPInferior = new JPanel();
				BorderLayout jPInferiorLayout = new BorderLayout();
				jPInferior.setLayout(jPInferiorLayout);
				this.add(jPInferior, BorderLayout.SOUTH);
				jPInferior.setPreferredSize(new java.awt.Dimension(400, 36));
				{
					jBBorrar = new JButton();
					jPInferior.add(jBBorrar, BorderLayout.WEST);
					jBBorrar.setText("Borrar");
					jBBorrar.setName("JBBorrarEpisodio");
					jBBorrar.setPreferredSize(new java.awt.Dimension(134, 36));
				}
				{
					jBNuevo = new JButton();
					jPInferior.add(jBNuevo, BorderLayout.EAST);
					jBNuevo.setText("Nuevo");
					jBNuevo.setName("JBNuevoEpisodio");
					jBNuevo.setPreferredSize(new java.awt.Dimension(129, 36));
				}
				{
					jBVerInformacion = new JButton();
					jBVerInformacion.setName("JBInformacionEpisodioAdmin");
					jPInferior.add(jBVerInformacion, BorderLayout.CENTER);
					jBVerInformacion.setText("Ver Informacion");
				}
			}
			{
				
				jList = new JList<Object>();
				this.add(jList, BorderLayout.CENTER);
			}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ListModel<Object> jList1Model = 	new DefaultComboBoxModel<Object>(((UserLoged)arg0).getEpisodiosBuscados().toArray());
		jList.setModel(jList1Model);
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		jBBorrar.addActionListener((ActionListener)controlador);
		jBNuevo.addActionListener((ActionListener)controlador);
		jBuscar.addActionListener((ActionListener)controlador);
		jBVerInformacion.addActionListener((ActionListener)controlador);
		
		jTFCapitulo.addFocusListener((FocusListener)controlador);
		jTFSerie.addFocusListener((FocusListener)controlador);
		
	}
	
	public List<Object> getSelecionadoEpisodio()
	{
		return jList.getSelectedValuesList();
	}

}
