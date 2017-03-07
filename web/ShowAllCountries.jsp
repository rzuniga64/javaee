<%@ page contentType="text/html; charset=UTF-8"
		 language="java"
		 import="java.util.*, com.javabeans.models.*"%>
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
				<table style="width:100%" border="1" >
					<%
						//we still don't have a way to loop...yet
						//so instead, we'll use java code to loop
						ArrayList<Country> allCountries = (ArrayList<Country>)session.getAttribute("AllCountries");
						StringBuilder sb = new StringBuilder("");
						sb.append("<tr><td>Name</td><td>Code</td><td>"
							+ "Region</td><td>Continent</td>");
						for (Country c : allCountries)
						{
							sb.append("<tr>");
							
							sb.append("<td>" + c.getName() + "</td>");
							sb.append("<td>" + c.getCode() + "</td>");
							sb.append("<td>" + c.getRegion() + "</td>");
							sb.append("<td>" + c.getContinent() + "</td>");
							
							sb.append("</tr>");
						}
						out.println(sb);
					%>
				</table>
			</td>
		</tr>
	</table>
    <c:import url="footer.jsp">
        <c:param name="copyrightYear" value="${initParam.copyright}" />
        <c:param name="websiteLink"   value="${initParam.weblink}" />
    </c:import>
</body>
</html>