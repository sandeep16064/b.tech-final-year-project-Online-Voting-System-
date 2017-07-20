

import com.SendMail;
import java.io.*;
//import java.io.FileInputStream;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Random;


public class RegisterServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
         
        String to = request.getParameter("email");
       
        String user ="online.voting.system2017@gmail.com";
        String pass ="8744881190g";
     //   SendMail.getSaltString();
       
      
        
        String uname = request.getParameter("uname");
    
       // String pass = request.getParameter("pass");
        String SALTCHARS ="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
StringBuilder salt =new StringBuilder();
Random rnd =new Random();
while(salt.length()<10)
{
int index =(int)(rnd.nextFloat()* SALTCHARS.length());  
          salt.append(SALTCHARS.charAt(index));
		  }
		  
		  String pass1 = salt.toString();
        
       
         //    String rpass = request.getParameter("rpass");
        String name = request.getParameter("name");
          String fname = request.getParameter("fname");
          String gender=request.getParameter("gender");
            String dob = request.getParameter("dob");
              String voter_id = request.getParameter("voter_id");
                String aadhar = request.getParameter("aadhar");
          String mob1=request.getParameter("mob");
        //  long mob=Integer.parseInt(mob1);
                  String city = request.getParameter("city");
                String fl = request.getParameter("filename");
                
                
                 String subject = "? no-reply SUCCESSFULL REGISTER IN Online Voting System";
        String message = "Welcome  "+name+"\nyou are successfully register in Online Voting System\nUsername:"+uname+"\nPassword:"+pass1+"\n\n thanks you..\n\n©project_work ";
                 SendMail.send(to,subject, message, user, pass);
            //     FileInputStream fin=new FileInpurStream("F:\\image\\diwali pics\\2016-10-30 14.53.30.jpg ");
        try{
        
        //loading drivers for mysql
        Class.forName("oracle.jdbc.driver.OracleDriver");

	//creating connection with the database 
          Connection  con=DriverManager.getConnection
                     ("jdbc:oracle:thin:@localhost:1521:xe","system","admin");

          PreparedStatement ps2=con.prepareStatement("insert into otp values(?,?,?,?,?)");
          PreparedStatement ps1=con.prepareStatement("insert into vote values(?,?,?)");
        PreparedStatement ps=con.prepareStatement
                  ("insert into user12 values(?,?,?,?,?,?,?,?,?,?,?,?,?)");

//insert into user12 values('sandeep','sandeep','sandeep','fa' ,'90' ,'3' ,'33' ,'3','4','sandeep','121212121');

        ps2.setString(1, uname);
        ps2.setString(2, pass1);
         ps2.setString(3, to);
        ps2.setString(4, mob1);
        ps2.setInt(5,000000);
     




        ps.setString(12, to);
        ps.setString(1, pass1);
        ps.setString(2, name);
        
        ps1.setString(1, uname);
        ps1.setString(2, pass1);
       
        ps1.setInt(3, 0);
        
        ps.setString(3, fname);
      //  ps.setInt(5, age);
      
            
        ps.setString(4, voter_id);
        ps.setString(5, aadhar);
        ps.setString(6, city);
         ps.setString(7, dob);
         ps.setString(8, pass1);
            FileInputStream filename;
            filename = new FileInputStream("d:\\user.jpg");
          //   filename = new FileInputStream("d:\\"+fl);
        ps.setBinaryStream(9,filename,filename.available());
        ps.setString(10,gender);
        ps.setString(11, uname);
        ps.setString(13,mob1);
        int i=ps.executeUpdate();
        int i1=ps1.executeUpdate();
         int m=ps2.executeUpdate();
        out.println("<html>\n" +
"<head>\n" +
"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
"<title>Online Voting System...</title>\n" +
"<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
"</head>\n" +
"<body>\n" +
"<div id=\"top_links\">\n" +
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
"</div><br><br>");
        if(i>0&&i1>0)
          {
              out.println("<center><font color=\"white\">");
            out.println("You are sucessfully registered<br>");
            out.println("<a href=\"login.html\">click here for login..</a>");
              out.println("<br>Mail send successfully<br>see Username&Password in your gmail</font></center>");
           // RequestDispatcher rs = request.getRequestDispatcher("login.html");
          }
          else
          {
              out.println(" ...");
          }
        out.println("</div></body></html>");
        con.close();
        }
        catch(Exception se)
        { se.printStackTrace();
            out.println(se+" .ERRROOR....");
        }
	
      }
  }