<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�б�</title>	
	</head>
	<script type="text/javascript">
		function sub(url){
			var bl = confirm("�Ƿ�ִ�е����ʽ�ͬ��������ͬ��֮���ʽ�״̬ΪʧЧ��������Ϣ��ſ���Ч��");
			if(bl){
			var params = url.split("?")[1].split("&");
		    var fundNo = null;
		    var projNo = null;
		    for(var index in params){
		    	if(params[index].split("=")[0] == "fundNo" && params[index].split("=").length == 2){
		    		fundNo = params[index].split("=")[1];
		    	}
		    	if(params[index].split("=")[0] == "projNo" && params[index].split("=").length == 2){
		    		projNo = params[index].split("=")[1];
		    	}
		    }
			document.cms_form.action="FundBaseAction_syncSingle.action?syncfundNo="+fundNo+"&syncprojNo="+projNo;
			document.cms_form.submit();
			}else{
				return false;
			}
		}
	</script>
	<body class="body_bg">
	<s:form method="post" theme="simple" name="cms_form"
		action="FundBaseAction_findByPage.action">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<table width="100%" align="center" class="searchstyle">
							<tr>
								<td>
									<s:if test="formSts==1">
										<dhcc:formTag property="formfund0005" mode="query" />
										<input name="formSts" value="1" type="hidden"/>
									</s:if>
									<s:else>
										<dhcc:formTag property="formfund0001" mode="query" />
									</s:else>
									
								</td>
							</tr>
						</table>
						<div class="tools_372">
							<dhcc:button value="��ѯ" action="��ѯ" commit="true"
								typeclass="btn_80"></dhcc:button>
							<dhcc:button typeclass="btn_80" value="����" action="����" onclick="FundBaseAction_input.action"></dhcc:button>	
						<!--	<dhcc:button typeclass="btn_80" value="��Ŀ�ʽ�ͬ��" action="ͬ��" onclick="jump_fund_base()"></dhcc:button>	 -->
							<dhcc:button typeclass="btn_80" value="�����˻�" action="�����˻�" onclick="ProjBaseAction_account_getAllDetail.action" param="projNo=projNo"></dhcc:button>	
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
							<div class="tabTitle">�ʽ�̨��</div>
						</div>
							
						<dhcc:tableTag paginate="fundBaseList" property="tablefund0001"
									head="true" />
					</div>
				</div>
			</div>
		</div>
	</s:form>
	<input id="formSts" value="<s:property value="formSts"/>" type="hidden">
	</body>
	<script type="text/javascript">
	 function jump_fund_base() {
		 var bl = confirm("�Ƿ�ִ����Ŀ�ʽ�ͬ��������ͬ��֮���ʽ�״̬ΪʧЧ��������Ϣ��ſ���Ч��");
		 if(bl){
		 	 var projNo = document.getElementsByName("projNo")[0].value;
			 var formSts = document.getElementById("formSts").value;
			 if(projNo == null || projNo == undefined || projNo == ''){
				sAlert("δѡ����Ŀ��ţ�");
				return false;
				}
				window.location = "FundBaseActionSync.action?projNo="+projNo+"&formSts="+formSts;
		 }else{
		 	return false;
		 }
		}
	</script>
</html>