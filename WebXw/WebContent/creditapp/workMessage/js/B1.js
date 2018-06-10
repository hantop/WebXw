$(document).ready(function() {
	document.onclick=function(e){
		var e= e? e : window.event; 
		var tar = e.srcElement||e.target; 
		var $tar = $(tar);
		var $task = $tar.parents(".task_style").length>0?$tar.parents(".task_style") : $tar;
		if($task.hasClass("task_select")){
			if(this.taskObj!=$task.data("info").pasNo){
				this.taskObj = $task.data("info").pasNo;
				if(typeof(this.taskInfo)!="undefined"){
					taskB.changeTaskSts(this.taskInfo);
				}
			}
			this.taskInfo = $task.data("info");
		}else if($(".task_select").length>0){
			var data = $(".task_select").data("info");
			$(".task_select").removeClass("task_correct").removeClass("task_select").data("open",true).find(".task_contents").animate({height:"25px"},300,function(){
				$(this).parents(".task_style").find(".task_ctrl").slideUp(function(){
					$(this).empty();
					mcSelector.mCustomScrollbar("update");
				});
			});
			taskB.changeTaskSts(data);
		}
	};
});

var IDMark_Switch = "_switch", IDMark_Icon = "_ico",IDMark_Tips = "_tips", IDMark_Span = "_span", IDMark_Input = "_input", IDMark_Check = "_check", IDMark_Edit = "_edit", IDMark_Remove = "_remove", IDMark_Ul = "_ul", IDMark_A = "_a";
var curMenu = null, treeObj = null;
var menu_setting = {
	view : {
		showIcon : false,
		showLine : false,
		selectedMulti : false,
		dblClickExpand : false,
		addDiyDom : menuAddDiyDom
	},
	data : {
		simpleData : {
			enable : true
		}
	},
	callback : {
		onClick : menu_OnClick
	}
};

var menu_zNodes = [];
function menuAddDiyDom(treeId, treeNode) {
//	if(treeNode.id.substr(0,1)==1){
		var aObj = $("#" + treeNode.tId + IDMark_A);
		var $new = $('<i class="task-new-icon"></i>');
		aObj.append($new);
		var countStr = "<span class='task_count task_max_no_"+treeNode.id+"' id='" + treeNode.tId + IDMark_Tips
		+ "' title='" + treeNode.count + "'>" + treeNode.count + "</span>";
		aObj.append(countStr);
//		taskB.msgCount+=Number(treeNode.count);
		if(treeNode.count==0||treeNode.count=="0"){
			$('#'+treeNode.tId + IDMark_Tips).hide();
		}
//	}else{
//		$("#" + treeNode.tId).remove();
//	}
}
function menu_OnClick(event, treeId, treeNode) {
	var jsonData = {
		pasMaxNo : treeNode.id,
		pasMinNo : "",
		pasAware : "",
		isHasBigType:true
	};
	taskB.getMessageJsonForRecent(jsonData);
}
/**
 * taskB
 * options Ĭ�ϲ���
 * initTasks ��ʼ���������Ϣ
 * initMsgCount ��ʼ����Ϣ����
 * createTask ��������
 * initEvent ��ʼ��ҳ��Ԫ���¼�
 * addEvent �����¼�
 * 
 * 
 * openIframe ����iframe
 * viewTaskMsg �鿴��Ϣ
 * changeTaskSts ��ѯ����״̬���޸�
 */
