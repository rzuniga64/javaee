<%@ page contentType="text/html; charset=UTF-8"
		 language="java"
		 import="com.javabeans.models.*"%>
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
				<jsp:useBean id="wu" class="com.javabeans.models.WebUser"
					scope="request">
					<jsp:setProperty name="wu" property="userId" 
						value='<%=request.getParameter("uid")%>' />
					<jsp:setProperty name="wu" property="password" 
						value='<%=request.getParameter("pwd")%>' />
					<jsp:setProperty name="wu" property="authLevel"
						value="1" />
				</jsp:useBean>

                <%@ include file="useBeans.jsp" %>

			</td>
		</tr>
	</table>
    <%@ include file="footer.jsp" %>
</body>
</html>