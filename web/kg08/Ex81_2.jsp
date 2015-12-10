<%-- 
    Document   : Ex81_2
    Created on : 2015/11/24, 11:10:13
    Author     : C0114112
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>リンク先：受け取った値</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Year</th>
                    <td><%=request.getParameter("y")%></td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th>Month</th>
                    <td><%=request.getParameter("m")%></td>
                </tr>
                <tr>
                    <th>Day</th>
                    <td><%=request.getParameter("d")%></td>
                </tr>
                
            </tbody>
        </table>

    </body>
</html>
