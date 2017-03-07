<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome to the World Manager</title>
</head>
<body>
	<c:import url="header.jsp" />
	
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
				<c:import url="navbar.jsp" />
			</td>
			<td style="width:75%;height:80%;">
				<h1>Welcome to the World manager web system</h1>
				<%
					if (session.getAttribute("authorized_user") != null) {
						%>
						<h2>Welcome back ${sessionScope.authorized_user.userId}</h2>
						<%
					} else {
						%>
							<h2>Returning users login</h2>
							<a href="login.jsp">here</a>
						<%
					}
				%>
			</td>
		</tr>
	</table>
	<c:import url="footer.jsp" />
		<c.param name="copyrightYear" value="${initParam.copyright}"></c.param>
		<c.param name="websiteLink" value="${initParam.weblink}"></c.param>

</body>
</html>