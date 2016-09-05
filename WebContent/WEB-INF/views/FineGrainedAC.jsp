<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<%@include file="EHR.jsp" %>
<head>
	<title>Fine Grained Access Control Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Create a Fine Grained Access(FGA) Control
</h1>

<c:url var="addAction" value="/CreateFGA" ></c:url>

<form:form action="${addAction}" commandName="fga">
<table>
	<c:if test="${fga.id != 0}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="FGA ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="groupId">
				<spring:message text="Group Id"/>
			</form:label>
		</td>
		<td>
			
			<form:select path="groupId" items="${listGroups}"  multiple="true"/>
       
      
			
		</td> 
	</tr>
	
	<tr>
		<td>
			<form:label path="columnNames">
				<spring:message text="Column Names"/>
			</form:label>
		</td>
		<td>
			
			<form:select path="columnNames" multiple="true">
        <form:options items="${listFGAColumns}" />
       </form:select>
		</td>
	</tr>
	
	<tr>
	<tr>
		<td colspan="2">
			<c:if test="${fga.id != 0}">
				<input type="submit"
					value="<spring:message text="Edit FGA"/>" />
			</c:if>
			<c:if test="${fga.id == 0}">
				<input type="submit"
					value="<spring:message text="Add FGA"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>FGA List</h3>
<c:if test="${!empty listPersons}">
	<table class="tg">
	<tr>
		<th width="80">FGA ID</th>
		<th width="120">FGA Name</th>
		
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listPersons}" var="fga">
		<tr>
			<td>${fga.groupId}</td>
			<td>${fga.columnNames}</td>
			
			
			
			<td><a href="<c:url value='/editFGA/${fga.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/removeFGA/${fga.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
