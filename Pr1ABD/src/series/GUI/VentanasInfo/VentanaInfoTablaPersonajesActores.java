/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI.VentanasInfo;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.List;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import series.GUI.VistaInterfaz;
import series.modelo.Actor;
import series.modelo.Episodio;
import series.modelo.Personaje;


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
public class VentanaInfoTablaPersonajesActores extends javax.swing.JFrame implements VistaInterfaz{
	private JPanel jPFondo;
	private JLabel jLTituloSerie;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JButton jBInformacion;
	private JPanel jPBot;
	private List<Actor> listaActores;
	private List<Personaje> listaPersonajes;
	
	
	public VentanaInfoTablaPersonajesActores(Episodio episodio) {
		super("Informacion de personajes episodio: " +episodio.getTitulo());
		initGUI(episodio);
		setLocationRelativeTo(null);
	}
	
	private void initGUI(Episodio episodio) {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPFondo = new JPanel();
				BorderLayout jPFondoLayout = new BorderLayout();
				jPFondo.setLayout(jPFondoLayout);
				getContentPane().add(jPFondo, BorderLayout.CENTER);
				{
					jLTituloSerie = new JLabel();
					jPFondo.add(jLTituloSerie, BorderLayout.NORTH);
					jLTituloSerie.setText(episodio.getTitulo());
					jLTituloSerie.setPreferredSize(new java.awt.Dimension(384, 31));
				}
				{
					jPBot = new JPanel();
					jPFondo.add(jPBot, BorderLayout.SOUTH);
					jPBot.setPreferredSize(new java.awt.Dimension(384, 31));
					jPBot.setLayout(null);
					{
						jBInformacion = new JButton();
						jPBot.add(jBInformacion);
						jBInformacion.setText("Ver Informacion");
						jBInformacion.setName("JBVerInformacionVentanaTablaInfoAP");
						jBInformacion.setBounds(122, 8, 132, 23);
					}
				}
				{
					jScrollPane1 = new JScrollPane();
					jPFondo.add(jScrollPane1, BorderLayout.CENTER);
					{
						
						jTable1 = new JTable();
						jScrollPane1.setViewportView(jTable1);
						inicializaTabla(episodio);
					}
				}
			}
			pack();
			setSize(400, 300);
		
	}
	
	private void inicializaTabla(Episodio episodio)
	{
		listaActores = episodio.getListaActores();
		listaPersonajes = episodio.getListaPersonaje();
		String ap[][] = new String [listaActores.size()][2];
		for (int i=0; i<listaActores.size(); i++)
		{
			ap[i][0] = listaPersonajes.get(i).getNombre();
			ap[i][1] = listaActores.get(i).getNombre();
		}
		TableModel jTableModel =
				new DefaultTableModel(
						ap,
						new String[] { "Personaje", "Actor." });
		jTable1.setModel(jTableModel);
	}

	public Actor getActorSeleccionado()
	{
		if (jTable1.getSelectedRow()!=-1)
			return listaActores.get(jTable1.getSelectedRow());
		else 
			return null;
	}
	
	public Personaje getPersonajeSelecionado()
	{
		if (jTable1.getSelectedRow()!=-1)
			return listaPersonajes.get(jTable1.getSelectedRow());
		else
			return null;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		jBInformacion.addActionListener((ActionListener)controlador);
		
	}
	
	public void cerrarVentana()
	{
		dispose();
	}
	
	/**
	 * Metodo para que la ventana se empiece ha hacerse visible en un nuevo hilo.
	 */
	public void empieza()
	{
		EventQueue.invokeLater(new Runnable(){
	    	public void run() {
	    		setVisible(true);
	    	}
	    });	
	}

}
