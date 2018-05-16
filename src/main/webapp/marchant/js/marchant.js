layui.use('element', function(){
	var $ = layui.query;
	var element = layui.element;
	
	element.on('tab(DishedInfoTab)',function(data){
		
	});
	
});
var marchant;
$(function(){
	window.sessionStorage.removeItem('cartData');
	cartData=[];
	cartAllPrice = 0;
	$.ajax({
		async: false,
		type: 'POST',
		url: 'MarchantInfo/get.mvc',
		data:{
			"id":window.sessionStorage.getItem("marchantId")
		},
		success: function(data){
			console.log(data);
			marchant = data;
		}
	});

	$('#marchantBar').tmpl(marchant).appendTo(".marchant-bar");
	console.log("marchantId"+window.sessionStorage.getItem("marchantId"));
	$.ajax({
		async: false,
		type: 'POST',
		url: 'DishedInfo/get.mvc',
		data:{
			"marchantId":window.sessionStorage.getItem("marchantId")
		},
		success: function(data){
			valueList = data;
			console.log(valueList);
			for(var i = 0;i<valueList.length;i++){
				productDishedBox(valueList[i]);
			}
		}
	});
});
var cartData=[];
var cartAllPrice = 0;
function clickChoiceBtn(){
	
	var inputElem = $(this).parent().prev("input").val();
	
	if($(this).attr("name")=="add"){
		inputElem ++;
	}else if($(this).attr("name")=="sub"){
		if(inputElem != 1){
			inputElem --;
		}
	}else if($(this).attr("name")=="cart"){
		var elem = $(this).closest(".dished-info-elem");
		var record = {
			'dished_id':elem.find("#infoId").val(),
			'dished_name':elem.find("#dishedName").html(),
			'dished_count':elem.find("#count").val(),
			'dished_price':elem.find("#price").val()
		};
		var exitCart = JSON.parse(window.sessionStorage.getItem("cartData"));
		if(exitCart != null || exitCart!=undefined){
			for(var x =0;x<exitCart.length;x++){
				if(record.dished_id==exitCart[x].dished_id){
					exitCart[x].dished_count = parseInt(exitCart[x].dished_count)+ parseInt(record.dished_count) +"";
					//record.dished_count = exitCart[x].dished_count;
					for(var i = 0;i<cartData.length;i++){
						if(cartData[i].dished_id == record.dished_id){
							cartData[i].dished_count = exitCart[x].dished_count;
							break;
						}
					}
					console.log("exitCart: ");
					console.log(exitCart);
					window.sessionStorage.setItem("cartData",JSON.stringify(exitCart));
					console.log("cartData: ");
					console.log(cartData);
					break;
				}else if(record.dished_id!=exitCart[x].dished_id && x == exitCart.length-1){
					cartData.push(record);
					console.log("cartData: ");
					console.log(cartData);
					window.sessionStorage.setItem("cartData",JSON.stringify(cartData));
				}
			}
		}else{
			cartData.push(record);
			console.log("cartData: ");
			console.log(cartData);
			window.sessionStorage.setItem("cartData",JSON.stringify(cartData));
		}
		showCartData();
		cartAllPrice= cartAllPrice + elem.find("#price").val()*elem.find("#count").val();
		$("#allPrice").html(cartAllPrice);
	
	}
	$(this).parent().prev("input").val(inputElem);
}

function showCartData(){
	var showCartData = JSON.parse(window.sessionStorage.getItem("cartData"));
	//console.log("showCartData: "+showCartData);
	if(showCartData != null || showCartData!=undefined){
		for(var i = 0;i<showCartData.length;i++){
			if(i == 0){
				$("#record").html('<tr><td colspan="3"><span><a id="clear">[清空]</a></span></td></tr>');
				$("#record").append("<tr><td>"+showCartData[i].dished_name+"</td><td>"+showCartData[i].dished_count+"</td><td name='recordPrice'>￥"+showCartData[i].dished_count*showCartData[i].dished_price+"</td></tr>");
			}else{
				$("#record").append("<tr><td>"+showCartData[i].dished_name+"</td><td>"+showCartData[i].dished_count+"</td><td name='recordPrice'>￥"+showCartData[i].dished_count*showCartData[i].dished_price+"</td></tr>");
			}
		}
	}
}

//动态加载元素的注册事件
$(".dished-info-list").on("click",".dished-info-choice .layui-btn-group button",clickChoiceBtn);

var valueList = [];


function productDishedBox(value){
	
	var block = $(".dished-info-list");
	var element = document.createElement("div");
	element.setAttribute("class","dished-info-elem");
	
	var idInput = document.createElement("input");
	idInput.setAttribute("type","hidden");
	idInput.setAttribute("value",value.infoId);
	idInput.setAttribute("id","infoId");
	
	var imgBlock = document.createElement("div");
	imgBlock.setAttribute("class","dished-info-img");
	
	var img = document.createElement("img");
	img.setAttribute("alt",value.name);
	img.setAttribute("src","./"+value.photoSrc);
	
	var wordBlock = document.createElement("div");
	wordBlock.setAttribute("class","dished-info-word");
	
	var dishedName = document.createElement("h2");
	dishedName.innerHTML = value.name;
	dishedName.setAttribute("id","dishedName");
	
	var descBlock = document.createElement("div");
	descBlock.setAttribute("class","dished-info-desc");
	descBlock.innerHTML = value.introduce;
	
	var choiceBlock = document.createElement("div");
	choiceBlock.setAttribute("class","dished-info-choice");

	imgBlock.appendChild(img);
	
	wordBlock.appendChild(dishedName);
	wordBlock.appendChild(descBlock);
	$('#dishedInfoChoice').tmpl(value).appendTo(wordBlock);
	
	element.appendChild(imgBlock);
	element.appendChild(wordBlock);
	element.appendChild(idInput);
	
	block.append(element);
}
var cartflag = true;
//点击购物车按钮
$(".shopCartArea .layui-btn-group [name=shopCart]").on("click",function(){
	var flag = "none";
	if(cartflag == true){
		flag = "";
	}else{
		flag = "none"
	}
	$('.layui-table').css("display",flag);
	cartflag = !cartflag;
});

$(".shopCartArea .layui-btn-group [name=placeOrder]").on("click",function(){
	//结账
	$("#contain").load("placeOrder/userOrder.html",function(){
		
	})
	
});


$('.cartContain').on("click",'#clear',function(event){
	$("#record").html('<tr><td colspan="3"><span><a id="clear">[清空]</a></span></td></tr>');
	$("#allPrice").html(0);
	window.sessionStorage.removeItem('cartData');
	cartData=[];
	cartAllPrice = 0;
	event.preventDefault();
});

              


