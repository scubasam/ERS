<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<html>
	<head>
		<title>Error</title>
		<s:head />
		<jsp:include page="/includes/decorator.jsp" />
		<script type="text/javascript">
			// style the nav bar
			setCurrentPage("home");
		</script>
	</head>
	<body>
		<div id="container">
			<jsp:include page="/includes/header.jsp" />
			<div id="content">
			
			<div class="error">
				Permission denied. You do not have permission to access this resource. This incident has been logged.
			</div>
			<div class="push"></div>
		</div>
		</div>
		<jsp:include page="/includes/footer.jsp" />
	</body>
</html>