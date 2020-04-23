package com.emp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.emp.bo.EmpBO;

public class EmpDAO {
	private static final String EMP_INSERT_QUERY="INSERT INTO EMPDETAILS VALUES(?,?,?,?,?,?,?)";

	public int insert(EmpBO bo)
	{
		//InitialContext ic = null;
		//DataSource ds = null;
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			/*
			 * //create initial context
			 *  ic = new InitialContext();
			 * 
			 * //get data source object through loo up operation ds = (DataSource)
			 * ic.lookup("DsJndi");
			 * 
			 * //get connection from jdbc connection pool
			 *  con = ds.getConnection();
			 */
			
			//
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// create con object....
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system","manager");
			
			//create prepared statement object
			ps = con.prepareStatement(EMP_INSERT_QUERY);
			
			//set values to the query params
			ps.setInt(1, bo.getEmpNo());
			ps.setString(2, bo.getEmpName());
			ps.setString(3, bo.getEmpAddr());
			ps.setFloat(4, bo.getBasicSalary());
			ps.setFloat(5, bo.getGrossSalary());
			ps.setFloat(6, bo.getNetSalary());
			ps.setInt(7, bo.getDeptNo());
			
			//execute query....
			result = ps.executeUpdate();
			}// end of try block
		
		catch (SQLException e)
			{
				e.printStackTrace();
			}
		catch (Exception e)
			{
				e.printStackTrace();
			}
			
			finally {
					try {
						if(ps != null)
							ps.close();
						}
					catch (SQLException e) 
						{
							e.printStackTrace();
						}
					
					try {
						if(con != null)
							con.close();
						}
					catch (SQLException e) 
						{
							e.printStackTrace();
						}
			}// end of finally bloack
			
			return result;
		}// end of method
}// end of dao class
