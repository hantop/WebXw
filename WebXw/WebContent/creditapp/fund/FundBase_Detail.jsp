<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>����</title>
	</head>
	<body class="body_bg">
	<s:form method="post" theme="simple" name="cms_form"
		action="FundBaseActionUpdate.action">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<dhcc:formTag property="formfund0002" mode="query" />
						
						<input type="hidden" value="<s:property value="reDeem1"/>" name="reDeem1">
						
						<div class="from_btn">
						  <s:if test="query!='query'">
							 <dhcc:button typeclass="button3" commit="true" value="����" action="����" onclick="check(cms_form)" ></dhcc:button>
						  </s:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	</body>
	<script type="text/javascript">
	function check(frm) {
	 var repayType = document.getElementsByName("repayType")[0].value;
	 var repayDay = document.getElementsByName("repayDay")[0].value;
	 var fdType = document.getElementsByName("fdType")[0].value;
	 repayType = repayType.substr(0,1);
	 
	 if(fdType == 01 && (repayType == null || repayType == undefined || repayType == ''))
          {
		     sAlert("�ʽ�����Ϊ���ȼ����������ڱ���!");
		     return false;
		  }
	 if(repayType == 1 && (repayDay == null || repayDay == undefined || repayDay == ''))
	      {
	         sAlert("������������Ϊ��Ȼ��Ϣ��ʽ��ָ�������ձ��� !");
	         return false;
		  }
	 if(repayDay > 28)
          {
		     sAlert("ָ�������ղ��ܴ���ÿ��28��!");
		     document.getElementsByName("repayDay")[0].value = "";
		     return false;
		  }	  
     if(repayType != 1 && repayDay.length > 0)
          {
		     sAlert("������������Ϊ���н�Ϣ��ʽ����ָ��������!");
		     document.getElementsByName("repayDay")[0].value = "";
		     return false;
		  }   
  	    
		frm.submit();  
	}
	 function judge_repay_day() {
	 var repayType = document.getElementsByName("repayType")[0].value;
	 var repayDay = document.getElementsByName("repayDay")[0].value; 
	 repayType = repayType.substr(0,1);
	 if(repayType == 1 && (repayDay == null || repayDay == undefined || repayDay == ''))
	      {
	         sAlert("������������Ϊ��Ȼ��Ϣ��ʽ��ָ�������ձ��� !");
	         return false;
		  }
	 if(repayDay > 28)
          {
		     sAlert("�����ղ��ܴ���ÿ��28��!");
		     document.getElementsByName("repayDay")[0].value = "";
		     return false;
		  }	  
     if(repayType != 1 && repayDay.length > 0)
          {
		     sAlert("������������Ϊ���н�Ϣ��ʽ����ָ��������!");
		     document.getElementsByName("repayDay")[0].value = "";
		     return false;
		  } 
	 if(repayDay.length != 2)
         {
		     sAlert("ָ�������ճ���Ϊ2λ������02,12!");
		     document.getElementsByName("repayDay")[0].value = "";
		     return false;
		  } 	   
	 	  
	}
	</script>
</html>