<%-- 
    Document   : Ex71
    Created on : 2015/11/17, 11:45:12
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
        <h1>Hello World!</h1>
        <%
            for (int i = 0; i < 5; i++) {
        %>
        くりかえし<%=i%>回<br>
        <%
            }
        %>
    </body>
    
</html>
