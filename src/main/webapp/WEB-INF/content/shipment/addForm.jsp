<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Shipment</title>
</head>
<body>
 
<p>Shipment</p>
 
<s:form name="shipment" method="post" action="shipment.action">
 
	<s:textfield name="timeEntered" label="timeEntered" />
	<s:textfield name="orderID" label="orderID" />
	<s:textfield name="vehicleType" label="vehicleType" />
	<s:textfield name="location" label="location" />
	<s:textfield name="route" label="route" />
	<s:textfield name="location" label="location" />
	<s:textfield name="route" label="route" />
	<s:textfield name="availableDate" label="availableDate" />
	<s:textfield name="releaseDate" label="releaseDate" />
	<s:textfield name="releaseTime" label="releaseTime" />
	<s:textfield name="earliestDelieveryDate" label="earliestDeliveryDate" />
	<s:textfield name="earliestDelieveryTime" label="earliestDelieveryTime" />
	<s:textfield name="latestDeliveryDate" label="latestDeliveryDate" />
	<s:textfield name="latestDeliveryTime" label="latestDeliveryTime" />
	<s:textfield name="serviceTime" label="serviceTime" />
	<s:textfield name="cubicWeight" label="cubicWeight" />
	<s:textfield name="customerName" label="customerName" />
	<s:textfield name="destination" label="destination" />
	<s:textfield name="pooledShipment" label="pooledShipment" />
	<s:textfield name="pooledDestination" label="pooledDestination" />
	<s:submit type="button" name="Add" />
	
 </s:form>
 
</body>
</html>