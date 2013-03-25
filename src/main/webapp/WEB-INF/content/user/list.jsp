<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
 <!doctype html>
<html>
<head>
	<title>User List</title>
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("users");
	</script>
</head>

<body>
	<div id="container">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">
			<h2>User List</h2>
		
			<s:if test="users.size > 0">
				<table id="users">
					<tr>
						<th>Username</th><th>Password</th><th>Session ID</th><th>Salt</th><th>Admin?</th>
					</tr>
					<s:iterator value="users">
						<tr>
							<td><s:property value="username" /></td>
							<td><s:property value="password" /></td>
							<td><s:property value="sessionId" /></td>
							<td><s:property value="salt" /></td>
							<td><s:property value="admin" /></td>
							<td><s:url id="deleteUser" value="deleteUser.action">
								<s:param name="id" value="id" />
							</s:url> <s:a href="%{deleteUser}">Delete</s:a></td>
						</tr>
					</s:iterator>
				</table>
			</s:if>
			
			<div id="addDiv">
				<s:url id="addUser" value="addUserForm.action"></s:url>
				<s:a href="%{addUser}">Add User</s:a>
			</div>
		</div>
		
	</div>
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>