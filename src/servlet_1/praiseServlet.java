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

import javabean.LevelUpgrade;
import javabean.mysql_getint;
import javabean.mysql_insert;
import javabean.mysql_operate;

/**
 * Servlet implementation class praiseServlet
 */
@WebServlet("/praiseServlet")
public class praiseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public praiseServlet() {
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
        int rid=Integer.parseInt(request.getParameter("rid"));
        
        String praise="null";
        String status="unread";
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateTime = df.format(date);
        
        mysql_insert insert=new mysql_insert();

		insert.userpraise_InserData(id, aid, rid, praise, dateTime, status);	
		
		//加分
        mysql_getint obj=new mysql_getint();
        int uid=obj.userID("userpost", "aid", aid);
        int point=obj.point(uid)+1;
        mysql_operate obj1=new mysql_operate();
        obj1.update_DBInt11("user",point, "point", uid, "uid");
        LevelUpgrade up=new LevelUpgrade();
        up.up(uid);
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
