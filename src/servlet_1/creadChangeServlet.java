package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.mysql_operate;

/**
 * Servlet implementation class creadChangeServlet
 */
@WebServlet("/creadChangeServlet")
public class creadChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creadChangeServlet() {
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
        
        int raid=Integer.parseInt(request.getParameter("aid"));
        int rrid=Integer.parseInt(request.getParameter("rid"));
        int rcid=Integer.parseInt(request.getParameter("cid"));
        String sta="read";
        String table="usercomment";
        String status="status";
        String whereatt="aid";
        String whereatt2="rid";
        String whereatt3="cid";
        
        mysql_operate rread=new mysql_operate();
        rread.update_DBInt3(table, sta, status, raid, whereatt, rrid, whereatt2, rcid, whereatt3);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
