<%-- 
    Document   : result
    Created on : 12 Feb, 2017, 4:50:22 PM
    Author     : SANDEEP KUMAR
--%>

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
        <title>Final result.</title>
        
        <LINK rel="shortcut icon" type="image/x-icon" href="images/fevicon.ico">
    </head>
    <body><center>
        <h1><br><br></h1>
        <h2>result discriptions in online votting systemmm..</h2>
         <%! String party;
                int v;%>
                <%                  
         try{
	 //loading drivers for mysql
         Class.forName("oracle.jdbc.driver.OracleDriver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
        Statement stmt =con.createStatement();
   // String s6="select max(count) from votes";
         String s5="select party_name,count from votes where count in(select max(count)from votes)";
         ResultSet rs =stmt.executeQuery(s5);
     //  ResultSet rs1=stmt.executeQuery(s6);
      %>
      <table><tr><th> --::PARTY NAME::--</th>
              <th> --::NO. OF VOTES::---</th></tr>
       <%
          while(rs.next()){
     HttpSession se=request.getSession();
  
          party = rs.getString("party_name"); 
        v=rs.getInt("count");
       
    
   out.println("<tr><td>"+party +" </td><td>"+v + "</td></tr>");
   //out.println("<tr><td>"+party);
  
       }
        }catch(Exception e)
      {
          e.printStackTrace();
          out.println("error...............");
      }
    %>
          
      </table>  
    <br> 
    <%out.println(party+" win with "+v+" votes");%>
    <br><br>
     <form action="result.jsp" method="Get">
              <input type="submit" value="back to table">
          </form>
    </center>          
</body>
</html>
