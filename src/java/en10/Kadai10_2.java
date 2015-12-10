/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package en10;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author C0114112
 */
@WebServlet(name = "Kadai10_2", urlPatterns = {"/Kadai10_2"})
public class Kadai10_2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //コネクションとステートメントの宣言
        Connection con = null;
        Statement stmt = null;
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Kadai10_2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Kadai10_2 at " + request.getContextPath() + "</h1>");

            //WebアプリケーションのときはClass.forNameが必要
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            /* 接続先を確認，自分のデータベース名に合わせること */
            String driverUrl = "jdbc:derby://localhost:1527/restaurant";
            con = DriverManager.getConnection(driverUrl, "db", "db");
            stmt = con.createStatement();

            //SQLの発行
            String sql = "select max(MENU_ID) as MAXID from T_MENU";

            /* 2. SQL文を実行しResultSetの取得 */
            ResultSet rs = stmt.executeQuery(sql);
            int maxID = 0;
            if (rs.next()) {
                maxID = rs.getInt("MAXID") + 1;
            }

            sql = "insert into T_MENU values(" + maxID + ",'ラーメン',500,500)";
            int count = stmt.executeUpdate(sql);
            if (count != 0) {
                out.println(count + "レコードを更新しました。<br>");
            } else {
                out.println("レコードを更新できませんでした。<br>");
            }
            /* 3. 1つずつレコードを読み込み出力する */
            sql = "select * from T_MENU";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                out.println("MENU_ID=" + rs.getString("MENU_ID") + "<br>");
                out.println("MENUNAME=" + rs.getString("MENUNAME") + "<br>");
                out.println("CALORIE=" + rs.getString("CALORIE") + "<br>");
                out.println("PRICE=" + rs.getString("PRICE") + "<br>");
                out.println("<hr>");
            }
            //ResultSetを解放（close）
            rs.close();

            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            //サーブレット内での例外をアプリケーションのエラーとして表示
            out.println(e); // ブラウザ上に出力
            throw new ServletException(e);
        } finally {
            //例外が発生したときでも確実にデータベースから切断
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
            }
        }
        //PrintWriterをclose
        out.close();

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
