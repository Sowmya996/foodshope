<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Food Court</title>
</head>
<body onload='document.f.username.focus();' bgcolor="AliceBlue">
<jsp:include page="Header.jsp"></jsp:include>
<centre><h1>Login Page</h1></centre>
<form class="form-horizontal" action="/foodshope/login" method="post">
        <div class="form-group">
            <label for="inputUsername" class="control-label col-xs-2">Username</label>
            <div class="col-xs-2">
                <input type="text" class="form-control" id="inputUsername" placeholder="Username" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-2">Password</label>
            <div class="col-xs-2">
                <input type="password" class="form-control" id="inputPassword" placeholder="Password" required>
            </div>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <div class="checkbox">
                    <label><input type="checkbox"> Remember me</label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
        </div>   
         </form>
         </div>
    <div class="panel-footer">New User? click <a href="Signup">here</a></div>
  </div>
         
     <br></br><br></br><br></br><br></br><br></br><br></br><br></br>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>