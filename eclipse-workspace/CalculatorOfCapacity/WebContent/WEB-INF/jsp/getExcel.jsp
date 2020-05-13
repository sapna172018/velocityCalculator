<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

	function SomeDeleteRowFunction() {
	      // event.target will be the input element.
	      var td = event.target.parentNode; 
	      var tr = td.parentNode; // the row to be removed
	      tr.parentNode.removeChild(tr);
	}


</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${message}</h1>
<br><hr>

<form:form action="processExcel" method="post" enctype="multipart/form-data">
<div>upload File Here</div>
<input type="file" name="excelFile">
<input type="submit" value="processExcel">
</form:form>
<hr>


<c:if test="${!empty list}">
		<table>
		<tr><th>Allocation List</th></tr>
			<tr>
						<th>Team Member</th>
						<th>Leaves </th>
			</tr>
			<c:forEach items="${list}" var="user">
						<tr>
						<td>${user.teamMember}</td>
						<td>${user.leaves}</td>
						<td><input type="button" value="X" onclick="SomeDeleteRowFunction(this);"></td>
						</tr>
			</c:forEach>
			<tr><th><h3><a href="allocation">Enter Resource Allocation</a></h3></th><tr>
		</table>

</c:if>

</body>
</html>