<%-- 
    Document   : login
    Created on : Feb 1, 2017, 7:13:27 PM
    Author     : Thomas Hartmann - tha@cphbusiness.dk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login here</h1>
        <form action="UserControl" method="POST">
            <input type="text" name="username" /><br>
            <input type="password" name="password" /><br>
            <input type="submit" value="submit">
        </form>
    </body>
</html>
