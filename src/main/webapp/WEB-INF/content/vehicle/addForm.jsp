<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Vehicle</title>
</head>
<body>
 
<p>Vehicle</p>
 
<s:form name="vehicle" method="post" action="vehicle.action">
	
	<s:textfield name="id" label="id" />
	<s:textfield name="plateNumber" label="plateNumber" />
	<s:textfield name="vinNumber" label="vinNumber" />
	<s:textfield name="manufacturedYear" label="manufacturedYear" />
	<s:textfield name="status" label="status" />
	<s:textfield name="vehicleType" label="vehicleType" />
	<s:textfield name="contractor" label="contractor" />
	<s:textfield name="drivers" label="drivers" />
	<s:textfield name="location" label="location" />	
	<s:submit type="button" name="Add" />
	
 </s:form>
 
</body>
</html>