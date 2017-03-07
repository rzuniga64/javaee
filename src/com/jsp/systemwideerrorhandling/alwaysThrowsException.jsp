<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         errorPage="../pagedirectiveerrors/errorHandler.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Bad Page</title>
</head>
<body>
	<jsp:forward page="/simulateException.do" />
</body>
</html>