/* 购物车部分 */

function addCart(gid){
	
	$.get("cartAdd.do",{"gid":gid},function(data){
		showMsg(data);
	});
	
}
/*function addCart(productId) {
	//判断剩余数目是否>0
	$.get("checkProductIfExists.do",{"productId":productId},function(data){
		if (data == "无货") {
			showMsg("<font color=yellow>抱歉，此商品目前缺货~</font>");
		} else {
			$.get("cartAdd.do",{"productId":productId},function(data){
				if(data == "加入购物车失败！") {
					showMsg(data);
				} else {
					showMsg(data);
				}
			});
		}
	});	
}*/
function initCart() {
    //alert("111111111");
	$.getJSON("showCart.do",function(data){
		if(data.length>0) {
			$("#cartTable").html("<tr align='center' valign='middle'><td height='27' class='tableBorder_B1'>编号</td><td class='tableBorder_B1'>商品名称</td><td class='tableBorder_B1'>市场价</td><td class='tableBorder_B1'>商城价</td><td class='tableBorder_B1'>折扣</td><td class='tableBorder_B1'>数量</td><td class='tableBorder_B1'>退回</td></tr>");
			var totalMarketprice = 0.0;
			var totalSaleprice = 0.0;
			for(var i = 0;i<data.length;i++){
				var id = data[i].id;
				var gName = data[i].gname;
				var marketPrice = data[i].marketPrice;
				var salPrice = data[i].salPrice;
				var amount = data[i].amount;
				var totalMprice = data[i].totalMprice;
				var totalSprice = data[i].totalSprice;
			
				totalMarketprice += parseFloat(totalMprice);
				totalSaleprice += parseFloat(totalSprice);
				//alert(totalMarketprice);
				//alert(totalSaleprice);
				$("#cartTable").append("<tr align='center' valign='middle'><td height='27'>"+(i+1)+"</td><td ><a href=\"goodsDetail.do?id="+id+"\">"+gName+"</a></td><td style='text-decoration:line-through;'>￥"+marketPrice+"</td><td style='color:#FF0000'>￥"+salPrice+"</td><td>"+Math.ceil((salPrice/marketPrice)*100)+"%</td><td ><input id="+id+" size='4' maxlength='4' type='text' class='txt_grey' value="+amount+" onchange='saveAmount("+id+")'></td><td><img id='deleteCartItemButton' onclick='deleteCart("+id+")' src='images/del.gif' width='16' height='16'></td></tr>");
			}
			$("#cartTable").append("<tr align='center' valign='middle'><td colspan=2 align='right'>总计</td><td style='text-decoration:line-through;'>￥"+totalMarketprice+"</td><td style='color:#FF0000'>￥"+totalSaleprice+"</td><td colspan=3><input type='button' class='button' value='更新数量'></td></tr>");
		} else {
			$("#emptyTable").empty();
			$("#cartTable").html("购物车中没有商品");
		}
	});
}
function deleteCart(goodsId) {
	
	$.get("deleteCart.do",{"goodsId":goodsId},function(data){
		showMsg(data);
		initCart();
	});
}

function saveAmount(goodsId) {
	//var number;
	$.getJSON("checkProductIfExists.do",{"goodsId":goodsId},function(data){
		if(data.length>0){
			for(var i=0;i<data.length;i++){
				 var number = data[i].number;
				
				 var amount = "#"+goodsId;
					
					var newAmount = $(amount).val();
				    
					if(isNaN(newAmount) == true){
						showMsg("必须是数字！！");
					} else if(parseInt(newAmount)>parseInt(number)){
						showMsg("<font color=red>抱歉，此商品目前数量不足，请重新输入</font>");
					}
					else
					 {
						$.get("saveAmount.do",{"goodsId":goodsId,"newAmount":newAmount},function(data){
							if(data == "修改成功") {
								showMsg(data);
								initCart();
							}
						});
					}	
			}
		}else{
			showMsg("<font color=red>抱歉，此商品目前缺货~</font>");
		}
	});
	
}
function clearCart() {
	//alert("8888888");
	$.get("clearCart.do",null,function(data){
		if(data.length>0) {
			showMsg(data);
			initCart();
		}
	});
}
/*订单提交部分*/
//修改收货地址
function modifyAddress() {
	var modifyAddressButtonValue = $("#modifyAddressButton").val();
	var addressItem = $(".addressItem");
	
	if (modifyAddressButtonValue == "修改") {
		$("#modifyAddressButton").val("保存");
		for ( var i = 0; i < addressItem.length; i++) {
			var item = addressItem.eq(i);
			var itemValue = item.html();
			item.html("<input class='addressNewItem' type='text' value='" + itemValue + "'>");
		}
	} else {
		$("#modifyAddressButton").val("修改");
		for ( var i = 0; i < addressItem.length; i++) {
			var item = addressItem.eq(i);
			var itemNewValue = item.children().val();
			item.html(itemNewValue);
		}
	}
}

