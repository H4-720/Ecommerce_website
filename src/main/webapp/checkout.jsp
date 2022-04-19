<%
user User = (user) session.getAttribute("current-user");
if (User==null){
	session.setAttribute("message", "You are not logged in || Login First");
	response.sendRedirect("login.jsp");
}


%>




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="comm.jsp" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <%@ include file="navber/navber.jsp" %>
	<div class="container">
	
		<div class="row mt-5">
		
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
					<h3 class="text-center mb-4">Your select items</h3>
					<div class="cart-body"></div>
					</div>
					
				</div>
			</div>
			<div class="col-md-6">
					<div class="card">
					<div class="card-body">
						<h3 class="text-center mb-4">Your order details</h3>
						<form action="#!">
							<div class="form-group">
   							 <label for="exampleInputEmail1">Email address</label>
   							 <%
   							 	if(!(User==null)){
   							 %>
    						<input value="<%= User.getUemail() %>"  type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
							<%} %>
  							</div>
  							
  							<div class="form-group">
   							 <label for="exampleInputEmail1">Name</label>
   							  <%
   							 	if(!(User==null)){
   							 %>
    						<input value="<%= User.getUname() %>" type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter Name">
  							</div>
  							<%} %>
  							<div class="form-group">
   							 <label for="exampleInputEmail1">Phone</label>
   							  <%
   							 	if(!(User==null)){
   							 %>
    						<input value="<%= User.getUphone() %>" type="text" class="form-control" id="phone" aria-describedby="emailHelp" placeholder="Enter Contact number">
  							<%} %>
  							</div>
  							
  							<div class="form-group">
    <label for="exampleFormControlTextarea1">Address</label>
    <textarea class="form-control" id="address" placeholder="Enter your address" rows="3"></textarea>

  </div>
  							<div class="container text-center">
  								<button class="btn btn-outline-success">OrderNow</button>
  							</div>
						</form>
					</div>
					
				</div>
			</div>
		
		</div>
	
	</div>

<%@ include file="common_modal.jsp" %>
</body>
</html>