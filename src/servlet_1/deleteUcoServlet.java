package servlet_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.mysql_operate;

/**
 * Servlet implementation class deleteMyUco
 */
@WebServlet("/deleteUcoServlet")
public class deleteUcoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUcoServlet() {
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
        
        String table="uco";
        String uid="uid";
        String aid="aid";
        HttpSession session= request.getSession();
        int delUid=Integer.parseInt(session.getAttribute("uid").toString());
        int delAid=Integer.parseInt(request.getParameter("aid"));
        
        mysql_operate del=new mysql_operate();
        del.delete_DBInt2(table, delUid, uid,delAid,aid);
        
        PrintWriter out = response.getWriter();

        out.println("<script language = javascript>alert('删除成功！');</script>");
        int id=Integer.parseInt(session.getAttribute("uid").toString());
      
        response.sendRedirect("my.jsp?uid="+id);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
