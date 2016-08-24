<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Captcha</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
     <%@page import=" org.aman.catchagen.SimpleCaptchaServlet " %>

<% String val=request.getParameter("value");
    %>
<center>
<form action=<%="getcontent.jsp?value="+val%> method="post">
<table cellspacing="15">
    
<tr>
<td>Are you human?</td>
<td><input type="text" name="code"></td>
</tr>

</table>
<br>
<img src=<%="SimpleCaptchaServlet?value="+val %> >

<br><br>
<input type="submit" value="submit">

</form>
<br><br>
</center>
</body>
</html>
