package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class only {
	private ArrayList<userreply> userreplylist=new ArrayList<userreply> ();
	private ArrayList<usercomment> usercommentlist=new ArrayList<usercomment> ();
	private PreparedStatement pstm;     	  
	  private Connection conn;
	  private ResultSet rs;
	public ArrayList<userreply> userreply_getData(String attvalue1,String attvalue2) {
		 try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select * from userreply where aid =? and uid=?");
				pstm.setString(1, attvalue1);
				pstm.setString(1, attvalue2);
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
	public ArrayList<usercomment> usercomment_getData(String attvalue1,String attvalue2) {
		 try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select * from usercomment where aid=? and rid=?");
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
}
