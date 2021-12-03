<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Product Manager</title>
		<style>
		mark{
     background-color: #ffffff;
      }
     body {
     font-family: Arial, Helvetica, sans-serif;
     background-image: url("img/item.jpg");
     background-size: cover;
	
}
* {box-sizing: border-box;
}
</style>
	</head>
	<body align="center">
		<h1>Item Management</h1>
		<a href="new">Add New Product</a>
		<br><br>
		<table border="1" align="center" cellpadding="10">
			<thead>
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Brand</th>
					<th>Made IN</th>
					<th>Price</th>
					<th>Email Id</th>
					<th>Activities</th>
				</tr>
			</thead>
			<tbody>
				 <c:forEach items="${listProducts}" var="product">
					<tr>
					<td>${product.getId()}</td>
					<td>${product.getName()}</td>
					<td>${product.getBrand()}</td>
					<td>${product.getMadein()}</td>
					<td>${product.getPrice()}</td>
					<td>${product.email}</td>
					<td>
						<a href="/+${product.id}">Edit</a>
						<a href="/delete/+${product.id}">Delete</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>