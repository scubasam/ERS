<%@ taglib prefix="s" uri="/struts-tags" %>

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
				Unable to connect to the database.  Please contact your system administrator.
			</div>
			<div class="push"></div>
		</div>
		</div>
		<jsp:include page="/includes/footer.jsp" />
	</body>
</html>