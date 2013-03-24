<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Add Contact</title>
<s:head />
</head>
<body>
<jsp:include page="/includes/header.jsp" />
<p>Add Contact</p>

<s:if test="isError">
	<s:property value="errorMessage" />
</s:if>
 
<s:form name="addContact" action="addContact.action">

	<jsp:include page="/WEB-INF/content/contact/fieldForm.jsp" />
		
	<s:submit type="button" name="Add Contact" />
						
	</s:form>
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>