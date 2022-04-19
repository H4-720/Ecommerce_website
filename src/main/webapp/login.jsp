<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@ include file="comm.jsp" %>
</head>
<body>
	<%@ include file="navber/navber.jsp" %>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header custom-bg text-white purple text-center">
						<h4>Login</h4>
					</div>
					<div class="card-body">
					<%@ include file="message.jsp" %>
						<form action="loginservlet" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input name= "email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
    
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input name="pass" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
	
 <div class="container text-center">
  <button type="submit" class="btn btn-primary purple ">Submit</button>
 </div>
</form>
					</div>
					<div class="card-footer">
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>