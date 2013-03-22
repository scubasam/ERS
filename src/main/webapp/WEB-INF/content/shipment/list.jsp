<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<html>
<head>
<title>Shipment List</title>
<sx:head debug="true" cache="false" compressed="false" />
</head>
<body>
 <jsp:include page="/WEB-INF/content/header.jsp" />
<p>Shipment List</p>

<s:if test="shipments.size > 0">
	<table id="shipments">
		<tr>
			<th>Time Entered</th><th>Order Id</th><th>Vehicle Type</th><th>Location</th>
			<th>Route</th><th>Available Date</th><th>Available Time</th><th>Release Date</th>
			<th>Release Time</th><th>Earliest Delivery</th><th></th><th>Latest Delivery</th><th></th>
			<th>Service Time</th><th>Weight</th><th>Cubic Weight</th><th>Customer Name</th>
			<th>Destination</th><th>Pooled Shipment</th><th>Pooled Destination</th>
		</tr>
		<s:iterator value="shipments">
			<tr>
				<td><s:property value="timeEntered" /></td>
				<td><s:property value="orderId" /></td>
				<td><s:property value="vehicleType" /></td>
				<td><s:property value="location" /></td>
				<td><s:property value="route" /></td>
				<td><s:property value="availableDate" /></td>
				<td><s:property value="availableTime" /></td>
				<td><s:property value="releaseDate" /></td>
				<td><s:property value="releaseTime" /></td>
				<td><s:property value="earliestDeliveryTime" /></td>
				<td><s:property value="earliestDeliveryDate" /></td>
				<td><s:property value="latestDeliveryDate" /></td>
				<td><s:property value="latestDeliveryTime" /></td>
				<td><s:property value="serviceTime" /></td>
				<td><s:property value="weight" /></td>
				<td><s:property value="cubicWeight" /></td>
				<td><s:property value="customerName" /></td>
				<td><s:property value="destination" /></td>
				<td><s:property value="pooledShipment" /></td>
				<td><s:property value="pooledDestination" /></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
	No Shipments Found...
</s:else>

<jsp:include page="/WEB-INF/content/footer.jsp" />
</body>
</html>