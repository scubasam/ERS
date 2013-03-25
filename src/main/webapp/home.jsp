<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
	<head>
		<jsp:include page="/includes/decorator.jsp" />
		<script type="text/javascript">
			// style the nav bar
			setCurrentPage("home");
		</script>
	</head>
	<body>
		<div id="container">
			<jsp:include page="/includes/header.jsp" />
			
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
		
		<jsp:include page="/includes/footer.jsp" />
		
		<script type="text/javascript">
		</script>
	</body>
</html>
