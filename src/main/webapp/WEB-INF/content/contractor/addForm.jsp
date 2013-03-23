<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Add Contractor</title>
<s:head />
</head>
<body>
<jsp:include page="/WEB-INF/content/header.jsp" />
<p>Add Contractor</p>

<s:if test="isError">
	<s:property value="errorMessage" />
</s:if>
 
<s:form name="addContractor" action="addContractor.action">

	<s:textfield name="contractor.contractorName" label="Contractor Name" />
	<jsp:include page="/WEB-INF/content/contact/fieldForm.jsp" />
		
	<s:submit type="button" name="Add Contractor" />
						
	</s:form>
	<jsp:include page="/WEB-INF/content/footer.jsp" />
</body>
</html>