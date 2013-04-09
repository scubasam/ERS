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
		pageSetup("contacts");
	</script>
</head>
<body>
<div id="container">
	<jsp:include page="/includes/header.jsp" />
	<div id="content">
		<h2>Contact List</h2>
		
		<s:if test="contacts.size > 0">
			
			<div id="scrollContainer">
				<table id="contacts">
					<tr>
						<th></th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Middle Initial</th>
						<th>Email Address</th>
						<th>Street Address 1</th>
						<th>Street Address 2</th>
						<th>City</th>
						<th>State</th>
						<th>Zip</th>
						<th>Primary Phone</th>
						<th>Work Phone</th>
					</tr>
					<s:iterator value="contacts">
						<tr>
							<td>
								<s:url id="edit" action="listAllContacts">
									<s:param name="id">
										<s:property value='id-1' />
									</s:param>
								</s:url>
								
								<s:a href="%{edit}">Edit</s:a>
							</td>
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
			</div>
				
			<div id="editContainer">
				<div style="clear:both;">
					<table>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Middle Initial</th>
							<th>Email Address</th>
							<th>Street Address 1</th>
							<th>Street Address 2</th>
							<th>City</th>
							<th>State</th>
							<th>Zip</th>
							<th>Primary Phone</th>
							<th>Work Phone</th>
						</tr>
						<tr>
							<td style="text-align: center;">
								<input type="text" name="contact.firstName" 
								value="<s:property value='contacts.get(#parameters["id"]).firstName' />" />
							</td>
							<td style="text-align: center;">
								<input type="text" name="contact.lastName" 
								value="<s:property value='contacts.get(#parameters["id"]).lastName' />" />
							</td>
							<td style="text-align: center;">
								<input type="text" name="contact.middleInitial" style="width: 40px;"
								value="<s:property value='contacts.get(#parameters["id"]).middleInitial' />" />
							</td>
							<td style="text-align: center;">
								<input type="text" name="contact.emailAddress" 
								value="<s:property value='contacts.get(#parameters["id"]).emailAddress' />" />
							</td>
							<td style="text-align: center;">
								<input type="text" name="contact.streetAddress1" 
								value="<s:property value='contacts.get(#parameters["id"]).streetAddress1' />" />
							</td>
							<td style="text-align: center;">
								<input type="text" name="contact.streetAddres2" 
								value="<s:property value='contacts.get(#parameters["id"]).streetAddres2' />" />
							</td>
							<td style="text-align: center;">
								<input type="text" name="contact.city" 
								value="<s:property value='contacts.get(#parameters["id"]).city' />" />
							</td>
							<td style="text-align: center;">
								<input type="text" name="contact.state" style="width: 40px;"
								value="<s:property value='contacts.get(#parameters["id"]).state' />" />
							</td>
							<td style="text-align: center;">
								<input type="text" name="contact.zip" style="width: 50px;"
								value="<s:property value='contacts.get(#parameters["id"]).zip' />" />
							</td>
							<td style="text-align: center;">
								<input type="text" name="contact.primaryPhone" style="width: 100px;"
								value="<s:property value='contacts.get(#parameters["id"]).primaryPhone' />" />
							</td>
							<td style="text-align: center;">
								<input type="text" name="contact.workPhone" style="width: 100px;" 
								value="<s:property value='contacts.get(#parameters["id"]).workPhone' />" />
							</td>
						</tr>
					</table>
				</div>
				
				<div class="buttonDiv" id="addButton">
					<s:url id="addContact" value="addContactForm.action"></s:url>
					<s:a href="%{addContact}" id="addButtonText">Add</s:a>
				</div>
				
				<div class="buttonDiv" id="editButton">
					<s:url id="editContact" value="addContactForm.action"></s:url>
					<s:a href="%{editContact}" id="editButtonText">Submit</s:a>
				</div>
				
				<div class="buttonDiv" id="deleteButton">
					<s:url id="deleteContact" value="addContactForm.action"></s:url>
					<s:a href="%{deleteContact}" id="deleteButtonText">Delete</s:a>
				</div>
				
			</div>
		</s:if>
		<s:else>
			No Contacts Found...
		</s:else>
	</div>
</div>

<jsp:include page="/includes/footer.jsp" />
</body>
</html>