<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<!doctype html>
<html>
<head>
	<title>Contractor List</title>
	<sx:head debug="true" cache="false" compressed="false" />
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
			<h2>Contractor List</h2>
			
			<s:if test="contractors.size > 0">
				<table id="contractors">
					<tr>
						<th>Contractor</th><th>Contact</th>
					</tr>
					<s:iterator value="contractors">
						<s:url id="viewContractor" value="viewContractor.action">
								<s:param name="id" value="id" />
							</s:url>
					
						<tr>
							<td><s:a href="%{viewContractor}"><s:property value="contractorName" /></s:a></td>
							<td><s:property value="contact" /></td>
							<td>
							<s:iterator value="locations">
								<s:property value="name" /> 
							</s:iterator>
							</td>
						</tr>
					</s:iterator>
				</table>
			</s:if>
			<s:else>
				No Contractors Found...
			</s:else>
			
			<div id="addDiv">
				<s:url id="addContractor" value="addContractorForm.action"></s:url>
				<s:a href="%{addContractor}">Add Contractor</s:a>
			</div>
		</div>
	</div>
	
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>