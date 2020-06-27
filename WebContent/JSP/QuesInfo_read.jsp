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
    <title>积分技术论坛 - 浏览帖子详情</title>
    <link type="text/css" rel="stylesheet" href="base.css"/>
    <link rel="icon" href="" type="image/x-icon" />
</head>
<body>
<jsp:include page="TopMenu.jsp"/>
<jsp:include page="RightBan.jsp"/>
<jsp:include page="foot.jsp"/>
<script>
    function fav(aid) {//收藏
        var fDiv=document.getElementById("fav");
        if(fDiv.innerHTML==="收藏"){
            // location.href="favServlet?method=fav&aid="+aid;
            fDiv.innerHTML="已收藏";
        }else {//取消收藏
            // location.href="cancelfavServlet?method=cancelfav&aid="+aid;
            fDiv.innerHTML="收藏";
        }
    }
    function backAll(aid) {//返回查看全部
        var rDiv=document.getElementsById("back"); 
        rDiv.style.color="#e40d01";
        rDiv.style.fontWeight="bold";
         // location.href="readServlet?method=read&aid="+aid;
         location.href="QuesInfo.jsp?aid="+aid;
    }
    function report1(aid) {
        //点击举报主贴
        document.getElementById("reportDiv").style.display="";
        var hideobj=document.getElementById("hidebg");
        hideobj.style.display="block";  //显示隐藏层
        hideobj.style.height=document.body.clientHeight+"px";  //设置隐藏层的高度为当前页面高度
    }
    function closeRDiv() {//关闭举报框
        document.getElementById("reportDiv").style.display="none";
        document.getElementById("hidebg").style.display="none";
    }
    function praise(rid,i) {//点赞
        var pDiv=document.getElementsByClassName("praise")[i];
        if(pDiv.style.color=="rgb(103, 103, 103)"){
            // location.href="praiseServlet?method=praise&aid="+aid;
            pDiv.style.color="red";
            pDiv.innerHTML="取消点赞"
        }else {//取消点赞
            // location.href="cancelpraiseServlet?method=cancelpraise&aid="+aid;
            pDiv.style.color = "#676767"
            pDiv.innerHTML = "点赞"
        }
    }
    function $(el) {
        return document.getElementById(el);
    }
    function comment(obj,rid) {//评论
        var oComment=obj.parentNode.parentNode.parentNode;
        console.log(oComment)
        oComment.appendChild($("response"));
        $("response").style.display="flex";
        var replyID=document.getElementById("replyCid");//回帖的id
        replyID.setAttribute("value",rid);
    }

</script>
//举报框
<div id="reportDiv" style="display: none;
    POSITION:absolute;
    left:50%;
    top:50%;
    width:350px;
    height:460px;
    margin-left:-100px;
    margin-top:-200px;
    padding: 5px;
    border:1px solid #cccccc;
    -webkit-border-radius: 5px;
    background-color: #fbfcfd;
    z-index: 10;
    text-align:center">
    <div class="boxTitle"><p>举报</p>
        <button class="close" type="button" onclick="closeRDiv()" aria-label="Close">
            <span aria-hidden="true">×</span>
        </button>
    </div>

    <div class="boxCenter">
        <form class="reportForm1" id="reportCon" method="post" action="">
            <div class="boxHeader">
                <span>你觉得这个帖子有什么问题？（必选）</span>
            </div>
            <label class="reportBan"><input type="radio" name="report1" value="1" />内容涉黄</label>
            <label class="reportBan"><input type="radio" name="report1" value="2" />政治相关</label>
            <label class="reportBan"><input type="radio" name="report1" value="3" />其他</label>
            <label class="reportBan"><input type="radio" name="report1" value="4" />涉嫌广告</label>
            <label class="reportBan"><input type="radio" name="report1" value="5" />招聘</label>
            <label class="reportBan"><input type="radio" name="report1" value="6" />刷屏</label>
            <label class="reportBan"><input type="radio" name="report1" value="7" />恶意灌水</label>
            <label class="reportBan"><input type="radio" name="report1" value="8" />跑题</label>
            <label class="reportBan"><input type="radio" name="report1" value="9" />言语攻击</label>

            <div class="boxHeader">
                <span>补充说明（选填）</span>
            </div>
            <textarea rows="5" cols="30" class="reportInput" id="reportInput"></textarea>

            <button class="btnM" type="submit">提交</button>
            <button class="btnM1" formtarget="_self" onclick="closeRDiv()">取消</button>
        </form>
    </div>

</div>
//隐藏遮罩层
 <div id="hidebg" style="position:absolute;left:0px;top:0px;
        background-color:gray;
        width:100%;  /*宽度设置为100%，这样才能使隐藏背景层覆盖原页面*/
        opacity:0.6;  /*非IE浏览器下设置透明度为60%*/
        display:none; /* http://www.jb51.net */
        z-Index:9"></div>
