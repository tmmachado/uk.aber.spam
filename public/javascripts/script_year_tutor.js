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

	$("#btn_updateOutcome").click(function(e) {
		//if ($("#outcome").val() != ""){

			$("#form_outcome").submit();
			//return;
		//}
		//alert("You must fill all the fields!");
	});

	$(".report").on('click', '.bt_actions', function() {
	     openHiddenActionsDialog($(this).parent());
	});

	getJson(location.pathname);

});

function openHiddenActionsDialog(btn_column){
	btn_column.siblings().each(function(index) {
		if ($(this).attr('class') !== undefined && $(this).attr('class') == "uid"){
			$("#meeting_for").text($(this).text());
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
			$("#cur_year").val($(this).attr('cur_year'));
		}
	});
	actions_dialog.dialog("open");
}
