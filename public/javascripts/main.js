function getJson(url){
	var odd = true;
	var ytUid = "",
		stdUid = "",
		dotUid = "";
	var highlight = "";
	var param = location.search;

	if (param != ""){
		if (param.indexOf("stdUid") != -1){
			if (param.indexOf("&", param.indexOf("stdUid") + 7) != -1){
				stdUid = param.substring(param.indexOf("stdUid")+7, param.indexOf("&", param.indexOf("stdUid") + 7));
			}else{
				stdUid = param.substring(param.indexOf("stdUid")+7);
			}
		}

		if (param.indexOf("ytUid") != -1){
			if (param.indexOf("&", param.indexOf("ytUid") + 6) != -1){
				ytUid = param.substring(param.indexOf("ytUid")+6, param.indexOf("&", param.indexOf("ytUid") + 6));
			}else{
				ytUid = param.substring(param.indexOf("ytUid")+6);
			}
		}

		if (param.indexOf("dotUid") != -1){
			if (param.indexOf("&", param.indexOf("dotUid") + 7) != -1){
				dotUid = param.substring(param.indexOf("dotUid")+7, param.indexOf("&", param.indexOf("dotUid") + 7));
			}else{
				dotUid = param.substring(param.indexOf("dotUid")+7);
			}
		}
	}

	switch (url){
		case "/studentReport":
			$.getJSON("/json/admin", function( data ) {
				$.each(data, function(index, val) {
						if ($(this).get(0)["email"] == stdUid){
							highlight = "highlight";
						}
						if (odd){
							$(".report tbody").append("<tr class='visible-row odd-row "+highlight+"'>");
							odd = false;
						} else {
							$(".report tbody").append("<tr class='visible-row even-row "+highlight+"'>");
							odd = true;
						}
						highlight = "";
						$(".report tbody tr:last-child").append('<td><button class="bt_actions">Meeting</button></td>');
						$(".report tbody tr:last-child").append('<td responsible_uid="'+$(this).get(0)["responsible_uid"] +
							'" responsible_name="' + $(this).get(0)["responsible_name"] + '" class="uid" stud_ref="'+
							$(this).get(0)["stud_ref"] + '">'+$(this).get(0)["email"]+'</td>');
						$(".report tbody tr:last-child").append('<td class="name">'+$(this).get(0)["name"]+'</td>');
						$(".report tbody tr:last-child").append('<td class="course">'+$(this).get(0)["course"]+'</td>');
						$(".report tbody tr:last-child").append('<td>'+$(this).get(0)["academic_year"]+'</td>');
						$(".report tbody tr:last-child").append('<td class="yos">'+$(this).get(0)["ss_year"]+'</td>');
						$(".report tbody tr:last-child").append('<td class="repeating">'+$(this).get(0)["repeating"]+'</td>');
						$(".report tbody tr:last-child").append('<td class="sop">'+$(this).get(0)["stage_of_process"]+'</td>');
						$(".report tbody tr:last-child").append('<td>'+$(this).get(0)["attended"]+'/'+$(this).get(0)["total"]+'</td>');
						$(".report tbody tr:last-child").append('<td class="overall">'+$(this).get(0)["overall"]+'%'+'</td>');
						$(".report tbody").append('</tr>');
				});
		  	});
		  	break;
		case "/ytList":
			$.getJSON("/json/yt", function( data ) {
				$.each(data, function(index, val) {
					if ($(this).get(0)["responsible_uid"] == ytUid){
						if ($(this).get(0)["email"] == stdUid){
							highlight = "highlight";
						}

						if (odd){
							$(".report tbody").append("<tr class='visible-row odd-row "+highlight+"'>");
							odd = false;
						} else {
							$(".report tbody").append("<tr class='visible-row even-row "+highlight+"'>");
							odd = true;
						}

						highlight = "";

						$(".report tbody tr:last-child").append('<td><button class="bt_actions">Update</button></td>');
						$(".report tbody tr:last-child").append('<td responsible_uid="' + $(this).get(0)["responsible_uid"] +
							'" class="uid">'+$(this).get(0)["email"]+'</td>');
						$(".report tbody tr:last-child").append('<td class="name">'+$(this).get(0)["name"]+'</td>');
						$(".report tbody tr:last-child").append('<td class="stud_ref" cur_year="'+$(this).get(0)["academic_year"]
									+'">'+$(this).get(0)["stud_ref"]+'</td>');
						$(".report tbody tr:last-child").append('<td class="sop">'+$(this).get(0)["stage_of_process"]+'</td>');
						$(".report tbody tr:last-child").append('<td id_meeting="'+$(this).get(0)["id_meeting"]
									+ '" class="datetime_meeting">'+strToDateTime($(this).get(0)["datetime"])+'</td>');
						$(".report tbody tr:last-child").append('<td class="overall">'+$(this).get(0)["overall"]+'%'+'</td>');
						$(".report tbody").append('</tr>');
					}
				});
		  	});
		  	break;
		case "/dotList":
			$.getJSON("/json/dot", function( data ) {
				$.each(data, function(index, val) {
					if ($(this).get(0)["responsible_uid"] == dotUid){
						if ($(this).get(0)["email"] == stdUid){
							highlight = "highlight";
						}

						if (odd){
							$(".report tbody").append("<tr class='visible-row odd-row "+highlight+"'>");
							odd = false;
						} else {
							$(".report tbody").append("<tr class='visible-row even-row "+highlight+"'>");
							odd = true;
						}

						highlight = "";

						$(".report tbody tr:last-child").append('<td><button class="bt_actions">Update</button></td>');
						$(".report tbody tr:last-child").append('<td responsible_uid="' + $(this).get(0)["responsible_uid"] +
							'" class="uid">'+$(this).get(0)["email"]+'</td>');
						$(".report tbody tr:last-child").append('<td class="name">'+$(this).get(0)["name"]+'</td>');
						$(".report tbody tr:last-child").append('<td class="stud_ref" cur_year="'+$(this).get(0)["academic_year"]
									+'">'+$(this).get(0)["stud_ref"]+'</td>');
						$(".report tbody tr:last-child").append('<td class="sop">'+$(this).get(0)["stage_of_process"]+'</td>');
						$(".report tbody tr:last-child").append('<td id_meeting="'+$(this).get(0)["id_meeting"]
									+ '" class="datetime_meeting">'+strToDateTime($(this).get(0)["datetime"])+'</td>');
						$(".report tbody tr:last-child").append('<td class="overall">'+$(this).get(0)["overall"]+'%'+'</td>');
						$(".report tbody").append('</tr>');
					}
				});
		  	});
		  	break;
	}
}

