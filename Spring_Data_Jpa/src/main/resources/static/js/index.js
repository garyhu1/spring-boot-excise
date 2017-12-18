$(document).ready(function() {
	$("#btn").click(function(event) {
		event.preventDefault();

		$(this).css({"background-color":"red","color": "#ffffff"});
		search_data();
	})
});

function search_data() {
	$("#btn").prop("disabled",true);
	var search = {}
	search["page"] = $("#page").val();
	search["size"] = $("#num").val();
	search["departmentId"] = $("#dep").val();

	$.ajax({
		type: "POST",
        contentType: "application/json",
        url: "/search",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#result').html(json);
            console.log("SUCCESS : ", data);
            $("#btn").prop("disabled", false);
        },
        error: function (e) {
            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#result').html(json);
            console.log("ERROR : ", e);
            $("#btn").prop("disabled", false);
        }
	});
}