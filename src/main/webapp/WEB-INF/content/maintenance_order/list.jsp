<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<html>
<head>
<title>Maintenance Orders List</title>
<sx:head debug="true" cache="false" compressed="false" />
</head>
<body>
 <jsp:include page="/includes/header.jsp" />
<p>Maintenance Orders List</p>

<s:if test="orders.size > 0">
	<table id="orders">
		<tr>
			<th>Requester</th><th>Service Technician</th><th>Scheduled Date</th>
			<th>Details</th><th>Service Type</th><th>Cost</th>
			<th>Status</th><th>Vehicle</th><th>Maintenance Type</th>
		</tr>
		<s:iterator value="orders">
			<tr>
				<td><s:property value="requester" /></td>
				<td><s:property value="serviceTechnician" /></td>
				<td><s:property value="scheduledDate" /></td>
				<td><s:property value="details" /></td>
				<td><s:property value="serviceTypeKey" /></td>
				<td><s:property value="cost" /></td>
				<td><s:property value="statusKey" /></td>
				<td><s:property value="vehicle" /></td>
				<td><s:property value="maintenanceType" /></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
	No Orders Found...
</s:else>

<jsp:include page="/includes/footer.jsp" />
</body>
</html>