<%@ taglib prefix="s" uri="/struts-tags"%>

<!doctype html>
<html>
<head>
	<title>User Login</title>
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
		
			<s:if test="hasActionErrors()">
			   <div class="errors">
			      <s:actionerror/>
			   </div>
			</s:if>
			
			<div class="login">
				<h2 style="text-align: center;">User Login</h2>
				<jsp:include page="/WEB-INF/content/user/loginForm.jsp" />
			</div>
		</div>
	</div>
	
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>
