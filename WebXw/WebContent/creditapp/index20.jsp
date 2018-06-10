<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@page import="app.base.PUBParm,app.util.User" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!--
	��ȡ���ݿ��б�sys_user�е�skin��value--��color������Ϊ����themeΪcolor��ֵ������themeΪyellow	
-->
<%
	Object themeObj = session==null?null:session.getValue("color");
	String theme = (themeObj==null||"".equals(themeObj))?"yellow":((String)themeObj);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>С΢�����Ŵ�����ϵͳ</title>
<!-- 
<meta http-equiv="X-UA-Compatible" content="IE=8" />
 -->
 
<meta http-equiv="X-UA-Compatible" content="IE=Edge" >
<script src="../themes/js/jquery-1.8.0.min.js" language="javascript" type="text/javascript" ></script>
<script src="../themes/js/jquery-ui-1.10.1.custom.min.js" language="javascript" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/creditapp/workMessage/pushMessage/js/notify.js"></script>
<link href="../themes/css/main.css" type="text/css" rel="stylesheet" />

<!--
	��ȡ�����theme���Ӷ�����css��ʹ��ҳ���ϵı�����ɫ����һ��
-->
<link href="../themes/theme_<%=theme %>/Css/sysUI_<%=theme %>.css" type="text/css" rel="stylesheet" />
<link href="../themes/jqueryUI/smoothness/jquery.ui.theme.css" type="text/css" rel="stylesheet" />
<link href="../themes/jqueryUI/smoothness/jquery.ui.core.css" type="text/css" rel="stylesheet" />
<link href="../themes/jqueryUI/smoothness/jquery.ui.dialog.css" type="text/css" rel="stylesheet" />
<link href="../themes/jqueryUI/smoothness/jquery.ui.button.css" type="text/css" rel="stylesheet" />
<link href="<%=request.getContextPath() %>/creditapp/a2b/animations.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/creditapp/a2b/components.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/creditapp/workMessage/pushMessage/css/notify.css">
<script type="text/javascript">
function changeDivHeight(){
	$(".sysMenuBody").width($(".header").width() - 391);
	$("#contFrame").attr("height", ($(window).height()-62)+"px");
	$("#messageFrame").attr("height", ($(window).height()-62)+"px");
}

window.onresize=function(){  
	changeDivHeight();
};  

