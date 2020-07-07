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
		//删掉where的那个数是整数类型 两个参数
	  public void delete_DBInt2(String table,int wherevalue,String whereatt,int wherevalue2,String whereatt2) {
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("delete from "+table+" where "+whereatt+" =? and "+whereatt2+" =? ");
					pstm.setInt(1, wherevalue);
					pstm.setInt(2, wherevalue2);
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


	  //更新的where是字符串类型
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
	//更新的where是字符串类型 2个参数
	  public void update_DBString2(String table,String setvalue,String setatt,String wherevalue,String whereatt,String wherevalue2,String whereatt2) {
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("update "+table+" set "+setatt+" =? where "+whereatt+" =? and"+whereatt2+" =?");					
					pstm.setString(1, setvalue);
					pstm.setString(2, wherevalue);
					pstm.setString(3, wherevalue2);
					pstm.executeUpdate();
							
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}
		//更新的where是字符串类型 3个参数
	  public void update_DBString3(String table,String setvalue,String setatt,String wherevalue,String whereatt,String wherevalue2,String whereatt2,String wherevalue3,String whereatt3) {
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("update "+table+" set "+setatt+" =? where "+whereatt+" =? and"+whereatt2+" =? and"+whereatt3+" =?");					
					pstm.setString(1, setvalue);
					pstm.setString(2, wherevalue);
					pstm.setString(3, wherevalue2);
					pstm.setString(4, wherevalue3);
					pstm.executeUpdate();
							
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}
		//更新的where是字符串类型 4个参数
	  public void update_DBString4(String table,String setvalue,String setatt,String wherevalue,String whereatt,String wherevalue2,String whereatt2,String wherevalue3,String whereatt3,String wherevalue4,String whereatt4) {
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("update "+table+" set "+setatt+" =? where "+whereatt+" =? and"+whereatt2+" =? and"+whereatt3+" =? and"+whereatt4+" =?");					
					pstm.setString(1, setvalue);
					pstm.setString(2, wherevalue);
					pstm.setString(3, wherevalue2);
					pstm.setString(4, wherevalue3);
					pstm.setString(5, wherevalue4);
					pstm.executeUpdate();
							
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}
	  //更新的where是整数类型
	  public void update_DBInt(String table,String setvalue,String setatt,int wherevalue,String whereatt) {
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("update "+table+" set "+setatt+" =? where "+whereatt+" =?");					
					pstm.setString(1, setvalue);
					pstm.setInt(2, wherevalue);
					pstm.executeUpdate();
							
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}
		//更新的where是整数类型 2个参数
	  public void update_DBInt2(String table,String setvalue,String setatt,int wherevalue,String whereatt,int wherevalue2,String whereatt2) {
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("update "+table+" set "+setatt+" =? where "+whereatt+" =? and"+whereatt2+" =?");					
					pstm.setString(1, setvalue);
					pstm.setInt(2, wherevalue);
					pstm.setInt(3, wherevalue2);
					pstm.executeUpdate();
							
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}
	//更新的where是整数类型 3个参数
	  public void update_DBInt3(String table,String setvalue,String setatt,int wherevalue,String whereatt,int wherevalue2,String whereatt2,int wherevalue3,String whereatt3) {
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("update "+table+" set "+setatt+" =? where "+whereatt+" =? and"+whereatt2+" =? and"+whereatt3+" =?");					
					pstm.setString(1, setvalue);
					pstm.setInt(2, wherevalue);
					pstm.setInt(3, wherevalue2);
					pstm.setInt(4, wherevalue3);
					pstm.executeUpdate();
							
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}
		//更新的where是整数类型 4个参数
	  public void update_DBInt4(String table,String setvalue,String setatt,int wherevalue,String whereatt,int wherevalue2,String whereatt2,int wherevalue3,String whereatt3,int wherevalue4,String whereatt4) {
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("update "+table+" set "+setatt+" =? where "+whereatt+" =? and"+whereatt2+" =? and"+whereatt3+" =? and"+whereatt4+" =?");					
					pstm.setString(1, setvalue);
					pstm.setInt(2, wherevalue);
					pstm.setInt(3, wherevalue2);
					pstm.setInt(4, wherevalue3);
					pstm.setInt(5, wherevalue4);
					pstm.executeUpdate();
							
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}
	//更新的where和set都是整数类型 
	  public void update_DBInt11(String table,int setvalue,String setatt,int wherevalue,String whereatt) {
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("update "+table+" set "+setatt+" =? where "+whereatt+" =?");					
					pstm.setInt(1, setvalue);
					pstm.setInt(2, wherevalue);
					pstm.executeUpdate();
							
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}



}
