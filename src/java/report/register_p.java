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
        try (PrintWriter out = response.getWriter()) {
            Connection con = null;
            Statement stmt = null;
            try {
                int times1 = Integer.parseInt(request.getParameter("投球回１"));
                int times2 = Integer.parseInt(request.getParameter("投球回２"));
                String win = request.getParameter("勝敗");
                int hit = Integer.parseInt(request.getParameter("被安打"));
                int k = Integer.parseInt(request.getParameter("三振"));
                int walks = Integer.parseInt(request.getParameter("四死球"));
                int runs_allowed = Integer.parseInt(request.getParameter("失点"));
                int runs_earned = Integer.parseInt(request.getParameter("自責点"));
                out.println("<html>");
                out.print("<head>");
                out.print("</head>");
                out.print(times1);
                out.print(times2);
                out.print(win);
                out.print(hit);
                out.print(k);
                out.print(walks);
                out.print(runs_allowed);
                out.print(runs_earned);

                out.print("</html");
            } catch (Exception e) {
                e.printStackTrace();
            }

            /*try {
             Class.forName("org.apache.derby.jdbc.ClientDriver");

             String driverUrl = "jdbc:derby://localhost:1527/pdata";
             con = DriverManager.getConnection(driverUrl, "db", "db");
             stmt = con.createStatement();

             //String sql = "";
             //ResultSet rs = stmt.executeQuery(sql);

             } catch (Exception e) {

             }*/
        }
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