var talkStatus= "";
	$(document).ready(function(){
		$("#sysSet").hover(function(){
			$(".sysSetList").slideDown("fast");
		}, function() {
			$(".sysSetList").fadeOut("fast");
		});
		$(".sysQuit").click(function(){
			window.top.location.href = "<%=request.getContextPath() %>/creditapp/logout.action";
		});
		
		changeDivHeight();
		$(".sysMenuBody a").click(function(){
			$(".sysMenuBody").find("a").removeAttr("class");
			$(this).attr("class","sysMenuBodyDown");
			$("#contFrame").focus();
		});	
		//-------------ϵͳƤ������-------------------------
 		$("#skin").click(function(){
			$( "#dialog-skin" ).dialog("open");
		});
					
		$("#dialog-skin").dialog({
			autoOpen: false,
			resizable: false,
			width:370,
			height:150,
			modal: true
		});
		/**ԭ�е�ȷ����ť����true֮��
		,
			buttons: {
				"ȷ��": function() {
					$(this).dialog("close");
					$(".skin_color li").each(function(){
						if($(this).attr("class") && $(this).attr("class").indexOf("current")>=0){
							window.location.href="updateSkin.action?color="+$(this).attr("alt");
							return false;
						}
					});
				},
				"ȡ��": function() {
					$( this ).dialog( "close" );
				}
			}
		*/
		//------------------�����޸�----------------------------
		function showPwdMsg(str){
			$("#pwd-msg-note").text(str);
			$("#pwd-msg-note").show("normal",function(){
				setTimeout(function(){
					$("#pwd-msg-note").hide("slow",null);
				},2000);
			});
		}
		$("#dialog-pwd").dialog({
			autoOpen: false,
			resizable: false,
			width:370,
			height:220,
			modal: true,
			buttons: {
				"ȷ��": function() {
					var opwd_2013 = document.getElementById("opwd_2013").value;
					var npwd_2013 = document.getElementById("npwd_2013").value;
					var dnpwd_2013 = document.getElementById("dnpwd_2013").value;
					if(opwd_2013 == ""){
						showPwdMsg("�������ԭ����Ϊ��,�����޸�!");
						return false;
					}
					if(npwd_2013.length < 6){
						showPwdMsg("�����벻������6���ַ�!");
						return false;
					}
					if(opwd_2013 == npwd_2013){
						showPwdMsg("�����벻�ܺ�ԭ������ͬ!");
						return false;
					}
					if(npwd_2013 != dnpwd_2013){
						showPwdMsg("��������������ȷ�����벻һ��,�����޸�!");
						return false;
					}
					$.ajax({
				   		type:"POST",
				   		url:"<%=request.getContextPath()%>/SysUserAction_changePwdByAjax.action",
				   		data:"changePWInfo="+opwd_2013+"/"+npwd_2013+"/"+dnpwd_2013,
				   		success:function(data){
				   			if(data != null && data != "" && data != "undefined" && data == "changeOK"){
				   				alert("�����޸ĳɹ�,��ʹ�����������µ�¼!");
				   				window.top.location.href = "<%=request.getContextPath() %>/creditapp/logout.action";
				   			} else {
				   				showPwdMsg(data);
				   			}
				   		}
				   	});
					
				},
				"ȡ��": function() {
					$(this).dialog("close");
				}
			}
		});
		$("#changepwd").click(function(){
			var msg = '<table style="position:relative; left:40px;top:20px"> ' +
			  '<tr><td width="80" style="font:12px   Verdana,   Geneva,   Arial,   Helvetica,   sans-serif;color:black">ԭ����</td><td><input id="opwd_2013" type="password" maxlength="20" size="25"/></td></tr>' +
			  '<tr><td style="font:12px   Verdana,   Geneva,   Arial,   Helvetica,   sans-serif;color:black">������</td><td><input id="npwd_2013" type="password" maxlength="20" size="25"/></td></tr>' +
			  '<tr><td style="font:12px   Verdana,   Geneva,   Arial,   Helvetica,   sans-serif;color:black">ȷ��������</td><td><input id="dnpwd_2013" type="password" maxlength="20" size="25"/></td></tr>' +
			  '<tr><td colspan="2" align="center"><span id="pwd-msg-note" style="display: none;color:#ff3424;text-align:center;"></span></td></tr></table>';
			$("#dialog-pwd").html(msg);
			$("#dialog-pwd").dialog("open")
		});	
		
		//------------------ϵͳ����----------------------------
		var locked = false;
		var lockPwd = null;
		function showLockMsg(str){
			$("#lock-msg-note").text(str);
			$("#lock-msg-note").show("normal",function(){
				setTimeout(function(){
					$("#lock-msg-note").hide("slow",null);
				},2000);
			});
		}
		function func_lock(){
			$(document.body).append("<div class='ui-widget-overlay' style='z-index:20;' id='lock-bg-div'></div>");
			$("#lock-name").text("�����������:");
			$("#lockPwdInput").val("");
			locked = true;
		}
		function func_unlock(){
			$("#lock-bg-div").remove();
			$("#lock-name").text("������������:");
			$("#lockPwdInput").val("");
			locked = false;
		}
		$("#dialog-lock").dialog({
			autoOpen: false,
			resizable: false,
			closeOnEscape: false,
			width:370,
			height:170,
			modal: true,
			close:function(){
				if(locked){
					setTimeout(function(){
						if(locked){
							$("#dialog-lock").dialog("open");
						}
					},2000);
				}
			},
			buttons: {
				"ȷ��": function() {
					var lockPwdInput = $("#lockPwdInput").val();
					if(locked){
						if(lockPwdInput && lockPwdInput.length>0){
							if(lockPwdInput==lockPwd){
								func_unlock();
								$("#dialog-lock").dialog("close");
							}else {
								showLockMsg("�������벻��ȷ,����������!");
							}
						}else {
							showLockMsg("�������������!");
						}
					}else {
						if(lockPwdInput && lockPwdInput.length>0){
							lockPwd = lockPwdInput;
							locked = true;
							func_lock();
						}else {
							showLockMsg("��������������!");
						}
					}
				}
			}
		});
		$("#lockScreen").click(function(){
			var msg = '<table style="position:relative; left:40px;top:20px"> ' +
			  '<tr><td width="80" style="font:12px Verdana,Geneva,Arial,Helvetica,sans-serif;color:black" id="lock-name">������������:</td><td><input id="lockPwdInput" type="password" maxlength="20" size="25"/></td></tr>' +
			  '<tr><td colspan="2" align="center"><span id="lock-msg-note" style="display: none;color:#ff3424;text-align:center;"></span></td></tr></table>';
			$("#dialog-lock").html(msg);
			$("#dialog-lock").dialog("open")
		});	
		
		//----------------------------------------------------
		$("#dialog-msg").dialog({
			autoOpen: false,
			resizable: false,
			draggable: true,
			width:370,
			height:160,
			modal: true,
			position: {
				my: "center",
				at: "center",
				of: window,
				collision: "fit",
				// Ensure the titlebar is always visible
				using: function(pos) {
					var topOffset = $(this).css(pos).offset().top;
					if (topOffset < 0) {
						$(this).css("top", pos.top-topOffset);
					}
				}
			},
			buttons: {
				"�ر�": function() {
					$(this).dialog( "close" );
				}
			}
		});
//-------------ϵͳ��ɫѡ���¼�-------------------------
		$(".skin_color li").click(function(){
			$(".skin_color li").removeClass();
			$(this).addClass("current");
		});
	});
	
	function changeColor() {
			$("#dialog-skin").dialog("close");
			$(".skin_color li").each(function(){
				if($(this).attr("class") && $(this).attr("class").indexOf("current")>=0){
					var color = $(this).attr("alt");
					$.ajax({
				   		type:"POST",
				   		url:"<%=request.getContextPath()%>/SysUserAction_changeSkin.action?color="+color,
				   		success:function(data){
				   			if(data != null && data != "" && data != "undefined" && data == "success"){
				   				window.location.reload();
				   			} else {
				   				showPwdMsg(data);
				   			}
				   		}
				   	});
				}
			});
	}
