/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package bbdd.patterns;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import series.modelo.ComentarioSerie;
import bbdd.patterns.query.Operator;
import bbdd.patterns.query.QueryCondition;

public class ComentarioSerieMapper extends AbstractMapper<ComentarioSerie, Integer>{

	private static final String[] COMENTARIOSERIE_KEY_COLUMN_NAME = new String[] {"ID"};
	private static final String[] COMENTARIOSERIE_COLUMN_NAMES = new String[] {COMENTARIOSERIE_KEY_COLUMN_NAME[0], "User","Serie","Cometario", "Fecha"};
	private static final String COMENTARIOSERIE_TABLE_NAME = "cometarioserie";
	
	@Override
	protected String getTableName() {
		return COMENTARIOSERIE_TABLE_NAME;
	}

	@Override
	protected String[] getColumnNames() {
		return COMENTARIOSERIE_COLUMN_NAMES;
	}

	@Override
	protected ComentarioSerie buildObject(ResultSet rs) throws SQLException {
		ComentarioSerie cs = null;
		int id = rs.getInt(COMENTARIOSERIE_COLUMN_NAMES[0]);
		String user = rs.getString(COMENTARIOSERIE_COLUMN_NAMES[1]);
		int idSerie = rs.getInt(COMENTARIOSERIE_COLUMN_NAMES[2]);
		String comentario = rs.getString(COMENTARIOSERIE_COLUMN_NAMES[3]);
		Date fecha = rs.getDate(COMENTARIOSERIE_COLUMN_NAMES[4]);
		cs = new ComentarioSerie(id, user, idSerie, comentario, fecha);
		return cs;
	}

	@Override
	protected String[] getKeyColumnName() {
		return COMENTARIOSERIE_KEY_COLUMN_NAME;
	}

	@Override
	protected String[] getKeyValues(Integer id) {
		return new String[] {id+""};
	}

	@Override
	protected Object[] serializableObject(ComentarioSerie objeto) {
		return new Object[]{objeto.getIdComentarioSerie(),objeto.getUsuario(),objeto.getIdSerie(),objeto.getComentario(),objeto.getFecha()};
	}

	@Override
	protected String[] getValuesKeyFromObject(ComentarioSerie objeto) {
		return new String[]{objeto.getIdComentarioSerie()+""};
	}

	@Override
	protected Integer getIdFromObject(ComentarioSerie objeto) {
		return objeto.getIdComentarioSerie();
	}

	@Override
	protected String getNameToSearch() {
		return COMENTARIOSERIE_COLUMN_NAMES[1];
	}

	public List<ComentarioSerie> findAllComentsFromSerie(int id) {
		List<ComentarioSerie> result = new ArrayList<ComentarioSerie>();
		QueryCondition[] condition =new QueryCondition[1];
		condition[0]= new QueryCondition("Serie", Operator.IG, id);		
		result = findByCondition(condition);
		return result;
	}

}
