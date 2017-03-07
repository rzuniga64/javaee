<%@ page contentType="text/html;charset=UTF-8"
		 language="java"
		 import="com.javabeans.models.*
    		, com.servlets.dbhelpers.*
    		, com.servlets.models.*
    		, java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="wm" uri="WorldManagerTags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to the World Manager</title>
</head>
<body>
	<c:import url="../header.jsp" />
	<c:choose>
		<c:when test="${sessionScope.cityData eq null}">
			<jsp:forward page="getcitydata.do" />
		</c:when>
		<c:otherwise>
			<h1><c:out value="Welcome Back ${sessionScope.authorized_user.userId}" /></h1>
		</c:otherwise>
	</c:choose> 
	
	
	<!-- otherwise, move forward for data display -->
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
				<c:import url="../navbar.jsp" />
			</td>
			<td style="width:75%;height:80%;">
				<table border=1> 
					<tr>
						<td>ID</td>
						<td>NAME</td>
						<td>COUNTRY_CODE</td>
						<td>DISTRICT</td>
						<td>POPULATION</td>
					</tr>
					
					<wm:cityiterator cityList="${sessionScope.cityData}">
						<tr>
							<td>${city.id}</td>
							<td>${city.name}</td>
							<td>${city.countryCode}</td>
							<td>${city.district}</td>
							<td>${city.population}</td>
						</tr>
					</wm:cityiterator>
					
					
				</table>
			</td>
		</tr>
	</table>
	<c:import url="../footer.jsp">
		<c:param name="copyrightYear" value="${initParam.copyright}" />
		<c:param name="websiteLink" value="${initParam.weblink}" />
	</c:import>
</body>
</html>