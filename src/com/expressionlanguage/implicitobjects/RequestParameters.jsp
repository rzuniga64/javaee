<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Request Parameters</title>
</head>
<body>
	<jsp:forward page="RequestParameters2.jsp">
		<jsp:param value="rpuid" name="uid"/>
		<jsp:param value="rppwd" name="pwd"/>
	</jsp:forward>
	<jsp:include page="navbar.jsp" />
</body>
</html>