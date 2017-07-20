/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SANDEEP KUMAR
 */
public class Logout extends HttpServlet {

 @Override
 public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    PrintWriter out=response.getWriter();
    HttpSession s;
     s = request.getSession();
    String s1=(String)s.getAttribute("uname");
    if(s!=null){
        s.invalidate();
        Cookie ck=new Cookie("uname","");
        ck=new Cookie("pass1","");
        ck.setMaxAge(0);
        response.addCookie(ck);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n"
                    + "<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("<title>User Logout</title>");            
            out.println("</head>");
            out.println("<body>");
         out.println("<div id=\"top_links\">\n" +
"<div id=\"header\"><marquee  behavior=\"scroll\" scrollamount=\"3\"  onmouseover=\"this.stop();\" onmouseout=\"this.start();\"><img src=\"images/flag.gif\" alt=\"business\" width=\"70\" height=\"50\">"
	+" </marquee>" +
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
"</div><table style=\"width:897px; background:#FFFFFF; margin:0 auto;\"><tr><td>");
         if(s1==null){
              out.println("<br><br><center><h2>You have already logout successfully..</h2><br>");
            out.println("<h2><a href=\"voter_login.html\">Login</a></center></h2>");
         }else{
            out.println("<br><br><center><h1>"+s1+" </h1><h3>You have logout successfully</h3><br>");
            out.println("<h2><a href=\"login.html\">Login</a></h2></center>");
         }
            
            out.println("</td></tr></table></div></body>");
            out.println("</html>");
        }
    else
        out.println("Hey!!... user must login first ");
    }
}