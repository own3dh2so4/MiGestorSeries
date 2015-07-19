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

import series.modelo.ComentarioEpisodio;
import series.modelo.EpisodioSerie;
import bbdd.patterns.query.Operator;
import bbdd.patterns.query.QueryCondition;

public class ComentarioEpisodioMapper extends AbstractMapper<ComentarioEpisodio, Integer>{

	private static final String[] COMENTARIOEPISODIO_KEY_COLUMN_NAME = new String[] {"ID"};
	private static final String[] COMENTARIOEPISODIO_COLUMN_NAMES = new String[] {COMENTARIOEPISODIO_KEY_COLUMN_NAME[0], "User","Serie","Capitulo","Comentario", "Fecha"};
	private static final String COMENTARIOEPISODIO_TABLE_NAME = "comentariocapitulo";
	
	@Override
	protected String getTableName() {
		return COMENTARIOEPISODIO_TABLE_NAME;
	}

	@Override
	protected String[] getColumnNames() {
		return COMENTARIOEPISODIO_COLUMN_NAMES;
	}

	@Override
	protected ComentarioEpisodio buildObject(ResultSet rs)
			throws SQLException {
		ComentarioEpisodio ce =null;
		int id = rs.getInt(COMENTARIOEPISODIO_COLUMN_NAMES[0]);
		String user = rs.getString(COMENTARIOEPISODIO_COLUMN_NAMES[1]);
		int serie = rs.getInt(COMENTARIOEPISODIO_COLUMN_NAMES[2]);
		int capitulo =  rs.getInt(COMENTARIOEPISODIO_COLUMN_NAMES[3]);
		String comentario = rs.getString(COMENTARIOEPISODIO_COLUMN_NAMES[4]);
		Date fecha = rs.getDate(COMENTARIOEPISODIO_COLUMN_NAMES[5]);
		ce =new ComentarioEpisodio(id, user, serie, capitulo, comentario, fecha);
		return ce;
	}

	@Override
	protected String[] getKeyColumnName() {
		return COMENTARIOEPISODIO_KEY_COLUMN_NAME;
	}

	@Override
	protected String[] getKeyValues(Integer id) {
		return new String[]{id+""};
	}

	@Override
	protected Object[] serializableObject(ComentarioEpisodio objeto) {
		return new Object[]{objeto.getIdComentarioEpisodio(),objeto.getUsuario(),objeto.getIdSerie(), objeto.getCapitulo(),objeto.getComentario(),objeto.getFecha()};
	}

	@Override
	protected String[] getValuesKeyFromObject(ComentarioEpisodio objeto) {
		return new String[]{objeto.getIdComentarioEpisodio()+""};
	}

	@Override
	protected Integer getIdFromObject(ComentarioEpisodio objeto) {
		return objeto.getIdComentarioEpisodio();
	}

	@Override
	protected String getNameToSearch() {
		return COMENTARIOEPISODIO_COLUMN_NAMES[1];
	}

	public List<ComentarioEpisodio> findAllComentsFromEpisodio(
			EpisodioSerie episodioSerie) {
		List<ComentarioEpisodio> result = new ArrayList<ComentarioEpisodio>();
		QueryCondition[] condition =new QueryCondition[2];
		condition[0]= new QueryCondition("Serie", Operator.IG, episodioSerie.getIdSerie());		
		condition[1]= new QueryCondition("Capitulo", Operator.IG, episodioSerie.getCapitulo());	
		result = findByCondition(condition);
		return result;
	}

}
