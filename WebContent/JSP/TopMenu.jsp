<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javabean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" rel="stylesheet" href="base.css"/>
    <link rel="icon" href="" type="image/x-icon" />
	<title>Insert title here</title>
</head>
<body>
<%
   String uid=(String)session.getAttribute("uid");
 %>
 <script>
    function exitout(uid) {
        window.close();
    }
</script>
<div class="viewContainer">
	<div class="mainHeaderBox">
        <div class="container">
            <div class="mainNav">
                <a class="topTitle" href="main.html">积分技术论坛</a>
                <ul class="navList">
                    <li class="navItem"><a href="main.jsp?uid=<%=uid%>">首页</a></li>
                    <span class="navText"> | </span>
                    <li class="navItem"><a href="publize.jsp?uid=<%=uid%>">发帖</a></li>
                    <li class="navItem">
                    	//搜索框
                        <form class="searchForm" id="MainSearch" name="MainSearch" method="post" action="">
                            <input class="searchInput" type="search" maxlength="50" id="MainSearchCont" name="MainSearchCont" placeholder="搜索内容">
                            <input class="searchIcon" type="image" src="icon/search.png" alt="搜索" >
                        </form>
                    </li>
                </ul>
            </div>
            <div class="mainLogin">
                <ul class="navLogin">
                    <li class="navItem"><a href="modify.html?uid=<%=uid %>">个人中心</a></li>
                    <span class="navText"> | </span>
                    <li class="navItem"><a target="_self" href="javascript:exitout(<%=uid%>)">退出</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>