package javabean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class search {
	private PreparedStatement pstm;     
	  private String diverclass="com.mysql.jdbc.Driver";
	  private String username="jdbc:mysql://localhost/visual";
	  private String password="root";
	  private String url="root";
	  private Connection conn;
	  private ResultSet rs;
	  private ArrayList<postlist> list=new ArrayList<postlist> ();
	  private ArrayList<post> list0=new ArrayList<post> ();
	  public ArrayList<postlist>  searchlist_getData(String attvalue) {
			 try {
					Class.forName(diverclass);
					conn=DriverManager.getConnection(url,username,password);
					pstm=conn.prepareStatement("select * from post where title=? or content=?");
					pstm.setString(1, "%"+attvalue+"%");
					pstm.setString(2, "%"+attvalue+"%");
					rs=pstm.executeQuery();
					while(rs.next()) {
						post bean=new post();
						bean.setAid(rs.getString(1));
						bean.setTitle(rs.getString(2));
						bean.setContent(rs.getString(3));
						list0.add(bean);
					}
					for(int i=0;i<list0.size();i++) {
						int num1=0;
						pstm=conn.prepareStatement("select * from userpost where aid=?");
						post post0=new post();
						post0=list0.get(i);
						pstm.setString(1, post0.getAid());
						rs=pstm.executeQuery();
						postlist bean=new postlist();
						while(rs.next()) {							
							bean.setUid(rs.getString(1));
							bean.setAid(rs.getString(2));
							bean.setTitle(post0.getTitle());
							bean.setAtime(rs.getString(3));							
						}
						pstm=conn.prepareStatement("select * from userreply where aid=?");
						pstm.setString(1, post0.getAid());
						rs=pstm.executeQuery();
						while(rs.next()) {
							num1=num1+1;
						}
						bean.setNum(num1);
						list.add(bean);
					}
					
				}catch(ClassNotFoundException e1){
					e1.printStackTrace();
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return list;
		}
}
