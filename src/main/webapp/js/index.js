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

//导航栏的模块
layui.use('element', function(){
  var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
  
  //监听导航点击
  element.on('nav(demo)', function(elem){
    //console.log(elem)
    layer.msg(elem.text());
  });
});

//轮播图模块
layui.use('carousel', function(){
	  var carousel = layui.carousel;
	  //建造实例
	  carousel.render({
	    elem: '#test1',
	    width: '100%', //设置容器宽度
	    arrow: 'always', //始终显示箭头
	    //anim: 'fade',//切换动画方式
	    interval: 2000,	//切换时间
	    height: '550px'
	  });
});



