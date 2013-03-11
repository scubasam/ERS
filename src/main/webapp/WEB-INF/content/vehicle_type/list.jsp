<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<html>
<head>
<title>Vehicle Type List</title>
<sx:head debug="true" cache="false" compressed="false" />
</head>
<body>
 <jsp:include page="/WEB-INF/content/header.jsp" />
<p>Vehicle Type List</p>

<s:if test="types.size > 0">
	<table id="types">
		<tr>
			<th>Type</th><th>Sub Type</th><th>Description</th><th>Make</th><th>Model</th><th>Minimum Weight</th><th>Maximum Weight</th><th>Capacity</th>
			<th>Maximum Range</th><th>Restrictions</th><th>Height</th><th>Empty Weight</th><th>Length</th>
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
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
	No Vehicle Types Found...
</s:else>

<jsp:include page="/WEB-INF/content/footer.jsp" />
</body>
</html>