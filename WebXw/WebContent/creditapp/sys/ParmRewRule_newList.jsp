<%@ page language="java" contentType="text/html; charset=GBK" import="app.creditapp.sec.entity.PasswordRegexp"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<%
	String 	checkRegIndex = (String)request.getParameter("checkRegIndex");
%>
<html>
	<head>
		<title></title>
	</head>
	<script type="text/javascript">
		function updateAuditValue(url,itemNo){
			var codeType=$("#codeType").val();
			var value =null;
			if(itemNo == '1'){
				value = "";
				$("input[name='passRegxp']:checked").each(function(){
					value = value+ $(this).val()+"@";
				})
			}else{
				if($("#value_"+itemNo)[0]){
					value = $("#value_"+itemNo).val();
				}else{
					value=$("input[name=value_"+itemNo+"]:checked").val()
				}
			}
			$.post(url, 
				{itemValueStr:value,itemNo:itemNo,codeType:codeType},function(data) {
					if(data.substring(0,4)=="SUCC"){
						alert("����ɹ�");	
					}else{
						alert(data);	
					}
			});
		}
	</script>
	<body class="body_bg">

		<s:form method="post" theme="simple" name="cms_form"
		action="ParmRewRuleAction_findByPage.action">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<table width="100%" align="center" class="searchstyle">
							<tr>
								<td>
									<dhcc:formTag property="formsys0016" mode="query" />
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
							<div style="vertical-align: bottom;" class="tabCont">
								<div style="float: left" class="tabTitle">
									��ȫѡ��������Ϣ�б�
								</div>
							</div>
							<table id="tablist" width="100%" border="0"   align="center" cellspacing="1" class="ls_list">
								<colgroup></colgroup>
								<colgroup></colgroup>
								<colgroup></colgroup>
								<colgroup></colgroup>
								<colgroup></colgroup>
								<colgroup></colgroup>
								<colgroup></colgroup>
								<thead> 
									<tr> 
										<th scope="col"  align="center">������</th>
										<th scope="col"  align="center">��������</th>
										<th scope="col"  align="center">������ռ���</th>
										<th scope="col"  align="center">��Ӧ�洢����</th>
										<th scope="col"  align="center">��������</th>
										<th scope="col"  align="center">�Ƿ�����</th>
										<th scope="col" colspan="2" align="center" > <font class="button_color">����</font></th>
									</tr>
								</thead>
								<tbody id="tab"> 
								<input type="hidden" name="codeType" value='<s:property value="codeType"/>' id="codeType"/>
									<s:iterator value="#request.auditlist" id="sec">
									<tr >
										<td align="left"><span style="padding-left: 25px"><s:property value="ruleId"/></span>  </td>
										<td align="left"><span style="padding-left: 25px"><s:property value="ruleDesc"/></span>  </td>
										<td align="center"><s:if test="riskLev==01">��ʾ</s:if><s:else>����</s:else> </td>
										<td align="center"><span style="padding-left: 25px"><s:property value="opProc"/></span>  </td>
										<td align="center"><s:if test="sceneNo==01">Ԥ����</s:if><s:else>��ʽ����</s:else> </td>
										<td align="center"><s:if test="ruleSts==1">����</s:if><s:else>ͣ��</s:else> </td>
										<td align="center"><a href="SecurityAuditAction_updateRuleSts.action?ruleId=<s:property value="ruleId"/>&ruleSts=<s:property value="ruleSts"/>" class="abatch">��/ͣ ��</a></td>
										<td align="center"><a href="ParmRewRuleAction_getById.action?ruleId=<s:property value="ruleId"/>" class="abatch">�޸�</a></td>
					<!--					<td align="center"><a href="javascript:void(0);" onclick="javascript:updateAuditValue('SecurityAuditAction_updateAuditInfo.action','<s:property value="itemNo"/>')" class="abatch">ɾ��</a></td>        -->
									</tr>
									</s:iterator>
								 </tbody> 
								</table>
						</div>
					</div>
				</div>
			</div>
		</s:form>	
	</body>
</html>