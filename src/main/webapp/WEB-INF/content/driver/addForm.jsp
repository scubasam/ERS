<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Add Driver</title>
<s:head />
<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("drivers");
	</script>
</head>
<body>
<div id="container">
 <jsp:include page="/includes/header.jsp" />
<p>Add Driver</p>

<s:if test="isError">
	<s:property value="errorMessage" />
</s:if>
 
<s:form name="addForm" method="post" action="addDriver.action">

	<jsp:include page="/WEB-INF/content/contact/fieldForm.jsp" />
	<s:textfield name="driver.licenseNumber" label="licenseNUmber" />
	<s:textfield name="driver.licenseExpiration" label="licenseExpiration" />
	<s:textfield name="driver.licenseClass" label="licenseClass" />
	<s:textfield name="driver.contractor" label="contractor" />

	<s:submit type="button" name="Add" />
						
</s:form>
</div>
<jsp:include page="/includes/footer.jsp" /> 
</body>
</html>
