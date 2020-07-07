package servlet_1;

import javabean.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.mysql_insert;
import javabean.mysql_operate;

/**
 * Servlet implementation class reply_post
 */
@WebServlet("/reply_post")
public class reply_post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reply_post() {
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
        int id=(int)session.getAttribute("id");
        int aid=Integer.parseInt(request.getParameter("aid")); 
        String reply=(String)session.getAttribute("replytext");
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = df.format(date);
        String status="unread";
        
        mysql_insert insert=new mysql_insert();
        insert.userreply_InserData(id, aid, reply, dateTime, status);
        
        //加分
        mysql_operate obj1=new mysql_operate();
        obj1.update_DBInt("user","point+3", "point", id, "uid");
        //发帖人加分
        mysql_getint obj2=new mysql_getint();
        int uid=obj2.userID("userpost", "aid", aid);
        obj1.update_DBInt("user","point+2", "point", uid, "uid");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
