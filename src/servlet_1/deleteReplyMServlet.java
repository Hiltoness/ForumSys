package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.mysql_operate;

/**
 * Servlet implementation class deleteReplyMServlet
 */
@WebServlet("/deleteReplyMServlet")
public class deleteReplyMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteReplyMServlet() {
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
        
        int delId=Integer.parseInt(request.getParameter("rid"));
        String rid="rid";
        String tab1="userreply";              
        String tab2="usercomment";        
        String tab3="userpraise";
        String tab4="usercomment";
        String tab5="userpraise";
        String tab6="userreport_r";
        String tab7="userreport_c";       
             
        mysql_operate del=new mysql_operate();
        del.delete_DB(tab1, delId, rid);
        del.delete_DB(tab2, delId, rid);
        del.delete_DB(tab3, delId, rid);
        del.delete_DB(tab4, delId, rid);
        del.delete_DB(tab5, delId, rid);
        del.delete_DB(tab6, delId, rid);
        del.delete_DB(tab7, delId, rid);
        
        PrintWriter out = response.getWriter();

        out.println("<script language = javascript>alert('删除成功！');");
        out.println("location.href='my.jsp'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
