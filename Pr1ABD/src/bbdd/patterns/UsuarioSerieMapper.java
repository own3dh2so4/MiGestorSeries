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

import bbdd.patterns.query.Operator;
import bbdd.patterns.query.QueryCondition;
import series.modelo.UsuarioSerie;

public class UsuarioSerieMapper extends AbstractMapper<UsuarioSerie, UsuarioSerie>{
	
	private static final String[] USUARIOSERIE_COLUMN_NAME = new String[] {"Usuario", "IdSerie"};
	private static final String[] USUARIOSERIE_KEY_NAME = USUARIOSERIE_COLUMN_NAME;
	private static final String USUARIOSERIE_TABLE_NAME = "sigue";
	
	public UsuarioSerieMapper() {
		super();
	}

	@Override
	protected String getTableName() {
		
		return USUARIOSERIE_TABLE_NAME;
	}

	@Override
	protected String[] getColumnNames() {
		return USUARIOSERIE_COLUMN_NAME;
	}

	@Override
	protected UsuarioSerie buildObject(ResultSet rs) throws SQLException {
		UsuarioSerie userSerie;
		String user = rs.getString("Usuario");
		int serie = rs.getInt("IdSerie");
		userSerie = new UsuarioSerie(user, serie);
		return userSerie;
	}

	@Override
	protected String[] getKeyColumnName() {
		return USUARIOSERIE_KEY_NAME;
	}

	@Override
	protected String[] getKeyValues(UsuarioSerie id) {
		
		return new String[] {id.getNombreUsuario(), ""+id.getIdSerie()};
	}

	@Override
	protected Object[] serializableObject(UsuarioSerie objeto) {
		return new Object[] {objeto.getNombreUsuario(), objeto.getIdSerie() };
	}

	@Override
	protected String[] getValuesKeyFromObject(UsuarioSerie objeto) {
		return new String[]{objeto.getNombreUsuario(), ""+objeto.getIdSerie()};
	}

	@Override
	protected UsuarioSerie getIdFromObject(UsuarioSerie objeto) {
		return objeto;
	}
	
	public List<Integer> getSeriesDelUsuario (String user)
	{
		List<Integer> ret = new ArrayList<Integer>();
		QueryCondition[] conditions = new QueryCondition[] {new QueryCondition("Usuario", Operator.IG, user)};
		List<UsuarioSerie> aux = findByCondition(conditions);
		for (int i=0; i<aux.size(); i++)
		{
			ret.add(aux.get(i).getIdSerie());
		}		
		return ret;
	}

	@Override
	protected String getNameToSearch() {
		return USUARIOSERIE_COLUMN_NAME[0];
	}

}
