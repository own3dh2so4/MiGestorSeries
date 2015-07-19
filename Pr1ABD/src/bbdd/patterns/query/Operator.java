/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package bbdd.patterns.query;

public enum Operator {
	MEN("<"),MENIG("<="),IG("="),MAY(">"),MAYIG(">="), LIK("LIKE"),NIG("<>");
	
	private String representacion;
	
	Operator (String rep)
	{
		representacion=rep;
	}
	
	public String toString()
	{
		return representacion;
	}
}
