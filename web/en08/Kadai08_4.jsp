<%-- 
    Document   : Kadai08_4
    Created on : 2015/11/26, 15:49:36
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
        <title>Kadai08_4</title>
    </head>
    <body>
        <h1>Kadai08_4.jsp</h1>
        <h1>アンケート結果</h1>
        <hr>
        <table border ="0">
            <tr><th>名前：</th>
                <td><%=request.getParameter("name")%></td>
            </tr>
            <tr><th>評価：</th>
                <td><%=request.getParameter("評価")%></td>
            </tr>
            <tr><th>自由意見：</th>
                <td><%=request.getParameter("textArea").replaceAll("\n","<br>")%></td>
            </tr>
        </table>
            <hr>
            <%@include file="Time.jsp"%>
    </body>
</html>
