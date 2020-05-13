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
<h1> Allocation(In Hours)  </h1>
<form:form action="enter" method="post">

 Does Every one has Same Allocation? <input type="submit" name="yes" value="Yes">  <input type="submit" name="no" value="No">

</form:form>


<!--  Does Every one has Same Allocation? &nbsp; <a href="">Yes</a> &nbsp; <a href="">No</a> -->


</body>
</html>