<%@ page contentType="text/html; charset=UTF-8"
		 language="java"
		 import="com.javabeans.models.*" %>
<!-- Must import the package the Java bean is in -->
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
                <!-- Must declare the bean here! -->
				<jsp:useBean id="wu" class="com.javabeans.models.WebUser"
                             scope="request"/>

				<h1>Welcome
                    <!-- if bean is not declared the getProperty method will
                         not work on our page because the bean id needs to be
                         recreated when we hit this page. Even though it exists
                         in the request it will go out to the request and just
                         set a reference to that. If it wasn't there it would
                         create a new one. So we need an actual object before
                         calling getProperty on the bean.-->
					<jsp:getProperty name="wu" property="userId" />
				</h1>
			</td>
		</tr>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>