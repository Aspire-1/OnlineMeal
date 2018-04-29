//发起请求
layui.use(['layer','element'],function(){
	
	$("#contain").on("click",".marchant-info-list .marchant-info-elem",function(event){
		if(window.sessionStorage.getItem("userData")==null){
			showLogin();
		}else{
			$("#contain").load("marchant/marchant1.html",function(){
			});
		}
	});

	$(function(){
		//测试数据
		var valueList = [{
			"name":"商家1",
			"photo":"pic/img/foodlist2.jpg",
			"note":"喝茶读书，不争朝夕"
		},{
			"name":"商家2",
			"photo":"pic/img/foodlist3.jpg",
			"note":"喝茶读书，不争朝夕"
		},{
			"name":"商家3",
			"photo":"pic/img/foodlist4.jpg",
			"note":"喝茶读书，不争朝夕"
		}];
	
		//生成格子
		function productBox(value){
			
			var block = $(".marchant-info-list");
			var element = document.createElement("div");
			element.setAttribute("class","marchant-info-elem");
			
			var imgBlock = document.createElement("div");
			imgBlock.setAttribute("class","marchant-info-img");
			
			var img = document.createElement("img");
			img.setAttribute("alt",value.name);
			img.setAttribute("src",value.photo);
			
			var marchantName = document.createElement("h2");
			marchantName.innerHTML = value.name;
			
			var descBlock = document.createElement("div");
			descBlock.setAttribute("class","marchant-info-desc");
			descBlock.innerHTML = value.note;
			
			imgBlock.appendChild(img);
			
			element.appendChild(imgBlock);
			element.appendChild(marchantName);
			element.appendChild(descBlock);
			
			block.append(element);
		}
	
		//显示函数
		function bianli(valueList){
			for(var x=0;x<20;x++){
				productBox(valueList[x%3]);
			}
		}
		
		bianli(valueList);
	});

	function showLogin(){
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
					$("#contain").load("marchant/marchant1.html",function(){
						if(window.sessionStorage.getItem('userData')!=null){
							$("#nav_userName").html(JSON.parse(window.sessionStorage.getItem('userData'))["local_userName"]);
							$("#nav_userHead").append('<dl class="layui-nav-child"><dd><a href="#">基本资料</a></dd><dd><a href="#" id="logoutBtn">退出</a></dd></dl>');
						}
					});
				}
			},
		})
	}
});
