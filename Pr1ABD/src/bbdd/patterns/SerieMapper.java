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

import series.modelo.Genero;
import series.modelo.Serie;

public class SerieMapper extends AbstractMapper<Serie, Integer>{
	private static final String[] SERIE_KEY_COLUMN_NAME = new String[] {"ID"};
	private static final String[] SERIE_COLUMN_NAMES = new String[] {SERIE_KEY_COLUMN_NAME[0], "Nombre", "Titular", "Sinopsis","AnoEstreno","AnoFin"};
	private static final String SERIE_TABLE_NAME = "series";
	
	public SerieMapper() {
		super();
	}
	
	@Override
	protected String getTableName() {
		
		return SERIE_TABLE_NAME;
	}

	@Override
	protected String[] getColumnNames() {
		return SERIE_COLUMN_NAMES;
	}

	@Override
	protected Serie buildObject(ResultSet rs) throws SQLException {
		Serie serie;
		int id= rs.getInt("ID");
		String nom = rs.getString("Nombre");
		String tit = rs.getString("Titular");
		String sino = rs.getString("Sinopsis");
		int anoE = rs.getInt("AnoEstreno");
		int anoF = rs.getInt("AnoFin");		
		if (anoF==0)
			serie= new Serie(id, nom, tit, sino, anoE);
		else
			serie = new Serie(id, nom, tit, sino, anoE, anoF);
		GeneroSerieMapper aux = new GeneroSerieMapper();
		List<Genero> aux1 = aux.getGenerosofSerie(id);
		for (int i=0; i<aux1.size(); i++)
		{
			serie.setGenero(aux1.get(i));
		}
		return serie;
	}

	@Override
	protected String[] getKeyColumnName() {
		return SERIE_KEY_COLUMN_NAME;
	}

	

	@Override
	protected String[] getKeyValues(Integer id) {
		return new String[] {id.toString()};
	}
	

	@Override
	protected Object[] serializableObject(Serie objeto) {
		return new Object[]{objeto.getId(), objeto.getNombre(), objeto.getTitular(), 
				objeto.getSinopsis(), objeto.getAnoEstreno(), objeto.getAnoFin()};
	}

	@Override
	protected String[] getValuesKeyFromObject(Serie objeto) {
		return new String[] {""+objeto.getId()};
	}

	@Override
	protected Integer getIdFromObject(Serie objeto) {
		return objeto.getId();
	}

	@Override
	protected String getNameToSearch() {
		return SERIE_COLUMN_NAMES[1];
	}

}
