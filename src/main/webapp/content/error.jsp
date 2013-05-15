<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<html>
	<head>
		<title>Error</title>
		<s:head />
		<jsp:include page="/includes/decorator.jsp" />
		<script type="text/javascript">
			// style the nav bar
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
				<div class="error">
					An unexpected error occurred.  Sorry for the inconvenience - Please try again.
				</div>
			<div class="push"></div>
			</div>
		</div>
		<jsp:include page="/includes/footer.jsp" />
	</body>
</html>
