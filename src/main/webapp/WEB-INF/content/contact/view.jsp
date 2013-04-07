<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<html>
<head>
<title>View Contact</title>
<sx:head debug="true" cache="false" compressed="false" />
</head>
<body>
 <jsp:include page="/includes/header.jsp" />

<h2><s:property value="contact.contactorName" /></h2>
<h3>Contact Information</h3>
<table id="contact_contactInfo">
		<tr>
			<th>First Name</th><th>Last Name</th><th>Middle Initial</th><th>Email Address</th><th>Street Address 1</th><th>Street Address 2</th><th>City</th>
			<th>State</th><th>Zip</th><th>Primary Phone</th><th>Work Phone</th>
		</tr>
			<tr>
				<td><s:property value="contact.firstName" /></td>
				<td><s:property value="contact.lastName" /></td>
				<td><s:property value="contact.middleInitial" /></td>
				<td><s:property value="contact.emailAddress" /></td>
				<td><s:property value="contact.streetAddress1" /></td>
				<td><s:property value="contact.streetAddres2" /></td>
				<td><s:property value="contact.city" /></td>
				<td><s:property value="contact.state" /></td>
				<td><s:property value="contact.zip" /></td>
				<td><s:property value="contact.primaryPhone" /></td>
				<td><s:property value="contact.workPhone" /></td>
			</tr>
	</table>
<jsp:include page="/includes/footer.jsp" />
</body>
</html>