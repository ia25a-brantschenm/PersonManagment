<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDateTime" %>
<%
        LocalDateTime currentDateTime = LocalDateTime.now();

		 int hour = currentDateTime.getHour(); 
		 int minute = currentDateTime.getMinute(); 
		 int second = currentDateTime.getSecond(); 
		 boolean yn = second % 2 == 0;


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World JSP</title>
</head>
<body>

	<h2>Current Time: <%= hour %> : <%= minute %> : <%= second %></h2>
	<h2>Sind die Sekunden Gerade ? : <%= yn  %> </h2>


</body>
</html>