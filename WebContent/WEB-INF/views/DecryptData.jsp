<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<%@include file="EHR.jsp" %>
<head>
	<title>Person Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Decrypt Patient Data
</h1>
<form action="DecryptData" >
<br>
<table align="center" >
	
	<tr>
		<td>
			<label path="token">
				<spring:message text="Token (Session Key)"/>
			</label>
		</td>
		<td>
			<input path="token" size="20"   value=""/>
			<hidden path="token" />
		</td> 
	</tr>
	
	
	<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
	
	<tr >
		<td colspan="2">
			
				<input type="submit"
					value="<spring:message text="Decrypt Data"/>" />
			
		
		</td>
	</tr>
</table>	
</form>
<br>
<br>
<h3>Patients List</h3>
<c:if test="${!empty listPersons}">
	<table class="tg">
	<tr>
		
		<th width="80">Patient ID</th>
		<th width="120">Patient Name</th>
		<th width="120">Patient Country</th>
		<th width="120">Father Name</th>
		<th width="120">Mother Name</th>
		<th width="120">Gender</th>
		<th width="120">BloodType</th>
		<th width="120">DOB</th>
		<th width="120">Disease</th>
		<th width="120">Symptoms</th>
		<th width="120">Diagnosis</th>
		<th width="120">Undergone Surgery</th>
		<th width="120">Temporary Address</th>
		<th width="120">Permanent Address</th>
		<th width="120">EyeSight Problem</th>
		<th width="120">Left Eye Power</th>
		<th width="120">Right Eye Power</th>
		<th width="120">Handicapped</th>
		<th width="120">Polio</th>
		<th width="120">Cancer</th>
		<th width="120">Cancer Type</th>
		<th width="120">Diabetis</th>
		<th width="120"> BloodPressure</th>
		<th width="120"> STD</th>
		<th width="120"></th>
		<th width="80">Session Token</th>
	</tr>
	<tr>
	<c:forEach items="${listPersons[0]}" var="header" varStatus="loop">
		<td width="120">${listPersons[0][loop.index]}</td>
		</c:forEach>
</tr>
	
	</table>
</c:if>
</body>
</html>
