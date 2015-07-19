/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.modelo;

import java.sql.Blob;
import java.sql.Date;

public class Actor {

	private int id;
	private String nombre;
	private Date nacio;
	private Blob foto;
	
	public Actor(int i, String nom, Date fecha, Blob imagen)
	{
		id = i;
		nombre = nom;
		nacio = fecha;
		foto = imagen;
	}
	
	public Actor( String nom, Date fecha, Blob imagen)
	{
		nombre = nom;
		nacio = fecha;
		foto = imagen;
	}
	
	public Actor(int i, String nom, Date fecha)
	{
		id = i;
		nombre = nom;
		nacio = fecha;
	}

	public Actor( String nom, Date fecha)
	{
		nombre = nom;
		nacio = fecha;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the nacio
	 */
	public Date getNacio() {
		return nacio;
	}

	/**
	 * @return the foto
	 */
	public Blob getFoto() {
		return foto;
	}
	
	public String toString()
	{
		return nombre + " (" + nacio.toString()+ ")";
	}
	

}
