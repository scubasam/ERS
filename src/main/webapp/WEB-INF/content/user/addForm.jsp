<%@ taglib prefix="s" uri="/struts-tags"%>

<!doctype html>
<html>
<head>
<title>Add User</title>
<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		page = "users";
		setCurrentPage(page);
	</script>
<s:head />
</head>
<body>
<div id="container">
<jsp:include page="/includes/header.jsp" />

<s:if test="isError">
	<s:property value="errorMessage" />
</s:if>

<s:form name="addForm" method="post" action="addUser.action">
 
	<s:textfield name="userBean.username" label="User" />
	<s:password name="userBean.password" label="Password" />
	<s:checkbox name="userBean.admin" label="Is Admin?" />
	<s:checkboxlist label="User Roles" list="roles" name="userRoles" />
 
	<s:submit type="button" name="Add" />
 
</s:form>
</div>
 <jsp:include page="/includes/footer.jsp" />
</body>
</html>