<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
				<h1>Welcome to the World manager web system</h1>
				<%
					if (session.getAttribute("authorized_user") != null)
					{
						%>
						<h2>Welcome back ${sessionScope.authorized_user.userId}</h2>
						<%
					}
					else
					{
						%>
							<h2>Returning users login</h2>
							<a href="login.jsp">here</a>
						<%
					}
				%>
			</td>
		</tr>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>