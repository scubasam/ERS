
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
	$("#scrollContainer").height(
		($(window).height()-50) / 2
	);
	
	$("#editContainer").height(
		($(window).height()-50) / 2
	);
}
