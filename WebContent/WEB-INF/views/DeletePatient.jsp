<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<%@include file="EHR.jsp" %>
<head>
	<title>Delete Patient</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Delete Patient
</h1>

<c:url var="addAction" value="/person/add" ></c:url>

<form:form action="${addAction}" commandName="person">

</form:form>
<br>
<h3>Patients List</h3>
<c:if test="${!empty listPersons}">
	<table class="tg">
	<tr>
	<th width="60">Delete</th>
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
		<th width="120"> Handicapped</th>
		<th width="120"> Polio</th>
		<th width="120"> Cancer</th>
		<th width="120">Cancer Type</th>
		<th width="120"> Diabetis</th>
		<th width="120"> BloodPressure</th>
		<th width="120"> STD</th>
		<th width="120">Physician</th>
		
	</tr>
	<c:forEach items="${listPersons}" var="person">
		<tr>
		<td><a href="<c:url value='/remove/${person.id}' />" >Delete</a></td>
			<td>${person.id}</td>
			<td>${person.name}</td>
			<td>${person.country}</td>
			<td>${person.fatherName}</td>
			<td>${person.motherName}</td>
			<td>${person.gender}</td>
			<td>${person.bloodType}</td>
			<td>${person.dob}</td>
			<td>${person.disease}</td>
			<td>${person.symptoms}</td>
			<td>${person.diagnosis}</td>
			<td>${person.isUndergoneSurgery}</td>
			<td>${person.tempAddress}</td>
			<td>${person.permanentAddress}</td>
			<td>${person.isEyeSightProblem}</td>
			<td>${person.leftEyePower}</td>
			<td>${person.rightEyePower}</td>
			<td>${person.isHandicapped}</td>
			<td>${person.hasPolio}</td>
			<td>${person.hasCancer}</td>
			<td>${person.cancerType}</td>
			<td>${person.hasDiabetis}</td>
			<td>${person.hasBloodPressure}</td>
			<td>${person.hasSTD}</td>
			<td>${person.physician}</td>
		
			
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
