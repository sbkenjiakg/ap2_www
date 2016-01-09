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
@WebServlet(name = "browse_p", urlPatterns = {"/browse_p"})
public class browse_p extends HttpServlet {

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
        
        Connection con = null;
        Statement stmt = null;
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>投手情報</title>");
            out.println("</head>");
            out.println("<body>");

            Class.forName("org.apache.derby.jdbc.ClientDriver");

            String driverUrl = "jdbc:derby://localhost:1527/bbdata";
            con = DriverManager.getConnection(driverUrl, "db", "db");
            stmt = con.createStatement();

            String sql = "select * from P_DATA";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                out.println("ID：" + rs.getInt("P_ID") + "<br>");
                out.println("名前：" + rs.getString("P_NAME") + "<br>");
                out.println("QS：" + rs.getInt("P_QS") + "<br>");
                int time = rs.getInt("P_TIME");
                String times = "";
                switch (time % 3) {
                    case 1:
                        time = (time-1)/3;
                        times = time + "回1/3";
                        break;
                    case 2:
                        time = (time-2)/3;
                        times = time + "回2/3";
                        break;
                    case 0:
                        time = time/3;
                        times = time + "回";
                        break;
                }
                out.println("投球回数：" + times +"<br>");
                out.println("勝利数：" + rs.getInt("P_WIN") + "<br>");
                out.println("負け数：" + rs.getInt("P_LOSE") + "<br>");
                out.println("セーブ：" + rs.getInt("P_SAVE") + "<br>");
                out.println("被安打：" + rs.getInt("P_HIT") + "<br>");
                out.println("奪三振：" + rs.getInt("P_K") + "<br>");
                out.println("四死球：" + rs.getInt("P_WALKS") + "<br>");
                out.println("失点：" + rs.getInt("P_RUNS_ALLOWED") + "<br>");
                out.println("自責点：" + rs.getInt("P_RUNS_EARNED") + "<br>");
                out.println("<hr>");
            }
            
            rs.close();

            out.println(" <a href=\"report/main_page.html\">戻る</a></body>");
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
