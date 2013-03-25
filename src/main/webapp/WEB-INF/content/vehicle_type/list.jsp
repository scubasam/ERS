<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<!doctype html>
<html>
<head>
	<title>Vehicle Type List</title>
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("vehicletypes");
	</script>
</head>

<body>
	<div id="container">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">
			<h2>Vehicle Type List</h2>
			
			<s:if test="types.size > 0">
				<table id="types">
					<tr>
						<th>Type</th><th>Sub Type</th><th>Description</th><th>Make</th><th>Model</th><th>Minimum Weight</th><th>Maximum Weight</th><th>Capacity</th>
						<th>Maximum Range</th><th>Restrictions</th><th>Height</th><th>Empty Weight</th><th>Length</th><th>Vehicles</th>
					</tr>
					<s:iterator value="types">
						<tr>
							<td><s:property value="type" /></td>
							<td><s:property value="subType" /></td>
							<td><s:property value="description" /></td>
							<td><s:property value="make" /></td>
							<td><s:property value="model" /></td>
							<td><s:property value="minimumWeight" /></td>
							<td><s:property value="maximumWeight" /></td>
							<td><s:property value="capacity" /></td>
							<td><s:property value="maximumRange" /></td>
							<td><s:property value="restrictions" /></td>
							<td><s:property value="height" /></td>
							<td><s:property value="empty_weight" /></td>
							<td><s:property value="length" /></td>
							<td><s:property value="vehicles" /></td>
						</tr>
					</s:iterator>
				</table>
			</s:if>
			<s:else>
				No Vehicle Types Found...
			</s:else>
		</div>
	</div>
	
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>