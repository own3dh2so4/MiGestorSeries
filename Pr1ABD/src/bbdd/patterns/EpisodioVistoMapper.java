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

import series.modelo.EpisodioVisto;
import bbdd.patterns.query.Operator;
import bbdd.patterns.query.QueryCondition;

public class EpisodioVistoMapper extends AbstractMapper<EpisodioVisto, EpisodioVisto>{

	private static final String[] EPISODIOVISTO_KEY_COLUMN_NAME = new String[] {"User","IdSerie","Capitulo"};
	private static final String[] EPISODIOVISTO_COLUMN_NAMES = EPISODIOVISTO_KEY_COLUMN_NAME;
	private static final String EPISODIOVISTO_TABLE_NAME = "visto";
	
	@Override
	protected String getTableName() {
		return EPISODIOVISTO_TABLE_NAME;
	}

	@Override
	protected String[] getColumnNames() {
		return EPISODIOVISTO_COLUMN_NAMES;
	}

	@Override
	protected EpisodioVisto buildObject(ResultSet rs) throws SQLException {
		String user = rs.getString(EPISODIOVISTO_COLUMN_NAMES[0]);
		int idSerie = rs.getInt(EPISODIOVISTO_COLUMN_NAMES[1]);
		int capitulo = rs.getInt(EPISODIOVISTO_COLUMN_NAMES[2]);
		EpisodioVisto eVisto = new EpisodioVisto(user, capitulo, idSerie);
		return eVisto;
	}

	@Override
	protected String[] getKeyColumnName() {
		return EPISODIOVISTO_KEY_COLUMN_NAME;
	}

	@Override
	protected String[] getKeyValues(EpisodioVisto id) {
		return new String[]{id.getUsuario(),id.getIdSerie()+"",id.getCapitulo()+""};
	}

	@Override
	protected Object[] serializableObject(EpisodioVisto objeto) {
		return new Object[]{objeto.getUsuario(),objeto.getIdSerie(),objeto.getCapitulo()};
	}

	@Override
	protected String[] getValuesKeyFromObject(EpisodioVisto objeto) {
		return new String[]{objeto.getUsuario(),objeto.getIdSerie()+"",objeto.getCapitulo()+""};
	}

	@Override
	protected EpisodioVisto getIdFromObject(EpisodioVisto objeto) {
		return objeto;
	}

	@Override
	protected String getNameToSearch() {
		return EPISODIOVISTO_COLUMN_NAMES[0];
	}
	
	public List<EpisodioVisto> findAllEspisodiosVistosPorDe(String user,int idSerie) {
		List<EpisodioVisto> result = new ArrayList<EpisodioVisto>();
		QueryCondition[] condition = new QueryCondition[2];
		
		condition[0]= new QueryCondition("IdSerie", Operator.IG, idSerie);
		condition[1] = new QueryCondition("User", Operator.LIK, user);
		
		result = findByCondition(condition);
		
		return result;
	}

}
