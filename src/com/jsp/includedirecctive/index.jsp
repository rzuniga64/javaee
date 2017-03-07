<%--

--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
      <meta charset="UTF-8">
      <title>Welcome to the World Manager</title>
  </head>
  <body>
        <!-- include using a directive -->
        <jsp:include page="header.jsp"/>
        <table style="width:100%">
            <tr>
                <td style="width:25%; height:80%"; valign="top">
                    <jsp:include page="navbar.jsp"/>
                </td>
                <td style="width:75%;height:80%">
                    <h1>Content goes here</h1>
                </td>
            </tr>
        </table>
        <!-- Include using JSP Standard action -->
        <jsp:include page="footer.jsp"/>
        <%-- Note: this comment does not render! --%>
  </body>
</html>
