<%-- 
    Document   : index
    Created on : 2014-7-7, 8:20:28 完成时间20130716
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

        <link href="<%=basePath%>Images/fls.ico" rel="shortcut icon" type="image/x-icon"/>
        <script type="text/javascript">
            function SetWinHeight(obj)
            {
                var win=obj;
                if (document.getElementById)
                {
                    if (win && !window.opera)
                        alert("!");
                    {
                        if (win.contentDocument && win.contentDocument.body.offsetHeight)
                            win.height = win.contentDocument.body.offsetHeight; 
                        else if(win.Document && win.Document.body.scrollHeight)
                            win.height = win.Document.body.scrollHeight;
                    }
                }
            }
        </script>
        <title><s:text name="join"></s:text></title>
        </head>

        <!--
        <iframe width="100%" src="<%=basePath%>NavigateAction?navFlag=index" align="center" height="100%"  marginheight="0" marginwidth="0" id="win" name="win" onload="Javascript:SetWinHeight(this)" frameborder="0" scrolling="no"></iframe>
    -->   
    <%
        //request.getRequestDispatcher(basePath + "NavigateAction?navFlag=index").forward(request, response);
%>



    <frameset cols="100%,0"　 marginwidth="0" marginheight="0" scrolling="no" frameborder="0" allowtransparency="true">
        <frame id="win" name="win" src="<%=basePath%>NavigateAction?navFlag=index" 　noresize="noresize" frameborder="0" >
            <noframes>
                <body id="top">
                </body>
            </noframes>
    </frameset>
            
           
</html>
