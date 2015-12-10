<%-- 
    Document   : Kadai08_1
    Created on : 2015/11/26, 15:00:19
    Author     : C0114112
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題8-1</title>
    </head>
    <body>
        <h1>Kadai08_1.html</h1>
        <table border ="1">
            <tr>
                <th>氏名</th>
                <td><%=request.getParameter("name")%></td>
            </tr>
            <tr>
                <th>趣味</th>
                <td><%=request.getParameter("hobby")%></td>
            </tr>
            <tr>
                <th>性別</th>
                <td><%=request.getParameter("gender")%></td>
            </tr>
        </table>
    </body>
</html>
