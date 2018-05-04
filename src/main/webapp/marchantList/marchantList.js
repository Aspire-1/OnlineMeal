//存储数据的全局变量
var valueList;

//测试数据
valueList = [{
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

$(function(){
	bianli(valueList);
	clickTypeBtn();
	clickSearchBtn();
});


layui.use(['layer','element'],function(){
	
	$("#contain").on("click",".marchant-info-list .marchant-info-elem",function(event){
		if(window.sessionStorage.getItem("userData")==null){
			showLogin();
		}else{
			$("#contain").load("marchant/marchant1.html",function(){
			});
		}
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
	for(var x=0;x<valueList.length;x++){
		productBox(valueList[x]);
	}
}

//点击类型按钮
function clickTypeBtn(){
	var btns =  document.querySelectorAll(".marchant-select-box .marchant-select .layui-anim-fadein");
	for(var i = 0;i<btns.length;i++){
		btns[i].addEventListener("click",function(event){
			var target = event.toElement;
			$.ajax({
				async: false,
				type: 'POST',
				url: 'MarchantInfo/get/type.mvc',
				data:{
					"type":target.innerText
				},
				success: function(data){
					valueList = data;
					console.log(valueList.length);
				}
			});
			if(valueList.length != 0){
				$(".marchant-info-list").html("");
				bianli(valueList);
			}else if(valueList.length == 0){
				$(".marchant-info-list").html('<h2>暂无此类型商家</h2>');
			}
			
		});
	}
}

//搜索按钮
function clickSearchBtn(){
	$("#searchName_btn").on('click',function(){
		$.ajax({
			async: false,
			type: 'POST',
			url: 'MarchantInfo/get/vagueName.mvc',
			data:{
				"name":$("#seachName_input").val()
			},
			success: function(data){
				valueList = data;
				console.log(valueList.length);
			}
		});
		if(valueList.length != 0){
			$(".marchant-info-list").html("");
			bianli(valueList);
		}else if(valueList.length == 0){
			$(".marchant-info-list").html('<h2>无查找到商家</h2>');
		}
	});
}
