/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SANDEEP KUMAR
 */
public class PrintReceipt extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>PrintReceipt</title>");            
            out.println("</head>");
            out.println("<body>");
       //     out.println("<h1>Servlet PrintReceipt at " + request.getContextPath() + "</h1>");
       //     out.println("<form action=\"PrintReceipt\" method=\"POST\"><input type=\"submit\" value=\"print receipt\" onSubmit=\"alert(\"really want to print\");></form></body>");
            out.println("</html>");
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
        processRequest(request, response);
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
       // processRequest(request, response);
       
       
       
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
       //     out.println("<body onload=\"window.print()\">");
       
        HttpSession session=request.getSession();
        String name1,pass1;
        int v = 0;
        name1 = (String)session.getAttribute("uname");
        pass1 = (String)session.getAttribute("pass1");
        
       
       
          try{
   // out.println("ABCD1<br>");
	 //loading drivers for mysql
         Class.forName("oracle.jdbc.driver.OracleDriver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
       //  out.println("ABCD2<br>");
         Statement stmt,stmt1;
            stmt = con.createStatement();
         String s1=name1+"' ";
         String s2="and ";
         String s3="pass='"+pass1+"'";
         String s4=s1+s2+s3;
         String s5="select email,name,fname,voter_id,aadhar_no,dob,image,gender,username,mobile_no from user12 where username='";
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
        String email=rs.getString("email");
            String username = rs.getString("username");
            String name = rs.getString("name");
            String  fname= rs.getString("fname");
            String gender = rs.getString("gender");
            String vot= rs.getString("voter_id");
            String aad = rs.getString("aadhar_no");
            String mob = rs.getString("mobile_no");
            String dob = rs.getString("dob");
            Blob b=rs.getBlob(7);
byte barr[]=new byte[(int)b.length()];//an array is created but contains no data
//barr=b.getBytes(1,(int)b.length());
barr=b.getBytes(1,(int)b.length());
             try (FileOutputStream fout = new FileOutputStream("C:\\Users\\SANDEEP KUMAR\\Documents\\NetBeansProjects\\Online Voting System\\web\\image\\"+username+".png")) {
                 fout.write(barr);
                 //   out.println(""+rs.getBlob("filename")+"");
             }
     
     
     
     
     out.println(" <center><img src=\"image/"+username+".png\" alt="+username+" width=\"196\" height=\"106\"><br>\n");
 
          
            out.println("<table style=\"background:#ffffff;\"><h2><tr><td> Username :   </td><td>  " + username + " </td></tr>");
         //   out.println("<tr><td>Total Profile Hits::    </td><td> "+count.intValue()+"</td></tr>");
            out.println("<tr><td>Email ID:   </td><td>" + email + "</td></tr>");
            out.println("<tr><td>name:   </td><td>" + name + "</td></tr>");  
            out.println("<tr><td>Father Name:  </td><td>" + fname+ "</td></tr>");
            out.println("<tr><td>Voter_ID:  </td><td>" +vot+ "</td></tr>");
            out.println("<tr><td>Aadhar No :  </td><td>" + aad+ "</td></tr>");
            out.println("<tr><td>Gender:  </td><td>" + gender+ "</td></tr>");
            out.println("<tr><td>Mobile No.:  </td><td>" + mob+ "</td></tr>");
            out.println("<tr><td>DOB:  </td><td>" + dob+ "</td></tr></h2></table>"); 
            out.println("Your vote done successfully..<br>thank you for give your time<br>for your right.</center>");
       }
      }catch(Exception e)
      {
          e.printStackTrace();
          out.println(e+" error...............");
      }
       
       
            out.println("<center><table width=\"1000\" height=\"2000\" ><p><button onClick=\"window.print()\">printer</button></p></table></center></body>");
    }
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
