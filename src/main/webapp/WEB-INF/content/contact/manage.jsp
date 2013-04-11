<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
<head>
	<title>Contact List</title>
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />
	<link rel="stylesheet" type="text/css" href="/ERS/styles/contacts.css">
	<script type="text/javascript">
		page = "contacts";
		pageSetup(page);
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
					<thead>
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
					</thead>
					<tbody>
						<s:iterator value="contacts">
							<tr>
								<td>
									<s:url id="edit" action="contactManagement">
										<s:param name="id">
											<s:property value='id' />
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
					</tbody>
				</table>
			</div>
			
			<s:if test="getMode()=='edit'">
				<div id="panel2">
					<s:url id="updateContact" value="updateContact.action">
						<s:param name="id" value="id" />
					</s:url>
					
					<div id="editContainer">
						<s:form name="editForm" action="%{updateContact}" id="contactForm">
							<jsp:include page="/WEB-INF/content/contact/fieldForm.jsp" />
						</s:form>
					</div>
					
					<div id="buttonContainer">
						<div id="modeDiv">
							<h3 id="modeLabel"></h3>
						</div>
						<div class="buttonDiv">
							<a href="javascript:submitForm(editForm);">Update</a>
						</div><br/>
						<div class="buttonDiv">
							<s:url id="deleteUrl" value="deleteContact.action">
								<s:param name="id" value="id" />
							</s:url>
							<s:a href="%{deleteUrl}">Delete</s:a>
						</div><br/>
						<div class="buttonDiv">
							<s:url id="clearUrl" value="contactManagement.action"></s:url>
							<s:a href="%{clearUrl}">Clear</s:a>
						</div><br/>
					</div>
				</div>
			</s:if>
			
			<s:else>
				<div id="panel2">
					<div id="editContainer">
						<s:form name="addForm" action="addContact.action" id="contactForm">
							<jsp:include page="/WEB-INF/content/contact/fieldForm.jsp" />
						</s:form>
					</div>
					
					<div id="buttonContainer">
						<div id="modeDiv">
							<h3 id="modeLabel"></h3>
						</div>
						<div class="buttonDiv">
							<a href="javascript:submitForm(addForm);">Create</a>
						</div><br/>
					</div>
				</div>
			</s:else>
			
		</s:if>
		<s:else>
			No Contacts Found...
		</s:else>
	</div>
</div>

<jsp:include page="/includes/footer.jsp" />
</body>
</html>