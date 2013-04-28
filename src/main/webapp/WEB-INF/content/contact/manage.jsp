<%-- @authors Mitchell Nemitz, Kelly Smith, Alex McCracken --%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
<head>
	<title>Contact List</title>
	
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />

	<script type="text/javascript">
		page = "contacts";
		pageSetup(page);
	</script>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">
			<h2>Contact List</h2>

			<s:if test="contacts.size > 0">
				<div id="columnSelect">
					<s:form name="manageColumns"
						action="manageColumns.action?action=contact" id="columnSelectForm">
						<s:checkboxlist label="Choose Display Columns" list="columnLabels"
							name="columnLabels" value="visibleColumns" />
						<s:submit value="Update" />
					</s:form>
				</div>

				<div id="dataContainer">
					<table id="contacts">
						<thead>
							<tr>
								<th></th>
								<s:property value="gridHeaders" escape="false" />
							</tr>
						</thead>

						<tbody>
							<s:property value="gridBody" escape="false" />
						</tbody>
					</table>
				</div>

				<div id="editContainer">
					<jsp:include page="/includes/error_header.jsp" />

					<s:if test="getMode()=='edit'">
						<s:url id="updateContact" value="updateContact.action">
							<s:param name="id" value="id" />
						</s:url>

						<div id="formContainer">
							<s:form name="editForm" action="%{updateContact}"
								id="contactForm">
								<s:textfield name="contact.firstName" label="First Name" />
								<s:textfield name="contact.lastName" label="Last Name" />
								<s:textfield name="contact.middleInitial" label="Middle Initial" />
								<s:textfield name="contact.emailAddress" label="Email Address" />
								<s:textfield name="contact.streetAddress1" label="Street Address 1" />
								<s:textfield name="contact.streetAddress2" label="Street Address 2" />
								<s:textfield name="contact.city" label="City" />
								<s:textfield name="contact.state" label="State" />
								<s:textfield name="contact.zip" label="Zip" />
								<s:textfield name="contact.primaryPhone" label="Primary Phone" />
								<s:textfield name="contact.workPhone" label="Work Phone" />
							</s:form>
						</div>

						<div id="buttonContainer">
							<div id="modeDiv">
								<h3 id="modeLabel"></h3>
							</div>
							<div class="buttonDiv">
								<a href="javascript:submitForm(editForm);">Update</a>
							</div>
							<br />
							<div class="buttonDiv">
								<s:url id="deleteUrl" value="deleteContact.action">
									<s:param name="id" value="id" />
								</s:url>
								<s:a href="%{deleteUrl}">Delete</s:a>
							</div>
							<br />
							<div class="buttonDiv">
								<s:url id="clearUrl" value="contactManagement.action"></s:url>
								<s:a href="%{clearUrl}">Clear</s:a>
							</div>
							<br />
						</div>
					</s:if>

					<s:else>
						<div id="formContainer">
							<s:form name="addForm" action="addContact.action"
								id="contactForm">
								<s:textfield name="contact.firstName" label="First Name" />
								<s:textfield name="contact.lastName" label="Last Name" />
								<s:textfield name="contact.middleInitial" label="Middle Initial" />
								<s:textfield name="contact.emailAddress" label="Email Address" />
								<s:textfield name="contact.streetAddress1" label="Street Address 1" />
								<s:textfield name="contact.streetAddress2" label="Street Address 2" />
								<s:textfield name="contact.city" label="City" />
								<s:textfield name="contact.state" label="State" />
								<s:textfield name="contact.zip" label="Zip" />
								<s:textfield name="contact.primaryPhone" label="Primary Phone" />
								<s:textfield name="contact.workPhone" label="Work Phone" />
							</s:form>
						</div>

						<div id="buttonContainer">
							<div id="modeDiv">
								<h3 id="modeLabel"></h3>
							</div>
							<div class="buttonDiv">
								<a href="javascript:submitForm(addForm);">Create</a>
							</div>
							<br />
						</div>
					</s:else>
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