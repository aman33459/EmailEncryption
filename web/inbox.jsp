<%-- 
    Document   : inbox
    Created on : Aug 6, 2016, 10:15:03 PM
    Author     : User
--%>

<%@page import="javax.mail.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aman inbox</title>
    </head>
    <body>
    <h>click here to see the inbox</h>
    <%@page import="com.aman.inbox.getinbox" %>
    <% Message[] message;
        getinbox aa = new getinbox();
        message=aa.receive("*********", "**********");
        
            out.println("<html>");
              out.println("<body>");
        for (int i = message.length-1; i >= message.length-5; i--) {  
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
          out.println("<td>Click <a href=\"login.jsp?value="+i+"\">here</a> to check the message </td>");

            out.println("</tr>");
            out.println("</p>");
        }
        
            out.println("</body>");
            out.println("</html>");
            out.println("");
        %>
    </body>
</html>
