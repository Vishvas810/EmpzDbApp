<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.cestar.model.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />

<style>
body {
	background-color: #f8f9fa;
}

.container {
	max-width: 500px;
	margin-top: 50px;
	background: white;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
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

	<div class="container">
		<h2 class="text-center text-primary">Edit Employee</h2>

		<%
		Employee emp = (Employee) session.getAttribute("employee_to_edit");
		%>

		<form action="update" method="get">
			<div class="mb-3">
				<label for="e_id" class="form-label">Employee ID</label> <input
					type="text" id="e_id" name="e_id" class="form-control"
					value="<%=emp.getId()%>" readonly>
			</div>
			<div class="mb-3">
				<label for="e_name" class="form-label">Employee Name</label> <input
					type="text" id="e_name" name="e_name" class="form-control"
					value="<%=emp.getName()%>">
			</div>
			<div class="mb-3">
				<label for="e_con" class="form-label">Employee Contact</label> <input
					type="text" id="e_con" name="e_con" class="form-control"
					value="<%=emp.getContact()%>">
			</div>
			<div class="mb-3">
				<label for="e_city" class="form-label">Employee City</label> <input
					type="text" id="e_city" name="e_city" class="form-control"
					value="<%=emp.getCity()%>">
			</div>
			<div class="mb-3">
				<label for="e_email" class="form-label">Employee Email</label> <input
					type="email" id="e_email" name="e_email" class="form-control"
					value="<%=emp.getEmail()%>">
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary">Update
					Employee</button>
			</div>
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
