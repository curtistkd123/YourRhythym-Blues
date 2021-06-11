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
<title>Shop Homepage - Start Bootstrap Template</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
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
</head>
<body>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<c:choose>
				<c:when test="${user.id==null}">
					<a class="navbar-brand " href="/register"><button>Create
							Profile</button></a>
				</c:when>

				<c:otherwise>
					<c:out value="${user.firstName }" />, <a
						class="navbar-brand " href="/edituser${user.id}"><button>Edit
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
								<li><a class="dropdown-item" href="/categories${c.id}"><c:out
											value="${c.name}" /></a></li>
							</c:forEach>
							<li><a class="dropdown-item" href="">Popular Items</a></li>
							<li><a class="dropdown-item" href="#!">New Arrivals</a></li>
						</ul></li>
				</ul>
				<form:form action="/shoppingCart${user.id}" method="get"
					class="d-flex">

					<button class="btn btn-outline-dark"
						onclick="/shoppingCart${user.id}" type="submit">
						<i class="bi-cart-fill me-1"></i> Cart <span
							class="badge bg-dark text-white ms-1 rounded-pill"><c:out
								value="${cartsize }" /></span>
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
	<!-- Section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div class="row justify-content-center">
				<div id="carousel1_indicator" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carousel1_indicator" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel1_indicator" data-slide-to="1"></li>
						<li data-target="#carousel1_indicator" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<a href="/categories${1}"><img class="d-block w-100 carouselpictures" style="width:386" src="images1/guitars.jpg"
								alt="First slide"></a>
						</div>
						<div class="carousel-item">
							<a href="/categories${4}"><img class="d-block w-100 carouselpictures" src="images1/amplifiers.jpg"
								alt="Second slide"></a>
						</div>
						<div class="carousel-item">
							<a href="/categories${3}"><img class="d-block w-100 carouselpictures" src="images1/accessories.jpg"
								alt="Third slide"></a>
						</div>
					</div>
					<a class="carousel-control-prev" href="#carousel1_indicator"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carousel1_indicator"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<c:choose>
					<c:when test="${products.size() ==0}">
						<h3>No items in Category</h3>
						<br />
					</c:when>
					<c:otherwise>
						<c:forEach items="${products }" var="p">
							<div class="col mb-5">
								<div class="card h-100 product">
									<!-- Product image-->
									<img class="card-img-top" src="images1/${p.name}.jpg" alt="..." />
									<!-- Product details-->
									<div class="card-body p-4">
										<div class="text-center">
											<!-- Product name-->
											<h5 class="fw-bolder">
												<c:out value="${p.name }" />
											</h5>
											<!-- Product price-->
											$
											<c:out value="${p.price }" />
										</div>
									</div>
									<!-- Product actions-->
									<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
										<div class="text-center">
											<a class="btn btn-outline-dark mt-auto"
												href="/addCartItem${p.id}">Add to Cart</a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</section>
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2021</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js1/scripts.js"></script>
	<script src="js/jquery-2.0.0.min.js" type="text/javascript"></script>

<!-- Bootstrap -->
<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>

<!-- custom javascript -->
<script src="js/script.js" type="text/javascript"></script>
</body>
</html>