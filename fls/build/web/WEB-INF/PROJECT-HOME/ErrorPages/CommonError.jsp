<%-- 
    Document   : CommonError
    Created on : 2014-7-8, 10:42:14
    Author     : Tone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
    <head>
        <base href="<%=basePath%>">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">    
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <STYLE type=text/css>.mod-notfound {
                BORDER-RIGHT: #e1e1e1 1px solid; BORDER-TOP: #e1e1e1 1px solid; MARGIN-TOP: 10px; BACKGROUND: #fff; BORDER-LEFT: #e1e1e1 1px solid; BORDER-BOTTOM: #e1e1e1 1px solid; HEIGHT: 585px; TEXT-ALIGN: center; border-radius: 10px
            }
        </STYLE>
        <script language="javascript" src="<%=basePath%>JavaScript/jquery-1.3.1.min.js"></script>
        <script language="javascript" src="<%=basePath%>JavaScript/common.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=basePath%>CSS/common.css"> 
        <link rel="stylesheet" type="text/css" href="<%=basePath%>CSS/people.css">	
        <title>JSP Page</title>
    </head>
    <body>

        <a name="top"></a>
        <div id="tips">
            <div id="tips_w">
                <div id="tips_t" class="tips_t">
                    <span id="message_text"></span><span id="message_dock" class="message_dock"></span>
                </div>
            </div>
        </div>
        <!-- begin  header_wrap-->
        <div id="header_wrap">
            <!-- begin  header -->
            <div id="header">
                <a id="logo" href="<%=basePath%>NavigateAction?navFlag=index" title="欢迎进入牢骚网!" style="position: static; -webkit-transform: rotate(0deg); left: 2px; top: 1px;">

                </a>
                <!-- begin  login_state -->
                <div id="login_state">
                    <s:if test="#session.LOGIN_USER.user_id!=null">
                        <div id="people_nav">
                            <dl>
                                <dt><s:property value="#session.LOGIN_USER.user_funUsers.size"/></dt>
                                <dd><a href="<%=basePath%>user/UserInfoAction!viewFollws?viewflag=follws&currentPage=1&viewuser_id=${session.LOGIN_USER.user_id}">关 注</a></dd>
                            </dl>
                            <dl style="border-left:1px solid #164673">
                                <dt><s:property value="#session.LOGIN_USER.user_followUsers.size"/></dt>
                                <dd><a href="<%=basePath%>user/UserInfoAction!viewFuns?viewflag=funs&currentPage=1&viewuser_id=${session.LOGIN_USER.user_id}">粉 丝</a></dd>
                            </dl>
                            <div id="settings_menu">
                                <s:if test="#session.LOGIN_USER.user_imageurl!=null">
                                    <a href="<%=basePath%>user/UserInfoAction!viewUserInfo?viewflag=index&viewuser_id=${session.LOGIN_USER.user_id}" title="${session.LOGIN_USER.user_name}">
                                        <img id="face_image" src="<%=basePath%>user/PhotoAction?viewuser_id=<s:property value="#session.LOGIN_USER.user_id"/>"></a>
                                    </s:if>
                                    <s:else>
                                    <a href="<%=basePath%>user/UserInfoAction!viewUserInfo?viewflag=index&viewuser_id=${session.LOGIN_USER.user_id}" title="${session.LOGIN_USER.user_name}"><img id="face_image" src="<%=basePath%>Images/list_m.gif"></a>
                                    </s:else>
                                <a href="javascript:settingMenuToggle()"><span></span></a>
                            </div>
                            <div id="settings_menu_drop">
                                <ul>
                                    <li><a href="<%=basePath%>user/UserInfoAction!viewUserInfo?viewflag=index&viewuser_id=${session.LOGIN_USER.user_id}" class="w">${session.LOGIN_USER.user_name}</a></li>
                                    <li><a href="<%=basePath%>NavigateAction?navFlag=edituserinfo">修改资料</a></li>
                                    <li><a href="<%=basePath%>NavigateAction?navFlag=chgpass">修改密码</a></li>
                                    <li style="border-top:1px solid #456B8F"><a href="<%=basePath%>NavigateAction?navFlag=logout" class="w">退出登录</a></li>
                                </ul>
                            </div>
                        </div>
                    </s:if><s:else>
                        <div id="login_nav">
                            <span id="reg">
                                <a href="<%=basePath%>NavigateAction?navFlag=register">
                                    <b>注册</b>
                                </a>
                            </span>
                            <span id="login">
                                <a href="<%=basePath%>NavigateAction?navFlag=login" >
                                    <b>登录</b>
                                </a>
                            </span>
                        </div>

                    </s:else>
                </div>
                <!-- end  login_state -->
                <!-- begin  search -->
                <div id="search">

                    <s:form action="ThemeAction!queryThemeByKey" namespace="/theme" method="post" name="searchform" >          
                        <input type="hidden" name="currentPage" id=currentPage value="1">
                        <input type="text" name="searchKey" id="search_q" value="按关键字/昵称/编号搜索" >
                        <input type="submit" value="" id="search_submit">
                    </s:form>

                </div>
                <!-- end  search -->
            </div>
            <!-- end  header  -->
        </div>
        <!-- end  header_wrap-->

        <div id="wrap">
            <div id="wrap_left">
                <!-- begin menu -->

                <!-- end menu -->

                <!-- begin  wrap_info-->
                <div id="wrap_info">

                </div>
                <!-- end  wrap_info-->
                <div id="profile_right" style="width:650px;">
                    <SECTION class=mod-page-body>
                        <DIV class="mod-page-main wordwrap clearfix">
                            <DIV class=x-page-container>
                                <DIV class="mod-notfound grid-98">
                                    <IMG class=img-notfound height=320 src="<%=basePath%>Images/x.gif" width=520>
                                    <P style="FONT-SIZE: 24px; LINE-HEIGHT: 70px">啊~哦~ 您要查看的页面不存在或已删除！</P>
                                    <P style="MARGIN-BOTTOM: 30px">请检查您输入的网址是否正确，或者点击链接继续浏览空间</P>
                                    <P style="FONT-SIZE: 14px; LINE-HEIGHT: 20px">您可以回到
                                        <A href="<%=basePath%>NavigateAction?navFlag=index">网站首页</A> 
                                        <BR>如若不能解决您的问题，联系作者
                                        <A href="mailto:bcsflilong@gmail.com?subject=来自牢骚网的邮件,${session.LOGIN_USER.user_name}" >bcsflilong@gamil.com</A>

                                </DIV>
                            </DIV>
                        </DIV>
                    </SECTION>
                    <s:if test="#session.LOGIN_USER.user_id!=null">

                        <s:if test="#session.LOGIN_USER.user_power=='root'">
                            CommonError
                            <s:debug></s:debug>
                        </s:if>

                    </s:if>


                </div>
            </div>


            <!-- left end -->
            <!-- // -->
            <div id="wrap_right">
                <div class="box_one">
                    <h2>已有[<s:property value="#application.userNum"/>]人 发出[<s:property value="#application.themeNum"/>] 个牢骚！</h2>
                    <hr />
                </div>
                <div class="box_one">
                    <h2>全部分类</h2>
                    <div id="right_menu_box">
                        <ul>
                            <s:iterator value="#application.Categorylist" var="category">
                                <li><a href="<%=basePath%>theme/ThemeAction!queryThemeByKey?searchKey=<s:property value="#category.config_value"/>&currentPage=1&chgEncoding=YES"><b>${category.config_value}</b></a></li>
                            </s:iterator>

                        </ul>
                    </div>
                    <div id="mini_ad_box">
                        <a href="<%=basePath%>NavigateAction?navFlag=inWall"  title="This Is The New Shit!"><img src="<%=basePath%>Images/xjad2.jpg" alt="This Is The New Shit!"></a>
                    </div>     
                </div>

                <div class="box_one">
                    <h2>人品排行榜</h2>
                    <s:iterator value="#application.userList" var="user">
                        <div class="pic_frame">
                            <a href="<%=basePath%>user/UserInfoAction!viewUserInfo?viewflag=index&viewuser_id=${user.user_id}" title="${user.user_name}">
                                <s:if test="#user.user_imageurl!=null">
                                    <s:if test="#user.imageFlag==false">
                                        <img src="<%=basePath%>user/PhotoAction?viewuser_id=${user.user_id}&rand='<%=Math.random()%>'" width="53" height="53" alt="${user.user_name} ">
                                        <%  //防止报错
                                           // out.clear();
                                            //out = pageContext.pushBody();
                                        %>
                                    </s:if>
                                    <s:else>
                                        <img src="<%=basePath%>Images/faces/${user.user_imageurl}" width="53" height="53" alt="${user.user_name} ">
                                    </s:else>
                                </s:if><s:else>
                                    <img src="<%=basePath%>Images/list_m.gif" width="53" height="53" alt="${user.user_name} ">
                                </s:else>

                            </a>
                        </div>
                    </s:iterator>	

                </div>
                <div class="box_one new_comments">
                    <h2>热门标签</h2>

                    <s:iterator value="#application.tagsList" var="tag">
                        <a href="<%=basePath%>theme/ThemeAction!queryThemeByKey?searchKey=<s:property value="#tag"/>&currentPage=1&chgEncoding=YES" class="tag" >${tag }</a>  
                    </s:iterator>  
                </div>

                <div class="box_one fixed_box" style="position: static; top: 0px;">
                    <iframe id="cproIframe3" src="<%=basePath%>advert/Advert.jsp" width="300" height="250" align="center,center" marginwidth="0" marginheight="0" scrolling="no" frameborder="0" allowtransparency="true">
                    </iframe>
                </div>

                <!-- ////////////////////////////////////// -->

            </div>
            <div class="clear"></div>
        </div>

        <div style="margin: auto; margin-top: 20px; width: 1000px;" id="links">
            <div style="float: left; width: 1000px; padding: 10px 10px 0 0; line-height: 20px; font-size: 12px;">
                友情链接:
                <s:iterator value="#application.urlList" var="url">

                    <a href="${url.config_db_value}" target="_blank">${url.config_value}</a> |

                </s:iterator>

                <br>
                友情链接事宜请发邮件至 
                <a href="mailto:bcsflilong@gmail.com?subject=来自牢骚网的邮件,${session.LOGIN_USER.user_name}">bcsflilong@gmail.com </a>

            </div>
            <div class="clear"></div>
        </div>

        <div id="footer_wrap">
            <div id="footer">
                <ul>
                    <li class="f"><a href="<%=basePath%>NavigateAction?navFlag=index">牢骚网</a>© 2009-2013 <br> </li>
                    <li><a href="<%=basePath%>NavigateAction?navFlag=about" >关于牢骚网</a></li>
                    <li><a href="<%=basePath%>NavigateAction?navFlag=help">常见问题</a></li>
                    <li><a href="<%=basePath%>NavigateAction?navFlag=advert">广告合作</a></li>
                    <li><a href="<%=basePath%>NavigateAction?navFlag=account">隐私声明</a></li>
                    <li><a href="<%=basePath%>NavigateAction?navFlag=index" target="_blank" title="订阅牢骚网"><img src="<%=basePath%>Images/feed.gif"> </a></li>
                    <li class="f" style="margin-left: 30px;"> <a href="<%=basePath%>NavigateAction?navFlag=index">吉ICP备10004485号${application.updateTime}</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>

        <div class="back_to_top" style="display: none;"></div>
    </body>
</html>
