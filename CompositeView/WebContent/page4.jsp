<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>...composite_view</title>
<link rel="stylesheet" type="text/css" href="css_file.css">
</head>


<body>
	<jsp:include page = "/headerurl"/>
	<main class="main">
		<%@include file = "left.html" %>
		<jsp:include page="sensex.jsp"/>
		<%@include file= "right.html" %>
	</main>
	<%@include file= "footer.html" %>
</body>
</html>