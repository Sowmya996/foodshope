<jsp:include page="Header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <title>Food Court</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>
<centre><h1>Categories.</h1></centre>
<div class="container">    
  <div class="row">
    <div class="col-sm-3"style="height:200px; width:275px">
      <div class="panel panel-primary">
        <div class="panel-heading">Extra Cheese</div>
        <div class="panel-body"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZybJPqfU7-OyImAJ0-QUoxnIX5CMNfdFLbQwNSjxG1WL4eaBy" class="img-responsive" style="height:150px; width:250px" alt="Image"></div>
        <div class="panel-footer"><b><center>Burgers</center></b></a></div>
      </div>
    </div>
    <div class="col-sm-3" style="height:200px; width:275px"> 
      <div class="panel panel-danger">
        <div class="panel-heading">One+One offer</div>
        <div class="panel-body"><center><img src="https://i.ytimg.com/vi/bYO4fDJ3lGo/maxresdefault.jpg" } class="img-responsive" style="height:150px; width:250px" alt="Image"></div></center> 
        <div class="panel-footer"><b><center>Ice Creams</center></b></a></div>
      </div>
    </div>
    <div class="col-sm-3" style="height:200px; width:275px"> 
      <div class="panel panel-success">
        <div class="panel-heading">Monsoon DEAL 50% Off</div>
        <div class="panel-body"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCqrWS48svtYjBrUiSlhpWA6BXSsPYqQ-3C_3Q_piRhyh6iPs20g" class="img-responsive" style="height:150px; width:250px" alt="Image"></div>
        <div class="panel-footer"><b><center>Pizzas</center></b></a></div>
      </div>
    </div>
    <div class="row">
    <div class="col-sm-3" style="height:200px; width:275px">
      <div class="panel panel-primary">
        <div class="panel-heading">25% Off</div>
        <div class="panel-body"><img src="http://pkytreehouse.weebly.com/uploads/3/7/1/6/3716301/pop-cans-tax-on-sugary-drinks-fmvxl6-clipart_orig.jpg" class="img-responsive" style="height:150px; width:250px" alt="Image"></div>
        <div class="panel-footer"><b><center>Cool Drinks</center></b></a></div>
      </div>
      </div>
      </div>
<br/><br/><br/><br/><br/><br/>    
  <div class="row">
    <div class="col-sm-3" style="height:200px; width:275px">
      <div class="panel panel-primary">
        <div class="panel-heading">Rs10/- Patym money</div>
        <div class="panel-body"><img src="http://goodtoknow.media.ipcdigital.co.uk/111/00000c80d/4679_orh412w625/Blue-cheese-puffs.jpg" class="img-responsive" style="height:150px; width:250px" alt="Image"></div>
        <div class="panel-footer"><b><center>Puffs</center></b></a></div>
      </div>
    </div>
    </div>
  </div>
</div>
</body>
</html>

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<jsp:include page="Footer.jsp"></jsp:include>