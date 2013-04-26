<%-- @authors Mitchell Nemitz, Kelly Smith, Alex McCracken --%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
<head>
	<title>Maintenance Order</title>
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />
	<link rel="stylesheet" type="text/css"
		href="/ERS/styles/page/servicetechnician.css">
	<script type="text/javascript">
		page = "technicians";
		pageSetup(page);
	</script>
</head>
<body>
	<div id="container">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">
			<h2>Maintenance Order</h2>

			<s:if test="serviceTechnicians.size > 0">
				<div id="columnSelect">
					<s:form name="manageColumns"
						action="manageColumns.action?action=serviceTechnician" id="columnSelectForm">
						<s:checkboxlist label="Choose Display Columns" list="columnLabels"
							name="columnLabels" value="visibleColumns" />
						<s:submit value="Update" />
					</s:form>
				</div>
				<div id="scrollContainer">
					<table id="serviceTechnician">
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

				<div id="panel2">
					<jsp:include page="/includes/error_header.jsp" />
					<s:if test="getMode()=='edit'">

						<s:url id="updateServiceTechnician" value="updateServiceTechnician.action">
							<s:param name="id" value="id" />
						</s:url>

						<div id="editContainer">
							<s:form name="editForm" action="%{updateServiceTechnician}" id="serviceTechnicianForm">
								<s:select label="Contact" name="contactSelect.selected"
									list="contactSelect.list" listKey="id" listValue="toString()"
									value="contactSelect.selected" />
								<s:select label="Maintenance Order" name="maintenanceOrderSelect.selected"
									list="maintenanceOrderSelect.list" listKey="id" listValue="toString()"
									value="maintenanceOrderSelect.selected" />
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
								<s:url id="deleteUrl" value="deleteServiceTechnician.action">
									<s:param name="id" value="id" />
								</s:url>
								<s:a href="%{deleteUrl}">Delete</s:a>
							</div>
							<br />
							<div class="buttonDiv">
								<s:url id="clearUrl" value="serviceTechnicianManagement.action"></s:url>
								<s:a href="%{clearUrl}">Clear</s:a>
							</div>
							<br />
						</div>
					</s:if>

					<s:else>
						<div id="editContainer">
							<s:form name="addForm" action="addServiceTechnician.action" id="serviceTechnicianForm">
								<s:select label="Contact" name="contactSelect.selected"
									list="contactSelect.list" listKey="id" listValue="toString()"
									value="contactSelect.selected" />
								<s:select label="MaintenanceOrder" name="maintenanceOrderSelect.selected"
									list="maintenanceOrderSelect.list" listKey="id" listValue="toString()"
									value="maintenanceOrderSelect.selected" />
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
				No Service Technicians...
			</s:else>
		</div>
	</div>

	<jsp:include page="/includes/footer.jsp" />
</body>
</html>