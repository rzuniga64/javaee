<%@ page contentType="text/html; charset=UTF-8"
		 language="java"
		 import="com.javabeans.models.*"%>
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
                <!--
                    Call the bean object. If the bean does not exist in the
                    scope we have state, which is the request, the bean will be
                    created and inserted into that scope.  The bean is named wu.
                    Specify what class the bean is using and the scope this bean
                    is in is request. Pull in some parameters before creating
                    the WebUser object.  When we use the 'property' keyword it
                    is in lowercase. The system will then know that is the
                    getUserID, getPassWord, and getAuthLevel. Then we will set
                    those values on that bean object and place those properties
                    into the request so we can pass those values from one
                    to another request.
                -->

				<jsp:useBean id="wu" class="com.javabeans.models.WebUser"
					scope="request">
					<jsp:setProperty name="wu" property="userId" 
						value='<%=request.getParameter("uid")%>' />
					<jsp:setProperty name="wu" property="password" 
						value='<%=request.getParameter("pwd")%>' />
					<jsp:setProperty name="wu" property="authLevel"
						value="1" />
				</jsp:useBean>

                <!-- forward bean information to usebeans.jsp -->
				<jsp:forward page="useBeans.jsp" />
			</td>
		</tr>
	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>