package servlet_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.LevelUpgrade;
import javabean.mysql_getint;
import javabean.mysql_operate;

/**
 * Servlet implementation class deleteReplyMServlet
 */
@WebServlet("/deleteReplyMServlet")
public class deleteReplyMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteReplyMServlet() {
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
        
        int delId=Integer.parseInt(request.getParameter("rid"));
        mysql_getint obj=new mysql_getint();
        int id=obj.userID("userreply", "rid", delId);
        int uid=obj.userID("userreport_r", "rid", delId);
        
        String rid="rid";
        String tab1="userreply";              
        String tab2="usercomment";        
        String tab3="userpraise";
        String tab4="userreport_r";
        String tab5="userreport_c";       
             
        mysql_operate del=new mysql_operate();
        del.delete_DBInt(tab5, delId, rid);
        del.delete_DBInt(tab4, delId, rid);
        del.delete_DBInt(tab3, delId, rid);
        del.delete_DBInt(tab2, delId, rid);
        del.delete_DBInt(tab1, delId, rid);
        
        //扣分
        mysql_operate obj1=new mysql_operate();
        obj1.update_DBInt("user","point-8", "point", id, "uid");
        //加分
        obj1.update_DBInt("user","point+2", "point", uid, "uid");
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
