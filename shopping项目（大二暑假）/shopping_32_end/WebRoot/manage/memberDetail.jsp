<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../include_head.jsp"%>
<%@include file="../include_import.jsp"%>
<c:if test="${empty user}">
     <jsp:forward page="../memberDetail.do"></jsp:forward>
</c:if>
<html>
<head>
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../CSS/style.css" rel="stylesheet">
<link href="../CSS/css3buttons.css" rel="stylesheet">
<link href="../CSS/showDialog.css" rel="stylesheet">
<script src="onclock.JS"></script>

</head>
<body  onLoad="clockon(bgclock)"> 
<table width="777" height="192"  border="0" align="center" cellpadding="0" cellspacing="0" class="tableBorder">
<tr>
  <td>
<!-- LOGO -->
	<table width="777" height="115"  border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr>
	    <td valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td bgcolor="#CCCCCC" height="6px"></td>
	      </tr>
	    </table>
	      <table width="100%" height="123"  border="0" cellpadding="0" cellspacing="0">
	        <tr>
	          <td valign="top" background="../images/manage_01.gif"><table width="100%" height="118"  border="0" cellpadding="0" cellspacing="0">
	            <tr>
	              <td height="98" colspan="2">&nbsp;</td>
	            </tr>
	            <tr>
	              <td width="25%">&nbsp;</td>
	              <td width="75%" class="word_green" id="bgclock"></td>
	            </tr>
	          </table></td>
	        </tr>
	      </table></td>
	  </tr>
	</table>
<!-- LOGO结束-->
<table width="777" height="288"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="182" valign="top"><table width="100%" height="431"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top" background="../images/manage_02.gif">
           <!-- 操作菜单 -->
           <table width="100%" height="350"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="18%" height="61">&nbsp;</td>
            <td width="82%">&nbsp;</td>
          </tr>
          <tr>
            <td height="46">&nbsp;</td>
            <td><a href="GoodsManage.jsp" class="word_white">商品管理<br>
              Goods Manage</a></td>
          </tr>
          <tr>
            <td height="47">&nbsp;</td>
            <td><a href="MemberManage.jsp" class="word_white">会员管理<br>
              Member Manage</a></td>
          </tr>
          <tr>
            <td height="48">&nbsp;</td>
            <td><a href="OrderManage.jsp" class="word_white">订单管理<br>
              Order Manage</a></td>
          </tr>
          <tr>
            <td height="50">&nbsp;</td>
            <td><a href="PlacardManage.jsp" class="word_white">公告管理<br>
              Placard Manage</a></td>
          </tr>
          <tr>
            <td height="50">&nbsp;</td>
            <td><a href="ParameterManage.jsp" class="word_white">参数管理<br>
              Parameter Manage </a></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><a href="adminOutLogin.do"  class="word_white" onclick="">退出后台<br>
              Exit Background </a></td>
          </tr>
        </table>
         <!-- 操作菜单结束 --> 
        </td>
      </tr>
    </table></td>
    <td align="center" valign="top"><table width="100%" height="120"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top" background="../images/manage_center_memberdetail.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="98%" align="right">&nbsp;</td>
            <td width="2%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="92%" height="192"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top">
             <table width="100%" height="14"  border="0" cellpadding="0" cellspacing="0">
               <tr>
                 <td height="13" align="center">&nbsp;</td>
               </tr>
             </table>
             <table width="96%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tableBorder_B_dashed" >
                 <tr>              
	              <td height="28" class="font2">基本信息</td>
	              <td height="28" align="right">&nbsp;</td>
	            </tr>
                <tr>              
	              <td width="18%" height="30" align="center">用 户 名：</td>
	              <td width="82%" class="word_grey">${user.username}</td>
	            </tr>
	            <tr>
	              <td height="28" align="center">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
	              <td height="28">******</td>
	            </tr> 
	            <tr>
	              <td height="28" align="center">E-mail：</td>
	              <td height="28">${user.email}</td>
	            </tr> 
	            <tr>
	              <td height="28" align="center">消费金额：</td>
	              <td height="28">￥${user.spend}</td>
	            </tr> 
	            <tr>
	              <td height="28" align="center">会员等级：</td>
	              <c:if test="${user.type==1}"><td height="28">VIP会员</td></c:if>
	              <c:if test="${user.type==0}"><td height="28">普通会员</td></c:if>
	            </tr> 
	            <tr>
	              <td height="28" align="center">用户状态：</td>
	              <c:if test="${user.state==1}"><td height="28">冻结</td></c:if>
	              <c:if test="${user.state==0}"><td height="28">有效</td></c:if>
	            </tr> 
	            <tr>
	              <td height="28" align="center">创建时间：</td>
	              <td height="28">${user.pdate}</td>
	            </tr> 
	        </table>	
	        <table width="96%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tableBorder_B_dashed" >
	            <tr>              
	              <td height="28" class="font2">收货地址</td>
	              <td height="28" align="right">&nbsp;</td>
	            </tr>
	            <tr>
	              <td height="28"  width="18%" align="center">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
	              <td height="28">${user.realname}</td>
	            </tr>  
	            <tr>
	              <td height="28" align="center">地&nbsp;&nbsp;&nbsp;&nbsp;址：</td>
	              <td class="word_grey">${user.address}</td>
	            </tr>               
	            <tr>
	              <td height="28" align="center">地&nbsp;&nbsp;&nbsp;&nbsp;区：</td>
	              <td>${user.area}</td>
	            </tr>            
	            <tr>
	              <td height="28" align="center">邮&nbsp;&nbsp;&nbsp;&nbsp;编：</td>
	              <td class="word_grey">${user.postcode}</td>
	            </tr>
	            <tr>
	              <td height="28" align="center">联系电话：</td>
	              <td>${user.tel}</td>
	            </tr>             
            </table> 
            <table width="96%"  border="0" align="center" cellpadding="0" cellspacing="0" >
               <tr>
                  <td height="38" colspan="2" align="center"><input name="Submit3" type="button" class="primary button" value="返回" onClick="window.location.href='MemberManage.jsp'"></td>
               </tr>
            </table>
          </td>
        </tr>
      </table>
      <table width="100%" height="46"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td background="../images/manage_06.gif">&nbsp;</td>
        </tr>
      </table></td>
  </tr>
</table>
<table width="777"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="54" align="center"></td>
  </tr>
</table>
</td>
</tr>
</table>
</body>
</html>
