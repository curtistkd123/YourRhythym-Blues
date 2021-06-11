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
<title>Category</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->

</head>

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

<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
	<c:choose>
    <c:when test="${products.size() ==0}">
        <h3>No items in Category</h3>
        <br />
    </c:when>    
    <c:otherwise>
				<c:forEach items="${products }" var="p">
	<div class="col-md-3 col-sm-6">
		<figure class="card card-product-grid">
			<div class="img-wrap"> <img src= src="images1/${p.name}.jpg" alt="..." > </div>
			<figcaption class="info-wrap border-top">
				<a href="/showProduct{p.id}" class="title">${p.name }</a>
				<div class="price mt-2">$ ${p.price }</div> <!-- price-wrap.// -->
			</figcaption>
		</figure> <!-- card // -->
	</div> <!-- col.// -->

			</c:forEach>
			</c:otherwise>
		</c:choose>
	</div> <!-- col.// -->
</div><!-- row.// -->


</body>
</html>