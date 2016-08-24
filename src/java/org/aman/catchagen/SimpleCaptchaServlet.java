/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aman.catchagen;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStream;

import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.aman.captchgen.randomgen;
import com.aman.inbox.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author User
 */
@WebServlet(name = "SimpleCaptchaServlet", urlPatterns = {"/SimpleCaptchaServlet"})
public class SimpleCaptchaServlet extends HttpServlet {


  protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response) 
                 throws ServletException, IOException, MessagingException {

    /*int width = 150;
    int height = 50;
      
    /*char data[][] = {
        { 'z', 'e', 't', 'c', 'o', 'd', 'e' },
        { 'l', 'i', 'n', 'u', 'x' },
        { 'f', 'r', 'e', 'e', 'b', 's', 'd' },
        { 'u', 'b', 'u', 'n', 't', 'u' },
        { 'j', 'e', 'e' }
    };*/
/**/
    String val=request.getParameter("value");
    int k=Integer.parseInt(val);
    inbox aa=new inbox();
   String filepa=aa.recieveEmail("************","***********",k);
   /*PrintWriter out = response.getWriter();
   out.println(filepa);*/
    BufferedImage img = null;
    img=ImageIO.read(new File(filepa));
    /*try (PrintWriter out = response.getWriter()) {
      out.println(filepa);
     }*/
    /*
    Graphics2D g2d = bufferedImage.createGraphics();

    Font font = new Font("Georgia", Font.BOLD, 18);
    g2d.setFont(font);

    RenderingHints rh = new RenderingHints(
           RenderingHints.KEY_ANTIALIASING,
           RenderingHints.VALUE_ANTIALIAS_ON);

    rh.put(RenderingHints.KEY_RENDERING, 
           RenderingHints.VALUE_RENDER_QUALITY);

    g2d.setRenderingHints(rh);

    GradientPaint gp = new GradientPaint(0, 0, 
    Color.red, 0, height/2, Color.black, true);

    g2d.setPaint(gp);
    g2d.fillRect(0, 0, width, height);

    g2d.setColor(new Color(255, 153, 0));

   /* Random r = new Random();
    int index = Math.abs(r.nextInt()) % 5;*/
  /*  String da;  
    randomgen mm= new randomgen();
    da=mm.generateCaptcha();

    //String captcha = String.copyValueOf(da);
    request.getSession().setAttribute("captcha", da );
   
    /*try (PrintWriter out = response.getWriter()) {

    out.println(da);
    }*/
    /*int x = 15; 
    int y = 25;
    g2d.drawString(da,x,y);
    
    /*for (int i=0; i<da.length(); i++) {
        x += 10 + (Math.abs(r.nextInt()) % 15);
        y = 20 + Math.abs(r.nextInt()) % 20;
        g2d.drawChars(da, i, 1, x, y);
    }*/

    //g2d.dispose();

   
    //request.getRequestDispatcher("http://localhost:8999/mailproject/submitinf.jsp").forward(request,response);
     response.setContentType("image/png");
    OutputStream os = response.getOutputStream();
    ImageIO.write(img, "png", os);
    os.close();
  } 


  protected void doGet(HttpServletRequest request, 
                       HttpServletResponse response)
                           throws ServletException, IOException {
      try {
          processRequest(request, response);
      } catch (MessagingException ex) {
          Logger.getLogger(SimpleCaptchaServlet.class.getName()).log(Level.SEVERE, null, ex);
      }
  } 


  protected void doPost(HttpServletRequest request, 
                        HttpServletResponse response)
                            throws ServletException, IOException {
      try {
          processRequest(request, response);
      } catch (MessagingException ex) {
          Logger.getLogger(SimpleCaptchaServlet.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
}/*
<%
  String captcha = (String) session.getAttribute("captcha");
  String code = (String) request.getParameter("code");

  if (captcha != null && code != null) {
      out.print(captcha +" " + code );
    if (captcha.equals(code)) {
	  out.print("<p class='alert'>Correct</p>");
    } else {
          out.print("<p class='alert'>Incorrect</p>");
    }
  }
%>*/
