<%-- 
    Document   : Kadai07_2
    Created on : 2015/11/19, 15:29:56
    Author     : C0114112
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    double getArea(int a,int b,int c){
        double s = (a+b+c)/2.0;
        double t = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        return t;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>三角形の面積</h1>
        a=3,b=4,c=5<br>
        面積は<%=getArea(3,4,5)%>です<br>
        a=5,b=7,c=9<br>
        面積は<%=getArea(5,7,9)%>です<br>
        
        
    </body>
</html>
