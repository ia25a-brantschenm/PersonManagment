<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Person</title>
<title>Main Site</title>
<link rel='stylesheet' type='text/css' href='test2.css'>
<script>
function deletePerson(uuid) {
	let parameter = {
	        method: "DELETE"
	    }
	    fetch(("personServlet?uuid=" + uuid), parameter)
        location.reload();
    }
</script>
</head>
<body>

<div class="stars"></div>
<div class="shooting-star"></div>
<div class="shooting-star"></div>
<div class="shooting-star"></div>
<div class="shooting-star"></div>
<div class="shooting-star"></div>


<c:forEach var="Person" items="${PersonList}">
	
	<ul>
		<li>${Person.firstname}, ${Person.lastname}, ${Person.uuid}  <button onclick="deletePerson('${Person.uuid}')">Delete</button></li>
	</ul>
	
</c:forEach>
<form action="personServlet" method="GET">
<input type="Submit" name="Submit">
</form>
<button><a href="http://localhost:8080/TestProject/Main.jsp">Back Person</a></button>

</body>
</html>