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

import series.modelo.Genero;

public class GeneroMapper extends AbstractMapper<Genero, String> {

	private static final String[] GENERO_COLUMN_NAME = new String[] {"Tipo"};
	private static final String[] GENERO_KEY_NAME = GENERO_COLUMN_NAME;
	private static final String GENERO_TABLE_NAME = "generos";
	
	@Override
	protected String getTableName() {
		return GENERO_TABLE_NAME;
	}

	@Override
	protected String[] getColumnNames() {
		return GENERO_COLUMN_NAME;
	}

	@Override
	protected Genero buildObject(ResultSet rs) throws SQLException {
		return new Genero(rs.getString(GENERO_COLUMN_NAME[0]));
	}

	@Override
	protected String[] getKeyColumnName() {
		return GENERO_KEY_NAME;
	}

	@Override
	protected String[] getKeyValues(String id) {
		return new String[] {id};
	}

	@Override
	protected Object[] serializableObject(Genero objeto) {
		return new Object[] {objeto.getGenero()};
	}

	@Override
	protected String[] getValuesKeyFromObject(Genero objeto) {
		return new String[] {objeto.getGenero()};
	}

	@Override
	protected String getIdFromObject(Genero objeto) {
		return objeto.getGenero();
	}

	@Override
	protected String getNameToSearch() {
		return GENERO_COLUMN_NAME[0];
	}

}
