<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�б�</title>
	</head>
	<script type="text/javascript">
	function frame(url){
		var arr = new Array();
		arr = url.split('=');
		var r=confirm("ȷ����������Ŀ�𣿽����󣬽������ٻָ���");
		if(r==true){
			var w=confirm("���ȷ�������𣿽���������δ���������ͽ���״̬����������ϵͳ��");
			if(w==true){
				var e=confirm("ȷ�������� ��Ҫ������˵���飡����ȷ��������������");
				if(e==true){
					window.location='ProjBaseAction_getBusniess_Theend.action?projNo='+arr[1];
				}
			}
		}
		
	}
	
	$(document).ready(function(){
		var index = 0;
		$("#tablist tr").each(function(){
			var $cell = $(this).children().eq(8);
			var isFlag = $cell.html();
			if(isFlag =="��"){
				$cell.html("");
				$cell.append('<img src="<%=request.getContextPath()%>/creditapp/proj/imgs/flag.png">');
			}else{
				if(index >0){
					$cell.html("");
					$cell.append('<img src="<%=request.getContextPath()%>/creditapp/proj/imgs/flag5.png">');

				}
			}
			index ++;
		});
	});
	</script>
	<body class="body_bg">
	<s:form method="post" theme="simple" name="cms_form"
		action="ProjBaseAction_findByPage.action">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<table width="100%" align="center" class="searchstyle">
							<tr>
								<td>
									<dhcc:formTag property="formproj0001" mode="query" />
								</td>
							</tr>
						</table>
						<div class="tools_372">
							<dhcc:button value="��ѯ" action="��ѯ" commit="true"
								typeclass="btn_80" ></dhcc:button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<p class="p_blank">&nbsp;</p>
		<input type="hidden" id="selBrNo">
		<input type="hidden" id="selBrName">
		<input type="hidden" id="selProjNo">
		<input type="hidden" id="selProjId">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<div class="tabCont">
							<div class="tabTitle">������Ŀ����</div>
							<dhcc:button value="����" action="����" typeclass="t_ico_tj"
								onclick="ProjBaseAction_input.action"></dhcc:button>
								
							<%--<dhcc:button value="ͬ��" action="ͬ��" typeclass="t_ico_tj"
								onclick="ProjBaseAction_merge.action"></dhcc:button>--%>
						</div>
						<input type = "hidden" name="brNo" />
						<dhcc:tableTag paginate="projBaseList" property="tableproj0001" head="true" />
					</div>
				</div>
			</div>
		</div>
	</s:form>
	<script type="text/javascript">
	function getmes(url){
  var projNo = url.split("?")[1].split("&")[1].split("=")[1];
  if(!projNo){
  sAlert("������ ����->��Ŀ��Ϣ �в�¼С΢��Ŀ��ţ�");
  return false;
  }else{
  func_cif_pop(url);
  }
}
	function funcSelectBrnoPop(url){
		var valueStr=url.split("?")[1].split("&");
		var projNo=valueStr[1].split("=")[1];//��ȡ��Ŀ���
		var brNo=valueStr[2].split("=")[1];//��ȡ������
		var projId=valueStr[0].split("=")[1];//��ȡ��ͨID
		//��Ŀ��� Ϊ�յ�ʱ����Ҫ���ж���Ŀ��Ž�������
		if(!projNo){
		 sAlert("������ ����->��Ŀ��Ϣ �в�¼С΢��Ŀ��ţ�");
		 return false;
		}
		//�жϵ�ǰ����Ŀ�Ƿ�����˺���������ţ����Ѿ���������Ŀ��ţ����ܽ��ж��ι���
		if(brNo){
	    sAlert("����Ŀ�Ѿ��������Ϊ�� "+brNo+" �ĺ�������");
	    return false;
	    }
	    document.getElementById("selProjNo").value = projNo;
	    document.getElementById("selProjId").value = projId;
		var strs = new Array();
		//var strs = showModalDialog(url, window, "dialogWidth=60;dialogHeight=30;resizable=no;scrollbars=no;status:no;help:no;");
	    var strs = showNewDailogWindow(url,false,null,null,"dialogWidth=60;dialogHeight=30;resizable=no;scrollbars=no;status:no;help:no;");
		var isIe = true;
		var agent = navigator.userAgent.toLowerCase();
		if (agent.indexOf("chrome") > 0 || agent.indexOf("firefox") > 0) {
			isIe = false;
		}
		if(isIe){
			relateBr(strs,projId);
		}
	}
	function relateBr(strs,projId){
		
	    var brNo;
	    var brName;
	    var projNo;
	    var projId;
	    if(strs){
	   		brNo = strs[0];
	    	brName = strs[1];
	    	projNo = document.getElementById("selProjNo").value;
	    	projId = document.getElementById("selProjId").value;
	    }else{
	    	brNo = document.getElementById("selBrNo").value;
	    	brName = document.getElementById("selBrName").value;
	    	projNo = document.getElementById("selProjNo").value;
	    	projId = document.getElementById("selProjId").value;
	    }
	    $.ajax({
	   		type:"POST",
	   		url:"<%=request.getContextPath()%>/ProjBaseAction_relateBr.action?projNo="+projNo+"&brNo="+brNo+"&brName="+brName+"&projId="+projId,
	   		success:function(data){
	   			if(data != null && data != "" && data != "undefined"){
	   				var resultArr = data.split("|");
	   				alert(resultArr[1]);
	   				if(resultArr[0]=="success")window.location.href="ProjBaseAction_findByPage.action";
	   			}
	   		}
	   	});
	   	}
	</script>
	</body>
</html>