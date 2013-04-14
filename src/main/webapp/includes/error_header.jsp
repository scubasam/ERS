<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="isError">
	<s:property value="errorMessage" />
</s:if>

<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>

<s:if test="hasActionMessages()">
   <div class="welcome">
      <s:actionmessage/>
   </div>
</s:if>

<s:if test="deleteSuccessful()">
	<div class="welcome">
     	<s:property value="deleteSuccessfulMessage()" />
   </div>
</s:if>