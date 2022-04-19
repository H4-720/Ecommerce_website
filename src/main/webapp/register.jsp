<!doctype html>
<%@page import="com.project.factoryProvider"%>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<%@ include file="comm.jsp" %>
    <title>Registration</title>
  </head>
  <body>
   <%@ include file="navber/navber.jsp" %>
   
	<div class="row mt-5">
	<div class="col-md-4 offset-md-4">
	 <div class = "card">
	 	<%@ include file="message.jsp" %>
	 	<div class="card-body">
	 	<h3 class="container text-center">SignUp</h3>
	 	
	 	
		<form action="registerservlet" method="post">
		<div class="form-group">
    <label for="name">Name</label>
    <input name="user_name" type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter name">
    
  </div>
  	<div class="form-group">
    <label for="email">Email</label>
    <input name="user_email" type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter Email">
    
  </div>
    	<div class="form-group">
    <label for="password">Password</label>
    <input name="user_pass" type="password" class="form-control" id="password" aria-describedby="emailHelp" placeholder="Enter Password">
    
  </div>
    	<div class="form-group">
    <label for="Phone">Phone</label>
    <input name="user_phone" type="number" class="form-control" id="Phone" aria-describedby="emailHelp" placeholder="Enter number">
    
  </div>
    	<div class="form-group">
    <label for="address">Address</label>
    <textarea name= "user_address" style="height: 200px" class="form-control" placeholder="Enter Address"></textarea>
    
  </div>
  <div class= "container text-center">
  <button type="submit" class="btn btn-success">Register</button>
  <button type="reset" class="btn btn-warning">Reset</button>
  </div>
		</form>
	 	</div>
	 
	 </div>
	</div>
	
	</div>

  </body>
</html>
