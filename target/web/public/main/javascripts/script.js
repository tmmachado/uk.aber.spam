$(document).ready(function(){
	alert("oi!");
});

function getJson(){
	$.getJSON( "/report", function( data ) {
	  var items = [];
	  $.each(data, function( key, val ) {
	    items.push("<p>" + key + "->" + val + "</p>");
	  });
	}
}