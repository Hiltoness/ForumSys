package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class mysql_get {

	private ArrayList<manager> managerlist=new ArrayList<manager> ();
	private ArrayList<post> postlist=new ArrayList<post> ();
	private ArrayList<uco> ucolist=new ArrayList<uco> ();
	private ArrayList<user> userlist=new ArrayList<user> ();
	private ArrayList<usercomment> usercommentlist=new ArrayList<usercomment> ();
	private ArrayList<userpost> userpostlist=new ArrayList<userpost> ();
	private ArrayList<userpraise> userpraiselist=new ArrayList<userpraise> ();
	private ArrayList<userreply> userreplylist=new ArrayList<userreply> ();
	private ArrayList<userreport_a> userreport_alist=new ArrayList<userreport_a> ();
	private ArrayList<userreport_c> userreport_clist=new ArrayList<userreport_c> ();
	private ArrayList<userreport_r> userreport_rlist=new ArrayList<userreport_r> ();
	
	  private PreparedStatement pstm;     
	  
	  private Connection conn;
	  private ResultSet rs;
	  
public ArrayList<manager> manager_getData(String attwhere,String attvalue) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from message where "+attwhere+" =?");
			pstm.setString(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				manager bean=new manager();
				bean.setMid(rs.getString(1));
				bean.setNotitle(rs.getString(2));
				bean.setNotice(rs.getString(3));
				bean.setNotime(rs.getString(4));
				managerlist.add(bean);
			}
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return managerlist;
}

public ArrayList<post> post_getData(String attwhere,String attvalue) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from post where "+attwhere+" =?");
			pstm.setString(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				post bean=new post();
				bean.setAid(rs.getString(1));
				bean.setTitle(rs.getString(2));
				bean.setContent(rs.getString(3));
				postlist.add(bean);
			}
	
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return postlist;
}

public ArrayList<uco> uco_getData(String attwhere,String attvalue) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from uco where "+attwhere+" =?");
			pstm.setString(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				uco bean=new uco();
				bean.setUid(rs.getString(1));
				bean.setAid(rs.getString(2));
				bean.setCotime(rs.getString(3));
				ucolist.add(bean);
			}
	
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return ucolist;
}

public ArrayList<user> user_getData(String attwhere,String attvalue) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from user where "+attwhere+" =?");
			pstm.setString(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				user bean=new user();
				bean.setUid(rs.getString(1));
				bean.setUname(rs.getString(2));
				bean.setUtime(rs.getString(3));
				bean.setSex(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setPoint(rs.getInt(6));
				bean.setLevel(rs.getInt(7));
				bean.setCollege(rs.getString(8));
				userlist.add(bean);
			}
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return userlist;
}

public ArrayList<usercomment> usercomment_getData(String attwhere1,String attvalue1,String attwhere2,String attvalue2) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from usercomment where "+attwhere1+" =? and "+attwhere2+" =?");
			pstm.setString(1, attvalue1);
			pstm.setString(2, attvalue2);
			rs=pstm.executeQuery();
			while(rs.next()) {
				usercomment bean=new usercomment();
				bean.setUid(rs.getString(1));
				bean.setAid(rs.getString(2));
				bean.setRid(rs.getString(3));
				bean.setCid(rs.getString(4));
				bean.setComment(rs.getString(5));
				bean.setCtime(rs.getString(6));
				bean.setStatus(rs.getString(7));
				usercommentlist.add(bean);
			}
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return usercommentlist;
}

public ArrayList<userpost> userpost_getData(String attwhere,String attvalue) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userpost where "+attwhere+" =?");
			pstm.setString(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				userpost bean=new userpost();
				bean.setUid(rs.getString(1));
				bean.setAid(rs.getString(2));
				bean.setAtime(rs.getString(3));
				userpostlist.add(bean);
			}
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return userpostlist;
}

public ArrayList<userpraise> userpraise_getData(String attwhere1,String attvalue1,String attwhere2,String attvalue2) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userpraise where "+attwhere1+" =? and "+attwhere2+" =?");
			pstm.setString(1, attvalue1);
			pstm.setString(2, attvalue2);
			rs=pstm.executeQuery();
			while(rs.next()) {
				userpraise bean=new userpraise();
				bean.setUid(rs.getString(1));
				bean.setAid(rs.getString(2));
				bean.setRid(rs.getString(3));
				bean.setPraise(rs.getString(4));
				bean.setPtime(rs.getString(5));
				bean.setStatus(rs.getString(6));
				userpraiselist.add(bean);
			}
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return userpraiselist;
}

public ArrayList<userreply> userreply_getData(String attwhere,String attvalue) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userreply where "+attwhere+" =?");
			pstm.setString(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				userreply bean=new userreply();
				bean.setUid(rs.getString(1));
				bean.setAid(rs.getString(2));
				bean.setRid(rs.getString(3));
				bean.setReply(rs.getString(4));
				bean.setRtime(rs.getString(5));
				bean.setStatus(rs.getString(6));
				userreplylist.add(bean);
			}
	
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return userreplylist;
}
public ArrayList<userreport_a> userreport_a_getData(String attwhere,String attvalue) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userreport_a where "+attwhere+" =?");
			pstm.setString(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				userreport_a bean=new userreport_a();
				bean.setUid(rs.getString(1));
				bean.setAid(rs.getString(2));
				bean.setReport(rs.getString(3));
				bean.setRetime(rs.getString(4));
				bean.setStatus(rs.getString(5));
				userreport_alist.add(bean);
			}
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return userreport_alist;
}

public ArrayList<userreport_c> userreport_c_getData(String attwhere,String attvalue) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userreport_c where "+attwhere+" =?");
			pstm.setString(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				userreport_c bean=new userreport_c();
				bean.setUid(rs.getString(1));
				bean.setAid(rs.getString(2));
				bean.setRid(rs.getString(3));
				bean.setCid(rs.getString(4));
				bean.setReport(rs.getString(5));
				bean.setRetime(rs.getString(6));
				bean.setStatus(rs.getString(7));
				userreport_clist.add(bean);
			}
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return userreport_clist;
}

public ArrayList<userreport_r> userreport_r_getData(String attwhere,String attvalue) {
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userreport_r where "+attwhere+" =?");
			pstm.setString(1, attvalue);
			rs=pstm.executeQuery();
			while(rs.next()) {
				userreport_r bean=new userreport_r();
				bean.setUid(rs.getString(1));
				bean.setAid(rs.getString(2));
				bean.setRid(rs.getString(3));
				bean.setReport(rs.getString(4));
				bean.setRetime(rs.getString(5));
				bean.setStatus(rs.getString(6));
				userreport_rlist.add(bean);
			}
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	 return userreport_rlist;
}

}