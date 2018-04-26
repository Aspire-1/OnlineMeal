
layui.use(['table','layer','carousel','element'], function(){
	//轮播图模块
	var carousel = layui.carousel;
	//导航栏的模块
	var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
	
	$(document).ready(function(){
		$("ul.layui-layout-left li.layui-nav-item a").on("click",function(event){
			var href=$(this).attr("href");
			if(href!="#" && $(this).text()!="首页"){
				$("#contain").load(href,function(){
					
				});
				event.preventDefault();
			}else{
			}
		});
	});

	//监听导航点击
	element.on('nav(demo)', function(elem){
		layer.msg(elem.text());
	});
	
	//建造实例
	carousel.render({
		elem: '#test1',
		width: '100%', //设置容器宽度
		arrow: 'always', //始终显示箭头
		interval: 2000,	//切换时间
		height: '550px'
	});	
 
});



