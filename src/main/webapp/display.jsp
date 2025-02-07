<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.cestar.model.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Employees</title>
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
	margin-top: 30px;
}

.table {
	background-color: white;
	border-radius: 8px;
	overflow: hidden;
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
					<li class="nav-item"><a class="nav-link active" href="read">Display
							Employees</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<h2 class="text-center text-primary">Employee List</h2>

		<table class="table table-striped table-bordered">
			<thead class="table-dark">
				<tr>
					<th>Employee Id</th>
					<th>Name</th>
					<th>Contact</th>
					<th>City</th>
					<th>Email</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Employee> emps = (List<Employee>) session.getAttribute("empz_from_db");
				%>
				<%
				for (Employee emp : emps) {
				%>
				<tr>
					<td><%=emp.getId()%></td>
					<td><%=emp.getName()%></td>
					<td><%=emp.getContact()%></td>
					<td><%=emp.getCity()%></td>
					<td><%=emp.getEmail()%></td>
					<td><a class="btn btn-warning btn-sm"
						href="edit?emp_id=<%=emp.getId()%>">Edit</a></td>
					<td><a class="btn btn-danger btn-sm"
						href="delete?emp_id=<%=emp.getId()%>">Delete</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<div class="text-center">
			<a class="btn btn-success" href="insert.jsp">Add Employee</a>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
