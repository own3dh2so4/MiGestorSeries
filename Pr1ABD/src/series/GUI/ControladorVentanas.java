/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.GUI;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import series.GUI.VentanasInfo.VentanaInfoActor;
import series.GUI.VentanasInfo.VentanaInfoComentarioEpisodio;
import series.GUI.VentanasInfo.VentanaInfoComentarioSerie;
import series.GUI.VentanasInfo.VentanaInfoEpisodio;
import series.GUI.VentanasInfo.VentanaInfoPersonaje;
import series.GUI.VentanasInfo.VentanaInfoSerie;
import series.GUI.VentanasInfo.VentanaInfoTablaEpisodios;
import series.GUI.VentanasInfo.VentanaInfoTablaPersonajesActores;
import series.GUI.VentanasNuevoObjeto.VentanaNuevaSerie;
import series.GUI.VentanasNuevoObjeto.VentanaNuevoActor;
import series.GUI.VentanasNuevoObjeto.VentanaNuevoComentarioEpisodio;
import series.GUI.VentanasNuevoObjeto.VentanaNuevoComentarioSerie;
import series.GUI.VentanasNuevoObjeto.VentanaNuevoEpisodio;
import series.GUI.VentanasNuevoObjeto.VentanaNuevoPersonaje;
import series.GUI.VentanasNuevoObjeto.VentanaNuevoUsuario;
import series.GUI.VentanasNuevoObjeto.VentanaPuntuaEpisodio;
import series.GUI.VentanasNuevoObjeto.VentanaPuntuaSerie;
import series.controlador.Controlador;
import series.controlador.ControladorLogin;
import series.modelo.Actor;
import series.modelo.ComentarioSerie;
import series.modelo.Episodio;
import series.modelo.Personaje;
import series.modelo.Serie;

public class ControladorVentanas implements Observer {

	private boolean isAdmin;
	private VentanaLogin ventanaLog;
	private VentanaPrincipal ventanaP;
	private VentanaPrincipalAdmin ventanaPA;
	private ControladorLogin controladorLogin;
	private Controlador controlador;
	private VentanaInfoSerie ventanaInfoSer;
	private VentanaNuevoUsuario ventanaNuevoUsuario;
	private VentanaNuevaSerie ventanaNuevaSerie;
	private VentanaNuevoActor ventanaNuevoActor;
	private VentanaInfoActor ventanaInfoActor;
	private VentanaInfoPersonaje ventanaInfoPersonaje;
	private VentanaNuevoPersonaje ventanaNuevoPersonaje;
	private VentanaInfoEpisodio ventanaInfoEpisodio;
	private VentanaInfoTablaEpisodios ventanaInfoTablaEpisodios;
	private VentanaNuevoEpisodio ventanaNuevoepisodio;
	private VentanaPuntuaSerie ventanaPuntuaSerie;
	private VentanaPuntuaEpisodio ventanaPuntuaEpisodio;
	private VentanaInfoTablaPersonajesActores ventanaInfoTablaPersonajesActores;
	private VentanaNuevoComentarioSerie ventanaComentaSerie;
	private VentanaInfoComentarioSerie ventanaInfoComentarioSerie;
	private VentanaNuevoComentarioEpisodio ventanaComentaEpisodio;
	private VentanaInfoComentarioEpisodio ventanaInfoComentarioEpisodio;
	
	public ControladorVentanas(ControladorLogin cLog, Controlador cont, boolean admin)
	{
		isAdmin = admin;
		ventanaLog= new VentanaLogin();
		controladorLogin=cLog;
		ventanaLog.fijarControlador(controladorLogin);
		ventanaP= new VentanaPrincipal();
		controlador=cont;
		ventanaP.fijarControlador(controlador);
		ventanaPA = new VentanaPrincipalAdmin();
		ventanaPA.fijarControlador(cont);
		arrancaVentanaPrincipalAdmin();
		arrancaElLogin();
		arrancaVentanPricipal();
	}
	
	/**
	 * Función encargada del arranque de la ventana.
	 */
	private void arrancaElLogin()
	{
		ventanaLog.empieza();
	}
	
	private void arrancaVentanPricipal()
	{
		ventanaP.empieza();
	}
	
	private void arrancaVentanaPrincipalAdmin()
	{
		ventanaPA.empieza();
	}
	
	public void arrancaVentanaInfoSerie(Serie serie, boolean admin)
	{
		ventanaInfoSer = new VentanaInfoSerie(serie, admin);
		ventanaInfoSer.fijarControlador(controlador);
		ventanaInfoSer.empieza();
	}
	
	public void arrancaVentanaNuevoEpisodio()
	{
		ventanaNuevoepisodio = new VentanaNuevoEpisodio();
		ventanaNuevoepisodio.fijarControlador(controladorLogin);
		ventanaNuevoepisodio.empieza();
	}
	
