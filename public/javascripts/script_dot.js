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

	var clicked = false;
    $(".report").on('click', '.visible-row', function() {
    	clicked == false ? $(this).siblings().fadeOut() : $(this).siblings().fadeIn();
		clicked == false ? clicked = true : clicked = false;

    });

    $(".asc").click(function() {
		order($(this).parent().attr("class"), "tr", ".report tbody", "asc");
	});

	$(".desc").click(function() {
		order($(this).parent().attr("class"), "tr", ".report tbody", "desc");
	});

	$("#btn_updateOutcome").click(function(e) {
		$("#progressbar").css("display", "block");
		setTimeout(function(){
			$("#form_outcome").submit();
			$("#btn_updateOutcome").prop('disabled', true);
			$("#outcome").prop('disabled', true);
			$("#date").prop('disabled', true);
			$("#absent").prop('disabled', true);
			$("#hours").spinner( "option", "disabled", true );
			$("#minutes").spinner( "option", "disabled", true );
		}, 50);
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
			$("#responsible_uid").val($(this).attr('responsible_uid'));
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

		if ($(this).attr('class') !== undefined && $(this).attr('class') == "name"){
			$("#stud_name").val($(this).text());
		}
	});
	actions_dialog.dialog("open");
}
