package servlet_1;

import javabean.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.mysql_getint;
import javabean.mysql_operate;

/**
 * Servlet implementation class deleteCommentMServlet
 */
@WebServlet("/deleteCommentMServlet")
public class deleteCommentMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteCommentMServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html charset=utf-8");
        
        int delId=Integer.parseInt(request.getParameter("cid"));
        mysql_getint obj=new mysql_getint();
        int id=obj.userID("usercomment", "cid", delId);
        int uid=obj.userID("userreport_c", "cid", delId);
        
        String cid="cid";
        String tab1="usercomment";              
        String tab2="userreport_c";        
             
        mysql_operate del=new mysql_operate();
        del.delete_DBInt(tab2, delId, cid);
        del.delete_DBInt(tab1, delId, cid);
        
      //扣分
        mysql_getint getInt=new mysql_getint();
        int point=getInt.point(id)-5;
        mysql_operate obj1=new mysql_operate();
        obj1.update_DBInt11("user",point, "point", id, "uid");
        //加分
        int point1=getInt.point(uid)+1;
        obj1.update_DBInt11("user",point1, "point", uid, "uid");
        LevelUpgrade up=new LevelUpgrade();
        up.up(id);
        up.up(uid);
        
        
        PrintWriter out = response.getWriter();

        out.println("<script language = javascript>alert('删除成功！');");
        out.println("location.href='my.jsp'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
