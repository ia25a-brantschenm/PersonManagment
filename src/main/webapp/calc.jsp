<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>I'm a Calculator</title>
</head>
<body>
	<h1>Calc</h1>
	    <form action="calc" method="POST">
            <label for="nr1">Num1:</label>
            <input  type="text" id="nr1" name="nr1"><br><br>
            <label for="nr2">Num2:</label>
            <input  type="text" id="nr2" name="nr2"><br><br>
            <label for="op">Operation:</label>
            <input  type="text" id="op" name="op"><br><br>
            <input type="submit" value="Submit">
        </form>
	
</body>
</html>