<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�б�</title>
		<script>
		function func_br(url){
		var brNo = url.split("?")[1].split("&")[1].split("=")[1];
		var brSts = url.split("?")[1].split("&")[0].split("=")[1];
		if(brSts=="00"){
		   //ͣ��״̬ ��Ϊ ����
		   var r = confirm("��ȷ��Ҫ ���� �˺���������");
		   if(r==true){
		     window.location='CorpBaseAction_valiBr.action?brNo='+brNo+'&brSts='+brSts;
		   }
		}else{
		   //����״̬ ��Ϊ ֹͣ״̬
		  var d = confirm("��ȷ��Ҫ ͣ�� �ú���������");
		  if(d==true){
		     var d = confirm("�����ȷ��Ҫ ͣ�� �ú���������");
		     if(d==true){
		      window.location='CorpBaseAction_valiBr.action?brNo='+brNo+'&brSts='+brSts;
		     }
		  }
		}
		
		
		
		
		}
		
		
		
		
		</script>
	</head>
	<body class="body_bg">
	<s:form method="post" theme="simple" name="cms_form"
		action="CorpBaseAction_findByPage.action">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<table width="100%" align="center" class="searchstyle">
							<tr>
								<td>
									<dhcc:formTag property="formcoop0001" mode="query" />
								</td>
							</tr>
						</table>
						<div class="tools_372">
							<dhcc:button value="��ѯ" action="��ѯ" commit="true"
								typeclass="btn_80"></dhcc:button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<p class="p_blank">&nbsp;</p>
		
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<div class="tabCont">
							<div class="tabTitle">������������</div>
							<dhcc:button value="����" action="����" typeclass="t_ico_tj"
								onclick="CorpBaseAction_input.action"></dhcc:button>
						</div>
							
						<dhcc:tableTag paginate="corpBaseList" property="tablecoop0001"
									head="true" />
					</div>
				</div>
			</div>
		</div>
	</s:form>
	</body>
</html>