var taskB = {
	msgCount:0,
	options : {
		url : "SysTaskInfoActionAjax_findByPageToBAjax.action",
		pageNo : '1',
		sysDate:"",
		jsonData:{pageNo:1}, 
		ajaxData:[],
		pageNo:1,
		nextPageFlag:false
		
	},
	B_task_html : '<div class="task_style" id="">' + '<div class="task_ico">'
			+ '<div class="task_alt"></div>' + '</div>'
			+ '<div class="task_content">' + '<div class="task_name">'
			+ '<span></span>' + '<div class="task_title"></div></div>' + '<div class="time_icon">'
			+ '<span></span>' + '</div>'
			+ '<div class="task_info">'
			+ '<div class="task_contents"></div></div></div>'
			+ '<div class="task_ctrl"></div>' + '<div class="content_edit">'
			+ '<div class="content_btn">'
			+ '<span class="content_pasAware"></span>'+ '<span class="content_btn_ignore">����</span>'+'<span class="content_btn_ctrl">����</span>' + '</div></div></div>',
	No_task_html : '<div class="no_task_style" id="">'+
					'<i class="i i-kulian"></i>'+
					'<span class="no_task_span"><span>'
					+'</div>',
	initTasks : function(elem, data, dic) {
		var $this = this;
		this.$elem = $(elem);
		$this.dic = dic;
		$this.sysDate = $this.options.sysDate;
		$this.createTask(data);
		$this.initEvent();
		mcTimeline($('body'));
	},
	createTask : function(data) {
		var $this = this;
		var $div = $this.$elem;
		var dic = $this.dic;
		$this.clearElem();
		$.each(data, function(i, info) {
			var $task = $($this.B_task_html);
			$task.data("info",info);
			$task.attr('id', info.createDate);
			$task.addClass('scrollTo'+info.pasNo);
			$task.addClass("task_max_"+info.pasMaxNo);
			$task.addClass('task_must_' + info.pasIsMust);
			//$task.addClass('task_sts_' + info.pasSts);
			$task.addClass('task_sts_0');
			$task.find(".content_pasAware").addClass(info.pasAware?'content_pasAware_'+info.pasAware:'content_pasAware_0');
			var pasBigType = "";
			$.each(dic, function(j, type) {
				if (type.optCode == info.pasMinNo) {
					pasBigType = type.optName;
				}
			});
			$task.find(".task_name span").html("��"+pasBigType+"��");
			if(info.pasMaxNo==0){
				$this.viewTaskMsg($task);
			}
			$task.find(".task_alt").html(pasBigType.subCHStr(0, 2));
			var currDate = formatStringyyyyMMddToDateDesc(info.createDate,$this.sysDate);
			$task.find(".time_icon span").html(currDate +"  "+info.createTime);
			$task.find(".task_title").html(info.pasTitle);
			if(info.pasSts==1&&info.pasMaxNo!=0){
				var remark = info.pasContent?info.pasContent.replace(/\\/g,""):"";
				remark +="</br></br>";
				remark +=info.pasResult&&info.pasResult!="null"?info.pasResult:"";
				$task.find(".task_contents").html(remark);
			}else{
				$task.find(".task_contents").html(info.pasContent?info.pasContent.replace(/\\/g,""):"");
			}
			$div.append($task);
			$task.data("open",true);
			$this.addEvent($task, info);
		});
		$div.append($('<div class="foot" ></div>'));
		$div.slideDown(function() {
			mcSelector.mCustomScrollbar("update").mCustomScrollbar("scrollTo","top");
			var searchStr = $("#work-zone-text").val();
			if(typeof(searchStr)!="undefined"&&searchStr!=""){
				fHl(document.getElementById('work-zone-tasks'),searchStr,false);
			}
		});
	},
	initEvent : function() {
		var $this = this;
		$(".work-zone-title .all-tasks").bind("click", function() {
			$(".work-zone-title i").removeClass("task_select_i");
			$(".ztree li").removeClass("correct");
			$(".ztree li").find("a").removeClass("curSelectedNode");
			$('.time-line-dl dd').find('a').removeClass('line-a-on').removeClass('line-second-dot-on');
			$('.time-line-dl dd').find('span').removeClass('line-dot-on i i-duihao1').removeClass('line-second-dot-on');
			
			var jsonData = {
				pasMaxNo : -1,
				pasMinNo : "",
				pasAware : "",
				isHasBigType:true
			};
			$this.getMessageJsonForRecent(jsonData);
		});
		$("#last_info").bind("click", function() {
			$(".work-zone-title i").removeClass("task_select_i");
			$(".ztree li").removeClass("correct");
			$('.time-line-dl dd').find('a').removeClass('line-a-on').removeClass('line-second-dot-on');
			$('.time-line-dl dd').find('span').removeClass('line-dot-on i i-duihao1').removeClass('line-second-dot-on');
			$this.getMessageJsonForRecent();
			$('.time-line-dl dd').siblings('dd').find('a').removeClass('line-a-on').removeClass('line-second-dot-on');
			$('.time-line-dl dd').siblings('dd').find('span').removeClass('line-dot-on i i-duihao1').removeClass('line-second-dot-on');
			$(".work-zone-text").val("");
		});
		$("#pasAware").bind("click", function() {
			$(this).addClass("task_select_i").siblings('.work-zone-title i').removeClass("task_select_i");
			$this.ajaxViewTask({
				pasAware : 1,
				pasMaxNo : "",
				pasMinNo : ""
			});
			$(".level0").removeClass("correct");
			$(this).addClass("correct");
		});
	},
	addEvent : function(elem, data) {
		var $this = this;
		var $elem = $(elem);
		var url = data.pasUrl;
		$elem.bind("click",function(){
			$elem.addClass("task_select").siblings('.task_style').removeClass("task_select").data("open",true).find(".task_contents").animate({height:"25px"},300,function(){
					$(this).parents(".task_style").find(".task_ctrl").slideUp(function(){
						$(this).empty();
						mcSelector.mCustomScrollbar("update");
					});
				});
			//$elem.addClass("task_correct").siblings('.task_style').removeClass("task_correct");
		});
		$elem.find(".content_btn .content_pasAware").bind("click", function() {
			var $pasAware = $(this);
			if(window.event){
		        //e.returnValue=false;//��ֹ������Ϊ
		        window.event.cancelBubble=true;//��ֹð��
		     }else if(arguments.callee.caller.arguments[0].preventDefault){
		        //e.preventDefault();//��ֹ������Ϊ
		        arguments.callee.caller.arguments[0].stopPropagation();//��ֹð��
		     }
			$.ajax({
				type : "POST",
				url : "SysTaskInfoActionAjax_updataPasAwareStsAjax.action",
				dataType : "json",
				data:data,
				success : function(jsonData) {
					var pasAwareCount = jsonData.pasAwareCount;
					if(pasAwareCount==0||pasAwareCount=='0'){
						$("#pasAware .task_count").hide();
					}else{
						$("#pasAware .task_count").html(pasAwareCount).attr("title",pasAwareCount).show();
					}
					$pasAware.attr("class","content_pasAware content_pasAware_"+jsonData.sysTaskInfo.pasAware);
				},
				error : function(xmlhq, ts, err) {
				}
			});
		});
		if(data.pasSts==1||data.pasMaxNo==0){
			$elem.find(".content_btn .content_btn_ctrl").remove();
			//return false;
		}
		/*
		if(data.pasMinNo !="102" && data.pasMinNo !="202" && data.pasMinNo !="103" && data.pasMinNo !="203"){
			$elem.find(".content_btn .content_btn_ignore").remove();
		}
		*/
		if(data.optType==2){
			var ajaxData = {};
			var urlParam = $this.getUrlParam(url);
			var submitUrl = "";
			if(data.pasType==1){
				submitUrl = urlParam.submitUrl+"?taskId="+data.wkfTaskNo;
				ajaxData = urlParam;
			}else if(data.pasType==2){
				submitUrl = url;
				ajaxData.formId = data.formId;
			}
			//$elem.find(".content_btn .content_btn_ctrl").remove();
			$elem.bind("click",function(){
				if($elem.data("open")){
						$.ajax({
							type : "POST",
							url : "SysTaskInfoActionAjax_getFormHtmlAjax.action",
							dataType : "json",
							data:ajaxData,
							success : function(jsonData) {
								$elem.find(".task_ctrl").empty().hide(function() {
									var form = $("<form></form>");
									form.append(jsonData.formHtml).append($this.addFormHidden(urlParam,form,data)).append($this.addBtn(data));
									if(form.find("input[name=taskId]").length>0){
										form.find("input[name=taskId]").val(data.wkfTaskNo);
									}
									$elem.find(".task_ctrl").append(form);
									$this.btnEvent($elem,data,submitUrl);
									$elem.find(".task_ctrl").slideDown(function(){
										mcSelector.mCustomScrollbar("update");
										mcSelector.mCustomScrollbar("scrollTo",$elem);
									});
									$elem.data("open",false);
								});
							},
							error : function(xmlhq, ts, err) {
							}
						});
				}
			});
		}
		
		$elem.find(".content_btn .content_btn_ctrl").bind("click", function() {
			var thisData = $elem.data("info");
			var thisDiv = $(this).parent().parent().parent();
			var showTitle = thisData.pasTitle;;
			var showContent = data.pasContent;
			var okTitle = thisData.pasResult;
			if(thisData.pasMinNo == '301'){
				showContent = "��ת����Ӧ������ҳ����д���";
				okTitle = "����";
			}
			var workForAfter = function(){
				if(thisData.pasMinNo == '301'){
					var pasUrl = $elem.data("info").pasUrl;
					window.top.changeAbPage(pasUrl);
				}else{
					$.ajax({
						type : "POST",
						url : 'AftMessageAlarmAction_updateMessage.action',
						dataType : "text",
						data : {
							bizPkno:thisData.bizPkno,
							pasSubType:thisData.pasMinNo,
							pasMaxType:thisData.pasMaxNo,
							pasNo:thisData.pasNo,
							relId:thisData.formId,
							projNo:thisData.projNo
						},
						success : function(result) {
							if(result == "succ"){
								thisDiv.removeClass('task_sts_0').addClass('task_sts_1');
								$elem.find(".content_btn .content_btn_ctrl").remove();
							}
							else{
								alert("����ʧ�ܣ���鿴��̨��־");
							}
						},
						error : function(xmlhq, ts, err) {
						}
					});
				}
			};
			
			var test = $.gDialog.confirm(showContent, {
				title: showTitle,
				okbtntitle:okTitle,
				animateIn : "rollIn",
				animateOut: "rollOut",

				onSubmit:workForAfter
			});
		});
		$elem.find(".content_btn .content_btn_ignore").bind("click", function() {
			var thisDiv = $(this).parent().parent().parent();
			$.ajax({
				type : "POST",
				url : 'AftMessageAlarmAction_ignoreMessage.action',
				dataType : "text",
				data : {
					bizPkno:data.bizPkno,
					pasSubType:data.pasMinNo
				},
				success : function(events) {
					if(events == "succ"){
						thisDiv.hide(1000);
						subMessage(data.pasMaxNo,data.startNum);
					} else{
						alert("����ʧ�ܣ���鿴��̨��־");
					}
				},
				error : function(xmlhq, ts, err) {
				}
			});
		});
	},
	addFormHidden:function(param,elem,data){
		var $elem = $(elem);
		var html = "";
		$.each(param,function(key,val){
			if($elem.find("input[name="+key+"]").length>0){
				$elem.find("input[name="+key+"]").val(val);
			}else{
				html+='<input type="hidden" value="'+val+'" name="'+key+'">';
			}
		});
		return html;
	},
	getUrlParam:function(url){
		var paramObj = {};
		if(typeof(url)!="undefined"){
			var str = url.substring(url.indexOf("?")+1,url.length).split("&");
			for(var x in str){
				var obj = str[x].split("=");
				paramObj[obj[0]]=obj[1];
			}
		}
		return paramObj;
	},
	btnEvent:function(elem,info,submitUrl){
		var $this = this;
		var $elem = $(elem);
		var $btns = $elem.find(".task_ctrl_div");
		$btns.find(".cancle").bind("click",function(){
			$elem.data("open",true);
			$elem.removeClass("task_select").find(".task_ctrl").slideUp(
						function(){
							$(this).empty();
							mcSelector.mCustomScrollbar("update").mCustomScrollbar("scrollTo",$elem);
						});
			 if(window.event){
			        //e.returnValue=false;//��ֹ������Ϊ
			        window.event.cancelBubble=true;//��ֹð��
			     }else if(arguments.callee.caller.arguments[0].preventDefault){
			        //e.preventDefault();//��ֹ������Ϊ
			        arguments.callee.caller.arguments[0].stopPropagation();//��ֹð��
			     }
			$elem.find(".task_ctrl").slideUp(function(){
				mcSelector.mCustomScrollbar("update");
				$elem.find(".task_ctrl").empty();
			});
		});
		$btns.find(".task_submit").bind("click",function(){
			var $obj = $(this).parents("form");
			var dataParam = JSON.stringify($obj.serializeArray()); 
			console.log("չ�������ύURL:"+submitUrl);
			jQuery.ajax({
				url:submitUrl,
				data:{ajaxData:dataParam},
				type:"POST",
				dataType:"json",
				beforeSend:function(){  
				},success:function(data){
					if(data.flag == "success"){
						$this.changeTaskSts(info);
						// alert("�����ɹ�!");
					}else if(data.flag=="error"){
						if(data.flag!==undefined&&data.flag!=null&&data.flag!=""){
							alert(data.msg);
						}else{
							alert("����ʧ��!");
						}
					}
				},error:function(data){
					 alert("����ʧ�ܣ�");
				}
			});
		});
	},
	addBtn:function(data){
		var $html = $("<div class='task_ctrl_div'></div>");
		$html.append('<input class="task_ctrl_btn task_submit" type="button" value="�ύ"/>');
		$html.append('<input class="task_ctrl_btn cancle" type="button" value="ȡ��"/>');
		return $html;
	},
	openIframe:function(elem,data){
		
	},
	removeTask : function(elem) {

	},
	viewTaskMsg : function(elem){
		var info = $(elem).data("info");
		$(elem).data("view",true);
		$(elem).bind("click",function(){
			if($(elem).data("view")&&info.pasSts!="1"){
				$.ajax({
					type : "POST",
					url : "SysTaskInfoActionAjax_updataMsgAjax.action",
					dataType : "json",
					data : {
						pasNo : info.pasNo
					},
					success : function(jsonData) {
					},
					error : function(xmlhq, ts, err) {
					}
				});
			}
		});
	},
	changeTask:function(elem,info){
		var $this = this;
		var $task = $(elem);
		$task.unbind();
		var dic = $this.dic;
		$task.data("info",info);
		$task.attr('id', info.createDate);
		$task.attr("class",'task_style scrollTo'+info.pasNo+" task_max_"+info.pasMaxNo+' task_must_' + info.pasIsMust+' task_sts_' + info.pasSts);
		var pasSubType = "";
		$.each(dic, function(j, type) {
			if (type.id == info.pasMinNo) {
				pasSubType = type.name;
			}
		});
		$task.find(".task_name span").html("��"+pasSubType+"��");
		if(info.pasMaxNo==3){
			$task.find(".task_alt").html("��");
			$this.viewTaskMsg($task);
		}else{
			$task.find(".task_alt").html(pasSubType.subCHStr(0, 2));
		}
		$task.find(".time_icon span").html(info.createTime);
		$task.find(".task_title").html(info.pasTitle);
		if(info.pasSts==1&&info.pasMaxNo!=3){
			$task.find(".task_contents").html(info.pasContent+"</br></br>"+info.pasResult);
		}else{
			$task.find(".task_contents").html(info.pasContent);
		}
		$task.data("open",true);
		$this.addEvent($task, info);
	},
	changeTaskSts : function(data) {
		var $this = this;
		if(data.pasSts=="1"){
			return false;
		}
		/*
		$.ajax({
			type : "POST",
			url : "SysTaskInfoActionAjax_getByIdAjax.action",
			dataType : "json",
			data : {
				pasNo : data.pasNo
			},
			success : function(jsonData) {
				$this.closeTask(jsonData);
				window.parent.b2_iframe.closeTask(jsonData);
			},
			error : function(xmlhq, ts, err) {
			}
		});
		*/
	},
	closeTask:function(jsonData){
		var $this = this;
		var list = jsonData.list;
		var info = jsonData.info;
		/*
		var pasAwareCount = jsonData.pasAwareCount;
		if(pasAwareCount==0||pasAwareCount=='0'){
			$("#pasAware .task_count").hide();
		}else{
			$("#pasAware .task_count").html(pasAwareCount).attr("title",pasAwareCount).show();
		}
		*/
		if(info.pasSts==1){
			//$('.scrollTo'+info.pasNo).removeClass("task_sts_0").addClass("task_sts_1");
			//$('.scrollTo'+info.pasNo).find(".content_btn .content_btn_ctrl").remove();
			var pasResult = info.pasContent.replace(/\\/g,"")+"</br></br>";//�����滻
			/*
			pasResult+=info.pasResult?info.pasResult:"";
			$('.scrollTo'+info.pasNo).find(".task_contents").html(pasResult);
			if(info.optType==2){
				$('.scrollTo'+info.pasNo).find(".task_ctrl").empty();
				$this.changeTask($('.scrollTo'+info.pasNo),info);
			}else{
				$('.scrollTo'+info.pasNo).removeClass("task_correct").removeClass("task_select").data("open",true).find(".task_contents").animate({height:"25px"},300,function(){
					$(this).parents(".task_style").find(".task_ctrl").slideUp(function(){
						$(this).empty();
						mcSelector.mCustomScrollbar("update");
						$this.changeTask($('.scrollTo'+info.pasNo),info);
					});
				});
			}
			*/
		}
		var treeObj = $.fn.zTree.getZTreeObj("menu_tree");
		var nodes = treeObj.getNodes();
		$.each(nodes,function(i,node){
			node.count="0";
			$("#"+node.tId + IDMark_Tips).html("0").attr("title","0").hide();
			$.each(list,function(j,obj){
				if(node.optCode==obj.pasMaxNo){
					node.count=obj.pasContent;
					$("#"+node.tId + IDMark_Tips).html(obj.pasContent).attr("title",obj.pasContent).show();
				}
			});
		});
	},
	clearElem : function(elem) {
		var $this = this;
		$this.$elem.empty();
	},
	addTask : function(data) {
		var $this = this;
		var $div = $this.$elem;
		var dic = $this.dic;
		$div.find(".foot").remove();
		$.each(data, function(i, info) {
			var $task = $($this.B_task_html);
			$task.data("info",info);
			$task.attr('id', info.createDate);
			$task.addClass('scrollTo'+info.pasNo);
			$task.addClass("task_max_"+info.pasMaxNo);
			$task.addClass('task_must_' + info.pasIsMust);
			//$task.addClass('task_sts_' + info.pasSts);
			$task.addClass('task_sts_0');
			$task.find(".content_pasAware").addClass('content_pasAware_' + info.pasAware);
			var pasSubType = "";
			$.each(dic, function(j, type) {
				if (type.optCode == info.pasMinNo) {
					pasSubType = type.optName;
				}
			});
			$task.find(".task_name span").html("��"+pasSubType+"��");
			if(info.pasMaxNo==3){
				$this.viewTaskMsg($task);
			}
			$task.find(".task_alt").html(pasSubType.subCHStr(0, 2));
			var currDate = formatStringyyyyMMddToDateDesc(info.createDate,$this.sysDate);
			$task.find(".time_icon span").html(currDate +"  "+info.createTime);
			$task.find(".task_title").html(info.pasTitle);
			if(info.pasSts==1&&info.pasMaxNo!=3){
				var remark = info.pasContent?info.pasContent.replace(/\\/g,""):"";
				remark +="</br></br>";
				remark +=info.pasResult&&info.pasResult!="null"?info.pasResult:"";
				$task.find(".task_contents").html(remark);
			}else{
				$task.find(".task_contents").html(info.pasContent?info.pasContent.replace(/\\/g,""):"");
			}
			$div.append($task);
			$task.data("open",true);
			$this.addEvent($task, info);
		});
		$div.append($('<div class="foot" ></div>'));
		var searchStr = $("#work-zone-text").val();
		if(typeof(searchStr)!="undefined"&&searchStr!=""){
			fHl(document.getElementById('work-zone-tasks'),searchStr,false);
		}
		mcSelector.mCustomScrollbar("update");
	},
	addMsg : function(info,mian) {
		var $this = this;
		var $div = $this.$elem;
		var dic = $this.dic;
		var $task = $($this.B_task_html);
		$task.data("info",info);
		$task.attr('id', info.createDate);
		$task.addClass('scrollTo'+info.pasNo);
		$task.addClass("task_max_"+info.pasMaxNo);
		$task.addClass('task_must_' + info.pasIsMust);
		//$task.addClass('task_sts_' + info.pasSts);
		$task.addClass('task_sts_0');
		$task.find(".content_pasAware").addClass('content_pasAware_' + info.pasAware);
		var pasSubType = "";
		$.each(dic, function(j, type) {
			if (type.optCode == info.pasMinNo) {
				pasSubType = type.optName;
			}
		});
		$task.find(".task_name span").html("��"+pasSubType+"��");
		if(info.pasMaxNo==0){
			$this.viewTaskMsg($task);
		}
		$task.find(".task_alt").html(pasSubType.subCHStr(0, 2));
		var currDate = formatStringyyyyMMddToDateDesc(info.createDate,$this.sysDate);
		$task.find(".time_icon span").html(currDate +"  "+info.createTime);
		$task.find(".task_title").html(info.pasTitle);
		if(info.pasSts==1&&info.pasMaxNo!=3){
			var remark = info.pasContent?info.pasContent.replace(/\\/g,""):"";
			remark +="</br></br>";
			remark +=info.pasResult&&info.pasResult!="null"?info.pasResult:"";
			$task.find(".task_contents").html(remark);
		}else{
			$task.find(".task_contents").html(info.pasContent?info.pasContent.replace(/\\/g,""):"");
		}
		$task.css({height:'0px',minHeight:'0px'});
		$div.prepend($task);
		$(".task_max_no_"+info.pasMaxNo).html(Number($(".task_max_no_"+info.pasMaxNo).html())+1);
		if(typeof(mian)=="undefined"||mian=="B"){
			$(".task_max_no_"+info.pasMaxNo).parent().find(".task-new-icon").css("display","block");
		}
		$task.data("open",true);
		$this.addEvent($task, info);
		var searchStr = $("#work-zone-text").val();
		if(typeof(searchStr)!="undefined"&&searchStr!=""){
			fHl(document.getElementById('work-zone-tasks'),searchStr,false);
		}
		$task.animate({height:'92px'},500,function(){
			mcSelector.mCustomScrollbar("update");
			$task.removeAttr("style");
		});
	},
	addFootMsg : function(msg) {
		var $this = this;
		var $elem = $this.$elem;
		var $foot = $elem.find(".foot");
		$foot.html(msg);
	},
	nextPage:function(){
		var $this = this;
		if($this.options.nextPageFlag){
			$this.addFootMsg("<span>û�и�������</span>");
			return false;
		}
		var url = this.options.url;
		var jData = $this.options.jsonData;
		var aData = $this.options.ajaxData;
		$this.options.pageNo = Number($this.options.pageNo)+1;
		jData.pageNo = $this.options.pageNo;
//		console.log(jData);
//		console.log(aData[0]);
		$.ajax({
			type : "POST",
			url : url,
			dataType : "json",
			data : {
				ajaxData : JSON.stringify(aData),
				jsonData : JSON.stringify(jData)
			},
			success : function(jsonData) {
				if(jsonData.ipage.result.length>0){
					$this.addTask(jsonData.ipage.result);
				}else{
					$this.options.nextPageFlag = true;
					$this.addFootMsg("<span>û�и�������</span>");
				}
			},
			error : function(xmlhq, ts, err) {
			}
		});
	},
	ajaxViewTask : function(jsonData, ajaxData) {
		var $this = this;
		var $div = $this.$elem;
		var url = this.options.url;
		$this.options.nextPageFlag = false;
		$this.options.pageNo=1;
		$this.options.jsonData.pageNo=1;
		var jData = $this.options.jsonData = $.extend({}, $this.options.jsonData, $.isPlainObject(jsonData) && jsonData);
		var aData = $this.options.ajaxData = $.extend([], $this.options.ajaxData,ajaxData);
//		console.log(jData);
//		console.log(aData[0]);
		$div.slideUp(function() {
			$.ajax({
				type : "POST",
				url : url,
				dataType : "json",
				data : {
					ajaxData : JSON.stringify(aData),
					jsonData : JSON.stringify(jData)
				},
				success : function(data) {
					var list = data.list;
					var pasAwareCount = data.pasAwareCount;
					if(pasAwareCount==0||pasAwareCount=='0'){
						$("#pasAware .task_count").hide();
					}else{
						$("#pasAware .task_count").html(pasAwareCount).attr("title",pasAwareCount).show();
					}
					var treeObj = $.fn.zTree.getZTreeObj("menu_tree");
					var nodes = treeObj.getNodes();
					$.each(nodes,function(i,node){
						node.count="0";
						$("#"+node.tId + IDMark_Tips).html("0").attr("title","0").hide();
						$.each(list,function(j,obj){
							if(node.optCode==obj.pasMaxNo){
								node.count=obj.pasContent;
								$("#"+node.tId + IDMark_Tips).html(obj.pasContent).attr("title",obj.pasContent).show();
							}
						});
					});
					if(data.ipage.result.length==0){
						$this.addSearchEmpty();
					}else{
						taskB.createTask(data.ipage.result);
					};
				},
				error : function(xmlhq, ts, err) {
				}
			});
		});
	},
	
	refreshTaskByDate : function(jsonData) {
		var $this = this;
		var $div = $this.$elem;
		$div.slideUp(function() {
			$.ajax({
				type : "POST",
				url : 'AftMessageAlarmAction_reloadMessagePage.action',
				dataType : "json",
				data : {
					sendDate:jsonData.createDate
				},
				success : function(data) {
					if(data.resultData.sysTaskInfoArray.result.length==0){
						$this.addSearchEmpty();
					}else{
						taskB.createTask(data.resultData.sysTaskInfoArray.result);
						showData.ajaxData = data.resultData;
					};
				},
				error : function(xmlhq, ts, err) {
				}
			});
		});
	},
	
	getMessageJsonForRecent : function(jsonData) {
		var $this = this;
		var $div = $this.$elem;
		$div.slideUp(function() {
			$.ajax({
				type : "POST",
				url : 'AftMessageAlarmAction_getMessageJsonForRecent.action',
				dataType : "json",
				data : {
				},
				success : function(data) {
					if(data.resultData.sysTaskInfoArray.result.length==0){
						$this.addSearchEmpty();
					}else{
						showData.ajaxData = data.resultData;
						if(jsonData && jsonData.isHasBigType){
							$this.refreshTaskByMaxNo(jsonData);
						}else{
							taskB.createTask(data.resultData.sysTaskInfoArray.result);
						}
					};
				},
				error : function(xmlhq, ts, err) {
				}
			});
		});
	},
	
	getMessageJsonBetween : function(jsonData) {
		var $this = this;
		var $div = $this.$elem;
		$div.slideUp(function() {
			$.ajax({
				type : "POST",
				url : 'AftMessageAlarmAction_getMessageJsonForBetween.action',
				dataType : "json",
				data : {
					beginDate:jsonData.beginDate,
					endDate:jsonData.endDate
				},
				success : function(data) {
					if(data.resultData.sysTaskInfoArray.result.length==0){
						$this.addSearchEmpty();
					}else{
						showData.ajaxData = data.resultData;
						if(jsonData && jsonData.isHasBigType){
							$this.refreshTaskByMaxNo(jsonData);
						}else{
							taskB.createTask(data.resultData.sysTaskInfoArray.result);
						}
					};
				},
				error : function(xmlhq, ts, err) {
				}
			});
		});
	},
	
	refreshTaskByMaxNo : function(jsonData){
		var $this = this;
		var $div = $this.$elem;
		$div.slideUp(function() {
			var resulData = $(showData.ajaxData.sysTaskInfoArray.result.clone());
			var thisResult = new Array();
			if(jsonData.pasMaxNo == -1){
				thisResult = resulData;
			}else{
				$.each(resulData,function(i,info){
					if(info.pasMaxNo == jsonData.pasMaxNo)thisResult.push(info);
				});
			}
			if(thisResult.length == 0) {
				$this.addSearchEmpty();
			}else{
				taskB.createTask(thisResult);
			}
			
		});
	},
	addSearchEmpty : function(){
		var $this = this;
		var $div = $this.$elem;
		$div.empty();
		var $html = $($this.No_task_html);
		var str = "�Ҳ�������ѯ��";
		if(typeof($this.options.ajaxData[0])!="undefined"&&$this.options.ajaxData[0].customQuery!=""){
			str+="��"+$this.options.ajaxData[0].customQuery+"��";
		}
		str+="�����Ϣ!";
		$html.find(".no_task_span").html(str);
		$div.append($html);
		$div.show();
		mcSelector.mCustomScrollbar("update");
	}
};

