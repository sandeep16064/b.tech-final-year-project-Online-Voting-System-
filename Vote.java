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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SANDEEP KUMAR
 */
public class Vote extends HttpServlet {

 
    
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");
   
        String party = request.getParameter("party");
        HttpSession session=request.getSession();
        String name1,pass1;
        int v = 0;
        name1 = (String)session.getAttribute("uname");
        pass1 = (String)session.getAttribute("pass1");
        
        String select=request.getParameter("party");
       // String s1="count+1";
        int s2;
       // s2 = Integer.parseInt(s1);
       out.println("<html>\n" +
"<head>\n" +
"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
"<title>Online Voting System...</title> <LINK rel=\"shortcut icon\" type=\"image/x-icon\" href=\"images/fevicon.ico\">\n" +
"<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
"</head>\n" +
"<body>\n" +
"<div id=\"top_links\">\n" +
"<div id=\"header\">\n" +
"    <marquee  behavior=\"scroll\" scrollamount=\"3\"  onmouseover=\"this.stop();\" onmouseout=\"this.start();\"><img src=\"images/flag.gif\" alt=\"business\" width=\"70\" height=\"50\">\n" +
"	 </marquee>\n" +
"</div>\n" +
"\n" +
"<div id=\"navigation\">\n" +
"    <ul>\n" +
"    <li><a href=\"index.html\">HOME</a></li>\n" +
"    <li><a href=\"login.html\">LOGIN</a></li>	\n" +
"	<li><a href=\"new_voter.html\">NEW VOTER</a></li>\n" +
"	<li><a href=\"apply.html\">APPLY</a></li>\n" +
"	<li><a href=\"result.html\">RESULTS</a></li>\n" +
"    <li><a href=\"faq.html\">FAQ</a></li>\n" +
"    <li><a href=\"help.html\">HELP</a></li>\n" +
"    </ul>\n" +
"</div><table width=\"897px\" height=\"200px\" bgcolor=\"#fbefd9\"><tr><td>");
        try{
        
        //loading drivers for mysql
        Class.forName("oracle.jdbc.driver.OracleDriver");
 
	//creating connection with the database 
          Connection  con=DriverManager.getConnection
                     ("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
        Statement stmt =con.createStatement();
        PreparedStatement ps,ps1;
        String s5="select status from vote where username='"+name1+"' and password='"+pass1+"'";
         ResultSet rs =stmt.executeQuery(s5);
        
         while(rs.next()){
     HttpSession se=request.getSession();
  
        v=rs.getInt("status");
         }
         String s6="update vote set status=1 where username='"+name1+"' and password='"+pass1+"'";
         ps1 = con.prepareStatement(s6);
            int auto= ps1.executeUpdate();
        // out.println(s5+"  "+s6+"  " +v+" "+auto);
        if(select==null){
             out.println("<br> Hey "+name1+" you are not select any redio button option before submit.<br>go back and try again..");
          
        }else{
         if(v==0){
       
       // ps1=con.prepareStatement("");
        
            ps = con.prepareStatement("update votes set count=count+1 where party_name=?");
                
      
      // ps.setInt(1, 88);
         
        ps.setString(1, party);
        int i=ps.executeUpdate();
        if(i>0)
          {
            out.println(" <center>Your vote( "+name1+") have done sucessfully <br>your timeout...<br></center>");
               // out.println("<a href=\"login.html\">click here for login..</a>");
           // RequestDispatcher rs = request.getRequestDispatcher("login.html");
          }
          else
          {
            //  out.println("<br> Hey "+name1+" you are not select any redio button option before submit.<br>go back and try again..");
          }
         }
         else{out.println("<center>"+name1+" <b>your vote already done!..</b><br><br></center>");
         }
         
         out.println("<form action=\"PrintReceipt\" method=\"POST\">"+name1+" want to print voting receipt..<input type=\"submit\" value=\"print receipt\"></form>");
         
        }
        }
        catch(Exception se)
        {
            se.printStackTrace();
            out.println(" shi se kr lO..ERRROOR....");
        }
        
       out.println("</center></td></tr></table></div></body></html>");
    }
}
