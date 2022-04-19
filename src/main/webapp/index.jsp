<!doctype html>

<%@page import="com.project.helper"%>
<%@page import="com.project.tables.category"%>
<%@page import="com.ecommerce.dao.catedao"%>
<%@page import="java.util.List"%>
<%@page import="com.project.tables.Product"%>
<%@page import="com.ecommerce.dao.productdao"%>
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
   
   <%
   String cat = request.getParameter("category");
   	productdao dao = new productdao(factoryProvider.getFactory());
   	List<Product> list=null;
   	if(cat==null){
   		list=dao.getallproduct();
   	}
   	else if(cat.trim().equals("all")){
   		list=dao.getallproduct();
   	}
   	else{
   		int cid  = Integer.parseInt(cat.trim());
   		list = dao.getallproductById(cid);
   	}
   	catedao cdao = new catedao(factoryProvider.getFactory());
   	List<category> clist = cdao.getCategory();
   %>
   <div class="container-fluid">
   <div class="row mt-3">
   <div class="col-md-2">
   <div class="list-group">
  <a href="index.jsp?category= all" class="list-group-item list-group-item-action active">
    All Products
  </a>
  </div>
   		<%
   			for(category cate: clist){
   		%>
   				<a href="index.jsp?category=<%= cate.getCatid() %>" class="list-group-item list-group-item-action"><%= cate.getCattitle() %></a>
   		<%
   			}
   		%>
   </div>
   
   <div class="col-md-10">
   
  <div class="card-columns">
  	
  	<%
  		for(Product p: list){
  	%>
  	<div class="card product-card">
  	<div class="container text-center">
  	
	<img class="card-img-top" style="max-height: 200px;max-width: 100%;width: auto;" src="image/propic/<%= p.getPphoto() %>" alt="Loading..">
  
  	</div>
  	<div class="card-body">
 		<h5 class="card-title"><%= p.getPname() %></h5>
 		<p class="card-text"><%= helper.get10word(p.getPdesc()) %></p>
  </div>
  <div class="card-footer">
  	<button class="btn purple text-white" onclick="add_to_card(<%= p.getPid()%>, '<%= p.getPname()%>', <%= p.getPriceafterApplingDiscount()%>)">Add to card</button>
  	<button class="btn btn-outline-success">&#8360;<%= p.getPriceafterApplingDiscount() %>/- <span class="text-secondary discount-label">&#8360;<%= p.getPprice()%>/- <%=p.getPdiscount() %>% off</span></button>
  </div>
</div>
  	
  	
  	<%}
  	
  		if(list.size()==0){
  			out.print("No item Avalable");
  		}
  	
  	%>
  </div>
  </div>
   	
   </div>
   
   </div>
   <%@ include file="common_modal.jsp" %>
  </body>
</html>




