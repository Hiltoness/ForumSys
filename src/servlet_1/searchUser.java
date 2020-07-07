package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.mysql_getint;


@WebServlet("/searchId")
public class searchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public searchUser() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html charset=utf-8");
        
        int searchId=Integer.parseInt(request.getParameter("searchUserID"));
        String uid="uid";
       
        mysql_getint search=new mysql_getint();
        search.user_getData(uid,searchId);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
