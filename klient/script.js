$(function () {
    $('#reqForm').on('submit',function (e) {
		const formInputs = {};
		$.each($(this).serializeArray(), function(i, field) {
			formInputs[field.name] = field.value;
		});
		
		const reqUrl = `${formInputs["basic"]}${formInputs["extended"]}`;		
		const reqMethod = $("#reqForm option:selected").text();
		
		const postParams = formInputs["postParams"];
		const params = jQuery.param(postParams);
		
		$.ajax({
			url: reqUrl,
			type: reqMethod,
			datatype: "text",
			data: params,
			success: function(data, textStatus, jqXHR) {
				alert(JSON.stringify(data));
			},
			error: function (jqXHR, textStatus, errorThrown) {
				console.log(textStatus + ": " + jqXHR.status + " " + errorThrown);
			},
		});
		e.preventDefault();
	});
});

function hideElement() {
    const input = document.getElementById("postParams");
    const label = document.getElementById("postParamsLabel");

	switch($('#reqType').val()) {
		case 'get':
			input.style.visibility = "hidden";
			label.style.visibility = "hidden";
			input.value = "";
			break;
		case 'post':
			input.style.visibility = "visible";
			label.style.visibility = "visible";
			break;
	}
};