// js��չ����ȡ����
String.prototype.strLen = function() {
	var len = 0;
	for ( var i = 0; i < this.length; i++) {
		if (this.charCodeAt(i) > 255 || this.charCodeAt(i) < 0)
			len += 2;
		else
			len++;
	}
	return len;
};
// ���ַ�������ַ������浽������
String.prototype.strToChars = function() {
	var chars = new Array();
	for ( var i = 0; i < this.length; i++) {
		chars[i] = [this.substr(i, 1), this.isCHS(i)];
	}
	String.prototype.charsArray = chars;
	return chars;
};
// �ж�ĳ���ַ��Ƿ��Ǻ���
String.prototype.isCHS = function(i) {
	if (this.charCodeAt(i) > 255 || this.charCodeAt(i) < 0)
		return true;
	else
		return false;
};
// ��ȡ�ַ�������start�ֽڵ�end�ֽڣ�
String.prototype.subCHString = function(start, end) {
	var len = 0;
	var str = "";
	this.strToChars();
	for ( var i = 0; i < this.length; i++) {
		if (this.charsArray[i][1])
			len += 2;
		else
			len++;
		if (end < len)
			return str;
		else if (start < len)
			str += this.charsArray[i][0];
	}
	return str;
};
// ��ȡ�ַ�������start�ֽڽ�ȡlength���ֽڣ�
String.prototype.subCHStr = function(start, length) {
	return this.subCHString(start, start + length);
};

