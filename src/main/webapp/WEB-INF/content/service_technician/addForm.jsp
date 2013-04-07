<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Add Service Technician</title>
<s:head />
<jsp:include page="/includes/decorator.jsp" />
	<script type="text/javascript">
		// style the nav bar
		setCurrentPage("technicians");
	</script>
</head>
<body>
<div id="container"> 
<jsp:include page="/includes/header.jsp" /> 
<s:form name="addServiceTechnician" method="post" action="addServiceTechinican.action">

	<s:textfield name="serviceTechnician.id" label="id" /> 
	<s:textfield name="serviceTechnician.contact" label="contact" />
	<s:textfield name="serviceTechnician.skillGrade" label="skillGrade" />
	<s:textfield name="maintenanceOrder.maintenanceOrders" label="maintenanceOrders" />
	<jsp:include page ="/WEB-INF/content/contact/fieldForm.jsp" />
	
	<s:submit type="button" name="Add Service Technician" />
		
 </s:form>
 </div>
 <jsp:include page="/includes/footer.jsp" />
</body>
</html>