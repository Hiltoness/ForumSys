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

@WebServlet("/modify_2")
public class modify_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public modify_2() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html charset=utf-8");
        
        HttpSession session = request.getSession();
        int id=(int)session.getAttribute("id");
        String psw1=request.getParameter("info_new_psw");
        String psw2=request.getParameter("info_confirm_psw");
        
        if(psw1==psw2) {
        mysql_operate update=new mysql_operate();
        
        String user = "user";
        String password="password";
		String uid = "uid";
		update.update_DBString(user,password,psw1,uid,id);
		
        PrintWriter out = response.getWriter();

        out.println("<script language = javascript>alert('修改成功！');");
        out.println("location.href='modify.jsp'</script>");
        }
        else {
        PrintWriter out = response.getWriter();

        out.println("<script language = javascript>alert('两次输入密码不一致！请重新输入');");
        out.println("location.href='modify.jsp'</script>");
        }
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
