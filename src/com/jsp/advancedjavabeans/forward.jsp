<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome to the World Manager</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
				<jsp:include page="navbar.jsp" />
			</td>
			<td style="width:75%;height:80%;">
				<jsp:forward page="forward2.jsp">
					<jsp:param value="10110101" name="secretCode"/>
					<jsp:param value="webuser" name="uid"/>
				</jsp:forward>
			</td>
		</tr>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>