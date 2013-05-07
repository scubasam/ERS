<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Route</title>
<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("routes");
	</script>
</head>
<body>
 
<p>Route</p>
 
<s:form name="route" method="post" action="route.action">

	<s:textfield name="id" label="id" /> 
	<s:textfield name="vehicle" label="vehicle" />
	<s:textfield name="shipments" label="shipments" />
	<s:submit type="button" name="Add" />								
 </s:form>
 
</body>
</html>