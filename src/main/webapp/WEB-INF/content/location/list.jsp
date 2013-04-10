<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<!doctype html>
<html>
<head>
	<title>Location List</title>
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />
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
				<div id="scrollContainer">
					<table id="locations">
						<thead>
							<tr>
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
					<div id="editContainer">
						<s:form name="addContact" action="addContact.action" id="contactForm">
							<jsp:include page="fieldForm.jsp" />
						</s:form>
					</div>
					<div id="buttonContainer">
						<div id="modeDiv">
							<h3 id="modeLabel"></h3>
						</div>
						<div class="buttonDiv">
							<a href="javascript:submitForm(contactForm);">Create</a>
						</div><br/>
						<div class="buttonDiv">
							<a href="javascript:submitForm(contactForm);">Update</a>
						</div><br/>
						<div class="buttonDiv">
							<a href="javascript:submitForm(contactForm);">Delete</a>
						</div><br/>
						<div class="buttonDiv">
							<a href="javascript:submitForm(contactForm);">Clear</a>
						</div><br/>
					</div>
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