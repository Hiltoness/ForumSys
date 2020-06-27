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
    <title>积分技术论坛 - 消息 资料详情</title>
    <link type="text/css" rel="stylesheet" href="base.css"/>
    <link rel="icon" href="" type="image/x-icon" />
</head>
<body>
<jsp:include page="TopMenu.jsp"/>
<jsp:include page="RightBan.jsp"/>
<jsp:include page="foot.jsp"/>
<div class="viewContainer">
    <div class="mainAsideBox">
        <div class="container_1">
            <div class="mainLeft">
                <section class="mainArticleList">
                    <h3 class="mainArticleTitle">消息</h3>
                    <div class="infoList">
                    <ul class="infoShow">
                        <li class="infoList">
                            <h3 class="infoTitle"><a name="Info1">收到的评论</a></h3>
                                <ul class="reviewShow">
                                	<%
                                		mysql_get obj=new mysql_get();
                                		personal_center obj1=new personal_center();
				                      String uid=(String)session.getAttribute("uid");
				                      session.setAttribute("uid", uid);
				                      List<usercomment> comment=obj1.getCommentlist(uid);
				                      for(int i=0;i<comment.size();i++){
				                    	  usercomment ct=comment.get(i);
				                    	  List<user> un=obj.user_getData("uid",ct.getUid());
				                    	  String uname=un.get(0).getUname();
				                    	  List<usercomment> cn=obj.usercomment_getData("aid",ct.getAid(),"rid",ct.getRid());
				                    	  String com=cn.get(0).getComment();
				                    %>
                                    <li class="infoDetail">
                                    <p class="artilist">
                                        <span class="infoName"><%=uname %></span>评论了你的回帖"<span class="infoContent"><%=com %></span>"
                                        </p>
                                        <a href="QuesInfo.jsp?aid='<%=ct.getAid()%>'?rid='<%=ct.getRid()%>'">
                                        	查看详情</a>
                                    </li>
                                    <%
				                        }
				                     %>
                                </ul>
                        </li>
                        <li class="infoList">
                            <h3 class="infoTitle"><a name="Info2">点赞我的</a></h3>
                            <ul class="reviewShow">
                            		<%
				                      List<userpraise> praise=obj1.getPraiselist(uid);
				                      for(int i=0;i<praise.size();i++){
				                    	  userpraise pr=praise.get(i);
				                    	  List<user> un=obj.user_getData("uid",pr.getUid());
				                    	  String uname=un.get(0).getUname();
				                    	  List<userreply> pra=obj.userreply_getData("rid",pr.getRid());
				                    	  String com=pra.get(0).getReply();
				                    %>
                                <li class="infoDetail">
                                <p class="artilist">
                                        <span class="infoName"><%=uname %></span><%=uname %>点赞了你的回帖“<span class="infoContent"><%=com %></span>”
                                </p>
                                </li>
                                <%} %>
                            </ul>
                        </li>
                        <li class="infoList">
                            <h3 class="infoTitle"><a name="Info3">回复我的</a></h3>
                            <ul class="reviewShow">
                            <%
                            List<userreply> reply=obj1.getReplynum(uid);
                            for(int i=0;i<reply.size();i++){
                            	userreply rp=reply.get(i);
                            	List<user> un=obj.user_getData("uid",rp.getUid());
		                    	String uname=un.get(0).getUname();
                            %>
                                <li class="infoDetail">
                                <p class="artilist">
                                        <span class="infoName"><%=uname %></span>回复了你的帖子“<span class="infoContent"><%=rp.getReply() %>”</span>
                                 </p>
                                </li>
                            <%} %>
                            </ul>
                        </li>
                        <li class="infoList">
                            <h3 class="infoTitle"><a name="Info4">系统通知</a></h3>
                            <ul class="reviewShow">
                            <%
                            List<userreport_a> report_a=obj1.getAreport(uid);
                            for(int i=0;i<report_a.size();i++){
                            	userreport_a rp_a=report_a.get(i);
                            	List<post> ti=obj.post_getData("aid",rp_a.getAid());
                            	String tit=ti.get(0).getTitle();
                            	
                            %>
                                <li class="infoDetail">
                                		<p class="artilist">
                                        	你的帖子<span class="infoContent"><%=tit %></span>因<span class="infoName"><%=rp_a.getReport() %></span>
                                        	被举报删帖</p>
                                </li>
                            <%} %>
                            <%
                            List<userreport_r> report_r=obj1.getRreport(uid);
                            for(int i=0;i<report_r.size();i++){
                            	userreport_r rp_r=report_r.get(i);
                            	List<userreply> ti=obj.userreply_getData("rid",rp_r.getRid());
                            	String tit=ti.get(0).getReply();
                            %>
                                <li class="infoDetail">
                                	<p class="artilist">你的回帖<span class="infoContent"><%=tit %></span>因<span class="infoName"><%=rp_r.getReport() %></span>
                                	被举报删帖
                                	</p>
                                </li>
                            <%} %>
                            <%
                            List<userreport_c> report_c=obj1.getCreport(uid);
                            for(int i=0;i<report_c.size();i++){
                            	userreport_c rp_c=report_c.get(i);
                            	List<usercomment> ti=obj.usercomment_getData("cid",rp_c.getCid(),"rid",rp_c.getRid());
                            	String tit=ti.get(0).getComment();
                            %>
                                <li class="infoDetail">
                                   <p class="artilist">你的评论<span class="infoContent"><%=tit %></span>因<span class="infoName"><%=rp_c.getReport() %></span>
                                   	被举报删除
                                   	</p></li>
                            <%} %>
                                
                            </ul>
                        </li>
                        <li class="infoList">
                            <h3 class="infoTitle"><a name="bulletin">论坛公告</a></h3>
                            <ul class="reviewShow">
                            	<%
                            		mysql_getall obj2=new mysql_getall();
                            		List<manager> bulletin=obj2.manager_getData();
                            		for(int k=0;k<bulletin.size();k++){
                            			manager bull=bulletin.get(k);
                            			
                            	%>
                                <li class="infoDetail"><%=bull.getNotitle() %>：<%=bull.getNotice() %> --<%=bull.getNotime() %></li>
                                <%} %>
                            </ul>
                        </li>
                    </ul>
                    <h3 class="mainArticleTitle">资料</h3>
                    <ul class="infoShow">
                        <li class="infoList">
                            <h3 class="infoTitle"><a name="Info5">修改资料</a></h3>
                            <div class="reviewShow">
                            <% 
                            List<user> us=obj.user_getData("uid", uid);
                            user uss=us.get(0);
                            String name=uss.getUname();
                            String sex=uss.getSex();
                            String college=uss.getCollege();
                            %>
                            <form method="post" action="" id="modiInfo" name="modiInfo">
                            	<div class="infoBox"><div class="infoModify"> 你的昵称：</div><input class="infoModify" id="info_name" name="info_name" type="text" size="50"  placeholder="<%=name %>" /></div>
                                <div class="infoBox"><div class="infoModify">你的性别：</div>
                                <select class="infoModify" name=info_gender>
                                        <option value="male">男</option>
                                        <option value="female">女</option>
                                    </select>
                                </div>
                                <div class="infoBox"><div class="infoModify">毕业院校：</div><input class="infoModify" id="info_college" name="info_college" type="text" size="100" placeholder="<%=college %>" /></div>
                                    <input class="btnModi" type="submit" value="确认修改" />
                            </form>  
                            </div>
                        </li>
                        <li class="infoList">
                            <h3 class="infoTitle"><a name="Info6">修改密码</a></h3>
                            <div class="reviewShow">
                                <form method="post" action="" id="modiPSW">
                                    <div class="infoBox"> <div class="infoModify">输入原密码：</div><input type="password" class="psw" name="info_former_psw" id="info_former_psw"></div>
                                    <div class="infoBox"> <div class="infoModify">输入新密码：</div><input type="password" class="psw" name="info_new_psw" id="info_new_psw"></div>
                                    <div class="infoBox"><div class="infoModify">再次输入新密码：</div><input type="password" class="psw" name="info_confirm_psw" id="info_confirm_psw"></div>
                                    <input class="btnModi" type="submit" value="确认修改" />
                                </form>
                            </div>
                        </li>
                    </ul>
                    </div>
                </section>
            </div>
        </div>
    </div>
</div>
</body>
</html>