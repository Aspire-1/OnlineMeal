var valueList;
$(function(){
	$.ajax({
		async: false,
		type: 'get',
		url: 'MarchantInfo/get/all.mvc',
		data:{
			
		},
		success: function(data){
			valueList = data;
			console.log(valueList);
			for(var i = 0;i<valueList.length;i++){
				productBox(valueList[i]);
			}
		}
	});
	//bianli(valueList);
	clickTypeBtn();
	clickSearchBtn();
});


layui.use(['layer','element'],function(){
	
	$("#contain").on("click",".marchant-info-list .marchant-info-elem",function(event){
		var marchantId= $(this).closest(".marchant-info-elem").find("#marchantId").val();
		var marchantName= $(this).closest(".marchant-info-elem").find("#marchantName").html();
		var marchantRecord = {
				'marchantId':marchantId,
				'marchantName':marchantName
		}
		window.sessionStorage.setItem("marchantRecord",JSON.stringify(marchantRecord));
		window.sessionStorage.setItem("marchantId",marchantId);
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
	
	var elemId = document.createElement("input");
	elemId.setAttribute("type","hidden");
	elemId.setAttribute("value",value.infoId);
	elemId.setAttribute("id","marchantId");
	
	var imgBlock = document.createElement("div");
	imgBlock.setAttribute("class","marchant-info-img");
	
	var img = document.createElement("img");
	img.setAttribute("alt",value.name);
	img.setAttribute("src",value.photoSrc);
	
	var marchantName = document.createElement("h2");
	marchantName.setAttribute("id","marchantName");
	marchantName.innerHTML = value.name;
	
	var descBlock = document.createElement("div");
	descBlock.setAttribute("class","marchant-info-desc");
	descBlock.innerHTML = value.note;
	
	imgBlock.appendChild(img);
	
	element.appendChild(elemId);
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
