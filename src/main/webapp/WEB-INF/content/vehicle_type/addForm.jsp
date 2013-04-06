<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Add Vehicle Type</title>
<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("vehicle_types");
	</script>
</head>
<body>
<div id="container">
<jsp:include page="/includes/header.jsp" /> 
 
<s:form name="addVehicleType" method="post" action="addVehicleType.action">
	
	<s:textfield name="vehicleType.id" label="id" />
	<s:textfield name="vehicleType.type" label="type" />
	<s:textfield name="vehicleType.subType" label="subType" />
	<s:textfield name="vehicleType.description" label="description" />
	<s:textfield name="vehicleType.make" label="make" />
	<s:textfield name="vehicleType.model" label="model" />
	<s:textfield name="vehicleType.maximumWeight" label="maximumWeight" />
	<s:textfield name="vehicleType.minimumWeight" label="minimumWeight" />
	<s:textfield name="vehicleType.maximumRange" label="maximumRange" />
	<s:textfield name="vehicleType.capacity" label="capacity" />
	<s:textfield name="vehicleType.restrictions" label="restrictions" />
	<s:textfield name="vehicleType.height" label="height" />
	<s:textfield name="vehicleType.emptyWeight" label="emptyWeight" />
	<s:textfield name="vehicleType.length" label="length" />
	<s:submit type="button" name="Add Vehicle Type" />
	
 </s:form>
 </div>
 <jsp:include page="/includes/footer.jsp" />
</body>
</html>