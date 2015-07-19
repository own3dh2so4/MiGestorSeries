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

import series.modelo.ComentarioSerie;

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
public class PanelInfoComentarioSerie extends javax.swing.JPanel {
	private JLabel jLNombreUser;
	private JLabel jLFecha;
	private JTextArea jTAComentario;
	private ComentarioSerie comentario;

	public PanelInfoComentarioSerie(ComentarioSerie comentario) {
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
