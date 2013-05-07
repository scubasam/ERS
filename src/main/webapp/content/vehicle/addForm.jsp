<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Vehicle</title>
<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("vehicles");
	</script>
</head>
<body>
<div id="container">
<jsp:include page="/includes/header.jsp" />

<s:form name="addvehicle" method="post" action="addVehicle.action">
	
	<s:textfield name="vehicle.id" label="id" />
	<s:textfield name="vehicle.plateNumber" label="plateNumber" />
	<s:textfield name="vehicle.vinNumber" label="vinNumber" />
	<s:textfield name="vehicle.manufacturedYear" label="manufacturedYear" />
	<s:textfield name="vehicle.status" label="status" />
	<s:textfield name="vehicle.vehicleType" label="vehicleType" />
	<s:textfield name="vehicle.contractor" label="contractor" />
	<s:textfield name="vehicle.location" label="location" />	
	<s:submit type="button" name="Add Vehicle" />
	
 </s:form>
 </div>
 <jsp:include page="/includes/footer.jsp" />
</body>
</html>