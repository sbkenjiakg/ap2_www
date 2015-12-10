<%-- 
    Document   : Ex80_1
    Created on : 2015/11/24, 10:57:04
    Author     : C0114112
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.net.URLEncoder" %>
<%    String v1 = URLEncoder.encode("りんご", "UTF-8");
    String v2 = URLEncoder.encode("蜜柑", "UTF-8");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <h1>日本語受け渡し</h1>
        <a href="Ex80_4.jsp?s1=<%=v1%>&s2=<%=v2%>">日本語リンク</a>     

    </body>
</html>
