<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<%@include file="EHR.jsp" %>
<head>
	<title>Revoke User</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>



<br>
<h3>Revoke User</h3>
<c:if test="${!empty listPersons}">
	<table class="tg">
	<tr>
	    <th width="60">Delete</th>
		<th width="80">User ID</th>
		<th width="120">User Name</th>
		<th width="120">Group Id</th>
		
		
		
	</tr>
	<c:forEach items="${listPersons}" var="user">
		<tr>
			<td><a href="<c:url value='/revokeUser/${user.loginId}' />" >Delete</a></td>
			<td>${user.loginId}</td>
			<td>${user.loginName}</td>
			<td>${user.groupId}</td>
			
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
