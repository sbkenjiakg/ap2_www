/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kg12;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author C0114112
 */
@WebServlet(name = "Ex12_2", urlPatterns = {"/Ex12_2"})
public class Ex12_2 extends HttpServlet {

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

        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Ex12_2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>受け取り</h1>");

            // multipart/form-data か確認
            if (ServletFileUpload.isMultipartContent(request)) {
                out.println("アップロードを実行します。<br>");
            } else {
                out.println("ファイルアップローダではありません。<br>");
                out.close();
                return;
            }

            // ServletFileUploadクラスのインスタンスを作成
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(factory);

            // アップロードするファイルのサイズ上限等を指定
            int fileSizeMax = 1024000;
            factory.setSizeThreshold(1024);
            sfu.setSizeMax(fileSizeMax);
            sfu.setHeaderEncoding("UTF-8");

            // ブラウザ出力用書式
            String format = "%s:%s<br>%n";

            // 受け取ったデータの処理用
            FileItemIterator fileIt = sfu.getItemIterator(request);

            while (fileIt.hasNext()) {
                FileItemStream item = fileIt.next();

                if (item.isFormField()) {
                    //通常フィールド
                    out.print("<br>ファイル以外の場合<br>");
                    out.printf(format, "フィールド名", item.getFieldName());
                    InputStream is = item.openStream();

                    // 出力用の byte 配列を用意
                    byte[] b = new byte[255];

                    // byte型配列変数 b に入力ストリームからデータを読み込み
                    is.read(b, 0, b.length);

                    // byte型配列変数 b の内容を "UTF-8" のコードでString型に変換し result へ代入
                    String result = new String(b, "UTF-8");
                    out.printf(format, "内容", result);
                } else {
                    //ファイルフィールド
                    out.print("<br>ファイルの場合<br>");
                    out.printf(format, "ファイル名", item.getName());
                    InputStream is = item.openStream();

                    String fileName = item.getName();
                    int len = 0;
                    byte[] buffer = new byte[fileSizeMax];

                    FileOutputStream fos = new FileOutputStream("D:\\NetBeansProjects\\ap2_www\\web\\kg12\\" + fileName);
                    try {
                        while ((len = is.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    } finally {
                        fos.close();
                    }

                }
            }
            out.println("</body>");
            out.println("</html>");
        } catch (FileUploadException e) {
            out.println(e + "<br>");
            throw new ServletException(e);
        } catch (Exception e) {
            out.println(e + "<br>");
            throw new ServletException(e);
        } finally {
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
