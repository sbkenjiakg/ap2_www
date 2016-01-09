<%-- 
    Document   : register_p
    Created on : 2015/12/18, 23:30:09
    Author     : kenji
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp"%>

<%
    request.setCharacterEncoding("UTF-8");
    
    String starter = request.getParameter("starter");
    String name = request.getParameter("name");
    int times1 = Integer.parseInt(request.getParameter("times1"));
    int times2 = Integer.parseInt(request.getParameter("times2"));
    String win = request.getParameter("win");
    int hit = Integer.parseInt(request.getParameter("hit"));
    int k = Integer.parseInt(request.getParameter("k"));
    int walks = Integer.parseInt(request.getParameter("walks"));
    int runs_allowed = Integer.parseInt(request.getParameter("runs_allowed"));
    int runs_earned = Integer.parseInt(request.getParameter("runs_earned"));
    
    int win_num=0;
    String[] result = {"勝ち", "負け", "セーブ", "勝敗つかず"};
    if (win.equals("win")) {
        win_num=0;
    } else if (win.equals("lose")) {
        win_num=1;
    } else if (win.equals("save")) {
        win_num=2;
    } else if (win.equals("draw")) {
        win_num=3;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録確認</title>
    </head>
    <body>
        <h3>登録確認</h3>
        以下の内容で登録します。

        <table border="1">
            <tbody>
                <tr>
                    <td>選手名</td>
                    <td><%=name%></td>
                </tr>
                <tr>
                    <td>投球回数</td>
                    <td><%=times1%>回<%=times2%>/3</td>                    
                </tr>              
                <tr>
                    <td>勝敗</td>
                    <td><%=result[win_num]%></td>
                </tr>
                <tr>
                    <td>被安打</td>
                    <td><%=hit%></td>
                </tr>
                <tr>
                    <td>奪三振</td>
                    <td><%=k%></td>
                </tr>
                <tr>
                    <td>四死球</td>
                    <td><%=walks%></td>
                </tr>
                <tr>
                    <td>失点</td>
                    <td><%=runs_allowed%></td>
                </tr>
                <tr>
                    <td>自責点</td>
                    <td><%=runs_earned%></td>
                </tr>
            </tbody>
        </table>

        <form action="../register_p" method="POST">
            <input type="hidden" name="starter" value="<%=starter%>">
            <input type="hidden" name="name" value="<%=name%>">
            <input type="hidden" name="times1" value="<%=times1%>">
            <input type="hidden" name="times2" value="<%=times2%>">
            <input type="hidden" name="win" value="<%=win%>">
            <input type="hidden" name="hit" value="<%=hit%>">
            <input type="hidden" name="k" value="<%=k%>">
            <input type="hidden" name="walks" value="<%=walks%>">
            <input type="hidden" name="runs_allowed" value="<%=runs_allowed%>">
            <input type="hidden" name="runs_earned" value="<%=runs_earned%>">           
            
            <input type="submit" name="btn" value="確認"/>
            <input type="button" value="戻る" name="back" onClick="history.back()"/>
        </form>
    </body>
</html>
