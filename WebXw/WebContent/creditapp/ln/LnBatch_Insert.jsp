<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>����</title>
	</head>
	<script type="text/javascript">
	function institutions(){
	    var brNo = document.getElementsByName("brNo")[0].value;
		var reg = /^[0-9]+$/;
		var bl = reg.test(brNo);
		if(!bl){
			sAlert("��������ȷ�ĺ���������");
			document.cms_form.elements["brNo"].value = "";
			return false;
	}
	}
	function batch(){
	    var batchNo = document.getElementsByName("batchNo")[0].value;
		var reg =/^[a-zA-Z\d]+$/;
		var bl = reg.test(batchNo);
		if(!bl){
			sAlert("��������ȷ�ĺ�ͬ���");
			document.cms_form.elements["batchNo"].value = "";
			return false;
	}
	}
	</script>
	<body class="body_bg">
	<s:form method="post" theme="simple" name="cms_form"
		action="LnBatchActionInsert.action">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<dhcc:formTag property="formlnbatch0002" mode="query" />
						<div class="from_btn">
							<dhcc:button typeclass="button3" commit="true" value="����" action="����"  ></dhcc:button>
							<dhcc:button typeclass="button_form" value="����" action="����" onclick="LnBatchAction_findByPage.action"></dhcc:button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	</body>
</html>