package javabean;
//连接数据库
import java.sql.*;
public class mysql_DB {
	  static String diverclass="com.mysql.jdbc.Driver";
	  static String username="jdbc:mysql://localhost/visual";
	  static String password="root";
	  static String url="root";
	  static Connection aConnection;
	  public Connection connectDB() {
		  try {
				Class.forName(diverclass);
				aConnection=DriverManager.getConnection(url,username,password);		
			}catch(ClassNotFoundException e1){
				e1.printStackTrace();
			}catch(SQLException ex){
			ex.printStackTrace();
			}		
			return aConnection;
	  }
}
