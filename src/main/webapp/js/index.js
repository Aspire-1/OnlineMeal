
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
		if(window.sessionStorage.getItem('userData')!=null){
			$("#nav_userName").html(JSON.parse(window.sessionStorage.getItem('userData'))["local_userName"]);
			$("#nav_userHead").append('<dl class="layui-nav-child"><dd><a href="#">基本资料</a></dd><dd><a href="#" id="logoutBtn">退出</a></dd></dl>');
		}
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

$("#nav_userHead").on('click',"#logoutBtn",function(event){
	logout(event);
});
$("#loginBtn").on('click',function(event){
	if(window.sessionStorage.getItem('userData')==null){
		clickLogin(event);
	}
});

function clickLogin(event){
	var index = layer.open({
		type: 2,
		title: false,
		closeBtn: 0,
		area: ['400px', '340px'],
		shade: 0.8,
		id: 'LAY_layuipro', //设定一个id，防止重复弹出
		btn: ['登陆', '取消'],
		btnAlign: 'c',
		moveType: 1 ,//拖拽模式，0或者1
		content: 'login.html',
		resize: false,
		move: false,
		yes: function(index,layero){
			var iframeWin = window[layero.find('iframe')[0]['name']];
			if(true===iframeWin.loginBtn()){
				layer.close(index);
				if(window.sessionStorage.getItem('userData')!=null){
					$("#nav_userName").html(JSON.parse(window.sessionStorage.getItem('userData'))["local_userName"]);
					$("#nav_userHead").append('<dl class="layui-nav-child"><dd><a href="">基本资料</a></dd><dd><a href="#" id="logoutBtn">退出</a></dd></dl>');
				}
			}
		},
	});
	event.preventDefault();
}

function logout(event){
	window.sessionStorage.removeItem('userData');
	location.reload();
	event.preventDefault();
}


