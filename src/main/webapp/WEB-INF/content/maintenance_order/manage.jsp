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
		href="/ERS/styles/page/routes.css">
	<script type="text/javascript">
		page = "maintenanceorders";
		pageSetup(page);
	</script>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">
			<h2>Maintenance Order</h2>

			<s:if test="maintenanceOrders.size > 0">
				<div id="columnSelect">
					<s:form name="manageColumns"
						action="manageColumns.action?action=maintenanceOrder" id="columnSelectForm">
						<s:checkboxlist label="Choose Display Columns" list="columnLabels"
							name="columnLabels" value="visibleColumns" />
						<s:submit value="Update" />
					</s:form>
				</div>
				<div id="dataContainer">
					<table id="mainteanceOrder">
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

						<s:url id="updateMaintenanceOrder" value="updateMainteanceOrder.action">
							<s:param name="id" value="id" />
						</s:url>

						<div id="formContainer">
							<s:form name="editForm" action="%{updateMainteanceOrder}" id="mainteanceOrderForm">
								<s:select label="Vehicle" name="vehicleSelect.selected"
									list="vehicleSelect.list" listKey="id" listValue="toString()"
									value="vehicleSelect.selected" />
								<s:select label="Service Technician" name="serviceTechnicianSelect.selected"
									list="serviceTechnicianSelect.list" listKey="id" listValue="toString()"
									value="serviceTechnicianSelect.selected" />
								<s:select label="Driver" name="drierSelect.selected"
									list="driverSelect.list" listKey="id" listValue="toString()"
									value="driverSelect.selected" />
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
								<s:url id="deleteUrl" value="deleteMaintenanceOrder.action">
									<s:param name="id" value="id" />
								</s:url>
								<s:a href="%{deleteUrl}">Delete</s:a>
							</div>
							<br />
							<div class="buttonDiv">
								<s:url id="clearUrl" value="mainteanceOrderManagement.action"></s:url>
								<s:a href="%{clearUrl}">Clear</s:a>
							</div>
							<br />
						</div>
					</s:if>

					<s:else>
						<div id="formContainer">
							<s:form name="addForm" action="addMaintenanceOrder.action" id="mainteanceOrderForm">
								<s:select label="Vehicle" name="vehicleSelect.selected"
									list="vehicleSelect.list" listKey="id" listValue="toString()"
									value="vehicleSelect.selected" />
								<s:select label="Service Technician" name="serviceTechnicianSelect.selected"
									list="serviceTechnicianSelect.list" listKey="id" listValue="toString()"
									value="serviceTechnicianSelect.selected" />
								<s:select label="Driver" name="drierSelect.selected"
									list="driverSelect.list" listKey="id" listValue="toString()"
									value="driverSelect.selected" />
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
				No Maintenance Order
			</s:else>
		</div>
	</div>

	<jsp:include page="/includes/footer.jsp" />
</body>
</html>