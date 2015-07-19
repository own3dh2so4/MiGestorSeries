/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.GregorianCalendar;

import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JFileChooser;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.commons.io.IOUtils;

import series.GUI.ControladorVentanas;
import series.GUI.JOpotiosPanles.VentanaFaltanCampos;
import series.GUI.JOpotiosPanles.VentanaNickExistente;
import series.GUI.JOpotiosPanles.VentanaUsuarioIncorrecto;
import series.modelo.Actor;
import series.modelo.Episodio;
import series.modelo.EpisodioSerie;
import series.modelo.Personaje;
import series.modelo.Serie;
import series.modelo.UserLoged;
import series.modelo.Usuario;

public class ControladorLogin implements ActionListener, FocusListener{
	private UserLoged modelo;
	private String user;
	private String pass;
	private ControladorVentanas vista;
	private Blob imagenUser;
	private String nickUser;
	private String passUser;
	private String diaUser;
	private String mesUser;
	private String anoUser;
	private String nombreSerie;
	private String titularSerie;
	private String sinopsisSerie;
	private String anoEstrenoSerie;
	private String anoFinSerie;
	private String nombreActorNuevo;
	private String diaActorNuevo;
	private String mesActorNuevo;
	private String anoActorNuevo;
	private Blob fotoActorNuevo;
	private String nombreNuevoPersonaje;
	private String descripcionNuevoPersonaje;
	private String tituloNuevoEpisodio;
	private String capituloNuevoEpisodio;
	private String temporadaNuevoEpisodio;
	private String sinopsisNuevoEpisodio;
	private String diaNuevoEpisodio;
	private String mesNuevoEpisodio;
	private String anoNuevoEpisodio;
	private String idSerieNuevoEpisodio;
	
	public ControladorLogin (UserLoged user)
	{
		modelo=user;
	}
	
	public void setVista(ControladorVentanas vis)
	{
		vista=vis;
	}
	
	@Override
	public void focusGained(FocusEvent arg0) {
		tratarEvento(arg0);
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		tratarEvento(arg0);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		tratarEvento(arg0);
		
	}
	
	/**
	 * Convierte el evento en el boton que lo pulso.
	 * @param event -Evento capturado en actionPerformed
	 */
	private void tratarEvento(EventObject event)
	{
		Component fuente = (Component) event.getSource();
        cambiarModelo(fuente);
	}
	
