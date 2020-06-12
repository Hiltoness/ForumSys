package javabean;
//数据库修改删除
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class mysql_operate {
	
	  private PreparedStatement pstm;     
	  private String diverclass="com.mysql.jdbc.Driver";
	  private String username="jdbc:mysql://localhost/visual";
	  private String password="root";
	  private String url="root";
	  private Connection conn;
	  public void delete_DB(String table,String wherevalue,String whereatt) {
			 try {
					Class.forName(diverclass);
					conn=DriverManager.getConnection(url,username,password);
					pstm=conn.prepareStatement("delete from "+table+" where "+whereatt+" =?");
					pstm.setString(1, wherevalue);
					pstm.executeUpdate();
				}catch(ClassNotFoundException e1){
					e1.printStackTrace();
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}

	  public void update_DB(String table,String setvalue,String setatt,String wherevalue,String whereatt) {
			 try {
					Class.forName(diverclass);
					conn=DriverManager.getConnection(url,username,password);
					pstm=conn.prepareStatement("update "+table+" set "+setatt+" =? where "+whereatt+" =?");					
					pstm.setString(1, setvalue);
					pstm.setString(2, wherevalue);
					pstm.executeUpdate();
					
				}catch(ClassNotFoundException e1){
					e1.printStackTrace();
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}



}
