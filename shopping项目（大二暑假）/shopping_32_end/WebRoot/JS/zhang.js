//添加进收藏夹
function addFavorite(gid) {

	$.get("addFavorite.do", {
		"gid" : gid
	}, function(data) {

		showMsg(data);
	});
}

$(document).ready(function() {
	sort();
	publish();
	showBigSearchCategory();
	showSearchCategory(1);
	$(".textarea").change(showSearchCategory);
});
// 显示销售排行
function sort() {
	var objTable = $("#table");
	$.getJSON("sellSort.do", null, function(data) {
		for ( var n = 0; n < data.length; n++) {
			var objTr = $("<tr>");
			var objTd = $("<td height=\"20\" class=\"tableBorder_B_dashed\">");
			var objhr = $("<hr>");
			var newName = "<a href=\"goodsDetail.do?id=" + data[n]["id"]
					+ "\">" + data[n]["gname"] + "</a>";
			objTd.html(newName);
			objTr.append(objTd);
			objTable.append(objTr);
		}
	});
}
// 显示公告
function publish() {
	var objTable = $("#publishTable");
	$.getJSON("showIndexPublishInfo.do", null, function(data) {
		for ( var n = 0; n < data.length; n++) {
			var ObjTr = $("<tr>");
			var ObjTd = $("<td height=\"24\" class=\"tableBorder_T_dashed\">");
			var newTitle = "<a href=\"showPublishDetail.do?id=" + data[n]["id"]
					+ "\">" + data[n]["title"].split(",")[0] + "</a>";
			ObjTd.html(newTitle);
			ObjTr.append(ObjTd);
			objTable.append(ObjTr);
		}
	});
}

// 显示前台搜索框的大类
function showBigSearchCategory() {
	var ObjSelect = $(".textarea");
	$.getJSON("searchCategory.do", null, function(data) {
		for ( var i = 1; i < data.length; i++) {
			var ObjOption = $("<option value=" + data[i]["id"] + ">");
			ObjOption.html(data[i]["name"]);
			ObjSelect.append(ObjOption);
		}
	});
}
// 显示后台的搜索框

function showSearchCategory(pid) {
	var ObjSelect = $(".textarea");
	if (pid != 1) {
		pid = ObjSelect.val();
		ObjSelect = $(".ctextarea");
		$(".ctextarea").empty();
	}
	$.getJSON("manageSearchCategory.do?pid=" + pid, null, function(data) {
		for ( var i = 0; i < data.length; i++) {
			var ObjOption = $("<option value=" + data[i]["id"] + ">");
			ObjOption.html(data[i]["name"]);
			ObjSelect.append(ObjOption);
			if (pid == 1) {
				$(".ctextarea").empty();
			}
		}
	});
}

// 自动生成后台添加商品页面的折扣率
function autoGetSalCount() {
	var objMarketPrice = $("#marketPrice").val();
	var objSalPrice = $("#salPrice").val();
	var objSalCount = $("#salCount");
	var salCount = objSalPrice / objMarketPrice;
	salCount = salCount.toString().substring(0, 5);
	objSalCount.val(salCount);
}

// 弹出后台商品页面的修改数量框
var inputObj;
var nowObj;
var gid ;
$(document).ready(function() {
	$(".goodsNum").click(changeCount);
});

function changeCount() {
	nowObj = $(this);
//	alert($(".gid").val());
	var oldValue = $(this).html();
	$(this).empty();
	inputObj = $("<input>");// 创建一个input输入框
	inputObj.val(oldValue);
	$(this).append(inputObj);
	inputObj.focus();
	$(this).unbind("click");
	inputObj.keypress(a);
}
function a(event) {
	if (event.keyCode == 13) {
		var newValue = inputObj.val();
		nowObj.empty();
		nowObj.html(newValue);
		$(".goodsNum").bind("click", changeCount);// 从新绑定click事件的changeCount函数
	}
}

// 添加商品数量
function addGoodsNum(id, count) {
	$.get("addGoodsNum.do", {
		gid : id,
		num : count
	}, function(data) {
		alert(data);
		window.setTimeout(function() {
			window.location.reload();
		}, 500);
	});
}

// 返回顶部
$(document)
		.ready(
				function() {
					var main_left = Math.round($(".main").offset().left + 1170)
							+ "px";
					var back_top_sty = {
						bottom : "100px",
						left : main_left,
						position : "fixed",
						display : "none",
						background : "blue",
						text : "���ض���"
					};
					$("body")
							.append(
									"<a href='javascript:;' id='back_top' title='Top'><img src='./images/toTop.gif' style='height:31px;height:31px'></a>");
					$("#back_top").css(back_top_sty);
					$(window).scroll(
							function() {
								if ($(window).scrollTop() > 100) {
									if ($.browser.msie
											&& ($.browser.version == "6.0")
											&& !$.support.style) {
										$("#back_top").css(
												{
													display : "block",
													position : "absolute",
													top : $(window).scrollTop()
															+ 450 + "px"
												});
									} else {
										$("#back_top").css({
											display : "block",
											position : "fixed"
										});
									}
								} else {
									$("#back_top").hide();
								}
							});
					$(window)
							.resize(
									function() {
										if ($(window).width() <= 1000) {
											main_left = $(window).width() - 20
													+ "px";
										} else {
											main_left = Math.round($(".main")
													.offset().left + 980)
													+ "px";
										}
										$("#back_top").css("left", main_left);
									});
					$("#back_top").click(function() {
						$("html, body").animate({
							scrollTop : 0
						}, 200);
						return false;
					});

				});
