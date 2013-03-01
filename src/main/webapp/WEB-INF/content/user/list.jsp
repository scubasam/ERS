<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<html>
<head>
<title>User List</title>
<sx:head debug="true" cache="false" compressed="false" />
</head>
<body>
 <jsp:include page="/WEB-INF/content/header.jsp" />
<p>User List</p>
<div><s:url id="addUser" value="addUserForm.action">
</s:url><s:a href="%{addUser}">Add</s:a></div>
<s:if test="users.size > 0">
	<table id="users">
		<tr>
			<th>Username</th><th>Password</th><th>Admin?</th>
		</tr>
		<s:iterator value="users">
			<tr>
				<td><s:property value="username" /></td>
				<td><s:property value="password" /></td>
				<td><s:property value="admin" /></td>
				<td><s:url id="deleteUser" value="deleteUser.action">
					<s:param name="id" value="id" />
				</s:url> <s:a href="%{deleteUser}">Delete</s:a></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<jsp:include page="/WEB-INF/content/footer.jsp" />
</body>
</html>