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
import java.util.List;

import bbdd.patterns.query.Operator;
import bbdd.patterns.query.QueryCondition;
import series.modelo.NotaSerie;
import series.modelo.UsuarioSerie;

public class NotaSerieMapper  extends AbstractMapper<NotaSerie,UsuarioSerie>{

	private static final String[] NOTASERIE_KEY_COLUMN_NAME = new String[] {"User","IdSerie"};
	private static final String[] NOTASERIE_COLUMN_NAMES = new String[] {NOTASERIE_KEY_COLUMN_NAME[0], NOTASERIE_KEY_COLUMN_NAME[1], "Nota"};
	private static final String NOTASERIE_TABLE_NAME = "notaserie";
	
	public NotaSerieMapper(){
		super();
	}
	
	@Override
	protected String getTableName() {
		return NOTASERIE_TABLE_NAME;
	}

	@Override
	protected String[] getColumnNames() {
		return NOTASERIE_COLUMN_NAMES;
	}

	@Override
	protected NotaSerie buildObject(ResultSet rs) throws SQLException {
		NotaSerie ns = null;
		int idSerie = rs.getInt("IdSerie");
		int notaSerie = rs.getInt("Nota");
		String nombeUsuario = rs.getString("User");
		ns = new NotaSerie(nombeUsuario, idSerie, notaSerie);
		return ns;
	}

	@Override
	protected String[] getKeyColumnName() {
		return NOTASERIE_KEY_COLUMN_NAME;
	}

	@Override
	protected String[] getKeyValues(UsuarioSerie id) {
		return new String[] {id.getNombreUsuario(),id.getIdSerie()+""};
	}

	@Override
	protected Object[] serializableObject(NotaSerie objeto) {
		return new Object[] {objeto.getNombreUser(),objeto.getIdSerie(),objeto.getNota()};
	}

	@Override
	protected String[] getValuesKeyFromObject(NotaSerie objeto) {
		return new String[]{objeto.getNombreUser(),objeto.getIdSerie()+""};
	}

	@Override
	protected UsuarioSerie getIdFromObject(NotaSerie objeto) {
		return new UsuarioSerie(objeto.getNombreUser(), objeto.getIdSerie());
	}

	@Override
	protected String getNameToSearch() {
		return NOTASERIE_KEY_COLUMN_NAME[0];
	}
	
	public int getNotaMediaDeSerie(int idSerie)
	{
		List <NotaSerie> ret = null;
		QueryCondition[] condition = new QueryCondition[1];
		condition[0]=new QueryCondition("IdSerie", Operator.IG, idSerie);		
		ret = findByCondition(condition);
		int notaMedia=0;
		if(!ret.isEmpty())
		{
			for (int i=0; i<ret.size(); i++)
			{
				notaMedia= notaMedia + ret.get(i).getNota();
			}
			notaMedia = notaMedia/ret.size();
		}
		return notaMedia;
	}

}
