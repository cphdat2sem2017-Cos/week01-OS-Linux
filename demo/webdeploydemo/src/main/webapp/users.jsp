<%-- 
    Document   : users
    Created on : Feb 1, 2017, 7:08:58 PM
    Author     : Thomas Hartmann - tha@cphbusiness.dk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, entity.User"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> User list </h1>
        <ul>
            
        <% if(request.getSession().getAttribute("userlist") == null){
            response.sendRedirect("UserControl");
          }
            List<User> users = (List<User>)request.getSession().getAttribute("userlist");
        for(User user : users){
            out.println("<li>"+user.getUsername()+"</li>");
        }
        %>
        <a href="UserControl?origin=delete">Delete all users</a><br>
        <a href="register.jsp">Register a new user</a>
        </ul>
    </body>
</html>
