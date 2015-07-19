/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.EventListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import series.modelo.UserLoged;

@SuppressWarnings("serial")
public class VentanaLogin extends JFrame implements VistaInterfaz{
	
	private JPanel panel;
	private JPanel panelBotones;
	private JPanel panelUsuario;
	private JPanel panelContrasena;
	private JTextField jtfUsuario;
	private JTextField jtfContrasena;
	private JLabel jlUsuario;
	private JLabel jlContrasena;
	private JButton aceptar;
	private JButton cancelar;
	private JButton newUser;
	
	/**
	 * Constructor por defecto.
	 */
	public VentanaLogin()
	{
		inicializaVentanaLogin();
	}
	
	
	/**
	 * Metodo privado que inicializa la venta del  login.
	 */
	private void inicializaVentanaLogin()
	{
		panel= new JPanel();
		panelBotones = new JPanel();
		panelUsuario = new JPanel();
		panelContrasena = new JPanel();
		jtfUsuario = new JTextField();
		jtfContrasena = new JPasswordField();
		jlUsuario = new JLabel();
		jlContrasena = new JLabel();
		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");
		newUser = new JButton("Nuevo Usuario");
		jlUsuario.setText("Usuario");
		jlContrasena.setText("Contraseña");
		panel.setSize(600,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Damos nombre a los botones para facilitar el controlador
		newUser.setName("BNewUsuario");
		aceptar.setName("BAceptar");
		cancelar.setName("BCancelar"); 
		jtfUsuario.setName("JTUsuario");
		jtfContrasena.setName("JTContrasena");
		
		
		//Ponemos color blanco a los JTextField
		jtfUsuario.setBackground(Color.WHITE);
		jtfContrasena.setBackground(Color.WHITE);
		
		
		//Vamos a insertar los botones en su panel.
		LayoutManager elLayoutDelPanelBotones = new BorderLayout();
		panelBotones.setLayout(elLayoutDelPanelBotones);
		panelBotones.add(aceptar,BorderLayout.WEST);
		panelBotones.add(cancelar, BorderLayout.EAST);
		panelBotones.add(newUser, BorderLayout.CENTER);
		
		
		//Vamos a insertar en el JPanel de usuario y contraseña
		LayoutManager elLayoutDelPanelUsuario = new GridLayout(3,1);
		panelUsuario.setLayout(elLayoutDelPanelUsuario);
		jlUsuario.setHorizontalAlignment( SwingConstants.CENTER );
		jtfUsuario.setHorizontalAlignment( SwingConstants.CENTER );
		jtfUsuario.setSize(new Dimension(15, 15));
		panelUsuario.add(new JPanel());
		panelUsuario.add(jlUsuario);
		panelUsuario.add(jtfUsuario);
		
		LayoutManager elLayoutDelPanelContrasena = new BorderLayout();
		jlContrasena.setHorizontalAlignment( SwingConstants.CENTER );
		jtfContrasena.setHorizontalAlignment( SwingConstants.CENTER );
		panelContrasena.setLayout(elLayoutDelPanelContrasena);
		panelContrasena.add(jlContrasena, BorderLayout.NORTH);
		panelContrasena.add(new JPanel(),BorderLayout.CENTER);
		panelContrasena.add(jtfContrasena, BorderLayout.SOUTH);
		
		
		
		//Vamos a insertar los elementos en el JPanel
		LayoutManager elLayoutDelPanel = new BorderLayout();
		JPanel paneltexto = new JPanel( new BorderLayout());
		paneltexto.add(new JPanel(), BorderLayout.CENTER);
		paneltexto.add(panelUsuario, BorderLayout.NORTH);
		paneltexto.add(panelContrasena, BorderLayout.SOUTH);
		JPanel panellogin = new JPanel(new GridLayout(1,10));
		panellogin.add(new JPanel());
		panellogin.add(paneltexto);
		panellogin.add(new JPanel());
		panel.setLayout(elLayoutDelPanel);
		panel.add(panellogin,BorderLayout.NORTH);
		panel.add(panelBotones,BorderLayout.SOUTH);
		this.setTitle("Inicio de sesión");
		this.add(panel);
		this.pack();
		this.setSize(300,200);
		setLocationRelativeTo(null);
		this.setResizable(false);
		
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
	
	
	/**
	 * Método que recoge el usuario que se ha escrito.
	 * @return el usuario introducido.
	 */
	public String leerElUsuario()
	{
		return jtfUsuario.getText();
	}
	
	
	/**
	 * Función que accede a la contraseña introducida.
	 * @return la contraseña que se ha escrito.
	 */
	public String leerLaContrasena()
	{
		return jtfContrasena.getText();
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		if(((UserLoged)arg0).usuarioRegistrado())
			setVisible(false);
		else
			{
				jtfContrasena.setText("");
				setVisible(true);
			}	
	}


	@Override
	public void fijarControlador(EventListener controlador) {
		jtfUsuario.addFocusListener((FocusListener)controlador);
		jtfContrasena.addFocusListener((FocusListener)controlador);
		
		aceptar.addActionListener((ActionListener)controlador);
		cancelar.addActionListener((ActionListener)controlador);
		newUser.addActionListener((ActionListener)controlador);
		
	}
	
}
