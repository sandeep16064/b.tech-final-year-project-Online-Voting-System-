/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

 import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 *
 * @author SANDEEP KUMAR
 */
public class HitCounts extends HttpServlet {
   
    PrintWriter out;
    public void services(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        out=response.getWriter();
        ServletContext  ctx=getServletContext();
        Integer count=(Integer)ctx.getAttribute("count");
        if(count==null)
        {
            count=new Integer(0);
        }
        count=new Integer(count.intValue()+1);
        ctx.setAttribute("count",count);
        out.println(count.intValue());
        }
        
    }
            