	/**
	 * Trata el modelo segun el boton que se selecioanra en la vista.
	 * @param fuente -Elemento que produjo el evento.
	 */
	private void cambiarModelo(Component fuente) {
		if(fuente.getName().equalsIgnoreCase("BAceptar"))
		{
			if (modelo.usuarioCorrecto(user,pass))
			{
				//vista.ocultaElLogin();
				//ventana.arrancaLaVentanaRegistrado(modelo.getUsuario());
			}
			else 
			{
				@SuppressWarnings("unused")
				VentanaUsuarioIncorrecto malUsuario = new VentanaUsuarioIncorrecto();
			}
		}
		else if (fuente.getName().equalsIgnoreCase("JTUsuario"))
		{
			JTextField use= (JTextField)fuente;
			user=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTContrasena"))
		{
			JPasswordField pas= (JPasswordField)fuente;
			pass=new String(pas.getPassword());
		}
		else if (fuente.getName().equalsIgnoreCase("BNewUsuario"))
		{
			vista.arrancaVentanaNuevoUsuario();
		}
		else if (fuente.getName().equalsIgnoreCase("JBAvatar"))
		{
			JFileChooser jf = new JFileChooser();
			if (jf.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
			{
				File f = jf.getSelectedFile();
				try {
					FileInputStream is = new FileInputStream(f);
					byte[] cadenaBytes =IOUtils.toByteArray(is);
					imagenUser= new SerialBlob(cadenaBytes);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {		
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		else if (fuente.getName().equalsIgnoreCase("JBCancelar"))
		{
			vista.cerrarVentanaNuevoUsuario();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFNombre"))
		{
			JTextField use= (JTextField)fuente;
			nickUser=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFPass"))
		{
			JPasswordField pas= (JPasswordField)fuente;
			passUser=new String(pas.getPassword());
		}
		else if (fuente.getName().equalsIgnoreCase("JTFFechaDia"))
		{
			JTextField use= (JTextField)fuente;
			diaUser=use.getText();
			/*if(Integer.parseInt(diaUser)>31 || Integer.parseInt(diaUser)<1)
			{
				diaUser=null;
			}*/
		}
		else if (fuente.getName().equalsIgnoreCase("JTFFechaMes"))
		{
			JTextField use= (JTextField)fuente;
			mesUser=use.getText();
			/*if(Integer.parseInt(mesUser)>12 || Integer.parseInt(mesUser)<1)
			{
				mesUser=null;
			}*/
		}
		else if (fuente.getName().equalsIgnoreCase("JTFFechaAno"))
		{
			JTextField use= (JTextField)fuente;
			anoUser=use.getText();
			/*if(Integer.parseInt(anoUser)>2014 || Integer.parseInt(anoUser)<1900)
			{
				anoUser=null;
			}*/
		}
		else if (fuente.getName().equalsIgnoreCase("JBAceptar"))
		{
			Usuario usuarioAgregar;
			if (nickUser==null || passUser == null || diaUser == null
					|| mesUser == null || anoUser == null )
			{
				@SuppressWarnings("unused")
				VentanaFaltanCampos faltanCampos = new VentanaFaltanCampos();
			}
			else
			{
				GregorianCalendar fecha1 = new GregorianCalendar(Integer.parseInt(anoUser), Integer.parseInt(mesUser), Integer.parseInt(diaUser));
				Date fecha = new Date(fecha1.getTime().getTime());
				usuarioAgregar = new Usuario(nickUser, passUser, fecha, imagenUser);
				if(modelo.usuarioRegistrado())
				{
					if (modelo.modificaUsuario(usuarioAgregar))
					{
						vista.cerrarVentanaNuevoUsuario();
					}
					else
					{
						@SuppressWarnings("unused")
						VentanaNickExistente nikcOcupado = new VentanaNickExistente();
					}
				}
				else
				{
					if	(!modelo.agregarUsuarioNuevo(usuarioAgregar))
					{
						@SuppressWarnings("unused")
						VentanaNickExistente nikcOcupado = new VentanaNickExistente();
					}
					else
						{
							vista.cerrarVentanaNuevoUsuario();
						}
				}
			}
		}
		else if (fuente.getName().equalsIgnoreCase("BCancelar"))
		{
			System.exit(0);
		}
		else if (fuente.getName().equalsIgnoreCase("JTFNombreSerie"))
		{
			JTextField use= (JTextField)fuente;
			nombreSerie=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFTitular"))
		{
			JTextField use= (JTextField)fuente;
			titularSerie=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFSinopsis"))
		{
			JTextArea use= (JTextArea)fuente;
			sinopsisSerie=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFAnoEstreno"))
		{
			JTextField use= (JTextField)fuente;
			anoEstrenoSerie=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFAnoFin"))
		{
			JTextField use= (JTextField)fuente;
			anoFinSerie=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JBAnadir"))
		{
			if (nombreSerie!=null && titularSerie!=null && sinopsisSerie!=null && anoEstrenoSerie!=null)
			{
				Serie ser=null;
				if (anoFinSerie==null)
					ser= new Serie( nombreSerie, titularSerie, sinopsisSerie, Integer.parseInt(anoEstrenoSerie));
				else
					ser= new Serie( nombreSerie, titularSerie, sinopsisSerie, Integer.parseInt(anoEstrenoSerie), Integer.parseInt(anoFinSerie));
				if(modelo.anadirSerie(ser))
					vista.cerrarVentanaNuevaSerie();
			}
			else
			{
				@SuppressWarnings("unused")
				VentanaFaltanCampos faltanCampos = new VentanaFaltanCampos();
			}
		}
		else if (fuente.getName().equalsIgnoreCase("JBCancelarNuevaSerie"))
		{
			vista.cerrarVentanaNuevaSerie();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFNombreActorNuevo"))
		{
			JTextField use= (JTextField)fuente;
			nombreActorNuevo=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFDiaActorNuevo"))
		{
			JTextField use= (JTextField)fuente;
			diaActorNuevo=use.getText();
			
		}
		else if (fuente.getName().equalsIgnoreCase("JTFMesActorNuevo"))
		{
			JTextField use= (JTextField)fuente;
			mesActorNuevo=use.getText();
			
		}
		else if (fuente.getName().equalsIgnoreCase("JTFAnoActorNuevo"))
		{
			JTextField use= (JTextField)fuente;
			anoActorNuevo=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JBBuscarFotoActorNuevo"))
		{
			JFileChooser jf = new JFileChooser();
			if (jf.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
			{
				File f = jf.getSelectedFile();
				try {
					FileInputStream is = new FileInputStream(f);
					byte[] cadenaBytes =IOUtils.toByteArray(is);
					fotoActorNuevo= new SerialBlob(cadenaBytes);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {		
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		else if (fuente.getName().equalsIgnoreCase("JBAceptarActorNuevo"))
		{

			if (nombreActorNuevo!=null && diaActorNuevo!=null && mesActorNuevo!=null && mesActorNuevo!=null)
			{
				Actor actorAnadir=null;
				GregorianCalendar fechaAux = new GregorianCalendar(Integer.parseInt(anoActorNuevo), Integer.parseInt(mesActorNuevo), Integer.parseInt(diaActorNuevo));
				Date fecha = new Date(fechaAux.getTime().getTime());
				if (fotoActorNuevo==null)
					actorAnadir= new Actor(nombreActorNuevo, fecha);
				else
					actorAnadir= new Actor(nombreActorNuevo, fecha, fotoActorNuevo);
				if(modelo.anadirActor(actorAnadir))
					vista.cerrarVentanaNuevaActor();
			}
			else
			{
				@SuppressWarnings("unused")
				VentanaFaltanCampos faltanCampos = new VentanaFaltanCampos();
			}
		}
		else if (fuente.getName().equalsIgnoreCase("JTFNombreNuevoPersonaje"))
		{
			JTextField use= (JTextField)fuente;
			nombreNuevoPersonaje=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFDescripcionNuevoPersonaje"))
		{
			JTextArea use= (JTextArea)fuente;
			descripcionNuevoPersonaje =use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JBCancelarNuevoPersonaje"))
		{
			vista.cerrarVentanaNuevoPersonaje();
		}
		else if (fuente.getName().equalsIgnoreCase("JBAceptarNuevoPerosnaje"))
		{

			if (nombreNuevoPersonaje!=null && descripcionNuevoPersonaje!=null)
			{
				Personaje perAnadir=new Personaje(nombreNuevoPersonaje, descripcionNuevoPersonaje);
				if(modelo.anadirPersonaje(perAnadir))
					vista.cerrarVentanaNuevoPersonaje();
			}
			else
			{
				@SuppressWarnings("unused")
				VentanaFaltanCampos faltanCampos = new VentanaFaltanCampos();
			}
		}
		else if (fuente.getName().equalsIgnoreCase("JTFTItuloNuevoEpisodio"))
		{
			JTextField use= (JTextField)fuente;
			tituloNuevoEpisodio =use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFCapituloNuevoEpisodio"))
		{
			JTextField use= (JTextField)fuente;
			capituloNuevoEpisodio =use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFTemporadaNuevoEpisodio"))
		{
			JTextField use= (JTextField)fuente;
			temporadaNuevoEpisodio =use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTASinopsisCNuevoCapitulo"))
		{
			JTextArea use= (JTextArea)fuente;
			sinopsisNuevoEpisodio =use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFDiaNuevoEpisodio"))
		{
			JTextField use= (JTextField)fuente;
			diaNuevoEpisodio =use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFMesNuevoEpisodio"))
		{
			JTextField use= (JTextField)fuente;
			mesNuevoEpisodio =use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFAnoNuevoEpisodio"))
		{
			JTextField use= (JTextField)fuente;
			anoNuevoEpisodio =use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFIdSerieNuevoEpisodio"))
		{
			JTextField use= (JTextField)fuente;
			idSerieNuevoEpisodio =use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JBAceptarNuevoEpisodio"))
		{
			if(tituloNuevoEpisodio!=null && capituloNuevoEpisodio!=null && temporadaNuevoEpisodio!=null  && sinopsisNuevoEpisodio!=null
					&& diaNuevoEpisodio!=null && mesNuevoEpisodio!=null && anoNuevoEpisodio!=null && idSerieNuevoEpisodio!=null)
			{
				GregorianCalendar fechaAux = new GregorianCalendar(Integer.parseInt(anoNuevoEpisodio), Integer.parseInt(mesNuevoEpisodio), Integer.parseInt(diaNuevoEpisodio));
				Date fecha = new Date(fechaAux.getTime().getTime());
				EpisodioSerie episodioSerie = new EpisodioSerie(Integer.parseInt(capituloNuevoEpisodio), Integer.parseInt(idSerieNuevoEpisodio));
				Episodio episodio = new Episodio(tituloNuevoEpisodio, episodioSerie, Integer.parseInt(temporadaNuevoEpisodio), sinopsisNuevoEpisodio, fecha);
				modelo.addEpisodio(episodio);
				vista.cerrarVentanaNuevoEpisodio();
			}
		}
	}

}
