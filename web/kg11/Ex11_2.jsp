<%-- 
    Document   : Ex11_2
    Created on : 2015/12/15, 11:41:09
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
        <h1>式言語</h1>
        <%
            int n =1+1;
            request.setAttribute("n", 1+1);
            String s = "こんにちわ";
            request.setAttribute("s", "こんにちわ");
            %>
            <ul>
                <li>式言語</li>
                1+1=${n}<br>
                s=${s}<br>
                <li>Javaのコードの式</li>
                1+1=<%=n%><br>
                s=<%=s%><br>
            </ul>
        
    </body>
</html>
