package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.mysql_operate;

/**
 * Servlet implementation class breadChangeServlet
 */
@WebServlet("/breadChangeServlet")
public class breadChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public breadChangeServlet() {
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
        
        int ruid=Integer.parseInt(request.getParameter("uid"));
        int rpid=Integer.parseInt(request.getParameter("pid"));
        String sta="read";
        String table="manager_user";
        String status="status";
        String whereatt="uid";
        String whereatt2="pid";
        
        mysql_operate rread=new mysql_operate();
        rread.update_DBInt2(table, sta, status, ruid, whereatt, rpid, whereatt2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}