
function pageSetup(page){
	$(document).ready(function(){
		setCurrentPage(page);
		interfaceSetup();
	});
}

function setCurrentPage(nav){
	// for pageSetup call
	$("#nav_" + nav).addClass("currentpage");
	
	// Redundancy during the transition
	$(document).ready(function(){
		$("#nav_" + nav).addClass("currentpage");
	});
}

function interfaceSetup(){
	var h = ($(window).height() - 354);
	if(h < 240){ h = 240; }
	
	$("#scrollContainer").height(h);
	$("#editContainer").height(140);
}

// Dynamically resizes elements
$(window).resize(function(){
	interfaceSetup();
});

// Style the editing panel
if($(document).getUrlParam("id") != null){
	$("#addButton").css("color", "grey");
} else {
	
}
