<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<html>
	<head>
		<title>�����ֵ�����������б�</title>
		<script type="text/javascript">
			function flushParmCache(){
				$.ajax({
			   		type:"POST",
			   		url:"<%=request.getContextPath()%>/ParmDicAction_flushCache.action",
					success : function(data) {
						if (data != null && data != "" && data != "undefined"
								&& data == "success") {
							sAlert("���������ֵ仺��ɹ������ڿ���ʹ���޸ĺ���ֵ���в���");
						} else {
							sAlert("���������ֵ仺��ʧ�ܣ���鿴�����ռ�");
						}
					}
				});
	}
</script>
	</head>
	<body class="body_bg">
		<div class="right_bg">
				<div class="right_w">
					<div class="from_bg">
						<div class="right_v">
					<s:form method="post" theme="simple" validate="false"
						name="cms_form" action="ParmDicAction_findByPage.action">
						<div class="tools_372">
						 <dhcc:button typeclass="btn_80"
								onclick="javascript:flushParmCache()" value="�������"
								action="�������"></dhcc:button>
							
						</div>		
						<p class="p_blank">&nbsp;</p>
		
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<div class="tabCont">
							<div class="tabTitle">�����ֵ��б�</div>
							<dhcc:button typeclass="t_ico_tj" onclick="func_add()" value="����"
								action="����" ></dhcc:button>
								<dhcc:button typeclass="t_ico_tj" onclick="func_back()" value="����"
								action="����" ></dhcc:button>
						</div>
						<dhcc:tableTag paginate="parmdicList" property="tablesys4033"
							head="true" />
					</div>
				</div>
			</div>
		</div>
						
					</s:form>
				</form>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
	function func_add(){
	window.location='ParmDicAction_input.action?key_name=<s:property value="key_name"/>';
	}
	
	</script>
		<script type="text/javascript">
	function func_back(){
	window.location='ParmKeyAction_findByPage.action';
	}
	</script>
</html>