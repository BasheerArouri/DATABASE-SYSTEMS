package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBcone {
	
	public static String dbuusername="root";
	public static String dbupassword="salma@eng1234";
	public static String URL="127.0.0.1";
	public static String pport ="3306";
	public static String ddname="training_school";
	
public static Connection ccon ;	
private Connection con ;
private String sdbuuesrname;
private String password;
private String url;
private String port;
private String dname;
private static String dural ;
public DBcone( String dbuuesrname, String password, String url, String port, String dname) {
	super();
	this.sdbuuesrname = dbuuesrname;
	this.password = password;
	this.url = url;
	this.port = port;
	this.dname = dname;
}

public  Connection contDB() throws ClassNotFoundException, SQLException {
	
	dural="jdbc:mysql://" + url + ":" +port + "/" + dname + "?verifyServerCerificate=fales";
	Properties p=new Properties();
	p.setProperty("users","dbuusername");
	p.setProperty("password","dbupassword");
	p.setProperty("UseSSL","false");
	p.setProperty("autoReconnect","true");
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection(dural,sdbuuesrname,password);
	
	
	return con; 
	
	
}


}