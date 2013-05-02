<%-- @authors Mitchell Nemitz, Kelly Smith, Alex McCracken --%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
<head>
	<title>Shipment Management</title>
	
	<jsp:include page="/includes/decorator.jsp" />

	<script type="text/javascript">
		page = "shipments";
		pageSetup(page);
	</script>
	
	<sx:head debug="true" cache="false" compressed="false" />
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/includes/header.jsp" />
		
		<div id="content">

			<s:if test="shipments.size > 0">
				<div id="columnSelect">
					<s:form name="manageColumns"
						action="manageColumns.action?action=shipment" id="columnSelectForm">
						<s:checkboxlist label="Choose Display Columns" list="columnLabels"
							name="columnLabels" value="visibleColumns" />
						<s:submit value="Update" />
					</s:form>
				</div>
				<div id="dataContainer">
					<table id="shipments" class="dataTable">
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

						<s:url id="updateShipment" value="updateShipment.action">
							<s:param name="id" value="id" />
						</s:url>

						<div id="formContainer">
							<s:form name="editForm" action="%{updateShipment}" id="shipmentForm">
								<s:textfield name="shipment.orderId" label="Order Id" />
								<s:select label="Vehicle Type" name="vehicleTypeSelect.selected"
									list="vehicleTypeSelect.list" listKey="id" listValue="toString()"
									value="vehicleTypeSelect.selected" />
								<s:select label="Location" name="locationSelect.selected"
									list="locationSelect.list" listKey="id" listValue="toString()"
									value="locationSelect.selected" />
								<s:select label="Route" name="routeSelect.selected"
									list="routeSelect.list" listKey="id" listValue="toString()"
									value="routeSelect.selected" />
								<sx:datetimepicker name="shipment.availableDate" displayFormat="dd-MMM-yyyy" label="Available Date" />
								<sx:datetimepicker name="shipment.releaseDate" displayFormat="dd-MMM-yyyy" label="Release Date" />
								<s:textfield name="shipment.releaseTime" label="Release Time" />
								<sx:datetimepicker name="shipment.earliestDeliveryDate" displayFormat="dd-MMM-yyyy" label="Earliest Delivery Date" />
								<s:textfield name="shipment.earliestDelieveryTime" label="Earliest Delievery Time" />
								<sx:datetimepicker name="shipment.latestDeliveryDate" displayFormat="dd-MMM-yyyy" label="Latest Delivery Date" />
								<s:textfield name="shipment.latestDeliveryTime" label="Latest Delivery Time" />
								<s:textfield name="shipment.serviceTime" label="Service Time" />
								<s:textfield name="shipment.weight" label="Weight" />
								<s:textfield name="shipment.cubicWeight" label="Cubic Weight" />
								<s:textfield name="shipment.customerName" label="Customer Name" />
								<s:select label="Destination" name="destinationSelect.selected"
									list="destinationSelect.list" listKey="id" listValue="toString()"
									value="destinationSelect.selected" />
								<s:textfield name="shipment.pooledShipment" label="Pooled Shipment" />
								<s:select label="Pooled Destination" name="pooledDestinationSelect.selected"
									list="pooledDestinationSelect.list" listKey="id" listValue="toString()"
									value="pooledDestinationSelect.selected" emptyOption="true" />
							</s:form>
						</div>

						<div id="buttonContainer">
							<a class="ui-button edit-button" href="javascript:submitForm(editForm);">Update</a>
							<br />

							<s:url id="deleteUrl" value="deleteShipment.action">
								<s:param name="id" value="id" />
							</s:url>
							<s:a cssClass="ui-button edit-button" href="%{deleteUrl}">Delete</s:a>
							<br />

							<s:url id="clearUrl" value="shipmentManagement.action"></s:url>
							<s:a cssClass="ui-button edit-button" href="%{clearUrl}">Clear</s:a>
							<br />
						</div>
					</s:if>

					<s:else>
						<div id="formContainer">
							<s:form name="addForm" action="addShipment.action" id="routeForm">
								<s:textfield name="shipment.orderId" label="Order Id" />
								<s:select label="Vehicle Type" name="vehicleTypeSelect.selected"
									list="vehicleTypeSelect.list" listKey="id" listValue="toString()"
									value="vehicleTypeSelect.selected" />
								<s:select label="Location" name="locationSelect.selected"
									list="locationSelect.list" listKey="id" listValue="toString()"
									value="locationSelect.selected" />
								<s:select label="Route" name="routeSelect.selected"
									list="routeSelect.list" listKey="id" listValue="toString()"
									value="routeSelect.selected" />
								<sx:datetimepicker name="shipment.availableDate" displayFormat="dd-MMM-yyyy" label="Available Date" />
								<sx:datetimepicker name="shipment.releaseDate" displayFormat="dd-MMM-yyyy" label="Release Date" />
								<s:textfield name="shipment.releaseTime" label="Release Time" />
								<sx:datetimepicker name="shipment.earliestDeliveryDate" displayFormat="dd-MMM-yyyy" label="Earliest Delivery Date" />
								<s:textfield name="shipment.earliestDelieveryTime" label="Earliest Delievery Time" />
								<sx:datetimepicker name="shipment.latestDeliveryDate" displayFormat="dd-MMM-yyyy" label="Latest Delivery Date" />
								<s:textfield name="shipment.latestDeliveryTime" label="Latest Delivery Time" />
								<s:textfield name="shipment.serviceTime" label="Service Time" />
								<s:textfield name="shipment.weight" label="Weight" />
								<s:textfield name="shipment.cubicWeight" label="Cubic Weight" />
								<s:textfield name="shipment.customerName" label="Customer Name" />
								<s:select label="Destination" name="destinationSelect.selected"
									list="destinationSelect.list" listKey="id" listValue="toString()"
									value="destinationSelect.selected" />
								<s:textfield name="shipment.pooledShipment" label="Pooled Shipment" />
								<s:select label="Pooled Destination" name="pooledDestinationSelect.selected"
									list="pooledDestinationSelect.list" listKey="id" listValue="toString()"
									value="pooledDestinationSelect.selected" emptyOption="true" />
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
				No Shipments Found...
			</s:else>

		</div>
	</div>

	<jsp:include page="/includes/footer.jsp" />
</body>
</html>