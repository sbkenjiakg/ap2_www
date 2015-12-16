/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kg11;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author C0114112
 */
@WebServlet(name = "Ex11_5", urlPatterns = {"/Ex11_5"})
public class Ex11_5 extends HttpServlet {

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

            //コネクションとステートメントの宣言
            Connection con = null;
            Statement stmt = null;

            try {
                //WebアプリケーションのときはClass.forNameが必要
                Class.forName("org.apache.derby.jdbc.ClientDriver");

                //データベース「meibo」への接続
            /* 接続先を確認，自分のデータベース名に合わせること */
                String driverUrl = "jdbc:derby://localhost:1527/meibo3";
                con = DriverManager.getConnection(driverUrl, "db", "db");
                stmt = con.createStatement();

                //SQLの作成し実行(student_id順で取得)
                String sql = "select * from T_STUDENT order by student_id";
                ResultSet rs = stmt.executeQuery(sql);

                // Listクラスの変数を宣言
                List<Student> data = new ArrayList<>();

                //全てのデータを出力
                while (rs.next()) {
                    Student st = new Student();
                    st.setStudentID(rs.getInt("student_id"));
                    st.setFullname(rs.getString("fullname"));
                    st.setGakubuID(rs.getInt("gakubu_id"));
                    st.setGrade(rs.getInt("grade"));
                    st.setScore(rs.getInt("score"));

                    // data に追加
                    data.add(st);
                }
                //メモリを解放
                rs.close();

                // data を list としてセットする
                request.setAttribute("list", data);

                // Ex11_5.jsp に request の内容を送る
                RequestDispatcher rd = request.getRequestDispatcher("kg11/Ex11_5.jsp");
                // フォワード
                rd.forward(request, response);

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
