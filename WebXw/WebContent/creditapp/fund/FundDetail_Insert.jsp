<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<%
String fdType= (String)request.getParameter("fdType");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>����</title>
	</head>	
	<script type="text/javascript">
	$(document).ready(function(){
		var timingTime = document.getElementById("timingTime").value;
		showTrigger(triggerType);
		showMode(modehedden);
		var mode = document.getElementById("mode");
		var ops = mode.options;  
		for(var i=0;i<ops.length; i++){  
          var tempValue = ops[i].value;  
             if(modehedden.value == tempValue)//������Ҫѡ��ֵ  
                {  
                   ops[i].selected = true;  
                   break;  
                }  
            }
            //alert(mode.value);
        document.getElementById("modehidden").innerHTML = mode.value;
		splitweek(weekhidden);
		var arrtimingTime = new Array();
		arrtimingTime = timingTime.split(",");
		$("#timDay").val(arrtimingTime[0]);
		$("#timMonth").val(arrtimingTime[1]);
		$("#timYear").val(arrtimingTime[2]);
		$("#timYearday").val(arrtimingTime[3]);
		
	});
	
	</script>
	<body class="body_bg">
	<s:form method="post" theme="simple" name="cms_form"
		action="FundDetailActionInsert.action" >
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<dhcc:formTag property="formfddetail0002" mode="query" />
						
							<input type="hidden" name="fdType"  value="<s:property value='fdType'/>">
							
						<div class="from_btn">
							<dhcc:button typeclass="button3" commit="true" value="����" action="����" onclick="check(cms_form)" ></dhcc:button>
							<dhcc:button typeclass="button_form" value="����" action="����" onclick="FundDetailAction_findByPage.action" param="fundNo=fundNo@fdType=fdType"></dhcc:button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	</body>
	<script type="text/javascript">
	function check(frm) {
     var tradeType = document.getElementsByName("tradeType")[0].value;
	 var txAmt =  document.getElementsByName("txAmt")[0].value;
	 var termNo =  document.getElementsByName("termNo")[0].value;
	 if(tradeType == "01" && txAmt < 0)
	      {
	         sAlert("��������Ϊ׷�ӣ����׽�����Ϊ���� !");
	         return false;
		  }
	 if(tradeType == "02" && txAmt > 0)
          {
		     sAlert("��������Ϊ�Ҹ������׽�����Ϊ����!");
		     return false;
		  }	  	   
           frm.submit(); 
     }      
	</script>
	
</html>