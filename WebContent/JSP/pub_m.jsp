<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>积分技术论坛 - 管理系统 发布公告</title>
    <link type="text/css" rel="stylesheet" href="base.css"/>
    <link rel="icon" href="" type="image/x-icon" />
    <base target="_blank">
</head>
<body>
<div class="viewContainer">
    <div class="mainHeaderBox">
        <div class="container">
            <div class="mainNav">
                <a class="topTitle1" href="manager.html">积分技术论坛 管理系统</a>
                <ul class="navList">
                    <li class="navItem1"><a href="manager.html">管理帖子主题</a></li>
                    <span class="navText"> | </span>
                    <li class="navItem1"><a href="publize.html">管理帖子回复</a></li>
                    <span class="navText"> | </span>
                    <li class="navItem1"><a href="publize.html">管理用户</a></li>
                    <span class="navText"> | </span>
                    <li class="navItem1"><a href="publize.html">发布公告</a></li>
                </ul>
            </div>
            <div class="mainLogin">
                <ul class="navLogin">
                    <li class="navItem"><a href="modify.html">管理员Name</a></li>
                    <span class="navText"> | </span>
                    <li class="navItem"><a>退出</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="mainAsideBox">
        <div class="container">
            <div class="publicize">
                <form class="searchTopic" id="pub_manager" name="publizeManager" method="post" action="">
                    <input id="topic_title" class="inputTitle" autocomplete="off" maxlength="80" placeholder="输入公告标题" size="60" type="text">

                    <div class="replyEdit" id="editor1">
                        <p>发布公告</p>
                    </div>
                    <script type="text/javascript" src="wangEditor-3.1.1/release/wangEditor.min.js"></script>
                    <script type="text/javascript">
                        var rich_editor=window.wangEditor;
                        var ed=new rich_editor('#editor1');
                        ed.create();
                        
                    </script>
                    <input class="btnCommit" type="submit" id="pubm_commit" name="topic_commit" value="发表" onclick="">
                </form>
                <script>
                	document.getElementById('pubm_commit').addEventListener('click', function(){
                	var text=ed.txt.text();
                    HttpSession session=request.getSession();
                    session.setAttribute("pubm",text);
                }, false)
                </script>
            </div>
        </div>
    </div>
</div>
<jsp:include page="foot.jsp"/>
</body>
</html>