<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<html>
<head>
<title>Vehicle List</title>
<sx:head debug="true" cache="false" compressed="false" />
</head>
<body>
 <jsp:include page="/WEB-INF/content/header.jsp" />
<p>Vehicle List</p>

<s:if test="vehicles.size > 0">
	<table id="vehicles">
		<tr>
			<th>Type</th><th>Plate Number</th><th>VIN</th><th>Manufactured Year</th><th>Location</th><th>Contractor</th>
		</tr>
		<s:iterator value="vehicles">
			<s:url id="viewContractor" value="viewContractor.action">
					<s:param name="id" value="contractor.getId()" />
				</s:url>
			<tr>
				<td><s:property value="vehicleType" /></td>
				<td><s:property value="plateNumber" /></td>
				<td><s:property value="vinNumber" /></td>
				<td><s:property value="manufacturedYear" /></td>
				<td><s:property value="location.name" /></td>
				<td><s:a href="%{viewContractor}"><s:property value="contractor" /></s:a></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
	No Vehicles Found...
</s:else>

<jsp:include page="/WEB-INF/content/footer.jsp" />
</body>
</html>