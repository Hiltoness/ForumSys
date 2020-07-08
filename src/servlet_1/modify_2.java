package servlet_1;

import javabean.*;
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
 * Servlet implementation class modify_2
 */
@WebServlet("/modify_2")
public class modify_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public modify_2() {
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
        String psw0=request.getParameter("info_former_psw");
        String psw1=request.getParameter("info_new_psw");
        String psw2=request.getParameter("info_confirm_psw");
        mysql_getint getObj=new mysql_getint();
        String sp=getObj.password(id);
        PrintWriter out = response.getWriter();
        if(sp.equals(psw0)){
        	if(psw1.equals(psw2)) {
                mysql_operate update=new mysql_operate();
                
                String user = "user";
                String password="password";
        		String uid = "uid";
        		update.update_DBInt(user,psw1,password,id,uid);

                out.println("<script language = javascript>alert('修改成功！');");
                out.println("location.href='modify.jsp'</script>");
                }else {
                    out.println("<script language = javascript>alert('两次输入密码不一致！请重新输入');");
                    out.println("location.href='modify.jsp'</script>");
                    }
        }else{
        	out.println("<script language = javascript>alert('原密码错误！请重新输入');");
            out.println("location.href='modify.jsp'</script>");

        }
        
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
