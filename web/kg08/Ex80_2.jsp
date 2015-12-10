<%-- 
    Document   : Ex80_2
    Created on : 2015/11/24, 11:01:26
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
        <h1>リンク先：受け取った結果</h1>
        <div>受け取った値その1：<%=request.getParameter("s1")%></div>
        受け取った値2：<%=request.getParameter("n")%>
        <div>受け取った値その3：<%=request.getParameter("s2")%> </div>
    </body>
</html>
