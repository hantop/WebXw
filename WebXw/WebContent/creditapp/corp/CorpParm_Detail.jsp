<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>����</title>
	</head>
	<script type="text/javascript">

	function getInvDate(){
		fPopUpCalendarDlg();
		}	
	function func_Timing(){
		var putType = document.getElementsByName("putType")[0].value;
		if(putType=='02'){
			var putTime = document.getElementsByName("putTime")[0].value;
			if(putTime==''){
				sAlert('��ʱ�ſ�ʱ��ʱ�ſ�ʱ�䲻��Ϊ��');
				return false;
			}else{
				return true;
			}
		}else{
			return true;
		}		
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
	</script>
	<body class="body_bg">
	<s:form method="post" theme="simple" name="cms_form"
		action="CorpParmActionUpdate.action">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<dhcc:formTag property="formcoop0004" mode="query" />
						<div class="from_btn">
						<s:if test="query!='query'">
							 <dhcc:button typeclass="button3" commit="true" value="����" action="����" ></dhcc:button>
							 </s:if>
							 <s:if test="backSts==1">
		                     <input type="button" value="����" onclick="javascript:window.location='CorpParmAction_findByPage.action'" class="button_form"/>
		                     </s:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	</body>

</html>