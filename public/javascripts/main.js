function getJson(url){
	var odd = true;
	var ytUid = "", stdUid = "";
	var highlight = "";
	if (location.search){
		if (location.search.split("&").length > 1){
			ytUid = location.search.split("&")[0].split("=")[1];
			stdUid = location.search.split("&")[1].split("=")[1];
		}else{
			ytUid = location.search.split("=")[1];
		}
	}
	switch (url){
		case "/studentReport":
			$.getJSON("/json/admin", function( data ) {
				$.each(data, function(index, val) {
					if (odd){
						$(".report tbody").append("<tr class='visible-row odd-row'>");
						odd = false;
					} else {
						$(".report tbody").append("<tr class='visible-row even-row'>");
						odd = true;
					}
					$(".report tbody tr:last-child").append('<td><button class="bt_actions">Meeting</button></td>');
					$(".report tbody tr:last-child").append('<td yt_uid="'+$(this).get(0)["tutor_id"]+'" yt_name="'+
						$(this).get(0)["tutor_name"] + '" class="uid">'+$(this).get(0)["email"]+'</td>');
					$(".report tbody tr:last-child").append('<td class="name">'+$(this).get(0)["name"]+'</td>');
					$(".report tbody tr:last-child").append('<td class="stud_ref">'+$(this).get(0)["stud_ref"]+'</td>');
					$(".report tbody tr:last-child").append('<td>'+$(this).get(0)["academic_year"]+'</td>');
					$(".report tbody tr:last-child").append('<td class="yos">'+$(this).get(0)["ss_year"]+'</td>');
					$(".report tbody tr:last-child").append('<td class="sop">'+$(this).get(0)["status"]+'</td>');
					$(".report tbody tr:last-child").append('<td>'+$(this).get(0)["attended"]+'/'+$(this).get(0)["total"]+'</td>');
					$(".report tbody tr:last-child").append('<td>'+$(this).get(0)["overall"]+'%'+'</td>');
					$(".report tbody").append('</tr>');
				});
		  	});
		  	break;
		case "/ytList":
			$.getJSON("/json/yt", function( data ) {
				$.each(data, function(index, val) {
					if ($(this).get(0)["tutor_id"] == ytUid){
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
						$(".report tbody tr:last-child").append('<td class="uid">'+$(this).get(0)["email"]+'</td>');
						$(".report tbody tr:last-child").append('<td class="name">'+$(this).get(0)["name"]+'</td>');
						$(".report tbody tr:last-child").append('<td class="stud_ref" cur_year="'+$(this).get(0)["academic_year"]
									+'">'+$(this).get(0)["stud_ref"]+'</td>');
						$(".report tbody tr:last-child").append('<td class="sop">'+$(this).get(0)["status"]+'</td>');
						$(".report tbody tr:last-child").append('<td class="tutor">'+$(this).get(0)["tutor_id"]+'</td>');
						$(".report tbody tr:last-child").append('<td id_meeting="'+$(this).get(0)["id_meeting"]
									+ '" class="datetime_meeting">'+strToDateTime($(this).get(0)["datetime"])+'</td>');
						$(".report tbody tr:last-child").append('<td>'+$(this).get(0)["overall"]+'%'+'</td>');
						$(".report tbody").append('</tr>');
					}
				});
		  	});
		  	break;
	}
}

function changeDisplay(obj){
	if (obj.css("display") == "none"){
		obj.css("display", "block");
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
