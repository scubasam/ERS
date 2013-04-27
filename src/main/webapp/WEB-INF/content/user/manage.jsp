<%-- @author Mitchell Nemitz, Kelly Smith, Alex McCracken --%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<!doctype html>
<html>
<head>
	<title>User List</title>
	
	<sx:head debug="true" cache="false" compressed="false" />
	<jsp:include page="/includes/decorator.jsp" />
	
	<link rel="stylesheet" type="text/css" href="/ERS/styles/page/users.css">
	<script type="text/javascript">
		page = "users";
		pageSetup(page);
	</script>
</head>

<body>
	<div id="wrapper">
		<jsp:include page="/includes/header.jsp" />
		
		<div class="buttonDiv" id="columnSelectButton">
			<a href="javascript:toggleColumnSelect()">Select Columns</a>
		</div>
			
		<div id="content">
			<h2>User List</h2>
		
			<s:if test="users.size > 0">
				<div id="columnSelect">
					<s:form name="manageColumns" action="manageColumns.action?action=user" id="columnSelectForm">
						<s:checkboxlist label="Choose Display Columns" list="columnLabels" name="columnLabels" value="visibleColumns" />
						<s:submit value="Update"/>
					</s:form>
				</div>
				
				<div id="scrollContainer">
					<table id="users">
						<tr>
							<th></th>
							<s:property value="gridHeaders" escape="false" />
						</tr>
							<s:property value="gridBody" escape="false" />
					</table>
				</div>
			</s:if>
			
			<div id="panel2">
				<jsp:include page="/includes/error_header.jsp" />
			
				<s:if test="getMode()=='edit'">
					<s:url id="updateUser" value="updateUser.action">
						<s:param name="id" value="id" />
					</s:url>
					
					<div id="editContainer">
						<s:form name="editForm" method="post" action="%{updateUser}">
							<s:textfield name="user.username" label="User" />
							<s:checkbox name="user.admin" label="Is Admin?" />
							<s:textfield name="user.email" label="Email" />
							<s:checkboxlist label="User Roles" list="rolesStr" name="userRoles" value="defaultRoles" />
						</s:form>
					</div>
					
					<div id="buttonContainer">
						<div class="buttonDiv">
							<a href="javascript:submitForm(editForm);">Update</a>
						</div><br/>
						
						<div class="buttonDiv">
							<s:url id="deleteUrl" value="deleteUser.action">
								<s:param name="id" value="id" />
							</s:url>
							<s:a href="%{deleteUrl}">Delete</s:a>
						</div><br/>
						
						<div class="buttonDiv">
							<s:url id="clearUrl" value="userManagement.action"></s:url>
							<s:a href="%{clearUrl}">Clear</s:a>
						</div><br/>
					</div>
				</s:if>
				
				<s:else>
					<div id="editContainer">
						<s:form name="addForm" method="post" action="addUser.action">
		 
							<s:textfield name="user.username" label="User" />
							<s:password name="user.password" label="Password" />
							<s:textfield name="user.email" label="Email" />
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
					</div>
				</s:else>
			</div>
		</div>
	</div>
	
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>
