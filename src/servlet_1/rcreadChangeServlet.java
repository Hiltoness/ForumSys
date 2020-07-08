package servlet_1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.mysql_operate;

/**
 * Servlet implementation class rcreadChangeServlet
 */
@WebServlet("/rcreadChangeServlet")
public class rcreadChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rcreadChangeServlet() {
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
        
        int raid=Integer.parseInt(request.getParameter("aid"));
        int rrid=Integer.parseInt(request.getParameter("rid"));
        int rcid=Integer.parseInt(request.getParameter("cid"));
        int ruid=Integer.parseInt(request.getParameter("uid"));
        String sta="read";
        String table="userreport_c";
        String status="status";
        String whereatt="aid";
        String whereatt2="rid";
        String whereatt3="cid";
        String whereatt4="uid";
        
        mysql_operate rread=new mysql_operate();       
		rread.update_DBInt4(table, sta, status, raid, whereatt, rrid, whereatt2, rcid, whereatt3, ruid, whereatt4);
		HttpSession session = request.getSession();
        int uid=Integer.parseInt(session.getAttribute("uid").toString());
        response.sendRedirect("modify.jsp?uid="+uid);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
