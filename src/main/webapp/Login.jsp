<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
		<title>Idk... Play Hypixel Skyblock...</title>
</head>
<body>

<%
    String name = (String) request.getAttribute("username");
    if (name != null) {
%>
        <h1>Yo yo <%= name %>!</h1>
<%
    } else {
%>
		<h1>Login</h1>
		<form action="Cookie" method="POST">
			<label for="nr1">Name</label>
			<input  type="text" id="name" name="name"><br><br>
			<label for="nr2">Password</label>
			<input  type="text" id="Password" name="password"><br><br>
			<input type="submit" value="Submit">
		</form>
<%
    }
%>

</body>
</html>
