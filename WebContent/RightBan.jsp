<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javabean.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="base.css"/>
<title>Insert title here</title>
</head>
<body onload=loadFresh()>


<%   
     myclass obj =new myclass();
	 mysql_getall obj1=new mysql_getall();
	 mysql_get obj2=new mysql_get();
	 mysql_getint obj3=new mysql_getint();
     int uid=Integer.parseInt(session.getAttribute("uid").toString());
	 String name=obj.getName(uid);
	 int level=obj.getLevel(uid);
	 int postnum=obj.getPostnum(uid);
	 int point=obj.getPoint(uid);
	 int uconum=obj.getUconum(uid);
%>
<div class="container_r">
<aside class="aside">
                <div class="myCard">
                    <div class="asideCardUp">
                        <img class="headerImg" src="icon/search.png" />
                        <div class="headerName">
                            <span><%=name %></span>
                            <br/>
                            <span><%=level %></span>
                        </div>
                        <div class="headerCont">
                            <a href="my.jsp#myPost?uid=<%=uid%>"><span class="headerContItem">我的帖子
                            <br/><%=postnum %></span></a>
                            <span class="headerContItem">我的积分
                                <br/><%=point %></span>
                            <a href="my.jsp#myFav?uid=<%=uid %>" ><span class="headerContItem">我的收藏
                                <br/><%=uconum %></span></a>
                        </div>
                    </div>
                    <div class="asideCardDown">
                    <%	
                    	int rnum=obj.getReplynum(uid);//未读回帖
                    	int cnum=obj.getCommentnum(uid);//未读评论
                    	int pnum=obj.getPraisenum(uid);//未读点赞
                    	int rpnum=obj.getReportnum(uid);//未读系统通知
                    	System.out.print(rnum+"rnum "+cnum+"cnum "+pnum+"pnum "+rpnum);
                    	
                    %>
                        <ul class="MSG">
                            <li class="headerMSGTitle aHover"><a href="modify.jsp?uid=<%=uid %>"><b>消息</b><span id="infoUnread" style="display: none;color: red"></span></a></li>
                            <li class="headerMSGItem"><a href="modify.jsp#Info1?uid=<%=uid %>">评论</a><span id="commentUnread" style="display: none;color: red"></span></li>
                            <li class="headerMSGItem"><a href="modify.jsp#Info2?uid=<%=uid %>">点赞</a><span id="praiseUnread" style="display: none;color: red"></span></li>
                            <li class="headerMSGItem"><a href="modify.jsp#Info3?uid=<%=uid %>">回复</a><span id="replyUnread" style="display: none;color: red"></span></li>
                            <li class="headerMSGItem"><a href="modify.jsp#Info4?uid=<%=uid %>">系统通知<span id="noticeUnread" style="display: none;color: red"></span></a></li>
                        </ul>
                        <ul class="MSG">
                            <li class="headerMSGTitle"><a href="modify.jsp#Info5?uid=<%=uid %>"><b>资料</b></a></li>
                            <li class="headerMSGItem"><a href="modify.jsp#Info5?uid=<%=uid %>">修改资料</a></li>
                            <li class="headerMSGItem"><a href="modify.jsp#Info6?uid=<%=uid %>">修改密码</a></li>
                        </ul>
                    </div>
                </div>
                <div class="mainBullet">
                    <span class="headerMSGTitle"><a href="modify.jsp#bulletin?uid=<%=uid%>"><b>论坛公告</b><span id="bulletinUnread" style="display: none;color: red"></span></a></span>
                    <ul>
                    	<%
                    	int bnum=0;
                    	bnum=obj.getBullnum(uid);
                    	%>
						<%
							List<String> bulletin=obj.getManagertitle();
							for(int k=0;k<bulletin.size();k++){
							
						%>
						<li class="mainBulletItem"><a href="modify.jsp#bulletin?uid=<%=uid%>"><%=bulletin.get(k) %></a></li>
						<%
							}
						%>
                    </ul>
                </div>
            </aside>
</div>
<script language="javascript">
	//未读回帖
    var jsp_rnum=<%= rnum%>; 
    console.log(jsp_rnum);
    //未读评论
    var jsp_cnum=<%=cnum%>;
    //未读点赞
    var jsp_pnum=<%=pnum%>;
    //系统通知
    var jsp_rpnum=<%=rpnum%>;
    //未读公告
    var jsp_bnum=<%=bnum%>;
    function loadFresh() {
        var m=unread();
        if(jsp_rnum>0){
            m.replyUnread(jsp_rnum);
        }
        if (jsp_cnum>0){
            m.commentUnread(jsp_cnum);
        }
        if(jsp_pnum>0){
            m.praiseUnread(jsp_pnum);
        }
        if (jsp_rpnum>0){
            m.noticeUnread(jsp_rpnum);
        }
        if(jsp_bnum>0){
            bulletin(jsp_bnum);
        }

    }
    function exitout(uid) {
        window.close();
    }
    var num=0;
    function unread() {//未读消息

        // var num=0;
        function total() {
            var unreadNote = document.getElementById("infoUnread");
            unreadNote.style.display = "contents";
            unreadNote.innerHTML = this.num;
            console.log(this.num);
        }

        function commentUnread(num1) {// 未读评论
            var unreadNote = document.getElementById("commentUnread");
            unreadNote.style.display = "contents";
            unreadNote.innerHTML = num1;
            num=num+num1;
            total();
        }

        function praiseUnread(num2) { //未读点赞
            var unreadNote = document.getElementById("praiseUnread");
            unreadNote.style.display = "contents";
            unreadNote.innerHTML = num2;
            num=num+num2;
            total();
        }

        function replyUnread(num3) { //未读回帖
            var unreadNote = document.getElementById("replyUnread");
            unreadNote.style.display = "contents";
            unreadNote.innerHTML = num3;
            num=num+num3;
            total();
        }

        function noticeUnread(num4) { //系统通知
            var unreadNote = document.getElementById("noticeUnread");
            unreadNote.style.display = "contents";
            unreadNote.innerHTML = num4;
            num=num+num4;
            total();
        }


        return{
            "commentUnread":commentUnread,
            "praiseUnread":praiseUnread,
            "replyUnread":replyUnread,
            "noticeUnread":noticeUnread
        }
    }
    
    function bulletin(numb) {
    	var unreadBull = document.getElementById("bulletinUnread");
        unreadBull.style.display = "contents";
        unreadBull.innerHTML = numb;
    }
        

</script>
</body>
</html>