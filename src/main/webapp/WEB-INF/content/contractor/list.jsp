<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<html>
<head>
<title>Contractor List</title>
<sx:head debug="true" cache="false" compressed="false" />
</head>
<body>
 <jsp:include page="/WEB-INF/content/header.jsp" />
<p>Contractor List</p>
<div><s:url id="addContractor" value="addContractorForm.action">
</s:url><s:a href="%{addContractor}">Add</s:a></div>
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

<jsp:include page="/WEB-INF/content/footer.jsp" />
</body>
</html>