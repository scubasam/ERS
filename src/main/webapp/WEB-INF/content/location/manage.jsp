<%-- @author Mitchell Nemitz, Kelly Smith, Alex McCracken --%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
<head>
	<title>Location Management</title>
	
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />

	<script type="text/javascript">
		page = "locations";
		pageSetup(page);
	</script>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">
			<h2>Location List</h2>

			<s:if test="locations.size > 0">
				<div id="columnSelect">
					<s:form name="manageColumns"
						action="manageColumns.action?action=location"
						id="columnSelectForm">
						<s:checkboxlist label="Choose Display Columns" list="columnLabels"
							name="columnLabels" value="visibleColumns" />
						<s:submit value="Update" />
					</s:form>
				</div>

				<div id="dataContainer">
					<table id="locations" class="dataTable">
						<thead>
							<tr>
								<th></th>
								<s:property value="gridHeaders" escape="false" />
							</tr>
						</thead>
						<tbody>
							<s:property value="gridBody" escape="false" />
						</tbody>
					</table>
				</div>

				<div id="editContainer">
					<jsp:include page="/includes/error_header.jsp" />
					<s:if test="getMode()=='edit'">
						<s:url id="updateLocation" value="updateLocation.action">
							<s:param name="id" value="id" />
						</s:url>

						<div id="formContainer">
							<s:url id="updateLocation" value="updateLocation.action">
								<s:param name="id" value="id" />
							</s:url>

							<s:form name="editForm" action="%{updateLocation}">
								<s:textfield name="location.name" label="Location Name" />
								<s:textfield name="location.streetAddress1"
									label="Street Address 1" />
								<s:textfield name="location.streetAddress2"
									label="Street Address 2" />
								<s:textfield name="location.city" label="City" />
								<s:textfield name="location.state" label="State" />
								<s:textfield name="location.zip" label="Zip Code" />
								<s:textfield name="location.roadName" label="Road" />
								<s:textfield name="location.roadNumber" label="Road Number" />
								<s:textfield name="location.latitude" label="Latitude" />
								<s:textfield name="location.longitude" label="Longitude" />
								<s:textfield name="location.locationType" label="Location Type" />
								<s:select label="Contractor" name="contractorId"
									list="contractorList" listKey="id" listValue="contractorName"
									value="selectedContractorId" />
									
							</s:form>
						</div>

						<div id="buttonContainer">
							<a class="ui-button edit-button" href="javascript:submitForm(editForm);">Update</a>
							<br />

							<s:url id="deleteUrl" value="deleteLocation.action">
								<s:param name="id" value="id" />
							</s:url>
							<s:a cssClass="ui-button edit-button" href="%{deleteUrl}">Delete</s:a>
							<br />

							<s:url id="clearUrl" value="locationManagement.action"></s:url>
							<s:a cssClass="ui-button edit-button" href="%{clearUrl}">Clear</s:a>
							<br />
						</div>
					</s:if>

					<s:else>
						<div id="formContainer">
							<s:form name="addForm" action="addLocation.action">

								<s:textfield name="location.name" label="Location Name" />
								<s:textfield name="location.streetAddress1"
									label="Street Address 1" />
								<s:textfield name="location.streetAddress2"
									label="Street Address 2" />
								<s:textfield name="location.city" label="City" />
								<s:textfield name="location.state" label="State" />
								<s:textfield name="location.zip" label="Zip Code" />
								<s:textfield name="location.roadName" label="Road" />
								<s:textfield name="location.roadNumber" label="Road Number" />
								<s:textfield name="location.latitude" label="Latitude" />
								<s:textfield name="location.longitude" label="Longitude" />
								<s:textfield name="location.locationType" label="Location Type" />
								<s:select label="Contractor" name="contractorId"
									list="contractorList" listKey="id" listValue="contractorName" />
							</s:form>
						</div>

						<div id="buttonContainer">
							<a class="ui-button edit-button" href="javascript:submitForm(addForm);">Create</a>
							<br />
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