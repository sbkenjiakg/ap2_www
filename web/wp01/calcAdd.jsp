<%-- 
    Document   : calcAdd
    Created on : 2016/05/31, 14:18:35
    Author     : C0114112
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    request.setCharacterEncoding("UTF-8");

    int num1 = Integer.parseInt(request.getParameter("num1"));
    int num2 = Integer.parseInt(request.getParameter("num2"));
    int ans = num1 + num2;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>足し算と背景</title>
    </head>
    <body background = "../404.jpg">
        <%=num1%>+<%=num2%>
        答え <%=ans%>
    </body>
</html>
