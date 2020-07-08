package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class only {
	private ArrayList<userreply> userreplylist=new ArrayList<userreply> ();
	private PreparedStatement pstm;     	  
	  private Connection conn;
	  private ResultSet rs;
	public ArrayList<userreply> userreply_getData(int attvalue1,int attvalue2) {
		 try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select * from userreply where aid =? and uid=?");
				pstm.setInt(1, attvalue1);
				pstm.setInt(1, attvalue2);
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
	public ArrayList<usercomment> usercomment_getData(int attvalue1,int attvalue2) {
		ArrayList<usercomment> usercommentlist=new ArrayList<usercomment> ();
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select * from usercomment where aid=? and rid=?");
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
}
