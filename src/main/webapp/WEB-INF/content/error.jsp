<html>
	<head>
		<style type="text/css">
			<jsp:include page="WEB-INF/content/style.css" />
		</style>
	</head>
	<body>
		<div id="container">
			<jsp:include page="header.jsp" />
			
			<div class="error">
				An unexpected error occurred.  Sorry for the inconvenience - Please try again.
			</div>
			<div class="push"></div>
		</div>
		<jsp:include page="footer.jsp" />
		
		<script type="text/javascript">
			<jsp:include page="WEB-INF/content/scripts.js" />
			setCurrentPage("nav_home");
		</script>
	</body>
</html>