//初始化checkout，设置checked属性
function initCart_checkout() {
	$("input[name=paymethod]").get(0).checked = true;
	$("input[name=recievemethod]").get(0).checked = true;
	$("input[name=timedemand]").get(0).checked = true;
}

//提交购物车生成订单
function submitCart() {
	
	var re = /^[0-9]+$/;
	if($("#modifyAddressButton").val() == "保存") {
		showMsg("<font color=red>你修改的送货地址还没保存，不能提交！</font>");
	} else {
		var addressItem = $(".addressItem");
		var recievename = addressItem.eq(0).html();
		var address = addressItem.eq(1).html();
		var postcode = addressItem.eq(2).html();
		var phone = addressItem.eq(3).html();
		var paymethod = $(":radio[name*='paymethod']:checked").val();
		//alert(paymethod);
		var recievemethod = $(":radio[name*='recievemethod']:checked").val();
		//alert(recievemethod);

		var timedemand = $(":radio[name*='timedemand']:checked").val();
		//alert(timedemand);
		var remark = $("#bz").val();
	
		$.get("submitCart.do",{"recievename":recievename,"address":address,"postcode":postcode,"phone":phone,"paymethod":paymethod,"recievemethod":recievemethod,"timedemand":timedemand,"remark":remark},function(data){
			alert("您确定要提交吗？");
			if(data == "订单提交成功") {
				clearCart();
				alert(data);					
				window.setTimeout(function(){window.location = "order.jsp"},1000);
			}else{
				showMsg(data);
			}
		});
	}
}
/*订单操作部分*/
//初始化订单列表
function initOrder() {
	$("#orderTable").html("你还没有订单");
	$.getJSON("showOrder.do",null,function(data){
		
		if(data.length>0) {
			$("#orderTable").html(
			"<tr align='center' >"+
          	"<td width='15%' height='30' class='tableBorder_B_dashed'>订单号</td>"+
          	"<td width='25%' class='tableBorder_B_dashed'>订单时间</td>"+
          	"<td width='15%' class='tableBorder_B_dashed'>收货人</td>"+
          	" <td width='35%' class='tableBorder_B_dashed'>订单商品</td>"+
          	"<td width='10%' class='tableBorder_B_dashed'>订单状态</td>"+
         "</tr>");
			
			
			for(var i = 0;i<data.length;i++){
				var orderid = data[i].orderid;
				var pdate = data[i].pdate;
				var recievename = data[i].recievename;
				var items = data[i].items;
				var status = data[i].status;
					if(status == 1){
						status = "<font color=red>新订单</font><input  type='button' class='btn_grey' value='取消此订单' onclick='deleteOrder(\""+orderid+"\")'>";
					}else{
						status = "已配送";
					}
				
				$("#orderTable").append(
						"<tr align='center' >"+
							"<td class='tableBorder_B_dashed'><a href='showOrderDetail.do?orderid="+orderid+"&items="+items+"&flag=normal'>"+orderid+"</a></td>"+
							"<td class='tableBorder_B_dashed'>"+pdate+"</td>"+
							"<td class='tableBorder_B_dashed'>"+recievename+"</td>"+
							"<td class='tableBorder_B_dashed'>"+
								items+
							"</td>"+
							"<td class='tableBorder_B_dashed'>"+status+"</td>"+
						"</tr>");
			}
			
		}
		
		if($("#orderTable").html() == "") {
			$("#orderTable").html("你还没有订单");
		}
		
	});
}
//删除订单
function deleteOrder(orderid) {
	$.get("deleteOrder.do",{"orderid":orderid},function(data){
		if(data == "订单删除成功"){
			showMsg(data);
			initOrder();
		}else{
			showMsg(data);
		}
	});
}

/*管理员部分*/

