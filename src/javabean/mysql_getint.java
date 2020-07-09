package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class mysql_getint {
	  private PreparedStatement pstm;     
	  
	  private Connection conn;
	  private ResultSet rs;
	  
public ArrayList<manager> manager_getData(String attwhere,int attvalue) {
	ArrayList<manager> managerlist=new ArrayList<manager> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from message where "+attwhere+" =?");
			pstm.setInt(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				manager bean=new manager();
				bean.setMid(rs.getInt(1));
				bean.setPid(rs.getInt(2));
				bean.setNotitle(rs.getString(3));
				bean.setNotice(rs.getString(4));
				bean.setNotime(rs.getString(5));
				
				managerlist.add(bean);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return managerlist;
}

public ArrayList<post> post_getData(String attwhere,int attvalue) {
	ArrayList<post> postlist=new ArrayList<post> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from post where "+attwhere+" =?");
			pstm.setInt(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				post bean=new post();
				bean.setAid(rs.getInt(1));
				bean.setTitle(rs.getString(2));
				bean.setContent(rs.getString(3));
				postlist.add(bean);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return postlist;
}

public ArrayList<uco> uco_getData(String attwhere,int attvalue) {
	ArrayList<uco> ucolist=new ArrayList<uco> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from uco where "+attwhere+" =?");
			pstm.setInt(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				uco bean=new uco();
				bean.setUid(rs.getInt(1));
				bean.setAid(rs.getInt(2));
				bean.setCotime(rs.getString(3));
				ucolist.add(bean);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return ucolist;
}

public ArrayList<user> user_getData(String attwhere,int attvalue) {
	ArrayList<user> userlist=new ArrayList<user> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from user where "+attwhere+" =?");
			pstm.setInt(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				user bean=new user();
				bean.setUid(rs.getInt(1));
				bean.setUname(rs.getString(2));
				bean.setUtime(rs.getString(3));
				bean.setSex(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setPoint(rs.getInt(6));
				bean.setLevel(rs.getInt(7));
				bean.setCollege(rs.getString(8));
				userlist.add(bean);
				
			}
		db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return userlist;
}

public ArrayList<usercomment> usercomment_getData(String attwhere1,int attvalue1,String attwhere2,int attvalue2) {
	ArrayList<usercomment> usercommentlist=new ArrayList<usercomment> ();
	try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from usercomment where "+attwhere1+" =? and "+attwhere2+" =?");
			pstm.setInt(1, attvalue1);
			pstm.setInt(2, attvalue2);
			rs=pstm.executeQuery();
			while(rs.next()) {
				usercomment bean=new usercomment();
				bean.setUid(rs.getInt(1));
				bean.setAid(rs.getInt(2));
				bean.setRid(rs.getInt(3));
				bean.setCid(rs.getInt(4));
				bean.setComment(rs.getString(5));
				bean.setCtime(rs.getString(6));
				bean.setStatus(rs.getString(7));
				usercommentlist.add(bean);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return usercommentlist;
}

public ArrayList<userpost> userpost_getData(String attwhere,int attvalue) {
	ArrayList<userpost> userpostlist=new ArrayList<userpost> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userpost where "+attwhere+" =?");
			pstm.setInt(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				userpost bean=new userpost();
				bean.setUid(rs.getInt(1));
				bean.setAid(rs.getInt(2));
				bean.setAtime(rs.getString(3));
				userpostlist.add(bean);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return userpostlist;
}

public ArrayList<userpraise> userpraise_getData(String attwhere1,int attvalue1,String attwhere2,int attvalue2) {
	ArrayList<userpraise> userpraiselist=new ArrayList<userpraise> (); 
	try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userpraise where "+attwhere1+" =? and "+attwhere2+" =?");
			pstm.setInt(1, attvalue1);
			pstm.setInt(2, attvalue2);
			rs=pstm.executeQuery();
			while(rs.next()) {
				userpraise bean=new userpraise();
				bean.setUid(rs.getInt(1));
				bean.setAid(rs.getInt(2));
				bean.setRid(rs.getInt(3));
				bean.setPraise(rs.getString(4));
				bean.setPtime(rs.getString(5));
				bean.setStatus(rs.getString(6));
				userpraiselist.add(bean);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return userpraiselist;
}

public ArrayList<userreply> userreply_getData(String attwhere,int attvalue) {
	ArrayList<userreply> userreplylist=new ArrayList<userreply> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userreply where "+attwhere+" =?");
			pstm.setInt(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				userreply bean=new userreply();
				bean.setUid(rs.getInt(1));
				bean.setAid(rs.getInt(2));
				bean.setRid(rs.getInt(3));
				bean.setReply(rs.getString(4));
				bean.setRtime(rs.getString(5));
				bean.setStatus(rs.getString(6));
				userreplylist.add(bean);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return userreplylist;
}
public ArrayList<userreport_a> userreport_a_getData(String attwhere,int attvalue) {
	 ArrayList<userreport_a> userreport_alist=new ArrayList<userreport_a> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userreport_a where "+attwhere+" =?");
			pstm.setInt(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				userreport_a bean=new userreport_a();
				bean.setUid(rs.getInt(1));
				bean.setAid(rs.getInt(2));
				bean.setReport(rs.getString(3));
				bean.setRetime(rs.getString(4));
				bean.setStatus(rs.getString(5));
				userreport_alist.add(bean);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return userreport_alist;
}

public ArrayList<userreport_c> userreport_c_getData(String attwhere,int attvalue) {
	 ArrayList<userreport_c> userreport_clist=new ArrayList<userreport_c> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userreport_c where "+attwhere+" =?");
			pstm.setInt(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				userreport_c bean=new userreport_c();
				bean.setUid(rs.getInt(1));
				bean.setAid(rs.getInt(2));
				bean.setRid(rs.getInt(3));
				bean.setCid(rs.getInt(4));
				bean.setReport(rs.getString(5));
				bean.setRetime(rs.getString(6));
				bean.setStatus(rs.getString(7));
				userreport_clist.add(bean);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return userreport_clist;
}

public ArrayList<userreport_r> userreport_r_getData(String attwhere,int attvalue) {
	 ArrayList<userreport_r> userreport_rlist=new ArrayList<userreport_r> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userreport_r where "+attwhere+" =?");
			pstm.setInt(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				userreport_r bean=new userreport_r();
				bean.setUid(rs.getInt(1));
				bean.setAid(rs.getInt(2));
				bean.setRid(rs.getInt(3));
				bean.setReport(rs.getString(4));
				bean.setRetime(rs.getString(5));
				bean.setStatus(rs.getString(6));
				userreport_rlist.add(bean);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return userreport_rlist;
}
public ArrayList<manager_user> manager_user_getData2(String attwhere,int attvalue,String attwhere2,int attvalue2) {
	 ArrayList<manager_user> mulist2=new ArrayList<manager_user> ();
	try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from manager_user where "+attwhere+" =? and "+attwhere2+" =? ");
			pstm.setInt(1, attvalue);
			pstm.setInt(2, attvalue2);
			rs=pstm.executeQuery();
			while(rs.next()) {
				manager_user bean=new manager_user();
				bean.setPid(rs.getInt(1));
				bean.setUid(rs.getInt(2));
				bean.setStatus(rs.getString(3));
				mulist2.add(bean);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return mulist2;
}

public ArrayList<manager_user> manager_user_getData(String attwhere,int attvalue) {
	 ArrayList<manager_user> mulist=new ArrayList<manager_user> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from manager_user where "+attwhere+" =?");
			pstm.setInt(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				manager_user bean=new manager_user();
				bean.setPid(rs.getInt(1));
				bean.setUid(rs.getInt(2));
				bean.setStatus(rs.getString(3));
				mulist.add(bean);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return mulist;
}
public int userID(String table,String col,int value){
	int uid=0;
	try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select uid from "+ table + " where "+col+" = ?");
			pstm.setInt(1, value);
			rs=pstm.executeQuery();
			while(rs.next()) {
				uid=rs.getInt(1);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	return uid;
	
}
public int point(int uid){
	int point=0;
	try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select point from user where uid =?");
			pstm.setInt(1, uid);
			rs=pstm.executeQuery();
			while(rs.next()) {
				point=rs.getInt(1);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	return point;
}
public int level(int uid){
	int level=0;
	try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select level from user where uid =?");
			pstm.setInt(1, uid);
			rs=pstm.executeQuery();
			while(rs.next()) {
				level=rs.getInt(1);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	return level;
}
public String name(int uid){
	String uname="";
	try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select uname from user where uid =?");
			pstm.setInt(1, uid);
			rs=pstm.executeQuery();
			while(rs.next()) {
				uname=rs.getString(1);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	return uname;
}
public String password(int uid){
	String upsw="";
	try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select password from user where uid =?");
			pstm.setInt(1, uid);
			rs=pstm.executeQuery();
			while(rs.next()) {
				upsw=rs.getString(1);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	return upsw;
}

}
