package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//我的类(首页的右边) 要知道用户id才能得到值
public class myclass {
	private String name;  //用户名
	private int level;     //等级
	private int postnum;      //我的帖子数目
	private int point;     //我的积分
	private int uconum;       //我的收藏数目
	private int commentnum;     //评论未读数目
	private int praisenum;     //点赞未读数目
	private int replynum;      //回复未读数目
	private int reportnum;     //系统通知未读数目
	private String[]   managertitle;    //论坛公告标题
	
	  private PreparedStatement pstm;     	
	  private Connection conn;
	  private ResultSet rs;
	public String getName(String uid) {
		try {
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select uname from user where uid =?");
			pstm.setString(1, uid);
			rs=pstm.executeQuery();
			while(rs.next()) {
				name=rs.getString(1);
			}			
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}		
		return name;
	}

	public int getLevel(String uid) {
		try {
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select level from user where uid =?");
			pstm.setString(1, uid);
			rs=pstm.executeQuery();
			while(rs.next()) {
				level=rs.getInt(1);
			}			
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}		
		return level;
	}

	public int getPostnum(String uid) {
		postnum=0;
		try {
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userpost where uid =?");
			pstm.setString(1, uid);
			rs=pstm.executeQuery();
			while(rs.next()) {
				postnum=postnum+1;
			}			
	
		}catch(SQLException ex){
		ex.printStackTrace();
		}		
		return postnum;
	}

	public int getPoint(String uid) {
		try {
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select point from user where uid =?");
			pstm.setString(1, uid);
			rs=pstm.executeQuery();
			while(rs.next()) {
				point=rs.getInt(1);
			}			
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}		
		return point;
	}

	public int getUconum(String uid) {
		try {
			uconum=0;
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from uco where uid =?");
			pstm.setString(1, uid);
			rs=pstm.executeQuery();
			while(rs.next()) {
				uconum=uconum+1;
			}			
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}		
		return uconum;
	}

	public int getCommentnum(String uid) {
		try {
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
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
			commentnum=0;
			for(int i=0;i<list.size();i++) {
				pstm=conn.prepareStatement("select * from usercomment where aid =? and rid=?");
				userreply reply=list.get(i);
				pstm.setString(1, reply.getAid());
				pstm.setString(2, reply.getRid());
				rs=pstm.executeQuery();
				while(rs.next()) {
					if(rs.getString(7)=="unread") {
						commentnum=commentnum+1;
					}
					
				}
			}
		
	
		}catch(SQLException ex){
		ex.printStackTrace();
		}
		return commentnum;
	}

	public int getPraisenum(String uid) {
		try {
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
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
			praisenum=0;
			for(int i=0;i<list.size();i++) {
				pstm=conn.prepareStatement("select * from userpraise where aid =? and rid=?");
				userreply reply=list.get(i);
				pstm.setString(1, reply.getAid());
				pstm.setString(2, reply.getRid());
				rs=pstm.executeQuery();
				while(rs.next()) {
                 if(rs.getString(6)=="unread") {
						praisenum=praisenum+1;
					}
					
				}
			}
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
		return praisenum;
	}

	public int getReplynum(String uid) {
		try {
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
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
			replynum=0;
			for(int i=0;i<list.size();i++) {
				pstm=conn.prepareStatement("select * from userreply where aid =?");
				userpost reply=list.get(i);
				pstm.setString(1, reply.getAid());
				rs=pstm.executeQuery();
				while(rs.next()) {
                if(rs.getString(6)=="unread") {
					replynum=replynum+1;	
					}
					
				}
			}
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
		return replynum;
	}

	public int getReportnum(String uid) {
		try {
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
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
			reportnum=0;
			for(int i=0;i<list.size();i++) {
				pstm=conn.prepareStatement("select * from userreport_a where aid =?");
				userpost reply=list.get(i);
				pstm.setString(1, reply.getAid());
				rs=pstm.executeQuery();
				while(rs.next()) {
                if(rs.getString(5)=="unread") {
					reportnum=reportnum+1;	
					}		
				}
			}
			
			pstm=conn.prepareStatement("select * from userreply where uid=?");
			pstm.setString(1, uid);
			rs=pstm.executeQuery();
			ArrayList<userreply> replylist=new ArrayList<userreply> ();
			while(rs.next()) {
				userreply bean=new userreply();
				bean.setUid(rs.getString(1));
				bean.setAid(rs.getString(2));
				bean.setRid(rs.getString(3));
				bean.setReply(rs.getString(4));
				bean.setRtime(rs.getString(5));
				bean.setStatus(rs.getString(6));
				replylist.add(bean);
			}
			for(int i=0;i<replylist.size();i++) {
				pstm=conn.prepareStatement("select * from userreport_r where aid =? and rid=?");
				userreply reply=replylist.get(i);
				pstm.setString(1, reply.getAid());
				pstm.setString(2, reply.getRid());
				rs=pstm.executeQuery();
				while(rs.next()) {
                if(rs.getString(6)=="unread") {
					reportnum=reportnum+1;	
					}		
				}
			}
			pstm=conn.prepareStatement("select * from usercomment where uid=?");
			pstm.setString(1, uid);
			rs=pstm.executeQuery();
			ArrayList<usercomment> commentlist=new ArrayList<usercomment> ();
			while(rs.next()) {
				usercomment bean=new usercomment();
				bean.setUid(rs.getString(1));
				bean.setAid(rs.getString(2));
				bean.setRid(rs.getString(3));
				bean.setCid(rs.getString(4));
				bean.setComment(rs.getString(5));
				bean.setCtime(rs.getString(6));
				bean.setStatus(rs.getString(7));
				commentlist.add(bean);
			}
			for(int i=0;i<commentlist.size();i++) {
				pstm=conn.prepareStatement("select * from userreport_c where aid =? and rid=? and cid=?");
				usercomment reply=commentlist.get(i);
				pstm.setString(1, reply.getAid());
				pstm.setString(2, reply.getRid());
				pstm.setString(3, reply.getCid());
				rs=pstm.executeQuery();
				while(rs.next()) {
                if(rs.getString(7)=="unread") {
					reportnum=reportnum+1;	
					}		
				}
			}
			pstm=conn.prepareStatement("select status from manger");
			rs=pstm.executeQuery();
			while(rs.next()) {
				if(rs.getString(1)=="unread"){
					reportnum=reportnum+1;	
					}	
			}
			
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}
		return reportnum;
	}

	public String[] getManagertitle() {
		try {
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from manger");
			rs=pstm.executeQuery();
			int i=0;
			while(rs.next()) {				
				managertitle[i]=rs.getString(2);
				i=i+1;
			}			
		
		}catch(SQLException ex){
		ex.printStackTrace();
		}		
		return managertitle;
	}

	
}
