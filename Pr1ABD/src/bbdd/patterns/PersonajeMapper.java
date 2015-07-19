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

import series.modelo.Personaje;

public class PersonajeMapper extends AbstractMapper<Personaje, Integer>{

	private static final String[] PERSONAJE_KEY_COLUMN_NAME = new String[] {"ID"};
	private static final String[] PERSONAJE_COLUMN_NAMES = new String[] {PERSONAJE_KEY_COLUMN_NAME[0], "NombreP", "Descripcion"};
	private static final String PERSONAJE_TABLE_NAME = "personajes";
	
	@Override
	protected String getTableName() {
		return PERSONAJE_TABLE_NAME;
	}

	@Override
	protected String[] getColumnNames() {
		return PERSONAJE_COLUMN_NAMES;
	}

	@Override
	protected Personaje buildObject(ResultSet rs) throws SQLException {
		Personaje ret = null;
		int id = rs.getInt("ID");
		String nombre = rs.getString("NombreP");
		String descripcion = rs.getString("Descripcion");
		ret = new Personaje(id, nombre, descripcion);
		return ret;
	}

	@Override
	protected String[] getKeyColumnName() {
		return PERSONAJE_KEY_COLUMN_NAME;
	}

	@Override
	protected String[] getKeyValues(Integer id) {
		return new String[] {id+""};
	}

	@Override
	protected Object[] serializableObject(Personaje objeto) {
		return new Object[] {objeto.getId(),objeto.getNombre(),objeto.getDescripcion()};
	}

	@Override
	protected String[] getValuesKeyFromObject(Personaje objeto) {
		return new String[] {objeto.getId()+"",objeto.getNombre(),objeto.getDescripcion()};
	}

	@Override
	protected Integer getIdFromObject(Personaje objeto) {
		return objeto.getId();
	}

	@Override
	protected String getNameToSearch() {
		return PERSONAJE_COLUMN_NAMES[1];
	}

}