//评论框
<div id="response" style="display: none;margin: 10px 15px">
    <form id="commentForm" name="commentForm" style="display: contents" accept-charset="utf-8" method="post" action="">
    	//评论cid
    	<input style="display: none" id="replyCid" value=""/>
    	//评论内容
        <textarea id="commentSend" style="display:inline;width: 100%;height: 80px;-webkit-border-radius: 3px;padding: 2px 5px"></textarea>
        //提交按钮
        <input class="btnModi" value="发表评论" type="submit" />
    </form>
</div>
<div class="viewContainer">
    
    <div class="mainAsideBox">
        <div class="container_1">
            
            <div class="mainLeft">
                <div class="quesFloor">
                <%
                  String aid=request.getParameter("aid");//主贴id
                  mysql_get obj=new mysql_get();
                  only obj1=new only();
                  List<post> post=obj.post_getData("aid", aid);
                  List<userpost> userpost=obj.userpost_getData("aid", aid);
                  List<userreply> repost1=obj.userreply_getData("aid", aid);
                  post pp=post.get(0);//帖子表
                  userpost up=userpost.get(0);//用户发帖表
                  String title=pp.getTitle();//标题
                  String userid=up.getUid();//用户id
                  List<user> user=obj.user_getData("uid", userid);
                  String username=user.get(0).getUname();//用户名
                  int level=user.get(0).getLevel();//等级
                  String time=up.getAtime();//发帖时间
                  String content=pp.getContent();//帖子内容
                  int num=repost1.size();//帖子回复数
                  
                %>
                    <h3 class="quesTitle"><%=post.get(0).getTitle() %></h3>
                    <section class="quesTitleNEr">
                        <div class="erInfoBox">
                            <img src="icon/search.png" class="headerImg2">
                            <div class="headerName">
                                <span><%=username %></span>
                                <br/>
                                <span><%=level %></span>
                            </div>
                        </div>
                        <div class="erQues">
                            <div class="erCont">
                            <%=content %>
                            </div>
                            <div class="erControl">
                                <div class="erControlL">
                                    <label class="datetime"><%=time %></label>
                                </div>
                                <div class="erControlR">
                                    <a href="javascript:fav(<%=aid%>)"><span id="fav">收藏</span></a>
                                    <span><%=num %></span>
                                    <a href="javascript:backAll(<%=aid%>)"><span id="back" style="color: rgb(103,103,103)">返回全部楼层</span></a>
                                    <a href="javascript:report1(<%=aid%>)">举报</a>
                                </div>
                            </div>
                        </div>
                    </section>
                    <%	
                    	String rUid=request.getParameter("rUid");//指定“只看TA”的uid
                    	List<userreply> rr=obj.userreply_getData("aid", aid);
                    	for(int i=0;i<rr.size();i++){
                    		userreply rr_1=rr.get(i);
                    		String rid=rr_1.getRid();//回帖id
                    		String ruid=rr_1.getUid();
                    		List<user> us=obj.user_getData("uid", ruid);
                    		List<usercomment> com=obj1.usercomment_getData(aid,rid );//评论list
                    		String rname=us.get(0).getUname();//回帖用户名
                    		int rlevel=us.get(0).getLevel();//回帖用户等级
                    		String reply=rr_1.getReply();//回帖内容
                    		String rtime=rr_1.getRtime();//回帖时间
                    	
                     %>
                    <section class="quesTitleNEr">
                        <div class="erInfoBox">
                            <img src="icon/search.png" class="headerImg">
                            <div class="headerName">
                                <span><%=rname %></span>
                                <br/>
                                <span><%=rlevel %></span>
                            </div>
                        </div>
                        <div class="erQues">
                            <div class="erCont">
			                     <%=reply %>
                            </div>
                            <div class="erControl">
                                <div class="erControlL">
                                    <label class="datetime"><%=rtime %></label>
                                </div>
                                <div class="erControlR">
                                    <a href="javascript:praise(<%=ruid%>)"><span class="praise">点赞</span></a>
                                    <div class="commentBtn" onclick="comment(this,<%=rr_1.getRid()%>)"><span class="comment">评论</span></div>
                                    <a href="javascript:report1(<%=ruid%>)">举报</a>
                                </div>
                            </div>
                            <%
                            	for(int j=0;j<com.size();j++){
                            		usercomment com1=com.get(j);
                            		List<user> us_c=obj.user_getData("uid", com1.getUid());
                            		String us_cname=us_c.get(0).getUname();//评论人用户名
                            		int us_clevel=us_c.get(0).getLevel();//评论人等级
                            	
                            %>
                            <div class="erComment">
                                <div class="commentHead">
                                    <span><%=us_cname %> &nbsp</span><span style="color:#1e88e5"><%=us_clevel%></span>
                                    <span class="commentCon"><%=com1.getComment() %></span>
                                </div>
                                <div class="erControl1">
                                    <div class="erControlR">
                                        <label class="datetime"><%=com1.getCtime() %></label>
                                        <a href="javascript:praiseCom(<%=com1.getCid() %>)"><span class="praise">点赞</span></a>
                                        <a href="javascript:reportCom1(<%=com1.getCid() %>)">举报</a>
                                    </div>
                                </div>

                            </div>
                            <%} %>
                        </div>
                    </section>
                    <%} %>
                    
                </div>

        </div>
    </div>
</div>
</body>
</html>