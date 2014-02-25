var inputUsernameIsOk = 0;//初始化为不可以
var inputPasswordIsOk = 0;//初始化为不可以
var inputCaptchaIsOk = 0;//初始化为不可以
var inputNoticeIsOk = 0;//初始化为不可以

function checkUsername(){
	var username = $("#regUsernameInputBox").val();
	//$.get("servlet的url",{参数名1:值1,***},回调函数(回调数据))
	$.get("checkUsername.do",{name:username},function(data){
		$("#checkResult").html(data);
		if(data == "<font color='green'>用户名已通过检测</font>") {
			inputUsernameIsOk = 1;
		} else {
			inputUsernameIsOk = 0;//改为不可以
		}
	});
}

function checkPassword(){
	var password1=$("#password1").val();
	var password2=$("#password2").val();
	if(password1 == password2) {
		$("#result").html("<font color=‘green’>两次密码一致</font>");
		inputPasswordIsOk = 1;
	} else {
		$("#result").html("<font color=‘red’>两次密码不一致，请确认！</font>");
		inputPasswordIsOk = 0;//改为不可以
	}
}
//会员登陆
function userLogin(){

	var username = $("#username").val();
	var password = $("#pwd").val();

	$.get("login.do",{"username":username,"pwd":password},function(data){
		
		showMsg(data);
		
		if(data=="登陆成功"){

			window.setTimeout(function(){
				window.location.reload()
			},500);
		}
					
	});
}
//弹出提示
function showMsg(str){
	showDialog("info", str, "友情提示", 300);
}

//验证码
function checkCaptcha() {
	var inputCaptcha = $("#captchaInputBox").val();
	$.get("checkCaptcha.do",{"inputCaptcha":inputCaptcha},function(data){
		$("#captchaResult").html(data);
		if(data == "<font color=green>验证码正确!</font>") {
			inputCaptchaIsOk = 1;
		} else {
			inputCaptchaIsOk = 0;//改为不可以
		}
	});
}
//退出登陆
function outlogin(){	
		
		clearCart();
	
		$.get("outlogin.do",null,function(data){
			showMsg(data);
			window.setTimeout(function(){
				window.location.href = "index.jsp"
				},300);
		});
		
		
}

//管理员登陆
function adminLogin(){
	
	var username = $("#admin").val();
	var password = $("#pwd").val();

	$.get("adminLogin.do",{"admin":username,"pwd":password},function(data){

		showMsg(data);

		if(data=="登陆成功"){
	
			window.setTimeout(function(){
				window.location.href="MemberManage.jsp"
			},300);
		}
					
	});
}


//密码修改
function updatePwd(){
	var oldpwd = $("#oldpwd").val();
	var newpwd = $("#newpwd").val();
	
	$.get("updatePwd.do",{"oldpwd":oldpwd,"newpwd":newpwd},function(data){
		
			showMsg(data);
		
			if(data=="修改成功，请牢记新密码"){
				
				window.setTimeout(function(){
					window.location.href = "index.jsp"
					},300);
			}
		});
}

//全国城市三级级联
function userInfo(){
	
	var name = $("#regUsernameInputBox").val();
	var password = $("#password1").val();
	var email = $("#email1").val();
	var realname = $("#realname1").val();
	var address = $("#address1").val();	
	var area1 = $("#test > select").val();
	var area2 = $("#test > select").next().val();
	var area3 = $("#test > select").next().next().val();
	
	var postcode = $("#postcode1").val();
	var tel = $("#telephone1").val();
	
	if(inputUsernameIsOk==1&& inputPasswordIsOk==1  && inputCaptchaIsOk==1 && $("#realname1").hasInputNotes() == false && $("#address1").hasInputNotes() == false && $("#postcode1").hasInputNotes() == false && $("#telephone1").hasInputNotes() == false)
	{
	$.post("register.do",{"name":name,"password":password,"email":email,"realname":realname,"address":address,"area1":area1,"area2":area2,"area3":area3,"postcode":postcode,"tel":tel},function(data){
			
		showMsg("注册成功");
		window.setTimeout(function(){
			window.location.href="index.jsp"
		},300);
		
	});
	}else{
    	showMsg("输入信息有误！");
    }
}