// ʱ����
var mcSelector;
var mcTimeline = function(mc) {
	mcSelector = mc;
	mcSelector.mCustomScrollbar({
		scrollButtons : {
			autoHideScrollbar : true,
			scrollAmount : 200
		},
		advanced : {
			autoExpandHorizontalScroll : true,
			updateOnBrowserResize : true,
			updateOnContentResize : false,
			autoScrollOnFocus : true,
			scrollSpeed : 50
		},
		scrollInertia : 1000,
		autoDraggerLength : true,
		callbacks : {
			onScroll : function() {
			},
			whileScrolling : function() {
			},
			onTotalScroll : function() {
				taskB.addFootMsg(' <div class="sk-double-bounce"><div class="sk-child sk-double-bounce1"></div><div class="sk-child sk-double-bounce2"></div></div>');
				setTimeout("taskB.nextPage()",1000);
			},
			onTotalScrollOffset:40,
			alwaysTriggerOffsets : false
		}
	});
};
var sysDate = "";
function createTimeLine(nowDate,len) {
	var ddArr = [];
	for(var i = 0;i<len;i++){
		var currDate = getCurrDate(nowDate,i);
		var ddHtml;
//		if (i == 0) {
//			ddHtml = '<dd class="time-line-dd">'
//					+ '<a data-dit="'
//					+ currDate
//					+ '" class="time-line-day line-a-on">'
//					+ showLocale(currDate)
//					+ '</a>'
//					+ '<span class="time-line-dot line-dot-on fa fa-check"></span>'
//					+ '<a data-dit="' + currDate
//					+ '" class="time-line-a line-a-on">'
//					+ formatStringyyyyMMddToyyyy_MM_dd(currDate)
//					+ '</a>' + '</dd>';
//		} else {
			ddHtml = '<dd class="time-line-dd">' + '<a data-dit="'
					+ currDate + '" class="time-line-day ">'
					+ showLocale(currDate) + '</a>'
					+ '<span class="time-line-dot"><em></em></span>'
					+ '<a data-dit="' + currDate
					+ '" class="time-line-a line-a-on">'
					+ formatStringyyyyMMddToyyyy_MM_dd(currDate)
					+ '</a>' + '</dd>';
//		}
		ddArr.push(ddHtml);
	}
//	var ddMoreHtml = '<dd class="time-line-dd">'
//	+ '<span class="time-line-dot"></span>'
//	+ '<b data-dit="" class="time-line-more-span">����</b>' + '</dd>';
//	ddArr.push(ddMoreHtml);
	$('.time-line-dl').html(ddArr.join(''));

	$('.time-line-dl').delegate('dd', 'click', function(evt) {
		var index = $('.time-line-dl dd').index($(this));
		$(this).find('a').addClass('line-a-on');
		$(this).find('span').addClass('line-dot-on i i-duihao1');
		$(this).siblings('dd').find('a').removeClass('line-a-on').removeClass('line-second-dot-on');
		$(this).siblings('dd').find('span').removeClass('line-dot-on i i-duihao1').removeClass('line-second-dot-on');
		if($(this).find('a').length>0){
			var ddId = $(this).find('a').data('dit');
			var jsonData = {createDate:ddId};
			taskB.refreshTaskByDate(jsonData);
		}else{
			//console.log("more");
		}
	});
	$(".time-line-border2").dateRangePicker({
		//alwaysOpen:true,
		format:"YYYY-MM-DD",
		endDate:nowDate,
		separator: '��',
		showShortcuts: false,
		language:'cn'
	}).bind('datepicker-apply',function(event,obj){
		var jsonData = {beginDate:obj.date1.format("yyyyMMdd"),endDate:obj.date2.format("yyyyMMdd")};
		//taskB.ajaxViewTask(jsonData);
		taskB.getMessageJsonBetween(jsonData)
		//createTimeLine(obj.date1.format("yyyyMMdd"),10);
		$(".time-line-body").find('dd').find('a').removeClass('line-a-on').removeClass('line-second-dot-on');
		$(".time-line-body").find('dd').find('span').removeClass('line-dot-on i i-duihao1').removeClass('line-second-dot-on');
	});
//	$(".time-line-dl b.time-line-more-span").parents(".time-line-dd").dateRangePicker({
//		//alwaysOpen:true,
//		format:"YYYY-MM-DD",
//		endDate:nowDate,
//		separator: '��',
//		showShortcuts: false
//		//language:'en'
//	}).bind('datepicker-apply',function(event,obj){
//		var jsonData = {createDate:"BETWEEN "+obj.date1.format("yyyyMMdd") +" AND "+obj.date2.format("yyyyMMdd")};
//		taskB.ajaxViewTask(jsonData);
//		$(this).find('a').addClass('line-a-on');
//		$(this).find('span').addClass('line-dot-on fa fa-check');
//		$(this).siblings('dd').find('a').removeClass('line-a-on').removeClass('line-second-dot-on');
//		$(this).siblings('dd').find('span').removeClass('line-dot-on fa fa-check').removeClass('line-second-dot-on');
//	});
}
//����N��ǰ����
var getCurrDate = function(sysDate,n){
    var now = new Date(sysDate.substring(0, 4),Number(sysDate.substring(4, 6))-1,sysDate.substring(6, 8));
    now.setDate(now.getDate() - n);
    var yy = now.getYear();
	if (yy < 1900) yy = yy + 1900;
	var MM = now.getMonth() + 1;
	if (MM < 10) MM = '0' + MM;
	var dd = now.getDate();
	if (dd < 10) dd = '0' + dd;
    return ""+yy+MM+dd;
};

