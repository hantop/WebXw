<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>小微金融运管平台管理系统</title>
	</head>
	<body class="body_bg">
	<s:form method="post" theme="simple" name="cms_form"
		action="ParmKeyActionUpdate.action">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<dhcc:formTag property="formsys0051" mode="query" />
						<div class="from_btn">
						<s:if test="query!='query'">
							 <dhcc:button typeclass="btn_80" commit="true" value="保存" action="保存"  ></dhcc:button>
						 </s:if>
		                     <dhcc:button typeclass="button_form" value="返回" action="返回" onclick="ParmKeyAction_findByPage.action"></dhcc:button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	</body>
</html>