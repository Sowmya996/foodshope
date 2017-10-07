<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Food Court</title>
<style type="text/css">
  
.dot {
  cursor:pointer;
  height: 13px;
  width: 13px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}
div.scrollmenu {
    overflow: auto;
    white-space: nowrap;
    text-align: center;
}
div.scrollmenu a {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px;
    text-decoration: none;
    padding: 15px 35px 15px 35px;
}

div.scrollmenu a:hover {
    background-color: #777;
}
  body {
      font: 400 15px Lato, sans-serif;
      line-height: 1.8;
      color: #818181;
  }

  .item h4 {
      font-size: 19px;
      line-height: 1.375em;
      font-weight: 400;
      font-style: italic;
      margin: 70px 0;
  }
  .item span {
      font-style: normal;
  }
 
</style>
</head>
<jsp:include page="Header.jsp"></jsp:include>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60"> 
  <div id="Home" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#Home" data-slide-to="0" class="dot"></li>
      <li data-target="#Home" data-slide-to="1" class="dot"></li>
      <li data-target="#Home" data-slide-to="2" class="dot"></li>
      <li data-target="#Home" data-slide-to="3" class="dot"></li>
      <li data-target="#Home" data-slide-to="4" class="dot"></li>
    </ol>
    
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="http://img.taste.com.au/OCHvg-fF/taste/2017/04/beef-beetroot-burger-with-grilled-pumpkin-1980x1320-125772-1.jpg" alt="Burger" style="width:100%;height: 350px;">
      </div>

      <div class="item">
        <img src="https://media.licdn.com/mpr/mpr/AAEAAQAAAAAAAAnMAAAAJGVjOGM4NjJjLTQwNTQtNGYxOC05ODU1LTQ3ZmVhMWVhYjg5MQ.jpg" alt="Pizza" style="width: 100%;height: 350px;" >
      </div>
    
      <div class="item">
        <img src="https://pull-revisfoodography.netdna-ssl.com/wp-content/uploads/2017/02/palak-paneer-puff-1.jpg" alt="Puffs" style="width: 100%;height: 350px;" >
      </div>
      
      <div class="item">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqMRANNqSsNWVoEEPT5o_8VdjJxmzlGsj8C34cIOwhyZsiK3iAjQ" alt="Cooldrink" style="width: 100%;height: 350px;" >
      </div>

      <div class="item">
        <img src="https://media.timeout.com/images/100914189/image.jpg" alt="Icecream" style="width: 100%;height: 350px;" >
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#Home" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#Home" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <br/>
<div class="container" id="about">
	<%@include file="Aboutus.jsp" %>
</div>


<br/><br/><br/>
<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>