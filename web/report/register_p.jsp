<%-- 
    Document   : register_p
    Created on : 2015/12/18, 23:30:09
    Author     : kenji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int times1 = Integer.parseInt(request.getParameter("投球回１"));
    int times2 = Integer.parseInt(request.getParameter("投球回２"));
    String win = request.getParameter("勝敗");
    int hit = Integer.parseInt(request.getParameter("被安打"));
    int k = Integer.parseInt(request.getParameter("三振"));
    int walks = Integer.parseInt(request.getParameter("四死球"));
    int runs_allowed = Integer.parseInt(request.getParameter("失点"));
    int runs_earned = Integer.parseInt(request.getParameter("自責点"));

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=times1%><br>
        <%=times2%><br>
        <%=win%><br>
        <%=hit%><br>
        <%=k%><br>
        <%=walks%><br>
        <%=runs_allowed%><br>
        <%=runs_earned%><br>

    </body>
</html>