function formatStringyyyyMMddToyyyy_MM_dd(value) {
	if (value.length == 8) {
		// return value.substring(0, 4) + "��" + value.substring(4, 6) + "��" +
		// value.substring(6, 8)+"��";
		return Number(value.substring(4, 6)) + "��" + value.substring(6, 8)
		+ "��";
	} else if (value.length == 6) {
		return value.substring(0, 4) + "��" + value.substring(4, 6) + "��";
	} else {
		return value + "��";
	}
}
function formatStringyyyyMMddToDateDesc(value,sysDate) {
	var DateDesc = ["����","����"];
	if(value==getCurrDate(sysDate,0)){
		return DateDesc[0];
	}
	if(value==getCurrDate(sysDate,1)){
		return DateDesc[1];
	}
	if (value.length == 8) {
		// return value.substring(0, 4) + "��" + value.substring(4, 6) + "��" +
		// value.substring(6, 8)+"��";
		return Number(value.substring(4, 6)) + "��" + value.substring(6, 8)
		+ "��";
	} else if (value.length == 6) {
		return value.substring(0, 4) + "��" + value.substring(4, 6) + "��";
	} else {
		return value + "��";
	}
}


function showLocale(objD) {
	var strDate = new Date();
	var yy = Number(objD.substring(0, 4));
	var mm = Number(objD.substring(4, 6)) - 1;
	var dd = Number(objD.substring(6, 8));
	strDate.setFullYear(yy, mm, dd);
	var str;
	// var yy = objD.getYear();
	// if (yy < 1900) yy = yy + 1900;
	// var MM = objD.getMonth() + 1;
	// if (MM < 10) MM = '0' + MM;
	// var dd = objD.getDate();
	// if (dd < 10) dd = '0' + dd;
	// var hh = objD.getHours();
	// if (hh < 10) hh = '0' + hh;
	// var mm = objD.getMinutes();
	// if (mm < 10) mm = '0' + mm;
	// var ss = objD.getSeconds();
	// if (ss < 10) ss = '0' + ss;
	var ww = strDate.getDay();
	if (ww == 0)
		ww = "����";
	if (ww == 1)
		ww = "��һ";
	if (ww == 2)
		ww = "�ܶ�";
	if (ww == 3)
		ww = "����";
	if (ww == 4)
		ww = "����";
	if (ww == 5)
		ww = "����";
	if (ww == 6)
		ww = "����";
	// str = colorhead + yy + "��" + MM + "��" + dd + "��" + hh + ":" + mm + ":" +
	// ss + " " + ww + colorfoot;
	str = ww;
	return (str);
}

