/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package en09;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author C0114112
 */
@WebServlet(name = "Kadai09_3", urlPatterns = {"/Kadai09_3"})
public class Kadai09_3 extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Kadai09_3</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Kadai09_3 at " + request.getContextPath() + "</h1>");
            Exam[] ex = new Exam[3];
            ex[0] = new Exam("工科大", 76);
            ex[1] = new Exam("計算好美", 42);
            ex[2] = new Exam("画像良太", 95);

            out.print("<table border = 1>");
            out.print("<tr>");
            out.print("<th>");
            out.print("氏名");
            out.print("</th>");
            out.print("<th>");
            out.print("点数");
            out.print("</th>");
            out.print("<th>");
            out.print("評価");
            out.print("</th>");
            out.print("</tr>");
            for (int i = 0; i < ex.length; i++) {
                out.print("<tr>");
                out.print("<th>");
                out.print(ex[i].getName());
                out.print("</th>");
                out.print("<th>");
                out.print(ex[i].getPoint());
                out.print("</th>");
                out.print("<th>");
                out.print(ex[i].getResult());
                out.print("</th>");
                out.print("</tr>");
            }
            out.print("</table>");
            out.println("</body>");
            out.println("</html>");
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
