<%-- 
    Document   : register
    Created on : Feb 1, 2017, 8:36:23 PM
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
        <h1>Registrer dig her</h1>
       <form action="UserControl" method="POST">
            <input type="text" name="username" placeholder="username"/>
            <input type="password" name="password" placeholder="password"/>
            <input type="password" name="password2" placeholder="password igen" />
            <input type="hidden" name="origin" value="register">
            <input type="submit" value="submit">
        </form>
    </body>
</html>
