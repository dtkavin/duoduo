<%-- 
    Document   : ChgPassWord
    Created on : 2014-7-9, 15:14:04
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
        <script language="javascript" src="<%=basePath%>JavaScript/jquery-1.3.1.min.js"></script>

        <script language="javascript" src="<%=basePath%>JavaScript/common.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=basePath%>CSS/common.css"> 
        <link rel="stylesheet" type="text/css" href="<%=basePath%>CSS/people.css">	
        <title>JSP Page</title>
    </head>
    <body onload="login_onload_yes('${request.yesmsg}');login_onload_no('${request.nomsg}');">
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
                 <a id="logo" href="<%=basePath%>NavigateAction?navFlag=index" title="欢迎进入牢骚网!!" style="position: static; -webkit-transform: rotate(0deg); left: 2px; top: 1px;">

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
                                        <img id="face_image"  src="<%=basePath%>user/PhotoAction?viewuser_id=<s:property value="#session.LOGIN_USER.user_id"/>"></a>
                                    </s:if>
                                    <s:else>
                                    <a href="<%=basePath%>user/UserInfoAction!viewUserInfo?viewflag=index&viewuser_id=${session.LOGIN_USER.user_id}" title="${session.LOGIN_USER.user_name}"><img  id="face_image" src="<%=basePath%>Images/list_m.gif"></a>
                                    </s:else>
                                <a href="javascript:settingMenuToggle()"><span></span></a>
                            </div>
                            <div id="settings_menu_drop">
                                <ul>
                                    <li><a href="<%=basePath%>userinfo/UserInfoAction!viewuserinfo?viewflag=index&viewuser_id=${session.LOGIN_USER.user_id}" class="w">${session.LOGIN_USER.user_name}</a></li>
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
                    <s:form action="ThemeAction!queryThemeByKey" namespace="/theme"  theme="xhtml"method="post" name="searchform" >          
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
        <!-- ######################################################################################### -->
        <div id="wrap">
            <div id="wrap_left">
                <div id="profile_left">
                    <div id="preview_avatar">
                        <iframe   border:none scrolling="no" frameborder="0" name="face_frame" id="face_frame"  src="NavigateAction?navFlag=face&imageurl=<s:if test="#session.LOGIN_USER.user_imageurl!=null">${session.LOGIN_USER.user_imageurl}&viewuser_imageuserid=${session.LOGIN_USER.user_id}</s:if><s:else>mynopic</s:else>">
                        </iframe>
                    </div>
                    <ul>
                        <li><a href="javascript:void(0);"><span><s:property value="#session.LOGIN_USER.getUser_browse()"/></span>浏览</a></li>
                        <li><a href="<%=basePath%>user/UserInfoAction!viewFuns?viewflag=funs&currentPage=1&viewuser_id=${session.LOGIN_USER.user_id}" title="${session.LOGIN_USER.user_name}的粉丝们"><span><s:property value="#session.LOGIN_USER.user_followUsers.size"/></span>粉丝</a></li>
                        <li><a href="<%=basePath%>user/UserInfoAction!viewFollws?viewflag=follws&currentPage=1&viewuser_id=${session.LOGIN_USER.user_id}" title="${session.LOGIN_USER.user_name}关注的牢骚作者"><span><s:property value="#session.LOGIN_USER.user_funUsers.size"/></span>关注</a></li>
                        <li><a href="<%=basePath%>user/UserInfoAction!viewUserInfo?viewflag=index&&currentPage=1&viewuser_id=${session.LOGIN_USER.user_id}" title="${session.LOGIN_USER.user_name}的牢骚"><span><s:property value="#session.LOGIN_USER.user_issueThemes.size"/></span>牢骚</a></li>
                        <li><a href="<%=basePath%>user/UserInfoAction!viewReply?viewflag=reply&&currentPage=1&viewuser_id=${session.LOGIN_USER.user_id}" title="${session.LOGIN_USER.user_name}发布的评论"><span><s:property value="#session.LOGIN_USER.user_issueReplys.size"/></span>评论</a></li>
                        <li><a href="<%=basePath%>user/UserInfoAction!viewFave?viewflag=fave&&currentPage=1&viewuser_id=${session.LOGIN_USER.user_id}"" title="${session.LOGIN_USER.user_name}收藏的草蛋事儿"><span><s:property value="#session.LOGIN_USER.user_keepThemes.size"/></span>收藏</a></li>

                    </ul>
                </div>
                <div id="profile_right">
                    <div id="set_header">修改密码</div>
                    <div class="boundary"></div>
                    <s:form action="UserInfoAction!chgpass" namespace="/user" method="post" name="chgpassform" onSubmit="return check_rchgpass_Submit();" >          

                        <input type="hidden" name="type" value="act_account"/>
                        <div class="set_form_fields"><label class="title">旧密码</label><br><input type="password" name="old_password" style="width:170px;padding:3px;"></div>
                        <div class="set_form_fields"><label class="title">新密码</label><br><input type="password" name="new_password" style="width:170px;padding:3px;"></div>
                        <!--
                         <div class="set_form_fields">
                          <input  class="set_profile_btn" type="submit" value="确认修改"/>
                           </div>
                        -->
                        <div class="reg_item">
                            &nbsp;<input  class="set_profile_btn" type="submit" value="确认修改"/>
                        </div>
                    </s:form>


                </div>
            </div>
            <!-- left end -->
            <div id="wrap_right">

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
                        <a href="<%=basePath%>NavigateAction?navFlag=inWall" title="This Is The New Shit!"><img src="<%=basePath%>Images/xjad2.jpg" alt="This Is The New Shit!"></a>
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
