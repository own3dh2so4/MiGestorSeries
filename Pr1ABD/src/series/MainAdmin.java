/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series;

import series.GUI.ControladorVentanas;
import series.controlador.Controlador;
import series.controlador.ControladorLogin;
import series.modelo.UserLoged;

public class MainAdmin {
	
	public static void main(String[] args) {
		UserLoged usuario = new UserLoged(true);		
		ControladorLogin contLog = new ControladorLogin (usuario);	
		Controlador cont = new Controlador(usuario);
		ControladorVentanas log = new ControladorVentanas(contLog,cont,true);
		cont.setVista(log);
		contLog.setVista(log);
		usuario.addObserver(log);
		//log.update(usuario, null);
		log.empiezaLogin();
	}
}
