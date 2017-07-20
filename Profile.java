/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SANDEEP KUMAR
 */
public class Profile extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = null,pass = null;
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
         Cookie ck1[]=request.getCookies();
        if(ck1!=null)
        {
       name =ck1[0].getValue();
       pass=ck1[1].getValue();
     //   String pass=ck1[1].getValue();
          out.println(name+"  ");
          out.println(pass);
          out.println("cheking"); 
      
          if(Validate.checkUser(name,pass))
        {
        out.println("true");
        
          RequestDispatcher rs = request.getRequestDispatcher("Welcome");
           // rs1.forward(request, response);
            rs.include(request, response);
            
        
        }
          else{
          out.println("false");
    }
    }
}
    }
}
