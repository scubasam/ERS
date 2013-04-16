<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Confirm Delete Contractor</title>
<s:head />
<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("contractors");
	</script>
</head>
<body>
<div id="container">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">
		
			<s:if test="hasActionErrors()">
			   <div class="errors">
			      <s:actionerror/>
			   </div>
			</s:if>
			
			<div>
				Drivers are associated with this Contractor.  Please delete or reassign them.
				<a href="confirmDeleteContractor.action">Delete</a>
				<form action="confirmDeleteContractor.action">
					 
				</form>
			</div>
		</div>
	</div>
	
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>