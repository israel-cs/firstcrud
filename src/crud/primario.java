package crud;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class primario {

	public static void main(String[] args) {
		
		Connection con = null; //conecta o banco
		Statement st = null; //preparar uma consulta ao SQL
		ResultSet rs = null; //resultado da consulta
		try {
			con=DB.getConnection();
			st=con.createStatement();
			rs = st.executeQuery("select * from department");
			while(rs.next()) {
				System.out.println(rs.getInt("ID")+ " - "+rs.getString("Name"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}			
	}
}