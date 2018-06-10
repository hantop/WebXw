/**
 * ���������
 * @param {Object} url (��ҳ�������) ����
 * @param {Object} title (��ʾ��ʾ�ı���) ��ѡ�� ����Ĭ��Ϊ����ʾ��
 * @param {Object} ctrlFlag ���Ʊ�־
 * 					   ������ 1).false Ϊ�رղ�ˢ�¸�ҳ��
 * 							2).true/����  Ĭ��Ϊˢ��  
 * 						    3).����  �ر���ת����ǰ����(����Ϊaction����)
 */
window.openBigForm = function(url,title,ctrlFlag){
	var obj =  $("body");
		if(!obj.find("#bigFormShow").length>0){
			bigFromShowHtml(obj);
		}
		obj.find("#bigFormShowiframe").attr("src","");
		obj.find("#bigFormShowiframe").attr("src",url);
		if(title!=null&&title!=""){
			obj.find("#bigFormShow #myModalLabel").html(title);
		}
		obj.find("#bigFormShow").modal({
	        backdrop:false,
	        show:true,
	        keyboard: false
	    });
	    obj.find("#bigFormShow .close").unbind();
	    obj.find("#bigFormShow .close").click(function(){
	    	if(ctrlFlag!==undefined&&typeof(ctrlFlag) == "function"){
	    		ctrlFlag.call(this);
	    	}else if(ctrlFlag!==undefined&&ctrlFlag!="false"&&!ctrlFlag==false&&ctrlFlag.indexOf(".action")!=-1){
	    		ctrlFlag = ctrlFlag.replace(new RegExp("amp;","gm"),"");
	    		$(top.window.document).find(".pt-page-current").find("iframe").eq(0).attr("src",ctrlFlag);
	    	} else if(ctrlFlag===undefined||(ctrlFlag!="false"&&!ctrlFlag==false)){
	    		$(top.window.document).find(".pt-page-current").find("iframe")[0].contentWindow.location.reload();
	    	}
	    	$(this).parents("#bigFormShow").find("#bigFormShowiframe").remove();
	    	$(this).parents("#bigFormShow").remove();
	    });
}
/**
 * �����رմ��
 */
window.cloesBigForm = function(url,callback){
	if(url!==undefined&&callback===undefined&&url.indexOf(".action")!=-1){
		url = url.replace(new RegExp("amp;","gm"),"");
		$(top.window.document).find(".pt-page-current").find("iframe").eq(0).attr("src",url);
	}
	if(typeof(callback)== "function"){
		callback.call(this);
	}else if(callback!==undefined&&callback=="iframepage"){
		document.getElementById("a_iframe").contentWindow.document.getElementById("iframepage").contentWindow.location.reload();
	}
	$("#bigFormShow").find("#bigFormShowiframe").remove();
	$("#bigFormShow").remove();
}
window.reloadFream = function (obj){
	//$(top.window.document).find(".pt-page-current").find("iframe")[0].contentWindow.location.reload();
}
function bigFromShowHtml(obj){
	var showHtml = "";
		showHtml +='<div class="modal fade  bs-example-modal-lg bigFormShow" id="bigFormShow" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">';
		showHtml +='<div class="modal-dialog" role="document" style="margin:1% 5% 0 5%;width: 90%;height:95%">';
		showHtml +='<div class="modal-content" style="height:96%">';
		showHtml +='<div class="modal-header" style=" padding: 4px 10px;">';
		showHtml +='<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
		showHtml +='<h4 class="modal-title" id="myModalLabel" style="color: #1185b9;">����������Ϣ</h4>';
		showHtml +='</div>';
		showHtml +='<div class="modal-body" style="padding: 4px;height: 100%; ">';
		showHtml +='<iframe id="bigFormShowiframe" src="" style=" height: 93%; width: 100%;"></iframe>';
		showHtml +='</div>';
		showHtml +='</div>';
		showHtml +='</div>';
		showHtml +='</div>';
	 $(obj).append(showHtml);
}
function createShowDiaglogHtml(){
	var showDialogHtml = "";
		showDialogHtml+='<div class="modal fade bs-example-modal-lg showDialog" id="showDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">';
		showDialogHtml+='<div class="modal-dialog"role=" document" style="margin:auto;width:90%;">';
		showDialogHtml+='<div class="modal-content" style="height:96%">';
		showDialogHtml+='<div class="modal-header" style="padding:14px 10px;">';
		showDialogHtml+='<button type="button" class="close" data-dismiss="modal" aria-label="Close" style="margin-top:4px">';
		showDialogHtml+='<span aria-hidden="true">&times;</span>';
		showDialogHtml+='</button>';
		showDialogHtml+='<i class="i i-fukuanjihua" style="font-size:20px; color:#333; margin-right:7px"></i>';
		showDialogHtml+='<h4 class="modal-title" id="myModalLabel" style="color:#333;display:inline-block"></h4>';
		showDialogHtml+='</div>';
		showDialogHtml+='<div class="modal-body" style="padding:4px;height:calc(100%-56px);">';
		showDialogHtml+='<iframe id="showDialogiframe" name="showDialogiframe" src="" scrolling="no" style="height:calc(73%); width:100%;"></iframe>';
		showDialogHtml+='<div style="text-align:right;margin-right:25px;margin-top:5px">';
		showDialogHtml+='<button type="button" class="btn btn-default" data-dismiss="modal">�ر�</button> ';
		showDialogHtml+='<button type="button" class="btn btn-primary" id="commitButton">�ύ����</button>';
		showDialogHtml+='</div>';
		showDialogHtml+='</div>';
		showDialogHtml+='</div>';
		showDialogHtml+='</div>';
		showDialogHtml+='</div>';

	return showDialogHtml;
}

