package javabean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class search {
	private PreparedStatement pstm;     	 
	  private Connection conn;
	  private ResultSet rs;
	  public ArrayList<postlist>  searchlist_getData(String attvalue) {
			ArrayList<postlist> list=new ArrayList<postlist> ();
			ArrayList<post> list0=new ArrayList<post> ();
		  try {
				    mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					//String st="'%%".concat(attvalue).concat("%%'");
					
					pstm=conn.prepareStatement("select * from post where title like ? ");
					pstm.setString(1, "%"+attvalue+"%");
					rs=pstm.executeQuery();
					while(rs.next()) {
						post bean0=new post();
						bean0.setAid(rs.getInt(1));
						bean0.setTitle(rs.getString(2));
						bean0.setContent(rs.getString(3));
						list0.add(bean0);
					}
					pstm=conn.prepareStatement("select * from post where content like ? ");
					pstm.setString(1, "%"+attvalue+"%");
					rs=pstm.executeQuery();
					while(rs.next()) {
						post bean0=new post();
						bean0.setAid(rs.getInt(1));
						bean0.setTitle(rs.getString(2));
						bean0.setContent(rs.getString(3));
						list0.add(bean0);
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
					db.close(conn);			
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return list;
		}
}
