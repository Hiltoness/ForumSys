package servlet_1;

import javabean.*;

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

import javabean.LevelUpgrade;
import javabean.mysql_getint;
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
        int id=Integer.parseInt(session.getAttribute("uid").toString());
        int aid=Integer.parseInt(request.getParameter("aid")); 
        String reply=request.getParameter("replytext");
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateTime = df.format(date);
        String status="unread";
        
        mysql_insert insert=new mysql_insert();
        insert.userreply_InserData(id, aid, reply, dateTime, status);
        
        //加分
        mysql_getint getInt=new mysql_getint();
        int point=getInt.point(id)+3;
        mysql_operate obj1=new mysql_operate();
        obj1.update_DBInt11("user",point, "point", id, "uid");
        //发帖人加分
        int uid=getInt.userID("userpost", "aid", aid);
        int point1=getInt.point(uid)+2;
        obj1.update_DBInt11("user",point, "point", uid, "uid");
        LevelUpgrade up=new LevelUpgrade();
        up.up(id);
        up.up(uid);
        
        PrintWriter out = response.getWriter();
        
        out.println("<script language = javascript>alert('回帖成功！');</script>");
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
