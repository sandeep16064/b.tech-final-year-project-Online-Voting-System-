<%-- 
    Document   : result
    Created on : 12 Feb, 2017, 4:50:22 PM
    Author     : SANDEEP KUMAR
--%>
<%@page import="javax.servlet.RequestDispatcher"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            table,th,td{border:2px solid blue;}
        </style>
        <title>Result</title>
        <LINK rel="shortcut icon" type="image/x-icon" href="images/fevicon.ico">
    </head>
    <body><center>
        <h1><br><br></h1>
        <h2>Result discriptions in online votting system..</h2>
         <%                  
         try{
	 //loading drivers for mysql
         Class.forName("oracle.jdbc.driver.OracleDriver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
        Statement stmt =con.createStatement();
   //String s6="select max(count) from votes";
         String s5="select party_name,count from votes";
         ResultSet rs =stmt.executeQuery(s5);
        //String s3=(String)request.getAttribute("name");
         //out.println(s3);
     //ResultSet rs1=stmt.executeQuery(s6);
      %>
      <table><tr><th>--::PARTY NAME::--</th>
              <th>--::NO. OF VOTES::---</th></tr>
       <%
          while(rs.next()){
     HttpSession se=request.getSession();
  
          String party = rs.getString("party_name"); 
        int v=rs.getInt("count");
       
    
    out.println("<tr><td>"+party +" </td><td>"+v + "</td></tr>");
   
       }
        }catch(Exception e)
      {
          e.printStackTrace();
          out.println("error...............");
      }
    %>
       <% 
//RequestDispatcher rd=request.getRequestDispatcher("test.html");
//rd.include(request,response);
  //      %>    
      </table>  
          <br>
     <form action="result11.jsp" method="Get">
              <input type="submit" value="final result">
     </form><br>
          <a href="index.html"><button>GOTO HOME</button></a>
    </center>          
</body>
</html>
