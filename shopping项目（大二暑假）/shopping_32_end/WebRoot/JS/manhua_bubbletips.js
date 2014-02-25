/***
 * ����ԭ��������Ϣ��ʾJquery���
 * ��дʱ�䣺2012��8��23��
 * version:manhua_bubbletips.js
***/
$(function() {
	$.fn.manhua_bubbletips = function(options) {
		var defaults = {			
			position : "t",			//��ͷָ����(t)����ͷָ����(b)����ͷָ����(l)����ͷָ����(r)
			value : 15,				//С��ͷƫ����ߺ��ϱߵ�λ��
			content : ""			//����
			
		};
		var options = $.extend(defaults,options);		
		var offset = $(this).offset();
		var bid = parseInt(Math.random()*100000);		
		$("body").prepend('<div class="docBubble" id="btip'+bid+'"><i class="triangle-'+options.position+'"></i> <i class="close" title="�ر�" id="btipc'+bid+'">�ر�</i><div class="tl"><div class="inner"><div class="cont">'+options.content+'</div></div></div><div class="tr"></div><div class="bl"></div></div>');
		var $btip = $("#btip"+bid);
		var $btipClose = $("#btipc"+bid);
		var h = $(this).height();
		var w = $(this).width();	
		switch(options.position){
			case "r" ://�������ұߵ�ʱ��			
				$(".triangle-r").css('top',options.value);
				$btip.css({ "left":offset.left-w+25-$btip.width()  ,  "top":offset.top+h/2-7-options.value });
				break;
		}
		$btipClose.live("click",function(e){
		  $btip.hide();	
		});		
	}
});