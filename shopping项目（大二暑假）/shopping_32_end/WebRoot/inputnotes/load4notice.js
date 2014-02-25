$(document).ready(function() {
	
	$("#title").inputNotes({
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
	
	$("#content").inputNotes({
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
	
});