package servlet_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import javabean.*;

/**
 * Servlet implementation class pinglun
 */
@WebServlet("/comment")
public class comment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public comment() {
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
        int id=Integer.parseInt(session.getAttribute("uid").toString());//获取session中保存的用户id
        int rid=Integer.parseInt(request.getParameter("replyRid").toString());
        int aid=Integer.parseInt(request.getParameter("replyAid").toString());
        
        
        String commentSend=request.getParameter("commentSend");
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
        String dateTime = df.format(date);
        
        mysql_insert insert=new mysql_insert();

		String status="unread";
		insert.usercomment_InserData(id,aid,rid,commentSend,dateTime,status); //aid和rid不知道从哪获取
		
		//加分
		mysql_getint getInt=new mysql_getint();
        int point=getInt.point(id)+2;
		mysql_operate obj1=new mysql_operate();
        obj1.update_DBInt11("user",point, "point", id, "uid");
		//回帖主人加分
        mysql_getint obj2=new mysql_getint();
        int uid=obj2.userID("userreply", "rid", rid);
        int point1=getInt.point(uid)+1;
        obj1.update_DBInt11("user", point1,"point", uid, "uid");
        LevelUpgrade up=new LevelUpgrade();
        up.up(id);
        up.up(uid);
        
        PrintWriter out = response.getWriter();

        out.println("<script language = javascript>alert('评论成功！');</script>");
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
