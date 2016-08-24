<%-- 
    Document   : getcontent
    Created on : Aug 4, 2016, 8:12:03 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%int val=Integer.parseInt(request.getParameter("value"));%>
        <%@page import="com.aman.inbox.content" %>
        <%String key= request.getParameter("code"); %>
        <%content aa = new content();
        out.print(aa.recieveEmail("aman33459@gmail.com","nawal@0563",val,key));
        //out.print();
        %>
        <p>click <a href="enter.jsp">here</a>to go back </p>
    </body>
</html>
