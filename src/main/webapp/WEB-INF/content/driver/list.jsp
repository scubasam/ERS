<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
<head>
	<title>Driver List</title>
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("drivers");
	</script>
</head>

<body>
	<div id="container">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">
			<h2>Driver List</h2>
			
			<s:if test="drivers.size > 0">
				<table id="drivers">
					<tr>
						<th>Contact</th><th>License Number</th><th>License Exp.</th><th>License Class</th><th>Contractor</th>
						<th>Vehicles</th>
					</tr>
					<s:iterator value="drivers">
						<s:url id="viewContractor" value="viewContractor.action">
								<s:param name="id" value="contractor.id" />
							</s:url>
					
						<tr>
							<td><s:property value="contact" /></td>
							<td><s:property value="licenseNumber" /></td>
							<td><s:property value="licenseExpiration" /></td>
							<td><s:property value="licenseClass" /></td>
							<td><s:a href="%{viewContractor}"><s:property value="contractor" /></s:a></td>
							<td>
							<s:property value="vehicles" />
							</td>
						</tr>
					</s:iterator>
				</table>
			</s:if>
			<s:else>
				No Drivers Found...
			</s:else>
		</div>
	</div>
		
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>