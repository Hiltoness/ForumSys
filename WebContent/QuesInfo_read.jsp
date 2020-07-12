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
    <script type="text/javascript" src="http://localhost:8080/ForumSyst/jquery-3.5.1.js"></script>
</head>
<body>
<jsp:include page="TopMenu.jsp"/>

<%-- 举报框--%>
<div id="reportDiv" style="display: none;
    POSITION:absolute;
    left:50%;
    top:50%;
    width:350px;
    height:500px;
    margin-left:-100px;
    margin-top:-200px;
    padding: 5px;
    border:1px solid #cccccc;
    -webkit-border-radius: 5px;
    background-color: #fbfcfd;
    z-index: 10002;
    text-align:center">
    <div class="boxTitle"><p>举报</p>
        <button class="close" type="button" onclick="closeRDiv()" aria-label="Close">
            <span aria-hidden="true">×</span>
        </button>
    </div>

    <div class="boxCenter">
        <form class="reportForm1" id="reportCon" name="reportCon" method="post" action="" accept-charset="utf-8">
            <div class="boxHeader">
                <span>你觉得这个帖子/评论有什么问题？（必选）</span>
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
			<input style="display:none" id="postId" name="postId" value="">
			<input style="display:none" id="replyId" name="replyId" value="">
			<input style="display:none" id="comId" name="comId" value="">
            <div class="boxHeader">
                <span>补充说明（选填）</span>
            </div>
            <textarea rows="5" cols="30" class="reportInput" id="reportInput" name="reportInput">请输入举报理由</textarea>

            <button class="btnM" type="submit" onsubmit="document.charset='utf-8'">提交</button>
            <button class="btnM1" type="button" formtarget="_self" onclick="closeRDiv()">取消</button>
        </form>
    </div>

</div>
<%--隐藏遮罩层--%>
 <div id="hidebg" style="position:absolute;left:0px;top:0px;
        background-color:gray;
        width:100%;  /*宽度设置为100%，这样才能使隐藏背景层覆盖原页面*/
        opacity:0.6;  /*非IE浏览器下设置透明度为60%*/
        display:none; /* http://www.jb51.net */
        z-Index:9"></div>
<%--评论框--%>
<div id="response" style="display: none;margin: 10px 15px">
    <form id="commentForm" name="commentForm" style="display: contents" accept-charset="utf-8" method="post" action="comment">
    	<!--评论cid-->
    	<input style="display: none" id="replyAid" name="replyAid" value=""/>
    	<input style="display: none" id="replyRid" name="replyRid" value=""/>
    	<!-- 评论内容-->
        <textarea id="commentSend" name="commentSend" style="display:inline;width: 100%;height: 80px;-webkit-border-radius: 3px;padding: 2px 5px"></textarea>
        <!-- 提交按钮-->
        <input class="btnModi" value="发表评论" type="submit" />
    </form>
