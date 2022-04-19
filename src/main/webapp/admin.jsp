<%@page import="java.util.Map"%>
<%@page import="com.project.helper"%>
<%@page import="com.project.tables.category"%>
<%@page import="java.util.List"%>
<%@page import="com.ecommerce.dao.catedao"%>
<%@page import="com.project.tables.user"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<% 
	user User = (user) session.getAttribute("current-user");
	if (User==null){
		session.setAttribute("message", "You are not logged in || Login First");
		response.sendRedirect("login.jsp");
	}else{
		if(User.getUtype().equals("normal"))
		{
			session.setAttribute("message", "You are not admin | Do not access this page");
			response.sendRedirect("login.jsp");
		}
	}
 %>
 
   <%
  catedao cd = new catedao(factoryProvider.getFactory()); 
  List<category> list = cd.getCategory();
  
 Map<String,Long> map= helper.getCount(factoryProvider.getFactory());
  
  %>

<!doctype html>
<%@page import="com.project.factoryProvider"%>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<%@ include file="comm.jsp" %>
    <title>Home</title>
  </head>
  <body>
   <%@ include file="navber/navber.jsp" %>
	<div class="container admin">
	
	<div class="container-fluid">
	
	<%@ include file="message.jsp" %>
	
	</div>
	
	<div class="row mt-5">
		<div class="col-md-4">
		
			<div class="card">
				<div class="card-body text-center">
				<div class="container">
					<img style="max-width: 125px;" class="img-fluid" alt="User_icon" src="image/users.png">
				</div>
				<h2 class="mt-2"><%= map.get("userCount") %></h2>
				<h2>Users</h2>
				
				</div>
			</div>
		
		</div>
		
		<div class="col-md-4">
		
					<div class="card">
				<div class="card-body text-center">
				<div class="container">
					<img style="max-width: 125px;" class="img-fluid" alt="User_icon" src="image/categorys.png">
				</div>
				<h2 class="mt-2"><%= list.size() %></h2>
				<h2>Categorys</h2>
				
				</div>
			</div>
		
		</div>
		
		<div class="col-md-4">
		
					<div class="card">
				<div class="card-body text-center ">
				<div class="container">
					<img style="max-width: 125px;" class="img-fluid" alt="User_icon" src="image/product.png">
				</div>
				<h2 class="mt-2"><%= map.get("ProductCount") %></h2>
				<h2>products</h2>
				
				</div>
			</div>
		
		</div>
	
	</div>
	<div class="row mt-3">
		<div class="col-md-6">
				<div class="card" data-toggle="modal" data-target="#categorymodal">
				<div class="card-body text-center">
				<div class="container">
					<img style="max-width: 125px;" class="img-fluid" alt="User_icon" src="image/addc.png">
				</div>
				<h2>Add categorys</h2>
				
				</div>
			</div>
		</div>
		<div class="col-md-6" data-toggle="modal" data-target="#productmodal">
				<div class="card">
				<div class="card-body text-center">
				<div class="container">
					<img style="max-width: 125px;" class="img-fluid" alt="User_icon" src="image/addp.png">
				</div>
				<h2>Add products</h2>
				
				</div>
			</div>
		</div>
	</div>
	
	
	</div>


<!-- Modal -->
<div class="modal fade" id="categorymodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header purple text-white">
        <h5 class="modal-title" id="exampleModalLabel">Add category</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        
        <form action="catOperationServlet" method="post">
        <input type="hidden" name="operation" value="addcat"/>
  <div class="form-group">
    <input name="cattitle" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter category name">
  </div>
  <div class="form-group">
 	<textarea name="catdescription" style="height: 300px;" class="form-control" placeholder="Enter Discription of category"></textarea>
    
  </div>
  <div class="contianer text-center">
    <button type="submit" class="btn btn-primary purple">Save</button>
  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
  </div>

</form>
        
        
      </div>
      <div class="modal-footer">
        
      </div>
    </div>
  </div>
</div>


<!-- Modal 2 -->
<div class="modal fade" id="productmodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header purple text-white">
        <h5 class="modal-title" id="exampleModalLabel">Add Product</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        
        <form action="catOperationServlet" method="post" enctype="multipart/form-data">
        <input type="hidden" name="operation" value="addproduct"/>
  <div class="form-group">
    <input name="pname" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter prouct name" >
  </div>
  <div class="form-group">
 	<textarea name="pdesp" class="form-control" placeholder="Enter Discription of category"></textarea>
    
  </div>
    <div class="form-group">
    <input name="pprice" type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter product price">
  </div>
  
    <div class="form-group">
    <input name="pdiscount" type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter product discount">
  </div>
  
    <div class="form-group">
    <input name="pquantity" type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter product quantity">
  </div>

  <div class="form-group col-md-4">
      <label for="inputState">State</label>
      <select name="catid" id="inputState" class="form-control">
        
        <%
        for(category c:list){
        %>
        
        <option value="<%= c.getCatid()%>"><%= c.getCattitle()%>></option>
        <%} %>
      </select>
    </div>
  
    <div class="form-group">
    <label for="exampleFormControlFile1">Example file input</label>
    <input name="pPic" type="file" class="form-control-file" id="exampleFormControlFile1">
  </div>
  
  <div class="contianer text-center">
    <button type="submit" class="btn btn-primary purple">Save</button>
  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
  </div>
  
</form>
        
        
      </div>
      <div class="modal-footer">
        
      </div>
    </div>
  </div>
</div>
<%@ include file="common_modal.jsp" %>
  </body>
</html>