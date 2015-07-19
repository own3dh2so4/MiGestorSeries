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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import series.GUI.VistaInterfaz;
import series.modelo.Episodio;


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
public class VentanaInfoTablaEpisodios extends javax.swing.JFrame implements VistaInterfaz {
	private JPanel jPFondo;
	private JPanel jPanelinferior;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JButton jBInformacion;
	private JButton jBPuntuarEpisodio;
	private List<Episodio> episodios;

	public VentanaInfoTablaEpisodios(List<Episodio> episodios) {
		super("Episodios de la serie");
		this.episodios=episodios;
		initGUI();
		setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPFondo = new JPanel();
				BorderLayout jPFondoLayout = new BorderLayout();
				jPFondo.setLayout(jPFondoLayout);
				getContentPane().add(jPFondo, BorderLayout.CENTER);
				{
					jPanelinferior = new JPanel();
					jPFondo.add(jPanelinferior, BorderLayout.SOUTH);
					jPanelinferior.setPreferredSize(new java.awt.Dimension(384, 40));
					jPanelinferior.setLayout(null);
					{
						jBInformacion = new JButton();
						jPanelinferior.add(jBInformacion);
						jBInformacion.setText("Ver informacion");
						jBInformacion.setName("JBInfomacionVentanaInfoTalaEpisodios");
						jBInformacion.setBounds(201, 12, 164, 23);
					}
					{
						jBPuntuarEpisodio = new JButton();
						jPanelinferior.add(jBPuntuarEpisodio);
						jBPuntuarEpisodio.setText("Puntuar episodio");
						jBPuntuarEpisodio.setName("JBPuntuarEpisodio2");
						jBPuntuarEpisodio.setBounds(30, 12, 164, 23);
					}
				}
				{
					jScrollPane1 = new JScrollPane();
					jPFondo.add(jScrollPane1, BorderLayout.CENTER);
					{
						String episodiosString[][] =  new String [episodios.size()][4];
						for (int i=0; i<episodios.size(); i++)
							{
								episodiosString[i][0] = episodios.get(i).getEpisodioSerie().getCapitulo()+"";
								episodiosString[i][1] = episodios.get(i).getTemporada()+"";
								episodiosString[i][2] = episodios.get(i).getTitulo();
								episodiosString[i][3] = episodios.get(i).getFecha().toString();
								
							}
						TableModel jTableModel = 
								new DefaultTableModel(
										episodiosString,
										new String[] { "Núm.", "Temp.","Titulo","Fecha" });
						jTable1 = new JTable();
						jScrollPane1.setViewportView(jTable1);
						jTable1.setModel(jTableModel);
					}
				}
			}
			pack();
			setSize(400, 300);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		jBInformacion.addActionListener((ActionListener)controlador);
		jBPuntuarEpisodio.addActionListener((ActionListener)controlador);
		
	}
	
	public Episodio getEpisodioSelecionadoTabla()
	{
		if (jTable1.getSelectedRow()!=-1)
			return episodios.get(jTable1.getSelectedRow());
		else
			return null;
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
