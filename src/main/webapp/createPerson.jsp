<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Person</title>
<link rel='stylesheet' type='text/css' href='test.css'>
</head>
<body>
<div class="grid-container">
	<div class="plane">
		<div class="grid"></div>
		<div class="glow"></div>
	</div>
	<div class="plane">
		<div class="grid"></div>
		<div class="glow"></div>
	</div>
</div>
<h1>Create Person</h1>

<form action="personServlet" method="POST">
<label for="firstname">First name:</label>
<input type="text" name="firstname">
<label for="lastname">Last name:</label>
<input type="text" name="lastname">
<input type="Submit" name="Submit">


</form>


</body>
</html>