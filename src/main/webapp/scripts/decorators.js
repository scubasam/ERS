

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
	var h1 = $("#editContainer").height();
	
	var h2 = $(window).height() - (h1 + 202);
	if(h2 < 240){ h2 = 240; }
	
	if(h2 > $("#"+page).height()){ h2 = $("#"+page).height; }
	
	$("#scrollContainer").height(h2);
}

function submitForm(form){
	$(form).submit();
}

// Dynamically resizes elements
$(window).resize(function(){
	interfaceSetup();
});
