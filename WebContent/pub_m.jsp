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
<%
	int mid=Integer.parseInt(session.getAttribute("mid").toString());
	String u=Integer.toString(mid);
	session.setAttribute("mid", u);

%>
<jsp:include page="TopMenu_m.jsp"></jsp:include>
<div class="viewContainer">
    
    <div class="mainAsideBox">
        <div class="container">
            <div class="publicize">
                <form class="searchTopic" id="pub_manager" name="publizeManager" method="post" action="">
                    <input id="topic_title" name="topic_title" class="inputTitle" autocomplete="off" maxlength="80" placeholder="输入公告标题" size="60" type="text">
					<input id="posttext" name="posttext" style="display:none" value="" />
                    <div class="replyEdit" id="editor1">
                        <p>发布公告</p>
                    </div>
                    <input class="btnCommit" type="submit" id="pubm_commit" name="topic_commit" value="发表">
                    <script type="text/javascript" src="wangEditor-3.1.1/release/wangEditor.min.js"></script>
                    <script type="text/javascript">
                        var rich_editor=window.wangEditor;
                        var ed=new rich_editor('#editor1');
                        ed.create();
                        
                        document.getElementById('pubm_commit').addEventListener('click', function(){
                        	var text=ed.txt.text();
                        	if(text==null){
                        		alert("不能为空");
                        	}else{
                        		alert(text);
                        		document.getElementById("posttext").setAttribute("value", text);
                        		document.getElementById("pub_manager").setAttribute("action", "pub_m");
                        	}
                        }, false)
                    </script>
                    
                </form>
                <script>
                	
                </script>
            </div>
        </div>
    </div>
</div>
<jsp:include page="foot.jsp"/>
</body>
</html>