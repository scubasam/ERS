<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Add Location</title>
<s:head />
<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("contractors");
	</script>
</head>
<body>
<div id="container">
<jsp:include page="/includes/header.jsp" />

<s:if test="isError">
	<s:property value="errorMessage" />
</s:if>
 
<s:form name="addLocation" action="addLocation.action">

	<s:textfield name="location.locationName" label="Location Name" />
	<s:textfield name="location.locationStreetAddress1" label="Street Address 1" />
	<s:textfield name="location.locationStreetAddress2" label="Street Address 2" />
	<s:textfield name="location.locationCity" label="City" />
	<s:textfield name="location.locationZip" label="Zip Code" />
	<s:textfield name="location.locationRoadName" label="Road" />
	<s:textfield name="location.locationRoadNumber" label="Road Number" />
	<s:textfield name="location.locationLatitude" label="Latitude" />
	<s:textfield name="contractor.contractorName" label="ContractorName" />
	<s:textfield name="location.locationType" label="Location Type" />
	<s:textfield name="vehicle.vehicles" label="Vehicles at Location" />								
	<s:submit type="button" name="Add Location" />
						
	</s:form>
	</div>
	<jsp:include page="/includes/footer.jsp" />
	
</body>
</html>