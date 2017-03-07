<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome to the World Manager</title>
</head>
<body>
    <c:import url="header.jsp" />
	<%!
		Cookie[] MyCookies;
		String uid = "";
		String pwd = "";
		int authLevel = 0;
	%>
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
                <c:import url="navbar.jsp" />
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
	<c:import url="footer.jsp">
		<c:param name="copyrightYear" value="${initParam.copyright}" />
		<c:param name="websiteLink"   value="${initParam.weblink}" />
	</c:import>
</body>
</html>