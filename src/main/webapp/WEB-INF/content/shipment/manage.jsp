<%-- @authors Mitchell Nemitz, Kelly Smith, Alex McCracken --%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
<head>
	<title>Shipment Management</title>
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />
	<link rel="stylesheet" type="text/css"
		href="/ERS/styles/page/shipments.css">
	<script type="text/javascript">
		page = "shipments";
		pageSetup(page);
	</script>
</head>
<body>
	<div id="container">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">
			<h2>Shipment Management</h2>

			<s:if test="shipments.size > 0">
				<div id="columnSelect">
					<s:form name="manageColumns"
						action="manageColumns.action?action=shipment" id="columnSelectForm">
						<s:checkboxlist label="Choose Display Columns" list="columnLabels"
							name="columnLabels" value="visibleColumns" />
						<s:submit value="Update" />
					</s:form>
				</div>
				<div id="scrollContainer">
					<table id="shipments">
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

						<s:url id="updateRoute" value="updateRoute.action">
							<s:param name="id" value="id" />
						</s:url>

						<div id="editContainer">
							<s:form name="editForm" action="%{updateRoute}" id="routeForm">
								
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
								<s:url id="deleteUrl" value="deleteRoute.action">
									<s:param name="id" value="id" />
								</s:url>
								<s:a href="%{deleteUrl}">Delete</s:a>
							</div>
							<br />
							<div class="buttonDiv">
								<s:url id="clearUrl" value="shipmentManagement.action"></s:url>
								<s:a href="%{clearUrl}">Clear</s:a>
							</div>
							<br />
						</div>
					</s:if>

					<s:else>
						<div id="editContainer">
							<s:form name="addForm" action="addShipment.action" id="routeForm">
								<s:textfield name="shipment.timeEntered" label="Time Entered" />
								<s:textfield name="shipment.orderID" label="Order Id" />
								<s:select label="Vehicle Type" name="vehicleTypeSelect.selected"
									list="vehicleTypeSelect.list" listKey="id" listValue="toString()"
									value="vehicleTypeSelect.selected" />
								<s:select label="Location" name="locationSelect.selected"
									list="locationSelect.list" listKey="id" listValue="toString()"
									value="locationSelect.selected" />
								<s:select label="Route" name="routeSelect.selected"
									list="routeSelect.list" listKey="id" listValue="toString()"
									value="routeSelect.selected" />
								<s:textfield name="shipment.availableDate" label="Available Date" />
								<s:textfield name="shipment.releaseDate" label="Release Date" />
								<s:textfield name="shipment.releaseTime" label="Release Time" />
								<s:textfield name="shipment.earliestDelieveryDate" label="Earliest Delivery Date" />
								<s:textfield name="shipment.earliestDelieveryTime" label="Earliest Delievery Time" />
								<s:textfield name="shipment.latestDeliveryDate" label="Latest Delivery Date" />
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
									value="pooledDestinationSelect.selected" />
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
				No Shipments Found...
			</s:else>

		</div>
	</div>

	<jsp:include page="/includes/footer.jsp" />
</body>
</html>