<%-- 
    Document   : Ex11_5
    Created on : 2015/12/15, 12:11:17
    Author     : C0114112
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "kg11.Student"%>
<%@page import = "java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            List<Student> dataList = (List<Student>) request.getAttribute("List");
            for (int i = 0; i < dataList.size(); i++) {
                Student st = dataList.get(i);

        %>
        <ul>
            <li><%=i + 1%>番目の学生</li>

            <ul>
                <li>学生ID：<%=st.getStudentID()%></li>
                <li>氏名：<%=st.getFullname()%></li>
                <li>学部ID：<%=st.getGakubuID()%></li>
                <li>学年：<%=st.getGrade()%></li>
                <li>得点：<%=st.getScore()%></li>
            </ul>
        </ul>

        <%
    }
        %>
    </body>
</html>
