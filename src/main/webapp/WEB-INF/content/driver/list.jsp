<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
<head>
	<title>View Driver</title>
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
						<th>Driver</th><th>Vehicle</th>
					</tr>
					<s:iterator value="drivers">
						<tr>
							<td><s:property value="id" /></td>
								<td><s:a href="%{viewDriver}"><s:property value="vehicles" /></s:a></td>
								<td><s:property value="type" /></td>
						</s:iterator>
				</table>
			</s:if>
			<s:else>
				No Drivers Found....
			</s:else>
			<div id="addDiv">
				<s:url id="addDriver" value="addDriverForm.action"></s:url>
				<s:a href="%{addDriver}">Add Driver</s:a>
			</div>
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>