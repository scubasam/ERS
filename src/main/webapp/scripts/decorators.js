
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
	var h1 = ($(window).height() - 196) * (0.75);
	if(h1 < 240){ h1 = 240; }
	
	var h2 = ($(window).height() - 196) * (0.25);
	if(h2 < 140){ h2 = 140; }
	
	$("#scrollContainer").height(h1);
	$("#editContainer").height(h2);
}
