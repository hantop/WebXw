<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>����</title>
	</head>
		<script type="text/javascript">
	function getBirthday(){
		    fPopUpCalendarDlg();
		}		
	
	</script>
	<script type="text/javascript">
		 function checkCommMail(obj){
             var temp = obj.value;
             //�Ե����ʼ�����֤
             var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
             if(!myreg.test(temp))
             {
                 sAlert('��ʾ\n\n��������Ч��E_mail��');
                 document.cms_form.elements["commMail"].value = "";
                 return false;
             }
         }
        function insti(){
	    var contIdno = document.getElementsByName("contIdno")[0].value;
		var reg = /^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/;
		var bl = reg.test(contIdno);
		if(!bl){
			sAlert("��������ȷ��֤����");
			document.cms_form.elements["contIdno"].value = "";
			return false;
	}
	}
	</script>
	<body class="body_bg">
	<s:form method="post" theme="simple" name="cms_form"
		action="CorpContActionUpdate.action">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<dhcc:formTag property="formcoop0012" mode="query" />
						<div class="from_btn">
						<s:if test="query!='query'">
							 <dhcc:button typeclass="button3" commit="true" value="����" action="����"  ></dhcc:button>
		                     <dhcc:button typeclass="button_form" value="����" action="����" onclick="CorpContAction_listQuotaForCorp.action" param="brNo=brNo"></dhcc:button>
						 </s:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	</body>
</html>