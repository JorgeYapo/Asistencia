/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento.control;

import com.google.zxing.EncodeHintType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.core.vcard.VCard;
import net.glxn.qrgen.javase.QRCode;
/**
 *
 * @author David
 */
@WebServlet(name = "GeneradorQR", urlPatterns = {"/GeneradorQR"})
public class GeneradorQR extends HttpServlet {

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
            OutputStream outStream = response.getOutputStream();
            
            String dato="";
             dato=request.getParameter("dni");             
            /*ByteArrayOutputStream outx = QRCode.from(dato)
                                        .withHint(EncodeHintType.MARGIN, 1)
                                        .withSize(250, 250)
                                        .to(ImageType.PNG)
                                        .stream();*/
        VCard vCard = new VCard();
        vCard.setName(dato);
        vCard.setAddress("street 1, xxxx address");
        vCard.setCompany("company Inc.");
        vCard.setPhoneNumber("+xx/xx.xx.xx");
        vCard.setTitle("title");
        vCard.setEmail("info@memorynotfound.com");
        vCard.setWebsite("http://memorynotfound.com");
        ByteArrayOutputStream bout =
                QRCode.from(vCard)
                        .withHint(EncodeHintType.MARGIN, 1)
                        .withSize(250, 250)
                        .to(ImageType.PNG)
                        .stream();
            response.setContentType("image/png");
            response.setContentLength(bout.size());
            
            //BufferedImage image = ImageIO.read(new ByteArrayInputStream(outx.toByteArray()));
            outStream.write(bout.toByteArray());
            //image.getScaledInstance(20, 20, 2);
            
            outStream.flush();
            outStream.close();          
       /* response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GeneradorQR</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GeneradorQR at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
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
