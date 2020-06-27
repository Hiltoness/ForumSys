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
	String uid=(String)session.getAttribute("uid");
	session.setAttribute("uid", uid);
%>
<jsp:include page="TopMenu.jsp"/>
<jsp:include page="RightBan.jsp"/>
<jsp:include page="foot.jsp"/>
<div class="viewContainer">
    <div class="mainAsideBox">
        <div class="container_1">
            
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
                            
                            $("#topic_commit").click(function getContent(){
                            	var text=ed.txt.text();
                            	HttpSession session=request.getSession();
                            	session.setAttribute("posttext",text);
                            });
                    </script>
                    <input class="btnCommit" type="submit" id="topic_commit" name="topic_commit" value="发表" onclick="">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>