<%@ taglib prefix="s" uri="/struts-tags"%>

<!doctype html>
<html>
<head>
	<title>Logged Out</title>
	<s:head />
	<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		page = "home";
		pageSetup(page);
	</script>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/includes/header.jsp" />
		<div id="content">You have been logged out.</div>
	</div>
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>
