/**
 * Created by jzh on 2015/1/22.
 */
/*��ʾ��
 * ����  1.��ʾ����Ϣ  2.��ʾ������
 * */
function GenerateHtml(type,msg,title){
    if(title==""||title===undefined){
        title="��ʾ��Ϣ";
    }
    var ghtml = "";
    ghtml+='<div class="modal fade bs-example-modal-sm" id="myAlert" tabindex="-1" role="dialog" aria-hidden="true">'+
    '<div class="modal-dialog modal-sm" style="width: 400px;">'+
    '<div class="modal-content">'+
    '<div class="modal-header">'+
    '<button type="button" class="close"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>'+
    '<h4 class="modal-title" style="color: black;font-size: 18px;">'+title+'</h4>'+
    '</div>'+
    '<div class="modal-body" style="color: black;font-size: 16px;">'+msg+'</div>'+
    '<div class="modal-footer">'+
    '<button type="button" class="btn btn-default alertConfirm">ȷ��</button>';
    if(type=="confirm"){
        ghtml+='<button type="button" class="btn btn-default alertClose">ȡ��</button>';
    }
    ghtml+='</div>'+
    '</div>'+
    '</div>'+
    '</div>';
    $("body").append(ghtml);
    $("#myAlert").modal({
        backdrop:false,
        show:true,
        keyboard: false
    });
    $("body").append("<div class='modal-backdrop modal-backdrop1 fade in'></div>");
}
function ChooseHtml(msg,title,chooseNameArr){
    if(title==""||title===undefined){
        title="��ʾ��Ϣ";
    }
    var ghtml = "";
    ghtml+='<div class="modal fade bs-example-modal-sm" id="myAlert" tabindex="-1" role="dialog" aria-hidden="true">'+
        '<div class="modal-dialog modal-sm">'+
        '<div class="modal-content">'+
        '<div class="modal-header">'+
        '<button type="button" class="close"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>'+
        '<h4 class="modal-title">'+title+'</h4>'+
        '</div>'+
        '<div class="modal-body">'+msg+'</div>'+
        '<div class="modal-footer">';
        for(var i=0;i<chooseNameArr.length;i++){
            ghtml+='<button type="button" class="btn btn-default" id="alertChoose_'+i+'">'+chooseNameArr[i]+'</button>';
        }
        ghtml+='<button type="button" class="btn btn-default alertClose">ȡ��</button>';
        ghtml+='</div>'+
    '</div>'+
    '</div>'+
    '</div>';
    $("body").append(ghtml);
    $("#myAlert").modal({
        backdrop:false,
        show:true,
        keyboard: false
    });
    $("body").append("<div class='modal-backdrop modal-backdrop1 fade in'></div>");
}
function myAlertConfirm(callback){
    $("#myAlert .alertConfirm").click(function(){
        $("#myAlert").modal("hide");
        $(".modal-backdrop1").remove();
        $("#myAlert").remove();
        if(typeof(callback) == 'function'){
            callback();
        }
        //$("body").css("overflow","");
    });
}
function myAlertChooseConfirm(callbackArr){
    for(var i=0;i<callbackArr.length;i++){
        var chooseStr = "#myAlert #alertChoose_"+i;
        $(chooseStr).click(function(e){
            var callBackNo =$(this).attr("id").split("_")[1];
            $("#myAlert").modal("hide");
            $(".modal-backdrop1").remove();
            $("#myAlert").remove();
            if(typeof(callbackArr[callBackNo]) == 'function'){
                callbackArr[callBackNo]();
            }
        });
    }
	//$("body").css("overflow","");
}

function myAlertCancel(){
    $("#myAlert .alertClose,#myAlert .close").click(function(){
        $("#myAlert").modal("hide");
        $(".modal-backdrop1").remove();
        $("#myAlert").remove();
       // $("body").css("overflow","");
    });
}
$(function(){
    $.myAlert = {
        Alert:function(msg,title){
            GenerateHtml("alert",msg,title);
            myAlertConfirm();
            myAlertCancel();
        },
        Confirm:function(msg,title,callback){
            GenerateHtml("confirm",msg,title);
            myAlertConfirm(callback);
            myAlertCancel();
        },
        Choose:function(msg,title,chooseNameArr,callbackArr){
            ChooseHtml(msg,title,chooseNameArr);
            myAlertChooseConfirm(callbackArr);
            myAlertCancel();
        }
    };
});
function myAlert(msg){
	$.myAlert.Alert(msg,"��ʾ��Ϣ");
}

//��дalert
var oldAlert = window.alert;
window.alert = function(msg,type,fun1,fun2){
    if(typeof(type)!="undefined"){
    	switch(type){
	    	case 0:
	    		window.top.alert(msg,0);
	    	  break;
	    	case 1:
	    		window.top.alert(msg,1);
	    	  break;
	    	case 2:
	    		window.top.alert(msg,2,fun1,fun2);
	    	  break;
	    	default:
	    		window.top.alert(msg);
    	}
    }else{
    	window.top.alert(msg);
    }
};