<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>����</title>
</head>
<script type="text/javascript">
	function show(){
		$("#ad").show();
	}
	function hide(){
		$("#ad").hide();
	}
</script>
		<body class="body_bg">
		<div class="Ci-box">
			<s:if test="cifPortrait.sex==1">
				<div class="Ci-personimgman">
					<s:if test="cifPortrait.cifBlacknum>0">
						<div class="hei">
							<img alt="" src="<%=contextpath%>/creditapp/cif/image/hmd.png">
						</div>
					</s:if>
				</div>
			</s:if>
			<s:elseif test="cifPortrait.sex==2">
				<div class="Ci-personimgwomen">
					<s:if test="cifPortrait.cifBlacknum>0">
						<div class="hei">
							<img alt="" src="<%=contextpath%>/creditapp/cif/image/hmd.png">
						</div>
					</s:if>
				</div>
			</s:elseif>
			<s:else>
				<div class="Ci-personimg">
					<s:if test="cifPortrait.cifBlacknum>0">
						<div class="hei">
							<img alt="" src="<%=contextpath%>/creditapp/cif/image/hmd.png">
						</div>
					</s:if>
				</div>
			</s:else>
			<div class="C1-star">
			<div class="C1-inblock">
			<s:if test="cifPortrait.grade<=20">
				<div class="stariy">
					<img alt="" src="<%=contextpath%>/creditapp/cif/image/star1.png">
				</div>
			</s:if>
			<s:elseif test="cifPortrait.grade>20&&cifPortrait.grade<=40">
				<% for(int i = 0; i<2; i++){%>
				<div class="stariy">
					<img alt="" src="<%=contextpath%>/creditapp/cif/image/star1.png">
				</div>
				<%}%>
			</s:elseif>
			<s:elseif test="cifPortrait.grade>40&&cifPortrait.grade<=60">
				<% for(int i = 0; i<3; i++){%>
				<div class="stariy">
					<img alt="" src="<%=contextpath%>/creditapp/cif/image/star1.png">
				</div>
				<%}%>
			</s:elseif>
			<s:elseif test="cifPortrait.grade>60&&cifPortrait.grade<=80">
				<% for(int i = 0; i<4; i++){%>
				<div class="stariy">
					<img alt="" src="<%=contextpath%>/creditapp/cif/image/star1.png">
				</div>
				<%}%>
			</s:elseif>
			<s:else>
				<% for(int i = 0; i<5; i++){%>
				<div class="stariy">
					<img alt="" src="<%=contextpath%>/creditapp/cif/image/star1.png">
				</div>
				<%}%>
			</s:else>
			</div>
			</div>
			<div class="Citfont" style=" margin:5px auto 10px; text-align:center">
					<s:property value="cifPortrait.prtDesc"></s:property>
			</div>
			<div>
				<table cellspacing="0" width="100%" class="cifpot-name">
					<tr>
						<td class="Citit" colspan="2">������Ϣ</td>
					</tr>
					<tr>
						<td  align="left" class="Citfont">
						<s:property value="cifPortrait.cifName"></s:property>
							<s:if test="cifPortrait.sex==1">
							/��
						</s:if>
						<s:if test="cifPortrait.sex==2">
							/Ů
						</s:if>
						/<s:property value="cifPortrait.birthDay"></s:property>��/
						<s:if test="cifPortrait.edu==20">
								��ѧ����
							</s:if>
							<s:if test="cifPortrait.edu==30">
								��ѧר�ƺ�ר��ѧУ
							</s:if>
							<s:if test="cifPortrait.edu==40">
								�е�רҵѧ���еȼ���ѧУ
							</s:if>
							<s:if test="cifPortrait.edu==50">
								����ѧУ
							</s:if>
							<s:if test="cifPortrait.edu==60">
								����
							</s:if>
							<s:if test="cifPortrait.edu==70">
								����
							</s:if>
							<s:if test="cifPortrait.edu==80">
								Сѧ
							</s:if>
							<s:if test="cifPortrait.edu==90">
								��ä�����ä
							</s:if>
							<s:if test="cifPortrait.edu==99">
								ѧ��δ֪
							</s:if>
							<s:if test="cifPortrait.marriage==10">
								/δ��
							</s:if>
							<s:if test="cifPortrait.marriage==20">
								/�ѻ�
							</s:if>
							<s:if test="cifPortrait.marriage==21">
								/����
							</s:if>
							<s:if test="cifPortrait.marriage==22">
								/�ٻ�
							</s:if>
							<s:if test="cifPortrait.marriage==23">
								/����
							</s:if>
							<s:if test="cifPortrait.marriage==30">
								/ɥż
							</s:if>
							<s:if test="cifPortrait.marriage==40">
								/���
							</s:if>
							<s:if test="cifPortrait.marriage==90">
								/δ˵���Ļ���״��
							</s:if>
							<s:if test="cifPortrait.cifType==01">
								/ũ��
							</s:if>
							<s:if test="cifPortrait.cifType==02">
								/��н
							</s:if>
							<s:if test="cifPortrait.cifType==03">
								/���幤�̻�
							</s:if>
							<s:if test="cifPortrait.cifType==04">
								/ѧ��
							</s:if>
						</td>
					</tr>
					<tr class="Citfont" align="left">
					<td colspan="2">
						TEL: &nbsp;<s:property value="cifPortrait.resTel"></s:property>
					</td>
					</tr>
					<tr align="left" class="Citfont" >
					<td colspan="2">
						Addr: &nbsp;<s:property value="cifPortrait.resAddr"></s:property>
					</td>
						
					</tr>
					</table>
					
					<div class="Ci-tipbox">
						<div class="Ci-tip Ci-orange">
							�в��׼�
						</div>
						<div class="Ci-tip Ci-blue"  id="add" onmouseover="show()" onmouseout="hide()">
							<s:if test="cifPortrait.repdNum<=0">
										������
									</s:if>
									<s:if test="cifPortrait.repdNum>=1&&cifPortrait.repdNum<=3">
										�������÷���
									</s:if>
									<s:if test="cifPortrait.repdNum>3">
										���ýϲ�
									</s:if>
						</div>
						<div class="Ci-tip Ci-green" style="display: none; position: absolute;z-index: 2;"  id="ad"> 
							<s:if test="cifPortrait.repdNum<=0">0�����ڣ���������</s:if>
										<s:if test="cifPortrait.repdNum>=1&&cifPortrait.repdNum<=3"><s:property value="cifPortrait.repdNum"></s:property>�����ڣ���ע��������÷���</s:if>
										<s:if test="cifPortrait.repdNum>3"><s:property value="cifPortrait.repdNum"></s:property>�����ڣ����ýϲ�</s:if>
						</div>
						
						<div class="Ci-tip Ci-yellow">
							<s:if test="cifPortrait.workType==0">
								���һ��ء���Ⱥ��֯����ҵ����ҵ��λ������
							</s:if>
							<s:if test="cifPortrait.workType==1">
								רҵ������Ա
							</s:if>
							<s:if test="cifPortrait.workType==3">
								������Ա���й���Ա
							</s:if>
							<s:if test="cifPortrait.workType==4">
								��ҵ������ҵ��Ա
							</s:if>
							<s:if test="cifPortrait.workType==5">
								ũ���֡������桢ˮ��ҵ������Ա
							</s:if>
							<s:if test="cifPortrait.workType==6">
								�����������豸������Ա���й���Ա
							</s:if>
							<s:if test='cifPortrait.workType=="X"'>
								����
							</s:if>
							<s:if test='cifPortrait.workType=="Y"'>
								��������������ҵ��Ա
							</s:if>
							<s:if test='cifPortrait.workType=="Z"'>
								δ֪
							</s:if>
						</div>
						<div class="Ci-tip Ci-zi">
							<s:if test="cifPortrait.ifCar==0">
								�޳�
							</s:if>
							<s:else>
								�г�һ��
							</s:else>
						</div>
						<div class="Ci-tip Ci-green">
							<s:if test="cifPortrait.ifRoom==0">
								�޷�
							</s:if>
							<s:else>
								�з�һ��
							</s:else>
						</div>
						<s:iterator value="cifPortraitList" id="var" >
							<s:if test="#var.cifGroup==01">
								<div class="Ci-tip Ci-blue">
									���ʿͻ�
								</div>
							</s:if>
							<s:if test="#var.cifGroup==02">
								<div class="Ci-tip Ci-blue">
									���ѿͻ�
								</div>
							</s:if>
						</s:iterator>
						<div class="Ci-tip Ci-orange">
							<s:if test="cifPortrait.ifDc==0">
								������
							</s:if>
							<s:else>
								�Ǵ�����
							</s:else>
						</div>
						<div class="Ci-tip Ci-green">
							<s:if test="cifPortrait.ifHg==0">
								�ع���
							</s:if>
							<s:else>
								�ǻع���
							</s:else>
						</div>
						<div class="Ci-tip Ci-zi">
							�г�������<s:property value="cifPortrait.gradePersent"></s:property>%�Ŀͻ�
						</div>
			</div>
			
		</div>
	</body>
</html>