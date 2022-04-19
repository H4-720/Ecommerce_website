function add_to_card(pid,pname,price)
{
	let cart = localStorage.getItem("cart");
	if(cart == null)
	
	{
	
	let products = [];
	let product = {productId: pid, productName: pname, productQuantity: 1, productPrice: price};
	products.push(product);
	localStorage.setItem("cart",JSON.stringify(products));
	console.log("Product is added for the first time");
	showtoast("Product is added");
	}
	else
	{
	
		let pcart = JSON.parse(cart);
		let oldproduct = pcart.find((item) => item.productId == pid)
		
		if(oldproduct)
		{ 
		oldproduct.productQuantity = oldproduct.productQuantity + 1
		pcart.map((item) =>{ 
			if(item.productId == oldproduct.productId){
				item.productQuantity = oldproduct.productQuantity;
			}
		})
		localStorage.setItem("cart", JSON.stringify(pcart));
		console.log("Product is increased");
		showtoast(oldproduct.productName+" is increased");
		}
		else{
		
		let product = {productId: pid, productName: pname, productQuantity: 1, productPrice: price};
		pcart.push(product);
		localStorage.setItem("cart", JSON.stringify(pcart));
		console.log("Product is added");
		showtoast("Product is added");
		}
	
	}
	updatecart();
}
function updatecart(){

	let cartString = localStorage.getItem("cart");
	let cart = JSON.parse(cartString);
	if(cart==null || cart.length==0){
		console.log("cart is empty !!");
		$(".cart-items").html("(0)");
		$(".cart-body").html("<h3>Cart does not have items</h3>");
		$(".check-out").attr('disabled',true);
	}else
	{
		console.log(cart);
		$(".cart-items").html(`(${cart.length})`);
		
				let table=`
		<table class='table'>
		<thead class='thread-light'>
		<tr>
			<th>Item Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Total Price</th>
			<th>Action</th>
		</tr>
		</thead>
		`;
		let totalprice=0;
	  cart.map((item)=>{
      table+=`
      <tr>
        <td> ${item.productName}</td>
        <td> ${item.productPrice}</td>
        <td> ${item.productQuantity}</td> 
        <td> ${item.productQuantity*item.productPrice}</td>
        <td> <button onclick='deletefromcard(${item.productId})' class="btn btn-danger btn-sm">Remove</button></td>
      </tr>`
		totalprice+= item.productPrice * item.productQuantity;
    })
		table = table + `
		<tr><td colspan='5' class="text-right font-weight-bold"> Total Price: ${totalprice} </td></tr>
		</table>`
		$(".cart-body").html(table);		
		$(".check-out").attr('disabled',false);
	}

}
function deletefromcard(pid){

	let cart = JSON.parse(localStorage.getItem("cart"));
	let newcart = cart.filter((item) => item.productId != pid);
	localStorage.setItem("cart", JSON.stringify(newcart));
	updatecart();
	showtoast("Product is removed");
}
$(document).ready(function(){updatecart()})

function showtoast(content){
	$("#toast").addClass("display");
	$("#toast").html(content);
	setTimeout(() => {
		$("#toast").removeClass("display");

	}, 2000);
}
function gotocheckout(){
	window.location="checkout.jsp";
}