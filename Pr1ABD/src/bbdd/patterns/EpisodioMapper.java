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

import bbdd.patterns.query.Operator;
import bbdd.patterns.query.QueryCondition;
import series.modelo.Episodio;
import series.modelo.EpisodioSerie;

public class EpisodioMapper extends AbstractMapper<Episodio, EpisodioSerie> {

	private static final String[] EPISODIO_KEY_COLUMN_NAME = new String[] {"Capitulo","Serie"};
	private static final String[] EPISODIO_COLUMN_NAMES = new String[] {"Titulo",EPISODIO_KEY_COLUMN_NAME[0], "Temporada", "Sinopsis","Fecha", EPISODIO_KEY_COLUMN_NAME[1]};
	private static final String EPISODIO_TABLE_NAME = "episodio";
	
	@Override
	protected String getTableName() {
		return EPISODIO_TABLE_NAME;
	}

	@Override
	protected String[] getColumnNames() {
		return EPISODIO_COLUMN_NAMES;
	}

	@Override
	protected Episodio buildObject(ResultSet rs) throws SQLException {
		Episodio episodio;
		String titulo = rs.getString(EPISODIO_COLUMN_NAMES[0]);
		int capitulo = rs.getInt(EPISODIO_COLUMN_NAMES[1]);
		int temporada = rs.getInt(EPISODIO_COLUMN_NAMES[2]);
		String sinopsis = rs.getString(EPISODIO_COLUMN_NAMES[3]);
		Date fecha = rs.getDate(EPISODIO_COLUMN_NAMES[4]);
		int idSerie = rs.getInt(EPISODIO_COLUMN_NAMES[5]);
		episodio = new Episodio(titulo, new EpisodioSerie(capitulo, idSerie), temporada, sinopsis, fecha);
		return episodio;
	}

	@Override
	protected String[] getKeyColumnName() {
		return EPISODIO_KEY_COLUMN_NAME;
	}

	@Override
	protected String[] getKeyValues(EpisodioSerie id) {
		return new String[]{id.getCapitulo()+"", id.getIdSerie()+""};
	}

	@Override
	protected Object[] serializableObject(Episodio objeto) {
		return new Object[]{objeto.getTitulo(),objeto.getEpisodioSerie().getCapitulo(),
							objeto.getTemporada(), objeto.getSinopsis(), objeto.getFecha(),
							objeto.getEpisodioSerie().getIdSerie()};
	}

	@Override
	protected String[] getValuesKeyFromObject(Episodio objeto) {
		return new String[]{objeto.getEpisodioSerie().getCapitulo()+"",objeto.getEpisodioSerie().getIdSerie()+""};
	}

	@Override
	protected EpisodioSerie getIdFromObject(Episodio objeto) {
		return objeto.getEpisodioSerie();
	}

	@Override
	protected String getNameToSearch() {
		return EPISODIO_KEY_COLUMN_NAME[1];
	}
	
	public List<Episodio> findAllFromSerie(int idSerie) {
		List<Episodio> result = new ArrayList<Episodio>();
		QueryCondition[] condition = new QueryCondition[1];
		
		condition[0]= new QueryCondition(getNameToSearch(), Operator.IG, idSerie);
		
		result = findByCondition(condition);
		
		return result;
	}
	
	public List<Episodio> findAllFromSerieMenos(int idSerie, int estosNo[]) {
		List<Episodio> result = new ArrayList<Episodio>();
		QueryCondition[] condition = new QueryCondition[estosNo.length+1];
		condition[0]= new QueryCondition(getNameToSearch(), Operator.IG, idSerie);
		for (int i=1; i<condition.length; i++)
		{
			condition[i]= new QueryCondition("Capitulo", Operator.NIG, estosNo[i-1]);
		}
		
		result = findByCondition(condition);
		
		return result;
	}
	
	public List<Episodio> findByIdRelative(EpisodioSerie es) {
		List<Episodio> result = new ArrayList<Episodio>();
		QueryCondition[] condition =null;
		
		if(es.getCapitulo()!=0)
		{
			condition = new QueryCondition[2];
			condition[0]= new QueryCondition("Capitulo", Operator.IG, es.getCapitulo());
			condition[1] = new QueryCondition("Serie", Operator.IG, es.getIdSerie());
		}
		else
		{
			condition = new QueryCondition[1];
			condition[0] = new QueryCondition("Serie", Operator.IG, es.getIdSerie());
		}
		
		result = findByCondition(condition);
		
		return result;
		
	}

}
