/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.EventListener;
import java.util.List;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.WindowConstants;

import series.GUI.VentanaPrincipalAdminComponentes.JPAddComentarioSerie;
import series.GUI.VentanaPrincipalAdminComponentes.JPAddEpisodio;
import series.GUI.VentanaPrincipalAdminComponentes.JPAddGenero;
import series.GUI.VentanaPrincipalAdminComponentes.JPAddGeneroSerie;
import series.GUI.VentanaPrincipalAdminComponentes.JPAddInterpreta;
import series.modelo.Actor;
import series.modelo.ComentarioSerie;
import series.modelo.Episodio;
import series.modelo.Personaje;
import series.modelo.Serie;
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
public class VentanaPrincipalAdmin extends javax.swing.JFrame implements VistaInterfaz {
	private JPanel jPanel1;
	private JButton jButton1;
	private JButton jButton2;
	private JPanel jPanel6;
	private JList<Object> jList1;
	private JButton jButton8;
	private JPanel jPanel10;
	private JTextField jTextField3;
	private JList<Object> jList3;
	private JButton jButton9;
	private JButton jButton7;
	private JLabel jLabel3;
	private JPanel jPanel9;
	private JList<Object> jList2;
	private JButton jButton6;
	private JButton jButton5;
	private JPanel jPanel8;
	private JTextField jTextField2;
	private JButton jButton4;
	private JLabel jLabel2;
	private JPanel jPanel7;
	private JButton jButton3;
	private JTextField jTextField1;
	private JLabel jLabel1;
	private JPanel jPanel5;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JTabbedPane jTabbedPane1;
	private JPAddGenero jPAddGenero;
	private JPAddGeneroSerie jPAddGeneroSerie;
	private JPAddEpisodio jPAddEpisodio;
	private JPAddInterpreta jPAddInterpreta;
	private JPAddComentarioSerie jPAddComentarioSerie;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public void empieza() {
		EventQueue.invokeLater(new Runnable(){
	    	public void run() {
	    		setVisible(false);
	    	}
	    });	
	}
	