/*
 * ҳ�����
 * */
function fHl(o, flag, rndColor, url) {
	// / <summary>
	// / ʹ�� javascript HTML DOM ������ʾҳ���ض��ִ�.
	// / ʵ��:
	// / fHl(document.body, 'ֽɡ|��');
	// / �����body��ָ����body��������ݡ�
	// / fHl(document.body, 'ϣ��|��Թ', false, '/');
	// / fHl(document.getElementById('at_main'), '����|Ʈ��|�Ƴ�', true,
	// 'search.asp?keyword=');
	// / �����'at_main'��ָ����id='at_main'��div��������ݡ�search.asp?keyword=ָ���ؼ��ּӵ����ӵ�ַ��
	// / ���������һ���������ں���Ҫ�õ�������������ĵ�ַ��
	// / </summary>
	// / <param name="o"type="Object">
	// / ����, Ҫ���и�����ʾ�Ķ���.
	// / </param>
	// / <param name="flag"type="String">
	// / �ַ���, Ҫ���и����Ĵʻ�����, ʹ�� ����(|) �ָ������ .
	// / </param>
	// / <param name="rndColor"type="Boolean">
	// / ����ֵ, �Ƿ������ʾ���ֱ���ɫ��������ɫ, true ��ʾ�����ʾ.
	// / </param>
	// / <param name="url"type="String">
	// / URI, �Ƿ�Ը����Ĵ��������.
	// / </param>
	// / <return></return>
	var bgCor = fgCor = '';
	if (rndColor) {
		bgCor = fRndCor(10, 20);
		fgCor = fRndCor(230, 255);
	} else {
		bgCor = '#3399FF';
		fgCor = '#ffffff';
	}
	var re = new RegExp(flag, 'i');
	for ( var i = 0; i < o.childNodes.length; i++) {
		var o_ = o.childNodes[i];
		var o_p = o_.parentNode;
		if (o_.nodeType == 1) {
			fHl(o_, flag, rndColor, url);
		} else if (o_.nodeType == 3) {
			// if(!(o_p.nodeName=='A')){
			if (o_.data.search(re) == -1)
				continue;
			var temp = fEleA(o_.data, flag);
			o_p.replaceChild(temp, o_);
			// }
		}
	}
	// ------------------------------------------------
	function fEleA(text, flag) {
		var style = ' style="background-color:' + bgCor + ';color:' + fgCor
				+ ';"';
		//font-weight:700;
		var o = document.createElement('span');
		var str = '';
		var re = new RegExp('(' + flag + ')', 'gi');
		if (url) {
			str = text.replace(re, '<a href="' + url + '$1"' + style
					+ '>$1</a>'); // �����Ǹ��ؼ��ּ����ӣ���ɫ��$1��ָ�������ӵ�ַ��ľ��������
		} else {
			str = text.replace(re, '<span ' + style + '>$1</span>'); // ��������ʱ��ʾ
		}
		o.innerHTML = str;
		return o;
	}
	// ------------------------------------------------
	function fRndCor(under, over) {
		if (arguments.length == 1) {
			var over = under;
			under = 0;
		} else if (arguments.length == 0) {
			var under = 0;
			var over = 255;
		}
		var r = fRandomBy(under, over).toString(16);
		r = padNum(r, r, 2);
		var g = fRandomBy(under, over).toString(16);
		g = padNum(g, g, 2);
		var b = fRandomBy(under, over).toString(16);
		b = padNum(b, b, 2);
		// defaultStatus=r+' '+g+' '+b
		return '#' + r + g + b;
		function fRandomBy(under, over) {
			switch (arguments.length) {
				case 1 :
					return parseInt(Math.random() * under + 1);
				case 2 :
					return parseInt(Math.random() * (over - under + 1) + under);
				default :
					return 0;
			}
		}
		function padNum(str, num, len) {
			var temp = '';
			for ( var i = 0; i < len; temp += num, i++);
			return temp = (temp += str).substr(temp.length - len);
		}
	}
}
//JS����ʱ�亯����չ ��ʽ��
Date.prototype.format = function(format) {
	var o = {
		"M+" : this.getMonth() + 1, // month
		"d+" : this.getDate(), // day
		"h+" : this.getHours(), // hour
		"m+" : this.getMinutes(), // minute
		"s+" : this.getSeconds(), // second
		"q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
		"S" : this.getMilliseconds()
	// millisecond
	};

	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}

	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1? o[k]: ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
};
//��ʱ ����
function enterKey(){};
function textareaInputCount(obj){};
function showCharsInfo(obj){};
function hideCharsInfo(obj){};


