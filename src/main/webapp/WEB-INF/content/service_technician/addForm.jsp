< %@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Service Technician</title>
</head>
<body>
 
<p>Service Technician</p>
 
<s:form name="serviceTechnician" method="post" action="serviceTechinican.action">

	<s:textfield name="id" label="id" /> 
	<s:textfield name="contact" label="contact" />
	<s:textfield name="skillGrade" label="skillGrade" />
	<s:textfield name="maintenanceOrders" label="maintenanceOrders" />
	<s:submit type="button" name="Add" />
		
 </s:form>
 
</body>
</html>