< %@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Contractor</title>
</head>
<body>
 
<p>Contractor</p>
 
<s:form name="contractor" method="post" action="contractor.action">

	<s:textfield name="id" label="id" /> 
	<s:textfield name="contractor" label="contractor" />
	<s:textfield name="contact" label="contact" />
	<s:textfield name="locations" label="locations" />
	<s:submit type="button" name="Add" />
						
 </s:form>
 
</body>
</html>
