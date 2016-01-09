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
 * @author C0114112
 */
@WebServlet(name = "browse_f", urlPatterns = {"/browse_f"})
public class browse_f extends HttpServlet {

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
        Connection con = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>野手情報</title>");
            out.println("</head>");
            out.println("<body>");

            Class.forName("org.apache.derby.jdbc.ClientDriver");

            String driverUrl = "jdbc:derby://localhost:1527/bbdata";
            con = DriverManager.getConnection(driverUrl, "db", "db");
            stmt = con.createStatement();

            String sql = "select * from F_DATA";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                out.println("ID：" + rs.getInt("F_ID") + "<br>");
                out.println("名前：" + rs.getString("F_NAME") + "<br>");
                out.println("打数：" + rs.getInt("F_BATNUM") + "<br>");
                out.println("安打：" + rs.getInt("F_HIT") + "<br>");
                out.println("本塁打：" + rs.getInt("F_HOMERUN") + "<br>");
                out.println("打点：" + rs.getInt("F_RBI") + "<br>");
                out.println("犠打：" + rs.getInt("F_SACRIFICE") + "<br>");
                out.println("四死球：" + rs.getInt("F_WALKS") + "<br>");
                out.println("<hr>");
            }
            rs.close();
            
            out.println("<a href=\"report/main_page.html\">戻る</a></body>");
            out.println("</html>");

        } catch (Exception e) {
            out.println(e);
            throw new ServletException(e);
        } finally {

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
