/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.AccountService;
import Beans.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Chris
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        if(logout!=null){
            session.invalidate();
            session = request.getSession();
            request.setAttribute("message", "Successfully logged out");
        } 
        
        if(session.getAttribute("username")!=null){
            response.sendRedirect("home");
        }
        else{
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);  
        
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession();
        
       String username = request.getParameter("user");
       String password = request.getParameter("password");
       AccountService check = new AccountService();
       
       
       if(username != null && username != ""){
           if(password != null && password != "") {
           User user = check.login(username, password);
                if(user!= null){
                    session.setAttribute("username", username);
                    response.sendRedirect("home");
                }
                else{
                    request.setAttribute("user",username);
                    request.setAttribute("password",password);
                    request.setAttribute("message", "Invalid Username or Password");
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
                }
           }
       }
       else{
          request.setAttribute("user",username);
          request.setAttribute("password",password);
          request.setAttribute("message", "Invalid Username or Password");
          getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
       }
       
        
    }
}


