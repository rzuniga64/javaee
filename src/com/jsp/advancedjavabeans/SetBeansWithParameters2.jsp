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
				<jsp:useBean id="wu" class="com.javabeans.models.WebUser"
					scope="request">
					<jsp:setProperty name="wu" property="userId" param="uid" />
					<jsp:setProperty name="wu" property="password" param="pwd" />
					<jsp:setProperty name="wu" property="authLevel" value="1" />
				</jsp:useBean>
				
				<jsp:forward page="useBeansWithParameters.jsp" />
			</td>
		</tr>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>