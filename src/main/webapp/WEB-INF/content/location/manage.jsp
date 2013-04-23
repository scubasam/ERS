<%-- @author Mitchell Nemitz, Kelly Smith, Alex McCracken --%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<!doctype html>
<html>
<head>
	<title>Location Management</title>
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />
	<link rel="stylesheet" type="text/css" href="/ERS/styles/locations.css">
	<script type="text/javascript">
		// style the nav bar
		page = "locations";
		pageSetup(page);
	</script>
</head>
<body>
	<div id="container">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">
			<h2>Location List</h2>
			
			<s:if test="locations.size > 0">
				<div id="columnSelect">
					<s:form name="manageColumns" action="manageColumns.action?action=location" id="columnSelectForm">
						<s:checkboxlist label="Choose Display Columns" list="columnLabels" name="columnLabels" value="visibleColumns" />
						<s:submit value="Update" />
					</s:form>
				</div>
				
				<div id="scrollContainer">
					<table id="locations">
						<thead>
							<tr>
								<th></th>
<!-- 								<th>Name</th> -->
<!-- 								<th>Street Address 1</th> -->
<!-- 								<th>Street Address 2</th> -->
<!-- 								<th>City</th> -->
<!-- 								<th>State</th> -->
<!-- 								<th>Zip</th> -->
<!-- 								<th>Road Name</th> -->
<!-- 								<th>Road Number</th> -->
<!-- 								<th>Latitude</th> -->
<!-- 								<th>Longitude</th> -->
<!-- 								<th>Contractor</th> -->
<!-- 								<th>Location Type</th> -->
<!-- 								<th>Vehicles</th> -->
								<s:property value="gridHeaders" escape="false" />
							</tr>
						</thead>
						<tbody>
							<s:property value="gridBody" escape="false" />
<%-- 							<s:iterator value="locations"> --%>
<!-- 								<tr> -->
<!-- 									<td> -->
<%-- 										<s:url id="edit" action="locationManagement"> --%>
<%-- 											<s:param name="id"> --%>
<%-- 												<s:property value='id' /> --%>
<%-- 											</s:param> --%>
<%-- 										</s:url> --%>
										
<%-- 										<s:a href="%{edit}">Edit</s:a> --%>
<!-- 									</td> -->
<%-- 									<td><s:property value="name" /></td> --%>
<%-- 									<td><s:property value="streetAddress1" /></td> --%>
<%-- 									<td><s:property value="streetAddress2" /></td> --%>
<%-- 									<td><s:property value="city" /></td> --%>
<%-- 									<td><s:property value="state" /></td> --%>
<%-- 									<td><s:property value="zip" /></td> --%>
<%-- 									<td><s:property value="roadName" /></td> --%>
<%-- 									<td><s:property value="roadNumber" /></td> --%>
<%-- 									<td><s:property value="latitude" /></td> --%>
<%-- 									<td><s:property value="longitude" /></td> --%>
<%-- 									<td><s:property value="contractor.contractorName" /></td> --%>
<%-- 									<td><s:property value="locationType" /></td> --%>
<%-- 									<td><s:property value="vehicles" /></td> --%>
<!-- 								</tr> -->
<%-- 							</s:iterator> --%>
						</tbody>
					</table>
				</div>
				

				
				<div id="panel2">
					<jsp:include page="/includes/error_header.jsp" />
					<s:if test="getMode()=='edit'">
						<s:url id="updateLocation" value="updateLocation.action">
							<s:param name="id" value="id" />
						</s:url>
						
						<div id="editContainer">
							<s:url id="updateLocation" value="updateLocation.action">
								<s:param name="id" value="id" />
							</s:url>
						
							<s:form name="editForm" action="%{updateLocation}">
			
								<s:textfield name="location.name" label="Location Name" />
								<s:textfield name="location.streetAddress1" label="Street Address 1" />
								<s:textfield name="location.streetAddress2" label="Street Address 2" />
								<s:textfield name="location.city" label="City" />
								<s:textfield name="location.state" label="State" />
								<s:textfield name="location.zip" label="Zip Code" />
								<s:textfield name="location.roadName" label="Road" />
								<s:textfield name="location.roadNumber" label="Road Number" />
								<s:textfield name="location.latitude" label="Latitude" />
								<s:textfield name="location.longitude" label="Longitude" />	
								<s:textfield name="location.locationType" label="Location Type" />
								<s:select label="Contractor" name="contractorId" list="contractorList" listKey="id" listValue="contractorName" value="selectedContractorId" />
								
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
								<s:url id="deleteUrl" value="deleteLocation.action">
									<s:param name="id" value="id" />
								</s:url>
								<s:a href="%{deleteUrl}">Delete</s:a>
							</div><br/>
							<div class="buttonDiv">
								<s:url id="clearUrl" value="locationManagement.action"></s:url>
								<s:a href="%{clearUrl}">Clear</s:a>
							</div><br/>
						</div>
					</s:if>
					
					<s:else>
						<div id="editContainer">
							<s:form name="addForm" action="addLocation.action">
			
								<s:textfield name="location.name" label="Location Name" />
								<s:textfield name="location.streetAddress1" label="Street Address 1" />
								<s:textfield name="location.streetAddress2" label="Street Address 2" />
								<s:textfield name="location.city" label="City" />
								<s:textfield name="location.state" label="State" />
								<s:textfield name="location.zip" label="Zip Code" />
								<s:textfield name="location.roadName" label="Road" />
								<s:textfield name="location.roadNumber" label="Road Number" />
								<s:textfield name="location.latitude" label="Latitude" />
								<s:textfield name="location.longitude" label="Longitude" />	
								<s:textfield name="location.locationType" label="Location Type" />
								<s:select label="Contractor" name="contractorId" list="contractorList" listKey="id" listValue="contractorName" />		
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
				No Locations Found...
			</s:else>
			
		</div>
	</div>
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>