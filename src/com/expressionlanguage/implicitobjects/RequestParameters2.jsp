<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>RP2</title>
</head>
<body>
	<h1>All Parameters</h1>
	${paramValues}
	
	<h1>UID</h1>
	${param.uid}
	<h1>PWD</h1>
	${param.pwd}
	<br><br>
	<jsp:include page="navbar.jsp" />
</body>
</html>