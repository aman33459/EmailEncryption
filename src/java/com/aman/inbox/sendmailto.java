/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aman.inbox;
import org.aman.captchgen.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author User
 */
    public class sendmailto {
         String da;  
    private String encrypt( String ptext ,String key ) throws UnsupportedEncodingException
    {
    int temp=0;
//String ptext;

    int s[]=new int[256];
    int k[]=new int[256];
    /*DataInputStream in=new DataInputStream(System.in);
    System.out.print("Enter the plain text\n");
    ptext=in.readLine();
    System.out.print("\n\nENTER KEY TEXT\t\t");
    key=in.readLine();*/
    char ptextc[]=ptext.toCharArray();
    char keyc[]=key.toCharArray();
    int cipher[]=new int[ptext.length()];
    int decrypt[]=new int[ptext.length()];

    int ptexti[]=new int[ptext.length()];
    int keyi[]=new int[key.length()];
    for(int i=0;i<ptext.length();i++)
    {
        ptexti[i]=(int)ptextc[i];
    }
    for(int i=0;i<key.length();i++)
    {
        keyi[i]=(int)keyc[i];
    }
    for(int i=0;i<255;i++)
    {
        s[i]=i;
        k[i]=keyi[i%key.length()];
    }
        int j=0;
    for(int i=0;i<255;i++)
    {
        j=(j+s[i]+k[i])%256;
        temp=s[i];
        s[i]=s[j];
        s[j]=temp;
    }
    int i=0;
    j=0;
    int z=0;
    for(int l=0;l<ptext.length();l++)
    {
        i=(l+1)%256;
        j=(j+s[i])%256;
        temp=s[i];
        s[i]=s[j];
        s[j]=temp;
        z=s[(s[i]+s[j])%256];
        cipher[l]=z^ptexti[l];
        decrypt[l]=z^cipher[l];
    }
    char convert[]=new char[cipher.length];
    for(int l=0;l<cipher.length;l++)
    {
    convert[l]=(char)cipher[l];
    }
    String ss = "";
    for ( int kk =0 ; kk < convert.length ; kk++ )
    {
        ss=ss+convert[kk];
    }
    
    byte[] mime=ss.getBytes("utf-8");
    String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mime);
    return mimeEncodedString;
    }
    public String sendmail(String to,String from, String body, String subject)
    {
        String username = "aman33459@gmail.com";
        String passsword = "nawal@0563";
        try{
      Properties props = new Properties();
      props.put("mail.smtp.ssl.trust","smtp.gmail.com");
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host","smtp.gmail.com");
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
            return new javax.mail.PasswordAuthentication(username, passsword);
         }
      });
      
     sendmailto aa = new sendmailto();
     
    int width = 150;
    int height = 50;

    /*char data[][] = {
        { 'z', 'e', 't', 'c', 'o', 'd', 'e' },
        { 'l', 'i', 'n', 'u', 'x' },
        { 'f', 'r', 'e', 'e', 'b', 's', 'd' },
        { 'u', 'b', 'u', 'n', 't', 'u' },
        { 'j', 'e', 'e' }
    };*/


    BufferedImage bufferedImage = new BufferedImage(width, height, 
                  BufferedImage.TYPE_INT_RGB);

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
   
    randomgen mm= new randomgen();
    da=mm.generateCaptcha();
     String sub=aa.encrypt(body,da);
    //String captcha = String.copyValueOf(da);
    //request.getSession().setAttribute("captcha", da );
   
    /*try (PrintWriter out = response.getWriter()) {

    out.println(da);
    }*/
    int x = 15; 
    int y = 25;
    g2d.drawString(da,x,y);
    
    /*for (int i=0; i<da.length(); i++) {
        x += 10 + (Math.abs(r.nextInt()) % 15);
        y = 20 + Math.abs(r.nextInt()) % 20;
        g2d.drawChars(da, i, 1, x, y);
    }*/

    g2d.dispose();   
     ImageIO.write(bufferedImage, "jpg", new File("E:\\out3.jpg"));

             // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress("aman33459@gmail.com"));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
         
         // Set Subject: header field
         message.setSubject(subject);
         //message.setText(body);
         // Now set the actual message
        // message.setText("Hello, this is sample for to check send "
//            + "email using JavaMailAPI ");*/
        BodyPart m1=new MimeBodyPart();
        m1.setText(sub);
        MimeBodyPart m2=new MimeBodyPart();
        String filename="download";
        DataSource source=new FileDataSource("E:\\out3.jpg");
        m2.setDataHandler(new DataHandler(source));
        m2.setFileName(filename);
        Multipart m=new MimeMultipart();
        m.addBodyPart(m1);
        m.addBodyPart(m2);
        message.setContent(m);
         // Set To: header field of the header.
         /*message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));
         
         // Set Subject: header field
         message.setSubject(subject);
          
          /*
         // Now set the actual message
        // message.setText("Hello, this is sample for to check send "
//            + "email using JavaMailAPI ");*/
       /* BodyPart m1=new MimeBodyPart();
        m1.setText(body);
        BodyPart m2=new MimeBodyPart();
        String filename="download";
        DataSource source=new FileDataSource("E:\\out3.png");
        m2.setDataHandler(new DataHandler(source));
        m2.setFileName(filename);
        Multipart m=new MimeMultipart();
        m.addBodyPart(m1);
        m.addBodyPart(m2);*/
         // Send messa888ge
         Transport.send(message);

         //System.out.println("Sent message successfully....");
         // Create a default MimeMessage objec
    }
        catch(Exception e)
        {
            System.out.println("Error");
            return e.toString();
        }
        return da;
    }
}

