package javabean;
//帖子列表的数据库查询，并按回复数，从大到小排序
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class mysql_postlist {
	private PreparedStatement pstm;     
	 
	  private Connection conn;
	  private ResultSet rs;

	  public ArrayList<postlist>  postlist_getData() {
		  ArrayList<postlist> list=new ArrayList<postlist> ();
		 ArrayList<postlist> solist=new ArrayList<postlist> ();
		   ArrayList<post> list0=new ArrayList<post> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from post");
					rs=pstm.executeQuery();
					while(rs.next()) {
						post bean=new post();
						bean.setAid(rs.getInt(1));
						bean.setTitle(rs.getString(2));
						bean.setContent(rs.getString(3));
						list0.add(bean);
					}
					for(int i=0;i<list0.size();i++) {
						int num1=0;
						pstm=conn.prepareStatement("select * from userpost where aid=?");
						post post0=new post();
						post0=list0.get(i);
						pstm.setInt(1, post0.getAid());
						rs=pstm.executeQuery();
						postlist bean=new postlist();
						while(rs.next()) {							
							bean.setUid(rs.getInt(1));
							bean.setAid(rs.getInt(2));
							bean.setTitle(post0.getTitle());
							bean.setAtime(rs.getString(3));							
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
					sort sortlist=new sort();
					solist=sortlist.postlistsort(list);
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return solist;
		}
}
