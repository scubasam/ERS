<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<!doctype html>
<html>
<head>
	<title>Route Management</title>
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		page = "routes";
		setCurrentPage(page);
	</script>
</head>
<body>
	<div id="container">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">
			<h2>Route Management</h2>
			
			<s:if test="routes.size > 0">
				<div id="scrollContainer">
					<table id="routes">
						<thead>
							<tr>
								<th></th><th>Route Id</th><th>Vehicle</th><th>Shipments</th><th>Start Location</th><th>End Location</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="routes">							
								<tr>
									<td>
										<s:url id="edit" action="routeManagement">
											<s:param name="id">
												<s:property value='id' />
											</s:param>
										</s:url>
										
										<s:a href="%{edit}">Edit</s:a>
									</td>
									<td>
										<s:property value="id" />
									</td>
									<td>
										<s:property value="vehicle" />
									</td>
									<td>
										<s:property value="shipments" />
									</td>
									<td>
										<s:property value="startLocation" />
									</td>
									<td>
										<s:property value="endLocation" />
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				
				<div id="panel2">
				<s:if test="getMode()=='edit'">
					
						<s:url id="updateRoute" value="updateRoute.action">
							<s:param name="id" value="id" />
						</s:url>
						
						<div id="editContainer">
							<s:form name="editForm" action="%{updateRoute}" id="routeForm">
								
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
								<s:url id="deleteUrl" value="deleteRoute.action">
									<s:param name="id" value="id" />
								</s:url>
								<s:a href="%{deleteUrl}">Delete</s:a>
							</div><br/>
							<div class="buttonDiv">
								<s:url id="clearUrl" value="routeManagement.action"></s:url>
								<s:a href="%{clearUrl}">Clear</s:a>
							</div><br/>
						</div>
				</s:if>
				
				<s:else>
						<div id="editContainer">
							<s:form name="addForm" action="addRoute.action" id="routeForm">
								<s:select label="Vehicle" name="vehicleSelect.selected" list="vehicleSelect.list" listKey="id" listValue="toString()" />
								<s:select label="Start Location" name="startLocationSelect.selected" list="startLocationSelect.list" listKey="id" listValue="toString()" />
								<s:select label="End Location" name="endLocationSelect.selected" list="endLocationSelect.list" listKey="id" listValue="toString()" />
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
				No Routes Found...
			</s:else>
			
		</div>
	</div>
	
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>