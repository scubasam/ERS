<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Vehicle Type</title>
</head>
<body>
 
<p>Vehicle Type</p>
 
<s:form name="vehicleType" method="post" action="vehicleType.action">
	
	<s:textfield name="id" label="id" />
	<s:textfield name="type" label="type" />
	<s:textfield name="subType" label="subType" />
	<s:textfield name="description" label="description" />
	<s:textfield name="make" label="make" />
	<s:textfield name="model" label="model" />
	<s:textfield name="maximumWeight" label="maximumWeight" />
	<s:textfield name="minimumWeight" label="minimumWeight" />
	<s:textfield name="maximumRange" label="maximumRange" />
	<s:textfield name="capacity" label="capacity" />
	<s:textfield name="restrictions" label="restrictions" />
	<s:textfield name="height" label="height" />
	<s:textfield name="emptyWeight" label="emptyWeight" />
	<s:textfield name="length" label="length" />
	<s:submit type="button" name="Add" />
	
 </s:form>
 
</body>
</html>