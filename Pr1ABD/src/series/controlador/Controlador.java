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
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JFileChooser;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.commons.io.IOUtils;

import series.GUI.ControladorVentanas;
import series.GUI.JOpotiosPanles.VentanaNoSeries;
import series.modelo.Actor;
import series.modelo.Episodio;
import series.modelo.EpisodioSerie;
import series.modelo.Genero;
import series.modelo.Personaje;
import series.modelo.Serie;
import series.modelo.UserLoged;

public class Controlador implements ActionListener, FocusListener, ChangeListener {

	private UserLoged modelo;
	private ControladorVentanas vista;
	private String serieBuscar;
	private String actorBuscar;
	private String tituloEditadoSerie;
	private String titularEditadoSerie;
	private String sinopsisEditadaSerie;
	private int idSerieEditada;
	private int anoInicioSerieEditada;
	private int anoFinSerieEditada;
	private String nombreActorEditado;
	private int diaActorEditado;
	private int mesActorEditado;
	private int anoActorEditado;
	private Blob fotoActorEditado;
	private int idActorEditado;
	private String nombrePersonajeBuscar;
	private int idPersonajeEditado;
	private String nombrePersonajeEditado;
	private String descripcionPersonajeEditado;
	private String generoABuscar;
	private String generoAAnadir;
	private String episodioBuscar;
	private String tituloEpisodioEditar;
	private int capitloEpisodioEditar;
	private int temporadaEpisodioEditar;
	private String sinopsisEpisodioEditar;
	private int diaEpisodioEditar;
	private int mesepisodioEditar;
	private int anoEpisodioEditar;
	private int IdSerieEpisodioEditar;
	private Episodio episodioEditar;
	private int notaAPoner=5; //Nota por defecto
	private int notaAPonerEpisodio=5; //Nota por defecto
	private String comentarioAnadirSerie;
	private String comentarioAnadirEpisodioe;
	private String nombreUsuarioComentario;
	
	public Controlador (UserLoged user)
	{
		modelo=user;
	}
	
	public void setVista(ControladorVentanas ventanas)
	{
		vista=ventanas;
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		tratarEvento(e);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		tratarEvento(e);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		tratarEvento(arg0);
		
	}

	private void tratarEvento(EventObject e) {
		Component fuente = (Component) e.getSource();
        cambiarModelo(fuente);
		
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0) {
		tratarEvento(arg0);
	}

