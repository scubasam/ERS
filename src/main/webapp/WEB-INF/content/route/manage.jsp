<%-- @authors Mitchell Nemitz, Kelly Smith, Alex McCracken --%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
<head>
	<title>Route Management</title>
	
	<jsp:include page="/includes/decorator.jsp" />
	
	<style type="text/css">
	#leftPanel {
		float: left;
		width: 50%;
		height: 300px;
		margin-top: 4px;
		margin-bottom: 23px;
	}
	
	#rightPanel {
		float: right;
		width: 50%;
		height: 300px;
		margin-top: 4px;
		margin-bottom: 23px;
	}
	
	#allShipments {
		height: 100%;
		display: block;
		overflow: auto;
		margin-top: 4px;
	}
	
	#shipmentList {
		height: 100%;
		display: block;
		overflow: auto;
		margin-top: 4px;
	}
	</style>
	
	<script type="text/javascript">
		page = "routes";
		pageSetup(page);
	</script>
	
	<sx:head debug="true" cache="false" compressed="false" />
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">

			<s:if test="routes.size > 0">
				<div id="columnSelect">
					<s:form name="manageColumns"
						action="manageColumns.action?action=route" id="columnSelectForm">
						<s:checkboxlist label="Choose Display Columns" list="columnLabels"
							name="columnLabels" value="visibleColumns" />
						<s:submit value="Update" />
					</s:form>
				</div>
				
				<div id="dataContainer" class="dataTable">
					<table id="routes">
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

						<s:url id="updateRoute" value="updateRoute.action">
							<s:param name="id" value="id" />
						</s:url>

						<div id="formContainer">
							<s:form name="editForm" action="%{updateRoute}" id="routeForm">
								<s:select label="Vehicle" name="vehicleSelect.selected"
									list="vehicleSelect.list" listKey="id" listValue="toString()"
									value="vehicleSelect.selected" />
									
									
									<div id="leftPanel">
										<h3>All Shipments</h3>
										<ul id="allShipments">
											<s:iterator value="unselectedShipments">
												<li class="ui-state-default" style="height: 24px; padding-top: 4px;" value="<s:property value="id" />">
												<span style="display: inline-block;" class="ui-icon ui-icon-arrowthick-2-n-s"></span><s:property value="orderId" /></li>
											</s:iterator>
										</ul>
									</div>
									
									<div id="rightPanel">
										<h3>Shipment Order</h3>
										<ul id="shipmentList">
											<s:iterator value="route.orderedShipments">
												<li class="ui-state-default" style="height: 24px; padding-top: 4px;" value="<s:property value="id" />">
												<span style="display: inline-block;" class="ui-icon ui-icon-arrowthick-2-n-s"></span><s:property value="orderId" /></li>
											</s:iterator>
										</ul>
									</div>
									
									<s:hidden id="orderedShipmentList" type="hidden" name="shipmentList" />
							</s:form>
						</div>

						<div id="buttonContainer">
							<a class="ui-button edit-button" href="javascript:submitForm(editForm);">Update</a>
							<br />

							<s:url id="deleteUrl" value="deleteRoute.action">
								<s:param name="id" value="id" />
							</s:url>
							<s:a cssClass="ui-button edit-button" href="%{deleteUrl}">Delete</s:a>
							<br />

							<s:url id="clearUrl" value="routeManagement.action"></s:url>
							<s:a cssClass="ui-button edit-button" href="%{clearUrl}">Clear</s:a>
							<br />
						</div>
					</s:if>

					<s:else>
						<div id="dualFormContainer">
							<s:form name="addForm" action="addRoute.action" id="routeForm">
								<s:select label="Vehicle" name="vehicleSelect.selected" list="vehicleSelect.list" listKey="id" listValue="toString()" />
									
									<div id="leftPanel">
										<h3>All Shipments</h3>
										<ul id="allShipments">
											<s:iterator value="allShipments">
												<li class="ui-state-default" style="height: 24px; padding-top: 4px;" value="<s:property value="id" />">
												<span style="display: inline-block;" class="ui-icon ui-icon-arrowthick-2-n-s"></span><s:property value="orderId" /></li>
											</s:iterator>
										</ul>
									</div>
									
									<div id="rightPanel">
										<h3>Shipment Order</h3>
										<ul id="shipmentList">
											<s:iterator value="route.orderedShipments">
												<li class="ui-state-default" style="height: 24px; padding-top: 4px;" value="<s:property value="id" />">
												<span style="display: inline-block;" class="ui-icon ui-icon-arrowthick-2-n-s"></span><s:property value="orderId" /></li>
											</s:iterator>
										</ul>
									</div>
									
									<s:hidden id="orderedShipmentList" type="hidden" name="shipmentList" />
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
				No Routes Found...
			</s:else>

		</div>
	</div>

	<jsp:include page="/includes/footer.jsp" />
	<script type="text/javascript">
		$("#shipmentList").disableSelection();
		$("#allShipments").disableSelection();

		$("#allShipments").sortable({
			placeholder: "ui-state-highlight",
		    cursor: 'crosshair',
		    connectWith: '#shipmentList'
		});
		
		$("#shipmentList").sortable({
		    placeholder: "ui-state-highlight",
		    cursor: 'crosshair',
		    connectWith: '#allShipments',
		    update: function(event, ui) {
		        var order = $("#shipmentList").sortable("toArray", {attribute: 'value'});
		        $('#orderedShipmentList').val(order.join(","));
		        console.log($('#orderedShipmentList').val());
		    }
		});
	</script>
</body>
</html>