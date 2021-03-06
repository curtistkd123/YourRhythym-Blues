<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<!-- jQuery -->
<script src="js/jquery-2.0.0.min.js" type="text/javascript"></script>

<!-- Bootstrap -->
<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>

<!-- custom javascript -->
<script src="js/script.js" type="text/javascript"></script>
<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>

<!-- Font awesome 5 -->
<link href="fonts/fontawesome/css/all.min.css" type="text/css" rel="stylesheet">

<!-- ui style -->
<link href="css/ui.css" rel="stylesheet" type="text/css"/>
<link href="css/responsive.css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Checkout</title>
</head>
<body>
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#!">Start Bootstrap</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#!">All Products</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                                <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <a href="/shoppingCart" class="btn btn-outline-dark" >
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                        </a>
                    </form>
                </div>
            </div>
        </nav>
        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">Rhythym&Blues</h1>
                    <p class="lead fw-normal text-white-50 mb-0">One stop shop for all things Guitars</p>
                </div>
            </div>
        </header>
<h1>Review Cart</h1>
<div class="row">

	<aside class="col-lg-9">
		<c:forEach items="${cartItems}" var="c">
				<div class="col-md-6">
					<figure class="itemside  mb-3">
						<div class="aside"><img src="bootstrap-ecommerce-html/images/items/1.jpg" class="border img-xs"></div>
						<figcaption class="info">
							<p>${c.product.name } </p>
							<span>${c.quantity} x  $ ${c.product.price} = $ ${Math.round(c.total*100.00)/100.00} </span>
						</figcaption>
					</figure>
				</div> <!-- col.// -->

			</c:forEach>

		<dl class="row">
		
		  <dt class="col-sm-10">Subtotal: <span class="float-right text-muted">${cartsize }</span></dt>
		  <dd class="col-sm-2 text-right"><strong>$ ${Math.round(cartTotal*100.00)/100.00 }</strong></dd>

		  <dt class="col-sm-10">Delivery charge: <span class="float-right text-muted">Express delivery</span></dt>
		  <dd class="col-sm-2 text-right"><strong>$25.00</strong></dd>

		  <dt class="col-sm-10">Tax: <span class="float-right text-muted">5%</span></dt>
		  <dd class="col-sm-2 text-right text-success"><strong>$ ${Math.round(.05*cartTotal)}</strong></dd>

		  <dt class="col-sm-10">Total:</dt>
		  <dd class="col-sm-2 text-right"><strong class="h5 text-dark">$ ${Math.round(.05/cartTotal)*100.00  + (Math.round(cartTotal*100.00)/100.00)  }</strong></dd>
		</dl>
		<a href="/orderDetail" class="btn btn-primary btn-block">Purchase!</a>
				<a href="#" class="btn btn-light btn-block">Continue Shopping</a>
		
	</aside> <!-- col. -->

</div><!-- row.// -->
<!-- ========================= SECTION CONTENT END// ========================= -->

<footer class="section-footer border-top padding-y">
	<div class="container">
		<p>	&copy Copyright 2020 All rights reserved</p>
		<p>	<a href="#">Terms and conditions</a> </p>
	</div><!-- //container -->
</footer>
</body>
</html>