<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>��������ҵ��������ҵ�����ϵͳ</title>
	</head>
	<body class="body_bg">
	<s:form method="post" theme="simple" name="cms_form"
		action="LnGageMidAction_listQuotaForLn_Read.action">
		<p class="p_blank">&nbsp;</p>
		<s:hidden name ="query"></s:hidden>
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<div class="tabCont">
							<div class="tabTitle">ѺƷ�б�</div>
							
							</div>
							<input name="appId" value="<s:property value="appId"/>" type="hidden"/>
						<dhcc:tableTag paginate="LnGageMidList" property="tablelngagemid0002"
									head="true" />
					</div>
				</div>
			</div>
		</div>
	</s:form>
	</body>
</html>