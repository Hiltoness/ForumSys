<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>积分技术论坛 - 发帖</title>
    <link type="text/css" rel="stylesheet" href="base.css"/>
    <link rel="icon" href="" type="image/x-icon" />

</head>
<body>
<%
	int uid=Integer.parseInt(session.getAttribute("uid").toString());
	String u=Integer.toString(uid);
	session.setAttribute("uid", u);
%>
<jsp:include page="TopMenu.jsp"/>

<div class="viewContainer">
    <div class="mainAsideBox">
    
        <div class="container_l">
            <jsp:include page="RightBan.jsp"/>
            <div class="publicize">
                <form class="searchTopic" method="post" action="" name="publize">
                    <input id="topic_title" name="topic_title" class="inputTitle" autocomplete="off" maxlength="80" placeholder="输入帖子标题" size="60" type="text">

                <div class="replyEdit" id="editor1">
                    <p>发表帖子</p>
                </div>
                    <script type="text/javascript" src="wangEditor-3.1.1/release/wangEditor.min.js"></script>
                    <script type="text/javascript">
                            var rich_editor=window.wangEditor;
                            var ed=new rich_editor('#editor1');
                            ed.create();
                            
                    </script>
                    <input class="btnCommit" type="submit" id="topic_commit" name="topic_commit" value="发表" onclick="">
                </form>
                <script>
                	document.getElementById('topic_commit').addEventListener('click', function(){
                	var text=ed.txt.text();
                    HttpSession session=request.getSession();
                    session.setAttribute("posttext",text);
                }, false)
                </script>
            </div>
        </div>
    </div>
</div>
<jsp:include page="foot.jsp"/>
</body>
</html>