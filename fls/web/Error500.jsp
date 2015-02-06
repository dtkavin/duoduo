<%-- 
    Document   : Error500
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
                </div>
                <!-- end  login_state -->
                <!-- begin  search -->
                
                <!-- end  search -->
            </div>
            <!-- end  header  -->
        </div>
        <!-- end  header_wrap-->

        <div id="wrap">
            <div id="wrap_left">
                <div id="wrap_info">

                </div>
                <!-- end  wrap_info-->
                <div id="profile_right" style="width:650px;">
                    <SECTION class=mod-page-body>
                        <DIV class="mod-page-main wordwrap clearfix">
                            <DIV class=x-page-container>
                                <DIV class="mod-notfound grid-98">
                                    <IMG class=img-notfound height=320 src="<%=basePath%>Images/x.gif" width=520>
                                    <P style="FONT-SIZE: 24px; LINE-HEIGHT: 70px">啊~哦~ 您的操作产生的致命的错误！</P>
                                    <P style="MARGIN-BOTTOM: 30px">请检查您输入的网址是否正确，或者点击链接继续浏览空间</P>
                                    <P style="FONT-SIZE: 14px; LINE-HEIGHT: 20px">您可以回到
                                        <A href="<%=basePath%>NavigateAction?navFlag=index">网站首页</A> 
                                        <BR>如若不能解决您的问题，联系作者
                                        <A href="mailto:bcsflilong@gmail.com?subject=来自牢骚网的邮件" >bcsflilong@gamil.com</A>

                                </DIV>
                            </DIV>
                        </DIV>
                    </SECTION>
                </div>
            </div>

       　　　
            <!-- left end -->
            <!-- // -->
            <div id="wrap_right">
                <div class="box_one">
                    
                </div>
                <div class="box_one">
                  
                </div>

                <div class="box_one">
                    

                </div>
                <div class="box_one new_comments">
                    
                </div>



                <!-- ////////////////////////////////////// -->

            </div>
            <div class="clear"></div>
        </div>

        <div style="margin: auto; margin-top: 20px; width: 1000px;" id="links">
            <div style="float: left; width: 1000px; padding: 10px 10px 0 0; line-height: 20px; font-size: 12px;">
              
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
                    <li class="f" style="margin-left: 30px;"> <a href="<%=basePath%>NavigateAction?navFlag=index">吉ICP备10004485号</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>

        <div class="back_to_top" style="display: none;"></div>
    </body>
</html>
