<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Route</title>
</head>
<body>
 
<p>Route</p>
 
<s:form name="route" method="post" action="route.action">

	<s:textfield name="id" label="id" /> 
	<s:textfield name="vehicle" label="vehicle" />
	<s:textfield name="shipments" label="shipments" />
	<s:submit type="button" name="Add" />								
 </s:form>
 
</body>
</html>