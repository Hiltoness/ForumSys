package javabean;
//数据库修改删除
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mysql_operate {
	
	  private PreparedStatement pstm;     

	  private Connection conn;
	//删掉where的那个数是整数类型
	  public void delete_DBInt(String table,int wherevalue,String whereatt) {
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("delete from "+table+" where "+whereatt+" =?");
					pstm.setInt(1, wherevalue);
					pstm.executeUpdate();
				
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}
	//删掉where的那个数是字符串类型
	  public void delete_DBString(String table,String wherevalue,String whereatt) {
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

	  //更新的那个数是字符串类型
	  public void update_DBString(String table,String setvalue,String setatt,String wherevalue,String whereatt) {
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
	  //更新的那个数是整数类型
	  public void update_DBInt(String table,int setvalue,String setatt,String wherevalue,String whereatt) {
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("update "+table+" set "+setatt+" =? where "+whereatt+" =?");					
					pstm.setInt(1, setvalue);
					pstm.setString(2, wherevalue);
					pstm.executeUpdate();
							
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}



}
