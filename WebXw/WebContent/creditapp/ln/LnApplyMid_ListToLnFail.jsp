<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�б�</title>
		<script type="text/javascript">
			function chkBrNo(){
				var brNo = document.getElementsByName("brNo")[0].value;
				if(brNo == ''){
					sAlert("��������������Ž��в�ѯ!");
					return false;
				}
				cms_form.submit();
			}
		</script>
	</head>
	<body class="body_bg">
	<s:form method="post" theme="simple" name="cms_form"
		action="LnApplyMidAction_findByPageToLnFail.action">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<table width="100%" align="center" class="searchstyle">
							<tr>
								<td>
									<dhcc:formTag property="formlnfail0001" mode="query" />
								</td>
							</tr>
							<tr>
								<td>
									<font color=red size="3px">&nbsp&nbsp��&nbsp��ʾ��&nbsp&nbsp��������������Ž��в�ѯ&nbsp!&nbsp��</font>
								</td>
							</tr>
						</table>
						<div class="tools_372">
							<dhcc:button value="��ѯ" action="��ѯ" commit="true" onclick="chkBrNo();"
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
							<div class="tabTitle">����ʧ��ҵ���б�</div>
				<!--			<dhcc:button value="����" action="����" typeclass="t_ico_tj"
								onclick="AcLnMstAction_input.action"></dhcc:button>   -->
						</div>
							
						<dhcc:tableTag paginate="lnFailList" property="tablelnapplymid0008"
									head="true" />
					</div>
				</div>
			</div>
		</div>
	</s:form>
	</body>
</html>