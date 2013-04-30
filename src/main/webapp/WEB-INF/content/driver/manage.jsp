<%-- @authors Mitchell Nemitz, Kelly Smith, Alex McCracken --%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
<head>
	<title>Driver</title>
	
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />

	<script type="text/javascript">
		page = "driver";
		pageSetup(page);
	</script>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">
			<h2>Driver</h2>

			<s:if test="drivers.size > 0">
				<div id="columnSelect">
					<s:form name="manageColumns"
						action="manageColumns.action?action=driver" id="columnSelectForm">
						<s:checkboxlist label="Choose Display Columns" list="columnLabels"
							name="columnLabels" value="visibleColumns" />
						<s:submit value="Update" />
					</s:form>
				</div>
				<div id="dataContainer">
					<table id="driver">
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

						<s:url id="updateDriver" value="updateDriver.action">
							<s:param name="id" value="id" />
						</s:url>

						<div id="formContainer">
							<s:form name="editForm" action="%{updateDriver}" id="driverForm">
								<s:select label="Vehicle" name="vehicleSelect.selected"
									list="vehicleSelect.list" listKey="id" listValue="toString()"
									value="vehicleSelect.selected" />
								<s:select label="Contact" name="contactSelect.selected"
									list="contactSelect.list" listKey="id" listValue="toString()"
									value="contactSelect.selected" />
								<s:select label="Contractor" name="contractorSelect.selected"
									list="contractorSelect.list" listKey="id" listValue="toString()"
									value="contractorSelect.selected" />
							</s:form>
						</div>

						<div id="buttonContainer">
							<div id="modeDiv">
								<h3 id="modeLabel"></h3>
							</div>
							<div class="buttonDiv">
								<a href="javascript:submitForm(editForm);">Update</a>
							</div>
							<br />
							<div class="buttonDiv">
								<s:url id="deleteUrl" value="deleteDriver.action">
									<s:param name="id" value="id" />
								</s:url>
								<s:a href="%{deleteUrl}">Delete</s:a>
							</div>
							<br />
							<div class="buttonDiv">
								<s:url id="clearUrl" value="driverManagement.action"></s:url>
								<s:a href="%{clearUrl}">Clear</s:a>
							</div>
							<br />
						</div>
					</s:if>

					<s:else>
						<div id="formContainer">
							<s:form name="editForm" action="%{updateDriver}" id="driverForm">
								<s:select label="Vehicle" name="vehicleSelect.selected"									
									list="vehicleSelect.list" listKey="id" listValue="toString()"
									value="vehicleSelect.selected" />
								<s:select label="Contact" name="contactSelect.selected"
									list="contactSelect.list" listKey="id" listValue="toString()"
									value="contactSelect.selected" />
								<s:select label="Contractor" name="contractorSelect.selected"
									list="contractorSelect.list" listKey="id" listValue="toString()"
									value="contractorSelect.selected" />
							</s:form>
						</div>

						<div id="buttonContainer">
							<div id="modeDiv">
								<h3 id="modeLabel"></h3>
							</div>
							<div class="buttonDiv">
								<a href="javascript:submitForm(addForm);">Create</a>
							</div>
							<br />
						</div>
					</s:else>
				</div>
			</s:if>
			<s:else>
				No Driver...
			</s:else>
		</div>
	</div>

	<jsp:include page="/includes/footer.jsp" />
</body>
</html>