	public void arrancaVentanaInfoTablaEpisodios(List<Episodio> episodios)
	{
		ventanaInfoTablaEpisodios = new VentanaInfoTablaEpisodios(episodios);
		ventanaInfoTablaEpisodios.fijarControlador(controlador);
		ventanaInfoTablaEpisodios.empieza();
	}
	
	public void arrancaVentanaInfoPersonaje(Personaje persona, boolean admin)
	{
		ventanaInfoPersonaje = new VentanaInfoPersonaje(persona, admin);
		ventanaInfoPersonaje.fijarControlador(controlador);
		ventanaInfoPersonaje.empieza();
	}
	
	public void arrancaVentanaComentaSerie(Serie ser)
	{
		ventanaComentaSerie = new VentanaNuevoComentarioSerie(ser);
		ventanaComentaSerie.fijarControlador(controlador);
		ventanaComentaSerie.empieza();
	}
	
	public void arrancaVentanaComentaEpisodio(Episodio ep)
	{
		ventanaComentaEpisodio =new VentanaNuevoComentarioEpisodio(ep);
		ventanaComentaEpisodio.fijarControlador(controlador);
		ventanaComentaEpisodio.empieza();
	}
	
	public void arrancaVentanaInfoComentarioSerie(Serie ser)
	{
		ventanaInfoComentarioSerie = new VentanaInfoComentarioSerie(ser);
		ventanaInfoComentarioSerie.empieza();
	}
	
	public void arrancaVentanaInfoActor(Actor actor, boolean admin)
	{
		ventanaInfoActor = new VentanaInfoActor(actor, admin);
		ventanaInfoActor.fijarControlador(controlador);
		ventanaInfoActor.empieza();
	}
	
	public void arrancaVentanaInfoEpisodio(Episodio episodio, boolean admin)
	{
		ventanaInfoEpisodio = new VentanaInfoEpisodio(episodio, admin);
		ventanaInfoEpisodio.fijarControlador(controlador);
		ventanaInfoEpisodio.empieza();
	}
	
	public void arrancaVentanaInfoComentarioEpisodio(Episodio episodio)
	{
		ventanaInfoComentarioEpisodio =new VentanaInfoComentarioEpisodio(episodio);
		ventanaInfoComentarioEpisodio.empieza();
	}
	
	public void arracaVentanaInfoTablaActoresPersonajes(Episodio episodio, boolean admin)
	{
		ventanaInfoTablaPersonajesActores = new VentanaInfoTablaPersonajesActores(episodio);
		ventanaInfoTablaPersonajesActores.fijarControlador(controlador);
		ventanaInfoTablaPersonajesActores.empieza();
	}
	
	public void arrancaVentanaNuevaSerie()
	{
		ventanaNuevaSerie = new VentanaNuevaSerie();
		ventanaNuevaSerie.fijarControlador(controladorLogin);
		ventanaNuevaSerie.empieza();
	}
	
	
	public void arrancaVentanaNuevoPersonaje()
	{
		ventanaNuevoPersonaje = new VentanaNuevoPersonaje();
		ventanaNuevoPersonaje.fijarControlador(controladorLogin);
		ventanaNuevoPersonaje.empieza();
	}
	
	public void arrancaVentanaNuevoUsuario()
	{
		ventanaNuevoUsuario = new VentanaNuevoUsuario();
		ventanaNuevoUsuario.fijarControlador(controladorLogin);
		ventanaNuevoUsuario.empieza();
	}
	
	public void arrancaVentanaNuevoActor()
	{
		ventanaNuevoActor = new VentanaNuevoActor();
		ventanaNuevoActor.fijarControlador(controladorLogin);
		ventanaNuevoActor.empieza();
	}
	
	public void arrancaVentanaPuntuaSerie(Serie serieAPuntuar)
	{
		ventanaPuntuaSerie = new VentanaPuntuaSerie(serieAPuntuar);
		ventanaPuntuaSerie.fijarControlador(controlador);
		ventanaPuntuaSerie.empieza();
	}
	
	public void arrancaVentanaPuntuaEpisodio(Episodio episodioAPuntuar)
	{
		ventanaPuntuaEpisodio = new VentanaPuntuaEpisodio(episodioAPuntuar);
		ventanaPuntuaEpisodio.fijarControlador(controlador);
		ventanaPuntuaEpisodio.empieza();
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		ventanaLog.update(arg0, arg1);
		if(!isAdmin)
			ventanaP.update(arg0, arg1);
		else
			ventanaPA.update(arg0, arg1);
		
	}

	public String leerElUsuario() {
		return ventanaLog.leerElUsuario();
	}

	public String leerLaContrasena() {
		return ventanaLog.leerLaContrasena();
	}

	public void ocultaElLogin() {
		ventanaLog.setVisible(false);
		
	}

