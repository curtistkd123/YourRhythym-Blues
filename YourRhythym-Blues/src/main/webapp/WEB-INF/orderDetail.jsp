<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Order Detail</title>

<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">

<!-- jQuery  -->
<script src="js/jquery-2.0.0.min.js" type="text/javascript"></script>

<!-- Bootstrap files-->
<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>

<!-- Font awesome 5 -->
<link href="fonts/fontawesome/css/all.min.css" type="text/css" rel="stylesheet">

<!-- custom style -->
<link href="css/ui.css" rel="stylesheet" type="text/css"/>
<link href="css/responsive.css" rel="stylesheet" />

<!-- custom javascript -->
<script src="js/script.js" type="text/javascript"></script>

</head>
<body>
<header class="section-header">
	<div class="container">
		<a href="#" class="brand-wrap"><img class="logo" src="images/logo.png"></a>
	</div> <!-- container.// -->
</header>

<!--Section: Block Content-->
<section>
	<form:form method="POST" action="orderDetail" modelAttribute="order">
  <!--Grid row-->
  <div class="row">

    <!--Grid column-->
    <div class="col-lg-8 mb-4">

      <!-- Card -->
      <div class="card wish-list pb-1">
        <div class="card-body">

          <h5 class="mb-2">Billing details</h5>

          <!-- Grid row -->
          <div class="row">
			
            <!-- Grid column -->
            <div class="col-lg-6">
			
              <!-- First name -->
              <div class="md-form md-outline mb-0 mb-lg-4">
              	<form:label path="orderFirstName">First name</form:label>
              	<form:errors path="orderFirstName"/>
                <form:input type="text" path="orderFirstName" class="form-control mb-0 mb-lg-2"/>
                
              </div>

            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-lg-6">

              <!-- Last name -->
              <div class="md-form md-outline">
                <form:label path="orderLastName">Last name</form:label>
                <form:errors path="orderLastName"/>
                <form:input type="text" path="orderLastName" class="form-control"/>
                
              </div>

            </div>
            <!-- Grid column -->

          </div>
          <!-- Grid row -->

          <!-- Company name -->
          <div class="md-form md-outline my-0">
             <form:label path="orderCompanyName">Company name (optional)</form:label>
             <form:errors path="orderCompanyName"/>
             <form:input type="text" path="orderCompanyName" class="form-control mb-0"/>
           
          </div>



          <!-- Address Part 1 -->
          <div class="md-form md-outline mt-0">
           <form:label path="orderAddress1">Address line 1</form:label>
           <form:errors path="orderAddress1"/> 
           <form:input type="text" path="orderAddress1" placeholder="House number and street name" class="form-control"/>
            
          </div>

          <!-- Address Part 2 -->
          <div class="md-form md-outline">
          	 <form:label path="orderAddress2">Address line 2</form:label>
            <form:input type="text" path="orderAddress2" placeholder="Apartment, suite, unit etc. (optional)"
              class="form-control"/>
              <form:errors path="orderAddress2"></form:errors>
      
          </div>

          <!-- Postcode / ZIP -->
          <div class="md-form md-outline">
            <form:label path="orderZip">ZIP CODE</form:label>
            <form:input type="text" path="orderZip" class="form-control"/>
            <form:errors></form:errors>
            
          </div>

          <!-- Town / City -->
          <div class="md-form md-outline">
             <form:label path="orderCity">City</form:label>
             <form:input type="text" path="orderCity" class="form-control"/>
            <form:errors path="orderCity"></form:errors>
          </div>
          
               <!-- State -->
          <div class="md-form md-outline">
            <form:label path="orderState">State</form:label>
            <form:input type="text" path="orderState" class="form-control"/>
            <form:errors path="orderState"></form:errors>
          </div>
          
          <!-- Country -->
          <div class="md-form md-outline">
            <form:label path="orderCountry">Country</form:label>
            <form:input type="text" path="orderCountry" class="form-control"/>
            <form:errors path="orderCountry"></form:errors>
          </div>

          <!-- Phone -->
          <div class="md-form md-outline">
            <form:label path="orderPhone">Phone</form:label>
            <form:input type="number" path="orderPhone" class="form-control"/>
  			<form:errors  path="orderPhone"/>      
          </div>

          <!-- Email address -->
          <div class="md-form md-outline">
            <form:label path="orderEmail">Email address</form:label>
            <form:input type="email" path="orderEmail" class="form-control"/>
            <form:errors path="orderEmail"></form:errors>
          </div>



        </div>
      </div>
      <!-- Card -->

    </div>
    <!--Grid column-->

    <!--Grid column-->
    <div class="col-lg-4">

      <!-- Card -->
      <div class="card mb-4">
        <div class="card-body">

          <h5 class="mb-3">The total amount of</h5>
			
          <ul class="list-group list-group-flush">
            <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
             Subtotal
              <span>$ ${Math.round(cartTotal*100.00)/100.00 }</span>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-center px-0">
              Shipping
              <span>$25.00</span>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
              <div>
                <strong>The total amount of</strong>
                <strong>
                  <p class="mb-0">(including Tax)</p>
                </strong>
              </div>
              <span><strong>$ ${Math.round(.05/cartTotal)*100.00  + (Math.round(cartTotal*100.00)/100.00) + 25 }</strong></span>
            </li>
          </ul>
	
          <button type="button" class="btn btn-primary btn-block waves-effect waves-light">Make purchase</button>

        </div>
      </div>
      <!-- Card -->


    </div>
    <!--Grid column-->

  </div>
  <!--Grid row-->
</form:form>
</section>
<!--Section: Block Content-->
<!-- ========================= SECTION CONTENT END// ========================= -->

<footer class="section-footer border-top padding-y">
	<div class="container">
		<p>	&copy Copyright 2020 All rights reserved</p>
		<p>	<a href="#">Terms and conditions</a> </p>
	</div><!-- //container -->
</footer>
</body>
</html>