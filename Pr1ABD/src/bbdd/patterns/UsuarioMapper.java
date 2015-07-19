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
import java.util.List;

import series.modelo.Usuario;

public class UsuarioMapper extends AbstractMapper<Usuario, String> {
	private static final String[] USUARIO_KEY_COLUMN_NAME = new String[] {"User"};
	private static final String[] USUARIO_COLUMN_NAMES = new String[] {USUARIO_KEY_COLUMN_NAME[0], "Pass", "Fecha", "Avatar"};
	private static final String USUARIO_TABLE_NAME = "usuario";
	

	public UsuarioMapper() {
		super();
	}

	@Override
	protected String getTableName() {
		return USUARIO_TABLE_NAME;
	}

	@Override
	protected String[] getColumnNames() {
		return USUARIO_COLUMN_NAMES;
	}

	@Override
	protected Usuario buildObject(ResultSet rs) throws SQLException {
		Usuario us;
		String user = rs.getString("User");
		String pass = rs.getString("Pass");
		Date fech = rs.getDate("Fecha"); 
		Blob foto = rs.getBlob("Avatar");
		us= new Usuario(user, pass, fech);
		if (!rs.wasNull()) {
			us.setFoto(foto);
		}
		UsuarioSerieMapper aux = new UsuarioSerieMapper();
		List<Integer> aux1 = aux.getSeriesDelUsuario(user);
		SerieMapper series = new SerieMapper();
		for (int i = 0; i<aux1.size(); i++)
		{
			us.followSerie(series.findById(aux1.get(i)));
		}
		return us;
	}

	@Override
	protected String[] getKeyColumnName() {
		return USUARIO_KEY_COLUMN_NAME;
	}

	

	@Override
	protected String[] getKeyValues(String id) {
		return new String[] {id};
	}

	@Override
	protected Object[] serializableObject(Usuario objeto) {
		return new Object[] {objeto.getUser(),objeto.getPass(), objeto.getNacio(), objeto.getFoto()};
	}

	@Override
	protected String[] getValuesKeyFromObject(Usuario objeto) {
		return new String[] {objeto.getUser()};
	}

	@Override
	protected String getIdFromObject(Usuario objeto) {
		return objeto.getUser();
	}

	@Override
	protected String getNameToSearch() {
		return USUARIO_KEY_COLUMN_NAME[0];
	}

}
