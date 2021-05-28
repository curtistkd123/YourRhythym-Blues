<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="max-age=604800" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Website title - bootstrap html template</title>

<link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon">

<!-- jQuery -->
<script src="js/jquery-2.0.0.min.js" type="text/javascript"></script>

<!-- Bootstrap4 files-->
<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />

<!-- Font awesome 5 -->
<link href="fonts/fontawesome/css/all.min.css" type="text/css"
	rel="stylesheet">

<!-- custom style -->
<link href="css/ui.css" rel="stylesheet" type="text/css" />
<link href="css/responsive.css" rel="stylesheet"
	media="only screen and (max-width: 1200px)" />

<!-- custom javascript -->
<script src="js/script.js" type="text/javascript"></script>

<script type="text/javascript">
	/// some script

	// jquery ready start
	$(document).ready(function() {
		// jQuery code

	});
	// jquery end
</script>

</head>
<body>


	<header class="section-header bg-dark">


		<section class="header-main border-bottom">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-2 col-4">
						<a href="http://bootstrap-ecommerce.com" class="brand-wrap"> <img
							class="logo" src="images1/mainimage.jpg">
						</a>
						<!-- brand-wrap.// -->
					</div>
					<div class="col-lg-6 col-12 text-center">
						<h1>Rhythym&Blues</h1>
					</div>


				</div>
				<!-- row.// -->
			</div>
			<!-- container.// -->
		</section>
		<!-- header-main .// -->
	</header>
	<!-- section-header.// -->



	<!-- ========================= SECTION CONTENT ========================= -->
	<section class="section-content padding-y">

		<!-- ============================ COMPONENT REGISTER   ================================= -->
		<div class="card mx-auto" style="max-width: 520px; margin-top: 40px;">
			<div class="card-body bg-light">
				<h4 class="card-title mb-4">Profile</h4>
				<p>
					<form:errors path="product.*" />
				</p>
				<form:form action="/newProduct" method="Post" modelAttribute="product" enctype="multipart/form-data">
					<div class="form-group">
						<img src="bootstrap-ecommerce-html/images/avatars/avatar1.jpg"
							class="img-sm rounded-circle border">
					</div>
					<div class="form-row">
						<div class="col form-group">
							<label>Product Name</label>
							<form:input path="name" type="text" class="form-control"
								placeholder="product name" />
						</div>
						<!-- form-group end.// -->
						<div class="col form-group">
							<label>Brand:</label>
							<form:input path="brand" type="text" class="form-control"
								placeholder="enter brand" />
						</div>
						<!-- form-group end.// -->
						<div class="col-12 form-group">
							<label>Description</label>
							<form:input path="description" type="textarea"
								class="form-control" placeholder="description" />
						</div>
						<!-- form-group end.// -->
					</div>
					<!-- form-row end.// -->
					<div class="form-group">
						<label>Price</label>
						<form:input path="price" type="number" step="0.01" class=" col-3 form-control"
							placeholder="0.00" />

					</div>
					<div class="col-12 form-group">
						<label>Category</label>
						<form:select path="category" type="text" class="form-control"
							placeholder="" >
							<c:forEach items="${categories}" var="c"> 							
							<form:option value="${c.id}"><c:out value="${c.name}"/></form:option></c:forEach>
											
						</form:select>
					</div>
					<!-- form-group end.// -->
					<label class="bg-dark">Upload Images:</label>
					<input type="file" path="images" name="images" size="50" accept="image/png, image/jpeg, image/jpg">
					
					<button class="btn btn-primary btn-block">Add Product</button>
				</form:form>
				<h5>Dont see your Category? Add it here</h5>
				<form:form name="category" action="/addCategory" method="post">
				<input type="text" name="category" placeholder="category name">
				 <input type="submit" value="Add" class="btn">
				</form:form>
			
			</div>
			<!-- card-body.// -->
		</div>
		<!-- card .// -->

		<br> <br>
		<!-- ============================ COMPONENT REGISTER  END.// ================================= -->


	</section>
	<!-- ========================= SECTION CONTENT END// ========================= -->


	<!-- ========================= FOOTER ========================= -->
	<footer class="section-footer border-top padding-y">
		<div class="container">
			<p class="float-md-right">&copy Copyright 2019 All rights
				reserved</p>
			<p>
				<a href="#">Terms and conditions</a>
			</p>
		</div>
		<!-- //container -->
	</footer>
	<!-- ========================= FOOTER END // ========================= -->



</body>
</html>
