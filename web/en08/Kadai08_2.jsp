<%-- 
    Document   : Kadai08_2
    Created on : 2015/11/26, 15:16:55
    Author     : C0114112
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
   %>
   <%
            String s1 = request.getParameter("radio");
                
            String[] s2 = new String[4];
            s2[0]="野球";
            s2[1]="サッカー";
            s2[2]="ラグビー";
            s2[3]="バドミントン";
            String japanese ="";
            
            if(s1.equals("baseball")){
                japanese = s2[0];
            }else if(s1.equals("soccer")){
                japanese = s2[1];
            }else if(s1.equals("rugby")){
                japanese = s2[2];
            }else if(s1.equals("badminton")){
                japanese = s2[3];
            }
            
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kadai08_2</title>
    </head>
    <body>
        <h1>Kadai08_2.jsp</h1>
        
        あなたの選んだスポーツは<%=japanese%>です。<br>
        英語表記は「<%=s1%>」です。
                
    </body>
</html>
