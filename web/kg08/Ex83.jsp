<%-- 
    Document   : Ex83
    Created on : 2015/11/24, 12:12:49
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>様々な入力フォームの受け取り</h1>
        <ul>
            <li>テキスト入力（テキスト）：<%=request.getParameter("txtInput")%></li>
            <li>テキスト入力（パスワード）：<%=request.getParameter("passInput")%></li>
            <li>複数行入力：<%=request.getParameter("textArea")%></li>
            <li>ラジオボタン１：<%=request.getParameter("radio1")%></li>
            <li>ラジオボタン２：<%=request.getParameter("radio2")%></li>
            <li>チェックボタン１：<%=request.getParameter("checkbtn1")%></li>
            <li>チェックボタン２：<%=request.getParameter("checkbtn2")%></li>
            <li>チェックボタン３：<%=request.getParameter("checkbtn3")%></li>
            <li>ドロップダウンリスト：<%=request.getParameter("language")%></li>
            <li>ファイル選択：<%=request.getParameter("selectFile")%></li>
        </ul>
    </body>
</html>
