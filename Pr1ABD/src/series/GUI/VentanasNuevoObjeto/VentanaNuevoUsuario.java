/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI.VentanasNuevoObjeto;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.EventListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import series.GUI.VistaInterfaz;

@SuppressWarnings("serial")
public class VentanaNuevoUsuario extends JFrame implements VistaInterfaz{

	private JPanel panel;
	private JPanel panelFecha;
	private JLabel jlNombre;
	private JTextField jtfNombre;
	private JLabel jlPass;
	private JPasswordField jtfPass;
	private JLabel jlFecha;
	private JTextField jtfFechaDia;
	private JTextField jtfFechaMes;
	private JTextField jtfFechaAno;
	private  JLabel jlAvatar;
	private JButton jbAvatar;
	private JButton jbAceptar;
	private JButton jbCancelar;
	
	public VentanaNuevoUsuario()
	{
		super("Usuario");
		inicializaVentanaNuevaSerie();
	}
	
	private void inicializaVentanaNuevaSerie() {
		panel = new JPanel();
		panelFecha = new JPanel();
		jlNombre = new JLabel("Escribe tu nick");
		jtfNombre = new JTextField();
		jlPass = new JLabel("Escribe tu contraseña");
		jtfPass = new JPasswordField();
		jlFecha = new JLabel("Fecha de nacimiento");
		jtfFechaDia = new JTextField();
		jtfFechaMes = new JTextField();
		jtfFechaAno = new JTextField();
		jlAvatar = new JLabel("Avatar");
		jbAvatar = new JButton("Buscar");
		jbAceptar = new JButton("Aceptar");
		jbCancelar = new JButton("Cancelar");
		
		jtfNombre.setName("JTFNombre");
		jtfPass.setName("JTFPass");
		jtfFechaDia.setName("JTFFechaDia");
		jtfFechaMes.setName("JTFFechaMes");
		jtfFechaAno.setName("JTFFechaAno");
		jbAvatar.setName("JBAvatar");
		jbAceptar.setName("JBAceptar");
		jbCancelar.setName("JBCancelar");
		
		LayoutManager layaout = new GridLayout(5,2);
		LayoutManager lay = new GridLayout(1,3);
		panel.setLayout(layaout);
		panel.add(jlNombre);
		panel.add(jtfNombre);
		panel.add(jlPass);
		panel.add(jtfPass);
		panel.add(jlFecha);
		panel.add(panelFecha);
		panelFecha.setLayout(lay);
		panelFecha.add(jtfFechaDia);
		panelFecha.add(jtfFechaMes);
		panelFecha.add(jtfFechaAno);
		panel.add(jlAvatar);
		panel.add(jbAvatar);
		panel.add(jbAceptar);
		panel.add(jbCancelar);
		
		jtfFechaAno.addKeyListener(new KeyAdapter()
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
		
		jtfFechaDia.addKeyListener(new KeyAdapter()
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
		
		jtfFechaMes.addKeyListener(new KeyAdapter()
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
		
		add(panel);
		pack();
		setLocationRelativeTo(null);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

	@Override
	public void fijarControlador(EventListener controlador) {
		jtfNombre.addFocusListener((FocusListener)controlador);
		jtfFechaAno.addFocusListener((FocusListener)controlador);
		jtfFechaDia.addFocusListener((FocusListener)controlador);
		jtfFechaMes.addFocusListener((FocusListener)controlador);
		jtfPass.addFocusListener((FocusListener)controlador);
		
		jbAvatar.addActionListener((ActionListener)controlador);
		jbAceptar.addActionListener((ActionListener)controlador);
		jbCancelar.addActionListener((ActionListener)controlador);
		
	}
	
	public void cerrarVentana()
	{
		dispose();
	}
	
	public void empieza()
	{
		EventQueue.invokeLater(new Runnable(){
	    	public void run() {
	    		setVisible(true);
	    	}
	    });	
	}

}
