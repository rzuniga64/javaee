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
				<form id="login" method="post" action="loginuser.do">
					<table style="width:450px;">
						<tr>
							<td>
								<span>UserName:</span>
							</td>
							<td>
								<input name="uid" type="text" style="width:250px;" value="${cookie.credentials_uid.value}" />
							</td>
						</tr>
						<tr>
							<td>
								<span>Password:</span>
							</td>
							<td>
								<input name="pwd" type="password" style="width:250px;" value="${cookie.credentials_pwd.value}"/>
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
					<input type="hidden" name="dest" value="${param.dest}" />
				</form>
			</td>
		</tr>
	</table>
</body>
</html>