<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
<head>
	<title>Vehicle List</title>
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("vehicles");
	</script>
</head>
<body>
	<div id="container">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">
			<h2>Vehicle List</h2>
			
			<s:if test="vehicles.size > 0">
				<table id="vehicles">
					<tr>
						<th>Type</th><th>Plate Number</th><th>VIN</th><th>Manufactured Year</th><th>Location</th><th>Contractor</th>
						<th>Drivers</th>
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
							<td><s:property value="drivers" /></td>
						</tr>
					</s:iterator>
				</table>
			</s:if>
			<s:else>
				No Vehicles Found...
			</s:else>
		</div>
	</div>
	<div id="addDiv">
		<s:url id="addVehicle" value="addVehicleForm.action"></s:url>
		<s:a href="%{addVehicle}">Add Vehicle</s:a>
	</div>
	
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>