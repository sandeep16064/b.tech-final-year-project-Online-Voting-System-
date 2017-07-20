 import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Welcome extends HttpServlet {
    
    

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
     
           
       
     //   String sql="";
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
  //     String uname=request.getParameter("uname");
  //     String pass1=request.getParameter("pass1");
       
  //     HttpSession se=request.getSession();
  //   se.setAttribute("uname", uname);
  //   se.setAttribute("pass1", pass1);
    
   HttpSession s;
     s = request.getSession();
    String uname=(String)s.getAttribute("uname");
    String pass1=(String)s.getAttribute("pass1");
  
    
        ServletContext  ctx=getServletContext();
        Integer count=(Integer)ctx.getAttribute("count");
        if(count==null)
        {
            count=new Integer(0);
        }
        count=new Integer(count.intValue()+1);
        ctx.setAttribute("count",count);
       // out.println(count.intValue());
       
       
       
    
      //RequestDispatcher rs1 = request.getRequestDispatcher("a2.html");
       out.println("<html><head><style>\n" +
"            table,th,td{border:2px solid blue;}\n" +
"        </style></head>");
        out.println("<body bgcolor='33ffcc'>");
      //  out.println("Welcome "+email );  
      out.println("<table style=\"width:897px; background:#3333cc; margin:0px 0px 0px 0px;\"><tr align=\"center\">");
      out.println(" <td width=\"299\" valign=\"top\">\n"+
"    	<div id=\"welcome\"><h1>Welcome</h1><br>\n");
     
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
         String s1=uname+"' ";
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
     
     
     
     
     out.println(" <center><img src=\"image/"+username+".png\" alt="+username+" width=\"196\" height=\"106\"></center><br>\n");
 
          
            out.println("<table style=\"background:#ffffff;\"><h2><tr><td> Username :   </td><td>  " + username + " </td></tr>");
            out.println("<tr><td>Total Profile Hits::    </td><td> "+count.intValue()+"</td></tr>");
            out.println("<tr><td>Email ID:   </td><td>" + email + "</td></tr>");
            out.println("<tr><td>name:   </td><td>" + name + "</td></tr>");  
            out.println("<tr><td>Father Name:  </td><td>" + fname+ "</td></tr>");
            out.println("<tr><td>Voter_ID:  </td><td>" +vot+ "</td></tr>");
            out.println("<tr><td>Aadhar No :  </td><td>" + aad+ "</td></tr>");
            out.println("<tr><td>Gender:  </td><td>" + gender+ "</td></tr>");
            out.println("<tr><td>Mobile No.:  </td><td>" + mob+ "</td></tr>");
            out.println("<tr><td>DOB:  </td><td>" + dob+ "</td></tr></h2></table>");
       }
      }catch(Exception e)
      {
          e.printStackTrace();
          out.println(e+" error...............");
      }
      //  out.println("last"+pass);
        
       //  out.println("<left> <button><a  href=\"Logout\">LOGOUT</a></button></left><br>");
         out.println("<br><center> <form action=\"Logout\" method=\"POST\">"
                 + "<input type=\"submit\" value=\"Logout\"></form></center>");
         out.println("<br><center> <form action=\"result55\" method=\"POST\">"
                 + "<input type=\"submit\" value=\"GoTo Vote\"></form></center>");
         out.println("<br><right> <a target=\"_blank\" href=\"http://127.0.0.1:8085/Online_Voting_System/result.jsp\"><button>Result</button></a> </right>");
         out.println();
         
out.println(" </td></table>");
   //out.println("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">");
       // out.println("<center><h1>"+email +"</h1></center>");
        
        out.println("</div></body></html>");
     
            out.close();
       
    }
   
}