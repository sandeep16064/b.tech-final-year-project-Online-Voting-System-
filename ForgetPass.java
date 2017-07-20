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
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SANDEEP KUMAR
 */
public class ForgetPass extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
              response.setContentType("text/html;charset=UTF-8");
              
              String to=request.getParameter("email");
            String sub="? no reply Recovery password";
           
            String user="online.voting.system2017";
            String pass="8744881190g";
            
             String pass1 = null,username = null,name = null;
   // out.println("ABCD1<br>");
try{	
   //loading drivers for mysql
         Class.forName("oracle.jdbc.driver.OracleDriver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
       //  out.println("ABCD2<br>");
         Statement stmt;
            stmt = con.createStatement();
            
             String s5="select name,pass,username from user12 where email='"+to+"'";
              //  String    sql="select email,pass,max(age) from user12 where email=? and pass=?";
          
 
         ResultSet rs =stmt.executeQuery(s5);
        // resultSet rs1=stmt1.executeQuery("select")
        // st = rs.next();
      //  int id  = rs.get("email");
      
       while(rs.next()){
     // String email=rs.getString("email");
             username = rs.getString("username");
             name = rs.getString("name");
             pass1=rs.getString("pass");
            
              }
      
      String msg="Dear "+name+"\n Your recovery password ::\nUsername: "+username+"\nPassword : "+pass1+"\n\n© Voting managment";
    out.println("<html>\n" +
"<head>\n" +
"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
"<title>Online Voting System...</title>\n" +
"<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
"</head>\n" +
"<body>\n" +
"<div id=\"top_links\">\n" +
"<div id=\"header\"><marquee  behavior=\"scroll\" scrollamount=\"3\"  onmouseover=\"this.stop();\" onmouseout=\"this.start();\"><img src=\"images/flag.gif\" alt=\"business\" width=\"70\" height=\"50\">"
	+" </marquee></div>\n" +
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
"</div><br><br>");
      if(username==null&&pass1==null){
     out.println("<center><font color=\"white\">sorry this Email ID:"+to+"<br>does not exist is the Database<br>"
             + "<a href=\"new_voter.html\">click here to register first</a></font></center>");
     }else{
     SendMail.send(to, sub, msg, user, pass);
        out.println("<center><font color=\"white\">"
                    + "<br>Successfully password recovered check your email..<br>"
                + "<a href=\"voter_login.html\">click here login..</a> </font></center>");
     }
  //   out.println(" <center><img src=\"image/"+username+".png\" alt="+username+" width=\"196\" height=\"106\"></center><br>\n");
   out.println("</div></body></html>");
      }catch(Exception e)
      {
          e.printStackTrace();
          out.println(e+" error...............");
      }
        }
    }
         
       
    