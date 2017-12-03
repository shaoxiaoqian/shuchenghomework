<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="beans.order"%>   
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Flat Cart Widget  Responsive Widget Template | Home :: w3layouts</title>
<link href="Css/style1.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Flat Cart Widget Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!--google fonts-->
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<script src="Js/jquery-1.11.0.min.js"></script>

<script>$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.cake-top').fadeOut('slow', function(c){
	  		$('.cake-top').remove();
		});
	});	  
});
</script>

<script>$(document).ready(function(c) {
	$('.close-btm').on('click', function(c){
		$('.cake-bottom').fadeOut('slow', function(c){
	  		$('.cake-bottom').remove();
		});
	});	  
});
</script>
</head>
<body>
<div class="logo">
	<h3>购物车界面</h3>
</div>
<div class="cart">
   <div class="cart-top">
   	  <div class="cart-experience">
   	  	 <h4>当前用户：${username}</h4>
   	  </div>
   	  <div class="cart-login">
   	  	 
   	  	 	 
   	  	 <div class="clear"> </div>
   	  </div>
   	 <div class="clear"> </div>
   </div>
   <div class="cart-bottom">
   	 <div class="table">
   		
   	 	<table>
   	 		<tbody>
   	 	      <tr  class="main-heading">	  	      	
		 			<th>商品名称</th>
		 			<th class="long-txt">商品描述</th>
		 			
		 			<th>数量</th>
		 			<th>单价</th>
		 			<th>总价</th>
		 			 		 			 	
   	 	     </tr>
   	 	     <c:forEach var="order" items="<%=new order().getGoodsList() %>">
   	 	     <tr class="cake-top">
   	 	     	<td class="cakes">	 	     	  
   	 	     		<div class="product-img">
   	 	     			<h4>${order.bookName }</h4>
   	 	     		</div>
   	 	        </td>
   	 	        <td class="cake-text">
   	 	     		<div class="product-text">
   	 	     			<h3>Box Of 12 Rose Petal Blueberry Cupcakes</h3>
   	 	     			
   	 	     		</div>
 	     	    </td>
 	     	    <td class="quantity"> 	 	     	 
   	 	     	  <div class="product-right">
   	 	     	  	 <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">				  
   	 	     	  </div>
   	 	     	</td>
   	 	     	<td class="price">
   	 	     		<h4>${order.bookPrice }</h4>	 	     		
   	 	     	</td>
   	 	     	<td class="btm-remove">
   	 	     		<h4>${order.bookPrice }</h4>
   	 	     		<div class="close-btm">
   	 	     	 <a href="shopcartDeleteServlet?id=${order.id}">
   	 	     	   <h5>删除</h5>
   	 	     	   </a>
   	 	        </div>
   	 	     	</td>
  	 	     	
   	 	     </tr>
</c:forEach>
   	 	   </tbody>
   	 	</table>
   	 	
   	 </div>
   	 <div class="vocher">
   	 	<div class="dis-card">
   	 	</div>
   	 	<div class="dis-total">
   	 		
   	 		<div class="tot-btn">
   	 			<a class="shop" href="index.jsp">回到商店</a>
   	 			<a class="check" href="submitOrderServlet">提交订单</a>
   	 		</div>
   	 	</div>
   	   <div class="clear"> </div>
   	 </div>
   </div>
</div>
<div class="copy-right">
			<p>© 2016 Flat Cart Widget. All rights reserved | Template by  <a href="http://w3layouts.com/" target="_blank">  W3layouts </a></p>
</div>

</body>
</html>
