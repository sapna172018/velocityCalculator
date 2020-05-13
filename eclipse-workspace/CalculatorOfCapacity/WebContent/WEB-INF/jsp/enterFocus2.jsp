<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Enter different Focus Factor </h1>
<table>
<form:form action="calculate" method="post" modelAttribute="allocation">
<tr>
<th>Team member</th> 
<th>Focus Factor</th><tr>
<c:forEach items="${list}" var="emp">
<tr><td>${emp.teamMember}</td>
<td><form:input path="fFactor"/></td></tr>
</c:forEach>
 <tr>
 <td><input type="submit" value="submit"></td>
 </tr>
</form:form>
</table>

</body>
</html>