<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>����</title>
	</head>
	<script type='text/javascript' src='<%=contextpath%>/creditapp/js/valid.js'></script>
	<script type="text/javascript">
	function getSetupDate(){
		    fPopUpCalendarDlg();
		}
	function getLicBegDate(){
		    fPopUpCalendarDlg();
		}
	function getLicEndDate(){
		    fPopUpCalendarDlg();
		}		
	
	</script>
	<body class="body_bg">
	<s:form method="post" theme="simple" name="cms_form"
		action="CorpBaseActionInsert.action">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<dhcc:formTag property="formcoop0002" mode="query" />
						<div class="from_btn">
							<dhcc:button typeclass="button3" commit="true" value="����" action="����"  ></dhcc:button>
							<dhcc:button typeclass="button_form" value="����" action="����" onclick="CorpBaseAction_findByPage.action"></dhcc:button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	</body>
</html>