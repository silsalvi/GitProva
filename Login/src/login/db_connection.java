package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_connection {

	public db_connection() {
		// TODO Auto-generated constructor stub
	}
	public Connection db() {
	Connection con = null;
	String url = "jdbc:mysql://localhost/";
	String db = "prova";
	String driver = "com.mysql.jdbc.Driver";
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}  

	try {
		con = DriverManager.getConnection(url + db, "root", "");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
	}
}