	@SuppressWarnings("deprecation")
	private void cambiarModelo(Component fuente) {
		if (fuente.getName().equalsIgnoreCase("JTFEscribe"))
		{
			JTextField bus= (JTextField)fuente;
			serieBuscar=bus.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JBBusca")){
			if (!modelo.bucarSeries(serieBuscar))
			{
				@SuppressWarnings("unused")
				VentanaNoSeries noSeries = new VentanaNoSeries();
			}
		}
		else if(fuente.getName().equalsIgnoreCase("JBComentarSeriePrincipal"))
		{
			Serie serie =vista.getSerieSelecionada();
			if (serie!=null)
				vista.arrancaVentanaComentaSerie(serie);
		}
		else if(fuente.getName().equalsIgnoreCase("JBVerInformacion"))
		{
			
			Serie serie =vista.getSerieSelecionada();
			if (serie!=null)
				{
					vista.arrancaVentanaInfoSerie(serie, modelo.getIsAdmin());
					vista.arrancaVentanaInfoComentarioSerie(serie);
				}
		}
		else if(fuente.getName().equalsIgnoreCase("JBVerInformacionAdmin"))
		{
			Serie serie = vista.getSerieSelecionadaAdmin();
			if (serie!=null)
				{
					titularEditadoSerie=serie.getTitular();
					tituloEditadoSerie=serie.getNombre();
					sinopsisEditadaSerie=serie.getSinopsis();
					idSerieEditada= serie.getId();
					anoInicioSerieEditada = serie.getAnoEstreno();
					anoFinSerieEditada = serie.getAnoFin();
					vista.arrancaVentanaInfoSerie(serie, modelo.getIsAdmin());
				}
		}
		else if (fuente.getName().equalsIgnoreCase("JBSeguirSerie"))
		{
			Serie serie =vista.getSerieSelecionada();
			modelo.seguirSerie(serie);
			vista.cerrarVentanaInfoSerie();
			
			
		}else if (fuente.getName().equalsIgnoreCase("JBCerrar"))
		{
			if (modelo.getIsAdmin())
			{
				Serie serieNueva = new Serie ( idSerieEditada,tituloEditadoSerie,titularEditadoSerie,sinopsisEditadaSerie,
											anoInicioSerieEditada,anoFinSerieEditada);
				modelo.editarSerie(vista.getSerieSelecionadaAdmin(),serieNueva );
			}
			vista.cerrarVentanaInfoSerie();
		}
		else if(fuente.getName().equalsIgnoreCase("VPPSFPanelFoto"))
		{
			vista.arrancaVentanaNuevoUsuario();
		}
		else if(fuente.getName().equalsIgnoreCase("JBNuevaSerie"))
		{
			vista.arrancaVentanaNuevaSerie();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFNombreBuscarActor"))
		{
			JTextField bus= (JTextField)fuente;
			actorBuscar=bus.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JBBuscarActor")){
			if (!modelo.bucarActor(actorBuscar))
			{
				@SuppressWarnings("unused")
				VentanaNoSeries noSeries = new VentanaNoSeries();
			}
		}
		else if(fuente.getName().equalsIgnoreCase("JBNuevoActor"))
		{
			vista.arrancaVentanaNuevoActor();
		}
		else if(fuente.getName().equalsIgnoreCase("JBVerInformacionActor"))
		{
			Object actor =vista.getActorSelecionadoAdmin();
			Actor actorSelecionado = (Actor)actor;
			if (actorSelecionado!=null)
				{
					idActorEditado=actorSelecionado.getId();
					nombreActorEditado=actorSelecionado.getNombre();
					diaActorEditado=actorSelecionado.getNacio().getDay();
					mesActorEditado=actorSelecionado.getNacio().getMonth();
					anoActorEditado= actorSelecionado.getNacio().getYear();
					fotoActorEditado=actorSelecionado.getFoto();
					vista.arrancaVentanaInfoActor(actorSelecionado,modelo.getIsAdmin());
				}
		}
		else if (fuente.getName().equalsIgnoreCase("JTFTituloSerieEditado"))
		{
			JTextField use= (JTextField)fuente;
			tituloEditadoSerie=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFTitularSerieEditado"))
		{
			JTextField use= (JTextField)fuente;
			titularEditadoSerie=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFSinopsisSerieEditado"))
		{
			JTextArea use= (JTextArea)fuente;
			sinopsisEditadaSerie=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFAnoFinSerieEditado"))
		{
			JTextField use= (JTextField)fuente;
			anoFinSerieEditada=Integer.parseInt(use.getText());
		}
		else if (fuente.getName().equalsIgnoreCase("JTFAnoInicioSerieEditado"))
		{
			JTextField use= (JTextField)fuente;
			anoInicioSerieEditada=Integer.parseInt(use.getText());
		}
		else if (fuente.getName().equalsIgnoreCase("JTFNombreVentanInfoActor"))
		{
			JTextField use= (JTextField)fuente;
			nombreActorEditado=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFDiaVentanaInfoActor"))
		{
			JTextField use= (JTextField)fuente;
			diaActorEditado=Integer.parseInt(use.getText());
		}
		else if (fuente.getName().equalsIgnoreCase("JTFMesVentanaInfoActor"))
		{
			JTextField use= (JTextField)fuente;
			mesActorEditado=Integer.parseInt(use.getText());
		}
		else if (fuente.getName().equalsIgnoreCase("JTFAnoVentanaInfoActor"))
		{
			JTextField use= (JTextField)fuente;
			anoActorEditado=Integer.parseInt(use.getText());
		}
		else if (fuente.getName().equalsIgnoreCase("JBFotoVentanaInfoActor"))
		{
			JFileChooser jf = new JFileChooser();
			if (jf.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
			{
				File f = jf.getSelectedFile();
				try {
					FileInputStream is = new FileInputStream(f);
					byte[] cadenaBytes =IOUtils.toByteArray(is);
					fotoActorEditado= new SerialBlob(cadenaBytes);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {		
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		else if (fuente.getName().equalsIgnoreCase("JBAceptarVentanaInfoActor"))
		{
			if (modelo.getIsAdmin())
			{
				GregorianCalendar fecha1 = new GregorianCalendar(anoActorEditado, mesActorEditado, diaActorEditado);
				Date fecha = new Date(fecha1.getTime().getTime());
				Actor actorNuevo = new Actor (idActorEditado,nombreActorEditado,fecha,fotoActorEditado);
				modelo.editarActor(vista.getActorSelecionadoAdmin(),actorNuevo );
			}
			vista.cerrarVentanaInfoActor();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFBuscarPersonaje"))
		{
			JTextField use= (JTextField)fuente;
			nombrePersonajeBuscar=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JBBuscarPersonaje")){
			if (!modelo.bucarPersonaje(nombrePersonajeBuscar))
			{
				@SuppressWarnings("unused")
				VentanaNoSeries noSeries = new VentanaNoSeries();
			}
		}
		
		else if(fuente.getName().equalsIgnoreCase("JBVerInformacionPersonaje"))
		{
			Personaje personajeSelecionado = vista.getPersonajeSelecionadoAdmin();
			if (personajeSelecionado!=null)
				{
					idPersonajeEditado = personajeSelecionado.getId();
					nombrePersonajeEditado = personajeSelecionado.getNombre();
					descripcionPersonajeEditado = personajeSelecionado.getDescripcion();
					vista.arrancaVentanaInfoPersonaje(personajeSelecionado,modelo.getIsAdmin());
				}
		}
		else if (fuente.getName().equalsIgnoreCase("JTFNombrePersonajeEditar"))
		{
			JTextField use= (JTextField)fuente;
			nombrePersonajeEditado=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFDescripcionPersonajeEditar"))
		{
			JTextArea use= (JTextArea)fuente;
			descripcionPersonajeEditado=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JBAceptarVentanaInfoPerosnaje"))
		{
			if (modelo.getIsAdmin())
			{
				Personaje p = new Personaje(idPersonajeEditado, nombrePersonajeEditado, descripcionPersonajeEditado);
				modelo.editarPersonaje(vista.getPersonajeSelecionadoAdmin(),p );
			}
			vista.cerrarVentanaInfoPersonaje();
		}
		else if(fuente.getName().equalsIgnoreCase("JBNuevoPersonaje"))
		{
			vista.arrancaVentanaNuevoPersonaje();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFBuscarGenero"))
		{
			JTextField use= (JTextField)fuente;
			generoABuscar=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JBBuscarGenero"))
		{
			if (generoABuscar!=null)
				modelo.buscarGenero(generoABuscar);
		}
		else if (fuente.getName().equalsIgnoreCase("JTFAnadeGenero"))
		{
			JTextField use= (JTextField)fuente;
			generoAAnadir=use.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JBAnadeGenero"))
		{
			if (generoAAnadir!=null)
				modelo.anadirGenero(new Genero(generoAAnadir));
		}
		else if (fuente.getName().equalsIgnoreCase("JBAsignarGeneroASerie"))
		{
			Serie serie = (Serie) vista.getSelecionadoSerieDeGeneroSerie();
			List<Object> genero = vista.getSelecionadoGeneroDeGeneroSerie();
			if (serie != null  && genero!=null)
			{
				for (int i=0; i<genero.size(); i++)
					modelo.agregarGeneroASerie(serie,(Genero) genero.get(i));
			}
			
		}
		else if (fuente.getName().equalsIgnoreCase("JBEliminarGeneroASerie"))
		{
			Serie serie = (Serie) vista.getSelecionadoSerieDeGeneroSerie();
			List<Object> genero = vista.getSelecionadoGeneroDeGeneroSerie();
			if (serie != null  && genero!=null)
			{
				for (int i=0; i<genero.size(); i++)
					modelo.eliminarGeneroASerie(serie,(Genero) genero.get(i));
			}
			
		}		
		else if (fuente.getName().equalsIgnoreCase("JBInformacionEpisodio"))
		{
			if (vista.getEpisodioSelecionadoTabla()!=null)
				{
					vista.arrancaVentanaInfoEpisodio(vista.getEpisodioSelecionadoTabla(),modelo.getIsAdmin());
					vista.arracaVentanaInfoTablaActoresPersonajes(vista.getEpisodioSelecionadoTabla(), modelo.getIsAdmin());
					vista.arrancaVentanaInfoComentarioEpisodio(vista.getEpisodioSelecionadoTabla());
				}
		}
		else if (fuente.getName().equalsIgnoreCase("JBMarcarComoVisto"))
		{
			if (vista.getEpisodioSelecionadoTabla()!=null)
			{
				modelo.marcarEpisodioComoVisto(vista.getEpisodioSelecionadoTabla());
			}
			else if (vista.dameEpisodioVentanaInfo()!=null)
			{
				modelo.marcarEpisodioComoVisto(vista.dameEpisodioVentanaInfo());
				vista.cerrarVentanaInfoEpisodio();
			}
		}
		else if (fuente.getName().equalsIgnoreCase("JBMarcarComoNoVisto"))
		{
			if (vista.dameEpisodioVentanaInfo()!=null)
			{
				modelo.marcarEpisodioComoNoVisto(vista.dameEpisodioVentanaInfo());
				vista.cerrarVentanaInfoEpisodio();
			}
		}
		else if (fuente.getName().equalsIgnoreCase("JBEpisodiosVentanaInfoSeries"))
		{
			/*Object ser =vista.getVentanaPrincipal().getPanelInferior().getPanel1().getListaSeries().getJList().getSelectedValue();
			Serie serie = (Serie)ser;*/
			Serie serie = vista.getSerieSelecionada();
			if (serie == null)
				serie= vista.getSerieSelecionadaAdmin();
			vista.arrancaVentanaInfoTablaEpisodios(serie.getEpisodios());
		}
		else if (fuente.getName().equalsIgnoreCase("JBInfomacionVentanaInfoTalaEpisodios"))
		{
			if (vista.getEpisodioSelecionadoTablaInfoEpisodios()!=null)
				{
					vista.arrancaVentanaInfoEpisodio(vista.getEpisodioSelecionadoTablaInfoEpisodios(),modelo.getIsAdmin());
					vista.arracaVentanaInfoTablaActoresPersonajes(vista.getEpisodioSelecionadoTablaInfoEpisodios(),modelo.getIsAdmin());
					vista.arrancaVentanaInfoComentarioEpisodio(vista.getEpisodioSelecionadoTablaInfoEpisodios());
				}
		}
		else if (fuente.getName().equalsIgnoreCase("JButonAceptarInfoEpisodio"))
		{
			if(modelo.getIsAdmin())
			{
				GregorianCalendar fechaAux = new GregorianCalendar(anoEpisodioEditar, mesepisodioEditar, diaEpisodioEditar);
				Date fecha = new Date(fechaAux.getTime().getTime());
				EpisodioSerie es = new EpisodioSerie(capitloEpisodioEditar, IdSerieEpisodioEditar);
				Episodio episodioEditado = new Episodio(tituloEpisodioEditar, es, temporadaEpisodioEditar, sinopsisEpisodioEditar, fecha);
				modelo.editarEpisodio(episodioEditado, episodioEditar);
			}
			vista.cerrarVentanaInfoEpisodio();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFCapituloEpisodioBuscar"))
		{
			JTextField bus= (JTextField)fuente;
			episodioBuscar=bus.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JBBuscarEpisodio"))
		{
			if(serieBuscar==null)
				serieBuscar="";
			if (episodioBuscar==null || episodioBuscar.equalsIgnoreCase(""))
				episodioBuscar="0";
			modelo.buscarEpisodioDeSerie(serieBuscar,Integer.parseInt(episodioBuscar));
		}
		else if (fuente.getName().equalsIgnoreCase("JBBorrarEpisodio"))
		{
			if(!vista.getListEpisodios().isEmpty())
				modelo.borrarEpisodios(vista.getListEpisodios());
		}
		else if (fuente.getName().equalsIgnoreCase("JBInformacionEpisodioAdmin"))
		{
			if(!vista.getListEpisodios().isEmpty())
				{
					episodioEditar =  ((Episodio) vista.getListEpisodios().get(0));
					tituloEpisodioEditar = ((Episodio) vista.getListEpisodios().get(0)).getTitulo();
					capitloEpisodioEditar =  ((Episodio) vista.getListEpisodios().get(0)).getEpisodioSerie().getCapitulo();
					temporadaEpisodioEditar =  ((Episodio) vista.getListEpisodios().get(0)).getTemporada();
					sinopsisEpisodioEditar =  ((Episodio) vista.getListEpisodios().get(0)).getSinopsis();
					diaEpisodioEditar =  ((Episodio) vista.getListEpisodios().get(0)).getFecha().getDay();
					mesepisodioEditar =  ((Episodio) vista.getListEpisodios().get(0)).getFecha().getMonth();
					anoEpisodioEditar =  ((Episodio) vista.getListEpisodios().get(0)).getFecha().getYear();
					IdSerieEpisodioEditar =  ((Episodio) vista.getListEpisodios().get(0)).getEpisodioSerie().getIdSerie();
					
					vista.arrancaVentanaInfoEpisodio((Episodio) vista.getListEpisodios().get(0), modelo.getIsAdmin());
				}
		}
		else if (fuente.getName().equalsIgnoreCase("JBNuevoEpisodio"))
		{
			vista.arrancaVentanaNuevoEpisodio();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFTituloEpisodio"))
		{
			JTextField bus= (JTextField)fuente;
			tituloEpisodioEditar=bus.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFCapituloEpisodio"))
		{
			JTextField bus= (JTextField)fuente;
			if (!bus.getText().equalsIgnoreCase(""))
				capitloEpisodioEditar=Integer.parseInt(bus.getText());
		}
		else if (fuente.getName().equalsIgnoreCase("JTFTemporadaEpisodio"))
		{
			JTextField bus= (JTextField)fuente;
			if (!bus.getText().equalsIgnoreCase(""))
				temporadaEpisodioEditar=Integer.parseInt(bus.getText());
		}
		else if (fuente.getName().equalsIgnoreCase("JTASinopsisEpisodio"))
		{
			JTextArea bus= (JTextArea)fuente;
			sinopsisEpisodioEditar=bus.getText();
		}
		else if (fuente.getName().equalsIgnoreCase("JTFDiaEpisodio"))
		{
			JTextField bus= (JTextField)fuente;
			if (!bus.getText().equalsIgnoreCase(""))
				diaEpisodioEditar=Integer.parseInt(bus.getText());
		}
		else if (fuente.getName().equalsIgnoreCase("JTFMesEpisodio"))
		{
			JTextField bus= (JTextField)fuente;
			if (!bus.getText().equalsIgnoreCase(""))
				mesepisodioEditar=Integer.parseInt(bus.getText());
		}
		else if (fuente.getName().equalsIgnoreCase("JTFAnoEpisodio"))
		{
			JTextField bus= (JTextField)fuente;
			if (!bus.getText().equalsIgnoreCase(""))
				anoEpisodioEditar=Integer.parseInt(bus.getText());
		}
		else if (fuente.getName().equalsIgnoreCase("JTFIdSerieEpisodio"))
		{
			JTextField bus= (JTextField)fuente;
			if (!bus.getText().equalsIgnoreCase(""))
				IdSerieEpisodioEditar=Integer.parseInt(bus.getText());
		}
		else if(fuente.getName().equalsIgnoreCase("JBPuntuarSerie"))
		{
			/*Object ser =vista.getVentanaPrincipal().getPanelInferior().getPanel1().getListaSeries().getJList().getSelectedValue();
			Serie serie = (Serie)ser;*/
			Serie serie = vista.getSerieSelecionada();
			if (serie!=null)
				vista.arrancaVentanaPuntuaSerie(serie);
		}
		else if(fuente.getName().equalsIgnoreCase("JSNotaParaLaSerie"))
		{
			JSlider nota = (JSlider) fuente;
			notaAPoner = nota.getValue();
		}
		else if(fuente.getName().equalsIgnoreCase("JBPuntuaLaSerie"))
		{
			//modelo.puntuaSerie((Serie)vista.getVentanaPrincipal().getPanelInferior().getPanel1().getListaSeries().getJList().getSelectedValue(), notaAPoner);
			modelo.puntuaSerie(vista.getSerieSelecionada(), notaAPoner);
			vista.cerrarVentanaPuntuaSerie();
		}
		else if(fuente.getName().equalsIgnoreCase("JBPuntuarEpisodio"))
		{
			Episodio ep = vista.getEpisodioSelecionadoTabla();
			if (ep!=null)
				vista.arrancaVentanaPuntuaEpisodio(ep);
		}
		else if(fuente.getName().equalsIgnoreCase("JBPuntuarEpisodio2"))
		{
			Episodio ep = vista.getEpisodioSelecionadoTablaInfoEpisodios();
			if (ep!=null)
				vista.arrancaVentanaPuntuaEpisodio(ep);
		}
		else if(fuente.getName().equalsIgnoreCase("JSNotaParaElEpisodio"))
		{
			JSlider nota = (JSlider) fuente;
			notaAPonerEpisodio = nota.getValue();
		}
		else if(fuente.getName().equalsIgnoreCase("JBPuntuaElEpisodio"))
		{
			Episodio ep = vista.getEpisodioSelecionadoTabla();
			if (ep==null)
			{
				ep = vista.getEpisodioSelecionadoTablaInfoEpisodios();
			}
			if (ep!=null)
			{
				modelo.puntuaEpisodio(vista.getEpisodioSelecionadoTabla(), notaAPonerEpisodio);
				vista.cerrarVentanaPuntuaEpisodio();
			}
			
		}
		else if(fuente.getName().equalsIgnoreCase("JBVerInformacionVentanaTablaInfoAP"))
		{
			if(vista.getActorVentanaTablaActorPersonaje()!=null)
				vista.arrancaVentanaInfoActor(vista.getActorVentanaTablaActorPersonaje(), modelo.getIsAdmin());
			if(vista.getPersonajeVentanaTablaActorPersonaje()!=null)
				vista.arrancaVentanaInfoPersonaje(vista.getPersonajeVentanaTablaActorPersonaje(), modelo.getIsAdmin());
		}
		else if(fuente.getName().equalsIgnoreCase("JBBuscarCapituloActorPersonaje"))
		{
			if(serieBuscar==null)
				serieBuscar="";
			if (episodioBuscar==null || episodioBuscar.equalsIgnoreCase(""))
				episodioBuscar="0";
			modelo.buscarEpisodioDeSerie(serieBuscar,Integer.parseInt(episodioBuscar));
			modelo.bucarPersonaje(nombrePersonajeBuscar);
			modelo.bucarActor(actorBuscar);
		}
		else if(fuente.getName().equalsIgnoreCase("JBNuevaInterpretacion"))
		{
			modelo.creaInterpretacion(vista.getEpisodioSelecionadoInterpreta(),vista.getActorSelecionadoInterpreta(),vista.getPersonajeSelecionadoInterpreta());
		}
		else if(fuente.getName().equalsIgnoreCase("JBBorrarInterpretacion"))
		{
			modelo.borraInterpretacion(vista.getEpisodioSelecionadoInterpreta(),vista.getActorSelecionadoInterpreta(),vista.getPersonajeSelecionadoInterpreta());
		}
		else if(fuente.getName().equalsIgnoreCase("JTFComentarioAnadirSerie"))
		{
			JTextArea use= (JTextArea)fuente;
			comentarioAnadirSerie=use.getText();
		}
		else if(fuente.getName().equalsIgnoreCase("JBComentaLaSerie"))
		{
			Serie serieAComentar = vista.getSerieParaComentar();
			if (comentarioAnadirSerie!=null)
				modelo.anadirComentarioDeSerie(serieAComentar, comentarioAnadirSerie);
			vista.cerrarVentanaComentaSerie();
		}
		else if(fuente.getName().equalsIgnoreCase("JBComentaEpisodio"))
		{
			vista.arrancaVentanaComentaEpisodio(vista.getEpisodioSelecionadoTabla());
		}
		else if(fuente.getName().equalsIgnoreCase("JTFComentarioAnadirEpisodio"))
		{
			JTextArea use= (JTextArea)fuente;
			comentarioAnadirEpisodioe=use.getText();
		}
		else if(fuente.getName().equalsIgnoreCase("JBComentaElEpisodio"))
		{
			Episodio episodioAComentar = vista.getEpisodioParaComentar();
			if (comentarioAnadirEpisodioe!=null)
			{
				modelo.anadirComentarioDeEpisodio(episodioAComentar, comentarioAnadirEpisodioe);
			}
			vista.cerrarVentanaComentaEpisodio();
		}
		else if(fuente.getName().equalsIgnoreCase("JTFNombreUsuarioBuscarComentario"))
		{
			JTextField bus= (JTextField)fuente;
			nombreUsuarioComentario=bus.getText();
		}
		else if(fuente.getName().equalsIgnoreCase("JBBuscarComentariosUsuario"))
		{
			modelo.buscaComentariosSerieDelUser(nombreUsuarioComentario);
		}
		else if(fuente.getName().equalsIgnoreCase("JBEliminarComentario"))
		{
			modelo.borrarComentarioSerie(vista.getComentarioSerieSelecionadoParaBorrar());
		}
	}

	
}
