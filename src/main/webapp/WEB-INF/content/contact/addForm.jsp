<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Add Contact</title>
<s:head />
<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("contacts");
	</script>
</head>
<body>
<div id="container">
<jsp:include page="/includes/header.jsp" />

<s:if test="isError">
	<s:property value="errorMessage" />
</s:if>
 
<s:form name="addContact" action="addContact.action">

	<jsp:include page="/WEB-INF/content/contact/fieldForm.jsp" />
		
	<s:submit type="button" name="Add Contact" />
						
	</s:form>
	</div>
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>