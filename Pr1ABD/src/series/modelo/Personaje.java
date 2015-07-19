/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package series.modelo;

public class Personaje {

	private int id;
	private String nombre;
	private String descripcion;
	
	public Personaje(int id, String nombre, String descripcion)
	{
		this.id=id;
		this.nombre= nombre;
		this.descripcion = descripcion;
	}
	
	public Personaje( String nombre, String descripcion)
	{
		this.nombre= nombre;
		this.descripcion = descripcion;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	public String toString()
	{
		return nombre;
	}
	
}
