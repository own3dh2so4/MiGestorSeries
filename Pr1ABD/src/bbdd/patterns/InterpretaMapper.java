/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package bbdd.patterns;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import series.modelo.Interpreta;
import bbdd.patterns.query.Operator;
import bbdd.patterns.query.QueryCondition;

public class InterpretaMapper extends AbstractMapper<Interpreta, Interpreta>{

	private static final String[] INTERPRETA_KEY_COLUMN_NAME = new String[] {"IdActor","IdPersonaje","Serie","Capitulo"};
	private static final String[] INTERPRETA_COLUMN_NAMES = INTERPRETA_KEY_COLUMN_NAME;
	private static final String INTERPRETA_TABLE_NAME = "interpreta";
	
	@Override
	protected String getTableName() {
		return INTERPRETA_TABLE_NAME;
	}

	@Override
	protected String[] getColumnNames() {
		return INTERPRETA_COLUMN_NAMES;
	}

	@Override
	protected Interpreta buildObject(ResultSet rs) throws SQLException {
		Interpreta interpreta =null;
		int idActor = rs.getInt(INTERPRETA_COLUMN_NAMES[0]);
		int idPersonaje = rs.getInt(INTERPRETA_COLUMN_NAMES[1]);
		int idSerie = rs.getInt(INTERPRETA_COLUMN_NAMES[2]);
		int capitulo = rs.getInt(INTERPRETA_COLUMN_NAMES[3]);
		interpreta = new Interpreta(idActor, idPersonaje, idSerie, capitulo);
		return interpreta;
	}

	@Override
	protected String[] getKeyColumnName() {
		return INTERPRETA_KEY_COLUMN_NAME;
	}

	@Override
	protected String[] getKeyValues(Interpreta id) {
		return new String[] {id.getIdActor()+"", id.getIdPersonaje()+"", id.getIdSerie()+"", id.getCapitulo()+""};
	}

	@Override
	protected Object[] serializableObject(Interpreta objeto) {
		return new Object[]{objeto.getIdActor(), objeto.getIdPersonaje(), objeto.getIdSerie(), objeto.getCapitulo()};
	}

	@Override
	protected String[] getValuesKeyFromObject(Interpreta objeto) {
		return new String[] {objeto.getIdActor()+"", objeto.getIdPersonaje()+"", objeto.getIdSerie()+"", objeto.getCapitulo()+""};
	}

	@Override
	protected Interpreta getIdFromObject(Interpreta objeto) {
		return objeto;
	}

	@Override
	protected String getNameToSearch() {
		return INTERPRETA_COLUMN_NAMES[0];
	}
	
	public List<Interpreta> findAllActorPersonajesFrom(int capitulo,int idSerie) {
		List<Interpreta> result = new ArrayList<Interpreta>();
		QueryCondition[] condition = new QueryCondition[2];
		
		condition[0]= new QueryCondition("Serie", Operator.IG, idSerie);
		condition[1] = new QueryCondition("Capitulo", Operator.IG, capitulo);
		
		result = findByCondition(condition);
		
		return result;
	}

}
