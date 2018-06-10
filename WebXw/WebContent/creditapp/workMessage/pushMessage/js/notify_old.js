(function($) {
	//������ID��ǰ׺
	var idNotify = "_ymc_notify";
	var idMask = "_ymc_mask";
	//�ڵ�ǰҳ���¼�ڼ���������
	var idx = 0;
	var bottomValue= 10;
	/**
	 * �ر���ʾ���ڣ��رն�ʱ��
	 * */
	function doClose(modal, index) {
		var closeHeight = $("#" + idNotify + index).height();
		var closeBottom = $("#" + idNotify + index).css("bottom");
		$("#" + idNotify + index).fadeOut(350,
		function() {
			$(this).remove();
		});
		if (modal) { //��������ֲ��Ƴ����ֲ�
			$("#" + idMask + index).fadeOut(350,
			function() {
				$(this).remove();
			});
		}
		resetBottom(closeHeight,closeBottom);
	}
	/**
	 * �����Ѿ���ʾ����Ϣ������
	 */
	function resetBottom(closeHeight,closeBottom){
//		var closeHeight = $(this).height()
		bottomValue = bottomValue - closeHeight;
		bottomValue = bottomValue < 0?10:bottomValue;
		$(document).find(".notify").each(function(){
			if($(this).css("bottom") > closeBottom){
				var thisBottom = $(this).css("bottom");
				thisBottom = parseInt(thisBottom.substring(0,thisBottom.length-2));
				$(this).css("bottom",(thisBottom -closeHeight-30)+"px" );
			}
		});
	}
	$.notify = function(options) {
		idx++; //��¼��������ʾ�����
		if($(document).find(".notify").length == 0){
			bottomValue = options.position["bottom"];
			bottomValue = bottomValue.substring(0,bottomValue.length-2);
			bottomValue = parseInt(bottomValue);
		}
		options = options || {};
		options = $.extend($.notify.defaults, options);
		var msgHtml = "";
		var _class = "notify successbox";
		var _img = "success.png";
		if (options.status == "bad") {
			_class = "notify errorbox";
			_img = "fail.png";
		}

		msgHtml += "<div class='" + _class + "' id=\"" + idNotify + idx + "\">";
		msgHtml += "<h1>" + options.title + "</h1>";
		msgHtml += "<span class='alerticon'>";
		//msgHtml += "<img src='" + _img + "'/>";
		msgHtml += "</span>";
		msgHtml += "<p>" + options.content + "</p>";
		msgHtml += "</div>";

		if (options.modal) { //��Ҫģ̬Ч��
			//������ֲ�
			var window_mask = "<div class=\"ymc-window-mask\" id=\"" + idMask + idx + "\"></div>";
			$(window_mask).appendTo("body");
			$(msgHtml).appendTo("body");
		} else {
			$(msgHtml).appendTo("body");
		}
		//��ʱִ�йر���ʾ��
		var timer = null;
		if (options.autoDelayClose) {
			var index = idx;
			timer = setTimeout(function() {
				doClose(options.modal, index);
			},
			options.timeout);
		}
		//click�¼��ر���ʾ��
		if (options.modal) {
			$('#' + idNotify + idx).on('click',
			function() {
				if (options.autoDelayClose) { //֧����ʱ�Զ��رյĻ�����ճ�ʱ��
					clearTimeout(timer);
				}
				$(this).fadeOut(350,
				function() {
					$(this).remove(); //��ɾ����ǰ�����ʾ��
					$("#" + idMask + idx).fadeOut(350,
					function() { //��ɾ���ṩģ̬Ч�������ֲ�
						$(this).remove();
					});
				});
			});
		} else {
			$('#' + idNotify + idx).on('click',
			function() {
				var closeHeight = $(this).height();
				var closeBottom = $(this).css("bottom");
				if (options.autoDelayClose) { //֧����ʱ�Զ��رյĻ�����ճ�ʱ��
					clearTimeout(timer);
				}
				$(this).fadeOut(550,
				function() { //ɾ����ʾ��
					$(this).remove();
				});
				if (options.autoDelayClose) { //��ճ�ʱ��
					clearTimeout(timer);
				}
				resetBottom(closeHeight,closeBottom);
			});
		}
		if (options.autoDelayClose) {
			var index = idx;
			$('#' + idNotify + idx).on('mouseenter',
			function() { //������ʱȡ����ʱ�ر�
				clearTimeout(timer);
			});
			$('#' + idNotify + idx).on('mouseleave',
			function() { //����˳�ʱ������ʱ�ر�
				timer = setTimeout(function() {
					doClose(options.modal, index);
				},
				options.timeout);
			});
		}
		if (options.modal) { //�����ģ̬����ʾ��Ϣ��ʾ��Ĭ�ϵ�λ�ã�����ԭ���Ĳ���
			options.position.top = "160px";
			options.position.left = $(document).width() / 2.8;
		}
		$('#' + idNotify + idx).css(options.position).css("width", options.minWidth)
		//�趨�߶�
			.css("height", "auto")
			.css("bottom",bottomValue+"px")
		//��֤��ʾ�������ֲ������
		.css("zIndex", 99);
		bottomValue = bottomValue + 30 + $('#' + idNotify + idx).height();
	};
	$.notify.defaults = {
		//������״̬Ŀǰֻ��good,bad����״̬
		status: 'good',
		//��ʾ��Ϣ������
		content: "��",
		//��ʾ��Ϣ����ʾ����
		title: "ľ����Ϣ",
		//��ʾλ��
		position: {
			"bottom": "10px",
			"right": "20px"
		},
		//��С���
		minWidth: "300px",
		//ģ̬
		modal: false,
		//��ʱ�رյĵĳ�ʱʱ��
		timeout: 4000,
		//�Ƿ��Զ��ӳٹر�
		autoDelayClose: true
	};
})(jQuery);