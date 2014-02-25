$(document).ready(function() {
	$("#productname").inputNotes({
		spacewarning: {
		      pattern: /\s/,
		      type: 'warning',
		      text: '不能输入空格!'
		},
		requiredfield: {
		      pattern: /(^(\s)+$)|(^$)/,
		      type: 'warning',
		      text: '必填的哦' 
		}
	});
	
	
	$("#normalprice").inputNotes({
		spacewarning: {
		      pattern: /\s/,
		      type: 'warning',
		      text: '不能输入空格!'
		},
		requiredfield: {
		      pattern: /(^(\s)+$)|(^$)/,
		      type: 'warning',
		      text: '必填的哦' 
		},
		warning : {
			pattern : /^[0-9]\d*\.\d*[0-9]\d*$/,
//			^[1-9]\d*$
//			^[1-9]\d*\.\d*[1-9]\d*$
			type : 'note',
			text : '只能输入正浮点数',
			inversedBehavior : true
		}
	});
	
	
	$("#memberprice").inputNotes({
		spacewarning: {
		      pattern: /\s/,
		      type: 'warning',
		      text: '不能输入空格!'
		},
		requiredfield: {
		      pattern: /(^(\s)+$)|(^$)/,
		      type: 'warning',
		      text: '必填的哦' 
		},
		warning : {
			pattern : /^[0-9]\d*\.\d*[0-9]\d*$/,
			type : 'note',
			text : '只能输入正浮点数',
			inversedBehavior : true
		}
	});
});