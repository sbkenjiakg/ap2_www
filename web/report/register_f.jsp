<%-- 
    Document   : register_f
    Created on : 2016/01/05, 10:59:42
    Author     : C0114112
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp"%>

<%
    request.setCharacterEncoding("UTF-8");
    
    String name = request.getParameter("name");
    int batnum  = Integer.parseInt(request.getParameter("batnum"));
    int hit = Integer.parseInt(request.getParameter("hit"));
    int homerun = Integer.parseInt(request.getParameter("homerun"));
    int rbi = Integer.parseInt(request.getParameter("rbi"));
    int sacrifice = Integer.parseInt(request.getParameter("sacrifice"));
    int walks = Integer.parseInt(request.getParameter("walks"));

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録確認</title>
    </head>
    <body>
        <h3>登録確認</h3>
        以下の内容で登録します。

        <table border="1">
            <tbody>
                <tr>
                    <td>選手名</td>
                    <td><%=name%></td>
                </tr>
                <tr>
                    <td>打席</td>
                    <td><%=batnum%></td>                    
                </tr>              
                <tr>
                    <td>安打</td>
                    <td><%=hit%></td>
                </tr>
                <tr>
                    <td>本塁打</td>
                    <td><%=homerun%></td>
                </tr>
                <tr>
                    <td>打点</td>
                    <td><%=rbi%></td>
                </tr>
                <tr>
                    <td>犠打</td>
                    <td><%=sacrifice%></td>
                </tr>
                <tr>
                    <td>四死球</td>
                    <td><%=walks%></td>
                </tr>
            </tbody>
        </table>

        <form action="../register_f" method="POST">
            <input type="hidden" name="name" value="<%=name%>">
            <input type="hidden" name="batnum" value="<%=batnum%>">
            <input type="hidden" name="hit" value="<%=hit%>">
            <input type="hidden" name="homerun" value="<%=homerun%>">
            <input type="hidden" name="rbi" value="<%=rbi%>">
            <input type="hidden" name="sacrifice" value="<%=sacrifice%>">
            <input type="hidden" name="walks" value="<%=walks%>">
        
            <input type="submit" name="btn" value="確認"/>
            <input type="button" value="戻る" name="back" onClick="history.back()"/>
        </form>
    </body>
</html>
