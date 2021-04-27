package fr.doranco.livretout.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class LivreToutDataSource {


// sinon je le fais en mode singleton
	 private static LivreToutDataSource instance; 
	private LivreToutDataSource(){
		}
	

	
	public Connection getConnection() throws SQLException {
		
		String user ="root";
		String password = "root";
		String url = "jdbc:mysql://127.0.0.1:3306/livretout_db";
		//Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connexion = DriverManager.getConnection(url,user, password);
		return connexion;
		
	}
		
		 public static LivreToutDataSource getInstance(){
		 if(instance==null){
		  instance = new LivreToutDataSource();
		 }
		 return instance;
		
	}

	
}
		 

