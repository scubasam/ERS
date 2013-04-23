<%-- @authors Mitchell Nemitz, Kelly Smith, Alex McCracken --%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
<head>
	<title>Vehicle Type Management</title>
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />
	<link rel="stylesheet" type="text/css"
		href="/ERS/styles/vehicletypes.css">
	<script type="text/javascript">
		page = "vehicletypes";
		pageSetup(page);
	</script>
</head>
<body>
	<div id="container">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">
			<h2>Vehicle Type Management</h2>

			<s:if test="vehicleTypes.size > 0">
				<div id="columnSelect">
					<s:form name="manageColumns"
						action="manageColumns.action?action=vehicleType"
						id="columnSelectForm">
						<s:checkboxlist label="Choose Display Columns" list="columnLabels"
							name="columnLabels" value="visibleColumns" />
						<s:submit value="Update" />
					</s:form>
				</div>

				<div id="scrollContainer">
					<table id="vehicletypes">
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

						<div id="editContainer">
							<s:url id="updateLocation" value="updateVehicleType.action">
								<s:param name="id" value="id" />
							</s:url>

							<s:form name="editForm" action="%{updateLocation}">
								<s:textfield name="vehicleType.type" label="Type" />
								<s:textfield name="vehicleType.subType" label="Sub Type" />
								<s:textfield name="vehicleType.description" label="Description" />
								<s:textfield name="vehicleType.make" label="Make" />
								<s:textfield name="vehicleType.model" label="Model" />
								<s:textfield name="vehicleType.maximumWeight"
									label="Minimum Weight" />
								<s:textfield name="vehicleType.minimumWeight"
									label="Maximum Weight" />
								<s:textfield name="vehicleType.maximumRange"
									label="Maximum Range" />
								<s:textfield name="vehicleType.capacity" label="Capacity" />
								<s:textfield name="vehicleType.restrictions"
									label="Restrictions" />
								<s:textfield name="vehicleType.height" label="Height" />
								<s:textfield name="vehicleType.emptyWeight" label="Empty Weight" />
								<s:textfield name="vehicleType.length" label="Length" />
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
								<s:url id="deleteUrl" value="deleteVehicleType.action">
									<s:param name="id" value="id" />
								</s:url>
								<s:a href="%{deleteUrl}">Delete</s:a>
							</div>
							<br />
							<div class="buttonDiv">
								<s:url id="clearUrl" value="vehicleTypeManagement.action"></s:url>
								<s:a href="%{clearUrl}">Clear</s:a>
							</div>
							<br />
						</div>
					</s:if>

					<s:else>
						<div id="editContainer">
							<s:form name="addForm" action="addVehicleType.action">
								<s:textfield name="vehicleType.type" label="Type" />
								<s:textfield name="vehicleType.subType" label="Sub Type" />
								<s:textfield name="vehicleType.description" label="Description" />
								<s:textfield name="vehicleType.make" label="Make" />
								<s:textfield name="vehicleType.model" label="Model" />
								<s:textfield name="vehicleType.maximumWeight"
									label="Minimum Weight" />
								<s:textfield name="vehicleType.minimumWeight"
									label="Maximum Weight" />
								<s:textfield name="vehicleType.capacity" label="Capacity" />
								<s:textfield name="vehicleType.maximumRange"
									label="Maximum Range" />
								<s:textfield name="vehicleType.restrictions"
									label="Restrictions" />
								<s:textfield name="vehicleType.height" label="Height" />
								<s:textfield name="vehicleType.emptyWeight" label="Empty Weight" />
								<s:textfield name="vehicleType.length" label="Length" />
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
				No Vehicle Types Found...
			</s:else>

		</div>
	</div>
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>