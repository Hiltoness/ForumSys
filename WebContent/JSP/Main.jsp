<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>积分技术论坛 - 论坛首页</title>
    <link type="text/css" rel="stylesheet" href="base.css"/>
    <link rel="icon" href="" type="image/x-icon" />
    <base target="_blank">
</head>
<body>
<div class="viewContainer">
    <div class="mainHeaderBox">
        <div class="container">
            <div class="mainNav">
                <a class="topTitle" href="main.html">积分技术论坛</a>
                <ul class="navList">
                    <li class="navItem"><a href="main.html">首页</a></li>
                    <span class="navText"> | </span>
                    <li class="navItem"><a href="publize.html">发帖</a></li>
                    <li class="navItem">
                        <form class="searchForm" id="MainSearch" method="post" action="">
                            <input class="searchInput" type="search" maxlength="50" id="MainSearchCont" placeholder="搜索内容">
                            <input class="searchIcon" type="image" src="icon/search.png" alt="搜索" >
                        </form>
                    </li>
                </ul>
            </div>
            <div class="mainLogin">
                <ul class="navLogin">
                    <li class="navItem"><a href="modify.html">个人中心</a></li>
                    <span class="navText"> | </span>
                    <li class="navItem"><a>退出</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="mainAsideBox">
        <div class="container">
            <aside class="aside">
                <div class="myCard">
                    <div class="asideCardUp">
                        <img class="headerImg" src="icon/search.png" />
                        <div class="headerName">
                            <span>Name</span>
                            <br/>
                            <span>Level</span>
                        </div>
                        <div class="headerCont">
                            <a><span class="headerContItem">我的帖子
                            <br/>20</span></a>
                            <a><span class="headerContItem">我的积分
                                <br/>20</span></a>
                            <a ><span class="headerContItem">我的收藏
                                <br/>20</span></a>
                        </div>
                    </div>
                    <div class="asideCardDown">
                        <ul class="MSG">
                            <li class="headerMSGTitle aHover"><a href="modify.html"><b>消息</b></a></li>
                            <li class="headerMSGItem"><a href="modify.html#Info1">评论</a></li>
                            <li class="headerMSGItem"><a href="modify.html#Info2">点赞</a></li>
                            <li class="headerMSGItem"><a href="modify.html#Info3">回复</a></li>
                            <li class="headerMSGItem"><a href="modify.html#Info4">系统通知</a></li>
                        </ul>
                        <ul class="MSG">
                            <li class="headerMSGTitle"><a href="modify.html#Info5"><b>资料</b></a></li>
                            <li class="headerMSGItem"><a href="modify.html#Info5">修改资料</a></li>
                            <li class="headerMSGItem"><a href="modify.html#Info6">修改密码</a></li>
                        </ul>
                    </div>
                </div>
                <div class="mainBullet">
                    <span class="headerMSGTitle"><b>论坛公告</b></span>
                    <ul>
                        <li class="mainBulletItem"><a>有奖征集</a></li>
                        <li class="mainBulletItem"><a>博主排名更新</a></li>
                        <li class="mainBulletItem"><a>系统升级通知</a></li>
                    </ul>
                </div>
            </aside>
            <main class="mainLeft">
                <section class="mainArticleList">
                    <h3 class="mainArticleTitle">
                        <span>热门帖子列表</span>
                    </h3>
                    <div class="mainArticleHead">
                        <span class="Head0">标题</span>
                        <span class="Head1">提问人</span>
                        <span class="Head2">时间</span>
                        <span class="Head3">回复数</span>
                    </div>
                    <ul class="mainTitleList">
                        <li>
                            <a class="mainQuesTitle" href="">银行家算法问题如何用Python求解</a>
                            <a class="mainQuestioner">最牛的人</a>
                            <span class="mainQuesTime">2020-05-20</span>
                            <span class="mainQuesReply">20</span>
                        </li>
                        <li><a class="mainQuesTitle" href="">Linux和Windows装机求指教</a>
                            <a class="mainQuestioner" href="">emikoshilo</a>
                            <span class="mainQuesTime">2020-05-04</span>
                            <span class="mainQuesReply">30</span>
                        </li>
                        <li><a class="mainQuesTitle" href="">Linux和Windows装机求指教</a>
                            <a class="mainQuestioner" href="">emikoshilo</a>
                            <span class="mainQuesTime">2020-05-04</span>
                            <span class="mainQuesReply">30</span>
                        </li>
                        <li><a class="mainQuesTitle" href="">Linux和Windows装机求指教</a>
                            <a class="mainQuestioner" href="">emikoshilo</a>
                            <span class="mainQuesTime">2020-05-04</span>
                            <span class="mainQuesReply">30</span>
                        </li>
                        <li><a class="mainQuesTitle" href="">Linux和Windows装机求指教</a>
                            <a class="mainQuestioner" href="">emikoshilo</a>
                            <span class="mainQuesTime">2020-05-04</span>
                            <span class="mainQuesReply">30</span>
                        </li>
                        <li><a class="mainQuesTitle" href="">Linux和Windows装机求指教</a>
                            <a class="mainQuestioner" href="">emikoshilo</a>
                            <span class="mainQuesTime">2020-05-04</span>
                            <span class="mainQuesReply">30</span>
                        </li>
                        <li><a class="mainQuesTitle" href="">Linux和Windows装机求指教</a>
                            <a class="mainQuestioner" href="">emikoshilo</a>
                            <span class="mainQuesTime">2020-05-04</span>
                            <span class="mainQuesReply">30</span>
                        </li>
                        <li><a class="mainQuesTitle" href="">Linux和Windows装机求指教</a>
                            <a class="mainQuestioner" href="">emikoshilo</a>
                            <span class="mainQuesTime">2020-05-04</span>
                            <span class="mainQuesReply">30</span>
                        </li>
                        <li><a class="mainQuesTitle" href="">Linux和Windows装机求指教</a>
                            <a class="mainQuestioner" href="">emikoshilo</a>
                            <span class="mainQuesTime">2020-05-04</span>
                            <span class="mainQuesReply">30</span>
                        </li>
                        <li><a class="mainQuesTitle" href="">Linux和Windows装机求指教</a>
                            <a class="mainQuestioner" href="">emikoshilo</a>
                            <span class="mainQuesTime">2020-05-04</span>
                            <span class="mainQuesReply">30</span>
                        </li>
                        <li><a class="mainQuesTitle" href="">Linux和Windows装机求指教</a>
                            <a class="mainQuestioner" href="">emikoshilo</a>
                            <span class="mainQuesTime">2020-05-04</span>
                            <span class="mainQuesReply">30</span>
                        </li>
                        <li><a class="mainQuesTitle" href="">Linux和Windows装机求指教</a>
                            <a class="mainQuestioner" href="">emikoshilo</a>
                            <span class="mainQuesTime">2020-05-04</span>
                            <span class="mainQuesReply">30</span>
                        </li>
                        <li><a class="mainQuesTitle" href="">Linux和Windows装机求指教</a>
                            <a class="mainQuestioner" href="">emikoshilo</a>
                            <span class="mainQuesTime">2020-05-04</span>
                            <span class="mainQuesReply">30</span>
                        </li>
                        <li><a class="mainQuesTitle" href="">Linux和Windows装机求指教</a>
                            <a class="mainQuestioner" href="">emikoshilo</a>
                            <span class="mainQuesTime">2020-05-04</span>
                            <span class="mainQuesReply">30</span>
                        </li>
                        <li><a class="mainQuesTitle" href="">Linux和Windows装机求指教</a>
                            <a class="mainQuestioner" href="">emikoshilo</a>
                            <span class="mainQuesTime">2020-05-04</span>
                            <span class="mainQuesReply">30</span>
                        </li>
                        <li><a class="mainQuesTitle" href="">Linux和Windows装机求指教</a>
                            <a class="mainQuestioner" href="">emikoshilo</a>
                            <span class="mainQuesTime">2020-05-04</span>
                            <span class="mainQuesReply">30</span>
                        </li>
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