package com.emp.dp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtility {
	 
	public static Connection getCOnnection(){
		Connection con=null;
		try {
			File path=new File("D:\\Javaneonworkspace\\CrudJdbc\\src\\main\\resources\\db.properties");
			FileInputStream fis=new FileInputStream(path);
			Properties p=new Properties();
			p.load(fis);
			Class.forName(p.getProperty("driver"));
			con=DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("password"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return con;
		
	}
	
	
	
}