//-------------------------��ʼ������-----------------------
</script>
</head>
<body >
<div id="dialog-skin" title="ϵͳƤ������" style="display: none;">
	<ul class="skin_color">
		<li ondblclick="changeColor()" alt="yellow"<%if("yellow".equals(theme)){%> class="current"<%} %>><a href="javascript:void(0);" style="background:#FC9F17;">����</a></li>
		<li ondblclick="changeColor()" alt="blue"<%if("blue".equals(theme)){%> class="current"<%} %>><a href="javascript:void(0);" style="background:#004a8e;">������</a></li>
		<li ondblclick="changeColor()" alt="pink"<%if("pink".equals(theme)){%> class="current"<%} %>><a href="javascript:void(0);" style="background:#f27ca0;">��Ů��</a></li>
		<li ondblclick="changeColor()" alt="red"<%if("red".equals(theme)){%> class="current"<%} %>><a href="javascript:void(0);" style="background:#FE007F;">õ���</a></li>
	</ul>
	
</div>
<div id="dialog-msg" title="ϵͳ��ʾ" style="display: none;text-align:left;white-space:normal;width:370px;">
</div>
<div id="dialog-pwd" title="�����޸�" style="display: none;text-align:left;white-space:normal;width:370px;">
</div>
<div id="dialog-lock" title="������Ļ" style="display: none;text-align:left;white-space:normal;width:370px;">
</div>
<div  class="header">
  	<div class="sysLogo">
  	
  	<img src="../themes/images/nav_logo.png">
  	</div>
  	<!--<div class="sysMenuLeft"><img src="../themes/theme_<%=theme %>/images/menu_left_bg.gif"  /></div>-->
   <div class="sysMenu">
        <div class="sysMenuBody">
        	<ul class="scrol">
				<%
				   java.util.List sysMenuLev1List =(java.util.List)session.getAttribute("sysMenuLev1List");
				   String menuName = "";
					 for(int i=0;i<sysMenuLev1List.size();i++){
						 app.creditapp.sys.entity.SysMenu sysMenu= (app.creditapp.sys.entity.SysMenu)sysMenuLev1List.get(i);
				%>
	
	  			<li style="float:left;"><a<%if(i==0){ %> class="sysMenuBodyDown"<%} %> href="left.jsp?id=<%=sysMenu.getMenuNo() %>" id="el<%=i+1 %>" target="leftFrame"><i class="ico<%=sysMenu.getMenuNo() %>"></i><span><%=sysMenu.getMenuName() %></span></a></li>
				 <% } %>
			</ul>
        </div>
		
	</div>
	<div class="sysSet">
   		<div class="user" id="user" title="Ӫҵ����:<%=app.util.User.getSys_date(request) %>&#10;����Ա��:<%=app.util.User.getLoginid(request) %>&#10;�������ƣ�<%=app.util.User.getBrname(request) %>&#10;������ţ�<%=app.util.User.getBrno(request) %>">
   			<div class="nav_li_task">
       			<i style="cursor: pointer;" class="transition" data-transition="horizontal-easing"></i>
      			<span id="sumMessageCount"><%=(Integer)request.getSession().getAttribute("messageSumNumber") %> </span>
   			</div>
			<!--<span class="ico_user"></span>-->���ã�<%=app.util.User.getDisplayName(request) %>
		</div>
		<div class="sysSetBtn" id="sysSet" title="ϵͳ����">
			<ul class="sysSetList" >
				<li class="firstLi"></li>
				<li><a href="javascript:void(0)" id="skin" style="border-top:none;"><span class="ico_skin"></span>ϵͳ����</a></li>
				<li id="lockScreen"><a href="javascript:void(0)"><span class="ico_lock"></span>������Ļ</a></li>
				<li id="changepwd"><a href="javascript:void(0)"><span class="ico_pass"></span>�޸�����</a></li>
				
				<li class="lastLi"></li>
			</ul>
		</div>
		<div class="sysQuit" title="�˳�ϵͳ"></div>
	</div>
