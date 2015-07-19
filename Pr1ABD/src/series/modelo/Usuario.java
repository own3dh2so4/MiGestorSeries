/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.modelo;

import java.sql.Date;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String user;
	private String pass;
	private Date nacio;
	private Blob foto;
	private List<Serie> sigue;
	
	public Usuario (String usuario, String contrasena, Date fecha, Blob photo)
	{
		setUser(usuario);
		setPass(contrasena);
		setNacio(fecha);
		setFoto(photo);		
		sigue = new ArrayList<Serie>();
	}
	
	public Usuario (String usuario, String contrasena, Date fecha)
	{
		setUser(usuario);
		setPass(contrasena);
		setNacio(fecha);
		foto=null;
		sigue = new ArrayList<Serie>();
	}
	
	public boolean esTuPass(String password)
	{
		return pass.equals(password);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getNacio() {
		return nacio;
	}

	public void setNacio(Date nacio) {
		this.nacio = nacio;
	}

	public Blob getFoto() {
		return foto;
	}

	public void setFoto(Blob foto) {
		this.foto = foto;
	}
	
	public void followSerie(Serie ser)
	{
		sigue.add(ser);
	}
	
	public boolean areFollowTheSerie(Serie ser)
	{
		boolean ret =false;
		for(int i=0; i<sigue.size(); i++)
		{
			if (sigue.get(i).equals(ser))
				ret=true;
		}
		return ret;
	}

	public void unFollowSerie(Serie ser) {
		sigue.remove(ser);
		
	}
	
	public List<Serie> getSeriesFromUser()
	{
		return sigue;
	}
	
}
