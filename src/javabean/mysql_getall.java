package javabean;
//查询数据表里的所有数据，没有条件句子
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class mysql_getall {
	  private PreparedStatement pstm;     
	  
	  private Connection conn;
	  private ResultSet rs;
	  
public ArrayList<manager> manager_getData() {
	ArrayList<manager> managerlist=new ArrayList<manager> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from manager ");			
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

public ArrayList<post> post_getData() {
	ArrayList<post> postlist=new ArrayList<post> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from post ");
			
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

public ArrayList<uco> uco_getData() {
	ArrayList<uco> ucolist=new ArrayList<uco> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from uco ");
			
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

public ArrayList<user> user_getData() {
	ArrayList<user> userlist=new ArrayList<user> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from user ");
			
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

public ArrayList<usercomment> usercomment_getData() {
	ArrayList<usercomment> usercommentlist=new ArrayList<usercomment> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from usercomment");
		
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

public ArrayList<userpost> userpost_getData() {
	ArrayList<userpost> userpostlist=new ArrayList<userpost> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userpost ");
			
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

public ArrayList<userpraise> userpraise_getData() {
	 ArrayList<userpraise> userpraiselist=new ArrayList<userpraise> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userpraise ");
			
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

public ArrayList<userreply> userreply_getData() {
	ArrayList<userreply> userreplylist=new ArrayList<userreply> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userreply ");
			
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
public ArrayList<userreport_a> userreport_a_getData() {
	 ArrayList<userreport_a> userreport_alist=new ArrayList<userreport_a> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userreport_a ");
		
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

public ArrayList<userreport_c> userreport_c_getData() {
	ArrayList<userreport_c> userreport_clist=new ArrayList<userreport_c> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userreport_c ");
			
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

public ArrayList<userreport_r> userreport_r_getData() {
	ArrayList<userreport_r> userreport_rlist=new ArrayList<userreport_r> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userreport_r ");
		
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
public ArrayList<manager_user> manager_user_getData() {
	ArrayList<manager_user> mulist=new ArrayList<manager_user> ();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from manager_user");;
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

}
