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
			<div id="addDiv">
				<s:url id="addDriver" value="addDriverForm.action"></s:url>
				<s:a href="%{addDriver}">Add Driver</s:a>
			</div>

<jsp:include page="/includes/footer.jsp" />
</body>
</html>