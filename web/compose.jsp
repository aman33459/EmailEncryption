<%-- 
    Document   : compose
    Created on : Aug 8, 2016, 12:09:46 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compose Email</title>
    </head>
    <body>
        <h1>Welcome to Aman mail</h1>
    </body><form name="sending mail" action="sendmail" method="POST">
        <table border="0">
            <tbody>
                <tr>
                    <td>To:</td>
                    <td><input type="text" name="To" value="" size="50" /></td>
                </tr>
                <tr>
                    <td>From:</td>
                    <td><input type="text" name="from" value="" size="50" /></td>
                </tr>
                <tr>
                    <td>Subject:</td>
                    <td><input type="text" name="subject" value="" size="50" /></td>
                </tr>
                <tr>
                    <td>Compose:</td>
                    <td><textarea name="body" rows="10" cols="50" size="50">
                        </textarea></td>
                </tr>
                 <tr>
                     <td><input type="file" name="attach" value="attach" width="50" /></td>
                     <td> </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="send mail" name="send mail" /></td>
                </tr>
            </tbody>
        </table>

    </form>
</html>

