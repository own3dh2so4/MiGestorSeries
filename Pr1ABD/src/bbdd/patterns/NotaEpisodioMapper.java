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

import series.modelo.EpisodioVisto;
import series.modelo.NotaEpisodio;
import bbdd.patterns.query.Operator;
import bbdd.patterns.query.QueryCondition;

public class NotaEpisodioMapper extends AbstractMapper<NotaEpisodio, EpisodioVisto>{
	
	private static final String[] NOTAEPISODIO_COLUMN_NAME = new String[] {"User","IdSerie","Capitulo","Nota"};
	private static final String[] NOTAEPISODIO_KEY_NAME = new String[] {NOTAEPISODIO_COLUMN_NAME[0],NOTAEPISODIO_COLUMN_NAME[1],NOTAEPISODIO_COLUMN_NAME[2]};
	private static final String NOTAEPISODIO_TABLE_NAME = "notacapitulo";
	
	@Override
	protected String getTableName() {
		return NOTAEPISODIO_TABLE_NAME;
	}

	@Override
	protected String[] getColumnNames() {
		return NOTAEPISODIO_COLUMN_NAME;
	}

	@Override
	protected NotaEpisodio buildObject(ResultSet rs) throws SQLException {
		NotaEpisodio notaEpisodio = null;
		String user = rs.getString("User");
		int idSerie = rs.getInt("IdSerie");
		int capitulo = rs.getInt("Capitulo");
		int nota = rs.getInt("Nota");
		notaEpisodio= new NotaEpisodio(user, idSerie, capitulo, nota);
		return notaEpisodio;
	}

	@Override
	protected String[] getKeyColumnName() {
		return NOTAEPISODIO_KEY_NAME;
	}

	@Override
	protected String[] getKeyValues(EpisodioVisto id) {
		return new String[] {id.getUsuario(), id.getIdSerie()+"", id.getCapitulo()+""};
	}

	@Override
	protected Object[] serializableObject(NotaEpisodio objeto) {
		return new Object[]{objeto.getUsuario(),objeto.getIdSerie(),objeto.getCapitulo(),objeto.getNota()};
	}

	@Override
	protected String[] getValuesKeyFromObject(NotaEpisodio objeto) {
		return new String[]{objeto.getUsuario(),objeto.getIdSerie()+"",objeto.getCapitulo()+""};
	}

	@Override
	protected EpisodioVisto getIdFromObject(NotaEpisodio objeto) {
		return new EpisodioVisto(objeto.getUsuario(), objeto.getCapitulo(), objeto.getIdSerie());
	}

	@Override
	protected String getNameToSearch() {
		return "User";
	}
	
	public int getNotaMediaDeSerie(int idSerie, int capitulo)
	{
		List <NotaEpisodio> ret = null;
		QueryCondition[] condition = new QueryCondition[2];
		condition[0]=new QueryCondition("IdSerie", Operator.IG, idSerie);	
		condition[1]=new QueryCondition("Capitulo", Operator.IG, capitulo);
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
