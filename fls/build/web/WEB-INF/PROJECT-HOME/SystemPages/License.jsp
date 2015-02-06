<%-- 
    Document   : License
    Created on : 2014-7-8, 10:02:19
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>用户须知</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">    
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <STYLE type=text/css>.mod-notfound {
                BORDER-RIGHT: #e1e1e1 1px solid; BORDER-TOP: #e1e1e1 1px solid; MARGIN-TOP: 10px; BACKGROUND: #fff; BORDER-LEFT: #e1e1e1 1px solid; BORDER-BOTTOM: #e1e1e1 1px solid; HEIGHT: 385px; TEXT-ALIGN: center; border-radius: 5px
            }
        </STYLE>
        <script type="text/javascript">
            <!--
            function colseLciense(){
                //alert(window.opener.document.getElementById("alread").checked);
                window.opener.document.getElementById("alread").checked=true;
                alert("您已经阅读用户须知，并同意其中相关内容");
                window.close();
            }
            //-->
        </script>

        <script language="javascript" src="<%=basePath%>JavaScript/jquery-1.3.1.min.js"></script>
        <script language="javascript" src="<%=basePath%>JavaScript/main.js"></script>
        <script language="javascript" src="<%=basePath%>JavaScript/common.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=basePath%>CSS/common.css"> 
        <link rel="stylesheet" type="text/css" href="<%=basePath%>CSS/people.css">
    </head>
    <body >
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

            </div>
            <!-- end  header  -->
        </div>
        <!-- end  header_wrap-->
        <!-- ######################################################################################### -->
        <div id="wrap">
            <div id="wrap_left">

                <div id="profile_right" style="width:650px;hight:350px">
                    <div class="set_header">用户须知</div>
                    <div class="boundary"></div>
                    <div style="line-height:24px;"> 
                        <section class=mod-page-body>
                            <div class="mod-page-main wordwrap clearfix">
                                <div class=x-page-container>
                                    <div class="mod-notfound grid-98">
                                        <br />  1.言论可以自由，但是请注意素质，禁止喷人。
                                        <br />  2.不要涉及敏感词汇 小心被和谐，如果牢骚网被和谐掉，作者做鬼也不会放过你的
                                        <br />  3.不要发布故意的虚假信息，如果你的言论造成群众的恐慌，责任要自负，作者是罩不住你的
                                        <br /><img src="<%=basePath%>Images/logo.jpg"/>
                                        <br /><input type="button" value="同意你就点这里" onclick="colseLciense();"/>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </div> 
                </div>
            </div>
            <!-- left end -->

            <div class="clear"></div>
        </div>
        <div class="back_to_top" style="display: none;"></div>
    </body>
</html>
