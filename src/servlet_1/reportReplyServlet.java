package servlet_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.mysql_insert;

/**
 * Servlet implementation class reportReplyServlet
 */
@WebServlet("/reportReplyServlet")
public class reportReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reportReplyServlet() {
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
        
        HttpSession session = request.getSession();
        int id=Integer.parseInt(session.getAttribute("uid").toString());;
        int aid=Integer.parseInt(request.getParameter("postId"));
        int rid=Integer.parseInt(request.getParameter("replyId"));
        String rr=request.getParameter("reportInput");
        if(rr==null){
        	rr="null";
        }
        String report1=request.getParameter("report1");
        String report=report1.concat(rr);
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateTime = df.format(date);
        String status="unread";
        
        mysql_insert insert=new mysql_insert();
        insert.userreport_r_InserData(id, aid, rid, report, dateTime, status);
        PrintWriter out = response.getWriter();
        
        out.println("<script language = javascript>alert('举报成功！');</script>");
        response.sendRedirect("QuesInfo.jsp?aid="+aid);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
