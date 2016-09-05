<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<%@include file="EHR.jsp" %>
<head>
	<title>	Modify Patient</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Modify Patient
</h1>

<c:url var="addAction" value="/person/add" ></c:url>

<form:form action="${addAction}" commandName="person">
	
</form:form>
<br>
<h3>Patients List</h3>
<c:if test="${!empty listPersons}">
	<table class="tg">
	<tr>
	<th width="60">Edit</th>
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
		<th width="120"> Undergone Surgery</th>
		<th width="120">Temporary Address</th>
		<th width="120">Permanent Address</th>
		<th width="120"> EyeSight Problem</th>
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
		<td><a href="<c:url value='/edit/${person.id}' />" >Edit</a></td>
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
<h1>
	Edit a Patient
</h1>

<c:url var="addAction" value="/patient/add" ></c:url>

<form:form action="${addAction}" commandName="person">
<table align="center">
	<c:if test="${!empty person.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="Patient ID"/>
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
			<form:label path="name">
				<spring:message text="Patient Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	
	<tr>
		<td>
			<form:label path="fatherName">
				<spring:message text="Father Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="fatherName" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="motherName">
				<spring:message text="Mother Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="motherName" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="gender">
				<spring:message text="Gender"/>
			</form:label>
		</td>
		<td>
			<form:select path="gender" >
			
			  <form:option value="Select" label="Select One"></form:option>
			    <form:option value="Male" label="Male"></form:option>
			    <form:option value="Female" label="Female"></form:option>
			</form:select>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="country">
				<spring:message text="Country"/>
			</form:label>
		</td>
		<td>
			<form:select path="country">
			  <form:option value="Select" label="Select One"></form:option>
			    <form:option value="India" label="India"></form:option>
			    <form:option value="Australia" label="Australia"></form:option>
			    <form:option value="America" label="America"></form:option>
			    <form:option value="China" label="China"></form:option>
			    <form:option value="Japan" label="Japan"></form:option>
			    <form:option value="Newzland" label="Newzland"></form:option>
			    <form:option value="France" label="France"></form:option>
			    <form:option value="Britan" label="Britan"></form:option>
			</form:select>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="bloodType">
				<spring:message text="Blood Type"/>
			</form:label>
		</td>
		<td>
			
			<form:select path="bloodType">
			  <form:option value="Select" label="Select One"></form:option>
			    <form:option value="A+" label="A+"></form:option>
			    <form:option value="A-" label="A-"></form:option>
			    <form:option value="O+" label="O-"></form:option>
			    <form:option value="B+" label="B+"></form:option>
			    <form:option value="O-" label="O-"></form:option>
			    <form:option value="B-" label="B-"></form:option>
			    <form:option value="AB+" label="AB+"></form:option>
			    <form:option value="AB-" label="AB-"></form:option>
			</form:select>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="dob">
				<spring:message text="DOB"/>
			</form:label>
		</td>
		<td>
