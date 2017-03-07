<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
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
					//get uid/pwd from cookie/session
					//HttpSession s = request.getSession();
					if (session.getAttribute("uid") == null || session.getAttribute("uid").equals("")) {
						//try to use cookies
						MyCookies = request.getCookies();
						if (MyCookies != null) {
							for (Cookie c : MyCookies) {
								if (c.getName().equalsIgnoreCase("credentials_uid")) {
									//set the uid from cookie value
									uid = c.getValue();
								} else if (c.getName().equalsIgnoreCase("credentials_pwd")) {
									//set the pwd from cookie value
									pwd = c.getValue();
								}
							}
						}
					} else {
						//use sessions
						uid = (String)session.getAttribute("uid");
						pwd = (String)session.getAttribute("pwd");
					}
				%>
				<form id="form1" method="post" action="loginuser.do">
					<table style="width:450px;">
						<tr>
							<td>
								<span>UserName:</span>
							</td>
							<td>
								<input name="uid" type="text" style="width:250px;" value="<%=uid%>" />
							</td>
						</tr>
						<tr>
							<td>
								<span>Password:</span>
							</td>
							<td>
								<input name="pwd" type="password" style="width:250px;" value="<%=pwd%>" />
							</td>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<input name="rememberMe" type="checkbox">&nbsp;Remember Me
							</td>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<input type="submit" value="Sign In" 
								    style="width:250px;" />
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>