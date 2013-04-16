<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<!doctype html>
<html>
<head>
	<title>Location Management</title>
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		page = "locations";
		setCurrentPage(page);
	</script>
</head>
<body>
<div id="container">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">
			<h2>Location List</h2>
			
			<s:if test="locations.size > 0">
				<div id="scrollContainer">
					<table id="locations">
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Street Address 1</th>
								<th>Street Address 2</th>
								<th>City</th>
								<th>State</th>
								<th>Zip</th>
								<th>Road Name</th>
								<th>Road Number</th>
								<th>Latitude</th>
								<th>Longitude</th>
								<th>Contractor</th>
								<th>Location Type</th>
								<th>Vehicles</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="locations">
								<tr>
									<td>
										<s:url id="edit" action="locationManagement">
											<s:param name="id">
												<s:property value='id' />
											</s:param>
										</s:url>
										
										<s:a href="%{edit}">Edit</s:a>
									</td>
									<td><s:property value="name" /></td>
									<td><s:property value="streetAddress1" /></td>
									<td><s:property value="streetAddress2" /></td>
									<td><s:property value="city" /></td>
									<td><s:property value="state" /></td>
									<td><s:property value="zip" /></td>
									<td><s:property value="roadName" /></td>
									<td><s:property value="roadNumber" /></td>
									<td><s:property value="latitude" /></td>
									<td><s:property value="longitude" /></td>
									<td><s:property value="contractor.contractorName" /></td>
									<td><s:property value="locationType" /></td>
									<td><s:property value="vehicles" /></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				

				
				<div id="panel2">
				<s:if test="getMode()=='edit'">
					
						<s:url id="updateLocation" value="updateLocation.action">
							<s:param name="id" value="id" />
						</s:url>
						
						<div id="editContainer">
							<s:form name="updateLocation" action="updateLocation.action">
			
								<s:textfield name="location.name" label="Location Name" />
								<s:textfield name="location.StreetAddress1" label="Street Address 1" />
								<s:textfield name="location.StreetAddress2" label="Street Address 2" />
								<s:textfield name="location.City" label="City" />
								<s:textfield name="location.Zip" label="Zip Code" />
								<s:textfield name="location.RoadName" label="Road" />
								<s:textfield name="location.RoadNumber" label="Road Number" />
								<s:textfield name="location.Latitude" label="Latitude" />
								<s:textfield name="location.Longitude" label="Longitude" />	
								<s:textfield name="location.Type" label="Location Type" />
								<s:textfield name="contractor.contractorName" label="ContractorName" />
								<s:textfield name="vehicle.vehicles" label="Vehicles at Location" />								
		
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
							<s:form name="addLocation" action="addLocation.action">
			
								<s:textfield name="location.name" label="Location Name" />
								<s:textfield name="location.StreetAddress1" label="Street Address 1" />
								<s:textfield name="location.StreetAddress2" label="Street Address 2" />
								<s:textfield name="location.City" label="City" />
								<s:textfield name="location.Zip" label="Zip Code" />
								<s:textfield name="location.RoadName" label="Road" />
								<s:textfield name="location.RoadNumber" label="Road Number" />
								<s:textfield name="location.Latitude" label="Latitude" />
								<s:textfield name="location.Longitude" label="Longitude" />	
								<s:textfield name="location.Type" label="Location Type" />
								<s:textfield name="contractor.contractorName" label="ContractorName" />
								<s:textfield name="vehicle.vehicles" label="Vehicles at Location" />								
								
								<s:submit type="button" name="Add Location" />				
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
			
			
		<div id="addDiv">
			<s:url id="addLocation" value="addLocationForm.action"></s:url>
			<s:a href="%{addLocation}">Add Location</s:a>
		</div>
		</div>
	</div>
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>