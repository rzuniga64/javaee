<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:choose>
	<c:when test="${pageContext.request.contextPath eq initParam.defaultWebBase}">
		<!-- context is good -->
		<ul style="list-style-type:none; padding:0px; margin:0px 0px 0px 0px;">
			<li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
			<li><a href="${pageContext.request.contextPath}/login.jsp">Login</a></li>
			<li><a href="${pageContext.request.contextPath}/Protected/listCities.jsp">View Cities</a></li>
			<li><a href="${pageContext.request.contextPath}/Protected/listCountries.jsp">View Countries</a></li>
			<li><a href="${pageContext.request.contextPath}/signout.do">Sign Out</a></li>
			<li><a href="${pageContext.request.contextPath}/invalidatesessionandremovecookies.do">Clear All User Data</a></li>
		</ul>
	</c:when>
	<c:otherwise>
		<!-- use base links -->
		<ul style="list-style-type:none; padding:0px; margin:0px 0px 0px 0px;">
			<li><a href="${initParam.baseURL}/index.jsp">Home</a></li>
			<li><a href="${initParam.baseURL}/login.jsp">Login</a></li>
			<li><a href="${initParam.baseURL}/Protected/listCities.jsp">View Cities</a></li>
			<li><a href="${initParam.baseURL}/Protected/listCountries.jsp">View Countries</a></li>
			<li><a href="${initParam.baseURL}/signout.do">Sign Out</a></li>
			<li><a href="${initParam.baseURL}/invalidatesessionandremovecookies.do">Clear All User Data</a></li>
		</ul>
	</c:otherwise>
</c:choose>
