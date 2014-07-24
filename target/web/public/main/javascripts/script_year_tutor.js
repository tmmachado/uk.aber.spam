$(document).ready(function(){

	actions_dialog = $("#hidden_actions").dialog({
    	modal:true,
    	autoOpen:false,
    	width:600,
    	height:470,
    });

    $("#date").datepicker({ dateFormat: "dd/mm/yy" });

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

	$("#progressbar").progressbar({
		value: false
    });


	$("#absent").click(function(e){
		if($("#absent").prop('checked')){
			$("#form_group").fadeOut();
		}else{
			$("#form_group").fadeIn();
		}
		/*var bool = false;
		if($("#absent").prop('checked')){
			bool = true;
		}

		$("#hours").spinner( "option", "disabled", bool);
		$("#minutes").spinner( "option", "disabled", bool);
		$("#outcome").prop('disabled', bool);
		$("#date").prop('disabled', bool);*/
    });

	$("#btn_updateOutcome").click(function(e) {
		$("#progressbar").css("display", "block");
		$("#form_outcome").submit();
		$("#btn_updateOutcome").prop('disabled', true);
		return;
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
		}

		if ($(this).attr('class') !== undefined && $(this).attr('class') == "datetime_meeting"){
			$("#date").val($(this).text().split(" ")[0]);
			$("#hours").val($(this).text().split(" ")[1].split(":")[0]);
			$("#minutes").val($(this).text().split(" ")[1].split(":")[1]);
			$("#id_meeting").val($(this).attr('id_meeting'));
		}

		if ($(this).attr('class') !== undefined && $(this).attr('class') == "stud_ref"){
			$("#stud_ref").val($(this).text());
			$("#cur_year").val($(this).attr('cur_year'));
		}

		if ($(this).attr('class') !== undefined && $(this).attr('class') == "tutor"){
			$("#year_tutor_uid").val($(this).text());
		}

		if ($(this).attr('class') !== undefined && $(this).attr('class') == "name"){
			$("#stud_name").val($(this).text());
		}
	});
	actions_dialog.dialog("open");
}
