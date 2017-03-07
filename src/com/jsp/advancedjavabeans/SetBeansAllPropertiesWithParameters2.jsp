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
					<!-- setting property equal to star means to implicitly
					     set every property for incoming parameters. If we do
                         not map them properly by having the exact name of the
                         property as our parameter it won't work.
                    -->
					<jsp:setProperty name="wu" property="*" />
				</jsp:useBean>
				
				<jsp:forward page="useBeansAllPropertiesWithParameters.jsp" />
			</td>
		</tr>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>