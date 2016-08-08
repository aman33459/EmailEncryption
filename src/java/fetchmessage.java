/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.aman.inbox.getinbox;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(urlPatterns = {"/fetchmessage"})
public class fetchmessage extends HttpServlet {

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
            throws ServletException, IOException, MessagingException {
        response.setContentType("text/html;charset=UTF-8");
            //communicating a simple String message.
    /*String messages1 = "Example source code of Servlet to JSP communication.";
    request.setAttribute("message", messages1);
      request.getRequestDispatcher("http://localhost:8999/mailproject/submitinf.jsp").forward(request,response);*/
        PrintWriter out = response.getWriter();
        Message[] message;
        getinbox aa = new getinbox();
        message=aa.receive("aman33459@gmail.com", "aman@2206");
        
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet fetchmessage</title>");            
            out.println("</head>");
              out.println("<body>");
        for (int i = message.length-1; i >= message.length-2; i--) {  
             Message messages = message[i];  
        /*out.println("");  
       out.println("Email Number " + (message.length - i ));  
        out.println("Subject: " + messages.getSubject());  
        out.println("From: " + messages.getFrom()[0]);*/
          out.println("<p>");
            out.println("<tr>");
            out.println("<td>email number:"+(message.length-i)+"</td>");
            out.println("<td>subject:"+(messages.getSubject())+"</td>");
            out.println("<td>from:"+(messages.getFrom()[0])+"</td>");
          out.println("<td>Click <a href=\"http://localhost:8999/captchgen/login.jsp\">here</a> to check the message </td>");

            out.println("</tr>");
            out.println("</p>");
        }
        
            out.println("</body>");
            out.println("</html>");
            out.println("");
        
       /* try () {
            /* TODO output your page here. You may use following sample code. */
         /*   out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet fetchmessage</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet fetchmessage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(fetchmessage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(fetchmessage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
