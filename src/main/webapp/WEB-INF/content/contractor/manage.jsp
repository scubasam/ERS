<%-- @author Mitchell Nemitz, Kelly Smith, Alex McCracken --%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
<head>
	<title>Contractor Management</title>
	
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />

	<script type="text/javascript">
		page = "contractors";
		pageSetup(page);
	</script>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/includes/header.jsp" />
		
		<div id="content">

			<s:if test="contractors.size > 0">
				<div id="columnSelect">
					<s:form name="manageColumns"
						action="manageColumns.action?action=contractor"
						id="columnSelectForm">
						<s:checkboxlist label="Choose Display Columns" list="columnLabels"
							name="columnLabels" value="visibleColumns" />
						<s:submit value="Update" />
					</s:form>
				</div>
				<div id="dataContainer">
					<table id="contractors" class="dataTable">
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
						<s:url id="updateContractor" value="updateContractor.action">
							<s:param name="id" value="id" />
						</s:url>

						<div id="formContainer">
							<s:form name="editForm" action="%{updateContractor}"
								id="contractorForm">
								<s:textfield name="contractor.contractorName" label="Name" />
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
							<a class="ui-button edit-button" href="javascript:submitForm(editForm);">Update</a>
							<br />
							
							<s:url id="deleteUrl" value="deleteContractor.action">
								<s:param name="id" value="id" />
							</s:url>
							<s:a cssClass="ui-button edit-button" href="%{deleteUrl}">Delete</s:a>
							<br />
							
							<s:url id="clearUrl" value="contractorManagement.action"></s:url>
							<s:a cssClass="ui-button edit-button" href="%{clearUrl}">Clear</s:a>
							<br />
						</div>
					</s:if>

					<s:else>
						<div id="formContainer">
							<s:form name="addForm" action="addContractor.action"
								id="contractorForm">
								<s:textfield name="contractor.contractorName" label="Name" />
								<s:textfield name="contractor.contractorName" label="Name" />
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
							<a class="ui-button edit-button" href="javascript:submitForm(addForm);">Create</a>
							<br />
						</div>
					</s:else>
				</div>
			</s:if>
			<s:else>
				No Contractors Found...
			</s:else>
		</div>
	</div>

	<jsp:include page="/includes/footer.jsp" />
</body>
</html>