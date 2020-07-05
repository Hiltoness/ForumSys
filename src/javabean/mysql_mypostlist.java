package javabean;
//查看我的帖子
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class mysql_mypostlist {
	private PreparedStatement pstm;     
	  
	  private Connection conn;
	  private ResultSet rs;
	  private ArrayList<postlist> list=new ArrayList<postlist> ();
	  private ArrayList<userpost> list0=new ArrayList<userpost> ();
	  public ArrayList<postlist>  postlist_getData(int attvalue) {
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from userpost where uid=?");
					pstm.setInt(1, attvalue);
					rs=pstm.executeQuery();
					while(rs.next()) {
						userpost bean=new userpost();
						bean.setUid(rs.getInt(1));
						bean.setAid(rs.getInt(2));
						bean.setAtime(rs.getString(3));
						list0.add(bean);
					}
					for(int i=0;i<list0.size();i++) {
						int num1=0;
						pstm=conn.prepareStatement("select * from post where aid=?");
						userpost post0=new userpost();
						post0=list0.get(i);
						pstm.setInt(1, post0.getAid());
						rs=pstm.executeQuery();
						postlist bean=new postlist();
						while(rs.next()) {							
							bean.setUid(post0.getUid());
							bean.setAid(rs.getInt(1));
							bean.setTitle(rs.getString(2));
							bean.setAtime(post0.getAtime());							
						}
						pstm=conn.prepareStatement("select * from userreply where aid=?");
						pstm.setInt(1, post0.getAid());
						rs=pstm.executeQuery();
						while(rs.next()) {
							num1=num1+1;
						}
						bean.setNum(num1);
						list.add(bean);
					}
					
			
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return list;
		}
}
