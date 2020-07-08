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

<div class="viewContainer">
    <div class="mainAsideBox">
    <jsp:include page="RightBan.jsp"/>
        <div class="container_l">
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
                                		mysql_getint obj2=new mysql_getint();
                                		int uid=Integer.parseInt(session.getAttribute("uid").toString());
                                		String u=Integer.toString(uid);
                                		session.setAttribute("uid", u);
				                      List<usercomment> comment=obj1.getCommentlist(uid);
				                      for(int i=0;i<comment.size();i++){
				                    	  usercomment ct=comment.get(i);
				                    	  List<user> un=obj2.user_getData("uid",ct.getUid());
				                    	  String uname=un.get(0).getUname();
				                    	  int aaid=ct.getAid();
				                    	  int rrid=ct.getRid();
				                    	  int ccid=ct.getCid();
				                    	  List<usercomment> cn=obj2.usercomment_getData("aid",ct.getAid(),"rid",ct.getRid());
				                    	  String com=cn.get(0).getComment();
				                    	  String status=cn.get(0).getStatus();//该评论的阅读状态
				                    %>
				                    <script language="javascript">
				                    	var status="<%= status%>";
				                    	var aid="<%=aaid%>";
				                    	var rid="<%=rrid%>";
				                    	var cid="<%=ccid%>";
				                    	if(status=="unread"){
				                    		location.href="creadChangeServlet?aid="+aid+"&rid="+rid+"&cid="+cid;
				                    	}
				                    </script>
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
				                    	  String status=pr.getStatus();
				                    	  int aaid=pr.getAid();
				                    	  int rrid=pr.getRid();
				                    	  int puid=pr.getUid();
				                    	  List<user> un=obj2.user_getData("uid",pr.getUid());
				                    	  String uname=un.get(0).getUname();
				                    	  List<userreply> pra=obj2.userreply_getData("rid",pr.getRid());
				                    	  String com=pra.get(0).getReply(); 
				                    %>
				                    <script language="javascript">
				                    	var status="<%= status%>";
				                    	var aid="<%=aaid%>";
				                    	var rid="<%=rrid%>";
				                    	var puid="<%=puid%>";
				                    	if(status=="unread"){
				                    		location.href="preadChangeServlet?aid="+aid+"&rid="+rid+"&uid="+puid;
				                    	}
				                    </script>
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
                            System.out.print(reply.size());
                            for(int i=0;i<reply.size();i++){
                            	userreply rp=reply.get(i);
                            	String status=rp.getStatus();
                            	int aaid=rp.getAid();
                            	int rrid=rp.getRid();
		                    	String runame=obj2.name(rp.getUid());
		                    	System.out.print(runame);
		                    	
                            %>
                            		<script language="javascript">
				                    	var status="<%= status%>";
				                    	var aid="<%=aaid%>";
				                    	var rid="<%=rrid%>";
				                    	if(status=="unread"){
				                    		location.href="rreadChangeServlet?aid="+aid+"&rid="+rid;
				                    	}
				                    </script>
                                <li class="infoDetail">
                                <p class="artilist">
                                        <span class="infoName"><%=runame %></span>回复了你的帖子“<span class="infoContent"><%=rp.getReply() %>”</span>
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
                            	String status=rp_a.getStatus();
                            	int aaid=rp_a.getAid();
                            	int uuid=uid;
                            	List<post> ti=obj2.post_getData("aid",rp_a.getAid());
                            	String tit=ti.get(0).getTitle();
                            	
                            %>
                            		<script language="javascript">
				                    	var status="<%= status%>";
				                    	var aid="<%=aaid%>";
				                    	if(status=="unread"){
				                    		location.href="rareadChangeServlet?aid="+aaid+"&uid="+uuid;
				                    	}
				                    </script>
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
                            	String status=rp_r.getStatus();
                            	int aaid=rp_r.getAid();
                            	int rrid=rp_r.getRid();
                            	List<userreply> ti=obj2.userreply_getData("rid",rp_r.getRid());
                            	String tit=ti.get(0).getReply();
                            %>
                                <script language="javascript">
				                    	var status="<%= status%>";
				                    	var aid="<%=aaid%>";
				                    	var rid="<%=rrid%>";
				                    	if(status=="unread"){
				                    		location.href="rrreadChangeServlet?aid="+aaid+"&uid="+uuid+"&rid="+rid;
				                    	}
				                    </script>
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
                            	String status=rp_c.getStatus();
                            	int aaid=rp_c.getAid();
                            	int rrid=rp_c.getRid();
                            	int ccid=rp_c.getCid();
                            	List<usercomment> ti=obj2.usercomment_getData("cid",rp_c.getCid(),"rid",rp_c.getRid());
                            	String tit=ti.get(0).getComment();
                            %>
                                <script language="javascript">
				                    	var status="<%= status%>";
				                    	var aid="<%=aaid%>";
				                    	var rid="<%=rrid%>";
				                    	var cid="<%=ccid%>";
				                    	if(status=="unread"){
				                    		location.href="rcreadChangeServlet?aid="+aaid+"&uid="+uuid+"&rid="+rid+"&cid="+cid;
				                    	}
				                    </script>
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
                            		mysql_getall obj3=new mysql_getall();
                            		List<manager> bulletin=obj3.manager_getData();
                            		for(int k=0;k<bulletin.size();k++){
                            			manager bull=bulletin.get(k);
                            			int ppid=bull.getPid();
                            			List<manager_user> bullu=obj2.manager_user_getData("pid", bull.getPid()); /*"uid",uuid*/
                            			String status=bullu.get(0).getStatus();
                            			
                            	%>
                            	<script>
                            		var status=<%= status%>;
                            		var pid=<%=ppid%>;
                            		if(status=="unread"){
                            			location.href="breadChangeServlet?uid="+uuid+"&pid="+pid;
                            		}
                            	</script>
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
                            List<user> us=obj2.user_getData("uid", uid);
                            user uss=us.get(0);
                            String name=uss.getUname();
                            String sex=uss.getSex();
                            String college=uss.getCollege();
                            %>
                            <form method="post" action="modify_1" id="modiInfo" name="modiInfo">
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
                                <form method="post" action="modify_2" id="modiPSW">
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
<jsp:include page="foot.jsp"/>
</body>
</html>