//发起请求

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

function test(){
	alert("llll");
}

