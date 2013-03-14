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
				<table class="login">
					<tr>
						<td>Username: </td>
						<td><input type="text" class="username" /></td>
					</tr>
					<tr>
						<td>Password: </td>
						<td><input type="password" class="password" /></td>
					</tr>
				</table>
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