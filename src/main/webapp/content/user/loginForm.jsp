<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form name="loginForm" method="post" action="loginUser.action" id="userLoginForm">

	<s:textfield name="userBean.username" label="Username" />
	<s:password name="userBean.password" label="Password" />
 
	<s:submit type="button" name="Login" label="Login" />
 
</s:form>
