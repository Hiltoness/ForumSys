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
	private ArrayList<String>   managertitle;    //论坛公告标题
	
	  private PreparedStatement pstm;     	
	  private Connection conn;
	  private ResultSet rs;
	public String getName(int uid) {
		try {
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select uname from user where uid =?");
			pstm.setInt(1, uid);
			rs=pstm.executeQuery();
			while(rs.next()) {
				name=rs.getString(1);
			}			
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}		
		return name;
	}

	public int getLevel(int uid) {
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

	public int getPostnum(int uid) {
		postnum=0;
		try {
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userpost where uid =?");
			pstm.setInt(1, uid);
			rs=pstm.executeQuery();
			while(rs.next()) {
				postnum=postnum+1;
			}			
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}		
		return postnum;
	}

	public int getPoint(int uid) {
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

	public int getUconum(int uid) {
		try {
			uconum=0;
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from uco where uid =?");
			pstm.setInt(1, uid);
			rs=pstm.executeQuery();
			while(rs.next()) {
				uconum=uconum+1;
			}			
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}		
		return uconum;
	}

	public int getCommentnum(int uid) {
		try {
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userreply where uid=?");
			pstm.setInt(1, uid);
			rs=pstm.executeQuery();
			ArrayList<userreply> list=new ArrayList<userreply> ();
			while(rs.next()) {
				userreply bean=new userreply();
				bean.setUid(rs.getInt(1));
				bean.setAid(rs.getInt(2));
				bean.setRid(rs.getInt(3));
				bean.setReply(rs.getString(4));
				bean.setRtime(rs.getString(5));
				bean.setStatus(rs.getString(6));
				list.add(bean);
			}
			commentnum=0;
			for(int i=0;i<list.size();i++) {
				pstm=conn.prepareStatement("select * from usercomment where aid =? and rid=?");
				userreply reply=list.get(i);
				pstm.setInt(1, reply.getAid());
				pstm.setInt(2, reply.getRid());
				rs=pstm.executeQuery();
				while(rs.next()) {
					if(rs.getString(7).equals("unread")) {
						commentnum=commentnum+1;
					}
					
				}
			}
		
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
		return commentnum;
	}

	public int getPraisenum(int uid) {
		try {
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userreply where uid=?");
			pstm.setInt(1, uid);
			rs=pstm.executeQuery();
			ArrayList<userreply> list=new ArrayList<userreply> ();
			while(rs.next()) {
				userreply bean=new userreply();
				bean.setUid(rs.getInt(1));
				bean.setAid(rs.getInt(2));
				bean.setRid(rs.getInt(3));
				bean.setReply(rs.getString(4));
				bean.setRtime(rs.getString(5));
				bean.setStatus(rs.getString(6));
				list.add(bean);
			}
			praisenum=0;
			for(int i=0;i<list.size();i++) {
				pstm=conn.prepareStatement("select * from userpraise where aid =? and rid=?");
				userreply reply=list.get(i);
				pstm.setInt(1, reply.getAid());
				pstm.setInt(2, reply.getRid());
				rs=pstm.executeQuery();
				while(rs.next()) {
                 if(rs.getString(6).equals("unread")) {
						praisenum=praisenum+1;
					}
					
				}
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
		return praisenum;
	}

	public int getReplynum(int uid) {
		try {
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userpost where uid=?");
			pstm.setInt(1, uid);
			rs=pstm.executeQuery();
			ArrayList<userpost> list=new ArrayList<userpost> ();
			while(rs.next()) {
				userpost bean=new userpost();
				bean.setUid(rs.getInt(1));
				bean.setAid(rs.getInt(2));
				bean.setAtime(rs.getString(3));
				list.add(bean);
			}
			replynum=0;
			for(int i=0;i<list.size();i++) {
				pstm=conn.prepareStatement("select * from userreply where aid =?");
				userpost reply=list.get(i);
				pstm.setInt(1, reply.getAid());
				rs=pstm.executeQuery();
				while(rs.next()) {
                if(rs.getString(6).equals("unread")) {
					replynum=replynum+1;	
					}
					
				}
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
		return replynum;
	}

	public int getReportnum(int uid) {
		try {
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from userpost where uid=?");
			pstm.setInt(1, uid);
			rs=pstm.executeQuery();
			ArrayList<userpost> list=new ArrayList<userpost> ();
			while(rs.next()) {
				userpost bean=new userpost();
				bean.setUid(rs.getInt(1));
				bean.setAid(rs.getInt(2));
				bean.setAtime(rs.getString(3));
				list.add(bean);
			}
			reportnum=0;
			for(int i=0;i<list.size();i++) {
				pstm=conn.prepareStatement("select * from userreport_a where aid =?");
				userpost reply=list.get(i);
				pstm.setInt(1, reply.getAid());
				rs=pstm.executeQuery();
				while(rs.next()) {
                if(rs.getString(5).equals("unread")) {
					reportnum=reportnum+1;	
					}		
				}
			}
			
			pstm=conn.prepareStatement("select * from userreply where uid=?");
			pstm.setInt(1, uid);
			rs=pstm.executeQuery();
			ArrayList<userreply> replylist=new ArrayList<userreply> ();
			while(rs.next()) {
				userreply bean=new userreply();
				bean.setUid(rs.getInt(1));
				bean.setAid(rs.getInt(2));
				bean.setRid(rs.getInt(3));
				bean.setReply(rs.getString(4));
				bean.setRtime(rs.getString(5));
				bean.setStatus(rs.getString(6));
				replylist.add(bean);
			}
			for(int i=0;i<replylist.size();i++) {
				pstm=conn.prepareStatement("select * from userreport_r where aid =? and rid=?");
				userreply reply=replylist.get(i);
				pstm.setInt(1, reply.getAid());
				pstm.setInt(2, reply.getRid());
				rs=pstm.executeQuery();
				while(rs.next()) {
                if(rs.getString(6).equals("unread")) {
					reportnum=reportnum+1;	
					}		
				}
			}
			pstm=conn.prepareStatement("select * from usercomment where uid=?");
			pstm.setInt(1, uid);
			rs=pstm.executeQuery();
			ArrayList<usercomment> commentlist=new ArrayList<usercomment> ();
			while(rs.next()) {
				usercomment bean=new usercomment();
				bean.setUid(rs.getInt(1));
				bean.setAid(rs.getInt(2));
				bean.setRid(rs.getInt(3));
				bean.setCid(rs.getInt(4));
				bean.setComment(rs.getString(5));
				bean.setCtime(rs.getString(6));
				bean.setStatus(rs.getString(7));
				commentlist.add(bean);
			}
			for(int i=0;i<commentlist.size();i++) {
				pstm=conn.prepareStatement("select * from userreport_c where aid =? and rid=? and cid=?");
				usercomment reply=commentlist.get(i);
				pstm.setInt(1, reply.getAid());
				pstm.setInt(2, reply.getRid());
				pstm.setInt(3, reply.getCid());
				rs=pstm.executeQuery();
				while(rs.next()) {
                if(rs.getString(7).equals("unread")) {
					reportnum=reportnum+1;	
					}		
				}
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
		return reportnum;
	}
	
	public int getBullnum(int uid) {
		int bullnum=0;
		try {
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select status from manager_user where uid=?");
			pstm.setInt(1, uid);
			rs=pstm.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals("unread")){
					bullnum=bullnum+1;	
					}	
			}
			
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
		return bullnum;
	}
		
	
	public ArrayList<String>  getManagertitle() {
		try {
			mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from manager");
			rs=pstm.executeQuery();
			managertitle=new ArrayList<String> ();
			while(rs.next()) {				
				managertitle.add(rs.getString(3));
			}			
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}		
		return managertitle;
	}

	
}
