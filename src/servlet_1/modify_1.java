package com.servlet;

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
 * Servlet implementation class modify
 */
@WebServlet("/modify")
public class modify_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public modify_1() {
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
        
        String name=request.getParameter("info_name");
        String gender =request.getParameter("info_gender");
        String coll =request.getParameter("info_college");
        
        mysql_operate update=new mysql_operate();
        
        String user = "user";
		String uname = "uname";
		String sex = "sex";
		String college = "college";
		String uid = "uid";
		update.update_DBString(user,uname,name,uid,id);//修改姓名
		update.update_DBString(user,sex,gender,uid,id);//修改性别	
		update.update_DBString(user,college,coll,uid,id);//修改大学
        
        PrintWriter out = response.getWriter();

        out.println("<script language = javascript>alert('修改成功！');");
        out.println("location.href='modify.jsp'</script>");
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
