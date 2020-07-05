package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

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
        
        String psw1=request.getParameter("info_new_psw");
        String psw2=request.getParameter("info_confirm_psw");
        
        if(psw1==psw2) {
        String DRIVER="com.mysql.jdbc.Driver";
        String URL="jdbc:mysql://localhost:3306/mysql";
        String user="root";
        String key="root";
        java.sql.Connection conn;

        try {
           Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
                    }
        try {
          conn = DriverManager.getConnection(URL,user,key);
          String sql="update user set password=? where uid=?";
          PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
          ps.setString(1, psw1);
          
          ps.executeUpdate();
          ps.close();
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        PrintWriter out = response.getWriter();

        out.println("<script language = javascript>alert('修改成功！');");
        out.println("location.href='modify.jsp'</script>");
        }else {
        PrintWriter out = response.getWriter();

        out.println("<script language = javascript>alert('两次输入密码不一致！请重新输入');");
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
