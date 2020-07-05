package com.servlet;

import java.beans.Beans;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.mysql_DB;
import javabean.user;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


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
        
        String name=request.getParameter("info_name");
        String sex =request.getParameter("info_gender");
        String college =request.getParameter("info_college");
        
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
          String sql="update user set name=?,sex=?,college=? where uid=?";
          PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
          ps.setString(1, name);
          ps.setString(2, sex);
          ps.setString(3, college);
          ps.executeUpdate();
          ps.close();
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        PrintWriter out = response.getWriter();

        out.println("<script language = javascript>alert('ÐÞ¸Ä³É¹¦£¡');");
        out.println("location.href='modify.jsp'</script>");
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
