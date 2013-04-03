<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<jsp:include page="/includes/decorator.jsp" />
	<title>Logged Out</title>
	<s:head />
	<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("home");
	</script>
</head>
<body>
<jsp:include page="/includes/header.jsp" />
<div id="container">
	<div id="content">
		You have been logged out.
	</div>
</div>
 <jsp:include page="/includes/footer.jsp" />
</body>
</html>