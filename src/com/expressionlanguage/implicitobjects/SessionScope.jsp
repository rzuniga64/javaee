<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<jsp:text>
		Hello ${sessionScope.uid}
	</jsp:text>
	<br>	
	Access Code: ${sessionScope.pwd}
	<br>
	<br><br>
	<jsp:include page="navbar.jsp" />
</body>
</html>