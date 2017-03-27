<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SQL</title>
</head>
<body>
	<table style="width:100%">
		<tr>
			<td style="width:30%">Tag</td>
			<td style="width:70%">Example</td>
		</tr>
		<tr>
			<td>setDataSource</td>
			<td><sql:setDataSource var="worlddata" driver="com.mysql.jdbc.Driver"
				url="${initParam.dburl}"
				user="${initParam.dbuserid}"
				password="${initParam.dbuserpwd}" />
				[see code]
			</td>
		</tr>
		<tr>
			<td>query</td>
			<td><sql:query dataSource="${worlddata}"
			     sql="select * from city" var="cityData" />
				<table style="width:100%">
					<tr>
						<td>ID</td>
						<td>NAME</td>
						<td>COUNTRY_CODE</td>
					</tr>
					<c:forEach var="dataRow" items="${cityData.rows}">
						<tr>
							<td>${dataRow.ID}</td>
							<td>${dataRow.Name}</td>
							<td>${dataRow.CountryCode }</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<h4>There are more tags available for things like update
					, param, transaction</h4>
			</td>
		</tr>
	</table>
	<c:import url="footer.jsp" />
</body>
</html>