/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SANDEEP KUMAR
 */
public class OtpTrue extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
             HttpSession s;
     s = request.getSession();
    String uname=(String)s.getAttribute("uname");
    String pass1=(String)s.getAttribute("pass1");
    
     HttpSession se=request.getSession();
     se.setAttribute("uname", uname);
     se.setAttribute("pass1", pass1);
    
     String  email,mobileNo;
     int otppin = 0,otppin1 = 0;
   // out.println(uname+""+pass1);
             int otp=Integer.parseInt(request.getParameter("otp"));
             //  out.println(otp+1);
             try{
   // out.println("ABCD1<br>");
	 //loading drivers for mysql
         Class.forName("oracle.jdbc.driver.OracleDriver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
       //  out.println("ABCD2<br>");
       PreparedStatement ps;
         Statement stmt,stmt1;
            stmt = con.createStatement();
           
         String s1=uname+"' ";
         String s2="and ";
         String s3="password='"+pass1+"'";
         String s4=s1+s2+s3;
         String s5="select email,mobile,otppin from otp where username='";
              //  String    sql="select email,pass,max(age) from user12 where email=? and pass=?";
              String sql=s5+s4;
 
         ResultSet rs =stmt.executeQuery(sql);
        // resultSet rs1=stmt1.executeQuery("select")
        // st = rs.next();
      //  int id  = rs.get("email");
       while(rs.next()){
     // out.println("ABCD4<br>");
     
        //  int age = rs.getInt("age"); 
        //  out.println("ABCD5<br>");
       email=rs.getString("email");
            mobileNo = rs.getString("mobile");
        otppin=rs.getInt("otppin");
       // otppin1=Integer.parseInt("otppin");
      // out.println("<br>"+otppin+1);
       
       // stmt.executeUpdate("commit;"); 
       }
  //      ps=con.prepareStatement("delete from otp where username='"+uname+"'");
  //     int i=ps.executeUpdate();
       
  //    if(i!=0)out.println("deleted..");
 //     else if(i==0)out.println("alredy deleted");
       
       
      
             
             
           // if(otp==otppin)
                if(otppin==otp)
                {
                     RequestDispatcher rs2 = request.getRequestDispatcher("LoginServlet");
                    rs2.include(request, response);
                }
            else
                {
                     RequestDispatcher rs1 = request.getRequestDispatcher("getotperror.html");
                    rs1.forward(request, response);
                  
                }
            con.close();
                }catch(Exception e)
      {
          e.printStackTrace();
          out.println(e+" error...............");
      }  
            /* TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OtpTrue</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("</body>");
            out.println("</html>"); */
        }
    }

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
      //  processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
