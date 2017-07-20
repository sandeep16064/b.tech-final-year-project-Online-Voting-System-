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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SANDEEP KUMAR
 */
public class result55 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         HttpSession s;
     s = request.getSession();
    String uname=(String)s.getAttribute("uname");
    String pass1=(String)s.getAttribute("pass1");
       
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\"><style>\n" +
             "   table,th,td{border:2px solid blue;}\n" +
                   "</style>");
            out.println("<title>Submit vote</title><LINK rel=\"shortcut icon\" type=\"image/x-icon\" href=\"images/fevicon.ico\">");            
            out.println("</head>");
        if(uname!=null&&pass1!=null){
            /* TODO output your page here. You may use following sample code. */
           
            out.println("<center><body bgcolor=\"yellow\">");
            out.println("Servlet result55 at "+
                  " <form action=\"Vote\" method=\"post\"><table width=\"1000px\" bgcolor=\"#fbefd9\"><tr><th> --::PARTY NAME::--</th> "+
            "  <th> --::CHOOSE BUTTON::---</th><th>--::PARTY`s SYMBOLS::--</th></tr>");
            out.println("<tr><td><H1><b>AAM ADAMI PARTY  (AAP)</B></H1></td><td> <input type=\"radio\" class=\"big\" name=\"party\" value=\"party1\"> </td><td> <img src=\"images/aap.jpg\" alt=\"aap...\" height=\"100\" width=\"105\"> </td></tr>");
            out.println("<tr><td><h1><b>BHARTI JANTA PATRY  (BJP)</b></h1>  </td><td> <input type=\"radio\"  class=\"big\" name=\"party\" value=\"party2\"> </td> <td><IMG src=\"images/bjp.jpg\" alt=\"bjp...\" height=\"100\" width=\"105\"></td></tr>");
            out.println("<tr><td><h1><b>  BAHUJAN SAMAJWADI PARTY (BSP)</b></h1>  </td><td>  <input type=\"radio\" class=\"big\"  name=\"party\" value=\"party3\"> </td><td> <IMG src=\"images/bsp.png\" alt=\"ff\" height=\"100\" width=\"105\"> </td></tr>");
            out.println("<tr><td> <h1><b> CONGRESS PATRY  (  ) </b></h1> </td><td> <input type=\"radio\"  class=\"big\" name=\"party\" value=\"party4\"> </td><td> <IMG src=\"images/congress.jpg\" alt=\"d\" height=\"100\" width=\"105\"> </td></tr>");
            out.println("<tr><td>    </td><td>  <input type=\"radio\"  class=\"big\" name=\"party\" value=\"party5\"></td><td> <IMG src=\"images/cpi.png\" alt=\"f\" height=\"100\" width=\"105\"> </td></tr>");
            out.println("<tr><td>    </td><td>  </td></tr>");
            out.println("<tr><td>   </td><td> <input type=\"radio\"  class=\"big\" name=\"party\" value=\"party6\"> </td><td> <IMG src=\"images/jdu.jpg\" alt=\"v\" height=\"100\" width=\"105\"> </td></tr>");
            out.println("<tr><td> <h1><b> SAMAJWADI PARTY (SP)</b></h1>   </td><td> <input type=\"radio\"  class=\"big\" name=\"party\" value=\"party8\"> </td><td>  <IMG src=\"images/sp.gif\" height=\"100\" width=\"105\"></td></tr>");
            out.println("<tr><td>    </td><td> <input type=\"radio\" class=\"big\"  name=\"party\" value=\"party9\"> </td><td> <IMG src=\"\" height=\"100\" width=\"105\"> </td></tr>");
            out.println("<tr><td>    </td><td>  </td><td>  </td></tr>");
            out.println("<tr><td>    </td><td>  </td><td>  </td></tr>");
            out.println("<tr><td>    </td><td>  </td><td>  </td></tr></table>");
            out.println("<input type=\"submit\" value=\"submit\" onsubmit=\"check()\" >");
           out.println("  <input type=\"reset\" value=\"reset\">");
            out.println("</form>");
            out.println("<table width=\"1000px\" height=\"200px\" bgcolor=\"#fbefd9\">");
            
            out.println("<tr><td><p>Declaimers:............................................</td></p></tr></table></body></center>");
            out.println("</html>");
       
       }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("common.html");
            rd.include(request, response);
            out.println("<center><body><table cellpadding=\"200\" cellspacing=\"90\" width=\"897px\" height=\"200px\" bgcolor=\"#fbefd9\">");
            
            out.println("<tr><td><p>your login timeout or you had logout.<br>so please login first for votting thanq..<br><a href=\"login.html\">goto login</a></p></td></tr></table></body></center>");
            
            out.println("</html>");
        }
    }

}
