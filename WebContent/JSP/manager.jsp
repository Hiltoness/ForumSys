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
<script>
function deleteTopic_m(aid) {//删除主贴
    if(confirm("确认删除"+aid)){
        location.href="deleteTopicMServlet?method=delete&aid="+aid;
    }else{
        alert("删除失败");
    }
}

function deleteReply(rid) {//删除回帖
    if(confirm("确认删除"+rid)){
        location.href="deleteReplyMServlet?method=delete&rid="+rid;
    }else{
        alert("删除失败");
    }
}

function deleteComment(cid){//删除评论
	if(confirm("确认删除"+cid)){
        location.href="deleteCommentMServlet?method=delete&cid="+cid;
    }else{
        alert("删除失败");
    }
}
</script>
<div class="viewContainer">
    <div class="mainAsideBox">
        <div class="container">
            <main class="manager">
                <section class="managerSec">
                    <h3 class="mainArticleTitle">
                        <span>管理帖子主题</span>
                        <form class="searchTopic_m" id="searchTopic_m" method="get" action="">
                            <input class="searchInput_m" type="search" placeholder="搜索帖子主题">
                        </form>
                    </h3>

                    <ul class="reviewShow">
                    <%
                      mysql_getall obj=new mysql_getall();
                    mysql_get obj1=new mysql_get();
                      List<userreport_a> ua=obj.userreport_a_getData();
                      for(int i=0;i<ua.size();i++){
                    	  userreport_a uaa=ua.get(i);
                    	  List<userpost> us1=obj1.userpost_getData("aid",uaa.getAid());
                    	  List<post> ps1=obj1.post_getData("aid", uaa.getAid());
                    	  String psTitle=ps1.get(0).getTitle();//帖子主题
                    	  List<user> us2=obj1.user_getData("uid",us1.get(0).getUid());
                    	  String pbName=us2.get(0).getUname();//发帖人名字
                    	  List<user> us3=obj1.user_getData("uid", uaa.getUid());
                    	  String coName=us3.get(0).getUname();//举报人用户名
                      
                    %>
                        <li class="infoDetail"><%=coName %>举报了<%=pbName %>的帖子主题“<%=psTitle %>”，举报理由为 <%=uaa.getReport() %>   
                        <a target="_self" href="javascript:deleteTopic_m(<%=uaa.getAid()%>)">删除此帖</a>
                        </li>
                        <%} %>
                    </ul>
                </section>
                <section class="managerSec">
                    <h3 class="mainArticleTitle">
                        <span>管理帖子回复</span>
                        <form class="searchTopic_m" id="searchReply_m">
                            <input class="searchInput_m" type="search" placeholder="搜索帖子回复">
                        </form>
                    </h3>
                    <ul class="reviewShow">
                    <%
                      List<userreport_r> ur=obj.userreport_r_getData();
                      for(int i=0;i<ur.size();i++){
                    	  userreport_r urr=ur.get(i);
                    	  List<userreply> ur1=obj1.userreply_getData("rid", urr.getRid());
                    	  List<userpost> up1=obj1.userpost_getData("aid",urr.getAid());
                    	  List<post> psr1=obj1.post_getData("aid", urr.getAid());
                    	  String psrTitle=psr1.get(0).getTitle();//帖子主题
                    	  String urcon=ur1.get(0).getReply();//回帖内容
                    	  List<user> usr2=obj1.user_getData("uid",ur1.get(0).getUid());
                    	  String pbrName=usr2.get(0).getUname();//发帖人名字
                    	  List<user> usr3=obj1.user_getData("uid", urr.getUid());
                    	  String corName=usr3.get(0).getUname();//举报人用户名
                      
                    %>
                        <li class="infoDetail"><%=corName %>举报了<%=pbrName %>在帖子主题“<%=psrTitle %>”下的回复“<%=urcon %>”，举报理由为<%=urr.getReport() %>   
                        <a target="_self" href="javascript:deleteReply(<%=urr.getRid()%>)">删除此回复</a>
                        </li>
                        <%} %>
                    </ul>
                </section>
                <section class="managerSec">
                    <h3 class="mainArticleTitle">
                        <span>管理评论</span>
                        <form class="searchTopic_m" id="searchReply_m">
                            <input class="searchInput_m" type="search" placeholder="搜索帖子回复">
                        </form>
                    </h3>
                    <ul class="reviewShow">
                    <%
                      List<userreport_c> uc=obj.userreport_c_getData();
                      for(int i=0;i<ur.size();i++){
                    	  userreport_c ucc=uc.get(i);
                    	  List<userreply> uc1=obj1.userreply_getData("rid", ucc.getRid());
                    	  String uccon=uc1.get(0).getReply();//回帖内容
                    	  List<usercomment> comm=obj1.usercomment_getData("rid", ucc.getRid(), "cid", ucc.getCid());
                    	  String comm1=comm.get(0).getComment();//评论内容
                    	  List<user> usc2=obj1.user_getData("uid",comm.get(0).getUid());
                    	  String pbcName=usc2.get(0).getUname();//评论人名字
                    	  List<user> usc3=obj1.user_getData("uid", ucc.getUid());
                    	  String cocName=usc3.get(0).getUname();//举报人用户名
                      
                    %>
                        <li class="infoDetail"><%=cocName %>举报了<%=pbcName %>在回帖“<%=uccon %>”下的评论“<%=comm1 %>”，举报理由为<%=ucc.getReport() %>   
                        <a target="_self" href="javascript:deleteComment(<%=ucc.getCid()%>)">删除此回复</a></li>
                        <%} %>
                    </ul>
                </section>
           
            </main>

        </div>
    </div>
    <footer class="footerBox">
        <div class="container">
            <div class="footerContent">
                <p>请联系我们 0000-0000-0000</p>
            </div>
        </div>
    </footer>
</div>
</body>
</html>