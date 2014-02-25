<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="include_import.jsp"%>
<html>
<head>
<title>奋斗电子商城</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="CSS/style.css" rel="stylesheet">
<link href="CSS/css3buttons.css" rel="stylesheet">
<link href="CSS/showDialog.css" rel="stylesheet">
<script language='JavaScript' src='JS/jquery.js'></script>
<script language='JavaScript' src='JS/menutree.js'></script>
<script language='JavaScript' src='JS/zhang.js'></script>
<script language='JavaScript' src='JS/song.js'></script>
<script language='JavaScript' src='JS/liyixiang.js'></script>
<script language='JavaScript' src='JS/jQuery-jcContact.js'></script>
<script language='JavaScript' src='JS/jquery.imageLens.js'></script>
<script language='JavaScript' src='JS/main.js'></script>
<script language='JavaScript' src='JS/showDialog.js'></script>
</head>
<body onload="initOrder()">
<table width="790"  border="0" cellspacing="0" cellpadding="0" align="center">
 <tr>
 <td class="tableBorder">
<!--导航条-->
<table width="790" height="115"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td bgcolor="#CCCCCC" height="6px"></td>
      </tr>
    </table>
      <table width="100%" height="109"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="25%"><img src="images/shop_02.gif" width="275" height="109"></td>
          <td width="75%"><table width="100%" height="109"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="52" align="right" valign="top"><table width="100%" height="31"  border="0" cellpadding="0" cellspacing="0">
                <tr align="center">
                  <td width="7" valign="top"><img src="images/cpro_float_smallLightgrey[1].jpg" width="22" height="28"></td>
                  <td width="80"><a href="manage/login.jsp">后台管理</a></td>
                  <td width="7" valign="top"><img src="images/T_contact.gif" width="42" height="28"></td>
                  <td width="72"><a href="javascript:mail();">发送邮件</a></td>
                  <td width="10" valign="top"><img src="images/T_favorite.gif" width="42" height="28"></td>
                  <td width="68"><a href="javascript:window.external.AddFavorite('www.fendoujiaoyu.com','奋斗教育')">收藏本站</a></td>
                  <td width="10" valign="top"><img src="images/T_home.gif" width="42" height="28"></td>
                  <td width="70"><a href="#" onclick="this.style.behavior='url(#default#homepage)';this.sethomepage('http://www.fendoujiaoyu.com')">设为首页</a></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="57" valign="top" background="images/shop_07.gif"><table width="100%" height="53"  border="0" cellpadding="0" cellspacing="0">
                <tr align="center">
                  <td width="9%"><a href="index.jsp">首页<br>
                    Index</a></td>
                  <td width="2%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="15%"><a href="NewGoods.jsp">新品上架<br>
                    NewGoods</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="14%"><a href="sale.jsp">特价商品<br>
                    At a sale</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="14%"><a href="member.jsp">会员资料修改<br>
                    Member</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="10%"><a href="cart_see.jsp">购物车<br>
                    Cart</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="15%"><a href="order.jsp">查看订单<br>
                    Order</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="11%"><a href="SellSort.jsp">销售排行<br>
                    SellSort</a></td>
                  <td width="2%">&nbsp;</td>
                </tr>
              </table></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
