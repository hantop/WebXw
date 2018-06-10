(function($) {
	//弹出框ID的前缀
	var idNotify = "_ymc_notify";
	var idMask = "_ymc_mask";
	//在当前页面记录第几个弹出框
	var idx = 0;
	var bottomValue= 10;
	/**
	 * 关闭提示窗口，关闭定时器
	 * */
	function doClose(modal, index) {
		var closeHeight = $("#" + idNotify + index).height();
		var closeBottom = $("#" + idNotify + index).css("bottom");
		$("#" + idNotify + index).fadeOut(350,
		function() {
			$(this).remove();
		});
		if (modal) { //如果有遮罩层移除遮罩层
			$("#" + idMask + index).fadeOut(350,
			function() {
				$(this).remove();
			});
		}
		resetBottom(closeHeight,closeBottom);
	}
	/**
	 * 重置已经显示的消息弹出框
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
		idx++; //记录弹出的提示框个数
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

		if (options.modal) { //需要模态效果
			//添加遮罩层
			var window_mask = "<div class=\"ymc-window-mask\" id=\"" + idMask + idx + "\"></div>";
			$(window_mask).appendTo("body");
			$(msgHtml).appendTo("body");
		} else {
			$(msgHtml).appendTo("body");
		}
		//超时执行关闭提示框
		var timer = null;
		if (options.autoDelayClose) {
			var index = idx;
			timer = setTimeout(function() {
				doClose(options.modal, index);
			},
			options.timeout);
		}
		//click事件关闭提示框
		if (options.modal) {
			$('#' + idNotify + idx).on('click',
			function() {
				if (options.autoDelayClose) { //支持延时自动关闭的话，清空超时器
					clearTimeout(timer);
				}
				$(this).fadeOut(350,
				function() {
					$(this).remove(); //先删除最前面的提示框
					$("#" + idMask + idx).fadeOut(350,
					function() { //再删除提供模态效果的遮罩层
						$(this).remove();
					});
				});
			});
		} else {
			$('#' + idNotify + idx).on('click',
			function() {
				var closeHeight = $(this).height();
				var closeBottom = $(this).css("bottom");
				if (options.autoDelayClose) { //支持延时自动关闭的话，清空超时器
					clearTimeout(timer);
				}
				$(this).fadeOut(550,
				function() { //删除提示框
					$(this).remove();
				});
				if (options.autoDelayClose) { //清空超时器
					clearTimeout(timer);
				}
				resetBottom(closeHeight,closeBottom);
			});
		}
		if (options.autoDelayClose) {
			var index = idx;
			$('#' + idNotify + idx).on('mouseenter',
			function() { //鼠标进入时取消超时关闭
				clearTimeout(timer);
			});
			$('#' + idNotify + idx).on('mouseleave',
			function() { //鼠标退出时开启定时关闭
				timer = setTimeout(function() {
					doClose(options.modal, index);
				},
				options.timeout);
			});
		}
		if (options.modal) { //如果是模态，提示信息显示在默认的位置，忽略原来的参数
			options.position.top = "160px";
			options.position.left = $(document).width() / 2.8;
		}
		$('#' + idNotify + idx).css(options.position).css("width", options.minWidth)
		//设定高度
			.css("height", "auto")
			.css("bottom",bottomValue+"px")
		//保证提示框在遮罩层的上面
		.css("zIndex", 99);
		bottomValue = bottomValue + 30 + $('#' + idNotify + idx).height();
	};
	$.notify.defaults = {
		//操作的状态目前只有good,bad两种状态
		status: 'good',
		//提示信息的内容
		content: "哈",
		//提示信息的显示标题
		title: "木屋消息",
		//显示位置
		position: {
			"bottom": "10px",
			"right": "20px"
		},
		//最小宽度
		minWidth: "300px",
		//模态
		modal: false,
		//延时关闭的的超时时间
		timeout: 4000,
		//是否自动延迟关闭
		autoDelayClose: true
	};
})(jQuery);