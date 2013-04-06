<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Shipment</title>
<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("shipments");
	</script>
</head>
<body>
<div id="container">
<jsp:include page="/includes/header.jsp" />
 
<s:form name="addShipment" method="post" action="addShipment.action">
 
	<s:textfield name="shipment.timeEntered" label="timeEntered" />
	<s:textfield name="shipment.orderID" label="orderID" />
	<s:textfield name="shipment.vehicleType" label="vehicleType" />
	<s:textfield name="shipment.location" label="location" />
	<s:textfield name="shipment.route" label="route" />
	<s:textfield name="shipment.location" label="location" />
	<s:textfield name="shipment.route" label="route" />
	<s:textfield name="shipment.availableDate" label="availableDate" />
	<s:textfield name="shipment.releaseDate" label="releaseDate" />
	<s:textfield name="shipment.releaseTime" label="releaseTime" />
	<s:textfield name="shipment.earliestDelieveryDate" label="earliestDeliveryDate" />
	<s:textfield name="shipment.earliestDelieveryTime" label="earliestDelieveryTime" />
	<s:textfield name="shipment.latestDeliveryDate" label="latestDeliveryDate" />
	<s:textfield name="shipment.latestDeliveryTime" label="latestDeliveryTime" />
	<s:textfield name="shipment.serviceTime" label="serviceTime" />
	<s:textfield name="shipment.cubicWeight" label="cubicWeight" />
	<s:textfield name="shipment.customerName" label="customerName" />
	<s:textfield name="shipment.destination" label="destination" />
	<s:textfield name="shipment.pooledShipment" label="pooledShipment" />
	<s:textfield name="shipment.pooledDestination" label="pooledDestination" />
	<s:submit type="button" name="Add Shipment" />
	
 </s:form>
 </div>
 <jsp:include page="/includes/footer.jsp" />
</body>
</html>