<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Add product</title>
		<style>
		mark{
     background-color: #ffffff;
      }
     body {
     font-family: Arial, Helvetica, sans-serif;
     background-image: url("img/add.jpg");
     background-size: cover;
	
}
* {box-sizing: border-box;
}
</style>
		
	</head>
	<body align="center">
		<h1>Add New Product</h1>
		
		<br><br>
		<form action="/save" method="post" modelAttribute="product" >
		<table  align="center" >
			<tr>
				<td>Product Name</td>
				<td><input name= "name" type="text"></td>
			</tr>
			<tr>
				<td>Brand</td>
				<td><input name="brand"  type="text"></td>
			</tr>
			<tr>
				<td>Made In</td>
				<td><input name="madein" type="text"></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input name="price"  type="text" ></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input name="email"  type="text" ></td>
			</tr>
			<tr>
				
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
		</form>
	</body>
</html>