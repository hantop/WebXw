<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
String acctType = (String)request.getParameter("acctType");
%>
<html>
	<head>
		<title>����</title>
<script> 
	var provinceArr = new  Array();
	provinceArr[0] = ['������'];  
	provinceArr[1] = ['�Ϻ���'];  
	provinceArr[2] = ['�����']; 
	provinceArr[3] = ['������'];  
	provinceArr[4] = ['�ӱ�ʡ'];  
	provinceArr[5] = ['ɽ��ʡ'];
	provinceArr[6] = ['���ɹ�������'];  
	provinceArr[7] = ['����ʡ'];  
	provinceArr[8] = ['����ʡ'];  
	provinceArr[9] = ['������ʡ'];   
	provinceArr[10] = ['����ʡ'];     
	provinceArr[11] = ['�㽭ʡ']; 
	provinceArr[12] = ['����ʡ'];   
	provinceArr[13] = ['����ʡ'];  
	provinceArr[14] = ['����ʡ'];  
	provinceArr[15] = ['ɽ��ʡ'];  
	provinceArr[16] = ['����ʡ'];  
	provinceArr[17] = ['����ʡ'];  
	provinceArr[18] = ['����ʡ'];  
	provinceArr[19] = ['�㶫ʡ'];  
	provinceArr[20] = ['����ʡ'];  
	provinceArr[21] = ['����ʡ'];  
	provinceArr[22] = ['�Ĵ�ʡ'];  
	provinceArr[23] = ['����ʡ']; 
	provinceArr[24] = ['����ʡ'];  
	provinceArr[25] = ['����������']; ;  
	provinceArr[26] = ['����ʡ'];  
	provinceArr[27] = ['����ʡ'];  
	provinceArr[28] = ['���Ļ���������'];
	provinceArr[29] = ['�ຣʡ'];  
	provinceArr[30] = ['�½�ά���������'];  
	provinceArr[31] = ['����ر�������'];  
	provinceArr[32] = ['�����ر�������'];  
	provinceArr[33] = ['̨��ʡ']; 
	var arr = new  Array();
	arr[0]="����,����,����,����,����,��̨,ʯ��ɽ,����,��ͷ��,��ɽ,ͨ��,˳��,��ƽ,����,ƽ��,����,����,����" 
	arr[1]="����,¬��,���,����,����,����,բ��,���,����,����,��ɽ,�ζ�,�ֶ�,��ɽ,�ɽ�,����,�ϻ�,����,����" 
	arr[2]="��ƽ,����,�Ӷ�,����,����,����,�Ͽ�,����,�ӱ�,����,����,����,����,���,����,����,����,����" 
	arr[3]="����,����,����,��ɿ�,����,ɳƺ��,������,�ϰ�,����,��ʢ,˫��,�山,����,ǭ��,����,�뽭,����,ͭ��,����,�ٲ�,��ɽ,��ƽ,�ǿ�,�ᶼ,�潭,��¡,����,����,����,���,��ɽ,��Ϫ,ʯ��,��ɽ,����,��ˮ,����,�ϴ�,����,�ϴ�" 
	arr[4]="ʯ��ׯ,����,��̨,����,�żҿ�,�е�,�ȷ�,��ɽ,�ػʵ�,����,��ˮ" 
	arr[5]="̫ԭ,��ͬ,��Ȫ,����,����,˷��,����,����,����,�ٷ�,�˳�" 
	arr[6]="���ͺ���,��ͷ,�ں�,���,���ױ�����,��������,����ľ��,�˰���,�����첼��,���ֹ�����,�����׶���,��������" 
	arr[7]="����,����,��ɽ,��˳,��Ϫ,����,����,Ӫ��,����,����,�̽�,����,����,��«��" 
	arr[8]="����,����,��ƽ,��Դ,ͨ��,��ɽ,��ԭ,�׳�,�ӱ�" 
	arr[9]="������,�������,ĵ����,��ľ˹,����,�绯,�׸�,����,�ں�,˫Ѽɽ,����,��̨��,���˰���" 
	arr[10]="�Ͼ�,��,����,��ͨ,����,�γ�,����,���Ƹ�,����,����,��Ǩ,̩��,����" 
	arr[11]="����,����,����,����,����,����,��,����,��ɽ,̨��,��ˮ" 
	arr[12]="�Ϸ�,�ߺ�,����,��ɽ,����,ͭ��,����,��ɽ,����,����,����,����,����,����,����,����,����" 
	arr[13]="����,����,����,����,Ȫ��,����,��ƽ,����,����" 
	arr[14]="�ϲ���,������,�Ž�,ӥ̶,Ƽ��,����,����,����,�˴�,����,����" 
	arr[15]="����,�ൺ,�Ͳ�,��ׯ,��Ӫ,��̨,Ϋ��,����,̩��,����,����,����,����,����,�ĳ�,����,����" 
	arr[16]="֣��,����,����,ƽ��ɽ,����,�ױ�,����,����,���,���,���,����Ͽ,����,����,����,�ܿ�,פ���,��Դ" 
	arr[17]="�人,�˲�,����,�差,��ʯ,����,�Ƹ�,ʮ��,��ʩ,Ǳ��,����,����,����,����,Т��,����" 
	arr[18]="��ɳ,����,����,��̶,����,����,����,����,¦��,����,����,����,����,�żҽ�" 
	arr[19]="����,����,�麣,��ͷ,��ݸ,��ɽ,��ɽ,�ع�,����,տ��,ï��,����,����,÷��,��β,��Դ,����,��Զ,����,����,�Ƹ�" 
	arr[20]="����,����,����,����,����,���Ǹ�,����,���,����,��������,���ݵ���,����,��ɫ,�ӳ�" 
	arr[21]="����,����" 
	arr[22]="�ɶ�,����,����,�Թ�,��֦��,��Ԫ,�ڽ�,��ɽ,�ϳ�,�˱�,�㰲,�ﴨ,�Ű�,üɽ,����,��ɽ,����" 
	arr[23]="����,����ˮ,����,��˳,ͭ��,ǭ����,�Ͻ�,ǭ����,ǭ��" 
	arr[24]="����,����,����,��Ϫ,��ͨ,����,���,��ɽ,˼é,��˫����,��ɽ,�º�,����,ŭ��,����,�ٲ�" 
	arr[25]="����,�տ���,ɽ��,��֥,����,����,����" 
	arr[26]="����,����,����,ͭ��,μ��,�Ӱ�,����,����,����,����" 
	arr[27]="����,������,���,����,��ˮ,��Ȫ,��Ҵ,����,����,¤��,ƽ��,����,����,����" 
	arr[28]="����,ʯ��ɽ,����,��ԭ" 
	arr[29]="����,����,����,����,����,����,����,����" 
	arr[30]="��³ľ��,ʯ����,��������,����,��������,����,�������տ¶�����,�� ������,��³��,����,��ʲ,����,������" 
	arr[31]="���" 
	arr[32]="����" 
	arr[33]="̨��,����,̨��,̨��,����,��Ͷ,����,����,�û�,����,����,����,��԰,����,��¡,̨��,����,����,���" 
	function init()
	{
	    var pro = document.getElementsByName("bankProv")[0];
	    var bankProv = document.getElementById("bankProv").value;
	    var city = document.getElementsByName("bankCity")[0]; 
	    var bankCity = document.getElementById("bankCity").value;
	    for(var i=0;i<provinceArr.length;i++)
	    {
	             pro[i]=new Option(provinceArr[i],provinceArr[i]);
	             if(bankProv.indexOf(pro[i].value) >= 0||pro[i].value.indexOf(bankProv) >= 0){
	             	pro[i].selected = true;  
	             	 var cityArr = arr[i].split(",");
				     for(var j=0;j<cityArr.length;j++)
				     {			 
				             city[j]=new Option(cityArr[j],cityArr[j]);
				             if(city[j].value.indexOf(bankCity) >= 0||bankCity.indexOf(city[j].value) >= 0){
				             	city[j].selected = true;  
				             }
				     }
	             }
	    }
	}
	function getCity()
	{    
	    var pro = document.getElementsByName("bankProv")[0];
	    var city = document.getElementsByName("bankCity")[0];
	    var index = pro.selectedIndex;
	    var cityArr = arr[index].split(",");   
	    city.length = 0;
	    //�����������е�ֵ��䵽������������
	    for(var i=0;i<cityArr.length;i++)
	    {
	             city[i]=new Option(cityArr[i],cityArr[i]);
	         }
	}
