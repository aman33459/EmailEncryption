<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Captcha</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
    
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
<img src=<%="http://localhost:8999/captchgen/SimpleCaptchaServlet?value="+val %> >

<br><br>
<input type="submit" value="submit">

</form>
<br><br>
</center>
</body>
</html>
