package servlet_1;

import javabean.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.mysql_insert;

/**
 * Servlet implementation class pub_m
 */
@WebServlet("/pub_m")
public class pub_m extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public pub_m() {
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
        int id=Integer.parseInt(session.getAttribute("mid").toString());
        String title=request.getParameter("topic_title");
        String notice=request.getParameter("posttext");
        int pid=0;
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateTime = df.format(date);
        
        mysql_insert insert=new mysql_insert();
        pid=insert.manager_InserData(id,title,notice,dateTime); 
		
        mysql_getall obj1=new mysql_getall();
        List<user> userlist=obj1.user_getData();
        for(int i=0;i<userlist.size();i++){
        	int uid=userlist.get(i).getUid();
        	// manager_user_InserData(int pid,int uid,String status)
        	insert.manager_user_InserData(pid, uid, "unread");
        }

        PrintWriter out = response.getWriter();

        out.println("<script language = javascript>alert('公告发布成功！');");
        out.println("</script>");
        int mid=Integer.parseInt(session.getAttribute("mid").toString());
        response.sendRedirect("manager.jsp?mid="+mid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