</div>
<div class="viewContainer">
    <%
    int uid=Integer.parseInt(session.getAttribute("uid").toString());
	String u=Integer.toString(uid);
	session.setAttribute("uid", u);
    %>
    <div class="mainAsideBox">
    <jsp:include page="RightBan.jsp"/>
        <div class="container_l">
            
            <div class="mainLeft">
                <div class="quesFloor">
                <%
                
                  int aid=Integer.parseInt(request.getParameter("aid"));//主贴id
                  mysql_get obj=new mysql_get();
                  only obj1=new only();
                  mysql_getint obj2=new mysql_getint();
                  List<post> post=obj2.post_getData("aid", aid);
                  List<userpost> userpost=obj2.userpost_getData("aid", aid);
                  List<userreply> repost1=obj2.userreply_getData("aid", aid);
				List<uco> uco=obj2.uco_getData("uid",uid);											
                  post pp=post.get(0);//帖子表
                  userpost up=userpost.get(0);//用户发帖表
                  String title=pp.getTitle();//标题
                  int userid=up.getUid();//用户id
                  List<user> user=obj2.user_getData("uid", userid);
                  String username=user.get(0).getUname();//用户名
                  int level=user.get(0).getLevel();//等级
                  String time=up.getAtime();//发帖时间
                  String content=pp.getContent();//帖子内容
                  int num=repost1.size();//帖子回复数
					int comNum=0;//评论数
                  int reNum=0;//回帖数
                  //用户收藏
                  int ucoFlag=0;
                  for(int l=0;l<uco.size();l++){
                	  if(uco.get(l).getAid()==aid){
                		  ucoFlag=1;
                	  }
                  }
                  
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
                                    <a><span id="fav" data-aid="<%=aid%>" ></span></a>
                                    <span><%=num %></span>
                                    <a href="javascript:backAll(<%=aid%>)"><span id="back" data-aid="<%=aid %>" style="color: rgb(103,103,103)">返回全部楼层</span></a>
                                    <a href="javascript:report1(<%=aid%>)">举报</a>
                                </div>
                            </div>
                        </div>
                    </section>
					<script>
                	var ucoflag='<%=ucoFlag%>';
                	if(ucoflag==='1'){
                		document.getElementById("fav").innerHTML="已收藏";
                	}else{
                		document.getElementById("fav").innerHTML="收藏";
                	}
                	
                </script>
                
                    <%	
                    	String rUid=request.getParameter("rUid");//指定“只看TA”的uid
                    	List<userreply> rr=obj2.userreply_getData("aid", aid);
                    	for(int i=0;i<rr.size();i++){
                    		userreply rr_1=rr.get(i);
                    		int rid=rr_1.getRid();//回帖id
                    		int ruid=rr_1.getUid();
                    		List<user> us=obj2.user_getData("uid", ruid);
                    		String rname=us.get(0).getUname();//回帖用户名
                    		int rlevel=us.get(0).getLevel();//回帖用户等级
                    		String reply=rr_1.getReply();//回帖内容
                    		String rtime=rr_1.getRtime();//回帖时间
							List<usercomment> com=new ArrayList<usercomment> ();
                    		com=obj1.usercomment_getData(aid,rid);//评论list
                    		System.out.print("rid"+rid);											  
                    	
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
                                    <a href="javascript:praise(<%=rid%>,<%=aid%>,<%=reNum%>)"><span class="praise">点赞</span></a>
                                    <div class="commentBtn" onclick="comment(this,<%=rr_1.getRid()%>)"><span class="comment">评论</span></div>
                                    <a href="javascript:reportReply(<%=ruid%>,<%=aid%>)">举报</a>
                                    <% 
                                    	List<userpraise> praise=obj2.userpraise_getData("aid",aid, "uid", uid);
	                                  //用户点赞
	                            		int praFlag=0;
	                            		for(int l=0;l<praise.size();l++){
	                            			if(praise.get(l).getRid()==rid){
	                            				praFlag=1;
	                            			}
	                            		}
                                    %>
                                    <script>
					                	var praflag='<%=praFlag%>';
					                	console.log(praflag);
					                	if(praflag=='1'){
					                		document.getElementsByClassName("praise")['<%=reNum%>'].innerHTML="取消点赞";
					                	}else{
					                		document.getElementsByClassName("praise")['<%=reNum%>'].innerHTML="点赞";
					                	}
					                	
					                </script>						  
                                </div>
                            </div>
                            <%
                            	for(int j=0;j<com.size();j++){
                            		usercomment com1=com.get(j);
                            		List<user> us_c=obj2.user_getData("uid", com1.getUid());
                            		String us_cname=obj2.name(com1.getUid());//评论人用户名
                            		int us_clevel=obj2.level(com1.getUid());//评论人等级                            	
                            %>
                            <div class="erComment">
                                <div class="commentHead">
                                    <span><%=us_cname %> &nbsp</span><span style="color:#1e88e5"><%=us_clevel%></span>
                                    <span class="commentCon"><%=com1.getComment() %></span>
                                </div>
                                <div class="erControl1">
                                    <div class="erControlR">
                                        <label class="datetime"><%=com1.getCtime() %></label>
                                        <%-- <a href="javascript:praiseCom(<%=com1.getCid() %>)"><span class="praise">点赞</span></a>
                                        --%>
                                        <a href="javascript:reportCom1(<%=rid %>,<%=aid %>,<%=com1.getCid() %>)">举报</a>
                                    </div>
                                </div>

                            </div>
                            <% 
                            } %>
                        </div>
                    </section>
                    <%
						reNum++;
					} %>
                    
                </div>
				 <div class="replyEdit">
                        <div class="mainArticleList" id="editor1">
                            <p>发表你的观点</p>
                        </div>
                        <form id="reply_ques" method="post" action="">
                        <input id="replytext" name="replytext" style="display:none" value="">
                        <input style="display:none" value="<%=aid%>" name="aid">
                            <input class="btnCommit" type="submit" id="reply_commit" name="reply_commit" value="发表">
                            <script type="text/javascript" src="wangEditor-3.1.1/release/wangEditor.min.js"></script>
                            <script language="JavaScript">
                                var rich_editor=window.wangEditor
                                var ed=new rich_editor('#editor1')
                                ed.create();
                                document.getElementById('reply_commit').addEventListener('click', function(){
                            	var text=ed.txt.text();
                            	if(text==null){
                            		alert("请输入帖子内容");
                            	}else{
                            		alert(text);
                            		document.getElementById("replytext").setAttribute("value", text);
                            		document.getElementById("reply_ques").setAttribute("action", "reply_post");
                            	}
                            	
                            }, false)
                            
                            </script>
                            
																																   
                        </form>
                        <script>
		                	document.getElementById('reply_commit').addEventListener('click', function(){
		                	var text=ed.txt.text();
		                    HttpSession session=request.getSession();
		                    session.setAttribute("replytext",text);
		                }, false)
		                </script>
                    </div>
        </div>
    </div>
