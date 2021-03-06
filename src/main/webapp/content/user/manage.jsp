<%-- @author Mitchell Nemitz, Kelly Smith, Alex McCracken --%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
 
<!doctype html>
<html>
<head>
	<title>User Management</title>
	
	<jsp:include page="/includes/decorator.jsp" />
	
	<script type="text/javascript">
		page = "users";
		pageSetup(page);
	</script>
	
	<sx:head debug="true" cache="false" compressed="false" />
</head>

<body>
	<div id="wrapper">
		<jsp:include page="/includes/header.jsp" />
			
		<div id="content">
		
			<s:if test="users.size > 0">
				<div id="columnSelect">
					<s:form name="manageColumns" action="manageColumns.action?action=user" id="columnSelectForm">
						<s:checkboxlist label="Choose Display Columns" list="columnLabels" name="columnLabels" value="visibleColumns" />
						<s:submit value="Update"/>
					</s:form>
				</div>
				
				<div id="dataContainer">
					<table id="users" class="dataTable">
						<tr>
							<th></th>
							<s:property value="gridHeaders" escape="false" />
						</tr>
							<s:property value="gridBody" escape="false" />
					</table>
				</div>
			</s:if>
			
			<div id="editContainer">
				<jsp:include page="/includes/error_header.jsp" />
			
				<s:if test="getMode()=='edit'">
					<s:url id="updateUser" value="updateUser.action">
						<s:param name="id" value="id" />
					</s:url>
					
					<div id="formContainer">
						<s:form name="editForm" method="post" action="%{updateUser}">
							<s:textfield name="user.username" label="User" />
							<s:checkbox name="user.admin" label="Is Admin?" />
							<s:textfield name="user.email" label="Email" />
							<s:checkboxlist label="User Roles" list="rolesStr" name="userRoles" value="defaultRoles" />
						</s:form>
					</div>
					
					<div id="buttonContainer">
						<a class="ui-button edit-button" href="javascript:submitForm(editForm);">Update</a>
						<br/>
					
						<s:url id="deleteUrl" value="deleteUser.action">
							<s:param name="id" value="id" />
						</s:url>
						<s:a cssClass="ui-button edit-button" href="%{deleteUrl}">Delete</s:a>
						<br/>
						
						<s:url id="clearUrl" value="userManagement.action"></s:url>
						<s:a cssClass="ui-button edit-button" href="%{clearUrl}">Clear</s:a>
						<br/>
					</div>
				</s:if>
				
				<s:else>
					<div id="formContainer">
						<s:form name="addForm" method="post" action="addUser.action">
		 
							<s:textfield name="user.username" label="User" />
							<s:password name="user.password" label="Password" />
							<s:textfield name="user.email" label="Email" />
							<s:checkbox name="user.admin" label="Is Admin?" />
							
							<s:checkboxlist label="User Roles" list="roles" name="userRoles" />
						</s:form>
					</div>
					
					<div id="buttonContainer">
						<a class="ui-button edit-button" href="javascript:submitForm(addForm);">Create</a>
						<br/>
					</div>
				</s:else>
			</div>
		</div>
	</div>
	
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>
