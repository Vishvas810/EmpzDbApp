<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<style>
body {
	background-color: #f4f4f4;
	font-family: Arial, sans-serif;
}

.container {
	margin-top: 50px;
}

.card {
	border-radius: 10px;
	box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
	padding: 20px;
}

.navbar {
	margin-bottom: 20px;
}

.table {
	margin-top: 20px;
}

.btn {
	margin: 5px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container">
			<a class="navbar-brand" href="index.jsp">Employee Management</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="insert.jsp">Add
							Employee</a></li>
					<li class="nav-item"><a class="nav-link" href="read">Display
							Employees</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container text-center">
		<div class="card bg-light">
			<h2 class="text-danger">Welcome To Lambton Employees DB App</h2>
			<p>Manage your employees efficiently with our system.</p>
			<a class="btn btn-primary" href="insert.jsp">Add Employee</a> <a
				class="btn btn-success" href="read">View Employees</a>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
