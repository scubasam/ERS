<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Location</title>
<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("locations");
	</script>
</head>
<body>
 
<p>Location</p>
 
<s:form name="location" method="post" action="location.action">

	<s:textfield name="id" label="id" /> 
	<s:textfield name="name" label="name" />
	<s:textfield name="streetAddress1" label="streetAddress1" />
	<s:textfield name="streetAddress2" label="streetAddress2" />
	<s:textfield name="city" label="city" />
	<s:textfield name="state" label="state" />
	<s:textfield name="zip" label="zip" />
	<s:textfield name="roadName" label="roadName" />
	<s:textfield name="roadNumber" label="roadNumber" />	
	<s:textfield name="latitude" label="latitude" />	
	<s:textfield name="longitude" label="longitude" />	
	<s:textfield name="vehicles" label="vehicles" />
	<s:textfield name="locationType" label="locationType" />	
	<s:textfield name="contractor" label="contractor" />
	<s:textfield name="vehicles" label="vehicles" />	
	<s:submit type="button" name="Add" />				
 </s:form>
 
</body>
</html>