	public void empiezaLogin() {
		ventanaLog.setVisible(true);
		
	}
	
	public VentanaPrincipal getVentanaPrincipal()
	{
		return ventanaP;
	}
	
	public Serie getSerieSelecionada()
	{
		return ventanaP.getSerieSelecionada();
	}
	
	
	public Serie getSerieSelecionadaAdmin()
	{
		return ventanaPA.getSerieSelecioandaAdmin();
	}
	
	public List<Object> getListEpisodios()
	{
		return ventanaPA.getSelecionadoEpisodio();
	}
	
	public Actor getActorSelecionadoAdmin()
	{
		return ventanaPA.getActorSelecionadoAdmin();
	}

	public Personaje getPersonajeSelecionadoAdmin()
	{
		return ventanaPA.getPersonajeSelecionadoAdmin();
	}
	
	public void cerrarVentanaInfoSerie()
	{
		ventanaInfoSer.cerrarVentana();
	}
	
	public void cerrarVentanaNuevoUsuario()
	{
		ventanaNuevoUsuario.cerrarVentana();
	}
	
	public void cerrarVentanaNuevaSerie()
	{
		ventanaNuevaSerie.cerrarVentana();
	}

	public void cerrarVentanaNuevaActor() {
		ventanaNuevoActor.cerrarVentana();
		
	}
	
	public void cerrarVentanaInfoActor() {
		ventanaInfoActor.cerrarVentana();		
	}
	
	public void cerrarVentanaInfoPersonaje()
	{
		ventanaInfoPersonaje.cerrarVentana();
	}
	
	public void cerrarVentanaNuevoPersonaje()
	{
		ventanaNuevoPersonaje.cerrarVentana();
	}
	
	public void cerrarVentanaInfoEpisodio()
	{
		ventanaInfoEpisodio.cerrarVentana();
	}
	
	public void cerrarVentanaInfoTablaEpisodios()
	{
		ventanaInfoTablaEpisodios.cerrarVentana();
	}
	
	public List<Object> getSelecionadoGeneroDeGeneroSerie()
	{
		return ventanaPA.getSelecionadoGeneroDeGeneroSerie();
	}
	
	public Object getSelecionadoSerieDeGeneroSerie()
	{
		return ventanaPA.getSelecionadoSerieDeGeneroSerie();
	}

	public Episodio getEpisodioSelecionadoTabla()
	{
		return ventanaP.getEpisodioSelecionadoTabla();
	}
	
	public Episodio getEpisodioSelecionadoTablaInfoEpisodios()
	{
		return ventanaInfoTablaEpisodios.getEpisodioSelecionadoTabla();
	}
	
	public void cerrarVentanaNuevoEpisodio()
	{
		ventanaNuevoepisodio.cerrarVentana();
	}
	
	public void cerrarVentanaPuntuaSerie()
	{
		ventanaPuntuaSerie.cerrarVentana();
	}
	
	public void cerrarVentanaPuntuaEpisodio()
	{
		ventanaPuntuaEpisodio.cerrarVentana();
	}
	
	public void cerrarVentanaComentaSerie()
	{
		ventanaComentaSerie.cerrarVentana();
	}

	public void cerrarVentanaInfoTablaActoresPersonajes()
	{
		ventanaInfoTablaPersonajesActores.cerrarVentana();
	}
	
	public void cerrarVentanaComentaEpisodio()
	{
		ventanaComentaEpisodio.cerrarVentana();
	}
	
	public Episodio dameEpisodioVentanaInfo() {
		Episodio epi =null;
		if (ventanaInfoEpisodio!=null)
			epi=ventanaInfoEpisodio.getEpisodio();
		return epi;
	}
	
	public Actor getActorVentanaTablaActorPersonaje()
	{
		return ventanaInfoTablaPersonajesActores.getActorSeleccionado();
	}
	
	public Personaje getPersonajeVentanaTablaActorPersonaje()
	{
		return ventanaInfoTablaPersonajesActores.getPersonajeSelecionado();
	}
	
	public Episodio getEpisodioSelecionadoInterpreta()
	{
		return ventanaPA.getEpisodioSelecionadoInterpretacion();
	}
	
	public Actor getActorSelecionadoInterpreta()
	{
		return ventanaPA.getActorSelecionadoInterpretacion();
	}
	
	public Personaje getPersonajeSelecionadoInterpreta()
	{
		return ventanaPA.getPersonajeSelecionadoInterpretacion();
	}
	
	public Serie getSerieParaComentar()
	{
		return ventanaComentaSerie.getSerie();
	}

	public Episodio getEpisodioParaComentar() {
		return ventanaComentaEpisodio.getEpisodio();
	}
	
	public ComentarioSerie getComentarioSerieSelecionadoParaBorrar()
	{
		return ventanaPA.getComentarioSerieSelecionado();
	}
}
