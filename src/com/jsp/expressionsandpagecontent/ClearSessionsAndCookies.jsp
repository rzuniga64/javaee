<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the World Manager</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<%!
		Cookie[] MyCookies;
		String uid = "";
		String pwd = "";
		int authLevel = 0;
	%>
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
				<%@ include file="navbar.jsp" %>
			</td>
			<td style="width:75%;height:80%;">
				<%
					session.invalidate();
					MyCookies = request.getCookies();
					if (MyCookies != null && MyCookies.length > 0) {
						for (Cookie c : MyCookies) {
							if (c.getName().toLowerCase().contains("credentials")) {
								//expire the cookie
								c.setMaxAge(0);
								response.addCookie(c);
							}
						}
					}
				%>
				<h1>Sessions and Cookies Cleared</h1>
			</td>
		</tr>
	</table>
	<!-- jsp:include page="footer.jsp" -->
	<%@ include file="footer.jsp" %>
</body>
</html>