</div>

<div id="navDiv" style="position:relative;z-index: 10;opacity:0.4;display: none;overflow: visible;">
	<div class="arrow_left" ></div>
	<div class="arrow_right" style="display: none"></div>
</div>
<script type="text/javascript">
var urlA = "<%=request.getContextPath() %>/creditapp/main20.jsp" ;
var urlB = "<%=request.getContextPath()%>/AftMessageAlarmAction_showMessagePage.action";
$(document).ready(function(){
	$("#contFrame")[0].src = urlA;
	$("#messageFrame")[0].src = urlB;
	
	$(".arrow_right").bind("click",function(){
		hideLeft();
	});
	$(".arrow_left").bind("click",function(){
		hideLeft();
	});
	$("#navDiv").mouseover(function(){
		$(this).css("opacity","1");
	});
	$("#navDiv").mouseout(function(){
		$(this).css("opacity","0.4");
	});
	$("#navDiv").show("slow");
});

function hideLeft(){
	
	if($(".arrow_right").css("display") == "none"){
		window.contFrame.document.getElementById("mainFramestId").cols='0,*';
		$(".arrow_left").hide();
		$(".arrow_right").show();
	}else{
		window.contFrame.document.getElementById("mainFramestId").cols='160,*';
		$(".arrow_right").hide();
		$(".arrow_left").show();
		
	}
}