</script>
	</head>
	<script type="text/javascript">
	
	$(document).ready(function(){
		init();
		var b = document.getElementsByName("acctType")[0]; 
		//b.options.remove(2);   
		
	            for   (var i=0;i<b.length;i++)   
		            {   
		            if(b[i].value==acctType){
		            	b[i].selected = true;  
		            }
		            b[i].disabled=true;   
	            }
	});
	</script>

	<body class="body_bg" >
	<s:form method="post" theme="simple" name="cms_form"
		action="ProjAcctActionUpdateForFK.action" param="projNo=projNo@flag=flag" >
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
					<s:if test="query=='query'">
						<dhcc:formTag property="formproj0030" mode="query" />
					</s:if>
					<s:else>
						<dhcc:formTag property="formproj0030" mode="query" />
					</s:else>
						<div class="from_btn">
						<s:if test="query!='query'">
							 <dhcc:button typeclass="button3" commit="true" value="����" action="����" ></dhcc:button>
							<dhcc:button typeclass="button_form" value="����" action="����" onclick="ProjAcctAction_findByPageToProj_Read.action" param="projNo=projNo"></dhcc:button>
						 </s:if>
						 <s:if test="flag!=1">
						 </s:if>
						 <s:if test="backSts == 1">
							<!--<input type="button" value="����" onclick="javascript:window.location='ProjAcctAction_findByPageForVa.action'" class="button_form"/>
						 --></s:if>
							<s:if test="backSts!=1"><!--
						      <input type="button" value="����" onclick="javascript:window.location='ProjAcctAction_findByPageToProj.action'" class="button_form"/>
						      --></s:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
<!--	<input type="hidden" id="acctType" value="<s:property value="projAcct.acctType"></s:property>">  -->
	<input type="hidden" id="bankProv" value="<s:property value="projAcct.bankProv"></s:property>">
	<input type="hidden" id="bankCity" value="<s:property value="projAcct.bankCity"></s:property>">
	</body>
</html>