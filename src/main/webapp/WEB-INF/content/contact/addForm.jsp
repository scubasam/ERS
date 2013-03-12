<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Contact</title>
</head>
<body>
 
<p>Contact</p>
 
<s:form name="contact" method="contact" action="contractor.action">

	<s:textfield name="id" label="id" /> 
	<s:textfield name="firstName" label="firstName" />
	<s:textfield name="lastName" label="lastName" />
	<s:textfield name="middleInitial" label="middleInitial" />
	<s:textfield name="emailAddress" label="emailAddress" />
	<s:textfield name="streetAddress1" label="streetAddress1" />
	<s:textfield name="streetAddress2" label="streetAddress2" />
	<s:textfield name="city" label="city" />
	<s:textfield name="state" label="state" />
	<s:textfield name="zip" label="zip" />
	<s:textfield name="primaryPhone" label="primaryPhone" />
	<s:textfield name="workPhone" label="workPhone" />	
	<s:submit type="button" name="Add" />
						
 </s:form>
 
</body>
</html>
