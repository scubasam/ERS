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
				<div id="scrollContainer">
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
								<td><s:url id="editUser" value="userManagement.action">
									<s:param name="id" value="id" />
								</s:url> <s:a href="%{editUser}">Edit</s:a></td>
							</tr>
						</s:iterator>
					</table>
				</div>
			</s:if>
			
			<div id="addDiv">
				<s:url id="addUser" value="addUserForm.action"></s:url>
				<s:a href="%{addUser}">Add User</s:a>
			</div>
			
			<div>
				<s:url id="clearUrl" value="userManagement.action"></s:url>
				<s:a href="%{clearUrl}">Clear</s:a>
			</div>
			
			<div id="editFormContainer">
					<s:if test="isError">
							<s:property value="errorMessage" />
						</s:if>
						<s:if test="hasActionErrors()">
						   <div class="errors">
						      <s:actionerror/>
						   </div>
						</s:if>
				<s:if test="getMode()=='edit'">
						
						<s:url id="updateUser" value="updateUser.action">
							<s:param name="id" value="id" />
						</s:url>
						
						<s:form name="editForm" method="post" action="%{updateUser}">
	 
							<s:textfield name="user.username" label="User" />
							<s:checkbox name="user.admin" label="Is Admin?" />
							<s:checkboxlist label="User Roles" list="rolesStr" name="userRoles" value="defaultRoles" />
						 
							<s:submit type="button" name="Add" />
						 
						</s:form>
				</s:if>
				<s:else>
					<s:form name="addForm" method="post" action="addUser.action">
	 
						<s:textfield name="user.username" label="User" />
						<s:password name="user.password" label="Password" />
						<s:checkbox name="user.admin" label="Is Admin?" />
						<s:checkboxlist label="User Roles" list="rolesStr" name="userRoles" />
					 
						<s:submit type="button" name="Add" />
					 
					</s:form>
				</s:else>
			</div>
		</div>
		
	</div>
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>