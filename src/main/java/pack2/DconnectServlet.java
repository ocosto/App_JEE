package pack2;

import java.io.IOException; 

import jakarta.servlet.http.HttpServlet; 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import pack1.User;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet(name = "DconnectServlet", urlPatterns = {"/logout"})
@WebServlet("/DconnectServlet")
public class DconnectServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        //request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