<!--导航条结束-->
<table width="790" height="236"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="182" height="182" valign="top">
	<!--左侧框架-->
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="83" align="center"><img src="images/shop_11.gif" width="182" height="83"></td>
      </tr>
      <tr>
        <td height="98" align="center" background="images/shop_17.gif">		 
         <form name="login" method="post" action="">
		  <table width="100%"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="10%">&nbsp;</td>
              <td width="90%" valign="top" background="Images/index_09.gif">
			<c:if test="${empty user}">
			
			  <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="24">会员名
                    <input name="username" type="text" class="txt_grey" id="username" size="16"></td>
                  <td>&nbsp;</td>
                </tr>
              
                <tr>
                  <td height="24">密&nbsp;&nbsp;&nbsp;码<br>
                    <input name="pwd" type="password" class="txt_grey" id="pwd" size="16" onKeydown="if(event.keyCode==13) form1.submit();"></td>
                  <td>&nbsp;</td>
                </tr>
                 
                <tr>
                  <td height="31">       
                   <input type="button" class="primary button" value="注册" onClick="window.location.href='register.jsp'">                
                    <input type="button" class="positive button" value="登录" onclick="userLogin()"> 
                     <input type="reset" class="negative button" value="重置">                   
                  </td>
                  <td>&nbsp;</td>
                </tr>
              </table>
             </c:if>
			<c:if test="${not empty user}">
                <table width="100%"  border="0" cellpadding="0" cellspacing="0" >
                  <tr>
                    <td width="94%" height="31" align="center" class="word_white">[${sessionScope.user.getUsername() } ]您好!<br>
                      <font color="red">您现在可以购物了!</font></td>
                    <td width="6%">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="24" align="center"><input type="button" class="primary button" value="修改资料" onClick="window.location.href='member.jsp';"></td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="24" align="center"><input type="button" class="positive button" value="我的收藏夹" onClick="window.location.href='favorite.do?uid=${sessionScope.user.getId()}'"></td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="24" align="center">
                     <input type="button" class="negative button" value="退出登录" onClick="outlogin();"></td>
                    <td>&nbsp;</td>
                  </tr>
                </table>
		   </c:if>
				</td>
            </tr>
          </table>
		  </form></td>
      </tr>
    </table>
      <table width="100%" height="155"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><img src="images/shop_22.gif" width="182" height="58"></td>
        </tr>
        <tr>
          <td height="97" align="center" valign="top" class="tableBorder_l"><table width="88%"  border="0" cellspacing="0" cellpadding="0">
           <table id="publishTable" width="88%"  border="0" cellspacing="0" cellpadding="0">
          </table>
          </td>
        </tr>
      </table>
      <table width="100%" height="151"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="40" background="images/shop_33.gif">&nbsp;</td>
        </tr>
        <tr>
          <td align="center" valign="top" class="tableBorder_lb">
          <table id="table" width="88%"  border="0" cellspacing="0" cellpadding="0">
           

          </table>
            <table width="100%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td>&nbsp;</td>
              </tr>
            </table></td>
        </tr>
      </table>
	
	<!--左侧框架结束-->
	</td>
    <td valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="33" background="images/shop_12.gif"></td>
        <td width="505" height="33" align="right" valign="middle" background="images/shop_12.gif"><table width="100%" height="24"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="8"></td>
          </tr>
          <tr>
             <td align="right" class="word_green">
            <c:if test="${empty user}">
			<marquee direction="left" scrollamount="1" scrolldelay="1" onMouseOver="this.stop();" onMouseOut="this.start();">
			购买商品请先登录 <a href="register.jsp" class="word_green">[新用户注册]</a>
			</marquee>
			</c:if>
			<c:if test="${not empty user}">
			 ${sessionScope.user.getUsername() }欢迎您!(如果您购物结束，<a href="javascript:outlogin();"><font color="red">请点击这里退出登录</font></a>) -->
			</c:if>
          </tr>
        </table></td>
        <td width="10" background="images/shop_12.gif">&nbsp;</td>
      </tr>
      <tr>
        <td width="93" height="50" background="images/shop_15.gif">&nbsp;</td>
        <td colspan="2" background="images/shop_16.gif">
		    
		</td>
      </tr>
    </table>
      <table width="100%"  border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="189" valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="80" background="images/center_order.gif">&nbsp;</td>
              </tr>
            <tr valign="top">
              <td height="134" align="center">
                 <table id="orderTable" width="94%"  border="0" cellpadding="3" cellspacing="3">
                 	
                  </table>
                 </td>
            </tr>
            <tr>
              <td height="38" align="right" background="images/center02.gif"></td>
            </tr>
          </table></td>
          </tr>
      </table></td>
  </tr>
</table>
<table width="790"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>
    <!--版权信息-->
	<table width="100%" height="78"  border="0" align="center" cellpadding="-2" cellspacing="-2">
      <tr>
        <td height="13" colspan="5"></td>
      </tr>
      <tr>
        <td width="124" height="13">&nbsp;</td>
        <td height="13" colspan="3" align="center">奋斗子商城客户服务热线：0791-3881060，3881061 传真：0791-3881063</td>
        <td width="141">&nbsp;</td>
      </tr>
      <tr>
        <td height="15" colspan="2">&nbsp;</td>
        <td width="464" valign="bottom" align="center"> CopyRight &copy; 2009 www.fendoujiaoyu.com 奋斗教育</td>
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="2">&nbsp;</td>
        <td align="center">本站请使用IE6.0或以上版本 1024*768为最佳显示效果</td>
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr bgcolor="#cccccc">
        <td height="8" colspan="2"></td>
        <td height="8" align="center"></td>
        <td height="8" colspan="2"></td>
      </tr>
    </table>
	
	<!--版权信息结束-->
    </td>
  </tr>
