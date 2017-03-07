<%@ page contentType="text/html; charset=UTF-8" language="java" %>
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
				<% 
					//page context default scope is page.  it will not work on anything
					//but the page.  The pageContext does allow access at other scopes, however
					//set a page context attribute
					pageContext.setAttribute("LostCode", "74185296");
					//set a page context application attribute:
					pageContext.setAttribute("SecretCode", "12345678", pageContext.APPLICATION_SCOPE);
					//set a new session attribute
					pageContext.setAttribute("SessionCode", "258369147", pageContext.SESSION_SCOPE);	
					
					//set a request attribute
					request.setAttribute("AnotherCode", "55544433");
					
					//set a destination with a QS Param
					String destination = "SecondPage.jsp?key=98765432";
					
					//try with redirect
					response.sendRedirect(destination);
							
					//try with dispatcher: GENERATES AND EXCEPTION
					// RequestDispatcher rd = request.getRequestDispatcher(destination);
					// rd.forward(request,response);
					
					//use page context
					//pageContext.forward works like RequestDispatcher:
					//pageContext.forward(destination);
				%>
			</td>
		</tr>
	</table>
	<!-- jsp:include page="footer.jsp" -->
	<%@ include file="footer.jsp" %>
</body>
</html>