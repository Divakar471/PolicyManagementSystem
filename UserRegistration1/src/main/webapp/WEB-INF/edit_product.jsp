<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Edit product</title>
		<style>
		mark{
     background-color: #ffffff;
      }
     body {font-family: Arial, Helvetica, sans-serif;
     background-image: url("img/edit.jpg");
     background-size: cover;}
* {box-sizing: border-box;
}
</style>
		
		
	</head>
	<body align="center">
		<h1>Edit Product</h1>
		
		<br><br>
		<form  method="post" action="/save" modelAttribute="product" >
		<table  align="center" >
			<tr>
				<td>Product Id</td>
				<td><input name= "id" type="text" value=${product.id} readonly="readonly"></td>
			</tr>
			<tr>
				<td>Product Name</td>
				<td><input name= "name" type="text" value=${product.name} ></td>
			</tr>
			<tr>
				<td>Brand</td>
				<td><input name="brand" type="text" value=${product.brand}></td>
			</tr>
			<tr>
				<td>Made In</td>
				<td><input name="madein" type="text" value=${product.madein} ></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input name="price" type="text" value=${product.price}></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input name="email" type="text" value=${product.email}></td>
			</tr>
			<tr>
				
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
		</form>
	</body>
</html>