<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Driver</title>
</head>
<body>
 
<p>Driver</p>
 
<s:form name="driver" method="post" action="driver.action">

	<s:textfield name="id" label="id" /> 
	<s:textfield name="contact" label="contact" />
	<s:textfield name="vehicles" label="vehicles" />
	<s:textfield name="licenseNumber" label="licenseNUmber" />
	<s:textfield name="licenseExpiration" label="licenseExpiration" />
	<s:textfield name="licenseClass" label="licenseClass" />
	<s:textfield name="contractor" label="contractor" />
	<s:submit type="button" name="Add" />
						
 </s:form>
 
</body>
</html>
