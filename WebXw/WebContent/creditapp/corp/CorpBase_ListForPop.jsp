<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�б�</title>
		<script type='text/javascript'>
			window.name = "curWindow";
		</script>
	</head>
	<body class="body_bg">
	<s:form method="post" theme="simple" name="cms_form"
		action="CorpBaseAction_findByPageForPop.action" target="curWindow">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<table width="100%" align="center" class="searchstyle">
							<tr>
								<td>
									<dhcc:formTag property="formcoop0055" mode="query" />
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
							<div class="tabTitle">���������б�</div>
						</div>
						<dhcc:tableTag paginate="corpBaseList" property="tablecoop0055"
									head="true" />
					</div>
				</div>
			</div>
		</div>
	</s:form>
	</body>
	<script type="text/javascript">
	function selectBrno(url){
		var valueStr=url.split("?")[1].split("&");
		var brNo=valueStr[0].split("=")[1];//
		var brName=valueStr[1].split("=")[1];
		 var r = confirm("��ȷ��Ҫ������Ϊ"+brNo+"�ĺ���������");
		  if(r==true){
		    var b = confirm("�����Ҫ������Ϊ"+brNo+"�ĺ���������");
		      if(b==true){
		         var u = confirm("����ȷ��Ҫ������Ϊ"+brNo+"�ĺ��������𣿹������ܽ����޸ģ�");
		           if(u==true){
		            var sts = new Array();
					sts[0]=brNo;
					sts[1]=brName;
					if(window.dialogArguments){
						window.returnValue=sts;
						sAlert("222");
					}else{
						window.opener.document.getElementById("selBrNo").value = brNo;
						window.opener.document.getElementById("selBrName").value = brName;
						window.opener.relateBr();
						sAlert("333");
					}
				    window.close();
		           }
		      }
		  }
		
	}
	</script>
</html>