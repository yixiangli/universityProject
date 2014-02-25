<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include_import.jsp"%>
<%@ include file="../include_head.jsp"%>
<c:if test="${empty orders}">
     <c:redirect url="./showAllOrders.do?nowpage=0"></c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../CSS/style.css" rel="stylesheet">
<script type="text/javascript" src="../JS/jquery.js"></script>
<script type="text/javascript" src="../JS/song.js"></script>
<link href="../CSS/css3buttons.css" rel="stylesheet">
<link href="../CSS/showDialog.css" rel="stylesheet">
<script language='JavaScript' src='../JS/showDialog.js'></script>
<script language='JavaScript' src='../JS/liyixiang.js'></script>
</head>

<body>  
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
            <td><a href="adminOutLogin.do" class="word_white">退出后台<br>
              Exit Background </a></td>
          </tr>
        </table>
         <!-- 操作菜单结束 --> 
        </td>
      </tr>
    </table></td>
    <td align="center" valign="top"><table width="100%" height="120"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top" background="../images/manage_center_orderlist.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="98%" align="right">
              <!--搜索框-->
				<form name="search" method="post" action="search_order.jsp">
				<table width="100%" height="23"  border="0" cellpadding="0" cellspacing="0">
				<tr>
				  <td height="7"></td>
				</tr>
				<tr>
				  <td width="85%">&nbsp; 根据订单状态筛选订单：
					<select name="orderType" class="textarea">
					    <option value="">请选择</option>
					    <option value="1">新订单</option>
					    <option value="2">已配送</option>
					</select>        
                  </td>
                 <td><input type="submit" class="pill button" value="搜索"></td>
                  
				</tr>
				</table>
				</form>
				<!--搜索框结束-->
            </td>
            <td width="2%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="95%" height="192"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top">
           <table id="orderTable" width="94%"  border="0" cellpadding="3" cellspacing="3">
                 
                  
                    <tr align="center" >
                      <td width="15%" height="30" class="tableBorder_B_dashed">订单号</td>
                      <td width="25%" class="tableBorder_B_dashed">订单时间</td>
                      <td width="15%" class="tableBorder_B_dashed">收货人</td>
                      <td width="35%" class="tableBorder_B_dashed">订单商品</td>
                      <td width="10%" class="tableBorder_B_dashed">订单状态</td>
                    </tr>
                    <%
                      int num = 0;
                    %>
                    <c:forEach items="${orders}" var="order" varStatus="orderNum">					
                   	<% 
                        num++;          
                        String str = (String)request.getAttribute(num+"");
                        
                      %>
                    <tr align="center" >
                      <td class="tableBorder_B_dashed"><a href="../manage/showManageOrderDetail.do?orderid=${order.orderId}&items=<%=(String)request.getAttribute(num+"")%>">${order.orderId}</a></td>
                      <td class="tableBorder_B_dashed">${order.orderTime}</td>
                      <td class="tableBorder_B_dashed">${order.receiveName}</td>
                      
                      <td class="tableBorder_B_dashed">
                        <%=str %>
                      </td>
                      <%
                      
                      %>
                      <c:choose>
                      <c:when test="${order.orderType == 1}">
                      <td class="tableBorder_B_dashed"><font color="red">新订单</font></td>
                      </c:when>
                      <c:otherwise>
                      <td class="tableBorder_B_dashed">已配送</td>
                      </c:otherwise>
                      </c:choose>
                    </tr>
					</c:forEach>
                                       
                  </table>
            <table width="100%"  border="0" cellspacing="0" cellpadding="0">
			 <tr>
			    <td align="center">
				<% OrderManageVo orderVo = (OrderManageVo)request.getAttribute("orderVo"); %>
				当前页数：[<%=orderVo.getNowpage()+1 %>/<%=orderVo.getPagecount() %>]
				
				<a href="./showAllOrders.do?nowpage=0">第一页</a>&nbsp;&nbsp;<a href="./showAllOrders.do?nowpage=<%=orderVo.getPreviouspage() %>">上一页</a>&nbsp;&nbsp;
				
				<a href="./showAllOrders.do?nowpage=<%=orderVo.getNextpage() %>">下一页&nbsp;</a><a href="./showAllOrders.do?nowpage=<%=orderVo.getLastpage()%>">&nbsp;&nbsp;最后一页&nbsp;</a>
				</td>
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
    <td height="54" align="center">
 <!--版权信息  -->
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
      <!--版权信息结束  -->  
    </td>
  </tr>
</table>
</td>
</tr>
</table>
</body>
</html>

 