//修改地址薄
function addressInfo(){
	
	var realname = $("#realname1").val();
	var address = $("#address1").val();
	var area1 = $("#test > select").val();
	var area2 = $("#test > select").next().val();
	var area3 = $("#test > select").next().next().val();
	var postcode = $("#postcode1").val();
	var tel = $("#telephone1").val();
	
	if($("#realname1").hasInputNotes() == false && $("#address1").hasInputNotes() == false && $("#postcode1").hasInputNotes() == false && $("#telephone1").hasInputNotes() == false){
		$.post("updateTraffic.do",{"realname":realname,"address":address,"area1":area1,"area2":area2,"area3":area3,"postcode":postcode,"tel":tel},function(data){
			
			showMsg("修改成功");
			window.setTimeout(function(){
				window.location.href="index.jsp"
			},300);
			
		});
	}else{
    	showMsg("输入信息有误！");
    }
	
}

(function($){
    $.fn.lastScrollY= 0;
     $.fn.higo_plugins_ad = function(options){
         $(this).addClass("higo_plugins_ad");
         var settings = $.extend({
             autoHide:true,               
             hideSecond:10,               
             top:20,                      
             layout:"left",               
             width:100,                   
             height:100,                  
             opacity:0.5,
             setPosition:function(left, top){
             return;
             }
         },options || {});
		$(this).append('<a href="javascript:void(0)" onclick="(this.parentElement || this.parentNode).style.visibility=\'hidden\'" style="display:block;text-align:right;font-size:12px;color:#000;line-height:200%">关闭</a>');
		if($.browser.msie && $.browser.version=='6.0'){ $(this).css({"position":"absolute"});}else{$(this).css("position","fixed");}
		 $(this).css({"top":settings.top + "px","opacity":settings.opacity,"opacity":settings.opacity,"filter":"alpha(opacity=" + parseInt(settings.opacity * 100)  + ")","width":settings.width+"px","height":(settings.height+26)+"px"});
		 switch(settings.layout){
			 case "left":$(this).css("left","10px");break;
			 case "right":$(this).css("right","10px");break;
			 case "center":$(this).css("left",(parseInt(window.screen.availWidth) - parseInt(settings.width))/2 + "px");break;
			 default:$(this).css("left","10px");break;
		 }
         if(settings.autoHide){
             setTimeout("(function(){$('" + $(this).selector +  "').hide();})();",parseInt(settings.hideSecond) * 1000);
         }
         window.onscroll = function(){
			 if($.browser.msie && $.browser.version=='6.0'){
             var diffY;
             if (document.documentElement && document.documentElement.scrollTop)
                 diffY = document.documentElement.scrollTop;
             else if (document.body)
                 diffY = document.body.scrollTop
             else {
             }
             percent= 1 * (diffY - $.fn.lastScrollY);
             if(percent>0)
                 percent=Math.ceil(percent);
             else 
                 percent=Math.floor(percent);
             
             var top = $('.higo_plugins_ad').css("top");
             
             $('.higo_plugins_ad').css("top", parseInt(top) + percent + "px");
             $.fn.lastScrollY += percent;
			 }
         }
     }
 })(jQuery);

$(document).ready(function(){
    $("#fad").higo_plugins_ad({
        autoHide:false,
        hideSecond:5,
        top:50,
        layout:"left",
        width:140,
        height:255,
        opacity:1
    })
	$("#fad1").higo_plugins_ad({
        autoHide:false,
        hideSecond:5,
        top:50,
        layout:"right",
        width:140,
        height:270,
        opacity:1
    })
});

function mail(){
	
	$.get("mail.do",null,function(data){
		
		showMsg(data);
	});
}


function submitContent(){
	var oEditor = FCKeditorAPI.GetInstance('content');    
	editorValue = oEditor.GetHTML();
		
	var uid = $("#uid").val();
	var gid = $("#gid").val();
	var content = editorValue;
	
	$.get("comment.do",{"uid":uid,"gid":gid,"content":content},function(data){
			
			showMsg(data);
			window.setTimeout(function(){
				window.location.href="index.jsp"
			},300);
			
		});
}

function showEditor(){
	var sBasePath = "./fckeditor/";

	var oFCKeditor = new FCKeditor( 'content' ) ;
	oFCKeditor.BasePath	= sBasePath ;
	oFCKeditor.ReplaceTextarea() ;
	
}
