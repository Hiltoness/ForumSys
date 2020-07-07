package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mysql_insert {

	  private PreparedStatement pstm;     
	
	  private Connection conn;
	  
public void manager_InserData(int mid,String notitle,String notice,String notime) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into manager values(?,0,?,?,?)");
			pstm.setInt(1, mid);
			pstm.setString(2, notitle);
			pstm.setString(3,notice );
			pstm.setString(4,notime );
			
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void post_InserData(String title,String content) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into post values(0,?,?)");
			
			pstm.setString(1, title);
			pstm.setString(2,content );
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void uco_InserData(int uid,int aid,String cotime) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into uco values(?,?,?)");
			pstm.setInt(1, uid);
			pstm.setInt(2, aid);
			pstm.setString(3,cotime );
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void user_InserData(String uname,String utime,String sex,String password,int point,int level,String college) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into user values(0,?,?,?,?,?,?,?)");
			
			pstm.setString(1, uname);
			pstm.setString(2,utime);
			pstm.setString(3,sex);
			pstm.setString(4,password);
			pstm.setInt(5,point);
			pstm.setInt(6,level);
			pstm.setString(7,college);
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void usercomment_InserData(int uid,int aid,int rid,String comment,String ctime,String status) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into usercomment values(?,?,?,0,?,?,?)");
			pstm.setInt(1, uid);
			pstm.setInt(2, aid);
			pstm.setInt(3,rid);
		
			pstm.setString(4,comment);
			pstm.setString(5,ctime);
			pstm.setString(6,status);
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void userpost_InserData(int uid,int aid,String atime) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into userpost values(?,?,?)");
			pstm.setInt(1, uid);
			pstm.setInt(2, aid);
			pstm.setString(3,atime);
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void userpraise_InserData(int uid,int aid,int rid,String praise,String ptime,String status) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into userpraise values(?,?,?,?,?,?)");
			pstm.setInt(1, uid);
			pstm.setInt(2, aid);
			pstm.setInt(3,rid);
			pstm.setString(4,praise);
			pstm.setString(5,ptime);
			pstm.setString(6,status);
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void userreply_InserData(int uid,int aid,String reply,String rtime,String status) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into userreply values(?,?,0,?,?,?)");
			pstm.setInt(1, uid);
			pstm.setInt(2, aid);
			
			pstm.setString(3,reply);
			pstm.setString(4,rtime);
			pstm.setString(5,status);
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}
public void userreport_a_InserData(int uid,int aid,String report,String retime,String status) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into userreport_a values(?,?,?,?,?)");
			pstm.setInt(1, uid);
			pstm.setInt(2, aid);
			pstm.setString(3,report);
			pstm.setString(4,retime);
			pstm.setString(5,status);
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void userreport_c_InserData(int uid,int aid,int rid,int cid,String report,String retime,String status) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into userreport_c values(?,?,?,?,?,?,?)");
			pstm.setInt(1, uid);
			pstm.setInt(2, aid);
			pstm.setInt(3, rid);
			pstm.setInt(4, cid);
			pstm.setString(5,report);
			pstm.setString(6,retime);
			pstm.setString(7,status);
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void userreport_r_InserData(int uid,int aid,int rid,String report,String retime,String status) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into userreport_r values(?,?,?,?,?,?)");
			pstm.setInt(1, uid);
			pstm.setInt(2, aid);
			pstm.setInt(3, rid);
			pstm.setString(4,report);
			pstm.setString(5,retime);
			pstm.setString(6,status);
			pstm.executeUpdate();
	
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}
public void manager_user_InserData(int pid,int uid,String status) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into manager_user values(?,?,?)");
			pstm.setInt(1, pid);
			pstm.setInt(2, uid);
			pstm.setString(3, status);

			
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

}
