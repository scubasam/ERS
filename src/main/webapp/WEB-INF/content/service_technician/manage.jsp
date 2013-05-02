<%-- @authors Mitchell Nemitz, Kelly Smith, Alex McCracken --%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
<head>
	<title>Service Technician Management</title>
	
	<jsp:include page="/includes/decorator.jsp" />

	<script type="text/javascript">
		page = "technicians";
		pageSetup(page);
	</script>
	
	<sx:head debug="true" cache="false" compressed="false" />
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">

			<s:if test="serviceTechnicians.size > 0">
				<div id="columnSelect">
					<s:form name="manageColumns"
						action="manageColumns.action?action=serviceTechnician" id="columnSelectForm">
						<s:checkboxlist label="Choose Display Columns" list="columnLabels"
							name="columnLabels" value="visibleColumns" />
						<s:submit value="Update" />
					</s:form>
				</div>
				<div id="dataContainer">
					<table id="serviceTechnician" class="dataTable">
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

						<s:url id="updateServiceTechnician" value="updateServiceTechnician.action">
							<s:param name="id" value="id" />
						</s:url>

						<div id="formContainer">
							<s:form name="editForm" action="%{updateServiceTechnician}" id="serviceTechnicianForm">
								<s:textfield name="serviceTechnician.skillGrade" label="Skill Grade" />							
								<s:select label="Contact" name="contactSelect.selected"
									list="contactSelect.list" listKey="id" listValue="toString()"
									value="contactSelect.selected" />
								<s:select label="Maintenance Order" name="maintenanceOrderSelect.selected"
									list="maintenanceOrderSelect.list" listKey="id" listValue="toString()"
									value="maintenanceOrderSelect.selected" />
							</s:form>
						</div>

						<div id="buttonContainer">
							<a class="ui-button edit-button" href="javascript:submitForm(editForm);">Update</a>
							<br />

							<s:url id="deleteUrl" value="deleteServiceTechnician.action">
								<s:param name="id" value="id" />
							</s:url>
							<s:a cssClass="ui-button edit-button" href="%{deleteUrl}">Delete</s:a>
							<br />

							<s:url id="clearUrl" value="serviceTechnicianManagement.action"></s:url>
							<s:a cssClass="ui-button edit-button" href="%{clearUrl}">Clear</s:a>
							<br />
						</div>
					</s:if>

					<s:else>
						<div id="formContainer">
							<s:form name="addForm" action="addServiceTechnician.action" id="serviceTechnicianForm">
								<s:textfield name="serviceTechnician.skillGrade" label="Skill Grade" />							
								<s:select label="Contact" name="contactSelect.selected"
									list="contactSelect.list" listKey="id" listValue="toString()"
									value="contactSelect.selected" />
								<s:select label="MaintenanceOrder" name="maintenanceOrderSelect.selected"
									list="maintenanceOrderSelect.list" listKey="id" listValue="toString()"
									value="maintenanceOrderSelect.selected" />
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
				No Service Technicians...
			</s:else>
		</div>
	</div>

	<jsp:include page="/includes/footer.jsp" />
</body>
</html>