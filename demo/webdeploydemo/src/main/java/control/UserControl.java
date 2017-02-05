package control;

import db.UserMapper;
import entity.User;
import exceptions.ToLogException;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Feb 1, 2017
 */
@WebServlet(name="UserControl", urlPatterns={"/UserControl", "/index.html"})
public class UserControl extends HttpServlet {
   UserMapper um = new UserMapper();
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       try {
        Object us = request.getSession().getAttribute("username");
        String origin = request.getParameter("origin");
        
        if(us == null)
            request.getRequestDispatcher("login.jsp").forward(request, response);
        
        if(origin != null && origin.equals("register")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String password2 = request.getParameter("password2");
            if(password.equals(password2)){
                um.addUser(username, password);
                request.getSession().setAttribute("username", username);
                
            }else{
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
        if(origin != null && origin.equals("delete")){
            um.deleteUsers();
        }
           List<User> users = um.getUsers();
           request.getSession().setAttribute("userlist", users);
           request.getRequestDispatcher("users.jsp").forward(request, response);
        
        
        
       } catch (ToLogException ex) {
           ex.printStackTrace();
       }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