//初始化订单管理页面
function initOrderManage(status,nowpage) {
	$("#orderTable").html("无订单");
	
	//显示所有类型
	if(status == 0) {
	$.getJSON("../showAllOrders.do",{"nowpage":nowpage},function(data){
		
		if(data.length>0) {
			$("#orderTable").html(
			"<tr align='center' >"+
          	"<td width='15%' height='30' class='tableBorder_B_dashed'>订单号</td>"+
          	"<td width='25%' class='tableBorder_B_dashed'>订单时间</td>"+
          	"<td width='15%' class='tableBorder_B_dashed'>收货人</td>"+
          	" <td width='35%' class='tableBorder_B_dashed'>订单商品</td>"+
          	"<td width='10%' class='tableBorder_B_dashed'>订单状态</td>"+
         "</tr>");
			
			
			for(var i = 0;i<data.length;i++){
				var orderid = data[i].orderid;
				var pdate = data[i].pdate;
				var recievename = data[i].recievename;
				var items = data[i].items;
				var status = data[i].status;
					if(status == 1){
						status = "<font color=red>新订单</font>";
					}else{
						status = "已配送";
					}
				
				$("#orderTable").append(
						"<tr align='center' >"+
							"<td class='tableBorder_B_dashed'><a href='../manage/showManageOrderDetail.do?orderid="+orderid+"&flag=admin'>"+orderid+"</a></td>"+
							"<td class='tableBorder_B_dashed'>"+pdate+"</td>"+
							"<td class='tableBorder_B_dashed'>"+recievename+"</td>"+
							"<td class='tableBorder_B_dashed'>"+
								items+
							"</td>"+
							"<td class='tableBorder_B_dashed'>"+status+"</td>"+
						"</tr>");
			}
			
		}

		/*if($("#orderTable").html() == "") {
			$("#orderTable").html("你还没有订单");
		}*/
		
	});
	if($("#orderTable").html() == "Loading......") {
	$("#orderTable").html("你还没有订单");
}
	
	} 
	else{
	 //var status = $(this).val();
	 //   alert("status");
		//显示搜索的订单
		$.getJSON("../manage/searchOrder.do",{"status":status},function(data){
			
			if(data.length>0) {
				$("#orderTable").html(
				"<tr align='center' >"+
	            	"<td width='15%' height='30' class='tableBorder_B_dashed'>订单号</td>"+
	            	"<td width='25%' class='tableBorder_B_dashed'>订单时间</td>"+
	            	"<td width='15%' class='tableBorder_B_dashed'>收货人</td>"+
	            	" <td width='35%' class='tableBorder_B_dashed'>订单商品</td>"+
	            	"<td width='10%' class='tableBorder_B_dashed'>订单状态</td>"+
	           "</tr>");
				
				
				for(var i = 0;i<data.length;i++){
					var orderid = data[i].orderid;
					var pdate = data[i].pdate;
					var recievename = data[i].recievename;
					var items = data[i].items;
					var status = data[i].status;
						if(status == 1){
							status = "<font color=red>新订单</font>";
						}else{
							status = "已配送";
						}
					
					$("#orderTable").append(
							"<tr align='center' >"+
								"<td class='tableBorder_B_dashed'><a href='../showOrderDetail.do?orderid="+orderid+"&flag=admin'>"+orderid+"</a></td>"+
								"<td class='tableBorder_B_dashed'>"+pdate+"</td>"+
								"<td class='tableBorder_B_dashed'>"+recievename+"</td>"+
								"<td class='tableBorder_B_dashed'>"+
									items+
								"</td>"+
								"<td class='tableBorder_B_dashed'>"+status+"</td>"+
							"</tr>");
				}
				
			}
		
			/*if($("#orderTable").html() == "Loading......") {
				$("#orderTable").html("你还没有订单");
			}*/
			
		});
		if($("#orderTable").html() == "Loading......") {
		$("#orderTable").html("你还没有订单");
	}
	}
}



//关闭订单
function closeOrder(orderid) {
	$.get("deleteManageOrder.do",{"orderid":orderid},function(data){
		showMsg(data);
		if(data == "订单删除成功"){
			window.setTimeout(function(){window.location = "OrderManage.jsp"},1000);
		}
	});
}

function loadOrderManage(status,nowpage) {
	// 设置每页显示的数量
	//var singlePageCount = 5;
	// 显示第一页内容
	initOrderManage(status,nowpage);
	
	//加载所有类型的订单
	//if(status == 0) {
	// 配置翻页工具
	/*$.get("../getAllOrdersCount.do", function(data) {
		$('.pagination').jqPagination({
			current_page : 1,
			max_page : Math.ceil(data / singlePageCount),
			paged : function(page) {
				initOrderManage(status,page, singlePageCount);
			}
		});
	});
	} else {*/
		// 配置翻页工具
		/*$.get("../getSearchOrderCount.do", function(data) {
			$('.pagination').jqPagination({
				current_page : 1,
				max_page : Math.ceil(data / singlePageCount),
				paged : function(page) {
					initOrderManage(status,page, singlePageCount);
				}
			});
		});
	}*/
}

//发货
function sendoutOrder(orderid) {
	
	$.get("sendoutOrder.do",{"orderid":orderid},function(data){
		showMsg(data);
		if(data == "发货成功"){
			window.setTimeout(function(){window.location = "OrderManage.jsp"},1000);
		}
	});
}