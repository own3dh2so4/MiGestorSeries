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
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import series.GUI.VistaInterfaz;
import series.modelo.Actor;
import series.modelo.Episodio;
import series.modelo.Personaje;
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
public class JPAddInterpreta extends javax.swing.JPanel implements VistaInterfaz{
	private JPanel jPTop;
	private JPanel jPTopIz;
	private JPanel jPTopIzDer;
	private JButton jBBuscar;
	private JPanel jPTopDer;
	private JTextField jTFActor;
	private JList<Object> jListActor;
	private JList<Object> jListPersonaje;
	private JList<Object> jListEpisodio;
	private JPanel jPCentro;
	private JButton jBNuevo;
	private JButton jBBorrar;
	private JPanel jPBot;
	private JTextField jTFPersonaje;
	private JLabel jLPersonaje;
	private JLabel jLActor;
	private JPanel jPTopCentro;
	private JTextField jTFEpisodio;
	private JTextField jTFSerie;
	private JLabel jLSerie;
	private JLabel jLEpisodio;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
		
	public JPAddInterpreta() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		BorderLayout thisLayout = new BorderLayout();
		this.setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(533, 366));
			{
				jPTop = new JPanel();
				BorderLayout jPTopLayout = new BorderLayout();
				jPTop.setLayout(jPTopLayout);
				this.add(jPTop, BorderLayout.NORTH);
				jPTop.setPreferredSize(new java.awt.Dimension(533, 47));
				{
					jPTopIz = new JPanel();
					BorderLayout jPTopIzLayout = new BorderLayout();
					jPTopIz.setLayout(jPTopIzLayout);
					jPTop.add(jPTopIz, BorderLayout.WEST);
					jPTopIz.setPreferredSize(new java.awt.Dimension(242, 47));
					{
						jLEpisodio = new JLabel();
						jPTopIz.add(jLEpisodio, BorderLayout.WEST);
						jLEpisodio.setText("Episodio");
					}
					{
						jPTopIzDer = new JPanel();
						BorderLayout jPTopIzDerLayout = new BorderLayout();
						jPTopIzDer.setLayout(jPTopIzDerLayout);
						jPTopIz.add(jPTopIzDer, BorderLayout.EAST);
						jPTopIzDer.setPreferredSize(new java.awt.Dimension(123, 47));
						{
							jLSerie = new JLabel();
							jPTopIzDer.add(jLSerie, BorderLayout.WEST);
							jLSerie.setText("Serie");
							jLSerie.setPreferredSize(new java.awt.Dimension(37, 47));
						}
						{
							jTFSerie = new JTextField();
							jTFSerie.setName("JTFEscribe");
							jPTopIzDer.add(jTFSerie, BorderLayout.CENTER);
						}
					}
					{
						jTFEpisodio = new JTextField();
						jTFEpisodio.setName("JTFCapituloEpisodioBuscar");
						jPTopIz.add(jTFEpisodio, BorderLayout.CENTER);
					}
				}
				{
					jBBuscar = new JButton();
					jPTop.add(jBBuscar, BorderLayout.EAST);
					jBBuscar.setText("Buscar");
					jBBuscar.setName("JBBuscarCapituloActorPersonaje");
					jBBuscar.setPreferredSize(new java.awt.Dimension(68, 47));
				}
				{
					jPTopCentro = new JPanel();
					BorderLayout jPTopCentroLayout = new BorderLayout();
					jPTopCentro.setLayout(jPTopCentroLayout);
					jPTop.add(jPTopCentro, BorderLayout.CENTER);
					{
						jLActor = new JLabel();
						jPTopCentro.add(jLActor, BorderLayout.WEST);
						jLActor.setText("Actor");
						jLActor.setPreferredSize(new java.awt.Dimension(37, 47));
					}
					{
						jPTopDer = new JPanel();
						BorderLayout jPTopDerLayout = new BorderLayout();
						jPTopDer.setLayout(jPTopDerLayout);
						jPTopCentro.add(jPTopDer, BorderLayout.EAST);
						jPTopDer.setPreferredSize(new java.awt.Dimension(126, 47));
						{
							jLPersonaje = new JLabel();
							jPTopDer.add(jLPersonaje, BorderLayout.WEST);
							jLPersonaje.setText("Personaje");
							jLPersonaje.setPreferredSize(new java.awt.Dimension(59, 47));
						}
						{
							jTFPersonaje = new JTextField();
							jTFPersonaje.setName("JTFBuscarPersonaje");
							jPTopDer.add(jTFPersonaje, BorderLayout.CENTER);
						}
					}
					{
						jTFActor = new JTextField();
						jTFActor.setName("JTFNombreBuscarActor");
						jPTopCentro.add(jTFActor, BorderLayout.CENTER);
					}
				}
			}
			{
				jPBot = new JPanel();
				BorderLayout jPBotLayout = new BorderLayout();
				jPBot.setLayout(jPBotLayout);
				this.add(jPBot, BorderLayout.SOUTH);
				jPBot.setPreferredSize(new java.awt.Dimension(533, 40));
				{
					jBBorrar = new JButton();
					jPBot.add(jBBorrar, BorderLayout.WEST);
					jBBorrar.setText("Borrar");
					jBBorrar.setName("JBBorrarInterpretacion");
					jBBorrar.setPreferredSize(new java.awt.Dimension(147, 40));
				}
				{
					jBNuevo = new JButton();
					jPBot.add(jBNuevo, BorderLayout.EAST);
					jBNuevo.setText("Nuevo");
					jBNuevo.setName("JBNuevaInterpretacion");
					jBNuevo.setPreferredSize(new java.awt.Dimension(151, 40));
				}
			}
			{
				jPCentro = new JPanel();
				BorderLayout jPCentroLayout = new BorderLayout();
				jPCentro.setLayout(jPCentroLayout);
				this.add(jPCentro, BorderLayout.CENTER);
				{
					jListEpisodio = new JList<Object>();
					jPCentro.add(jListEpisodio, BorderLayout.WEST);;
					jListEpisodio.setPreferredSize(new java.awt.Dimension(241, 279));
				}
				{
					jListPersonaje = new JList<Object>();
					jPCentro.add(jListPersonaje, BorderLayout.EAST);
					jListPersonaje.setPreferredSize(new java.awt.Dimension(194, 279));
				}
				{
					jListActor = new JList<Object>();
					jPCentro.add(jListActor, BorderLayout.CENTER);
				}
			}

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ListModel<Object> jList1Model = 	new DefaultComboBoxModel<Object>(((UserLoged)arg0).getEpisodiosBuscados().toArray());
		jListEpisodio.setModel(jList1Model);
		ListModel<Object> jList1Model2 = 	new DefaultComboBoxModel<Object>(((UserLoged)arg0).getActoresBuscados().toArray());
		jListActor.setModel(jList1Model2);
		ListModel<Object> jListModel3 = 	new DefaultComboBoxModel<Object>(((UserLoged)arg0).getPersonajesBuscados().toArray());
		jListPersonaje.setModel(jListModel3);
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		jBBorrar.addActionListener((ActionListener)controlador);
		jBBuscar.addActionListener((ActionListener)controlador);
		jBNuevo.addActionListener((ActionListener)controlador);
		
		jTFActor.addFocusListener((FocusListener)controlador);
		jTFEpisodio.addFocusListener((FocusListener)controlador);
		jTFPersonaje.addFocusListener((FocusListener)controlador);
		jTFSerie.addFocusListener((FocusListener)controlador);
	}
	
	public Episodio getEpisodioSelecionado()
	{
		return (Episodio) jListEpisodio.getSelectedValue();
	}
	
	public Actor getActorSelecionado()
	{
		return (Actor) jListActor.getSelectedValue();
	}
	
	public Personaje getPersonajeSelecionado()
	{
		return (Personaje) jListPersonaje.getSelectedValue();
	}

}