//����
$(function(){
	$(".sysTaskHelp").bind("click",domoGuide);
})
function domoGuide() {

	var guide = $.guide({
		actions: [
			{
				element: $('.work-zone-search'),
				content: '<span>ͨ���ؼ�����������</span>',
				offsetX: 220,
				offsetY: 0
			},
			{
				element: $('#menu_tree'),
				content: '<span>��ʾ��ͬ����������</span>',
				offsetX: 220,
				offsetY: 0,
				beforeFunc: function(g) {
				}
			},
//			{
//				element: $('#pasMsg'),
//				content: '<span>��ʾϵͳ��Ϣ</span>',
//				offsetX: 220,
//				offsetY: 0,
//				//isBeforeFuncExec: true,
//				beforeFunc: function(g) {
//				}
//			},
			{
				element: $('#pasAware'),
				content: '<span>��ʾ��ǰ�û��ѹ�ע������</span>',
				offsetX: 220,
				offsetY: 0,
				//isBeforeFuncExec: true,
				beforeFunc: function(g) {
				}
			},
			{
				element: $('#work-zone-tasks'),
				content: '<span>������ʾ����</span>',
				offsetX: 400,
				offsetY: 200,
				//isBeforeFuncExec: true,
				beforeFunc: function(g) {
				}
			},{
				element: $('.work-zone-timeLine'),
				content: '<span>����ʱ�����������ɸѡ</span>',
				offsetX: -200,
				offsetY: 20,
				//isBeforeFuncExec: true,
				beforeFunc: function(g) {
				}
			},{
				element: $('.time-line-border2'),
				content: '<span>ͨ��������Զ���һ��ʱ��Σ�����ɸѡ</span>',
				offsetX: -250,
				offsetY: 0,
				//isBeforeFuncExec: true,
				beforeFunc: function(g) {
				}
				
			}
		]
	});

}

