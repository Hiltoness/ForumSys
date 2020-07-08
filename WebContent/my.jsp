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
    <title>积分技术论坛 - 我的帖子 我的收藏</title>
    <link type="text/css" rel="stylesheet" href="base.css"/>
    <link rel="icon" href="" type="image/x-icon" />
</head>
<body>
<jsp:include page="TopMenu.jsp"/>

<script>
    function deleteMyPost(aid){//删除我的帖子
    	if(confirm("确认删除")){
            location.href="deleteTopicServlet?method=delete&aid="+aid;
        }else{
            alert("删除失败");
        }
    }
    
    function deleteMyUco(uid,aid){//删除我的收藏
    	if(confirm("确认删除")){
            location.href="deleteUcoServlet?method=delete&uid="+uid+"&aid="+aid;
        }else{
            alert("删除失败");
        }
    }
</script>
<div class="viewContainer">
    
    <div class="mainAsideBox">
    <jsp:include page="RightBan.jsp"/>
        <div class="container_l">
            <div class="mainLeft">
                <section class="mainArticleList">
                    <div class="mainArticleList">
                        <h3 class="mainArticleTitle"><a name="myPost">我的帖子</a></h3>
                        <div class="infoList">
                            <ul class="infoShow">
                            <%
	                            int uid=Integer.parseInt(session.getAttribute("uid").toString());
	                        	String u=Integer.toString(uid);
	                        	session.setAttribute("uid", u);
                            	mysql_get obj=new mysql_get();
                            	mysql_mypostlist obj1=new mysql_mypostlist();
                            	mysql_getint obj2=new mysql_getint();
                            	List<postlist> post=obj1.postlist_getData(uid);
                            	for(int i=0;i<post.size();i++){
                            		postlist pp=post.get(i);
                            		List<post> ppd=obj2.post_getData("aid", pp.getAid());
                            		String ppd_t=ppd.get(0).getContent();
                            		int ppd_n=pp.getNum();
                            		int aid=pp.getAid();
                            		String atime=pp.getAtime();
                            %>
                                <li class="topicList">
                                    <h4 class="infoTitle"><a name="Info1" href="QuesInfo.jsp?aid=<%=aid%>"><%=pp.getTitle()%></a></h4>
                                    <p class="topicDetail"><%=ppd_t %></p>
                                    <p class="topicBottom">
                                        <span class="datetime"><%=atime%></span>
                                        <span >&nbsp;&nbsp;回复(<%=ppd_n %>)</span>
                                        <a href="javascript:deleteMyPost(<%=pp.getAid()%>)">&nbsp;&nbsp;删除</a>
                                    </p>
                                </li>
                                <%} %>
                            </ul>
                        </div>
                    </div>
                    <div class="mainArticleList">
                        <h3 class="mainArticleTitle"><a name="myFav">我的收藏</a></h3>
                        <div class="infoList">
                            <ul class="infoShow">
                            <%
                            	List<uco> favs=obj2.uco_getData("uid",uid);
                            	for(int i=0;i<favs.size();i++){
                            		uco fav=favs.get(i);
                            		List<post> ppd=obj2.post_getData("aid",fav.getAid());
                            		List<userpost> ups=obj2.userpost_getData("aid", fav.getAid());
                            		List<user> upub=obj2.user_getData("uid", ups.get(0).getUid());
                            		List<postlist> ppdl=obj1.postlist_getData(upub.get(0).getUid());
                            		String ppd_t=ppd.get(0).getTitle();
                            		String ppd_c=ppd.get(0).getContent();
                            		String ppd_tm=ups.get(0).getAtime();//发表时间
                            		String ppd_pb=upub.get(0).getUname();//发表人
                            		int num=ppdl.get(0).getNum();//回复数                            	
                            %>
                                <li class="topicList">
                                    <h4 class="infoTitle"><a name="Info1"><%=ppd_t %></a></h4>
                                    <p class="topicDetail"><%=ppd_c %></p>
                                    <p class="topicBottom">
                                        <span class="datetime"><%=ppd_tm %></span>
                                        <span >&nbsp;&nbsp;回复(<%=num%>)</span>
                                        <span >&nbsp;&nbsp;提问人：<%=ppd_pb %></span>
                                        <a href="javascript:deleteMyUco(<%=uid%>,<%=fav.getAid()%>)">&nbsp;&nbsp;删除</a>
                                    </p>
                                </li>
                                <%} %>
                            </ul>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
</div>
<jsp:include page="foot.jsp"/>
</body>
</html>