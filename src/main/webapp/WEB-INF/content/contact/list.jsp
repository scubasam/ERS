<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
<head>
	<title>Contact List</title>
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("contacts");
	</script>
</head>
<body>
<div id="container">
	<jsp:include page="/includes/header.jsp" />
	<div id="content">
		<h2>Contact List</h2>
		
		<s:if test="contacts.size > 0">
			<table id="contacts">
				<tr>
					<th>First Name</th><th>Last Name</th><th>Middle Initial</th><th>Email Address</th><th>Street Address 1</th><th>Street Address 2</th><th>City</th>
					<th>State</th><th>Zip</th><th>Primary Phone</th><th>Work Phone</th>
				</tr>
				<s:iterator value="contacts">
					<tr>
						<td><s:property value="firstName" /></td>
						<td><s:property value="lastName" /></td>
						<td><s:property value="middleInitial" /></td>
						<td><s:property value="emailAddress" /></td>
						<td><s:property value="streetAddress1" /></td>
						<td><s:property value="streetAddres2" /></td>
						<td><s:property value="city" /></td>
						<td><s:property value="state" /></td>
						<td><s:property value="zip" /></td>
						<td><s:property value="primaryPhone" /></td>
						<td><s:property value="workPhone" /></td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
		<s:else>
			No Contacts Found...
		</s:else>
		
		<div id="addDiv">
			<s:url id="addContact" value="addContactForm.action"></s:url>
			<s:a href="%{addContact}">Add Contact</s:a>
		</div>
	</div>
</div>

<jsp:include page="/includes/footer.jsp" />
</body>
</html>