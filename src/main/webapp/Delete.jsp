<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Person</title>
</head>
<body>
<h1>Delete Person</h1>

<form action="personServlet" method="POST">
	<label for="firstname">First name:</label>
	<input type="text" name="firstname">
	<label for="lastname">Last name:</label>
	<input type="text" name="lastname">
	<input type="hidden" name="_method" value="DELETE">
	<button type="submit">Delete Item</button>
</form>



</body>
</html>