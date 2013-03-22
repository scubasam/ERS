<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Add Contact</title>
<s:head />
</head>
<body>
<jsp:include page="/WEB-INF/content/header.jsp" />
<p>Add Contact</p>

<s:if test="isError">
	<s:property value="errorMessage" />
</s:if>
 
<s:form name="addContact" action="addContact.action">

	<s:textfield name="contact.firstName" label="First Name" />
	<s:textfield name="contact.lastName" label="Last Name" />
	<s:textfield name="contact.middleInitial" label="Middle Initial" />
	<s:textfield name="contact.emailAddress" label="Email Address" />
	<s:textfield name="contact.streetAddress1" label="Street Address 1" />
	<s:textfield name="contact.streetAddress2" label="Street Address 2" />
	<s:textfield name="contact.city" label="City" />
	<s:textfield name="contact.state" label="State" />
	<s:textfield name="contact.zip" label="Zip" />
	<s:textfield name="contact.primaryPhone" label="Primary Phone" />
	<s:textfield name="contact.workPhone" label="Work Phone" />
		
	<s:submit type="button" name="Add Contact" />
						
	</s:form>
	<jsp:include page="/WEB-INF/content/footer.jsp" />
</body>
</html>