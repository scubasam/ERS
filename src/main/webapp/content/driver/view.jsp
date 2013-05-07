<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<html>
<head>
<title>View Driver</title>
<sx:head debug="true" cache="false" compressed="false" />
</head>
<body>
<jsp:include page="/includes/header.jsp" />

<h2><s:property value="driver.driverName" /></h2>
<h3>Driver Information</h3>
<table id="driver_contactInfo">
		<tr>
			<th>First Name</th><th>Last Name</th><th>Middle Initial</th><th>Email Address</th><th>Street Address 1</th><th>Street Address 2</th><th>City</th>
			<th>State</th><th>Zip</th><th>Primary Phone</th><th>Work Phone</th>
		</tr>
			<tr>
				<td><s:property value="driver.contact.firstName" /></td>
				<td><s:property value="driver.contact.lastName" /></td>
				<td><s:property value="driver.contact.middleInitial" /></td>
				<td><s:property value="driver.contact.emailAddress" /></td>
				<td><s:property value="driver.contact.streetAddress1" /></td>
				<td><s:property value="driver.contact.streetAddres2" /></td>
				<td><s:property value="driver.contact.city" /></td>
				<td><s:property value="driver.contact.state" /></td>
				<td><s:property value="driver.contact.zip" /></td>
				<td><s:property value="driver.contact.primaryPhone" /></td>
				<td><s:property value="driver.contact.workPhone" /></td>												
			</tr>
	</table>
<h3>Location Information</h3>
<s:if test="driver.locations.size > 0">
	<table id="driver_locationInfo">
		<tr>
			<th>Name</th><th>Street Address 1</th><th>Street Address 2</th><th>City</th>
			<th>State</th><th>Zip</th><th>Road Name</th><th>Road Number</th><th>Latitude</th><th>Longitude</th><th>Location Type</th>
		</tr>
		<s:iterator value="driver.locations">
				<tr>
					<td><s:property value="name" /></td>
					<td><s:property value="streetAddress1" /></td>
					<td><s:property value="streetAddress2" /></td>
					<td><s:property value="city" /></td>
					<td><s:property value="state" /></td>
					<td><s:property value="zip" /></td>
					<td><s:property value="roadName" /></td>
					<td><s:property value="roadNumber" /></td>
					<td><s:property value="latitude" /></td>
					<td><s:property value="longitude" /></td>
					<td><s:property value="locationType" /></td>
				</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
	No Locations Found...
</s:else>

<h3>Vehicle Information</h3>
<s:if test="driver.vehicles.size > 0">
	<table id="driver_vehicleInfo">
		<tr>
			<th>Type</th><th>Plate Number</th><th>VIN</th><th>Manufactured Year</th><th>Location</th><th>Contractor</th>
		</tr>
		<s:iterator value="driver.vehicles">
			<s:url id="viewDriver" value="viewDriver.action">
					<s:param name="id" value="driver.getId()" />
				</s:url>
			<tr>
			<tr>
				<td><s:property value="vehicleType" /></td>
				<td><s:property value="plateNumber" /></td>
				<td><s:property value="vinNumber" /></td>
				<td><s:property value="manufacturedYear" /></td>
				<td><s:property value="location.name" /></td>
				<td><s:a href="%{viewDriver}"><s:property value="driver" /></s:a></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
	No Vehicles Found...
</s:else>

<h3>Driver Information</h3>
<s:if test="driver.vehicles.size> 0">
	<table id="driverInfo">
		<tr>
			<th>Driver ID</th><th>Contact</th><th>Vehicles</th><th>License Number</th><th>License Expiration</th><th>License Class</th><th>Contract Name</th>
		</tr>
		<s:iterator value="driver.">
			<tr>
				<td><s:property value ="id" /></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
	No locations Found....
</s:else>

<jsp:include page="/includes/footer.jsp" />
</body>
</html>