function changeAbPage(url){
	$(".transition").trigger("click");
	if(url){
		var u = window.document.getElementById("contFrame").contentWindow.document.getElementById("rightFrame");
		u.src = "../"+url;
	}
}
//������Ϣ���ֵ�js����

function messageNotify( title,messageContent) {
	$.notify({
		modal : false,//�Ƿ�ģ̬
		status : "good",//Ŀǰֻ��������״̬���ɹ�ʧ��
		title : title,//
		//position:position,//����ʱ����������λ��
		position:{
			"bottom": "10px",
			"right": "10px",
			"position":"absolute"
		},
		autoDelayClose:true,//�Ƿ��Զ��ر�
		timeout:3000,//3s���Զ��رգ������ʾ��Ҳ�����ֶ��ر�
		content : messageContent
	});
}
//websocket�������ͷ�����
<%-- var username="<%=User.getLoginid(request)%>";
var pushServerPath = "<%=(String)request.getSession().getAttribute("pushMessageServerPath")%>";
var websocket = null;
	
if("WebSocket" in window){
	//websocket = new WebSocket("ws://172.16.112.107:8087/TestWebsocket/server/"+username+"/222222");
	websocket = new WebSocket(pushServerPath);
}else{
	alert('Not support websocket');
}
websocket.onopen = function(){
	messageNotify("��ӭ����","�Ѿ������������ͷ�����");
};

websocket.onerror = function(){
	messageNotify("������Ϣ","û���������ͷ�������<br/>���ν�Ϊ����������Ϣ");
};
//�������ڹر��¼��������ڹر�ʱ������ȥ�ر�websocket���ӣ���ֹ���ӻ�û�Ͽ��͹رմ��ڣ�server�˻����쳣��
window.onbeforeunload = function(){
    websocket.close();
}
//����������Ϣ
websocket.onmessage = function(event){
	var title = "";
	var content = "";
	var sendType = "";
	var messageChangeType= "";
	
	var sendResult = event.data;
	var messageMap = sendResult.split("|");
	var keyValueMap = null;
	if(messageMap.length>0){
		for(var i=0; i<messageMap.length; i++){
			keyValueMap = messageMap[i].split(":");
			if(keyValueMap[0] == "sendType")sendType = keyValueMap[1];
			if(keyValueMap[0] == "content")content = keyValueMap[1];
			if(keyValueMap[0] == "messageType")messageChangeType = keyValueMap[1];
			if(keyValueMap[0] == "title")title = keyValueMap[1];
		}
	}
	
	if(sendType == "message"){
		document.getElementById("messageFrame").contentWindow.addNewMessage(messageChangeType);
	}
	
	messageNotify(title,content);
}

//�ر�����
function closeWebSocket(){
    websocket.close();
} --%>

</script>
<!-- 
	<iframe id="messageFrame" name="messageFrame" src="<%=request.getContextPath()%>/AftMessageAlarmAction_initMessagePage.action" width="100%" frameborder="0" scrolling="no"></iframe>
 -->
 
<%
String indexUiFlag = (String)request.getSession().getAttribute("indexUi");
%>
<div id="divA" class="page">
	<iframe id="contFrame" name="contFrame" src="" width="100%" frameborder="0" scrolling="no"></iframe>
</div>
<div id="divB" class="page">
	<iframe id="messageFrame" name="messageFrame" src="" width="100%" frameborder="0" scrolling="yes"></iframe>
</div>
<input type="hidden" name="lastUi" id="lastUi" value="<%=indexUiFlag %>" />	
<script src="<%=request.getContextPath() %>/creditapp/a2b/page-transitions.js" language="javascript" type="text/javascript"></script>
</body>
</html>
