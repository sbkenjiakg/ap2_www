<%-- 
    Document   : Kadai07_1
    Created on : 2015/11/19, 15:04:59
    Author     : C0114112
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        50から180の整数のうち、9の倍数、かつ4の倍数ではない数<br>
        <%
            Set<Integer> set1 = new TreeSet<Integer>();

            for (int i = 50; i <= 180; i++) {
                if (i % 4 != 0 && i % 9 == 0) {
                    set1.add(i);
                }
            }
            Iterator<Integer> iter;
            iter = set1.iterator();
            while (iter.hasNext()) {
                int element = iter.next();
        %>
        <%=element%> <br>
        <%
            }
        %>



    </body>
</html>
