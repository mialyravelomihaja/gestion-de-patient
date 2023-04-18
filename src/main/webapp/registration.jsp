<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Ajout consultation</title>

<!-- navbar -->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/index-styles.css" rel="stylesheet" />

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">

</head>
<body>

<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="#page-top">Gestion Medical</a>
			<button
				class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded"
				type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="#portfolio">Galerie</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="#about">A Propos</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="registration.jsp">Consultation</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="logout">Logout</a></li>
					<li class="nav-item mx-0 mx-lg-1 bg-danger"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="logout"><%=session.getAttribute("nom") %>></a></li>
					
				</ul>
			</div>
		</div>
	</nav>

<input type="hidden" id="status" value="<%=request.getAttribute("status") %>">

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Consultation</h2>
					
						<form method="post" action="enregistrer" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="nom"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="nom" id="nom" placeholder="Nom" />
							</div>
							<div class="form-group">
								<label for="prenom"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="prenom" id="prenom" placeholder="Prenom" />
							</div>
							<div class="form-group">
								<label for="age"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="age" id="age" placeholder="Age" />
							</div>
							
							<div class="form-group">
								<label for="telephone"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="telephone" id="telephone"
									placeholder="Telephone" />
							</div>
							<div class="form-group">
								<label for="date"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="date" name="date" id="date"
									placeholder="date" />
							</div>
							<div class="form-group">
								<label for="resultat"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="resultat" id="resultat"
									placeholder="Resultat" />
							</div>
							
							<div class="form-group form-button">
								<input type="submit" name="ajout" id="ajout"
									class="form-submit" value="Enregistrer" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="login.jsp" class="signup-image-link">
							</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	<script type="text/javascript">
	var status = document.getElementById("status").value;
	if(status =="success"){
		swal("Super", "insertion reussit");
	}
	</script>



</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>