<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("logout");
	</script>
<title>Enterprise Routing System</title>
<s:head />
</head>
<body>
<jsp:include page="/includes/header.jsp" />

You have been logged out.

 <jsp:include page="/includes/footer.jsp" />
</body>
</html>