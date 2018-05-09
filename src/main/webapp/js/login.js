layui.use(['form', 'layedit', 'laydate'], function(){
	var form = layui.form,
	layer = layui.layer,
	layedit = layui.layedit,
	laydate = layui.laydate;
	
	$('#loginBtn').on("click",loginBtn);
			
});

var rulePhone = /^[1][3,4,5,7,8][0-9]{9}$/; //手机号码
var ruleUserName = /^[a-zA-z]\w{5,19}$/;		//用户名规则：字母、数字、下划线组成，字母开头，6-20位
var ruleEmail = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/; //邮箱规则
var user;

function verifyLoginMessage(data){
	if(!(rulePhone.test(data) || ruleEmail.test(data) || ruleUserName.test(data))){
		return false;
	}else{
		return true;
	}
}

function loginBtn(){
	var loginMessage = $('input[name="loginMessage"]').val();
	var password = $('input[name="password"]').val();
	var flag = false;
	if(true===verifyLoginMessage(loginMessage)){	//前端先校验格式
		$.ajax({
			async: false,
			type: 'POST',
			url: 'UserInfo/validate/loginMessage.mvc',
			data:{
				"loginMessage":loginMessage,
				"password":password
			},
			success: function(data){
				if("true"==data.result){
					$.ajax({
						async: false,
						type:"POST",
						url:"UserInfo/login.mvc",
						data:{
							"loginMessage":loginMessage,
							"password":password
						},
						success:function(data){
							user = data.object;
							storeSessionStorage("userData",data.object);
							flag = true;
						}
					});
				}else{
					layer.msg(data.message);
				}
			}
		});
	}else{
		layer.msg("输入的用户名格式不正确");
		flag = false;
	}
	console.log(user);
	return flag;
}

function storeSessionStorage(dataName,data){
	var userData = {
			'local_id':data.id,
			'local_registPhone':data.registPhone,
			'local_registEmail':data.registEmail,
			'local_registCode':data.registCode,
			'local_registTime':data.registTime,
			'local_lastLoginTime':data.lastLoginTime,
			'local_userName':data.userName,
			'local_password':data.password,
			'local_loginState':data.loginState,
			'local_state':data.state,
			'local_openId':data.openId,
			'local_headPhotoUrl':data.headPhotoUrl
	};
	window.sessionStorage.setItem(dataName,JSON.stringify(userData));
}
