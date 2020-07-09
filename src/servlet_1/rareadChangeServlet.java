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
 * Servlet implementation class rareadChangeServlet
 */
@WebServlet("/rareadChangeServlet")
public class rareadChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rareadChangeServlet() {
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
        int ruid=Integer.parseInt(request.getParameter("uid"));
        
        String table="userreport_a";
        String sta="status"; 
        String status="read";
        String whereatt="aid";
        String whereatt2="uid";
        
        mysql_operate updateStatus=new mysql_operate();		
		updateStatus.update_DBInt(table, status, sta, raid, whereatt);
		
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
