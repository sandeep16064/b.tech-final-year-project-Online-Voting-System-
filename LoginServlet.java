import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
    //    String uname = request.getParameter("uname");
     //   String pass1 = request.getParameter("pass1");
        
        HttpSession s;
     s = request.getSession();
    String uname=(String)s.getAttribute("uname");
    String pass1=(String)s.getAttribute("pass1");
    
    
     HttpSession se=request.getSession();
     se.setAttribute("uname", uname);
     se.setAttribute("pass1", pass1);
        
     //   if(Validate.checkUser(uname,pass1))
    //    {
           out.println("<html>\n" +
"<head>\n" +
"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
"<title>Online Voting System...</title>\n" +
"<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
" <script language=\"JavaScript\">function otp(){ prompt(\"Please Enter OTP:\n\",\"otp\"); \n alert(\"otp\");}</script></head>\n" +
"<body onload=\"javascript:otp();\">\n" +
"<div id=\"top_links\">\n" +
"<div id=\"header\"><marquee  behavior=\"scroll\" scrollamount=\"3\"  onmouseover=\"this.stop();\" onmouseout=\"this.start();\"><img src=\"images/flag.gif\" alt=\"business\" width=\"70\" height=\"50\">"
	+" </marquee>" +
"</div>\n" +
"\n" +
"<div id=\"navigation\">\n" +
"    <ul>\n" +
"    <li><a href=\"#\">HOME</a></li>\n" +
"    <li><a href=\"#\"><font color=\"white\">PROFILE</font></a></li>	\n" +
"	<li><a href=\"#\">NEW VOTER</a></li>\n" +
"	<li><a href=\"#\">APPLY</a></li>\n" +
"	<li><a href=\"#\">RESULTS</a></li>\n" +
"    <li><a href=\"#\">FAQ</a></li>\n" +
"    <li><a href=\"#\">HELP</a></li>\n" +
"    </ul>\n" +
"</div>\n");//+
//"</div>\n" +
//"</body>\n" +
//"</html>");

 Cookie ck=new Cookie("uname",uname);
 ck=new Cookie("pass1",pass1);
 response.addCookie(ck);
 
  // out.println("<form>\n<input type=\"number\" name=\"otp\">\n<input type=\"submit\" value=\"varify\">\n</form>");
    //  String otp=request.getParameter("otp");
 
 //out.println("document.write(\"sandeep\")");
            //RequestDispatcher rs1 = request.getRequestDispatcher("a2.html");
            RequestDispatcher rs = request.getRequestDispatcher("Welcome");
          // rs.forward(request, response);
           rs.include(request, response);
            
        }
  //      else
   //     {
            //  out.println("sandeep error");
         //  out.println("<p align=\"center\"> username or password incorrect....</p><br>");
 //          RequestDispatcher rs = request.getRequestDispatcher("incorrect_login.html");
         //  out.println(" <center>Username or Password incorrect</center>");
 //          rs.forward(request, response);
 //       }
 //   }  

}
