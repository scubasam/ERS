<%-- @authors Mitchell Nemitz, Kelly Smith, Alex McCracken --%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
<head>
	<title>Vehicle Management</title>
	
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />

	<script type="text/javascript">
		page = "vehicles";
		pageSetup(page);
	</script>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">

			<s:if test="vehicles.size > 0">
				<div id="columnSelect">
					<s:form name="manageColumns"
						action="manageColumns.action?action=vehicle" id="columnSelectForm">
						<s:checkboxlist label="Choose Display Columns" list="columnLabels"
							name="columnLabels" value="visibleColumns" />
						<s:submit value="Update" />
					</s:form>
				</div>
				<div id="dataContainer">
					<table id="mainteanceOrder" class="dataTable">
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

						<s:url id="updateVehicle" value="updateVehicle.action">
							<s:param name="id" value="id" />
						</s:url>

						<div id="formContainer">
							<s:form name="editForm" action="%{updateVehicle}" id="vehicleForm">
								<s:textfield name="vehicle.plateNumber" label="Plate Number" />
								<s:textfield name="vehicle.vinNumber" label="Vin" />
								<s:textfield name="vehicle.manufacturedYear" label="Manufactured Year" />
								<s:select label="Vehicle Type" name="vehicleTypeSelect.selected"
									list="vehicleTypeSelect.list" listKey="id" listValue="toString()"
									value="vehicleTypeSelect.selected" />
								<s:select label="Contractor" name="contractorSelect.selected"
									list="contractorSelect.list" listKey="id" listValue="toString()"
									value="contractorSelect.selected" />
								<s:select label="Location" name="locationSelect.selected"
									list="locationSelect.list" listKey="id" listValue="toString()"
									value="locationSelect.selected" />
								<s:select label="Driver" name="driverSelect.selected"
									list="driverSelect.list" listKey="id" listValue="toString()"
									value="driverSelect.selected" />
							</s:form>
						</div>

						<div id="buttonContainer">
							<a class="ui-button edit-button" href="javascript:submitForm(editForm);">Update</a>
							<br />

							<s:url id="deleteUrl" value="deleteVehicle.action">
								<s:param name="id" value="id" />
							</s:url>
							<s:a cssClass="ui-button edit-button" href="%{deleteUrl}">Delete</s:a>
							<br />

							<s:url id="clearUrl" value="vehicleManagement.action"></s:url>
							<s:a cssClass="ui-button edit-button" href="%{clearUrl}">Clear</s:a>
							<br />
						</div>
					</s:if>

					<s:else>
						<div id="formContainer">
							<s:form name="addForm" action="addVehicle.action" id="vehicleForm">
								<s:textfield name="vehicle.plateNumber" label="Plate Number" />
								<s:textfield name="vehicle.vinNumber" label="Vin" />
								<s:textfield name="vehicle.manufacturedYear" label="Manufactured Year" />								
								<s:select label="Vehicle Type" name="vehicleTypeSelect.selected"
									list="vehicleTypeSelect.list" listKey="id" listValue="toString()"
									value="vehicleTypeSelect.selected" />
								<s:select label="Contractor" name="contractorSelect.selected"
									list="contractorSelect.list" listKey="id" listValue="toString()"
									value="contractorSelect.selected" />
								<s:select label="Location" name="locationSelect.selected"
									list="locationSelect.list" listKey="id" listValue="toString()"
									value="locationSelect.selected" />
								<s:select label="Driver" name="driverSelect.selected"
									list="driverSelect.list" listKey="id" listValue="toString()"
									value="driverSelect.selected" />
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
				No vehicles...
			</s:else>
		</div>
	</div>

	<jsp:include page="/includes/footer.jsp" />
</body>
</html>