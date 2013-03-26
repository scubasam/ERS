<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Add Driver</title>
<s:head />
</head>
<body>
 <jsp:include page="/includes/header.jsp" />
<p>Add Driver</p>

<s:if test="isError">
	<s:property value="errorMessage" />
</s:if>
 
<s:form name="addForm" method="post" action="addDriver.action">

	<s:textfield name="id" label="id" /> 
	<s:textfield name="contact" label="contact" />
	<s:textfield name="vehicles" label="vehicles" />
	<s:textfield name="licenseNumber" label="licenseNUmber" />
	<s:textfield name="licenseExpiration" label="licenseExpiration" />
	<s:textfield name="licenseClass" label="licenseClass" />
	<s:textfield name="contractor" label="contractor" />

	<s:submit type="button" name="Add" />
						
</s:form>
<jsp:include page="/includes/footer.jsp" /> 
</body>
</html>
