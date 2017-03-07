<%@ page contentType="text/html;charset=UTF-8"
		 language="java"
		 import="com.servlets.dbhelpers.*,
		 com.servlets.models.*,
		 java.sql.*"
    %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to the World Manager</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<%!
		String uid = "";
		String pwd = "";
		DBManager dbm;
	%>
	<%
		//make sure user is logged in
		//HttpSession s = request.getSession();
		//direct access to HttpSession --> session!!
		if (session.getAttribute("authlevel") == null 
				|| session.getAttribute("authlevel").equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else {
			Integer authLevel = (Integer)session.getAttribute("authlevel");
			if (authLevel < 1) {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		}
		if (session.getAttribute("uid") != null && !session.getAttribute("uid").equals("")) {
			uid = (String)session.getAttribute("uid");
		}
		if (session.getAttribute("pwd") != null && !session.getAttribute("pwd").equals("")) {
			pwd = (String)session.getAttribute("pwd");
		}
	%>
	<%
		if (uid != null && !uid.equals("")) {
			%>
				<h1>Welcome Back <%= uid %></h1>
			<% 
		}
	%>
	
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
				<%@ include file="navbar.jsp" %>
			</td>
			<td style="width:75%;height:80%;">
				<%-- We don't know how to use
					 expressions yet so we'll do it all here --%>
				<%
					//get the DBManager from context
					//DBManager dbm = (DBManager)getServletContext().getAttribute("WorldDBManager");
					//application --> getServletContext()
					dbm = (DBManager)application.getAttribute("WorldDBManager");
					
					//generate the output in a StringBuilder
					
					//java.lang not needed at import.
					StringBuilder sb = new StringBuilder("<html><body>");
					try {
						//connect to the db and open the connection
						if (!dbm.isConnected()) {
							if (!dbm.openConnection()) {
								//massive failure, log it
								sb.append("Could not connect to the database...");
							}
						}
						
						//ID NAME CountryCode District Population
						//get the cities into a table:
						sb.append("<table border=1>" 
									+ "<tr><td>ID</td><td>NAME</td><td>COUNTRY_CODE</td>"
									+ "<td>DISTRICT</td><td>POPULATION</td></tr>");
						
						//TRUE MVC ERROR: the query should NOT be on the JSP page...
						String query = DBWorldQueries.getCitiesByDistrictByPopulation();
						//TRUE MVC ERROR: neither should creation of the result set...
						ResultSet rs = dbm.ExecuteResultSet(query);
						
						while (rs.next()) {
							int id = rs.getInt("ID");
							String name = rs.getString("NAME");
							String ctry = rs.getString("CountryCode"); 
							String dist = rs.getString("District"); 
							int pop = rs.getInt("Population");
							
							sb.append("<tr><td>" + id + "</td>" 
									+ "<td>" + name + "</td>" 
									+ "<td>" + ctry + "</td>" +
									"<td>" + dist + "</td>" +
									"<td>" + pop + "</td></tr>");
						}
						sb.append("</table>");
					} catch(Exception e) {
						sb.append("<h1>ERROR: " + e.getMessage() + "</h1>");
					}
					sb.append("</body></html>");
					
					//don't need to get the writer anymore...
					//response.setContentType("text/html");
					//PrintWriter out = response.getWriter();
					out.println(sb);
				%>
			</td>
		</tr>
	</table>
	<!-- jsp:include page="footer.jsp" -->
	<%@ include file="footer.jsp" %>
</body>
</html>