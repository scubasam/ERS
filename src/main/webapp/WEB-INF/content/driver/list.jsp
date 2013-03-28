<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
<head>
	<title>View Driver</title>
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("drivers");
	</script>
</head>
<body>
	<div id="container">
 		<jsp:include page="/includes/header.jsp" />
		<div id="content">
			<h2>Driver List</h2>
			<s:if test="drivers.size > 0">
				<table id="drivers">
					<tr>
						<th>License Number</th><th>License Expiration</th><th>License Class</th><th>Contractor</th><th>Vehicle Type</th>
					</tr>
					<s:iterator value="drivers">
						<tr>
							<td><s:property value="licenseNumber" /></td>
							<td><s:property value="licenseExpiration" /></td>
							<td><s:property value="licenseClass" /></td>
								<td><s:property value="contractor" /></td>
								<td><s:property value="vehicles" /></td>
						</s:iterator>
				</table>
			</s:if>
			<s:else>
				No Drivers Found....
			</s:else>
			<div id="addDiv">
				<s:url id="addDriver" value="addDriverForm.action"></s:url>
				<s:a href="%{addDriver}">Add Driver</s:a>
			</div>
		</div>
	</div>
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>