<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Add Contractor</title>
<s:head />
<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("contractors");
	</script>
</head>
<body>
<jsp:include page="/includes/header.jsp" />
<p>Add Contractor</p>

<s:if test="isError">
	<s:property value="errorMessage" />
</s:if>
 
<s:form name="addContractor" action="addContractor.action">

	<s:textfield name="contractor.contractorName" label="Contractor Name" />
	<jsp:include page="/WEB-INF/content/contact/fieldForm.jsp" />
		
	<s:submit type="button" name="Add Contractor" />
						
	</s:form>
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>