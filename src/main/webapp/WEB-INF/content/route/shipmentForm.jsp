<%-- @authors Mitchell Nemitz, Kelly Smith --%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<%-- Obviously the action name is bullshit, but something like this should do it --%>
<s:form name="addShipmentRoute" method="post" action="addShipmentRoute.action">
	<ul id="shipmentList">
		<s:iterator value="shipments">
			<li><s:property value="orderId" /></li>
		</s:iterator>
	</ul>
	<input type="hidden" name="orderedShipmentList" />
	
	<s:submit type="button" name="Submit Shipments" />
</s:form>

<script type="text/javascript">
$("#shipmentList").disableSelection();
$("#shipmentList").sortable({
    placeholder: "ui-state-highlight",
    cursor: 'crosshair',
    update: function(event, ui) {
        var order = $("#shipmentList").sortable("toArray");
        $('#orderedShipmentList').val(order.join(","));
        alert($('#orderedShipmentList').val());
    }
});
</script>
