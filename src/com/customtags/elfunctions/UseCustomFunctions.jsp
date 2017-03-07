<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="wmelf" uri="WorldManagerELFunctions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Demonstrate Custom EL Functions</title>
</head>
<body>
	<h2>SQUARE of 2.0:</h2>
	<span>${wmelf:square(2.0)}</span>
	<h2>CUBE of 2.0:</h2>
	<span>${wmelf:cube(2.0)}</span>
	<h2>SQUARE ROOT of 16.0</h2>
	<span>${wmelf:sqrt(16.0)}</span>
</body>
</html>