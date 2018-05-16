$(function(){
	var user = window.sessionStorage.getItem('userData');
	$('#userBar').tmpl(JSON.parse(user)).appendTo(".user-bar");
	
	var user = JSON.parse(window.sessionStorage.getItem("userData"));
	$("[name=userName]").val(user.local_userName);
	$("[name=registEmail]").val(user.local_registEmail);
	$("[name=registPhone]").val(user.local_registPhone);
	$("[name=address]").val(user.local_sendAddress);
	
	$('#submitUserInfo').on("click",function(){
		var formData = new FormData();
		formData.append("id",user.local_id);
		formData.append("userName",$("[name='userName']").val());
		formData.append("registPhone",$("[name=registPhone]").find('option:selected').text());
		formData.append("registEmail",$("[name='registEmail']").val());
		formData.append("address",$("[name='address']").val());
		//formData.append("uploadphoto",$("[name='photo']").get(0).files[0]);
		$.ajax({
			asyn: false,
			url: "UserInfo/modify/userId.mvc",
	        type: "POST",
	        data : formData, 
		    processData : false, 
		    contentType : false,
	        success: function(data){
	        	console.log(data);
	        	layer.open({
	                type: 1,
	                content: '<div style="padding: 20px 100px;">信息更改成功<br/>请重新登陆</div>',
	                btn: '确定',
	                btnAlign: 'c', //按钮居中
	                shade: 0,//不显示遮罩
	                yes: function(){
	                	window.sessionStorage.removeItem('userData');
	    	        	location.reload();
	    	        	event.preventDefault();
	                }
	              });
	        }
	    });
		
	});
});
		
