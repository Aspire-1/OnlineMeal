layui.use('element', function(){
	var $ = layui.query;
	var element = layui.element;
	
	element.on('tab(DishedInfoTab)',function(data){
		
	});
	
});

function clickChoiceBtn(){
	
	var inputElem = $(this).parent().prev("input").val();
	
	if($(this).attr("name")=="add"){
		inputElem ++;
	}else if($(this).attr("name")=="sub"){
		if(inputElem != 0){
			inputElem --;
		}
	}else if($(this).attr("name")=="cart"){
		alert("加入购物车")
	}
	$(this).parent().prev("input").val(inputElem);
}

//动态加载元素的注册事件
$(".dished-info-list").on("click",".dished-info-choice .layui-btn-group button",clickChoiceBtn);

var valueList = [{
	"name":"菜肴1",
	"photo":"pic/img/foodlist2.jpg",
	"note":"喝茶读书，不争朝夕"
},{
	"name":"菜肴2",
	"photo":"pic/img/foodlist3.jpg",
	"note":"喝茶读书，不争朝夕"
},{
	"name":"菜肴3",
	"photo":"pic/img/foodlist4.jpg",
	"note":"喝茶读书，不争朝夕"
}];


function productDishedBox(value){
	
	var block = $(".dished-info-list");
	var element = document.createElement("div");
	element.setAttribute("class","dished-info-elem");
	
	var imgBlock = document.createElement("div");
	imgBlock.setAttribute("class","dished-info-img");
	
	var img = document.createElement("img");
	img.setAttribute("alt",value.name);
	img.setAttribute("src",value.photo);
	
	var wordBlock = document.createElement("div");
	wordBlock.setAttribute("class","dished-info-word");
	
	var dishedName = document.createElement("h2");
	dishedName.innerHTML = value.name;
	
	var descBlock = document.createElement("div");
	descBlock.setAttribute("class","dished-info-desc");
	descBlock.innerHTML = value.note;
	
	var choiceBlock = document.createElement("div");
	choiceBlock.setAttribute("class","dished-info-choice");
	choiceBlock.innerHTML = document.getElementById("dishedInfoChoice").innerText;
	
	imgBlock.appendChild(img);
	
	wordBlock.appendChild(dishedName);
	wordBlock.appendChild(descBlock);
	wordBlock.appendChild(choiceBlock);
	
	element.appendChild(imgBlock);
	element.appendChild(wordBlock);
	
	block.append(element);
}


