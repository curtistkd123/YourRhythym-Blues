<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Product Page </title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css1/styles.css" rel="stylesheet" />
</head>
<body>
<div class="card">
	<div class="row no-gutters">
		<aside class="col-md-6">
<article class="gallery-wrap">
<div class="img-big-wrap">
  <div> <a href="#"><img src="/images1/"></a></div>
</div> <!-- slider-product.// -->
<div class="thumbs-wrap">
  <a href="#" class="item-thumb"> <img src="/images1/"></a>
  <a href="#" class="item-thumb"> <img src="/images1/"></a>
  <a href="#" class="item-thumb"> <img src="/images1/"></a>
</div> <!-- slider-nav.// -->
</article> <!-- gallery-wrap .end// -->
		</aside>
		<main class="col-md-6 border-left">
<article class="content-body">

<h2 class="title">${product.name }</h2>

<div class="rating-wrap my-3">
	<ul class="rating-stars">
		<li style="width:80%" class="stars-active">
			<i class="fa fa-star"></i> <i class="fa fa-star"></i>
			<i class="fa fa-star"></i> <i class="fa fa-star"></i>
			<i class="fa fa-star"></i>
		</li>
		<li>
			<i class="fa fa-star"></i> <i class="fa fa-star"></i>
			<i class="fa fa-star"></i> <i class="fa fa-star"></i>
			<i class="fa fa-star"></i>
		</li>
	</ul>
	<small class="label-rating text-muted">132 reviews</small>
	<small class="label-rating text-success"> <i class="fa fa-clipboard-check"></i> 154 orders </small>
</div> <!-- rating-wrap.// -->

<div class="mb-3">
	<var class="price h4">${product.price }</var>

</div> <!-- price-detail-wrap .// -->

<p>${product.description }</p>


<dl class="row">
  <dt class="col-sm-3">Brand</dt>
  <dd class="col-sm-9">${product.brand }</dd>

  <dt class="col-sm-3">Category</dt>
  <dd class="col-sm-9">${product.category }</dd>

  <dt class="col-sm-3">Vendor</dt>
  <dd class="col-sm-9">${product.vendors } </dd>
</dl>

<hr>

	<div class="form-group col">
		<form>
			<label>Quantity</label>
	
			<select class="form-control" name="quantity">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
			</select>
		</form>
	</div>



	<a href="/addCartItem${product.id }" class="btn  btn-outline-primary"> <span class="text">Add to cart</span> <i class="fas fa-shopping-cart"></i>  </a>
		
</article> <!-- product-info-aside .// -->
		</main> <!-- col.// -->
	</div> <!-- row.// -->
</div> <!-- card.// -->
	<c:if test="${vendor.id == vendor.product.id}">
		<a href="/product/edit/${product.id}" class="btn btn-danger">Edit Product</a>
				<form action="/product/${product.id }" method="post">
			<input type="hidden" name="method" value="delete"/>
			<input type="submit" value="Delete" />
		
		</form>
		</c:if>
		
</body>
</html>