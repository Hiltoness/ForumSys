package javabean;
//连接数据库
import java.sql.*;
public class mysql_DB {
	  static String diverclass="com.mysql.jdbc.Driver";
	  static String username="root";
	  static String password="";
	  static String url="jdbc:mysql://localhost/visual?serverTimezone=UTC&characterEncoding=utf8";
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
	  public void close(Connection conn){
			if(conn != null) {
				try {
					conn.close();
					conn = null;
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
}
