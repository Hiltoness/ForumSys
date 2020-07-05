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
 * Servlet implementation class pinglun
 */
@WebServlet("/pinglun")
public class comment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public comment() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html charset=utf-8");
        
        String replyCid=request.getParameter("replyCid");
        String commentSend=request.getParameter("commentSend");
        
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
          String sql="insert into usercomment(uid,aid,rid,cid,comment) values(?,?,?,?,?)";
          PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
          ps.setString(1, name);
          ps.setString(2, );
          ps.setString(3, );
          ps.setString(3, replyCid);
          ps.setString(3, commentSend);
          
          ps.executeUpdate();
          ps.close();
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        PrintWriter out = response.getWriter();

        out.println("<script language = javascript>alert('ÆÀÂÛ³É¹¦£¡');");
        out.println("location.href='QuesInfo.jsp'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
