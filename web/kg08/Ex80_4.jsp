<%-- 
    Document   : Ex82_2
    Created on : 2015/11/24, 11:20:17
    Author     : C0114112
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--
<%
    request.setCharacterEncoding("UTF-8"); これでも日本語出力できる
%>
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>リンク先：受け取った結果</h1>
        日本語受け取りその１：<%=request.getParameter("s1")%><br>
        日本語受け取りその２：<%=request.getParameter("s2")%>                
    </body>
</html>
