<%-- 
    Document   : index
    Created on : 2014-7-7, 12:14:27
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
        <title><s:property value="pageEntity.list.size"></s:property></title>
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
                <div id="menu">
                    <div id="menu_lb"></div>
                    <div id="menu_cen">
                        <div id="menu_cen_left">
                            <ul>
                                <li><a href="<%=basePath%>theme/ThemeAction!queryTheme?serachtype=MAX_NEW&currentPage=1" <s:if test="#request.serachtype=='MAX_NEW'">class="now" </s:if > >最 新</a></li>
                                <li><a href="<%=basePath%>theme/ThemeAction!queryTheme?serachtype=MAX_YES&currentPage=1" <s:if test="#request.serachtype=='MAX_YES'">class="now" </s:if > >最郁闷</a></li>
                                <li><a href="<%=basePath%>theme/ThemeAction!queryTheme?serachtype=MAX_NO&currentPage=1"  <s:if test="#request.serachtype=='MAX_NO'">class="now" </s:if >  >最矫情</a></li>
                                <li><a href="<%=basePath%>theme/ThemeAction!queryTheme?serachtype=RAND&currentPage=1"  <s:if test="#request.serachtype=='RAND'">class="now" </s:if >   >随 机</a></li>
                                <li><a href="<%=basePath%>theme/ThemeAction!queryTheme?serachtype=MAX_DISS&currentPage=1" <s:if test="#request.serachtype=='MAX_DISS'">class="now" </s:if > >评 论</a></li>

                                </ul>
                            </div>
                        <s:if test="#session.LOGIN_USER.user_id!=null">
                            <div id="menu_cen_right">
                                <span>发牢骚</span>
                            </div>
                        </s:if>
                    </div>
                    <div id="menu_rb"></div>
                </div>
                <!-- end menu -->

                <!-- begin  wrap_info-->
                <div id="wrap_info">
                    <div id="pub_wrap" style="display: none;">
                        <s:form action="ThemeAction!sendTheme" namespace="/theme" method="post" name="sendlsform" onsubmit="return check_sendls();">          

                            <input type="hidden" name="uid" value="${session.LOGIN_USER.user_id}">
                            <ul>
                                <li class="big">发出你的牢骚!</li>
                            </ul>
                            <div id="nickname_box">
                                昵称:<input type="text" name="nickname" id="input_nickname"size="25" 
                                          style="border: 1px solid #578CCA; height: 20px" value="${session.LOGIN_USER.user_name }" readonly="readonly"/>
                            </div>

                            <div id="cat_box">
                                分类:<select name="cat" id="input_cat" style="border: 1px solid #578CCA;">
                                    <option value="">请选择</option>
                                    <s:iterator value="#application.Categorylist" var="category">
                                        <option value="${category.config_value}">${category.config_value}</option>
                                    </s:iterator>
                                </select>
                            </div>
                            <div id="count_box">
                                还可以输入<span>150</span>字
                                <h1><s:property value="#session.USER_NAME"/></h1>
                            </div>
                            <div id="c_box">
                                <textarea name="content" id="input_content" onkeyup="cut(this)"   
                                          style="border: 1px solid #578CCA; width: 555px; height: 90px; padding: 5px;" wrap="physical"  
                                          class="input_content"></textarea>
                            </div>

                            <div id="tag_box">
                                标签:
                                <input type="text" name="theme_tags1" id="theme_tags1" size="5"style="border: 1px solid #578CCA; height: 20px">
                                <input type="text" name="theme_tags2" id="theme_tags2" size="5"style="border: 1px solid #578CCA; height: 20px">
                                <input type="text" name="theme_tags3" id="theme_tags3" size="5"style="border: 1px solid #578CCA; height: 20px">
                                （每个牢骚最多3个标签）

                            </div>

                            <div id="submit_box">

                                <input type="submit" id="btn_pub" value="提 交">
                            </div>
                        </s:form>
                        <div class="clear"></div>

                    </div>
                </div>
                <!-- end  wrap_info-->
                <!-- end  infobox -->
                <s:if test="%{pageEntity.allRow >= 1}">
                    <s:iterator value="pageEntity.list" var="theme">

                        <div class="infobox">
                            <div class="c">
                                <a href="<%=basePath%>theme/ReplyAction!queryReply?currentPage=1&theme_id=${theme.theme_id} ">
                                    <span style="word-warp:break-word;word-break:break-all; display:-moz-inline-box; display:inline-block;" >
                                        <s:property escape="false" value="#theme.theme_content" />
                                    </span>
                                </a>
                            </div>
                            <div class="date">
                                <div id="dateleft">
                                    <a href="<%=basePath%>theme/ReplyAction!queryReply?currentPage=1&theme_id=${theme.theme_id}">查看    <!-- #${theme.theme_index } --></a> 评论(<font color="red"><s:property value="#theme.theme_replys.size"/></font>)
                                </div>
                                <div id="dateright">
                                    <span class="voteyes" id="voteyes${theme.theme_id}">
                                        <a href="javascript:"onclick="voteyes('${theme.theme_id}','${theme.theme_yes}');">的确郁闷</a>
                                        <font color="#aaaaaa">(${theme.theme_yes})</font>
                                    </span> &nbsp;&nbsp;&nbsp;&nbsp;
                                    <span class="voteno" id="voteno${theme.theme_id}">
                                        <a href="javascript:" onclick="voteno('${theme.theme_id}','${theme.theme_no}');">有点矫情</a> 
                                        <font color="#aaaaaa">(${theme.theme_no})</font>
                                    </span>
                                    <br>
                                    <font color="red"><s:date name="#theme.theme_updatetime" format="yyyy-MM-dd HH:ss:mm"/> </font>
                                    &nbsp;
                                    by
                                    <a href="<%=basePath%>user/UserInfoAction!viewUserInfo?viewflag=index&viewuser_id=<s:property value="#theme.theme_owner.user_id"/>">
                                        <font color="blue"><s:property value="#theme.theme_owner.user_name"/></font>
                                    </a>
                                    &nbsp;&nbsp;&nbsp;
                                    分类:
                                    <a href="<%=basePath%>theme/ThemeAction!queryThemeByKey?searchKey=<s:property value="#theme.theme_category"/>&currentPage=1&chgEncoding=YES"> 
                                        <font color="green"><s:property value="#theme.theme_category"/> </font>
                                    </a>
                                    &nbsp;&nbsp;&nbsp;
                                    标签:
                                    <s:if test="#theme.theme_tags1!=''">
                                        <a href="<%=basePath%>theme/ThemeAction!queryThemeByKey?searchKey=<s:property value="#theme.theme_tags1"/>&currentPage=1&chgEncoding=YES">
                                            <font color="blue">
                                            <s:property value="#theme.theme_tags1"/>
                                            </font>
                                        </a>&nbsp;
                                    </s:if>
                                    <s:if test="#theme.theme_tags2!=''">
                                        <a href="<%=basePath%>theme/ThemeAction!queryThemeByKey?searchKey=<s:property value="#theme.theme_tags2"/>&currentPage=1&chgEncoding=YES">
                                            <font color="blue">
                                            <s:property value="#theme.theme_tags2"/>
                                            </font>
                                        </a>&nbsp;
                                    </s:if>
                                    <s:if test="#theme.theme_tags3!=''">
                                        <a href="<%=basePath%>theme/ThemeAction!queryThemeByKey?searchKey=<s:property value="#theme.theme_tags3"/>&currentPage=1&chgEncoding=YES">
                                            <font color="blue">
                                            <s:property value="#theme.theme_tags3"/>
                                            </font>
                                        </a>&nbsp;
                                    </s:if>
                                    &nbsp;&nbsp;&nbsp;
                                    <span id="fav_${theme.theme_id}">
                                        <a onclick="addtofav('${theme.theme_id}')" style="cursor: pointer">+加入收藏</a>
                                    </span>

                                    <a title="分享到人人网"   href="javascript:void(function(){var d=document,e=encodeURIComponent,r='http://share.xiaonei.com/share/buttonshare.do?link='+e('<%=basePath%>issue/DiscussAction!queryreply?currentPage=1&theme_id=${theme.theme_id}')+'&title='+e('分享生活中的牢骚！'),x=function(){if(!window.open(r,'xnshare','toolbar=0,resizable=1,scrollbars=yes,status=1,width=450,height=330'))location.href=r+'&r=1'};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})()">
                                        <img align="absmiddle" src="Images/renren.jpg" width="16" height="16" border="0" alt="分享到人人网">
                                    </a> 
                                    <a title="分享到新浪微博" href="javascript:void((function(s,d,e){try{}catch(e){}var f='http://v.t.sina.com.cn/share/share.php?',u=d.location.href,p=['url=',e('<%=basePath%>issue/DiscussAction!queryreply?currentPage=1&theme_id=${theme.theme_id}'),'&title= <s:property escape="false" value="#theme.theme_content" />this the a new  shit！&appkey=2495395889&ralateUid=1657779303'].join('');function a(){if(!window.open([f,p].join(''),'mb',['toolbar=0,status=0,resizable=1,width=620,height=450,left=',(s.width-620)/2,',top=',(s.height-450)/2].join('')))u.href=[f,p].join('');};if(/Firefox/.test(navigator.userAgent)){setTimeout(a,0)}else{a()}})(screen,document,encodeURIComponent));">
                                        <img align="absmiddle" src="Images/sina.jpg" width="16" height="16" border="0" alt="分享到新浪微博">
                                    </a>
                                    <a title="分享到腾讯微博"  href="javascript:void(0);" onclick="postToWb('<%=basePath%>','<%=basePath%>issue/DiscussAction!queryreply?theme_id=${theme.theme_id}&currentPage=1','${theme.theme_id}','<s:property escape="false" value="#theme.theme_content" />');">
                                        <img align="absmiddle" src="Images/qq.jpg" width="16" height="16" border="0" alt="分享到腾讯微博">
                                    </a> 


                                </div>
                            </div>
                        </div>

                    </s:iterator>

                    <s:if test="#request.serachtype=='bykey'">
                        <s:if test="%{pageEntity.list.size>0}">
                            <div id="paging">
                                <span> 
                                    <a> 共 <font color="red"><s:property value="pageEntity.allRow"/> </font>条记录 </a>
                                    <a> 共<font color="red"><s:property value="pageEntity.totalPage"/></font> 页 </a> 
                                    <a> 当前第<font color="red"><s:property value="pageEntity.currentPage"/></font>页</a> </span>
                                <span>
                                    <s:if test="%{pageEntity.currentPage == 1}">
                                        <a>第一页 </a> 
                                        <a>上一页</a>
                                    </s:if>
                                    <s:else>
                                        <a href="<%=basePath%>theme/ThemeAction!queryThemeByKey?currentPage=1">第一页</a>
                                        <a href="<%=basePath%>theme/ThemeAction!queryThemeByKey?currentPage=<s:property value="%{pageEntity.currentPage-1}"/>">上一页</a> 
                                    </s:else>
                                    <s:if test="%{pageEntity.currentPage != pageEntity.totalPage}">
                                        <a href="<%=basePath%>theme/ThemeAction!queryThemeByKey?currentPage=<s:property value="%{pageEntity.currentPage+1}"/>">下一页</a>
                                        <a href="<%=basePath%>theme/ThemeAction!queryThemeByKey?currentPage=<s:property value="pageEntity.totalPage"/>">最后一页</a>
                                    </s:if>
                                    <s:else>
                                        <a>下一页</a>  
                                        <a>最后一页</a>
                                    </s:else>
                                </span>
                            </div>
                        </s:if>

                    </s:if>
                    <s:else>
                        <s:if test="%{pageEntity.list.size>0}">
                            <div id="paging">
                                <span> 
                                    <a> 共 <font color="red"><s:property value="pageEntity.allRow"/> </font>条记录 </a>
                                    <a> 共<font color="red"><s:property value="pageEntity.totalPage"/></font> 页 </a> 
                                    <a> 当前第<font color="red"><s:property value="pageEntity.currentPage"/></font>页</a> </span>
                                <span>
                                    <s:if test="%{pageEntity.currentPage == 1}">
                                        <a>第一页</a> 
                                        <a>上一页</a>
                                    </s:if>
                                    <s:else>
                                        <a href="<%=basePath%>theme/ThemeAction!queryTheme?currentPage=1">第一页</a>
                                        <a href="<%=basePath%>theme/ThemeAction!queryTheme?currentPage=<s:property value="%{pageEntity.currentPage-1}"/>">上一页</a> 
                                    </s:else>
                                    <s:if test="%{pageEntity.currentPage != pageEntity.totalPage}">
                                        <a href="<%=basePath%>theme/ThemeAction!queryTheme?currentPage=<s:property value="%{pageEntity.currentPage+1}"/>">下一页</a>
                                        <a href="<%=basePath%>theme/ThemeAction!queryTheme?currentPage=<s:property value="pageEntity.totalPage"/>">最后一页</a>
                                    </s:if>
                                    <s:else>
                                        <a>下一页</a>  
                                        <a>最后一页</a>
                                    </s:else>
                                </span>
                            </div>
                        </s:if>
                    </s:else>
                    <s:if test="%{pageEntity.list.size>0}">
                        <div style="float: left; margin-top: 10px;">
                            <s:form theme="xhtml" action="ThemeAction!queryTheme" namespace="/theme" method="post" name="gotoform" onsubmit="return check_goto_Submit();">
                                <input type="hidden" name="totalPage"  value="<s:property value="pageEntity.totalPage"/>">        
                                穿越到<input type="text" name="currentPage" style="width: 30px; height: 16px;">页 
                                <input type="submit" value="走~">
                            </s:form>
                        </div>
                    </s:if>
                </s:if>
                <s:else>
                    <div  style="float:left; width:670px; line-height:24px; text-align:center; font-size:18px; font-weight:bold; margin-top:10px; padding-top:20px; padding-bottom:15px; border:2px dashed #CCDCEF;">没有找到<s:property value="#request.searchKey"></s:property>类型的牢骚<br>
                            <span style="color:#B1B5B5; font-weight:normal; font-size:13px;">牢骚网</span>
                        </div>   
                </s:else>

            </div>


            <!-- left end -->
            <!-- // -->
            <div id="wrap_right">
                <div class="box_one">
                    <h2>已有[<s:property value="#application.userNum"/>]人 发出[<s:property value="#application.themeNum"/>] 个牢骚！</h2>                    
                    <div class="boundary"></div>
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
                                    <!--
                                     <img src="<%=basePath%>user/PhotoAction?viewuser_id=${user.user_id}&rand='<%=Math.random()%>'" width="53" height="53" alt="${user.user_name} ">
                                    -->
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
                <div class="clear"></div>
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
