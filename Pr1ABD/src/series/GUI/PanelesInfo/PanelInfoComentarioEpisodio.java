/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI.PanelesInfo;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import series.modelo.ComentarioEpisodio;

@SuppressWarnings("serial")
public class PanelInfoComentarioEpisodio extends javax.swing.JPanel {
	private JLabel jLNombreUser;
	private JLabel jLFecha;
	private JTextArea jTAComentario;
	private ComentarioEpisodio comentario;

	public PanelInfoComentarioEpisodio(ComentarioEpisodio comentario) {
		super();
		this.comentario = comentario;
		initGUI();
	}
	
	private void initGUI() {
			this.setPreferredSize(new java.awt.Dimension(400, 122));
			this.setLayout(null);
			{
				jLNombreUser = new JLabel();
				this.add(jLNombreUser);
				jLNombreUser.setText(comentario.getUsuario());
				jLNombreUser.setBounds(24, 12, 100, 16);
			}
			{
				jLFecha = new JLabel();
				this.add(jLFecha);
				jLFecha.setText(comentario.getFecha().toString());
				jLFecha.setBounds(227, 12, 151, 16);
			}
			{
				jTAComentario = new JTextArea();
				jTAComentario.setEditable(false);
				this.add(jTAComentario);
				jTAComentario.setText(comentario.getComentario());
				jTAComentario.setBounds(24, 40, 354, 70);
			}

	}

}
