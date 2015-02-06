<%-- 
    Document   : MyJsp
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">    
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">

        <script language="JavaScript">
            //这里必须强制的刷新一次  否则  IE显示异常
            function reimage(){
    	    
                var image=document.getElementById("imageid");
                var image2=window.parent.document.getElementById("face_image");
    	    
                image.src="<%=basePath%>user/PhotoAction?viewuser_id=<s:property value="#request.viewuser_imageuserid"/>"+"&rand="+Math.random();
                image2.src=image.src;
    		
            }
        </script>
        <title>JSP Page</title>
    </head>
    <body <s:if test="#request.navFlag==edituserinfo">onload="reimage();" </s:if>>

        <s:if test="#request.imageurl!='mynopic'">
           
            <img id="imageid"    src="<%=basePath%>user/PhotoAction?viewuser_id=<s:property value="#request.viewuser_imageuserid"/>" width="100" height="100"/>
        </s:if>

        <s:else>
            <s:if test="#request.imageurl==mynopic">
               <img id="imageid"  src="<%=basePath%>user/PhotoAction?viewuser_id=<s:property value="#request.viewuser_imageuserid"/>" width="100" height="100"/>
            </s:if>
            <s:else>
                <img  id="imageid" src="<%=basePath%>Images/list_m.gif" width="100" height="100"/>
            </s:else>
        </s:else>


    </body>
</html>
