<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>

<%
    String path = request.getContextPath();
	//�õ����еļ�¼��ɵ��ַ���
	String trees = (String) request.getAttribute("treeJson");
	String tri_func = (String) request.getAttribute("tri_func");
	String tri_lev = (String) request.getAttribute("tri_lev");
	String select_type = (String) request.getAttribute("select_type");
	String parms = (String) request.getAttribute("parms");
	String call_func = request.getParameter("call_func");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge" >
<%@ include file="/include/tld.jsp"%>
<title>ͨ��ѡ����</title>
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/creditapp/ztree/css/zTreeStyle.css"
    type="text/css">
<script type="text/javascript"
    src="<%=request.getContextPath()%>/creditapp/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
    src="<%=request.getContextPath()%>/creditapp/ztree/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript"
    src="<%=request.getContextPath()%>/creditapp/ztree/js/jquery.ztree.exedit-3.5.js"></script>
<style type="text/css">
.contextMenu {
    visibility: hidden;
    z-index: 500;
    position: absolute;
    display: block;
    top: 141px;
    left: 196px;
}

.contextMenu ul {
    border-bottom: #999 1px solid;
    border-left: #999 1px solid;
    padding-bottom: 1px;
    background-color: #fff;
    list-style-type: none;
    margin: 0px;
    padding-left: 1px;
    width: 120px;
    border-top: #999 1px solid;
    border-right: #999 1px solid;
    padding-top: 1px;
}

.contextMenu ul li {
    border-bottom: #fff 1px solid;
    border-left: #fff 1px solid;
    padding-bottom: 3px;
    margin: 0px 0px 0px 0px;
    padding-left: -20px;
    display: block;
    color: #000;
    border-top: #fff 1px solid;
    cursor: pointer;
    border-right: #fff 1px solid;
    padding-top: 3px;
}

.contextMenu ul li:hover {
    background-color: #D6E7FF;
}
</style>
</head>
<body onkeydown="if(event.keyCode==13)event.keyCode=9">
    <div class="right_bg_f" class="body_bg">
        <div class="right_bg">
            <div class="right_w">
                <div class="from_bg">
                    <div class="right_v">
                        <s:form action="#" theme="simple">
                            <table width="100%" border="0"
                                bordercolor="#1759AF" cellspacing="0"
                                cellpadding="0" align="center">
                                <%
                                    if("2".equals(select_type)){//��ѡ
                                %>
                                <tr>
                                    <td>
                                        <input type="button" value="ȷ��" onclick="setSelectValue('<%=parms%>');" class="t_ico_tj"/>
                                    </td>
                                </tr>
                                <%}%>
                                
                                <tr>
                                    <td>
                                        <ul>
                                            <div class="zTreeDemoBackground left">
                                                <ul id="treeDemo" class="ztree">
                                                </ul>
                                            </div>
                                        </ul>
                                    </td>
                                </tr>
                            </table>
                        </s:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

<script type="text/javascript" charset="GBK">
	var setting = {
		edit : {
			enable : false,
			showRemoveBtn : false,
			showRenameBtn : false
		},
		data : {
			key : {
			},
			simpleData : {
				enable : true,
				idKey: "id",
				pIdKey: "pId",
				rootPId: "-1"
			}
		},
		<%if("2".equals(select_type)){%>
		check: {
	������������enable: true,
	  ����		chkStyle:"checkbox",
	������������radioType: "all",
	������������chkboxType:{ "Y":"ps","N":"ps"}
	������},
	    <%}%>
		callback : {
			onDblClick : <%=tri_func%>
		}
	};

	
	var triLev = "<%=tri_lev%>";
	var parms = "<%=parms%>";
	var selectType = "<%=select_type%>"; 
	var call_func = "<%=call_func%>";
	function onDblClick (event, treeId, treeNode, clickFlag) {
		if(triLev.indexOf('c')>-1){
		   if(!treeNode.isParent){//ֻ��ѡû���ӽڵ�Ľڵ�
		   		setOpenrValue(parms,treeNode);
		   }else{
		        return;
		   }
		}
		if(triLev.indexOf(treeNode.level+1)>-1) {
			setOpenrValue(parms,treeNode)
		}
	}

	function deleteNull(strResult) {
		if (strResult == "null")
			return "";
		return strResult;
	}

	$(document).ready(function() {
		var zNodes = <%=trees%>;
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});
	
	function setOpenrValue(params,treeNode){
		var doc;
		var win;
		if(window.dialogArguments == null){//ʹ��window.open�ķ�ʽ�����´���ʱȡ�ø�����
			doc = window.opener.document;
			win = window.opener;
		}else{//ʹ��window.showModalDialog�ķ�ʽ�����´���ʱȡ�ø�����
			doc = dialogArguments.document;
			win = dialogArguments;
		}
		if (""!=params&& params!=null) {
			var params_arr = params.split(",");
			for (var i=0 ;i<params_arr.length;i++) {
				
				if('id'==params_arr[i].split("-")[1]) {
					//if(!!doc.getElementsByName(params_arr[i].split("-")[0]).value)
					doc.getElementsByName(params_arr[i].split("-")[0])[0].value=treeNode.id;
				}
				if('name'==params_arr[i].split("-")[1]) {
					//if(!!doc.getElementsByName(params_arr[i].split("-")[0]).value)
					doc.getElementsByName(params_arr[i].split("-")[0])[0].value=treeNode.name;
				}
			}
		}
		if(call_func && call_func!="null" && call_func!="undefined"){
			eval("win."+call_func+"()");
		}
		window.close();
	}
	function setSelectValue(params){
		var doc;
		if(window.dialogArguments == null){//ʹ��window.open�ķ�ʽ�����´���ʱȡ�ø�����
			doc = window.opener.document;
		}else{//ʹ��window.showModalDialog�ķ�ʽ�����´���ʱȡ�ø�����
			doc = dialogArguments.document;
		}
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		var sNodes = treeObj.getCheckedNodes(true);
		var sid = "";
		var sname = "";
		if (sNodes.length > 0) {
			for(var i=0;i<sNodes.length;i++){
				if (i==sNodes.length-1) {
					sid += sNodes[i].id;
	    			sname += sNodes[i].name;
				} else {
					sid += sNodes[i].id+"@";
	    			sname += sNodes[i].name+"@";
				}
			}
		}
		if (""!=params&& params!=null) {
			var params_arr = params.split(",");
			for (var i=0 ;i<params_arr.length;i++) {
				if('id'==params_arr[i].split("-")[1]) {
					doc.getElementsByName(params_arr[i].split("-")[0])[0].value=sid;
				}
				if('name'==params_arr[i].split("-")[1]) {
					doc.getElementsByName(params_arr[i].split("-")[0])[0].value=sname;
				}
			}
		}
		window.close();
	}
</script>
</html>
