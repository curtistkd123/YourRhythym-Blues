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
<link href="css1/styles.css" rel="stylesheet" />
 <style >
 body {
  background-image: url("images1/background1.jpg");
  background-repeat: no-repeat; /* Do not repeat the image */
  background-size: cover;}
     .carouselpictures {
     width:400px;
     height: 400px;}
     
     .product img {
     width:100%;
     height: 150px;
      }
     }
      </style>
<body>
<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<c:choose>
				<c:when test="${user.id==null}">
					<a class="navbar-brand bg-dark" href="/register"><button>Create
							Profile</button></a>
				</c:when>

				<c:otherwise>
					<c:out value="${user.firstName }" />, <a
						class="navbar-brand bg-dark" href="/edituser${user.id}"><button>Edit
							Profile</button></a>

				</c:otherwise>
			</c:choose>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#!">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#!">About</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="/">All Products</a></li>
							<li><hr class="dropdown-divider" /></li>
							<c:forEach items="${categories }" var="c">
							<li><a class="dropdown-item" href="/categories${c.id}"><c:out value="${c.name}"/></a></li>
							</c:forEach>
							<li><a class="dropdown-item" href="">Popular Items</a></li>
							<li><a class="dropdown-item" href="#!">New Arrivals</a></li>
						</ul></li>
				</ul>
				<form:form action="/shoppingCart${user.id}" method="get" class="d-flex">
				
					<button class="btn btn-outline-dark" onclick="/shoppingCart${user.id}" type="submit">
						<i class="bi-cart-fill me-1"></i> Cart <span
							class="badge bg-dark text-white ms-1 rounded-pill"><c:out value="${cartsize }"/></span>
					</button>
					
				</form:form>
			</div>
		</div>
	</nav>
	<!-- Header-->
	<header class="bg-dark py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
				<h1 class="display-4 fw-bolder">Rhythym&Blues</h1>
				<p class="lead fw-normal text-white-50 mb-0">One stop shop for
					all things Guitars</p>
			</div>
		</div>
	</header>

<div class="card">
	<div class="row no-gutters">
		<aside class="col-md-6">
<article class="gallery-wrap">
<div class="img-big-wrap">
  <div> <a href="#"><img  src="images1/${p.name}.jpg" alt="..." ></a></div>
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
<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	<div class="text-center">
		<a class="btn btn-outline-dark mt-auto"
			href="/addCartItem${p.id}">Add to Cart</a>
		</div>
		</div>
	<div class="text-center">
		
			<c:if test="${vendor.id == vendor.product.id}">
			<h5>
		<a href="/product/edit/${product.id}" class="btn btn-danger">Edit Product</a>
				<form action="/product/${product.id }" method="post">
			<input type="hidden" name="method" value="delete"/>
			<input type="submit" value="Delete" />
		
		</form>
		</c:if>
		</h5>
</article> <!-- product-info-aside .// -->
		</main> <!-- col.// -->
	</div> <!-- row.// -->
</div> <!-- card.// -->

		
</body>
</html>