</table>
</td>
</tr>
</table>
<table width="100%" height="119"  border="0" cellpadding="0" cellspacing="0">           
                
                <div id="fad"><img src="images/goods/fdg0050.jpg" width="200" height="450">  </div>           
                          
            </table>
            <div id="demo2" class="jcContact">
     <div class="jcConraper">
         <!-- 自定义部分 -->
         <div style=" background:url(images/c02.png) no-repeat 0 0; height:44px;"></div>
         <ul>
             <li style="font-size:20px; text-align:center; font-weight:bold; color:#ff6600; padding:15px 0 5px;">0791-3881060</li>
             <li style="background:url(images/c04.png) no-repeat center 0; height:140px;"></li>
         </ul>
         <div style="background:url(images/c05.png) no-repeat 0 0; height:11px;"></div>
         <div style="line-height:22px; padding:5px 18px 25px;">
             <span style="display:block; float:left; height:22px; line-height:22px; font-size:13px; font-weight:bold; color:#555555;">admin</span>
             <a href="tencent://message/?uin=1741498" style="display:block; float:right; width:74px; height:22px; background:red; "><img src="images/c06.png" height="22" width="74" border="0" /></a>
             <div class="clear"></div>
         </div>
         <div style="background:url(images/c07.png) no-repeat; height:13px;"></div>
         <!-- 自定义部分 结束 -->
     </div>
	 <div class="jcConBtn"></div>
</div>
<script>
$(function(){
    $('#demo1').jcContact();
	
	$('#demo2').jcContact({
		speed:700,
		position:'top',
		posOffsetY : 50,
		btnPosition : 'top',
		btnPosoffsetY : 44 ,
		float:'right',
		Event : "mouseover"			  
	});
	
	$('#demo3').jcContact({
		speed:400,
		position:'bottom',
		posOffsetY : -100,
		btnPosition : 'top',
		btnPosoffsetY : 44 ,
		float:'right',
		Event : "click"			  
	});
});
</script>
<style>
<!-- 
/* contact */
.jcContact { position:absolute; top:0; left:0; z-index:99; width:215px; }
.jcConraper { width:174px; background:url(images/c03.png) repeat-y 0 0; overflow:hidden;}
.jcConBtn { background:url(images/c01.png) no-repeat; position:absolute; top:0; left:0; width:41px; height:116px; cursor:pointer;  }
body,ul,ol,h2,h3,h4,h5,p,dl,dt,dd,form{padding:0;margin:0;}img{border:none;}li{list-style:none;}a{text-decoration:none;outline:none;color:#666666;}a:hover{text-decoration:none}img{border:0}ul{list-style:none;margin:0;}label{color:#6CBD45;font-size:14px;font-weight:bold;padding-bottom:0.5em;margin:0;}.h3{font-size:13px;font-weight:bold;}#show{background:url(images/photo.jpg)}#meun{color:#fff;padding-left:10px;}#meun img{float:left;}#submeun{margin-left:70px;float:left;}#submeun span{text-align:center;margin-right:10px;float:left;display:inline;}#submeun span a{color:#fff;height:50px;line-height:50px;font-size:14px;font-weight:bold;text-align:center;padding-left:15px;padding-right:15px;display:block;}#submeun span.cur{text-align:center;background:#82ce18;margin-right:10px;float:left;display:inline;}#top{background-color:#000;margin:0em 0 10px 0em;border-style:solid;border-width:1px;border-color:#E5E5E5;height:50px;line-height:50px;}label.subtitle{font-size:13px;float:right;color:#6CBD45;margin:0 10px;text-align:right;}h1.title{height:50px;font-size:12px;background:url(logo.png) no-repeat;}h1.title a:link,h1.title a:visited,h1.title a:hover{color:#000;text-decoration:none;}
-->
</style>
</body>
</html>

 