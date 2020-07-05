<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javabean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>积分技术论坛 - 论坛首页</title>
    <link type="text/css" rel="stylesheet" href="base.css"/>
    <link rel="icon" href="" type="image/x-icon" />
    <base target="_blank">
</head>
<body>
<%
	int uid=(Integer)session.getAttribute("uid");
	String u=Integer.toString(uid);
	session.setAttribute("uid", u);

%>
<jsp:include page="TopMenu.jsp"/>

<div class="viewContainer" id="Main">
    <div class="mainAsideBox" id="Center">
    <jsp:include page="RightBan.jsp"></jsp:include>
        <div class="container_l">
            <main class="mainLeft">
                <section class="mainArticleList">
                    <h3 class="mainArticleTitle">
                        <span>热门帖子列表</span>
                    </h3>
                    <div class="mainArticleHead">
                        <span class="Head0">标题</span>
                        <span class="Head1">提问人</span>
                        <span class="Head2">时间</span>
                        <span class="Head3">回复数</span>
                    </div>
                    <ul class="mainTitleList">                    	
					<%	
						mysql_postlist obj=new mysql_postlist();
						mysql_get obj1=new mysql_get();
						mysql_getint obj2=new mysql_getint();
						List<postlist> post=obj.postlist_getData();
						for(int i=0;i<post.size();i++){
							postlist ms=post.get(i);
							int aid=ms.getAid();
							user us=obj2.user_getData("uid", ms.getUid()).get(0);
							String name=us.getUname();
					%>
                        <li>
                            <a class="mainQuesTitle" href="QuesInfo.jsp?aid=<%=aid%>"><%=ms.getTitle()%></a>
                            <span class="mainQuestioner"><%=name%></span>
                            <span class="mainQuesTime"><%=ms.getAtime()%></span>
                            <span class="mainQuesReply"><%=ms.getNum()%></span>
                        </li>
                    <%} %>
                        
                    </ul>
                </section>
            </main>

        </div>
    </div>

</div>
<jsp:include page="foot.jsp"/>
</body>
</html>