<html>
	<head>
		<style type="text/css">
			<jsp:include page="WEB-INF/content/style.css" />
		</style>
	</head>
	<body>
		<div id="container">
			<jsp:include page="WEB-INF/content/header.jsp" />
			
			<div class="login">
				<jsp:include page="/WEB-INF/content/user/loginForm.jsp" />
			</div>
			<div class="push"></div>
		</div>
		<jsp:include page="WEB-INF/content/footer.jsp" />
		
		<script type="text/javascript">
			<jsp:include page="WEB-INF/content/scripts.js" />
			setCurrentPage("nav_home");
		</script>
	</body>
</html>