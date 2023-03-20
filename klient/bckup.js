$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/HelloWorldApp/webresources/RestService/score",
		type: "get",
		datatype: "text",
		success: function(data, textStatus, jqXHR) {
			alert(JSON.stringify(data));
		},
		error: function (jqXHR, textStatus, errorThrown) {
			console.log(textStatus + ": " + jqXHR.status + " " + errorThrown);
		},
		complete(jqXHR, textStatus) {
			console.log(jqXHR.status);
		}
	});
});



