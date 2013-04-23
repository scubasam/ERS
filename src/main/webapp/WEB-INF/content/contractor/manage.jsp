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
		page = "contractors";
		setCurrentPage(page);
	</script>
</head>
<body>
	<div id="container">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">
			<h2>Contractor List</h2>
			
			<s:if test="contractors.size > 0">
				<div id="columnSelect">
					<s:form name="manageColumns" action="manageColumns.action?action=contractor" id="columnSelectForm">
						<s:checkboxlist label="Choose Display Columns" list="columnLabels" name="columnLabels" value="visibleColumns" />
						<s:submit value="Update" />
					</s:form>
				</div>
				<div id="scrollContainer">
					<table id="contractors">
						<thead>
							<tr>
								<!-- <th></th><th>Contractor</th><th>Contact</th><th>Locations</th>-->
								<th></th>
								<s:property value="gridHeaders" escape="false" />
							</tr>
						</thead>
						<tbody>
							<s:property value="gridBody" escape="false" />
							<!-- 
							<s:iterator value="contractors">
								<s:url id="viewContractor" value="viewContractor.action">
									<s:param name="id" value="id" />
								</s:url>
							
								<tr>
									<td>
										<s:url id="edit" action="contractorManagement">
											<s:param name="id">
												<s:property value='id' />
											</s:param>
										</s:url>
										
										<s:a href="%{edit}">Edit</s:a>
									</td>
									<td>
										<s:a href="%{viewContractor}"><s:property value="contractorName" /></s:a>
									</td>
									<td>
										<s:property value="contact" />
									</td>
									<td>
										<s:iterator value="locations">
											<s:property value="name" /> 
										</s:iterator>
									</td>
								</tr>
							</s:iterator>
							-->
						</tbody>
					</table>
				</div>
				
				<div id="panel2">
					<jsp:include page="/includes/error_header.jsp" />
					<s:if test="getMode()=='edit'">
						<s:url id="updateContractor" value="updateContractor.action">
							<s:param name="id" value="id" />
						</s:url>
						
						<div id="editContainer">
							<s:form name="editForm" action="%{updateContractor}" id="contractorForm">
								<s:textfield name="contractor.contractorName" label="Name" />
								<jsp:include page="/WEB-INF/content/contact/fieldForm.jsp" />
							</s:form>
						</div>
						
						<div id="buttonContainer">
							<div id="modeDiv">
								<h3 id="modeLabel"></h3>
							</div>
							<div class="buttonDiv">
								<a href="javascript:submitForm(editForm);">Update</a>
							</div><br/>
							<div class="buttonDiv">
								<s:url id="deleteUrl" value="deleteContractor.action">
									<s:param name="id" value="id" />
								</s:url>
								<s:a href="%{deleteUrl}">Delete</s:a>
							</div><br/>
							<div class="buttonDiv">
								<s:url id="clearUrl" value="contractorManagement.action"></s:url>
								<s:a href="%{clearUrl}">Clear</s:a>
							</div><br/>
						</div>
					</s:if>
				
					<s:else>
						<div id="editContainer">
							<s:form name="addForm" action="addContractor.action" id="contractorForm">
								<s:textfield name="contractor.contractorName" label="Name" />
								<jsp:include page="/WEB-INF/content/contact/fieldForm.jsp" />
							</s:form>
						</div>
						
						<div id="buttonContainer">
							<div id="modeDiv">
								<h3 id="modeLabel"></h3>
							</div>
							<div class="buttonDiv">
								<a href="javascript:submitForm(addForm);">Create</a>
							</div><br/>
						</div>
					</s:else>
				</div>
			</s:if>
			<s:else>
				No Contractors Found...
			</s:else>
			
		</div>
	</div>
	
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>