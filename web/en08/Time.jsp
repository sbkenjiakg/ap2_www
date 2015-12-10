<%-- 
    Document   : Time
    Created on : 2015/11/26, 16:15:41
    Author     : C0114112
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%!
    String getData() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日(E) hh:mm:ss");
        return sdf.format(new Date());
    }
%>
<%
    request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>

        <%= getData()%><br>
    </body>

</html>
