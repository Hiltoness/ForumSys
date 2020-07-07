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
 * Servlet implementation class deleteTopicServlet
 */
@WebServlet("/deleteTopicServlet")
public class deleteTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteTopicServlet() {
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
        int id=Integer.parseInt(request.getParameter("uid"));
        mysql_operate obj1=new mysql_operate();
        obj1.update_DBInt("user","point-5", "point", id, "uid");
        LevelUpgrade up=new LevelUpgrade();
        up.up(id);
        
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
