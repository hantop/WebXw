<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>角色详情</title>
	</head>
	<body class="body_bg">
	<s:form method="post" theme="simple" name="cms_form"
		action="SysRoleActionUpdate.action">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<dhcc:formTag property="formsys0075" mode="query" />
						<div class="from_btn">
							<dhcc:button typeclass="button3" commit="true" value="保存" action="保存"  ></dhcc:button>
							<input type="button" value="返回" onclick="javascript:window.location='SysRoleAction_findByPage.action'" class="button_form"/>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	</body>
</html>