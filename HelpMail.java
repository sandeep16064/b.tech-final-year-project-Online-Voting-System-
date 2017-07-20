/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SANDEEP KUMAR
 */
public class HelpMail extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String to = request.getParameter("to");
            String sub = request.getParameter("subject");
            String msg = request.getParameter("message");
            String user = request.getParameter("userEmail");
            String pass = request.getParameter("userPass");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Helping Mail</title>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
"<LINK rel=\"shortcut icon\" type=\"image/x-icon\" href=\"images/fevicon.ico\">\n" +
"<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">");            
            out.println("</head>");
            out.println("<body>");
           out.println("<div id=\"top_links\">\n" +
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
            SendMail.send(to, sub, msg, user, pass);
            out.println("<br><br><center>your request send successfully...</center>");
            out.println("</td></tr></table></div></body>");
            out.println("</html>");
        }
    }
    }