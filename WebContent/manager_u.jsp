<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javabean.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>积分技术论坛 - 管理系统</title>
    <link type="text/css" rel="stylesheet" href="base.css"/>
    <link rel="icon" href="" type="image/x-icon" />
    <base target="_blank">
</head>
<body>

<jsp:include page="TopMenu_m.jsp"></jsp:include>
<%
	int mid=Integer.parseInt(session.getAttribute("mid").toString());
	String u=Integer.toString(mid);
	session.setAttribute("mid", u);

%>
<div class="viewContainer">

    <div class="mainAsideBox">
        <div class="container">
            <main class="manager">
                <section class="managerSec">
                    <h3 class="mainArticleTitle">
                        <span>管理用户</span>
                        <form class="searchTopic_m" id="searchUser_m" name="searchUser_m" method="post" action="">
                            <input class="searchInput_m" type="search" name="searchUserID" placeholder="搜索用户ID">
                            <input class="searchIcon" type="image" src="icon/search.png" alt="搜索" >
                        </form>
                    </h3>
                    
                    <div class="mainArticleHead">
                        <span class="userListHead0">序号</span>
                        <span class="userListHead1">用户ID</span>
                        <span class="userListHead1">用户昵称</span>
                        <span class="userListHead1">注册时间</span>
                        <span class="userListHead0">性别</span>
                        <span class="userListHead0">密码</span>
                    </div>
                    <% 
                      mysql_getall obj=new mysql_getall();
                    List<user> usinfo=obj.user_getData();
                    for(int i=0;i<usinfo.size();i++){
                    	user info=usinfo.get(i);
                    	int id=info.getUid();
                    	String name=info.getUname();
                    	String time=info.getUtime();
                    	String gender=info.getSex();
                    	String psw=info.getPassword();
                    
                    %>
                    <ul class="userList">
                        <li class="userListHead0"><%=i+1 %></li>
                        <li class="userListHead1"><%=id %></li>
                        <li class="userListHead1"><%=name %></li>
                        <li class="userListHead1"><%=time %></li>
                        <li class="userListHead0"><%=gender %></li>
                        <li class="userListHead0"><%=psw %></li>
                        <button onclick="modiInfo_m()"> 修改&nbsp;</button>
                        <button onclick="deleteUser_m(<%=id%>)">&nbsp;删除</button>
                    </ul>
                    <%-- 修改用户信息框--%>
                    <div id="modi_m1" style="display: none;
					    POSITION:absolute;
					    left:50%;
					    top:100%;
					    width:250px;
					    height:250px;
					    margin-left:-100px; margin-top:-200px;
					    padding: 5px;
					    border:1px solid #888;
					    -webkit-border-radius: 5px;
					    background-color: #f5f6f7;
					    z-index: 100;
					    text-align:center">
					    <%-- 修改用户信息--%>
					    <form class="modiForm1" id="modi_m2" name="modi_m2" method="post" action="updateUser">
					        <label class="modiForm">用户ID:<label id="modi_uid"><%=id %></label></label>
					        <label class="modiForm">用户昵称：<%=name %></label>
					        <label class="modiForm">注册时间：<%=time %></label>
					        <label class="modiForm">性别：<%=gender %></label>
					        <label class="modiForm">密码：<input class="modiInput" type="text" id="modi_m_psw" name="modi_m_psw" value=<%=psw %>></label>
					        <input style="display:none" name="uid" value="<%=id%>">
					        <button class="btnM" type="submit">确认修改</button>
					        <button class="btnM1" formtarget="_self" onclick="closeDiv()">取消</button>
					    </form>
					</div>
                    <%} %>
                </section>
            </main>

        </div>
    </div>
    <footer class="footerBox">
        <div style="margin:0 160px;z-index:6;position:relative">
            <div class="footerContent">
                <p class="content">请联系我们 0000-0000-0000</p>
            </div>
        </div>
    </footer>
</div>
<script type="application/javascript">
    function modiInfo_m() {
        document.getElementById("modi_m1").style.display="";
       
    }
    function closeDiv() {
        document.getElementById("modi_m1").style.display="none";
            }
    function deleteUser_m(uid) {
        if(confirm("确认删除"+uid)){
            location.href="deleteServlet?method=delete&uid="+uid;
        }else{
            alert("删除失败");
        }
    }
</script>
</body>
</html>