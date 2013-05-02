// @author Mitchell Nemitz
// @depends jquery-1.9.1.js
// @purpose Provides a set of convenience functions for the
// more dynamic sections of the app, allowing custom form
// submissions and providing onready style changes.



// Called on each page to dynamically style the interface
// to match each management page. 
function pageSetup(page){
	$(document).ready(function(){
		$("#nav_" + page).addClass("currentpage");
		$("#columnSelect").hide();

		interfaceSetup();
	});
}

// Sets up the dual pane interface, keeping sensible minimum heights
function interfaceSetup(){
	var h2 = $(window).height() - ($("#editContainer").height() + 340);
	
	if(h2 < 300){ h2 = 300; }
	if(h2 > $("#"+page).height()){ h2 = $("#"+page).height; }
	
	$("#dataContainer").height(h2);
}

// convenience function for submitting complex forms
function submitForm(form){
	$(form).submit();
}

// IE compatibility function. Internet Explorer doesn't
// like having jquery inline, so this is the simple solution.
function toggleColumnSelect() {
	$('#columnSelect').toggle();
}

// Resizes static elements when the window
// is resized to keep the UI consistent.
$(window).resize(function(){
	interfaceSetup();
});

// jQuery UI element styling onready
$(document).ready(function () {
	$(".buttonDiv").button();
	$(".ui-button").button();
});
