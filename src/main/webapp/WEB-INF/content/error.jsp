<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<s:url value="/styles/main.css" />">
	</head>
	<body>
		<div id="container">
			<jsp:include page="/includes/header.jsp" />
			
			<div class="error">
				An unexpected error occurred.  Sorry for the inconvenience - Please try again.
			</div>
			<div class="push"></div>
		</div>
		<jsp:include page="/includes/footer.jsp" />
	</body>
</html>