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
			$("#arrange_meeting").submit();
			$("#btn_sendEmail").prop('disabled', true);
			return;
		}
		alert("You must fill all the fields!");
	});

	$(".btn_filter").click(function() {
		changeDisplay($(".hidden_container"));
		$("#hidden_filter").focus();
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
			$("#meeting_with").text($(this).attr('yt_name') + ' (Year Tutor)');
			$("#year_tutor_name").val($(this).attr('yt_name'));
			$("#year_tutor_uid").val($(this).attr('yt_uid'));
		}

		if ($(this).attr('class') !== undefined && $(this).attr('class') == "name"){
			$("#stud_name").val($(this).text());
		}

		if ($(this).attr('class') !== undefined && $(this).attr('class') == "stud_ref"){
			$("#stud_ref").val($(this).text());
		}

		if ($(this).attr('class') !== undefined && $(this).attr('class') == "sop"){
			if($(this).text().toUpperCase() != "FIRST TIME"){
				$("#meeting_with").text('Tarcio Machado (DOT)');
			}
		}
	});
	actions_dialog.dialog("open");
}