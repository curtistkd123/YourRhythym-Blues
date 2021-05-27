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
<body>
	<header class="section-header">
		<section class="header-main border-bottom">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-2 col-4">
						<a href="http://bootstrap-ecommerce.com" class="brand-wrap"> <img
							class="logo" src="images/logo.png">
						</a>
						<!-- brand-wrap.// -->
					</div>
					<div class="col-lg-6 col-sm-12">
						<form action="#" class="search">
							<div class="input-group w-100">
								<input type="text" class="form-control" placeholder="Search">
								<div class="input-group-append">
									<button class="btn btn-primary" type="submit">
										<i class="fa fa-search"></i> Search
									</button>
								</div>
							</div>
						</form>
						<!-- search-wrap .end// -->
					</div>
					<!-- col.// -->
					<div class="col-lg-4 col-sm-6 col-12">
						<div class="widgets-wrap float-md-right">
							<div class="widget-header  mr-3">
								<a href="#" class="icon icon-sm rounded-circle border"><i
									class="fa fa-shopping-cart"></i></a> <span
									class="badge badge-pill badge-danger notify">0</span>
							</div>
							<div class="widget-header icontext">
								<a href="#" class="icon icon-sm rounded-circle border"><i
									class="fa fa-user"></i></a>
								<div class="text">
									<span class="text-muted">Welcome!</span>
									<div>
										<a href="#">Sign in</a> | <a href="#"> Register</a>
									</div>
								</div>
							</div>

						</div>
						<!-- widgets-wrap.// -->
					</div>
					<!-- col.// -->
				</div>
				<!-- row.// -->
			</div>
			<!-- container.// -->
		</section>
		<!-- header-main .// -->
	</header>
	<!-- section-header.// -->
	<div class="container">
		<div class="row align-items-center">
			<div class="col-12 col-lg-8">
			<p>
				<form:errors path="vendor.*" />
			</p>
				<form:form action="/newVendor" method="post" modelAttribute="vendor">
					<div class="form-row">
						<div class="col form-group">
							<label>Company Name</label>
							<form:input path="name" type="text" class="form-control"
								placeholder="" />
						</div>
						<!-- form-group end.// -->
						<div class="col form-group">
							<label>Statement</label>
							<form:input path="description" type="text" class="form-control"
								placeholder="" />
						</div>
						<!-- form-group end.// -->
						<div class="col form-group">
							<label>Address</label>
							<form:input path="address" type="text" class="form-control"
								placeholder="" />
						</div>
						<!-- form-group end.// -->
					</div>
					<!-- form-row end.// -->
					<div class="form-group">
						<label>Email</label>
						<form:input path="email" type="email" class="form-control"
							placeholder="" />
						
					</div>
					<!-- form-group end.// -->
					<div class="form-group">
						<label>Phone</label>
						<form:input path="phoneNumber" type="tel" class="form-control"
							placeholder="" />
					</div>
					<!-- form-group end.// -->

					<div class="form-row">
						<div class="form-group col-md-6">
							<label>Create password</label>
							<form:input path="password" class="form-control" type="password" />
						</div>
						<!-- form-group end.// -->
						<div class="form-group col-md-6">
							<label>Repeat password</label>
							<form:input path="confirmPassword" class="form-control"
								type="password" />
						</div>
						<!-- form-group end.// -->
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block">
							Welcome to your Site</button>
					</div>
					<!-- form-group// -->
					<div class="form-group">
						<label class="custom-control custom-checkbox"> <input
							type="checkbox" class="custom-control-input" checked="">
						
						</label>
					</div>
					<!-- form-group end.// -->
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>