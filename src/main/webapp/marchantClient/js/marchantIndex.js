$(document).ready(function(){
	$("div.layui-side div.layui-side-scroll li.layui-nav-item a").on("click",function(event){
		var href=$(this).attr("href");
		if(href!="#"){
			$("#contain").load(href,function(){
				
			});
		}
		event.preventDefault();
	});
	
});