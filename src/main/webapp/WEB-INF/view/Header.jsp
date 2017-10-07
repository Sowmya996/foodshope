<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <c:set var="cp" value="${pageContext.request.contextPath}" /> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<!--Starting header-->
       <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="Home"></a>
      <div class="container-fluid" style="font-size: 35px;">
    <a class="navbar-brand" href="#" id="header" >FOOD COURT</a>
    </div>
    </div>
     <ul class="nav navbar-nav navbar-right">
      <li class="active"><a href="Home"><span class="glyphicon glyphicon-home">Home</span></a></li>
      <li><a href="Signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      <li><a href="Category"><span class="glyphicon glyphicon-category"></span> Category</a></li>
      <li><a href="Home"><span class="glyphicon glyphicon-about-us">About Us</span></a></li>
       <li><a href="Admin"><span class="glyphicon glyphicon-about-us">Admin</span></a></li>
    </ul>
  </div>
</nav>
</body>
</html>