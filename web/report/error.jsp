<%-- 
    Document   : error
    Created on : 2016/01/08, 1:32:42
    Author     : C0114112
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>error page</title>
    </head>
    <body>
        以下のエラーが発生しました。<br>
        <hr>
        <%
        out.println(exception.toString());
        
        
        
        %>
        <hr>
        <a href="main_page.html">戻る</a>
    </body>
</html>
