package javabean;
//个人中心
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class personal_center {
	  private PreparedStatement pstm;     
	  private String diverclass="com.mysql.jdbc.Driver";
	  private String username="jdbc:mysql://localhost/visual";
	  private String password="root";
	  private String url="root";
	  private Connection conn;
	  private ResultSet rs;
	  private ArrayList<usercomment> commentlist=new ArrayList<usercomment> ();
	  private ArrayList<userpraise> praiselist=new ArrayList<userpraise> ();
	  private ArrayList<userreply> replylist=new ArrayList<userreply> ();
	  private ArrayList<userreport_a> areportlist=new ArrayList<userreport_a> ();
	  private ArrayList<userreport_c> creportlist=new ArrayList<userreport_c> ();
	  private ArrayList<userreport_r> rreportlist=new ArrayList<userreport_r> ();
	public ArrayList<usercomment> getCommentlist(String uid) {
		try {
			Class.forName(diverclass);
			conn=DriverManager.getConnection(url,username,password);
			pstm=conn.prepareStatement("select * from userreply where uid=?");
			pstm.setString(1, uid);
			rs=pstm.executeQuery();
			ArrayList<userreply> list=new ArrayList<userreply> ();
			while(rs.next()) {
				userreply bean=new userreply();
				bean.setUid(rs.getString(1));
				bean.setAid(rs.getString(2));
				bean.setRid(rs.getString(3));
				bean.setReply(rs.getString(4));
				bean.setRtime(rs.getString(5));
				bean.setStatus(rs.getString(6));
				list.add(bean);
			}
			for(int i=0;i<list.size();i++) {
				pstm=conn.prepareStatement("select * from usercomment where aid =? and rid=?");
				userreply reply=list.get(i);
				pstm.setString(1, reply.getAid());
				pstm.setString(2, reply.getRid());
				rs=pstm.executeQuery();
				while(rs.next()) {
					usercomment bean0=new usercomment();
					bean0.setUid(rs.getString(1));
					bean0.setAid(rs.getString(2));
					bean0.setRid(rs.getString(3));
					bean0.setCid(rs.getString(4));
					bean0.setComment(rs.getString(5));
					bean0.setCtime(rs.getString(6));
					bean0.setStatus(rs.getString(7));
					commentlist.add(bean0);
					
				}
			}
		
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException ex){
		ex.printStackTrace();
		}
		return commentlist;
	}

	public ArrayList<userpraise> getPraiselist(String uid) {
		try {
			Class.forName(diverclass);
			conn=DriverManager.getConnection(url,username,password);
			pstm=conn.prepareStatement("select * from userreply where uid=?");
			pstm.setString(1, uid);
			rs=pstm.executeQuery();
			ArrayList<userreply> list=new ArrayList<userreply> ();
			while(rs.next()) {
				userreply bean=new userreply();
				bean.setUid(rs.getString(1));
				bean.setAid(rs.getString(2));
				bean.setRid(rs.getString(3));
				bean.setReply(rs.getString(4));
				bean.setRtime(rs.getString(5));
				bean.setStatus(rs.getString(6));
				list.add(bean);
			}
			for(int i=0;i<list.size();i++) {
				pstm=conn.prepareStatement("select * from userpraise where aid =? and rid=?");
				userreply reply=list.get(i);
				pstm.setString(1, reply.getAid());
				pstm.setString(2, reply.getRid());
				rs=pstm.executeQuery();
				while(rs.next()) {
					userpraise bean0=new userpraise();
					bean0.setUid(rs.getString(1));
					bean0.setAid(rs.getString(2));
					bean0.setRid(rs.getString(3));
					bean0.setPraise(rs.getString(4));
					bean0.setPtime(rs.getString(5));
					bean0.setStatus(rs.getString(6));
					praiselist.add(bean0);
					
				}
			}
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException ex){
		ex.printStackTrace();
		}
		return praiselist;
	}

	public ArrayList<userreply> getReplynum(String uid) {
		try {
			Class.forName(diverclass);
			conn=DriverManager.getConnection(url,username,password);
			pstm=conn.prepareStatement("select * from userpost where uid=?");
			pstm.setString(1, uid);
			rs=pstm.executeQuery();
			ArrayList<userpost> list=new ArrayList<userpost> ();
			while(rs.next()) {
				userpost bean=new userpost();
				bean.setUid(rs.getString(1));
				bean.setAid(rs.getString(2));
				bean.setAtime(rs.getString(3));
				list.add(bean);
			}
			for(int i=0;i<list.size();i++) {
				pstm=conn.prepareStatement("select * from userreply where aid =?");
				userpost reply=list.get(i);
				pstm.setString(1, reply.getAid());
				rs=pstm.executeQuery();
				while(rs.next()) {
                if(rs.getString(6)=="unread") {
                	userreply bean0=new userreply();
    				bean0.setUid(rs.getString(1));
    				bean0.setAid(rs.getString(2));
    				bean0.setRid(rs.getString(3));
    				bean0.setReply(rs.getString(4));
    				bean0.setRtime(rs.getString(5));
    				bean0.setStatus(rs.getString(6));
    				replylist.add(bean0);	
					}
					
				}
			}
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException ex){
		ex.printStackTrace();
		}
		return replylist;
	}

	public ArrayList<userreport_a> getAreport(String uid) {
		try {
			Class.forName(diverclass);
			conn=DriverManager.getConnection(url,username,password);
			pstm=conn.prepareStatement("select * from userpost where uid=?");
			pstm.setString(1, uid);
			rs=pstm.executeQuery();
			ArrayList<userpost> list=new ArrayList<userpost> ();
			while(rs.next()) {
				userpost bean=new userpost();
				bean.setUid(rs.getString(1));
				bean.setAid(rs.getString(2));
				bean.setAtime(rs.getString(3));
				list.add(bean);
			}
			for(int i=0;i<list.size();i++) {
				pstm=conn.prepareStatement("select * from userreport_a where aid =?");
				userpost reply=list.get(i);
				pstm.setString(1, reply.getAid());
				rs=pstm.executeQuery();
				while(rs.next()) {
					userreport_a bean0=new userreport_a();
					bean0.setUid(rs.getString(1));
					bean0.setAid(rs.getString(2));
					bean0.setReport(rs.getString(3));
					bean0.setRetime(rs.getString(4));
					bean0.setStatus(rs.getString(5));
					areportlist.add(bean0);
				}
			}			
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException ex){
		ex.printStackTrace();
		}
		return areportlist;
	}
	
	
	public ArrayList<userreport_r> getRreport(String uid) {
		try {
			Class.forName(diverclass);
			conn=DriverManager.getConnection(url,username,password);					
			pstm=conn.prepareStatement("select * from userreply where uid=?");
			pstm.setString(1, uid);
			rs=pstm.executeQuery();
			ArrayList<userreply> list=new ArrayList<userreply> ();
			while(rs.next()) {
				userreply bean=new userreply();
				bean.setUid(rs.getString(1));
				bean.setAid(rs.getString(2));
				bean.setRid(rs.getString(3));
				bean.setReply(rs.getString(4));
				bean.setRtime(rs.getString(5));
				bean.setStatus(rs.getString(6));
				list.add(bean);
			}
			for(int i=0;i<list.size();i++) {
				pstm=conn.prepareStatement("select * from userreport_r where aid =? and rid=?");
				userreply reply=replylist.get(i);
				pstm.setString(1, reply.getAid());
				pstm.setString(2, reply.getRid());
				rs=pstm.executeQuery();
				while(rs.next()) {
					userreport_r bean0=new userreport_r();
					bean0.setUid(rs.getString(1));
					bean0.setAid(rs.getString(2));
					bean0.setRid(rs.getString(3));
					bean0.setReport(rs.getString(4));
					bean0.setRetime(rs.getString(5));
					bean0.setStatus(rs.getString(6));
					rreportlist.add(bean0);	
				}
			}
			
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException ex){
		ex.printStackTrace();
		}
		return rreportlist;
	}
	
	
	public ArrayList<userreport_c> getCreport(String uid) {
		try {
			Class.forName(diverclass);
			conn=DriverManager.getConnection(url,username,password);		
			pstm=conn.prepareStatement("select * from usercomment where uid=?");
			pstm.setString(1, uid);
			rs=pstm.executeQuery();
			ArrayList<usercomment> list=new ArrayList<usercomment> ();
			while(rs.next()) {
				usercomment bean=new usercomment();
				bean.setUid(rs.getString(1));
				bean.setAid(rs.getString(2));
				bean.setRid(rs.getString(3));
				bean.setCid(rs.getString(4));
				bean.setComment(rs.getString(5));
				bean.setCtime(rs.getString(6));
				bean.setStatus(rs.getString(7));
				list.add(bean);
			}
			for(int i=0;i<commentlist.size();i++) {
				pstm=conn.prepareStatement("select * from userreport_c where aid =? and rid=? and cid=?");
				usercomment reply=commentlist.get(i);
				pstm.setString(1, reply.getAid());
				pstm.setString(2, reply.getRid());
				pstm.setString(3, reply.getCid());
				rs=pstm.executeQuery();
				while(rs.next()) {
					userreport_c bean0=new userreport_c();
					bean0.setUid(rs.getString(1));
					bean0.setAid(rs.getString(2));
					bean0.setRid(rs.getString(3));
					bean0.setCid(rs.getString(4));
					bean0.setReport(rs.getString(5));
					bean0.setRetime(rs.getString(6));
					bean0.setStatus(rs.getString(7));
					creportlist.add(bean0);
				}
			}
		
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException ex){
		ex.printStackTrace();
		}
		return creportlist;
	}
}
