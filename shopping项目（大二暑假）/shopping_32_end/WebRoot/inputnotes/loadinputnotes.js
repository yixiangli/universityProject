$(document).ready(function() {
	//注册部分：
	$("#regUsernameInputBox").inputNotes({
		spacewarning: {
		      pattern: /\s/,
		      type: 'warning',
		      text: '不能输入空格!'
		},
		requiredfield: {
		      pattern: /(^(\s)+$)|(^$)/,
		      type: 'warning',
		      text: '用户名必填' 
		}
	});
	$("#captchaInputBox").inputNotes({
		spacewarning: {
		      pattern: /\s/,
		      type: 'warning',
		      text: '不能输入空格!'
		},
		requiredfield: {
		      pattern: /(^(\s)+$)|(^$)/,
		      type: 'warning',
		      text: '验证码必填' 
		}
	});
	
	$("#email1").inputNotes({
		
		email: {
		      pattern: /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+$/,
		      type: 'info',
		      text: '邮箱填写正确！' 
		    }
	});
	
	$("#address1").inputNotes({
		requiredfield: {
		      pattern: /(^(\s)+$)|(^$)/,
		      type: 'warning',
		      text: '地址必填' 
		}
	});

	
	$("#realname1").inputNotes({
		spacewarning: {
		      pattern: /\s/,
		      type: 'warning',
		      text: '不能输入空格!'
		},
		requiredfield: {
		      pattern: /(^(\s)+$)|(^$)/,
		      type: 'warning',
		      text: '真实姓名必填' 
		}
	});
	
	$("#password1").inputNotes({
		minlength: {
		      pattern: /^(.){0,5}$/i,
		      type: 'info',
		      text: '密码最小为6位' 
		    },
		    characters: {
		      pattern: /[^a-z0-9]/i,
		      type: 'warning',
		      text: '只能输入字母或数字' 
		    },
	});

	$("#postcode1").inputNotes({
		config : {
			notePosition : 'before'
		},
		minlength: {
		      pattern: /^(.){0,5}$/i,
		      type: 'info',
		      text: '邮编固定为6位' 
		    },
		warning : {
			pattern : /^[0-9]+$/,
			type : 'note',
			text : '只能输入数字',
			inversedBehavior : true
		}
	});
	$("#telephone1").inputNotes({
		config : {
			notePosition : 'before'
		},
		warning : {
			pattern : /^[0-9]+$/,
			type : 'note',
			text : '只能输入数字',
			inversedBehavior : true
		}
	});
});