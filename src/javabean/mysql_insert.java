package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mysql_insert {

	  private PreparedStatement pstm;     
	
	  private Connection conn;
	  
public void manager_InserData(String mid,String pid,String notitle,String notice,String notime) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into manager values(?,?,?,?,?)");
			pstm.setString(1, mid);
			pstm.setString(2, pid);
			pstm.setString(3, notitle);
			pstm.setString(4,notice );
			pstm.setString(5,notime );
			
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void post_InserData(String aid,String title,String content) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into post values(?,?,?)");
			pstm.setString(1, aid);
			pstm.setString(2, title);
			pstm.setString(3,content );
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void uco_InserData(String uid,String aid,String cotime) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into uco values(?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, aid);
			pstm.setString(3,cotime );
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void user_InserData(String uid,String uname,String utime,String sex,String password,int point,int level,String college) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into user values(?,?,?,?,?,?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, uname);
			pstm.setString(3,utime);
			pstm.setString(4,sex);
			pstm.setString(5,password);
			pstm.setInt(6,point);
			pstm.setInt(7,level);
			pstm.setString(8,college);
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void usercomment_InserData(String uid,String aid,String rid,String cid,String comment,String ctime,String status) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into usercomment values(?,?,?,?,?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, aid);
			pstm.setString(3,rid);
			pstm.setString(4,cid);
			pstm.setString(5,comment);
			pstm.setString(6,ctime);
			pstm.setString(7,status);
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void userpost_InserData(String uid,String aid,String atime) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into userpost values(?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, aid);
			pstm.setString(3,atime);
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void userpraise_InserData(String uid,String aid,String rid,String praise,String ptime,String status) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into userpraise values(?,?,?,?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, aid);
			pstm.setString(3,rid);
			pstm.setString(4,praise);
			pstm.setString(5,ptime);
			pstm.setString(6,status);
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void userreply_InserData(String uid,String aid,String rid,String reply,String rtime,String status) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into user values(?,?,?,?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, aid);
			pstm.setString(3,rid);
			pstm.setString(4,reply);
			pstm.setString(5,rtime);
			pstm.setString(6,status);
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}
public void userreport_a_InserData(String uid,String aid,String report,String retime,String status) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into user values(?,?,?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, aid);
			pstm.setString(3,report);
			pstm.setString(4,retime);
			pstm.setString(5,status);
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void userreport_c_InserData(String uid,String aid,String rid,String cid,String report,String retime,String status) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, aid);
			pstm.setString(3, rid);
			pstm.setString(4, cid);
			pstm.setString(5,report);
			pstm.setString(6,retime);
			pstm.setString(7,status);
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void userreport_r_InserData(String uid,String aid,String rid,String report,String retime,String status) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into user values(?,?,?,?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, aid);
			pstm.setString(3, rid);
			pstm.setString(4,report);
			pstm.setString(5,retime);
			pstm.setString(6,status);
			pstm.executeUpdate();
	
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}
public void manager_user_InserData(String pid,String uid,String status) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("insert into manager_user values(?,?,?)");
			pstm.setString(1, pid);
			pstm.setString(2, uid);
			pstm.setString(3, status);

			
			pstm.executeUpdate();
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

}
