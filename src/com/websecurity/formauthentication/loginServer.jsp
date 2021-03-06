<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
				<form id="login" method="post" action="j_security_check">
					<table style="width:450px;">
						<tr>
							<td>
								<span>UserName:</span>
							</td>
							<td>
								<input name="j_username" type="text" style="width:250px;" value="${cookie.credentials_uid.value}" />
							</td>
						</tr>
						<tr>
							<td>
								<span>Password:</span>
							</td>
							<td>
								<input name="j_password" type="password" style="width:250px;" value="${cookie.credentials_pwd.value}"/>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<input type="submit" value="Sign In" 
								    style="width:250px;" />
							</td>
						</tr>
					</table>
					<input type="hidden" name="dest" value="${param.dest}" />
				</form>
			</td>
		</tr>
	</table>
	<c:import url="footer.jsp">
		<c:param name="copyrightYear" value="${initParam.copyright}" />
		<c:param name="websiteLink" value="${initParam.weblink}" />
	</c:import>
</body>
</html>