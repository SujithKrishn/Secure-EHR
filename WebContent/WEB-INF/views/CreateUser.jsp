<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<%@include file="EHR.jsp" %>
<head>
	<title>Add a User</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a User
</h1>

<c:url var="addAction" value="/CreateUser" ></c:url>

<form:form action="${addAction}" commandName="user">
<table>
	<c:if test="${!empty user.loginName}">
	<tr>
		<td>
			<form:label path="loginId">
				<spring:message text="Doctor ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="loginId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="loginId" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="loginName">
				<spring:message text="Doctor Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="loginName" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="password">
				<spring:message text="Password"/>
			</form:label>
		</td>
		<td>
			<form:password path="password" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="groupId">
				<spring:message text="Group Id"/>
			</form:label>
		</td>
		<td>
			
			<form:select path="groupId">
        <form:options items="${listGroups}" />
       </form:select>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty user.loginName}">
				<input type="submit"
					value="<spring:message text="Edit user"/>" />
			</c:if>
			<c:if test="${empty user.loginName}">
				<input type="submit"
					value="<spring:message text="Add user"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Doctor List</h3>
<c:if test="${!empty listPersons}">
	<table class="tg">
	<tr>
		<th width="80">Doctor ID</th>
		<th width="120">Doctor Name</th>
		<th width="120">Group Id</th>
		
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listPersons}" var="user">
		<tr>
			<td>${user.loginId}</td>
			<td>${user.loginName}</td>
			<td>${user.groupId}</td>
			
			
			<td><a href="<c:url value='/editUser/${user.loginId}' />" >Edit</a></td>
			<td><a href="<c:url value='/removeUser/${user.loginId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
