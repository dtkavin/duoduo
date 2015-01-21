package org.bcsfll.common.utility.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnectFactory {
	private static DBConnectFactory  instance;
	private static  String db_url =null;
	private static  String db_username =null;
	private static  String db_password=null;
	public static DBConnectFactory getInstance(String dbUrl,String className,String userName,String passWord) {
		if (instance == null) {
			instance = new DBConnectFactory(dbUrl,className,userName,passWord);
		}
		return instance;
	}
	private DBConnectFactory(String dbUrl,String className,String userName,String passWord){
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db_url=dbUrl;
		db_username=userName;
		db_password=passWord;
	}
	public static Connection getConnection() {
		try {
			return  DriverManager.getConnection(db_url, db_username, db_password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void close(ResultSet resultSet, Statement statement,Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
	}
}
