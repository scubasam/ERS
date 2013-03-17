<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form name="loginForm" method="post" action="loginUser.action">
 
	<s:textfield name="userBean.username" label="User" />
	<s:password name="userBean.password" label="Password" />
 
	<s:submit type="button" name="Login" label="Login" />
 
</s:form>