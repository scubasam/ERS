<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Maintenance Order</title>
</head>
<body>
 
<p>Maintenance Order</p>
 
<s:form name="maintenanceOrder" method="post" action="maintenanceOrder.action">

	<s:textfield name="id" label="id" /> 
	<s:textfield name="requester" label="requester" />
	<s:textfield name="serviceTechnician" label="serviceTechnician" />
	<s:textfield name="scheduleDate" label="scheduleDate" />
	<s:textfield name="details" label="details" />
	<s:textfield name="serviceTypeKey" label="serviceTypeKey" />
	<s:textfield name="cost" label="cost" />
	<s:textfield name="statusKey" label="statusKey" />
	<s:textfield name="vehicle" label="vehicle" />
	<s:textfield name="maintenanceType" label="maintenanceType" />	
	<s:submit type="button" name="Add" />
		
 </s:form>
 
</body>
</html>
