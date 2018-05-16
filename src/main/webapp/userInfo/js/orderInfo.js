$(function(){
	var user = window.sessionStorage.getItem('userData');
	$('#userBar').tmpl(JSON.parse(user)).appendTo(".user-bar");
	
	var userOrder;
	$.ajax({
		async: false,
		type: 'POST',
		url: 'UserOrderInfo/getAll/user.mvc',
		data:{
			"userId":JSON.parse(user).local_id
		},
		success: function(data){
			console.log(data);
			userOrder = data;
		}
	});
	
	$('#timeLineTemp').tmpl(userOrder).appendTo("#orderRow");
	
	layui.use(['table','layer','carousel','element'], function(){
		$("#orderRow").on('click','[name=detail]',function(){
			
			var orderRecord= $(this).closest(".layui-timeline").find("[name=orderId]").val();
			
			$.ajax({
				async: false,
				type: 'POST',
				url: 'UserOrderInfo/get/detail.mvc',
				data:{
					"id":orderRecord
				},
				success: function(data){
					console.log(data);
					userOrder = data;
					var index = layer.open({
						type: 1,
						title: '订单编号: ' + data.code + '  下单时间：' + data.createTime , //不显示标题栏
						closeBtn: false,
						area: ['800px', '500px'],
						id: 'LAY_layuipro', //设定一个id，防止重复弹出
						
						btnAlign: 'c',
						moveType: 1 ,//拖拽模式，0或者1
						shade:0,
						content: $('#formContain'),
						scrollbar: true,
						resize:false,
						closeBtn: true,
						success:function(){
							$("[name='username']").val(data.username);
							$("[name='marchantName']").val(data.marchantName);
							$("[name='userphone']").val(data.userphone);
							$("[name='isToRestaurant']").val(data.isToRestaurant);
							$("[name='sendAddress']").val(data.sendAddress);
							$("#orderContains").html('');
							for(var x=0;x<data.orderContents.length;x++){
								$("#orderContains").append('<div class="layui-row"><div class="layui-col-md4">'+data.orderContents[x].dishedName+'</div><div class="layui-col-md4">'+data.orderContents[x].dishedCount+'</div><div class="layui-col-md4">￥'+data.orderContents[x].dishedPrice+'</div></div>');
							}
						}
					});
					
				}
			});
			
		});
		
		
		$("#orderRow").on('click','#delete',function(){
			
			var orderRecord= $(this).closest(".layui-timeline").find("[name=orderId]").val();
			
			alert(orderRecord);
			var index = layer.open({
                type: 1,
                content: '<div style="padding: 20px 100px;">是否取消该订单</div>',
                btn: ['确定','取消'],
                btnAlign: 'c', //按钮居中
                shade: 0,//不显示遮罩
                yes: function(){
                	$.ajax({
        				async: false,
        				type: 'POST',
        				url: 'UserOrderInfo/delete.mvc',
        				data:{
        					"id":orderRecord
        				},
        				success: function(data){
        					
        				}
        			});
                	layer.close(index);
                }
              });
			
			
		});
		
	});
	
})