	public VentanaPrincipalAdmin() {
		super("Ventana de Administracion");
		initGUI();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new java.awt.Dimension(750, 550));
	}
	
	private void initGUI() {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jTabbedPane1 = new JTabbedPane();
					jPanel1.add(jTabbedPane1);
					jTabbedPane1.setPreferredSize(new java.awt.Dimension(700, 500));
					{
						jPanel2 = new JPanel();
						BorderLayout jPanel2Layout = new BorderLayout();
						jPanel2.setLayout(jPanel2Layout);
						jTabbedPane1.addTab("Series", null, jPanel2, null);
						{
							jPanel5 = new JPanel();
							BorderLayout jPanel5Layout = new BorderLayout();
							jPanel5.setLayout(jPanel5Layout);
							jPanel2.add(jPanel5, BorderLayout.NORTH);
							jPanel5.setPreferredSize(new java.awt.Dimension(372, 35));
							{
								jLabel1 = new JLabel();
								jPanel5.add(jLabel1, BorderLayout.WEST);
								jLabel1.setText("Buscar serie");
								jLabel1.setPreferredSize(new java.awt.Dimension(84, 35));
							}
							{
								jButton1 = new JButton();
								jPanel5.add(jButton1, BorderLayout.EAST);
								jButton1.setText("Buscar");
								jButton1.setName("JBBusca");
								jButton1.setPreferredSize(new java.awt.Dimension(65, 55));
							}
							{
								jTextField1 = new JTextField();
								jTextField1.setName("JTFEscribe");
								jPanel5.add(jTextField1, BorderLayout.CENTER);
								jTextField1.setPreferredSize(new java.awt.Dimension(200, 35));
							}
						}
						{
							jList1 = new JList<Object>();
							jPanel2.add(jList1, BorderLayout.CENTER);;
						}
						{
							jPanel6 = new JPanel();
							BorderLayout jPanel6Layout = new BorderLayout();
							jPanel6.setLayout(jPanel6Layout);
							jPanel2.add(jPanel6, BorderLayout.SOUTH);
							jPanel6.setPreferredSize(new java.awt.Dimension(372, 26));
							{
								jButton2 = new JButton();
								jPanel6.add(jButton2, BorderLayout.WEST);
								jButton2.setText("Ver Informacion");
								jButton2.setName("JBVerInformacionAdmin");
								jButton2.setPreferredSize(new java.awt.Dimension(152, 26));
							}
							{
								jButton3 = new JButton();
								jPanel6.add(jButton3, BorderLayout.EAST);
								jButton3.setText("Nueva Serie");
								jButton3.setName("JBNuevaSerie");
								jButton3.setPreferredSize(new java.awt.Dimension(152, 26));
							}
						}
					}
					{
						jPanel3 = new JPanel();
						BorderLayout jPanel3Layout = new BorderLayout();
						jPanel3.setLayout(jPanel3Layout);
						jTabbedPane1.addTab("Actores", null, jPanel3, null);
						{
							jPanel7 = new JPanel();
							BorderLayout jPanel7Layout = new BorderLayout();
							jPanel7.setLayout(jPanel7Layout);
							jPanel3.add(jPanel7, BorderLayout.NORTH);
							jPanel7.setPreferredSize(new java.awt.Dimension(372, 34));
							{
								jLabel2 = new JLabel();
								jPanel7.add(jLabel2, BorderLayout.WEST);
								jLabel2.setText("Buscar actor:");
							}
							{
								jButton4 = new JButton();
								jPanel7.add(jButton4, BorderLayout.EAST);
								jButton4.setText("Buscar");
								jButton4.setName("JBBuscarActor");
								jButton4.setPreferredSize(new java.awt.Dimension(74, 34));
							}
							{
								jTextField2 = new JTextField();
								jPanel7.add(jTextField2, BorderLayout.CENTER);
								jTextField2.setName("JTFNombreBuscarActor");
								jTextField2.setPreferredSize(new java.awt.Dimension(222, 34));
							}
						}
						{
							jPanel8 = new JPanel();
							BorderLayout jPanel8Layout = new BorderLayout();
							jPanel8.setLayout(jPanel8Layout);
							jPanel3.add(jPanel8, BorderLayout.SOUTH);
							jPanel8.setPreferredSize(new java.awt.Dimension(372, 28));
							{
								jButton5 = new JButton();
								jPanel8.add(jButton5, BorderLayout.WEST);
								jButton5.setText("Ver Infomación");
								jButton5.setName("JBVerInformacionActor");
								jButton5.setPreferredSize(new java.awt.Dimension(136, 28));
							}
							{
								jButton6 = new JButton();
								jPanel8.add(jButton6, BorderLayout.EAST);
								jButton6.setText("Nueva actor");
								jButton6.setName("JBNuevoActor");
								jButton6.setPreferredSize(new java.awt.Dimension(146, 28));
							}
						}
						{
							jList2 = new JList<Object>();
							jPanel3.add(jList2, BorderLayout.CENTER);
						}
					}
					{
						jPanel4 = new JPanel();
						BorderLayout jPanel4Layout = new BorderLayout();
						jPanel4.setLayout(jPanel4Layout);
						jTabbedPane1.addTab("Personajes", null, jPanel4, null);
						{
							jPanel9 = new JPanel();
							BorderLayout jPanel9Layout = new BorderLayout();
							jPanel9.setLayout(jPanel9Layout);
							jPanel4.add(jPanel9, BorderLayout.NORTH);
							jPanel9.setPreferredSize(new java.awt.Dimension(372, 33));
							{
								jLabel3 = new JLabel();
								jPanel9.add(jLabel3, BorderLayout.WEST);
								jLabel3.setText("Buscar Personaje: ");
								jLabel3.setPreferredSize(new java.awt.Dimension(113, 33));
							}
							{
								jButton7 = new JButton();
								jPanel9.add(jButton7, BorderLayout.EAST);
								jButton7.setText("Buscar");
								jButton7.setName("JBBuscarPersonaje");
								jButton7.setPreferredSize(new java.awt.Dimension(94, 33));
							}
							{
								jTextField3 = new JTextField();
								jTextField3.setName("JTFBuscarPersonaje");
								jPanel9.add(jTextField3, BorderLayout.CENTER);
							}
						}
						{
							jPanel10 = new JPanel();
							BorderLayout jPanel10Layout = new BorderLayout();
							jPanel4.add(jPanel10, BorderLayout.SOUTH);
							jPanel10.setLayout(jPanel10Layout);
							jPanel10.setPreferredSize(new java.awt.Dimension(372, 29));
							{
								jButton8 = new JButton();
								jPanel10.add(jButton8, BorderLayout.WEST);
								jButton8.setText("Información");
								jButton8.setName("JBVerInformacionPersonaje");
								jButton8.setPreferredSize(new java.awt.Dimension(137, 29));
							}
							{
								jButton9 = new JButton();
								jPanel10.add(jButton9, BorderLayout.EAST);
								jButton9.setText("Nuevo personaje");
								jButton9.setName("JBNuevoPersonaje");
								jButton9.setPreferredSize(new java.awt.Dimension(140, 29));
							}
						}
						{
							jList3 = new JList<Object>();
							jPanel4.add(jList3, BorderLayout.CENTER);;
						}
					}
					{
						jPAddGenero = new JPAddGenero();
						jTabbedPane1.addTab("Genero", jPAddGenero);
					}
					{
						jPAddGeneroSerie = new JPAddGeneroSerie();
						jTabbedPane1.addTab("Genero a serie", jPAddGeneroSerie);
					}
					{
						jPAddEpisodio = new JPAddEpisodio();
						jTabbedPane1.addTab("Episodio", jPAddEpisodio);
					}
					{
						jPAddInterpreta = new JPAddInterpreta();
						jTabbedPane1.addTab("Interpreta", jPAddInterpreta);
					}
					{
						jPAddComentarioSerie = new JPAddComentarioSerie();
						jTabbedPane1.addTab("Comentario Serie", jPAddComentarioSerie);
					}
				}
			}
			pack();
			setSize(400, 300);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(((UserLoged)arg0).usuarioRegistrado())
			setVisible(true);
		ListModel<Object> jList1Model = 	new DefaultComboBoxModel<Object>(((UserLoged)arg0).getSeriesBuscadas().toArray());
		jList1.setModel(jList1Model);
		ListModel<Object> jList1Model2 = 	new DefaultComboBoxModel<Object>(((UserLoged)arg0).getActoresBuscados().toArray());
		jList2.setModel(jList1Model2);
		ListModel<Object> jListModel3 = 	new DefaultComboBoxModel<Object>(((UserLoged)arg0).getPersonajesBuscados().toArray());
		jList3.setModel(jListModel3);
		jPAddGenero.update(arg0, arg1);
		jPAddGeneroSerie.update(arg0, arg1);
		jPAddEpisodio.update(arg0, arg1);
		jPAddInterpreta.update(arg0, arg1);
		jPAddComentarioSerie.update(arg0, arg1);
		
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		jButton1.addActionListener((ActionListener)controlador);
		jButton2.addActionListener((ActionListener)controlador);
		jButton3.addActionListener((ActionListener)controlador);
		jButton4.addActionListener((ActionListener)controlador);
		jButton5.addActionListener((ActionListener)controlador);
		jButton6.addActionListener((ActionListener)controlador);
		jButton7.addActionListener((ActionListener)controlador);
		jButton8.addActionListener((ActionListener)controlador);
		jButton9.addActionListener((ActionListener)controlador);
		
		jTextField1.addFocusListener((FocusListener)controlador);
		jTextField2.addFocusListener((FocusListener)controlador);
		jTextField3.addFocusListener((FocusListener)controlador);
		
		jPAddGenero.fijarControlador(controlador);
		jPAddGeneroSerie.fijarControlador(controlador);
		jPAddEpisodio.fijarControlador(controlador);
		jPAddInterpreta.fijarControlador(controlador);
		jPAddComentarioSerie.fijarControlador(controlador);
		
	}
	
	public JList<Object> getJListSerie()
	{
		return jList1;
	}
	
	public Serie getSerieSelecioandaAdmin()
	{
		return (Serie) jList1.getSelectedValue();
	}
	
	public Actor getActorSelecionadoAdmin()
	{
		return (Actor) jList2.getSelectedValue();
	}
	
	public Personaje getPersonajeSelecionadoAdmin()
	{
		return (Personaje) jList3.getSelectedValue();
	}
	

	
	public List<Object> getSelecionadoGeneroDeGeneroSerie()
	{
		return jPAddGeneroSerie.getSelecionadoGenero();
	}
	
	public Object getSelecionadoSerieDeGeneroSerie()
	{
		return jPAddGeneroSerie.getSelecionadoSerie();
	}
	
	public List<Object> getSelecionadoEpisodio()
	{
		return jPAddEpisodio.getSelecionadoEpisodio();
	}
	
	public Episodio getEpisodioSelecionadoInterpretacion()
	{
		return jPAddInterpreta.getEpisodioSelecionado();
	}
	
	public Actor getActorSelecionadoInterpretacion()
	{
		return jPAddInterpreta.getActorSelecionado();
	}
	
	public Personaje getPersonajeSelecionadoInterpretacion()
	{
		return jPAddInterpreta.getPersonajeSelecionado();
	}
	
	public ComentarioSerie getComentarioSerieSelecionado()
	{
		return jPAddComentarioSerie.getComentarioSerieSelecionado();
	}
}
