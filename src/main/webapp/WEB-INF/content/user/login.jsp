<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>User Login</title>
<s:head />
</head>
<body>
<jsp:include page="/WEB-INF/content/header.jsp" />
<p>User Login</p>

<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>
<jsp:include page="/WEB-INF/content/user/loginForm.jsp" />

 <jsp:include page="/WEB-INF/content/footer.jsp" />
</body>
</html>