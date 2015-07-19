/* ******************************************************************************
*																				*
*		Practica ABD - Series													*
*		Autores:	David Garcia Alvarez										*
*					Javier Toledano Regaño										*
*								3ºB												*
*********************************************************************************/

package bbdd.patterns;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;

import bbdd.patterns.query.Operator;
import bbdd.patterns.query.QueryCondition;

import com.mchange.v2.c3p0.ComboPooledDataSource;





public abstract class AbstractMapper<T,K> {

	protected DataSource ds;

	protected abstract String getTableName();

	protected abstract String[] getColumnNames();

	protected abstract T buildObject(ResultSet rs) throws SQLException;

	protected abstract String[] getKeyColumnName();	
	
	protected abstract String[] getKeyValues(K id) ;
	
	protected abstract Object[] serializableObject(T objeto);
	
	protected abstract String[] getValuesKeyFromObject(T objeto);
	
	protected abstract K getIdFromObject(T objeto);
	
	protected abstract String getNameToSearch();

	public AbstractMapper() {
		this.ds = Conexion.dameDataSource();
	}

	protected List<T> findByCondition(QueryCondition[] conditions)
	{
		Connection con        = null;
		PreparedStatement pst = null;
		ResultSet rs          = null;
		List<T> result       = new ArrayList<T>();
		try {
			con = ds.getConnection();
			String[] columnNames = getColumnNames();
			String columnNamesWithCommas = StringUtils.join(columnNames, ", ");
			String[] conditionStr = new String[conditions.length];
			for (int i=0; i<conditionStr.length; i++)
			{
				conditionStr[i] = conditions[i].getColumName() + " "
									+ conditions[i].getOperacion().toString() + " ?";
			}
			pst = con.prepareStatement(
					"SELECT " + columnNamesWithCommas + " FROM " + getTableName() +  
					" WHERE " + StringUtils.join(conditionStr, " AND ")
					);
			for (int i=0; i<conditions.length;i++)
			{
				pst.setObject(i+1, conditions[i].getObjeto());
			}
			
			rs = pst.executeQuery();
			while (rs.next()) {
				result.add(buildObject(rs));
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (Exception e) {}
		}
		
		
		return result;
	}
	
	public T findById(K id) {
		T result       = null;		
		String[] keyNameColum = getKeyColumnName(); 
		String[] keyValues = getKeyValues(id);
		QueryCondition[] condition = new QueryCondition[keyNameColum.length];
		for (int i=0; i< keyNameColum.length; i++)
		{
			condition[i]=new QueryCondition(keyNameColum[i],
									Operator.IG, keyValues[i]);
		}
		List<T> listaClave = findByCondition(condition);
		if (!listaClave.isEmpty())
			result= listaClave.get(0);
		return result;
	}
	
	
	public boolean update(T old, T newObjeto)
	{
		Connection con        = null;
		PreparedStatement pst = null;
		ResultSet rs          = null;
		T objetos = findById(getIdFromObject(old));
		if (objetos == null)
			return false;
		try {
			con = ds.getConnection();
			String[] columnNames = getColumnNames();
			String[] keyColumnNames = getKeyColumnName();
			String[] assignaments = new String[columnNames.length];
			String[] keyValues = new String[keyColumnNames.length];
			for (int i=0; i<assignaments.length; i++)
			{
				assignaments[i] = columnNames[i] + " = ?";
			}
			for (int i=0; i<keyValues.length; i++)
			{
				keyValues[i] = keyColumnNames[i] + " = ?";
			}
			pst = con.prepareStatement( "UPDATE " + getTableName() + " SET "
						+ StringUtils.join(assignaments, ", ")
						+ " WHERE " + StringUtils.join(keyValues," AND "));
			
			Object [] objectFields = serializableObject(newObjeto);
			
			int j = 1;
			for (int i = 0 ; i< objectFields.length; i++)
			{
				pst.setObject(j, objectFields[i]);
				j++;
			}
			String[] key = getValuesKeyFromObject(old);
			for (int i = 0 ; i < keyValues.length; i++)
			{
				pst.setObject(j, key[i]);
				j++;
			}					
			pst.executeUpdate();
			
			} 
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (Exception e) {}
		}
		return true;
	}
	
	public boolean insert(T objeto)
	{
		
		T objetos = findById(getIdFromObject(objeto));
		if (objetos != null)
			return false;
		Connection con        = null;
		PreparedStatement pst = null;
		ResultSet rs          = null;
		
		try {
			con = ds.getConnection();
			String[] columnNames = getColumnNames();
			String[] interrogations = new String[columnNames.length];
			for (int i=0; i< interrogations.length; i++)
			{
				interrogations[i]= " ? ";
			}
			pst = con.prepareStatement( "INSERT INTO " + getTableName() + " ("
						+ StringUtils.join(columnNames, ", ") + ") values ("
						+ StringUtils.join(interrogations, ", ") + ")");
			
			Object [] objectFields = serializableObject(objeto);
			
			for (int i = 0 ; i< objectFields.length; i++)
			{
				pst.setObject(i+1, objectFields[i]);
			}				
			pst.executeUpdate();
			
			} 
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (Exception e) {}
		}
		return true;
	}
	
	public boolean delete (T objeto)
	{
		T objetos = findById(getIdFromObject(objeto));
		if (objetos == null)
			return false;
		Connection con        = null;
		PreparedStatement pst = null;
		ResultSet rs          = null;
		
		try {
			con = ds.getConnection();
			String[] columnKeyNames = getKeyColumnName();
			String[] interrogations = new String[columnKeyNames.length];
			for (int i=0; i< interrogations.length; i++)
			{
				interrogations[i]= columnKeyNames[i] + " = ? ";
			}
			pst = con.prepareStatement( "DELETE FROM " + getTableName() + " WHERE "
						+ StringUtils.join(interrogations, " AND "));
			
			Object [] objectFields = getValuesKeyFromObject(objeto);
			
			for (int i = 0 ; i< objectFields.length; i++)
			{
				pst.setObject(i+1, objectFields[i]);
			}				
			pst.executeUpdate();
			
			} 
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (Exception e) {}
		}
		return true;
	}
	
	public List<T> findAllWithName(String name) {
		List<T> result = new ArrayList<T>();
		QueryCondition[] condition = new QueryCondition[1];
		
		condition[0]= new QueryCondition(getNameToSearch(), Operator.LIK, "%"+name+"%");
		
		result = findByCondition(condition);
		
		return result;
		
	}
	
	private static class Conexion {
		private static ComboPooledDataSource cpds;
		
		
		public static ComboPooledDataSource dameDataSource()
		{
			if (cpds==null)
			{
				cpds = new ComboPooledDataSource();
				try {
					cpds.setDriverClass("org.gjt.mm.mysql.Driver");
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
				cpds.setJdbcUrl("jdbc:mysql://localhost/practica1");
				cpds.setUser("UsuarioP1");
				cpds.setPassword("pass");
			}
			return cpds;
		}
		
		
	}
	

}