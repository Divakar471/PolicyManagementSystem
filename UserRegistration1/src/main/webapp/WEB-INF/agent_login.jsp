<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<style>  
h3{
  font-family: Calibri; 
  font-size: 25pt;         
  font-style: normal; 
  font-weight: bold; 
  color:#FFFFFF;
  text-align: center; 
  
}
body {font-family: Arial, Helvetica, sans-serif;
background-image: url("img/login.jpg");
background-size: cover;
}
* {box-sizing: border-box;}

</style> 
</head>
<body>

<h3>Login Page</h3>

	${error}
	<form method="post" action="${pageContext.request.contextPath }/agent_login">
		
		<table border="0" cellpadding="2" cellspacing="2">
			<tr>
				<td>Token-ID</td>
				<td><input type="text" name="tokenid"></td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>

</body>
</html>