function changeDisplay(obj, display){
	if (obj.css("display") == "none"){
		obj.css("display", display);
	} else {
		obj.css("display", "none");
	}
}

function getArrayFromClass(c){
	var array = new Array();
	$(".report tbody ."+ c).each(function(index) {
		array.push($(this).text());
	});
	return array;
}

function filter(input){
	var filterClass = $('.btn_filter').parent().attr("class");
	var originalArray = getArrayFromClass(filterClass);
	var odd = true;

	if (originalArray.indexOf(input.val()) !== -1){
		$(".report tbody ."+filterClass).each(function(index) {
			if ($(this).text() != input.val()){
				$(this).parent().removeClass('visible-row');
				$(this).parent().addClass('invisible-row');
			} else {
				$(this).parent().removeClass('invisible-row');
				$(this).parent().addClass('visible-row');
				if (odd) {
					$(this).parent().removeClass('even-row');
					$(this).parent().addClass('odd-row');
					odd = false;
				} else {
					$(this).parent().removeClass('odd-row');
					$(this).parent().addClass('even-row');
					odd = true;
				}
			}
		});
	} else if (input.val() == "") {
		$(".report tbody ."+filterClass).each(function(index) {
			$(this).parent().removeClass('invisible-row');
			$(this).parent().addClass('visible-row');
			if (odd) {
					$(this).parent().removeClass('even-row');
					$(this).parent().addClass('odd-row');
					odd = false;
				} else {
					$(this).parent().removeClass('odd-row');
					$(this).parent().addClass('even-row');
					odd = true;
				}
		});
	}
}

function strToDateTime(str){
	var day = str.substring(8, 10);
	var month = str.substring(5, 7);
	var year = str.substring(0, 4);
	var hour = str.substring(11, 13);
	var min = str.substring(14, 16);
	return day + "/" + month + "/" + year + " " + hour + ":" + min;
}

function getFeedback(){
	if ($("#feedback").text() != ""){
		alert($("#feedback").text());
	}
}

function order(colClass, elem, ctx, order){
	var unordered = new Array();
	var ordered = new Array();

	$(ctx+' .'+colClass).each(function(index) {
		unordered.push(new Array($(this).text(), $(this).parent()));
	});

	order.toUpperCase() == "ASC" ? ordered = unordered.sort() : ordered = unordered.sort().reverse();

	$(ctx+" "+elem).remove();
	$.each(ordered, function(index, val) {
		$(ctx).append(ordered[index][1]);
		if (index % 2 == 0){
			$(ctx+" "+elem).last().removeClass('even-row');
			$(ctx+" "+elem).last().addClass('odd-row');
		}else{
			$(ctx+" "+elem).last().removeClass('odd-row');
			$(ctx+" "+elem).last().addClass('even-row');
		}
	});
}
