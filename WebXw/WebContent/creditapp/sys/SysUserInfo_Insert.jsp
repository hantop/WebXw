<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>����</title>
	</head>
	<body class="body_bg">
	<script type="text/javascript">
	function certificate(){
	    var idNo = document.getElementsByName("idNo")[0].value;
		var reg =/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		var bl = reg.test(idNo);
		if(!bl){
			sAlert("��������ȷ��֤������");
			document.cms_form.elements["idNo"].value = "";
			return false;
	}
	}
		$(document).ready(function(){	
		});
		//���û�����������ʱ�����û�������������
		function if_hid_brdepart(){
			var br_no = document.getElementsByName("br_no")[0].value;
			if(br_no != "00000"){
				$("select[name='br_depart']").parent("td").parent("tr").hide();
				$("select[name='br_depart']").value="";
			}
		}
		function getuser(){
			var user_no = document.getElementsByName("user_no")[0];
			var user_name = document.getElementsByName("user_name")[0];
			var pass_word = document.getElementsByName("pass_word")[0];
			if(user_no == null || typeof(user_no) == "undefined" || "" == user_no.value){
		    	alert("�������½��!");
		    	return false ;
		    }
			$.ajax({
				url : 'SysUserAction_getUser.action',
				type : 'POST',
				async: false,
				data : "user_no=" + user_no.value,
				success : function(data){
				var returnInfo = new Array();
				returnInfo = data.split("*") ;
		  		 if(returnInfo[0]=="0"){//�ɰ� ����,����,���֤ȡ������ֵ
			  		user_name.value=returnInfo[1];
			  		id_no.value=returnInfo[2];
			  		pass_word.value="111111";
			       } else if(returnInfo[0]=="error.notlrno"){
					   alert("�ò���Ա�ں��Ĳ�����,�����ں������");	     
					   return false;
			  	   } else if(returnInfo[0]=="error.neibu"){
			           alert("���ķ��ص��ڲ�����,�������Ա��ϵ");	     
					   return false;	     
			  	   }else{
			  	        alert("ͨѶ�쳣,�Ժ������·��ͻ��������Ա��ϵ");	     
					   return false;	
					   
			  	   }	   
		    	}
			});
		}

		function nochange(){
			sAlert("��ֹ�ֶ��޸�!");
		}
	</script>
	<s:form method="post" theme="simple" name="cms_form"
		action="SysUserActionInsert.action">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<dhcc:formTag property="formsys0071" mode="query" />
						<div class="from_btn">
							<dhcc:button typeclass="button3" commit="true" value="����" action="����"  ></dhcc:button>
							<dhcc:button typeclass="button_form" value="����" action="����" onclick="SysUserAction_findByPage.action"></dhcc:button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	</body>
	<script type="text/javascript">
	function selAuthSplitId(){
		funcSysUserPop('user_no,user_name','user_no,user_name');
	}
</script>
</html>