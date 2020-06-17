package com.articulos.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection jdbcConnection=null;
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    
    public Conexion(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
 
	public void conectar() throws SQLException{
		String url = jdbcURL;
		String user = jdbcUsername;
		String password =jdbcPassword;
                try {
                	Class.forName("com.mysql.cj.jdbc.Driver");
                	jdbcConnection = DriverManager.getConnection(url, user, password);
		            if (jdbcConnection!= null) {
		                System.out.println("Exito al conectar a la base de datos");
		            }
				} catch (SQLException ex) {
				    System.out.println("SQLException: " + ex.getMessage());
				    System.out.println("SQLState: " + ex.getSQLState());
				    System.out.println("VendorError: " + ex.getErrorCode());
				} catch (ClassNotFoundException e) {
				    // TODO Auto-generated catch block
				    e.printStackTrace();
                }
	}
    public void desconectar() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
 
	public Connection getJdbcConnection() {
		return jdbcConnection;
	}  
}
