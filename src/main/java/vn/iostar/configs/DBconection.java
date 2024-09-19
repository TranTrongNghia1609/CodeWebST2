package vn.iostar.configs;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconection {
	
	 private final String serverName = "NGHIATRAN";
	 private final String dbName = "ltwebst2";
	 private final String portNumber = "1433";
	 private final String userID = "nhan";
	 private final String password = "123";
	 public Connection getConnection() throws Exception {



	 String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;


	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");


	 return DriverManager.getConnection(url, userID, password);


	 }





	 public static void main(String[] args) {


	 try {


	 System.out.println(new DBconection().getConnection());


	 } catch (Exception e) {


	 e.printStackTrace();


	 }


	 }




}
