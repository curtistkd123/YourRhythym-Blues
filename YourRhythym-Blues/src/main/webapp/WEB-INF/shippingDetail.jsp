<!DOCTYPE HTML>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Payment Detail</title>

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

  <!--Grid row-->
  <div class="row">

    <!--Grid column-->
    <div class="col-lg-8 mb-4">

      <!-- Card -->
      <div class="card wish-list pb-1">
        <div class="card-body">

          <h5 class="mb-2">Shipping details</h5>

          <!-- Grid row -->
          <div class="row">

            <!-- Grid column -->
            <div class="col-lg-6">

              <!-- First name -->
              <div class="md-form md-outline mb-0 mb-lg-4">
                <input type="text" id="firstName" class="form-control mb-0 mb-lg-2">
                <label for="orderShipFirstName">First name</label>
              </div>

            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-lg-6">

              <!-- Last name -->
              <div class="md-form md-outline">
                <input type="text" id="lastName" class="form-control">
                <label for="orderShipLastName">Last name</label>
              </div>

            </div>
            <!-- Grid column -->

          </div>
          <!-- Grid row -->

          <!-- Company name -->
          <div class="md-form md-outline my-0">
            <input type="text" id="orderShipCompanyName" class="form-control mb-0">
            <label for="orderShipCompanyName">Company name (optional)</label>
          </div>



          <!-- Address Part 1 -->
          <div class="md-form md-outline mt-0">
            <input type="text" id="orderShipAddress1" placeholder="House number and street name" class="form-control">
            <label for="orderShipAddress1">Address</label>
          </div>

          <!-- Address Part 2 -->
          <div class="md-form md-outline">
            <input type="text" id="orderShipAddress2" placeholder="Apartment, suite, unit etc. (optional)"
              class="form-control">
            <label for="orderShipAddress2">Address</label>
          </div>

          <!-- Postcode / ZIP -->
          <div class="md-form md-outline">
            <input type="text" id="orderShipZip" class="form-control">
            <label for="orderShipZip">ZIP CODE</label>
          </div>

          <!-- Town / City -->
          <div class="md-form md-outline">
            <input type="text" id="orderShipCity" class="form-control">
            <label for="orderShipCity">City</label>
          </div>
          
               <!-- State -->
          <div class="md-form md-outline">
            <input type="text" id="orderShipState" class="form-control">
            <label for="orderShipState">State</label>
          </div>
          
          <!-- Country -->
          <div class="md-form md-outline">
            <input type="text" id="orderShipCountry" class="form-control">
            <label for="form18">Country</label>
          </div>

          <!-- Phone -->
          <div class="md-form md-outline">
            <input type="number" id="orderPhone" class="form-control">
            <label for="orderPhone">Phone</label>
          </div>

          <!-- Email address -->
          <div class="md-form md-outline">
            <input type="email" id="orderEmail" class="form-control">
            <label for="form20">Email address</label>
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
              <span>insert order total here</span>
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
              <span><strong>insert total times tax</strong></span>
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