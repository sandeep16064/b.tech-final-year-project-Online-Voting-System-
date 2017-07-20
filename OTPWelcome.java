/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com;

import com.SendMail;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
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
public class OTPWelcome extends HttpServlet {

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
            boolean flag=false;
            String uname = request.getParameter("uname");
        String pass1 = request.getParameter("pass1");
        
         String email = null, mobileNo = null;
         int m;
         String otp1 =null;
         
          String user ="online.voting.system2017@gmail.com";
        String pass ="8744881190g";
        
         try 
          {
        URL url = new URL("http://www.sandeepcollectionhere.netne.net.com");
 
        URLConnection connection = url.openConnection();
        connection.connect();   
        
      // SendMail.send(email,subject, message, user, pass);
        out.println("Internet Connected");   
            
       }catch (Exception e){
              flag=true;
              out.println("Sorry, No Internet Connection");     
                                                            
           } 
        
         
          String SALTCHARS ="1234567890";
StringBuilder salt =new StringBuilder();
Random rnd =new Random();
while(salt.length()<6)
{
int index =(int)(rnd.nextFloat()* SALTCHARS.length());  
          salt.append(SALTCHARS.charAt(index));
		  }
		  
		  otp1 = salt.toString();
         int otp2=Integer.parseInt(otp1);
         
        
        HttpSession se=request.getSession();
     se.setAttribute("uname", uname);
     se.setAttribute("pass1", pass1);
    //   out.println("OTPWelcome"); 
          if(!flag)
            {
        if(Validate.checkUser(uname,pass1))
        {
            
            
            
          
             try{
   // out.println("ABCD1<br>");
	 //loading drivers for mysql
         Class.forName("oracle.jdbc.driver.OracleDriver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
       //  out.println("ABCD2<br>");
       PreparedStatement ps;
         Statement stmt;
            stmt = con.createStatement();
         String s1=uname+"' ";
         String s2="and ";
         String s3="pass='"+pass1+"'";
         String s4=s1+s2+s3;
         String s5="select email,mobile_no from user12 where username='";
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
            mobileNo = rs.getString("mobile_no");
       //      m=Integer.parseInt(mobileNo);
         //   out.println(m+5);
         //   String name = rs.getString("name");
           // String  fname= rs.getString("fname");
            
              }
         ps = con.prepareStatement("update otp set otppin="+otp2+" where username=?");
                
      
      // ps.setInt(1, 88);
         
        ps.setString(1, uname);
        int i=ps.executeUpdate();
       
//        PreparedStatement ps1=con.prepareStatement("insert into otp values(?,?,?,?,?)");
  //      ps1.setString(1, uname);
    //    ps1.setString(2, pass1);
    //     ps1.setString(3, email);
     //   ps1.setString(4, mobileNo);
     //   ps1.setInt(5,otp2);
     //   m=ps1.executeUpdate();
        
         String subject = "? no-reply ONE TIME PASSWORD FOR LOGIN IN Online Voting System";
        String message = "Welcome  user..\nyou are successfully register in Online Voting System\nUsername:"+uname+"\nOTP::"+otp2+"\n\n thanks you..\n\n©project_work ";
            
       

       
       SendMail.send(email,subject, message, user, pass);
        con.close();
      }catch(Exception e)
      {
          e.printStackTrace();
          out.println(e+" error...............");
      }
            
            RequestDispatcher rs = request.getRequestDispatcher("getotp.html");
           rs.include(request, response);
        }
            else
            {
                  RequestDispatcher rs = request.getRequestDispatcher("incorrect_login.html");
           rs.forward(request, response);
            }
        }
     else
          {
          
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> OTPWelcome</title>");            
            out.println("</head>");
           out.println("<body> no intenet");
            
        
            out.println("</body>");
            out.println("</html>");
        }
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
       // processRequest(request, response);
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
