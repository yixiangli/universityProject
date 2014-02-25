$(document).ready(function() {
	//修改部分：
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
	
	$("#address1").inputNotes({
		requiredfield: {
		      pattern: /(^(\s)+$)|(^$)/,
		      type: 'warning',
		      text: '地址必填' 
		}
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