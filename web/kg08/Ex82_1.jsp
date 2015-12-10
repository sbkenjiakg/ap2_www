<%-- 
    Document   : Ex82_1
    Created on : 2015/11/24, 11:44:43
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
        <h1>入力ページ</h1>
        <form name ="入力ぺージ" action="Ex81_2.jsp" method="post">
            <table border="0">

                <tr>
                    <td>年</td>
                    <td><input type="text" name="y"></td>
                </tr>
                <tr>
                    <td>月</td>
                    <td><input type="text" name="m"></td>
                </tr>
                <tr>
                    <td>日</td>
                    <td><input type="text" name="d"></td>
                </tr>
                <tr>
                    <td colspan ="2"><input type="submit" name="btn" value="送信"></td>
                </tr>


        </form>
    </body>
</html>
