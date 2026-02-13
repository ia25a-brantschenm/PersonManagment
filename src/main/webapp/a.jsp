<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
 
<%
    ArrayList<String> names = new ArrayList<String>();
 
    names.add("Marco");
    names.add("David");
    names.add("Christian");
    names.add("Giona");
%>
<!DOCTYPE html>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='Style.css'>
    <title>Namen</title>
</head>
<body>
 
<h1>Namen</h1>
 
<ol>
<%
    for(String n : names){
%>
        <li><%= n %></li>
<%
    }
%>
</ol>
</body>
</html>
 