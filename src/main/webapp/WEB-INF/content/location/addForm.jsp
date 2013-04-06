<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Add Location</title>
<s:head />
<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("locations");
	</script>
</head>
<body>
<div id="container">
<jsp:include page="/includes/header.jsp" />

<s:if test="isError">
	<s:property value="errorMessage" />
</s:if>
 
<s:form name="addLocation" action="addLocation.action">

	<s:textfield name="location.name" label="Location Name" />
	<s:textfield name="location.StreetAddress1" label="Street Address 1" />
	<s:textfield name="location.StreetAddress2" label="Street Address 2" />
	<s:textfield name="location.City" label="City" />
	<s:textfield name="location.Zip" label="Zip Code" />
	<s:textfield name="location.RoadName" label="Road" />
	<s:textfield name="location.RoadNumber" label="Road Number" />
	<s:textfield name="location.Latitude" label="Latitude" />
	<s:textfield name="location.Longitude" label="Longitude" />	
	<s:textfield name="location.Type" label="Location Type" />
	<s:textfield name="contractor.contractorName" label="ContractorName" />
	<s:textfield name="vehicle.vehicles" label="Vehicles at Location" />								
	
	<s:submit type="button" name="Add Location" />				
	</s:form>
	
	</div>
	<jsp:include page="/includes/footer.jsp" />
	
</body>
</html>