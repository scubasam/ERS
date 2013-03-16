<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Add User</title>
</head>
<body>
<jsp:include page="/WEB-INF/content/header.jsp" />
<p>Add User</p>

<s:if test="isError">
	<s:property value="errorMessage" />
</s:if>

<s:form name="addForm" method="post" action="addUser.action">
 
	<s:textfield name="username" label="User" />
	<s:password name="password" label="Password" />
	<s:checkbox name="admin" label="Is Admin?" />
 
	<s:submit type="button" name="Add" />
 
</s:form>
 <jsp:include page="/WEB-INF/content/footer.jsp" />
</body>
</html>