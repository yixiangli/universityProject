<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台管理!</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../CSS/style.css" rel="stylesheet">
<link href="../CSS/css3buttons.css" rel="stylesheet">
<link href="../CSS/showDialog.css" rel="stylesheet">
<script language='JavaScript' src='../JS/jquery.js'></script>
<script language='JavaScript' src='../JS/liyixiang.js'></script>
<script language='JavaScript' src='../JS/main.js'></script>
<script language='JavaScript' src='../JS/showDialog.js'></script>
</head>
<body>
	<div><br></div>
	<div><br></div>
	<div><br></div>
	<div><br></div>
	<div><br></div>
      <table width="350" height="210"  border="0" align="center" cellpadding="0" cellspacing="0" background="../images/login_M.jpg" class="tableBorder">
        <tr>
          <td height="136" align="center"><br></td>
        </tr>	  
              
        <tr>
          <td height="87" align="center" valign="top">
          <form name="form1" method="post" action="">
          <table width="62%" height="120"  border="0" cellpadding="0" cellspacing="0" style="width: 202px;">              
			<tr>
              <td width="95%" align="center">&nbsp;用户名：
              <input name="admin" type="text" id="admin" size="20"></td>
              </tr>
            <tr>
              <td align="center">&nbsp;密&nbsp;&nbsp;码：
              <input name="pwd" type="password" id="pwd" size="20"></td>
              </tr>

            <tr>
              <td align="center"><input type="button" class="positive button" value="确认" onClick="adminLogin()"> 
              &nbsp;
                <input type="reset" class="negative button" value="重置">
              &nbsp;
              <input type="button" class="primary button" value="返回" onClick="window.location.href='../index.jsp';"></td>
              </tr>           
          </table>
          </form>
          </td>
        </tr>
</table>
</body>
</html>