function objClone(myObj){
    if(typeof(myObj) != 'object') return myObj;
    if(myObj == null) return myObj;
    var myNewObj = new Object();
    for(var i in myObj)
    myNewObj[i] = objClone(myObj[i]);
    return myNewObj;
}

function addNewMessage(bigtype){
	var $bigTypeObj = $("#menu_tree_"+bigtype+"_tips");
	if($bigTypeObj.css("display")=="none")$bigTypeObj.show();
	var lastCount = $bigTypeObj.html();
	if(lastCount == null || lastCount=="")lastCount = 0;
	$bigTypeObj.html(parseInt(lastCount)+1);
	var sumMessaeObjCount = window.top.document.getElementById("sumMessageCount");
	if($(sumMessaeObjCount).length>0){
		var sumMessageCount = $(sumMessaeObjCount).html();
		if(sumMessageCount == null || sumMessageCount=="")sumMessageCount = 0;
		$(sumMessaeObjCount).html(parseInt(sumMessageCount)+1)
	}
	//var lastCount = parseInt($bigTypeObj.html())+1;
}

function subMessage(bigtype,changeNumber){
	if(changeNumber == null || changeNumber == "undefined")changeNumber = 1;
	var $bigTypeObj = $("#menu_tree_"+bigtype+"_tips");
	if($bigTypeObj.css("display")=="none")return;
	var lastCount = $bigTypeObj.html();
	var newCount = parseInt(lastCount) - changeNumber;
	if(newCount <= 0)$bigTypeObj.hide();
	$bigTypeObj.html(newCount);
	var sumMessaeObjCount = window.top.document.getElementById("sumMessageCount");
	if($(sumMessaeObjCount).length>0){
		var sumMessageCount = $(sumMessaeObjCount).html();
		if(sumMessageCount == null || sumMessageCount=="")sumMessageCount = 0;
		sumMessageCount = parseInt(sumMessageCount) - changeNumber;
		sumMessageCount = sumMessageCount <= 0 ? 0:sumMessageCount;
		$(sumMessaeObjCount).html(sumMessageCount)
	}
}

Array.prototype.clone=function(){//Ϊ������ӿ�¡��������ʹ�õݹ�����ڶ༶����
    var newArr=new Array();
    for(var i=0;i<=this.length-1;i++){
       var itemi=this[i];
       if(itemi.length && itemi.push) itemi= itemi.clone();//������󣬽��еݹ�
       else if(typeof(itemi)=="object") itemi=objClone(itemi);//����������������objClone������¡
       newArr.push(itemi);
    }
    return newArr;
};