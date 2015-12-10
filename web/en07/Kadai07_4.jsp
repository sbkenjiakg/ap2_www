<%-- 
    Document   : Kadai07_4
    Created on : 2015/11/19, 15:49:26
    Author     : C0114112
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>音楽リスト</h1>
        <%
            List<String> music = new ArrayList<String>();
            music.add("Dragon Night:SEKAI NO OWARI");
            music.add("R.Y.U.S.E.I:三代目 J Soul Brothers form EXILE TRIBE");
            music.add("あったかいんだからぁ♪:クマムシ");
            music.add("もしも運命の人がいるのなら:西野カナ");
            music.add("あなたに恋をしてみました:chay");
            music.add("Darling:西野カナ");
            music.add("私以外私じゃないの:ゲスの極み乙女");
            music.add("愛唄～since 2007～:whiteeeen");
            music.add("ひまわりの約束:秦基博");
            music.add("ヒロイン:back number");

            for (String str : music) {
        %>
        <ul><il><%= str%><br></il></ul>
        <%
            }
        %>
        <hr>
        現在再生中の曲<br>
        ♪ 
        <%
        String s = music.get((int)(Math.random()*music.size()));
        %>
        <%=s%>
    </body>
</html>
