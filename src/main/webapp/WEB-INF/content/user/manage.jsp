<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
 <!doctype html>
<html>
<head>
	<title>User List</title>
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />
	<link rel="stylesheet" type="text/css" href="/ERS/styles/users.css">
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
							<th></th>
							<th>Username</th>
							<th>Password</th>
							<th>Session ID</th>
							<th>Salt</th>
							<th>Admin?</th>
						</tr>
						
						<s:iterator value="users">
							<tr>
								<td><s:url id="editUser" value="userManagement.action">
										<s:param name="id" value="id" />
									</s:url>
									<s:a href="%{editUser}">Edit</s:a>
								</td>
								<td><s:property value="username" /></td>
								<td><s:property value="password" /></td>
								<td><s:property value="sessionId" /></td>
								<td><s:property value="salt" /></td>
								<td><s:property value="admin" /></td>
								
							</tr>
						</s:iterator>
					</table>
				</div>
			</s:if>
			
			<s:if test="isError">
				<s:property value="errorMessage" />
			</s:if>
			
			<s:if test="hasActionErrors()">
			   <div class="errors">
			      <s:actionerror/>
			   </div>
			</s:if>
			
			<s:if test="getMode()=='edit'">
				<div id="panel2">
					<s:url id="updateUser" value="updateUser.action">
						<s:param name="id" value="id" />
					</s:url>
					
					<div id="editContainer">
						<s:form name="editForm" method="post" action="%{updateUser}">
							<s:textfield name="user.username" label="User" />
							<s:checkbox name="user.admin" label="Is Admin?" />
							<s:checkboxlist label="User Roles" list="roles" name="userRoles" value="defaultRoles" />
						</s:form>
					</div>
					
					<div id="buttonContainer">
						<div id="modeDiv">
							<h3 id="modeLabel"></h3>
						</div>
						<div class="buttonDiv">
							<a href="javascript:submitForm(editForm);">Update</a>
						</div><br/>
						<div class="buttonDiv">
							<a href="">Delete</a>
						</div><br/>
						<div class="buttonDiv">
							<s:url id="clearUrl" value="userManagement.action"></s:url>
							<s:a href="%{clearUrl}">Clear</s:a>
						</div><br/>
					</div>
				</div>
			</s:if>
			
			<s:else>
				<div id="panel2">
					<div id="editContainer">
						<s:form name="addForm" method="post" action="addUser.action">
		 
							<s:textfield name="user.username" label="User" />
							<s:password name="user.password" label="Password" />
							<s:checkbox name="user.admin" label="Is Admin?" />
							
							<s:checkboxlist label="User Roles" list="roles" name="userRoles" />
						</s:form>
					</div>
					
					<div id="buttonContainer">
						<div id="modeDiv">
							<h3 id="modeLabel"></h3>
						</div>
						<div class="buttonDiv">
							<a href="javascript:submitForm(addForm);">Create</a>
						</div><br/>
						<div class="buttonDiv">
							<a href="">Delete</a>
						</div><br/>
						<div class="buttonDiv">
							<s:url id="clearUrl" value="userManagement.action"></s:url>
							<s:a href="%{clearUrl}">Clear</s:a>
						</div><br/>
					</div>
				</div>
			</s:else>
		</div>
	</div>
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>