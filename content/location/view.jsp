<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<html>
<head>
<title>View Location</title>
<sx:head debug="true" cache="false" compressed="false" />
</head>
<body>
<jsp:include page="/includes/header.jsp" />

<h2><s:property value="location.name" /></h2>
<h3>Location Information</h3>
<table id="location_info">
		<tr>
			<th>Name</th><th>Street Address 1</th><th>Street Address 2</th><th>City</th>
			<th>State</th><th>Zip</th><th>Road Name</th><th>Road Number</th><th>Latitude</th><th>Longitude</th><th>Location Type</th>
		</tr>
			<tr>
				<td><s:property value="location.name" /></td>
				<td><s:property value="location.streetAddress1" /></td>
				<td><s:property value="location.streetAddress2" /></td>
				<td><s:property value="location.city" /></td>
				<td><s:property value="location.state" /></td>
				<td><s:property value="location.zip" /></td>
				<td><s:property value="location.roadName" /></td>
				<td><s:property value="location.roadNumber" /></td>
				<td><s:property value="location.latitude" /></td>
				<td><s:property value="location.longitude" /></td>
				<td><s:property value="location.locationType" /></td>											
			</tr>
	</table>
<jsp:include page="/includes/footer.jsp" />
</body>
</html>