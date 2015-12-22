<%-- 
    Document   : Ex12_1
    Created on : 2015/12/22, 11:19:15
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
        <h1>アップロード</h1>
        <form action="../Ex12_1" method="POST" enctype="multipart/form-data">
            ファイル<input type="file" name="uploadFile" value="" /><br>
            コメント<input type="text" name="comment" value="" /><br>
            <input type="submit" value="送信" name="btn" />
        </form>
    </body>
</html>
