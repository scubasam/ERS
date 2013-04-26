<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Maintenance Order</title>
<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("maintenanceorders");
	</script>
</head>
<body>
<div id="container">
<jsp:include page="/includes/header.jsp" />

<s:form name="addForm" method="post" action="addMaintenanceOrder.action">

	<s:textfield name="maintenanceOrder.id" label="id" /> 
	<s:textfield name="maintenanceOrder.requester" label="requester" />
	<s:textfield name="maintenanceOrder.serviceTechnician" label="serviceTechnician" />
	<s:textfield name="maintenanceOrder.scheduleDate" label="scheduleDate" />
	<s:textfield name="maintenanceOrder.details" label="details" />
	<s:textfield name="maintenanceOrder.serviceTypeKey" label="serviceTypeKey" />
	<s:textfield name="maintenanceOrder.cost" label="cost" />
	<s:textfield name="maintenanceOrder.statusKey" label="statusKey" />
	<s:textfield name="Vehicle.vehicle" label="vehicle" />
	<s:textfield name="maintenanceOrder.maintenanceType" label="maintenanceType" />	
	<s:submit type="button" name="Add MaintenanceOrder" />
		
 </s:form>
 </div>
 <jsp:include page="/includes/footer.jsp" />
</body>
</html>
