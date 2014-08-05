var actions_dialog;

$(document).ready(function(){
	$("#date").datepicker({
		dateFormat: "dd/mm/yy",
		minDate: -0
	});

	actions_dialog = $("#hidden_actions").dialog({
	  	modal:true,
	   	autoOpen:false,
	   	width:450,
	   	height:320,
	});

	$("#progressbar").progressbar({
		value: false
    });

	var hourSpinner = $( "#hours" ).spinner({
		min:8,
		max:17,
		numberFormat: "d2"
	});
	var minuteSpinner = $( "#minutes" ).spinner({
		min:0,
		max:50,
		numberFormat: "d2",
		step:10
	});

	$("#btn_sendEmail").click(function(e) {
		if ($("#date").val() != "" && $("#location").val() != ""){
			$("#progressbar").css("display", "block");
			setTimeout(function(){
				$("#arrange_meeting").submit();
				$("#btn_sendEmail").prop('disabled', true);
				$("#date").prop('disabled', true);
				$("#hours").spinner( "option", "disabled", true );
				$("#minutes").spinner( "option", "disabled", true );
				$("#location").prop('disabled', true);
			}, 50);
			return;
		}
		alert("You must fill all the fields!");
	});

	$(".btn_filter").click(function() {
		changeDisplay($("#hidden_filter"), "inline");
		$("#hidden_filter").focus();
	});

	$(".asc").click(function() {
		order($(this).parent().attr("class"), "tr", ".report tbody", "asc");
	});

	$(".desc").click(function() {
		order($(this).parent().attr("class"), "tr", ".report tbody", "desc");
	});

	$("#hidden_filter").keyup(function(){
		filter($(this));
	});

	$(".report").on('click', '.bt_actions', function() {
	     openHiddenActionsDialog($(this).parent());
	});

	getFeedback();
	getJson(location.pathname);

});

function openHiddenActionsDialog(btn_column){
	btn_column.siblings().each(function(index) {
		if ($(this).attr('class') !== undefined && $(this).attr('class') == "uid"){
			$("#meeting_for").text($(this).text());
			$("#stud_uid").val($(this).text());
			$("#meeting_with").text($(this).attr('responsible_name') + " [" + $(this).attr('responsible_uid') + "]");
			$("#responsible_uid").val($(this).attr('responsible_uid'));
			$("#responsible_name").val($(this).attr('responsible_name'));
			$("#stud_ref").val($(this).attr('stud_ref'));
		}

		if ($(this).attr('class') !== undefined && $(this).attr('class') == "name"){
			$("#stud_name").val($(this).text());
		}

		if ($(this).attr('class') !== undefined && $(this).attr('class') == "yos"){
			$("#year_of_study").val($(this).text());
		}

		if ($(this).attr('class') !== undefined && $(this).attr('class') == "sop"){
			$("#stage_of_process").val($(this).text());
		}
	});
	actions_dialog.dialog("open");
}