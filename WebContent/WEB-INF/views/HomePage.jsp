<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<%@include file="EHR.jsp" %>
<head>
	<title>Create Group Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>



<h1>
	Patients List
</h1>
<br>

<c:if test="${!empty listPersons}">
	<table class="tg" align="center">
	<tr>
	
		<c:forEach items="${listPersons[0]}" var="header" varStatus="loop">
		<th width="120">${listPersons[0][loop.index]}</th>
		</c:forEach>
		
		
	</tr>

		
		<c:forEach items="${listPersons[1]}"  varStatus="loop">
		<tr>
		<c:forEach items="${listPersons[1][loop.index]}" varStatus="loop1">
			<td>${listPersons[1][loop.index][loop1.index]}</td>
			</c:forEach>
			</tr>
			</c:forEach>
			
			
		
	
	</table>
</c:if>
</body>
</html>
