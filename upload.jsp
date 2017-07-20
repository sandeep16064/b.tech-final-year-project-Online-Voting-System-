<%-- 
    Document   : upload
    Created on : 4 Apr, 2017, 12:50:29 PM
    Author     : SANDEEP KUMAR
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Uploading using Java</title>
</head>
<body>
<form method="POST" action="${pageContext.request.contextPath}/Uploader"
      encType="multipart/form-data"><br><br>
    <input type="file" name="file" value="select images..."/><br><br>
<input type="submit" value="start upload"/>
</form>
</body>
</html>