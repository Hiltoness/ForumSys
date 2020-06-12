package javabean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mysql_insert {

	  private PreparedStatement pstm;     
	  private String diverclass="com.mysql.jdbc.Driver";
	  private String username="jdbc:mysql://localhost/visual";
	  private String password="root";
	  private String url="root";
	  private Connection conn;
	  
public void manager_InserData(String mid,String notitle,String notice,String notime) {
	 try {
			Class.forName(diverclass);
			conn=DriverManager.getConnection(url,username,password);
			pstm=conn.prepareStatement("insert into manager values(?,?,?,?)");
			pstm.setString(1, mid);
			pstm.setString(2, notitle);
			pstm.setString(3,notice );
			pstm.setString(4,notime );
			pstm.executeUpdate();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void post_InserData(String aid,String title,String content) {
	 try {
			Class.forName(diverclass);
			conn=DriverManager.getConnection(url,username,password);
			pstm=conn.prepareStatement("insert into post values(?,?,?)");
			pstm.setString(1, aid);
			pstm.setString(2, title);
			pstm.setString(3,content );
			pstm.executeUpdate();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void uco_InserData(String uid,String aid,String cotime) {
	 try {
			Class.forName(diverclass);
			conn=DriverManager.getConnection(url,username,password);
			pstm=conn.prepareStatement("insert into uco values(?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, aid);
			pstm.setString(3,cotime );
			pstm.executeUpdate();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void user_InserData(String uid,String uname,String utime,String sex,String password,String point,String level) {
	 try {
			Class.forName(diverclass);
			conn=DriverManager.getConnection(url,username,password);
			pstm=conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, uname);
			pstm.setString(3,utime);
			pstm.setString(4,sex);
			pstm.setString(5,password);
			pstm.setString(6,point);
			pstm.setString(7,level);
			pstm.executeUpdate();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void usercomment_InserData(String uid,String aid,String rid,String cid,String comment,String ctime,String status) {
	 try {
			Class.forName(diverclass);
			conn=DriverManager.getConnection(url,username,password);
			pstm=conn.prepareStatement("insert into usercomment values(?,?,?,?,?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, aid);
			pstm.setString(3,rid);
			pstm.setString(4,cid);
			pstm.setString(5,comment);
			pstm.setString(6,ctime);
			pstm.setString(7,status);
			pstm.executeUpdate();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void userpost_InserData(String uid,String aid,String atime) {
	 try {
			Class.forName(diverclass);
			conn=DriverManager.getConnection(url,username,password);
			pstm=conn.prepareStatement("insert into userpost values(?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, aid);
			pstm.setString(3,atime);
			pstm.executeUpdate();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void userpraise_InserData(String uid,String aid,String rid,String praise,String ptime,String status) {
	 try {
			Class.forName(diverclass);
			conn=DriverManager.getConnection(url,username,password);
			pstm=conn.prepareStatement("insert into userpraise values(?,?,?,?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, aid);
			pstm.setString(3,rid);
			pstm.setString(4,praise);
			pstm.setString(5,ptime);
			pstm.setString(6,status);
			pstm.executeUpdate();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void userreply_InserData(String uid,String aid,String rid,String reply,String rtime,String status) {
	 try {
			Class.forName(diverclass);
			conn=DriverManager.getConnection(url,username,password);
			pstm=conn.prepareStatement("insert into user values(?,?,?,?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, aid);
			pstm.setString(3,rid);
			pstm.setString(4,reply);
			pstm.setString(5,rtime);
			pstm.setString(6,status);
			pstm.executeUpdate();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}
public void userreport_a_InserData(String uid,String aid,String report,String retime,String status) {
	 try {
			Class.forName(diverclass);
			conn=DriverManager.getConnection(url,username,password);
			pstm=conn.prepareStatement("insert into user values(?,?,?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, aid);
			pstm.setString(3,report);
			pstm.setString(4,retime);
			pstm.setString(5,status);
			pstm.executeUpdate();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void userreport_c_InserData(String uid,String aid,String rid,String cid,String report,String retime,String status) {
	 try {
			Class.forName(diverclass);
			conn=DriverManager.getConnection(url,username,password);
			pstm=conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, aid);
			pstm.setString(3, rid);
			pstm.setString(4, cid);
			pstm.setString(5,report);
			pstm.setString(6,retime);
			pstm.setString(7,status);
			pstm.executeUpdate();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

public void userreport_r_InserData(String uid,String aid,String rid,String report,String retime,String status) {
	 try {
			Class.forName(diverclass);
			conn=DriverManager.getConnection(url,username,password);
			pstm=conn.prepareStatement("insert into user values(?,?,?,?,?,?)");
			pstm.setString(1, uid);
			pstm.setString(2, aid);
			pstm.setString(3, rid);
			pstm.setString(4,report);
			pstm.setString(5,retime);
			pstm.setString(6,status);
			pstm.executeUpdate();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}

}
