<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>����</title>
	<script language="javascript" type="text/javascript">
		$(document).ready(function(){
			//������ݵ�ѡ��
			var myDate= new Date();
			var startYear=myDate.getFullYear()-50;//��ʼ���
			var endYear=myDate.getFullYear()+50;//�������
			var obj=document.getElementsByName('workYear')[0];
			for (var i=startYear;i<=endYear;i++)
			{
			obj.options.add(new Option(i,i));
			}
			obj.options[obj.options.length-51].selected=1;
			}
		);
	</script> 
	</head>
	<body class="body_bg">
	<s:form method="post" theme="simple" name="cms_form"
		action="CifPersCareerActionInsert.action">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<dhcc:formTag property="formcif0014" mode="query" />
						<div class="from_btn">
							<dhcc:button typeclass="button3" commit="true" value="����" action="����"  ></dhcc:button>
							<dhcc:button typeclass="button_form" value="����" action="����" onclick="CifPersCareerAction_listQuotaForCif.action" param="cifNo=cifNo@brNo=brNo"></dhcc:button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	</body>
</html>