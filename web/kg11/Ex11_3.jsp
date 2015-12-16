<%-- 
    Document   : Ex11_3
    Created on : 2015/12/15, 11:47:30
    Author     : C0114112
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>サーブレットとJSPの連携(Javaコード)</h1>
        受け取った値は<br>
        <%=request.getAttribute("time")%><br>
                
    </body>
</html>
