/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Rega�o										*
*								3�B												*
*********************************************************************************/

package bbdd.patterns.query;


public class QueryCondition {

	private String columName;
	private Operator operacion;
	private Object objeto;
	
	public QueryCondition()
	{
		
	}
	public QueryCondition(String cName, Operator ope, Object obj)
	{
		columName = cName;
		operacion = ope;
		objeto = obj;
	}

	public Operator getOperacion() {
		return operacion;
	}

	public Object getObjeto() {
		return objeto;
	}

	public String getColumName() {
		return columName;
	}

	

	
	
}
