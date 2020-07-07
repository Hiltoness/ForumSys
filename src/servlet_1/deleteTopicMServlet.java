package servlet_1;

import javabean.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.mysql_operate;

/**
 * Servlet implementation class deleteTopicMServlet
 */
@WebServlet("/deleteTopicMServlet")
public class deleteTopicMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteTopicMServlet() {
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
        
        int delId=Integer.parseInt(request.getParameter("aid"));        
        mysql_getint obj=new mysql_getint();
        int id=obj.userID("userpost", "aid", delId);
        int uid=obj.userID("userreport_a", "aid", delId);
        
        String aid="aid";
        String tab1="post";              
        String tab2="userpost";        
        String tab3="userreply";
        String tab4="usercomment";
        String tab5="userpraise";
        String tab6="userreport_a";
        String tab7="userreport_r";
        String tab8="userreport_c";
        String tab9="uco";
             
        mysql_operate del=new mysql_operate();
        del.delete_DBInt(tab8, delId, aid);
        del.delete_DBInt(tab7, delId, aid);
        del.delete_DBInt(tab6, delId, aid);
        del.delete_DBInt(tab4, delId, aid);
        del.delete_DBInt(tab5, delId, aid);
        del.delete_DBInt(tab3, delId, aid);
        del.delete_DBInt(tab9, delId, aid);
        del.delete_DBInt(tab2, delId, aid);
        del.delete_DBInt(tab1, delId, aid);
        
        //扣分
        mysql_operate obj1=new mysql_operate();
        obj1.update_DBInt("user","point-10", "point", id, "uid");
        //加分
        obj1.update_DBInt("user","point+3", "point", uid, "uid");
        LevelUpgrade up=new LevelUpgrade();
        up.up(id);
        up.up(uid);
        
        PrintWriter out = response.getWriter();

        out.println("<script language = javascript>alert('删除成功！');");
        out.println("location.href='manager_u.jsp'</script>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