<%-- 			<form:input path="dob" /> --%>
			 <input type="date" name="dob">
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="disease">
				<spring:message text="Disease"/>
			</form:label>
		</td>
		<td>
			
				<form:select path="disease">
			  <form:option value="NA" label="Select One"></form:option>
			      <form:option value="NA" label="Select One"></form:option>
			    <form:option value="Airborne disease" label="Airborne disease"></form:option>
			    <form:option value="Contagious disease" label="Contagious disease"></form:option>
			    <form:option value="Cryptogenic disease" label="Cryptogenic disease"></form:option>
			    <form:option value="Disseminated disease" label="Disseminated disease"></form:option>
			    <form:option value="Lifestyle disease" label="Lifestyle disease"></form:option>
			    <form:option value="Progressive disease" label="Progressive disease"></form:option>
			    <form:option value="Rare disease" label="Rare disease"></form:option>
			</form:select>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="symptoms">
				<spring:message text="Symptoms"/>
			</form:label>
		</td>
		<td>
			
			<form:select path="symptoms">
			  <form:option value="NA" label="Select One"></form:option>
			    <form:option value="chest pain" label="chest pain"></form:option>
			    <form:option value="fever" label="fever"></form:option>
			     <form:option value="dry cough" label="dry cough"></form:option>
			      <form:option value="wheezing" label="wheezing"></form:option>
			       <form:option value="nausea" label="nausea"></form:option>
			        <form:option value="vomiting" label="vomiting"></form:option>
			</form:select>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="diagnosis">
				<spring:message text="Diagnosis"/>
			</form:label>
		</td>
		<td>
			<form:input path="diagnosis" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="isUndergoneSurgery">
				<spring:message text=" Undergone Surgery"/>
			</form:label>
		</td>
		<td>
			
				<form:select path="isUndergoneSurgery">
			  <form:option value="NA" label="Select One"></form:option>
			    <form:option value="Yes" label="Yes"></form:option>
			    <form:option value="No" label="No"></form:option>
			</form:select>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="tempAddress">
				<spring:message text="Temporary Address"/>
			</form:label>
		</td>
		<td>
			<form:input path="tempAddress" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="permanentAddress">
				<spring:message text="Permanent Address"/>
			</form:label>
		</td>
		<td>
			<form:input path="permanentAddress" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="isEyeSightProblem">
				<spring:message text=" Eye Sight Problem"/>
			</form:label>
		</td>
		<td>
		
			<form:select path="isEyeSightProblem">
			  <form:option value="NA" label="Select One"></form:option>
			     <form:option value="Yes" label="Yes"></form:option>
			    <form:option value="No" label="No"></form:option>
			</form:select>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="leftEyePower">
				<spring:message text="Left Eye Power"/>
			</form:label>
		</td>
		<td>
			<form:input path="leftEyePower" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="rightEyePower">
				<spring:message text="Right Eye Power"/>
			</form:label>
		</td>
		<td>
			<form:input path="rightEyePower" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="isHandicapped">
				<spring:message text=" Handicapped"/>
			</form:label>
		</td>
		<td>
			
			<form:select path="isHandicapped">
			  <form:option value="NA" label="Select One"></form:option>
			      <form:option value="Yes" label="Yes"></form:option>
			   <form:option value="No" label="No"></form:option>
			</form:select>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="hasPolio">
				<spring:message text=" Polio"/>
			</form:label>
		</td>
		<td>
			
			<form:select path="hasPolio">
			  <form:option value="NA" label="Select One"></form:option>
			    <form:option value="Yes" label="Yes"></form:option>
			   <form:option value="No" label="No"></form:option>
			</form:select>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="hasCancer">
				<spring:message text=" Cancer"/>
			</form:label>
		</td>
		<td>
		
			<form:select path="hasCancer">
			  <form:option value="NA" label="Select One"></form:option>
			   <form:option value="Yes" label="Yes"></form:option>
			    <form:option value="No" label="No"></form:option>
			</form:select>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="cancerType">
				<spring:message text="Cancer Type"/>
			</form:label>
		</td>
		<td>
			
			<form:select path="cancerType">
			  <form:option value="NA" label="Select One"></form:option>
			    <form:option value="Anal cancer" label="Anal cancer"></form:option>
			    <form:option value="Bladder cancer " label="Bladder cancer"></form:option>
			    <form:option value="Blood cancer " label="Blood cancer"></form:option>
			    <form:option value="Breast cancer " label="Breast cancer"></form:option>
			    <form:option value="Cervical cancer " label="Cervical cancer"></form:option>
			     <form:option value="Eye cancer " label="Eye cancer"></form:option>
			      <form:option value="Head cancer " label="Head cancer"></form:option>
			       <form:option value="Lung cancer " label="Lung cancer"></form:option>
			        <form:option value="Ovarian cancer " label="Ovarian cancer"></form:option>
			         <form:option value="Penis cancer " label="Penis cancer"></form:option>
			</form:select>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="hasDiabetis">
				<spring:message text=" Diabetis"/>
			</form:label>
		</td>
		<td>
			
			<form:select path="hasDiabetis">
			  <form:option value="NA" label="Select One"></form:option>
			     <form:option value="Yes" label="Yes"></form:option>
			   <form:option value="No" label="No"></form:option>
			</form:select>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="hasBloodPressure">
				<spring:message text=" BloodPressure"/>
			</form:label>
		</td>
		<td>
			
			<form:select path="hasBloodPressure">
			  <form:option value="NA" label="Select One"></form:option>
			   <form:option value="Yes" label="Yes"></form:option>
			  <form:option value="No" label="No"></form:option>
			</form:select>
			
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="hasSTD">
				<spring:message text=" STD"/>
			</form:label>
		</td>
		<td>
			<form:select path="hasSTD">
			  <form:option value="NA" label="Select One"></form:option>
			   <form:option value="Yes" label="Yes"></form:option>
			   <form:option value="No" label="No"></form:option>
			</form:select>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="physician">
				<spring:message text="Physician"/>
			</form:label>
		</td>
		<td>
			<form:select path="physician" items="${listPhysicians}"  multiple="true"/>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty person.name}">
				<input type="submit"
					value="<spring:message text="Edit Patient"/>" />
			</c:if>
			<c:if test="${empty person.name}">
				<input type="submit"
					value="<spring:message text="Add Patient"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
</body>
</html>
