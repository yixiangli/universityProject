<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include_import.jsp" %>
<c:if test="${publishs == null}">
  <jsp:forward page="showPublish.do?nowpage=0"></jsp:forward>
</c:if>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="../CSS/style.css" rel="stylesheet">
<script src="../JS/check.jsp"></script>
<script src="onclock.JS"></script>
<link href="../CSS/manhua_bubbletips.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../JS/jquery.js"></script>
<script type="text/javascript" src="../JS/manhua_bubbletips.js"></script>
<script type="text/javascript">
$(function (){
	$("#test").manhua_bubbletips({position : "r",value : 15,content : "点击这里添加公告！！！"});
	
});
</script>
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
            <td><a href="adminOutLogin.do"  class="word_white">退出后台<br>
              Exit Background </a></td>
          </tr>
        </table>
         <!-- 操作菜单结束 --> 
                </td> 
              </tr> 
            </table></td> 
            
          <td align="center" valign="top"><table width="100%" height="120"  border="0" cellpadding="0" cellspacing="0"> 
              <tr> 
                <td valign="top" background="../images/manage_center_placardlist.gif"><table width="594" height="37"  border="0" cellpadding="0" cellspacing="0"> 
                    <tr> 
                      <td width="78%"></td>
                      <td id="test"><a href="placard_add.jsp">[ <img src="../images/list.gif" width="11" height="13">&nbsp;添加公告信息]</a></td> 
                      <td width="5%"></td>
                    </tr> 
                  </table></td> 
              </tr> 
            </table> 
            
              <table width="98%" height="192"  border="0" cellpadding="0" cellspacing="0"> 
                <tr> 
                  <td valign="top">                   
                    <table width="100%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" ="#FFFFFF"> 
                      <tr bgcolor="#eeeeee"> 
                        <td width="10%" align="center">编号</td> 
                        <td width="40%" height="24" align="center">公告标题</td> 
                        <td width="20%" align="center">发布时间</td> 
                        <td width="20%" align="center">失效时间</td> 
                        <td width="5%" align="center">修改</td>
                        <td width="5%" align="center">删除</td>
                      </tr>  
                     <c:forEach items="${publishs}" var="publish" varStatus="publishNum">                   
                      <tr style="padding:5px;"> 
                        <td height="20" align="center">${publishNum.count}.</td> 
                        <td align="center">${publish.getTitle()}！</td> 
                        <td align="center"><fmt:formatDate value="${publish.getPublishTime()}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                        <td align="center"><fmt:formatDate value="${publish.getOutTime()}" pattern="yyyy-MM-dd"></fmt:formatDate></td> 
                        <td align="center"><a href="publishModify.do?id=${publish.getId()}"><img src="../images/modify.gif" width="15" height="15"></a></td>
                        <td align="center"><a href="deletePublish.do?id=${publish.getId()}"><img src="../images/del.gif" width="16" height="16"></a></td>
                      </tr> 
                     </c:forEach>                     
                    </table>                   
                    <table width="100%"  border="0" cellspacing="0" cellpadding="0">
					  <tr>
					    <td align="right"> <% GoodsManageVo goodsManageVo = (GoodsManageVo)request.getAttribute("publishVo");%>
				当前页数：[<%=goodsManageVo.getNowpage()+1 %>/<%=goodsManageVo.getPagecount() %>]
				<a href="./showPublish.do?nowpage=0">第一页</a>　<a href="./showPublish.do?nowpage=<%=goodsManageVo.getPreviouspage() %>">上一页</a>
				<%if(goodsManageVo.getNextpage() < goodsManageVo.getPagecount()){ %>
			      <a href="./showPublish.do?nowpage=<%=goodsManageVo.getNextpage() %>">下一页</a>
				<%} else{%>
				  <a href="./showPublish.do?nowpage=0">下一页</a>
				<%} %>
				<a href="./showPublish.do?nowpage=<%=goodsManageVo.getLastpage()%>">最后一页&nbsp;</a>
						
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
      </table></td> 
  </tr> 
</table> 
</body>
</html>

 