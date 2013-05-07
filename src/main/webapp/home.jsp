<%-- @author Mitchell Nemitz, Kelly Smith, Alex McCracken --%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!doctype html>
<html>
	<head>
		<title>Enterprise Routing System</title>
		<s:head />
		<jsp:include page="/includes/decorator.jsp" />
		<script type="text/javascript">
			page = "home";
			pageSetup(page);
			
			$(document).ready(function(){
				$("#columnSelectButton").hide();
			});
		</script>
	</head>
	<body>
		<div id="wrapper">
			<jsp:include page="/includes/header.jsp" />
			<div id="content">
				<s:if test="loggedIn == true">
					<p>Welcome, <s:property value="currentUser.username"/>!</p>
				</s:if>
				<s:else>
					<div class="login">
						<h2 style="text-align: center;">User Login</h2>
						<jsp:include page="/content/user/loginForm.jsp" />
					</div>
				</s:else>
				<div class="push"></div>
			</div>
		</div>
		<jsp:include page="/includes/footer.jsp" />
	</body>
</html>
