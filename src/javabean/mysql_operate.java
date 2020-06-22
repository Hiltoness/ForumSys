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

	  private Connection conn;
	  public void delete_DB(String table,String wherevalue,String whereatt) {
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("delete from "+table+" where "+whereatt+" =?");
					pstm.setString(1, wherevalue);
					pstm.executeUpdate();
				
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}

	  public void update_DB(String table,String setvalue,String setatt,String wherevalue,String whereatt) {
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("update "+table+" set "+setatt+" =? where "+whereatt+" =?");					
					pstm.setString(1, setvalue);
					pstm.setString(2, wherevalue);
					pstm.executeUpdate();
					
				
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}



}
