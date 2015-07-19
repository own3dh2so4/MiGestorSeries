/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI.VentanaPrincipalComponents;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.List;
import java.util.Observable;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import series.GUI.VistaInterfaz;
import series.modelo.Episodio;
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
public class JPanelPestanaDos extends javax.swing.JPanel  implements VistaInterfaz{
	private JPanel jPSuperior;
	private JComboBox<Object> jCBSeries;
	private JScrollPane jScrollPane1;
	private JTable jTable;
	private JButton jBMarcarComoVisto;
	private JButton jBInformacion;
	private JButton JBPuntuar;
	private JButton JBComenta;
	private JPanel jPanelInf;
	private JLabel jLSerie;
	private UserLoged user;
	private List<Episodio> episodios;

	
	
	public JPanelPestanaDos() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		
			BorderLayout thisLayout = new BorderLayout();
			this.setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(467, 389));
			{
				jPSuperior = new JPanel();
				BorderLayout jPSuperiorLayout = new BorderLayout();
				jPSuperior.setLayout(jPSuperiorLayout);
				this.add(jPSuperior, BorderLayout.NORTH);
				jPSuperior.setPreferredSize(new java.awt.Dimension(467, 44));
				{
					jLSerie = new JLabel();
					jPSuperior.add(jLSerie, BorderLayout.WEST);
					jLSerie.setText("Serie:");
					jLSerie.setPreferredSize(new java.awt.Dimension(207, 44));
				}
				{
					
					jCBSeries = new JComboBox<Object>();
					jCBSeries.setName("JCBSeries");
					jPSuperior.add(jCBSeries, BorderLayout.CENTER);
				}
			}
			{
				jPanelInf = new JPanel();
				this.add(jPanelInf, BorderLayout.SOUTH);
				jPanelInf.setPreferredSize(new java.awt.Dimension(467, 40));
				jPanelInf.setLayout(null);
				{
					jBInformacion = new JButton();
					jPanelInf.add(jBInformacion);
					jBInformacion.setText("Informacion");
					jBInformacion.setName("JBInformacionEpisodio");
					jBInformacion.setBounds(10, 12, 110, 23);
				}
				{
					jBMarcarComoVisto = new JButton();
					jPanelInf.add(jBMarcarComoVisto);
					jBMarcarComoVisto.setText("Marcar como visto");
					jBMarcarComoVisto.setName("JBMarcarComoVisto");
					jBMarcarComoVisto.setBounds(233, 12, 162, 23);
				}
				{
					JBPuntuar = new JButton();
					jPanelInf.add(JBPuntuar);
					JBPuntuar.setText("Puntuar episodio");
					JBPuntuar.setName("JBPuntuarEpisodio");
					JBPuntuar.setBounds(400, 12, 172, 23);
				}
				{
					JBComenta = new JButton();
					jPanelInf.add(JBComenta);
					JBComenta.setText("Comenta");
					JBComenta.setName("JBComentaEpisodio");
					JBComenta.setBounds(125, 12, 100, 23);
				}
			}
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1, BorderLayout.CENTER);
				{
					
					jTable = new JTable();
					jScrollPane1.setViewportView(jTable);
				}
			}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (((UserLoged)arg0).getSeriesDelUser()!=null)
		{
			ComboBoxModel<Object> jCBSeriesModel = new DefaultComboBoxModel<Object>( ((UserLoged)arg0).getSeriesDelUser().toArray());
			jCBSeries.setModel(jCBSeriesModel);
			user=((UserLoged)arg0);
			actualizarTabla();
		}
		
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		jCBSeries.addActionListener(new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        actualizarTabla();
		    }
		});
		jBInformacion.addActionListener((ActionListener)controlador);
		jBMarcarComoVisto.addActionListener((ActionListener)controlador);
		JBPuntuar.addActionListener((ActionListener)controlador);
		JBComenta.addActionListener((ActionListener)controlador);
	}
	
	public void actualizarTabla()
	{
		if ((Serie)jCBSeries.getSelectedItem()!=null)
		{
			episodios = user.episodiosNoVistosDe(((Serie)jCBSeries.getSelectedItem()));
			String episodiosString[][] =  new String [episodios.size()][5];
			for (int i=0; i<episodios.size(); i++)
				{
					episodiosString[i][0] = episodios.get(i).getEpisodioSerie().getCapitulo()+"";
					episodiosString[i][1] = episodios.get(i).getTemporada()+"";
					episodiosString[i][2] = episodios.get(i).getTitulo();
					episodiosString[i][3] = episodios.get(i).getFecha().toString();
					episodiosString[i][4] = episodios.get(i).getNotaMedia()+"";
					
				}
			TableModel jTableModel = 
					new DefaultTableModel(
							episodiosString,
							new String[] { "Núm.", "Temp.","Titulo","Fecha", "Nota" });
			jTable.setModel(jTableModel);
		}
	}
	
	public Serie getSerieComboBox()
	{
		return (Serie)jCBSeries.getSelectedItem();
	}
	
	public Episodio getEpisodioSelecionadoTabla()
	{
		if (jTable.getSelectedRow()<0)
			return null;
		return episodios.get(jTable.getSelectedRow());
	}

}
