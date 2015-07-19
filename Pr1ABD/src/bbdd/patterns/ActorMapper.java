/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package bbdd.patterns;

import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import series.modelo.Actor;

public class ActorMapper extends AbstractMapper<Actor, Integer>{
	
	private static final String[] ACTOR_KEY_COLUMN_NAME = new String[] {"ID"};
	private static final String[] ACTOR_COLUMN_NAMES = new String[] {ACTOR_KEY_COLUMN_NAME[0], "Nombre", "Fecha", "Foto"};
	private static final String ACTOR_TABLE_NAME = "actores";
	
	public ActorMapper() {
		super();
	}
	
	@Override
	protected String getTableName() {
		return ACTOR_TABLE_NAME;
	}

	@Override
	protected String[] getColumnNames() {
		return ACTOR_COLUMN_NAMES;
	}

	@Override
	protected Actor buildObject(ResultSet rs) throws SQLException {
		Actor ret =null;
		int id = rs.getInt("ID");
		String nombre = rs.getString("Nombre");
		Date fecha = rs.getDate("Fecha");
		Blob foto = rs.getBlob("Foto");
		if (foto!=null)
			ret = new Actor(id, nombre, fecha, foto);
		else
			ret = new Actor(id, nombre, fecha);
		return ret;
	}

	@Override
	protected String[] getKeyColumnName() {
		return ACTOR_KEY_COLUMN_NAME;
	}

	@Override
	protected String[] getKeyValues(Integer id) {
		return new String[] {id+""};
	}

	@Override
	protected Object[] serializableObject(Actor objeto) {
		return new Object[] {objeto.getId(), objeto.getNombre(), objeto.getNacio(), objeto.getFoto()};
	}

	@Override
	protected String[] getValuesKeyFromObject(Actor objeto) {
		return new String[]{objeto.getId()+""};
	}

	@Override
	protected Integer getIdFromObject(Actor objeto) {
		return objeto.getId();
	}
	

	@Override
	protected String getNameToSearch() {
		return ACTOR_COLUMN_NAMES[1];
	}

}
