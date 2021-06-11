<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<!-- jQuery -->
<script src="js/jquery-2.0.0.min.js" type="text/javascript"></script>

<!-- Bootstrap  -->
<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>

<!-- custom javascript -->
<script src="js/script.js" type="text/javascript"></script>
<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />

<!-- Font awesome 5 -->
<link href="fonts/fontawesome/css/all.min.css" type="text/css"
	rel="stylesheet">

<!-- ui style -->
<link href="css/ui.css" rel="stylesheet" type="text/css" />
<link href="css/responsive.css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>
<<<<<<< HEAD
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
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
                            <span class="badge bg-dark text-white ms-1 rounded-pill">${user.cartItems.size() }</span>
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
<h1>Shopping Cart for ${user.firstName }</h1>
<div class="row">
	<aside class="col-lg-9">
<div class="card">

<div class="table-responsive">

<table class="table table-borderless table-shopping-cart">
<thead class="text-muted">
<tr class="small text-uppercase">
  <th scope="col">Product</th>
  <th scope="col" width="120">Quantity</th>
  <th scope="col" width="120">Price</th>
  <th scope="col" class="text-right d-none d-md-block" width="200"> </th>
</tr>
</thead>
<tbody>
<c:forEach items="${cart}" var="c">
<tr>
	<td>
		<figure class="itemside align-items-center">
			<div class="aside"><img src="images1/${c.product.name}.jpg"  class="img-sm"></div>
			<figcaption class="info">

				<a href="#" class="title text-dark"><c:out value="${c.product.name}"/></a>
				<p class="text-muted small"> ${c.product.description} <br> Brand: ${c.product.brand }</p>



			</figcaption>
		</figure>
	</td>
	<td>
		<select class="form-control">
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
		</select>
	</td>
	<td>
		<div class="price-wrap">

		
			<var class="price">$<c:out value="${c.total}"/></var>
			<small class="text-muted"> $<c:out value="${c.product.price}"/> each </small>

			<var class="price">
			
			
			
		

		</div> <!-- price-wrap .// -->
	</td>
	<td class="text-right d-none d-md-block">
	<a data-original-title="Save to Wishlist" title="" href="" class="btn btn-light" data-toggle="tooltip"> <i class="fa fa-heart"></i></a>
	<a href="/shoppingCart${user.id}/delete${c.id}" class="btn btn-light"> Remove</a>
	</td>
</tr>
</c:forEach>

</tbody>
</table>

</div> <!-- table-responsive.// -->

<div class="card-body border-top">
	<p class="icontext"><i class="icon text-success fa fa-truck"></i> Free Delivery within 1-2 weeks</p>
</div> <!-- card-body.// -->

</div> <!-- card.// -->

	</aside> <!-- col.// -->
	<aside class="col-lg-3">

<div class="card mb-3">
<div class="card-body">
<form>
	<div class="form-group">
		<label>Have coupon?</label>
		<div class="input-group">
			<input type="text" class="form-control" name="" placeholder="Coupon code">
			<span class="input-group-append">
				<button class="btn btn-primary">Apply</button>
			</span>
=======
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="#!">Rhythym&Blues</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/">Home</a></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">


						</ul></li>
				</ul>
				<form class="d-flex">
					<a href="/shoppingCart" class="btn btn-outline-dark"> <i
						class="bi-cart-fill me-1"></i> Cart <span
						class="badge bg-dark text-white ms-1 rounded-pill">${cartsize }</span>
					</a>
				</form>
			</div>
