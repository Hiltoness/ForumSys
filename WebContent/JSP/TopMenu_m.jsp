<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
    function exitout(uid) {
        window.close();
    }
</script>
<div class="viewContainer">
    <div class="mainHeaderBox">
        <div class="container">
            <div class="mainNav">
                <a class="topTitle1" href="manager.html">积分技术论坛 管理系统</a>
                <ul class="navList">
                    <li class="navItem1"><a href="manager.jsp">管理帖子主题</a></li>
                    <span class="navText"> | </span>
                    <li class="navItem1"><a href="manager.jsp">管理帖子回复</a></li>
                    <span class="navText"> | </span>
                    <li class="navItem1"><a href="manager_u.jsp">管理用户</a></li>
                    <span class="navText"> | </span>
                    <li class="navItem1"><a href="pub_m.jsp">发布公告</a></li>
                </ul>
            </div>
            <div class="mainLogin">
                <ul class="navLogin">
                    <li class="navItem"><a href="modify.html">管理员Name</a></li>
                    <span class="navText"> | </span>
                    <li class="navItem"><a href="javascript:exit()">退出</a></li>
                </ul>
            </div>
        </div>
    </div>
    </div>
</body>
</html>