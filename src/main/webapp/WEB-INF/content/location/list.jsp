<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<html>
<head>
<title>Location List</title>
<sx:head debug="true" cache="false" compressed="false" />
</head>
<body>
 <jsp:include page="/WEB-INF/content/header.jsp" />
<p>Location List</p>

<s:if test="locations.size > 0">
	<table id="locations">
		<tr>
			<th>Name</th><th>Street Address 1</th><th>Street Address 2</th><th>City</th>
			<th>State</th><th>Zip</th><th>Road Name</th><th>Road Number</th><th>Latitude</th><th>Longitude</th><th>Contractor</th><th>Location Type</th>
		</tr>
		<s:iterator value="locations">
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
				<td><s:property value="contractor.contractorName" /></td>
				<td><s:property value="locationType" /></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
	No Locations Found...
</s:else>

<jsp:include page="/WEB-INF/content/footer.jsp" />
</body>
</html>