var marchantId=window.sessionStorage.getItem("marchantId");
$(document).ready(function(){
	if(marchantId==null|| marchantId==undefined){
		window.location.href="loginMarchant.html";
	}
	$("div.layui-side div.layui-side-scroll li.layui-nav-item a").on("click",function(event){
		var href=$(this).attr("href");
		if(href!="#"){
			$("#contain").load(href,function(){
				
			});
		}
		event.preventDefault();
	});
	
	$("#logout").on("click",function logout(event){
		
		$.ajax({
			async: false,
			type:"POST",
			url:"/OnlineMeal/MarchantManager/logout.mvc",
			data:{
				"id":window.sessionStorage.getItem("managerId")
			},
			success:function(data){
				console.log(data)
			}
		});
		window.sessionStorage.removeItem('marchantId');
		window.sessionStorage.removeItem('managerId');

		location.reload();
		event.preventDefault();
	});
	
});

