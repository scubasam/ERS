<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<<<<<<< HEAD
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
=======
<title>Driver</title>
</head>
<body>
>>>>>>> parent of 88408e7... Making this work... or else.
 
<p>Driver</p>
 
<s:form name="driver" method="post" action="driver.action">

<<<<<<< HEAD
	<jsp:include page="/WEB-INF/content/contact/fieldForm.jsp" />
	<s:textfield name="driver.licenseNumber" label="licenseNUmber" />
	<s:textfield name="driver.licenseExpiration" label="licenseExpiration" />
	<s:textfield name="driver.licenseClass" label="licenseClass" />
	<s:textfield name="driver.contractor" label="contractor" />

	<s:submit type="button" name="Add" />
						
</s:form>
</div>
<jsp:include page="/includes/footer.jsp" /> 
=======
	<s:textfield name="id" label="id" /> 
	<s:textfield name="contact" label="contact" />
	<s:textfield name="vehicles" label="vehicles" />
	<s:textfield name="licenseNumber" label="licenseNUmber" />
	<s:textfield name="licenseExpiration" label="licenseExpiration" />
	<s:textfield name="licenseClass" label="licenseClass" />
	<s:textfield name="contractor" label="contractor" />
	<s:submit type="button" name="Add" />
						
 </s:form>
 
>>>>>>> parent of 88408e7... Making this work... or else.
</body>
</html>
