<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<html>
	<head>
		<style type="text/css">
			<jsp:include page="WEB-INF/content/style.css" />
		</style>
	</head>
	<body>
		<div id="container">
			<jsp:include page="WEB-INF/content/header.jsp" />
			
			<s:if test="loggedIn == true">
				<div class="login">
					Hello <s:property value="currentUser" /> | <a href="logout.action">Logout</a>
				</div>
			</s:if>
			<s:else>
				<div class="login">
					<jsp:include page="/WEB-INF/content/user/loginForm.jsp" />
				</div>
			</s:else>
			<div class="push"></div>
		</div>
		<jsp:include page="WEB-INF/content/footer.jsp" />
		
		<script type="text/javascript">
			<jsp:include page="WEB-INF/content/scripts.js" />
			setCurrentPage("nav_home");
		</script>
	</body>
</html>