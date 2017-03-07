<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome to the World Manager</title>
</head>
<body>
    <%@ include file="header.jsp" %>
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
                <%@ include file="navbar.jsp" %>
			</td>
			<td style="width:75%;height:80%;">
                <!-- We can forward to another file using JSP. -->
				<jsp:forward page="forward2.jsp">
                    <!-- We can set request parameters in our page using JSP -->
					<jsp:param value="10110101" name="secretCode"/>
					<jsp:param value="webuser" name="uid"/>
				</jsp:forward>
			</td>
		</tr>
	</table>
    <%@ include file="footer.jsp" %>
</body>
</html>