<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<!doctype html>
<html>
<head>
	<title>Service Technician List</title>
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("technicians");
	</script>
</head>
<body>
	<div id="container">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">
			<h2>Service Technician List</h2>
			
			<s:if test="technicians.size > 0">
				<table id="technicians">
					<tr>
						<th>Contact</th><th>Skill Grade</th><th>Maintenance Orders</th>
					</tr>
					<s:iterator value="technicians">
						<tr>
							<td><s:property value="contact" /></td>
							<td><s:property value="skillGrade" /></td>
							<td><s:property value="maintenanceOrders" /></td>
						</tr>
					</s:iterator>
				</table>
			</s:if>
			<s:else>
				No Technicians Found...
			</s:else>
		</div>
	</div>
			
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>