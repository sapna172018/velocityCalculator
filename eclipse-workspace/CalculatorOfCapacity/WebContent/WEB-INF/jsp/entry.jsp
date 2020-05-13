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
<form:form action="enterFocus" method="post" modelAttribute="allocation">
<pre>
 Allocated Hours                        <form:input path="allocatedHrs"/><br><br>
 Total Days In Current Sprint           <form:input path="totalWorkingDays"/><br><br>
 Number Of Holidays In Current Sprint   <form:input path="nationalHolidays"/><br><br>
<input type="submit" value="submit">
</pre>
</form:form>

</body>
</html>