<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cookies!</title>
</head>
<body>
	Hello ${cookie["credentials_uid"].value}
	<br>	
	Access Code: ${cookie.credentials_pwd.value}
	<br>
	<br><br>
	<jsp:include page="navbar.jsp" />
</body>
</html>