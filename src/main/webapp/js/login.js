layui.use(['form', 'layedit', 'laydate'], function(){
	var form = layui.form,
	layer = layui.layer,
	layedit = layui.layedit,
	laydate = layui.laydate;
	
	var rulePhone = /^[1][3,4,5,7,8][0-9]{9}$/; //手机号码
	var ruleUserName = /^[a-zA-z]\w{5,19}$/;		//用户名规则：字母、数字、下划线组成，字母开头，6-20位
	var ruleEmail = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/; //邮箱规则
	
	function verifyLoginMessage(data){
		if(!(rulePhone.test(data) || ruleEmail.test(data) || ruleUserName.test(data))){
			return false;
		}else{
			return true;
		}
	}
	
	$('#loginBtn').on("click",function(){
		var loginMessage = $('input[name="loginMessage"]').val();
		var password = $('input[name="password"]').val();
		if(true===verifyLoginMessage(loginMessage)){	//前端先校验格式
			$.ajax({
				type: 'POST',
				url: 'UserInfo/validate/loginMessage.mvc',
				data:{
					"loginMessage":loginMessage,
					"password":password
				},
				success: function(data){
					if("true"==data.result){
						$.ajax({
							type:"POST",
							url:"UserInfo/login.mvc",
							data:{
								"loginMessage":loginMessage,
								"password":password
							},
							success:function(data){
								console.log(data);
								storeCookie(data.object);
							}
						});
					}else{
						layer.msg(data.message);
					}
				}
			});
		}else{
			layer.msg("输入的用户名格式不正确");
		}
		
	});
	
	function storeCookie(data){
		$.cookie('userId',data.id);
	}
	
});