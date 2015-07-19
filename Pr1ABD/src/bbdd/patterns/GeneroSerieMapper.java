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
import series.modelo.Genero;
import series.modelo.GeneroSerie;

public class GeneroSerieMapper extends AbstractMapper<GeneroSerie, GeneroSerie> {
	private static final String[] GENEROSERIE_COLUMN_NAME = new String[] {"IdSerie", "Genero"};
	private static final String[] GENEROSERIE_KEY_NAME = GENEROSERIE_COLUMN_NAME;
	private static final String GENEROSERIE_TABLE_NAME = "generoseries";
	public GeneroSerieMapper() {
		super();
	}

	@Override
	protected String getTableName() {
		return GENEROSERIE_TABLE_NAME;
	}

	@Override
	protected String[] getColumnNames() {
		
		return GENEROSERIE_COLUMN_NAME;
	}

	@Override
	protected GeneroSerie buildObject(ResultSet rs) throws SQLException {
		GeneroSerie genSe;
		int idSerie = rs.getInt("IdSerie");
		String genero = rs.getString("Genero");
		genSe = new GeneroSerie(idSerie, genero);
		return genSe;
	}

	@Override
	protected String[] getKeyColumnName() {
		return GENEROSERIE_KEY_NAME;
	}

	@Override
	protected String[] getKeyValues(GeneroSerie id) {
		return new String[] {""+id.getIdSerie(), id.getGeneroSerie().toString()};
	}

	@Override
	protected Object[] serializableObject(GeneroSerie objeto) {
		return new Object[] {objeto.getIdSerie(), objeto.getGeneroSerie()};
	}

	@Override
	protected String[] getValuesKeyFromObject(GeneroSerie objeto) {
		return new String[] {""+objeto.getIdSerie(), objeto.getGeneroSerie().toString()};
	}
	
	public List<Genero> getGenerosofSerie (int idSerie)
	{
		List<Genero> ret = new ArrayList<Genero>();
		QueryCondition[] conditions = new QueryCondition[] { new QueryCondition("IdSerie", Operator.IG, idSerie)};
		List<GeneroSerie> aux = findByCondition(conditions);
		for (int i=0; i<aux.size(); i++)
		{
			ret.add(new Genero(aux.get(i).getGeneroSerie().toString()));
		}
		return ret;
	}

	@Override
	protected GeneroSerie getIdFromObject(GeneroSerie objeto) {
		return objeto;
	}

	@Override
	protected String getNameToSearch() {
		return GENEROSERIE_COLUMN_NAME[1];
	}

}
