<%-- 
    Document   : Ex11_1
    Created on : 2015/12/15, 10:59:05
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
        <h1>式言語</h1>
        <ul>
            <li>1+1 = ${1+1};</li>
            <li>6/5 = ${6%5};</li>
            <li>6/5 = ${6 mod 5};</li>
            <li>"a==a":${"a"=="a"};</li>
        </ul>>
        <h1>Javaコード</h1>
        <ul>
            <li>1+1 = <%=1+1%></li>
            <li>6/5 = <%=6%5%>;</li>
            <li>"a==a":<%="a"=="a"%>;</li>
            <li>"a==a":<%="a".equals("a")%>;</li>

        </ul>
    </body>
</html>