>>>>>>> fc5e41263ff591df87244d073f194f08630b69e8
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
	<h1>Shopping Cart for ${user.firstName }</h1>
	<div class="row">
		<aside class="col-lg-9">
			<div class="card">

				<div class="table-responsive">

					<table class="table table-borderless table-shopping-cart">
						<thead class="text-muted">
							<tr class="small text-uppercase">
								<th scope="col">Product</th>
								<th scope="col" width="120">Quantity</th>
								<th scope="col" width="120">Price</th>
								<th scope="col" class="text-right d-none d-md-block" width="200">
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cart}" var="c">
								<tr>
									<td>
										<figure class="itemside align-items-center">
											<div class="aside">
												<img src="images1/${c.product.name}.jpg" class="img-sm">
											</div>
											<figcaption class="info">

												<a href="#" class="title text-dark"><c:out
														value="${c.product.name}" /></a>
												<p class="text-muted small">
													${c.product.description} <br> Brand: ${c.product.brand }
												</p>


											</figcaption>
										</figure>
									</td>
									<td>
										<div class="number">
											<a href="/minus${c.id}"><button>-</button></a> <span><c:out
													value="${c.quantity}" /></span>
											 <a href="/plus${c.id}"><button>+</button></a>
										</div>

										
									</td>
									<td>
										<div class="price-wrap">

											<var class="price">
												$
												<c:out value="${c.total}" />
											</var>
											<small class="text-muted"> $<c:out
													value="${c.product.price}" /> each
											</small>



										</div> <!-- price-wrap .// -->
									</td>
									<td class="text-right d-none d-md-block"><a
										data-original-title="Save to Wishlist" title="" href=""
										class="btn btn-light" data-toggle="tooltip"> <i
											class="fa fa-heart"></i></a> <a
										href="/shoppingCart${user.id}/delete${c.id}"
										class="btn btn-light"> Remove</a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

				</div>
				<!-- table-responsive.// -->

				<div class="card-body border-top">
					<p class="icontext">
						<i class="icon text-success fa fa-truck"></i> Free Delivery within
						1-2 weeks
					</p>
				</div>
				<!-- card-body.// -->

			</div>
			<!-- card.// -->

		</aside>
		<!-- col.// -->
		<aside class="col-lg-3">

			<div class="card mb-3">
				<div class="card-body">
					<form>
						<div class="form-group">
							<label>Have coupon?</label>
							<div class="input-group">
								<input type="text" class="form-control" name=""
									placeholder="Coupon code"> <span
									class="input-group-append">
									<button class="btn btn-primary">Apply</button>
								</span>
							</div>
						</div>
					</form>
				</div>
				<!-- card-body.// -->
			</div>
			<!-- card.// -->

			<div class="card">
				<div class="card-body">
					<dl class="dlist-align">
						<dt>Total price:</dt>
						<dd class="text-right">
							<c:out value="${cartTotal}" />
						</dd>
					</dl>
					<dl class="dlist-align">
						<dt>Discount:</dt>
						<dd class="text-right text-danger">- $0.00</dd>
					</dl>
					<dl class="dlist-align">
						<dt>Total:</dt>

						<dd class="text-right text-dark b">
							<strong>$<c:out value="${cartTotal}" /></strong>
						</dd>
					</dl>
					<hr>
					<p class="text-center mb-3">
						<img src="bootstrap-ecommerce-html/images/misc/payments.png"
							height="26">
					</p>
					<a href="/reviewCart" class="btn btn-primary btn-block"> Make
						Purchase </a> <a href="#" class="btn btn-light btn-block">Continue
						Shopping</a>
				</div>
				<!-- card-body.// -->
			</div>
			<!-- card.// -->

		</aside>
		<!-- col.// -->
	</div>
<<<<<<< HEAD
</form>
</div> <!-- card-body.// -->
</div> <!-- card.// -->

<div class="card">
<div class="card-body">
		<dl class="dlist-align">
		  <dt>Total price:</dt>
		  <dd class="text-right"><c:out value="${cartTotal}"/></dd>
		</dl>
		<dl class="dlist-align">
		  <dt>Discount:</dt>
		  <dd class="text-right text-danger">- 0.00</dd>
		</dl>
		<dl class="dlist-align">
		  <dt>Total:</dt>
		  <dd class="text-right text-dark b"><strong>${cartTotal}</strong></dd>
		</dl>
		<hr>
		<p class="text-center mb-3">
			<img src="bootstrap-ecommerce-html/images/misc/payments.png" height="26">
		</p>
		<a href="/reviewCart${orderItem.id }" class="btn btn-primary btn-block"> Make Purchase </a>
		<a href="/" class="btn btn-light btn-block">Continue Shopping</a>
</div> <!-- card-body.// -->
</div> <!-- card.// -->

	</aside> <!-- col.// -->
</div> <!-- row.// -->
<footer class="section-footer border-top padding-y">
	<div class="container">
		<p>	&copy Copyright 2020 All rights reserved</p>
		<p>	<a href="#">Terms and conditions</a> </p>
	</div><!-- //container -->
</footer>
=======
	<!-- row.// -->
	<footer class="section-footer border-top padding-y">
		<div class="container">
			<p>&copy Copyright 2020 All rights reserved</p>
			<p>
				<a href="#">Terms and conditions</a>
			</p>
		</div>
		<!-- //container -->
	</footer>
>>>>>>> fc5e41263ff591df87244d073f194f08630b69e8
</body>
</html>