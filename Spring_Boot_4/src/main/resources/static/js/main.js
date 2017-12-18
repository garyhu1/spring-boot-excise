$(document).ready(function(){
	//验证
	$("#btn").click(function(event){
		event.preventDefault();
		submit_validate();
	});
	//登录
	$("#login").click(function(event){
		event.preventDefault();
		login();
	});
});

function submit_validate(){
	$("#btn").prop("disabled",true);
	var info ={}
	info["id"] = $("#content").val();
	
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/validate",
		data: JSON.stringify(info),
		dataType: "json",
		cache: false,
		timeout: 600000,
		success: function(data){
			var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#con').html(json);
            console.log("SUCCESS : ", data);
            $("#btn").prop("disabled", false);
		},
		error: function(e){
			var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#con').html(json);
            $("#btn").prop("disabled", false);
		}
	});
}

function login() {
	$("#login").prop("disabled",true);
	var user = {};
	user["username"] = $("#username").val();
	user["password"] = $("#password").val();
	
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/admin/login",
		data: JSON.stringify(user),
		dataType: "json",
		cache: false,
		timeout: 600000,
		success: function(data){
			$("#login").prop("disabled",false);
			var json = "<h4>登录成功</h4><pre>"+
			   JSON.stringify(data,null,4)+"</pre>";
			$("#login_result").html(json);
		},
		error: function(e){
			$("#login").prop("disabled",false);
			var json = "<h4>登录失败</h4><pre>"+
			   e.responseText+"</pre>";
			$("#login_result").html(json);
		}
	});
}