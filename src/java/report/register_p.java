/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

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
 * @author kenji
 */
@WebServlet(name = "register_p", urlPatterns = {"/register_p"})
public class register_p extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Connection con = null;
        Statement stmt = null;
        try {

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

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverUrl = "jdbc:derby://localhost:1527/bbdata";
            con = DriverManager.getConnection(driverUrl, "db", "db");
            stmt = con.createStatement();

            String sql = "select max(P_ID) as MAXID from P_DATA";
            ResultSet rs = stmt.executeQuery(sql);

            //IDの設定
            int max = 0;
            while (rs.next()) {
                max = rs.getInt("MAXID") + 1;
            }

            //クオリティスタートの判定
            int qs = 0;
            if (starter.equals("ON") && runs_earned < 4) {
                qs = 1;
            }

            //投球回数の計上
            int time = ((times1 * 3) + times2);

            int wins = 0;
            int save = 0;
            int lose = 0;
            if (win.equals("win")) {
                wins++;
            } else if (win.equals("lose")) {
                lose++;
            } else if (win.equals("save")) {
                save++;
            } else {

            }

            sql = "insert into P_DATA values(" + max + ",'" + name + "'," + qs + "," + time + "," + wins + "," + lose + "," + save + "," + hit + "," + k + "," + walks + "," + runs_allowed + "," + runs_earned + " )";
            int count = stmt.executeUpdate(sql);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>登録完了</title></head>");
            out.println("<body><hr/>");

            if (count != 0) {
                out.print("登録しました。<br>");
            } else {
                out.println("登録に失敗しました。<br>");
            }
            out.print("<a href=\"report/main_page.html\">トップに戻る</a><br>");
            out.println("<hr/></body>");
            out.println("</html>");
        } catch (Exception e) {
            out.println(e);
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
