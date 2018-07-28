package com.cg.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import com.cg.exception.AccountException;

public class DBUtil {
	
	public static Connection getConnection() throws AccountException{
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url,"system","orcl11g");
		}catch(ClassNotFoundException e){
			throw new AccountException(e.getMessage());
		}catch(SQLException e){
			throw new AccountException(e.getMessage());
		}
	}
	
}