</div>

<jsp:include page="foot.jsp"/>

<script>
		$('#fav').click(
		   function (event) {
		    let string=jQuery("#fav").text();
		     var aid=jQuery("#fav").data("aid");
		    if(string.includes("已")){
		    	location.href="cancelfavServlet?method=cancelfav&aid="+aid;
		        $("#fav").html("收藏");
		    }else {//取消收藏
		        location.href="favServlet?method=fav&aid="+aid;
		        $("#fav").html("已收藏")
		    }
		    })
</script>		
<script>
	$("#back").click(function(event){
		var aid=$("#back").data("aid");
		location.href="QuesInfo.jsp?aid="+aid;
	})
    function report1(aid) {
        //点击举报主贴
        document.getElementById("reportDiv").style.display="";
        var reportobj=document.getElementById("reportCon");
        reportobj.setAttribute("action", "reportPostServlet");
        var postobj=document.getElementById("postId");
        postobj.setAttribute("value", aid);
        var hideobj=document.getElementById("hidebg");
        hideobj.style.display="block";  //显示隐藏层
        hideobj.style.height=document.body.clientHeight+"px";  //设置隐藏层的高度为当前页面高度
    }
    function reportReply(rid,aid){
    	//点击举报回帖
    	document.getElementById("reportDiv").style.display="";
        var reportobj=document.getElementById("reportCon");
        reportobj.setAttribute("action", "reportReplyServlet");
        var postobj=document.getElementById("postId");
        postobj.setAttribute("value", aid);
        var replyobj=document.getElementById("replyId");
        replyobj.setAttribute("value", rid);
        var hideobj=document.getElementById("hidebg");
        hideobj.style.display="block";  //显示隐藏层
        hideobj.style.height=document.body.clientHeight+"px";  //设置隐藏层的高度为当前页面高度
    }
    function reportCom1(rid,aid,cid){
    	//点击举报评论
    	document.getElementById("reportDiv").style.display="";
        var reportobj=document.getElementById("reportCon");
        reportobj.setAttribute("action", "reportComServlet");
        var postobj=document.getElementById("postId");
        postobj.setAttribute("value", aid);
        var replyobj=document.getElementById("replyId");
        replyobj.setAttribute("value", rid);
        var comobj=document.getElementById("comId");
        comobj.setAttribute("value", cid);
        var hideobj=document.getElementById("hidebg");
        hideobj.style.display="block";  //显示隐藏层
        hideobj.style.height=document.body.clientHeight+"px";  //设置隐藏层的高度为当前页面高度
    }
    function closeRDiv() {//关闭举报框
        document.getElementById("reportDiv").style.display="none";
        document.getElementById("hidebg").style.display="none";
    }
    function praise(rid,aid,i) {//点赞
        var pDiv=document.getElementsByClassName("praise")[i];
        if(pDiv.innerHTML=="点赞"){
            location.href="praiseServlet?method=praise&aid="+aid+"&rid="+rid;
            pDiv.style.color="red";
            pDiv.innerHTML="取消点赞";
        }else {//取消点赞
            location.href="cancelpraiseServlet?method=cancelpraise&aid="+aid+"&rid="+rid;
            pDiv.style.color = "#676767"
            pDiv.innerHTML = "点赞";
        }
    }
    var eleComment=document.getElementsByClassName('comment');//评论
    for(var i=0;i<eleComment.length;i++){
        (function (current) {
            current.onclick=function (event) {
                current.parentNode.parentNode.parentNode.parentNode.appendChild(document.getElementById("response"));
                $('#response').css('display','flex');
                $('#replyRid').val(current.dataset.rid);
                $('#replyAid').val(current.dataset.aid);
            };
        })(eleComment[i]);
    }

</script>
</body>
</html>