function createShowDialog(url,title,sWidth,sHeight,callback){
	var $obj = $("body");
	if(!$obj.find("#showDialog").length>0){
		var html = createShowDiaglogHtml();
		$obj.append(html);
	}
	$obj.find("#showDialog").find(".modal-dialog").css({"width":sWidth+"%","marginTop":"calc((100% - "+sHeight+"%) / 4)","height":sHeight+"%"});
	$obj.find("#showDialog").find(".modal-content").css("height","calc(100% - 35px)");
	$obj.find("#showDialogiframe").attr("src",url);
	if(title!=null&&title!=""){
		$obj.find("#showDialog #myModalLabel").html(title);
	}
	$obj.find("#showDialog").modal({
        backdrop:false,
        show:true,
        keyboard: false
    });
	
    $obj.find("#showDialog .close").unbind();
    $obj.find("#showDialog .close").click(function(){
    	if(typeof(callback)== "function"){
    		callback.call(this);
    	}else if(callback!==undefined&&callback=="iframepage"){
    		document.getElementById("a_iframe").contentWindow.document.getElementById("iframepage").contentWindow.location.reload();
    	}
    	$(this).parents("#showDialog").find("#showDialogiframe").remove();
    	$(this).parents("#showDialog").remove();
    });
}

/*
 * B�����񵯳�����
 */
function createTaskShowDialog(url,title,sWidth,sHeight,data,callback){
	var $obj = $("body");
	if(!$obj.find("#showDialog").length>0){
		var html = createShowDiaglogHtml();
		$obj.append(html);
	}
	if(typeof(data)!="undefined"){
		$obj.find("#showDialog").data("taskData",data);
	}
	$obj.find("#showDialog").find(".modal-dialog").css({"width":sWidth+"%","height":sHeight+"%"});
	$obj.find("#showDialog").find(".modal-content").css("height","calc(100% - 10px)");
	$obj.find("#showDialogiframe").attr("src","");
	$obj.find("#showDialogiframe").attr("src",url);
	if(title!=null&&title!=""){
		$obj.find("#showDialog #myModalLabel").html(title);
	}
	$obj.find("#showDialog").modal({
        backdrop:false,
        show:true,
        keyboard: false
    });
	$("#commitButton").click(function(){
		//alert("ѡ��ֵΪ:"+	window.document.getElementById('showDialogiframe').contentWindow.document.getElementById("selectValue").value);
		//alert(window.top.document.getElementById("sumMessageCount"));
		//alert(data.pasUrl);
		window.cloesShowDialog(callback);
		return false;
		
		$.ajax({
			type : "POST",
			url : 'AftMessageAlarmAction_updateMessage.action',
			dataType : "text",
			data : {
				bizPkno:data.bizPkno,
				pasSubType:data.pasMinNo,
				pasMaxType:data.pasMaxNo,
				pasNo:data.pasNo,
				relId:data.formId
			},
			success : function(result) {
				if(result == "succ")window.cloesShowDialog(callback);
				else{
					alert("����ʧ�ܣ���鿴��̨��־");
				}
			},
			error : function(xmlhq, ts, err) {
			}
		});
	});
	
	/*
    $obj.find("#showDialog .close").unbind();
    $obj.find("#showDialog .close").click(function(){
    	document.getElementById("b1_iframe").contentWindow.taskB.changeTaskSts(data);
    	$(this).parents("#showDialog").find("#showDialogiframe").remove();
    	$(this).parents("#showDialog").remove();
    });
    */
}



function taskShowDialog(url){
	createTaskShowDialog(url,"�������","99","100");
}

/**
 * ����B��رմ��
 */
window.cloesTaskBigForm = function(url){
	var flag = false;
	if($("#showDialog").length>0){
		$.ajax({
			type: "post",
			url: url,
			success: function(data) {
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
			}
		});
		var data = $("#showDialog").data("taskData");
		setTimeout(function(){
			document.getElementById("b1_iframe").contentWindow.taskB.changeTaskSts(data);
		},1000);
		$("#showDialog").find("#showDialogiframe").remove();
		$("#showDialog").remove();
		flag = true;
	}
	if(!flag){
		document.getElementById("a_iframe").src =url;
	}
};
window.cloesShowDialog = function(callback){
	if(typeof(callback)== "function"){
		callback.call(this);
	}else if(callback!==undefined&&callback=="iframepage"){
		document.getElementById("a_iframe").contentWindow.document.getElementById("iframepage").contentWindow.location.reload();
	}
	$("#showDialog").modal('hide');
	$("#showDialog").find("#showDialogiframe").remove();
	$("#showDialog").remove();
}
window.showDialog = function(url,title,sWidth,sHeight,callback){
	createShowDialog(url,title,sWidth,sHeight,callback);
}