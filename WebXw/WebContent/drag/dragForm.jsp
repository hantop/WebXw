<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/tld/loan.tld" prefix="dhcc" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
  String formId = request.getParameter("formId");
  String currFormId="";
  if(formId!=null&&formId.trim()!="")
  {
      currFormId="��ǰ�༭�����:"+formId;
  }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>���༭��</title>
		<script type='text/javascript' src= '<%=request.getContextPath()%>/drag/js/dragForm.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/drag/js/common.js'></script>
		<script type='text/javascript' src= '<%=request.getContextPath()%>/drag/js/empty.js'></script>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/include/screencore.css" type="text/css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/drag/css/dragCss.css" type="text/css" />
		<link id="css" rel="stylesheet" href="<%=request.getContextPath()%>/drag/css/style.css" type="text/css" />
		<style type="text/css">
			body{margin:0; padding:0;font-family:Verdana, Arial, Helvetica, sans-serif,"";font-size:12px;}
			/*
			input{direction:rtl;unicode-bidi:bidi-override;}
			*/
		</style>
    	<script type="text/javascript" src="<%=request.getContextPath()%>/themes/js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			$(".from_w > tbody > tr:even").addClass("evenRow");//������
			var tabIndex = 1;
		    $("table.ls_list").attr("cellSpacing","0")
		    $("table.ls_list").find("tr").each(function(){
		    	if($(this).find("td.bartop").get(0) || $(this).find("td.bartitle").get(0)){
		    		tabIndex = 1;
		    	}else {
			    	if(tabIndex%2!=0){
			    		//$(this).addClass("evenRow");
			    		$(this).addClass("t2");
			    	}else {
			    		//$(this).addClass("oddRow");
			    		$(this).addClass("t1");
			    	}
			    	tabIndex++;
		    	}
		    });
		});
		
		</script>
	</head>
	<body bgcolor="#FFFFFF">
		<div id="winlinks" class="divcolor">
		    <div class="divtoolboxlabel" align="center">������</div>
			<div id="div1" class="components" style="left:5px; top:40px;" onmouseover="fun7('input')" onmouseout="fun8('input')">
				<img id="input" src="drag/images/toolbox/TextEdit.png"  width=16px height=16px />
				<label>�ı��ֶ�</label>
			</div>
			<div id="div5" class="components" style="left:5px; top:80px;" onmouseover="fun7('textarea')" onmouseout="fun8('textarea')">
				<img id="textarea" src="drag/images/toolbox/TextArea.png" width=16px height=16px  />
				<label>�ı�����</label>
			</div>
			<div id="div2" class="components" style="left:5px; top:120px;" onmouseover="fun7('select')" onmouseout="fun8('select')">
				<img id="select" src="drag/images/toolbox/listbox.png" width=16px height=16px  />
			    <label>ѡ����</label>
			</div>
			<div id="div3" class="components" style="left:5px; top:160px;" onmouseover="fun7('input_checkbox')" onmouseout="fun8('input_checkbox')">
				<img id="input_checkbox" src="drag/images/toolbox/stock_form-checkbox.png" width=16px height=16px />
			    <label>��ѡ��</label>
			</div>
			<div id="div6" class="components" style="left:5px; top:200px;" onmouseover="fun7('input_radio')" onmouseout="fun8('input_radio')">
				<img id="input_radio" src="drag/images/toolbox/RadioButton.png"  width=16px height=16px />
			    <label>��ѡ��</label>
			</div>
			<div id="div6" class="components" style="left:5px; top:240px;" onmouseover="fun7('input_pw')" onmouseout="fun8('input_pw')">
				<img id="input_pw" src="drag/images/toolbox/password.png"  width=16px height=16px />
			    <label>������</label>
			</div>
			<div id="div99" class="components" style="left:5px; top:280px;" onmouseover="fun7('input_hidden')" onmouseout="fun8('input_hidden')">
				<img id="input_hidden" src="drag/images/toolbox/field_hidden.png"  width=16px height=16px />
			    <label>������</label>
			</div>
			<div id="div00" class="components" style="left:5px; top:320px;" onmouseover="fun7('input_other')" onmouseout="fun8('input_other')">
				<img id="input_other" src="drag/images/toolbox/navigate-check.png"  width=16px height=16px />
			    <label>����Ԫ��</label>
			</div>
		</div>
		<div style="width:5px; height:100%; position:absolute; left:99px; top:0px;"><img width=2px height=100% src="drag/images/toolbox/colline.png" /></div>
		<div style="height:30px; position:absolute; left:101px; top:0px;" class="tab_w">
		    <ul>
				<li class="tab_mid"><a href="javaScript:fun16('insertRowDiv')">����һ��</a></li>
				<li class="tab_line"></li>
				<li class="tab_mid"><a href="javaScript:fun16('deleteRowDiv')">ɾ��һ��</a></li>
				<li class="tab_line"></li>
				<li class="tab_mid"><a href="javaScript:fun16('logicalFormulaDiv')">��֤��ʽ</a></li>
				<li class="tab_line"></li>
		    </ul>
		    <label id="currFormId"><%=currFormId%></label>
		</div>
		<div id="formMoveDiv" style="position:absolute; left:101px; top:80px;width:1000px">
		     <div width="95%">
		    	<dhcc:formPreviewTag property="form" mode="preQuery" />
		    	<a name="formitem" href="" target="mtopwin"></a>
		   	 </div>
		</div>
		<div id="hiddenElement" style="position:absolute;left:1110; top:10px;width:220px" onmousedown="dragPro('hiddenElement')">
		    <dhcc:tableTag  paginate="formElementList" property="table109" head="true"/>
		</div>
		<div id="searchFormDiv" class="searchFormDiv" ondblclick="closeDiv(this)">
		    <table width="100%">
		        <tr>
		            <td align="right">����</td>
		            <td align="left"><input type="text" id="searchFormId"/></td>
		            <td align="right">������</td>
		            <td align="left"><input type="text" id="searchTitle"/></td>
		            <td align="center"><button type="button" onclick="fun13()">��ѯ</button></td>
		        </tr>
		    </table>
			<table align="center" width="100%"  border="0" id="formListTable">
		        <tr height="20">
		            <td align="center" height="20">������</td>
		            <td align="center">����</td>
		            <td align="center">�޸�����</td>
		            <td align="center">ɾ����</td>
		            <td align="center">����ά��</td>
		            <td align="center">����</td>
		        </tr>
		    </table>
	        <table align="center">
	            <tr align="center">
	                <td align="center"><span style="cursor:hand;" onclick="fun25('first')"><font color="#0000ff">��ҳ&nbsp;&nbsp;</font></span></td>
	                <td align="center"><span style="cursor:hand;" onclick="fun25('previous')"><font color="#0000ff">��һҳ&nbsp;&nbsp;</font></span></td>
	                <td align="center"><span style="cursor:hand;" onclick="fun25('next')"><font color="#0000ff">��һҳ&nbsp;&nbsp;</font></span></td>
	                <td align="center"><span style="cursor:hand;" onclick="fun25('last')"><font color="#0000ff">βҳ</font></span></td>
	            </tr>
	        </table>
		    <div id="updateFormDiv" class="updateFormDiv" style="display:none;">
		        <table width="100%">
		        <tr>
		            <td align="right">����<font color="red">*</font></td>
		            <td align="left"><input type="text" id="updateFormId" size="15" /></td>
		        </tr>
		        <tr>
		            <td align="right">������<font color="red">*</font></td>
		            <td align="left"><input type="text" id="updateTitle" size="20"/></td>
		        </tr>
		         <tr>
		        <td align="right">�Ƿ���ʾ����<font color="red">*</font></td>
				      <td align="left">
				          <select name="updateformTitleShowFlag" title="�Ƿ���ʾ����" >
				          <option value="" selected></option>
				          <option value="false">��</option>
				          <option value="true">��</option>
				          </select>
				      </td>
		         </tr>
		        
		        <tr>
		            <td align="center"><button type="button" onclick="fun12()">ȷ��</button></td>
		            <td align="center"><button type="button" onclick="closeDiv2('updateFormDiv')">�ر�</button></td>
		        </tr>
		    </table>
		    </div>
		    <div id="copyFormDiv" class="copyFormDiv" style="display:none;">
		        <table width="100%">
		        	<tr>
			            <td align="right">ԭ����<font color="red">*</font></td>
			            <td align="left"><input type="text" id="copyFormId" size="15" readonly="true"/></td>
			        </tr>
			        <tr>
			            <td align="right">�±���<font color="red">*</font></td>
			            <td align="left"><input type="text" id="newFormId" size="15" /></td>
			        </tr>
			        <tr>
			            <td align="right">�±�����<font color="red">*</font></td>
			            <td align="left"><input type="text" id="newTitle" size="20"/></td>
			        </tr>
			         <tr>
			        <td align="right">�Ƿ���ʾ����<font color="red">*</font></td>
					      <td align="left">
					          <select name="newTitleShowFlag" title="�Ƿ���ʾ����" >
					          <option value="" selected></option>
					          <option value="false">��</option>
					          <option value="true">��</option>
					          </select>
					      </td>
			         </tr>
			        <tr>
			            <td align="center"><button type="button" onclick="fun11()">ȷ��</button></td>
			            <td align="center"><button type="button" onclick="closeDiv2('copyFormDiv')">�ر�</button></td>
			        </tr>
		    	</table>
		    </div>
		    <div id="searchFormLoadingDiv" class="searchFormLoadingDiv"><!--<img src="drag/images/loading.gif" width=40px height=40px/>--></div>
		</div>
		<div id="addForm" class="addForm">
		    <table width="100%">
		        <tr>
		            <td align="right">����<font color="red">*</font></td>
		            <td align="left"><input type="text" id="insertFormId" size="15" /></td>
		        </tr>
		        <tr>
		            <td align="right">������<font color="red">*</font></td>
		            <td align="left"><input type="text" id="insertTitle" size="15" /></td>
		        </tr>
		         <tr>
		             <td align="right">�Ƿ���ʾ����<font color="red">*</font></td>
				      <td align="left">
				          <select name="insertformTitleShowFlag" title="�Ƿ���ʾ����" >
				          <option value="false">��</option>
				          <option value="true" selected>��</option>
				          </select>
				      </td>
		         </tr>
		        <tr>
		            <td align="center"><button type="button" onclick="fun10()">ȷ��</button></td>
		            <td align="center"><button type="button" onclick="closeDiv2('addForm')">�ر�</button></td>
		        </tr>
		    </table>
		</div>
		<div id="insertRowDiv" class="insertRowDiv">
		    <table width="100%">
		        <tr>
		            <td align="right">�к�<font color="red">*</font></td>
		            <td align="left"><input type="text" id="insertRowNum" size="15" /></td>
		        </tr>
		        <tr>
		            <td align="center"><button type="button" onclick="fun18()">ȷ��</button></td>
		            <td align="center"><button type="button" onclick="closeDiv2('insertRowDiv')">�ر�</button></td>
		        </tr>
		    </table>
		</div>
		<div id="deleteRowDiv" class="deleteRowDiv">
		    <table width="100%">
		        <tr>
		            <td align="right">�к�<font color="red">*</font></td>
		            <td align="left"><input type="text" id="deleteRowNum" size="15" /></td>
		        </tr>
		        <tr>
		            <td align="center"><button type="button" onclick="fun19()">ȷ��</button></td>
		            <td align="center"><button type="button" onclick="closeDiv2('deleteRowDiv')">�ر�</button></td>
		        </tr>
		    </table>
		</div>
		<div id="logicalFormulaDiv" class="logicalFormulaDiv">
		    <table width="550px" border="0" cellpadding="0" cellspacing="1" style="border:#CAECD4;" bgcolor="EAEAEA" align="center">
			    <tr>
			      <td valign="top">
			        <table width="99%" border="1" align="center" cellpadding="5" cellspacing="0">
			          <tr> 
			              <td align="center"><select id="formElementSelect"></select></td>
			               <td>
			                <input name="b_insert" type="button" id="b_insert2" value="����" onClick="fun20('formElementSelect')" class="btn_80"/>
			              </td>
			          </tr>
			          <tr height="15px"><td colspan="2"></td></tr>
			        </table>
			      </td>
			     </tr>
			     <tr>
			      <td width="100%" valign="top" align="center">
			      	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			          <tr>
			            <td width="80%" align="center">
			            	<table width="80%"  border="1" align="center" cellpadding="0" cellspacing="1">
								<tr align="center" bgcolor="#CAECD4" height="30px"><!-- line 1 -->
									<td width="62px" onClick="fun22('&')" align="center">&</td>
									<td width="62px" onClick="fun22('|')" align="center">|</td>
									<td width="62px" onClick="fun22('!')" align="center">!</td>
					                <td width="62px" onClick="fun22('%')" align="center">%</td>
					                <td width="62px" onClick="fun22('>')" align="center">&gt;</td>
									<td width="62px" onClick="fun22('(')" align="center">(</td>
									<td width="62px" onClick="fun22(')')" align="center">)</td>
								</tr>
								<tr align="center" bgcolor="#CAECD4" height="30px">
				                  <td width="62px" onClick="fun22('7')" align="center">7</td>
				                  <td width="62px" onClick="fun22('8')" align="center">8</td>
				                  <td width="62px" onClick="fun22('9')" align="center">9</td>
				                  <td width="62px" onClick="fun22('/')" align="center">/</td>
				                  <td width="62px" onClick="fun22('<')" align="center">&lt;</td>
								  <td width="62px" onClick="fun22('[')" align="center">[</td>
								  <td width="62px" onClick="fun22(']')" align="center">]</td>
								</tr>
								<tr align="center" bgcolor="#CAECD4" height="30px">
				                  <td width="62px" onClick="fun22('4')" align="center">4</td>
				                  <td width="62px" onClick="fun22('5')" align="center">5</td>
				                  <td width="62px" onClick="fun22('6')" align="center">6</td>
				                  <td width="62px" onClick="fun22('*')" align="center">*</td>
				                  <td width="62px" onClick="fun22('>=')" align="center">��</td>
								  <td width="62px" onClick="fun22('{')" align="center">{</td>
								  <td width="62px" onClick="fun22('}')" align="center">}</td>
								</tr>
								<tr align="center" bgcolor="#CAECD4" height="30px">
				                  <td width="62px" onClick="fun22('1')" align="center">1</td>
				                  <td width="62px" onClick="fun22('2')" align="center">2</td>
				                  <td width="62px" onClick="fun22('3')" align="center">3</td>
				                  <td width="62px" onClick="fun22('-')" align="center">-</td>
				                  <td width="62px" onClick="fun22('<=')" align="center">��</td>
								  <td colspan="2" width="124px" onClick="fun22('$txDt')" align="center">Ӫҵ����</td>
								</tr>
								<tr align="center" bgcolor="#CAECD4" align="center" height="30px">
								  <td colspan="2" width="124px" onClick="fun22('0')" align="center">0</td>
								  <td width="62px" onClick="fun22('.')" align="center">.</td>
								  <td width="62px" onClick="fun22('+')" align="center">+</td>
								  <td width="62px" onClick="fun22('=')" align="center">=</td>
				                  <td width="62px" onClick="fun22(';')"  align="center">;</td>
				                  <td width="62px" onClick="fun24('formulavalidate')" align="center">��</td>
								</tr>
							</table>
						</td>
			            <td width="20%">
			           	 	<table width="100%">
				           	 	<tr align="left"><td>
				                	<input name="b_js" type="button" id="b_js" value="��ʽУ��" onClick="fun16('formulavalidate')" class="btn_4"/>
				                </td></tr>
				                <tr height="20px"><td></td></tr>
				            </table>
			            </td>
			        </tr>
			       </table>
			      </td>
			    </tr>
			    <tr>
			      <td valign="top" align="left" width="100%" height="100%">
			          <textarea cols="90" rows="8" id="1formulavalidate1"></textarea>
			      </td>
			    </tr>
			    <tr style="border-top:0px;">
			    	<td valign="top" align="center">
			          <input type="button" name="Button" value="����" onClick="fun16('saveformulavalidate')" class="btn_80"/>
			          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					  <input type="button" name="Button" value="�ر�" onClick="closeDiv2('logicalFormulaDiv')" class="btn_80"/>
			        </td></tr>
			  </table>
		</div>
		<div id="redForkDiv" class="redForkDiv">
		    <img id="redForkImg" src="drag/images/toolbox/redFork.png" width=8px height=8px onClick="fun16('redForkConfirm')"/>
		</div>
		<div id="redForkConfirm" class="redForkConfirm">
		    <table width="100%" class="redForkTable">
		        <tr>
		        	<td align="center"><button onClick="fun15()">ɾ��</button></td>
		            <td align="center"><button onClick="fun51()">����</button></td>
		            <td align="center"><button onClick="closeDiv2('redForkConfirm')">ȡ��</button></td>
		        </tr>
		    </table>
		</div>
		<div id="div11" class="dragDiv11" onmouseout=""></div>
		<div id="new" style="height:100%; position:absolute; left:120px; top:0px;"></div>
		<form id="submitPropertyForm" action="FormDataForToolBean_insertFormElement.action" method="post">
		<input type="hidden" id="formId" value="<s:property value="formId"/>"/>
		<div id="popAlert" style="display:none;background:#e2ecf5" onmousedown="dragPro('popAlert')">		
			<div id="tab_div">
	          <span id="tab1_span" class="span" onclick="fun9(this)">������Ϣ</span>
	          <span id="tab2_span" class="span" onclick="fun9(this)">��ʽ����</span>
			  <span id="tab3_span" class="span" onclick="fun9(this)">�¼�����</span>
			  <span id="tab4_span" class="span" onclick="fun9(this)">��������</span>
          </div>
		  <div id="tab1" class="tab_block">
		      <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
			      <tr align="center">
			          <td align="right">��ǩ����&nbsp;</td>
			          <td align="left"><input type="text" title="��ǩ����" name="formActive.labelName"  size="16" onmousedown="stopDarg()" onblur="dargBlur()"/></td>
			          <td align="right">�ֶ�����&nbsp</td>
			          <td align="left"><input type="text" title="�ֶ�����" name="formActive.fieldName"  size="16" onmousedown="stopDarg()" onblur="dargBlur()"/></td>
			          <td align="right">�ֶ�����&nbsp</td>
			          <td align="left">
			              <select name="formActive.fieldType" onmousedown="stopDarg()" onblur="dargBlur()">
			              <option value="1">�ı��ֶ�</option>
						  <option value="2">ѡ����</option>
						  <option value="21">ѡ����(��ѡ)</option>
						  <option value="22">ѡ����(�ֹ�)</option>
						  <option value="3">��ѡ��</option>
						  <option value="31">�Զ���ѡ��</option>
						  <option value="32">�ӿ��и�ѡ��</option>
						  <option value="4">��ѡ��</option>
						  <option value="41">��ѡ��(�ֹ�)</option>
						  <option value="5">�ı�����</option>
						  <option value="6">������</option>
						  <option value="7">�ӿ���ѡ��</option>
						  <option value="33">�ӿ���ѡ��(��ѡ)</option>
						  <option value="8">�Զ���ѡ��</option>
						  <option value="9">�ļ�</option>
						  <option value="99">������</option>
						  </select>
			          </td>
			      </tr>
			      <tr>
			          <td align="right">�д�<font color="#FF0000">*</font> </td>
			          <td align="left"><input type="text" title="�д�" name="formActive.row"  maxlength="3" size="5" onmousedown="stopDarg()" onblur="dargBlur()"></td>
			          <td align="right">��ǩ�д�&nbsp</td>
			          <td align="left"><input type="text" title="��ǩ�д�" name="formActive.labelCol"  maxlength="3" size="5" onmousedown="stopDarg()" onblur="dargBlur()"></td>
			          <td align="right">�ֶ��д�&nbsp</td>
			          <td align="left"><input type="text" title="�ֶ��д�" name="formActive.fieldCol"  maxlength="3" size="5" onmousedown="stopDarg()" onblur="dargBlur()"></td>
			      </tr>
			      <tr>
				      <td align="right">�ߴ�/ѡ��&nbsp</td>
				      <td align="left"><input type="text" title="�ߴ�/ѡ��" name="formActive.fieldSize" onmousedown="stopDarg()" onblur="dargBlur()"></td>
				  	  <td align="right">��λ&nbsp</td>
				      <td align="left"><input type="text" title="��λ" name="formActive.unit"  size="16" onmousedown="stopDarg()" onblur="dargBlur()"></td>
				      <td align="right">��������&nbsp</td>
				      <td align="left">
				          <select name="formActive.dataType" title="��������" onchange="selectonchange()" onmousedown="stopDarg()" onblur="dargBlur()">
						  <option value=""></option>
						  <option value="0" selected>String</option>
						  <option value="1">Int</option>
						  <option value="2">Long</option>
						  <option value="3">Double(2)</option>
						  <option value="4">Float</option>
						  <option value="5">Boolean</option>
						  <option value="6">Date</option>
						  <option value="8">Double(4)</option>
						  <option value="9">Double(6)</option>
						  <option value="12">�����(Ԫ)</option>
						  <option value="13">�����(��)</option>
						  <option value="14">�����(��)</option>
						  <option value="15">�����(��Ԫ)</option>
						  <option value="16">�����(��Ԫ)</option>
						  <option value="17">�ٷֺţ�</option>
						  <option value="18">ǧ�ֺš�</option>
						  <option value="19">��ֺ�</option>
						  </select>
				      </td>    
				  </tr>
				  <tr>
				      <td align="right">�Ƿ�ֻ��&nbsp</td>
				      <td align="left">
				          <select name="formActive.readonly" title="�Ƿ�ֻ��" onmousedown="stopDarg()" onblur="dargBlur()">
				          <option value="" selected></option>
				          <option value="0">��</option>
				          <option value="1">��</option>
				          </select>
				      </td>
				      <td align="right" title="����Ϊѡ����ʱ��">�Ƿ����&nbsp</td>
				      <td align="left" title="����Ϊѡ����ʱ��">
				          <select name="formActive.mustInput" title="�Ƿ����" onmousedown="stopDarg()" onblur="dargBlur()">
				          <option value="" selected></option>
				          <option value="0">��</option>
				          <option value="1">��</option>
				          </select>
				      </td>
				  </tr>
				  <tr>
				      <td align="right">��ֵ&nbsp</td>
				      <td align="left"><input type="text" title="��ֵ" name="formActive.initValue"  size="16" onmousedown="stopDarg()" onblur="dargBlur()"></td>
				      <td align="right">��󳤶�&nbsp</td>
				      <td align="left"><input type="text" title="��󳤶�" name="formActive.maxLength"  maxlength="5" size="5" onmousedown="stopDarg()" onblur="dargBlur()"></td>
				  </tr>
				  <tr>
				      <td align="right">�ֶ�˵��&nbsp</td>
				      <td colspan="3" align="left"><input type="text" title="�ֶ�˵��" name="formActive.alt"  size="40" onmousedown="stopDarg()" onblur="dargBlur()"></td>
				   
				  </tr>
				  <tr>
				      <td align="right">����&nbsp</td>
				      <td colspan="3" align="left"><input type="text" title="����" name="formActive.para"  size="40" onmousedown="stopDarg()" onblur="dargBlur()"></td>
				  </tr>
		      </table>
		      <table align="center" width="50%">
		          <tr>
		              <td><button type="button" onclick="fun14()">ȷ��</button></td>
		              <td><button type="button" onclick="fun15()">ɾ��</button></td>
		              <td><button type="button" onclick="closePopAlert()">�ر�</button></td>
		          </tr>
		      </table>
		  </div>
		   <div id="tab2" class="tab_hide">
		      <table width="96%" border="0" align="center"  cellpadding="0" cellspacing="0">
                  <tr>
			          <td align="right">������&nbsp</td>
			          <td align="left"><input type="text" title="������" name="formActive.rowSpan"  maxlength="3" size="5" onmousedown="stopDarg()" onblur="dargBlur()"></td>
			          <td align="right">��ǩ������&nbsp</td>
			          <td align="left"><input type="text" title="��ǩ������" name="formActive.labelColSpan"  maxlength="3" size="5" onmousedown="stopDarg()" onblur="dargBlur()"></td>
			          <td align="right">�ֶο�����&nbsp</td>
			          <td align="left"><input type="text" title="�ֶο�����" name="formActive.fieldColSpan"  maxlength="3" size="5" onmousedown="stopDarg()" onblur="dargBlur()"></td>			         
			      </tr>
                  <tr>
                   <td align="right">���巶Χ&nbsp</td>
			          <td align="left">
				          <select name="formActive.selRange" title="���巶Χ" onmousedown="stopDarg()" onblur="dargBlur()">
				          <option value="0" selected>ȫ��</option>
				          <option value="1">��ǩ��Ч</option>
				          <option value="2">�ֶ���Ч</option>
				          </select>
			          </td>
                   <td align="right">��ǩ����&nbsp</td>
			          <td align="left">
			              <select name="formActive.labelAlign" title="��ǩ����" onmousedown="stopDarg()" onblur="dargBlur()">
			              <option value="1">�����</option>
			              <option value="2">����</option>
			              <option value="3" selected>�Ҷ���</option>
			              </select>
			          </td>
			          <td align="right">�ֶζ���&nbsp</td>
			          <td align="left">
			              <select name="formActive.fieldAlign" title="�ֶζ���" onmousedown="stopDarg()" onblur="dargBlur()">
			              <option value="1" selected>�����</option>
			              <option value="2">����</option>
			              <option value="3">�Ҷ���</option>
			              </select>
			          </td>
                   </tr>
                   <tr>    
                   	  <td align="right">��ǩ���&nbsp</td>
				      <td align="left"><input type="text" title="��ǩ���" name="formActive.labelWidth"  maxlength="8" size="8" onmousedown="stopDarg()" onblur="dargBlur()"></td>
				      <td align="right">��ǩ��ʽ&nbsp</td>
				      <td align="left"><input type="text" title="��ǩ��ʽ" name="formActive.labelStyle"  size="16" onmousedown="stopDarg()" onblur="dargBlur()"></td>    
                   </tr>
                   <tr>   
               		  <td align="right">�ֶο��&nbsp</td>
				      <td align="left"><input type="text" title="�ֶο��" name="formActive.fieldWidth"  maxlength="3" size="8" onmousedown="stopDarg()" onblur="dargBlur()"></td>
				      <td align="right">�ֶ���ʽ&nbsp</td>
				      <td align="left"><input type="text" title="�ֶ���ʽ" name="formActive.fieldStyle"  size="16" onmousedown="stopDarg()" onblur="dargBlur()"></td>
                   </tr>
                   <tr>  
              		 <td align="right">���ַ���&nbsp</td>
				      <td align="left">
				          <select name="formActive.labelDirect" title="���ַ���" onmousedown="stopDarg()" onblur="dargBlur()">
				          <option value="1">����</option>
				          <option value="0" selected>����</option>
				          </select>
				      </td>
				      
				       <td align="right">�ı���������������</td>
				      <td align="left"><input type="text" title="�ı���������������" name="formActive.textAreaFieldRows"  size="16" onmousedown="stopDarg()" onblur="dargBlur()"></td>
			       </tr>
			       
			 
			       
              </table>
              <table align="center" width="50%">
		          <tr>
		              <td><button type="button" onclick="fun14()">ȷ��</button></td>
		               <td><button type="button" onclick="fun15()">ɾ��</button></td>
		              <td><button type="button" onclick="closePopAlert()">�ر�</button></td>
		             
		          </tr>
		      </table>
		  </div>
		  <div id="tab3" class="tab_hide">
		      <table width="96%" border="0" align="center"  cellpadding="0" cellspacing="0">
                  <tr>
				      <td align="right">��ǩ����&nbsp</td>
				      <td colspan="3" align="left"><input type="text" title="��ǩ����" name="formActive.labelLink"  size="40" onmousedown="stopDarg()" onblur="dargBlur()"></td>
				  </tr>
				  <tr>
				      <td align="right">��ť����&nbsp</td>
				      <td colspan="3" align="left"><input type="text" title="��ť����" name="formActive.buttonCondition"  size="40" onmousedown="stopDarg()" onblur="dargBlur()"></td>
				  </tr>
                  <tr>
                      <td align="right">����¼�&nbsp</td>
                      <td align="left"><input type="text" title="����¼�" name="formActive.onclick"  size="15" onmousedown="stopDarg()" onblur="dargBlur()"></td>
                      <td align="right">��ý���&nbsp</td>
                      <td align="left"><input type="text" title="��ý���" name="formActive.onfocus"  size="15" onmousedown="stopDarg()" onblur="dargBlur()"></td>
                  </tr>
                  <tr>
                      <td align="right" nowrap>���ݱ���¼�&nbsp</td>
                      <td align="left"><input type="text" title="���ݱ���¼�" name="formActive.onchange"  size="15" onmousedown="stopDarg()" onblur="dargBlur()"></td>
                      <td align="right" nowrap>�����뿪&nbsp</td>
                      <td align="left"><input type="text" title="�����뿪" name="formActive.onblur"  size="15" onmousedown="stopDarg()" onblur="dargBlur()"></td>
                  </tr>
                  <tr>
                      <td align="right">��������&nbsp</td>
                      <td align="left"><input type="text" title="��������" name="formActive.onmousedown"  size="15" onmousedown="stopDarg()" onblur="dargBlur()"></td>
                      <td align="right">���̼��ɿ�&nbsp</td>
                      <td align="left"><input type="text" title="���̼��ɿ�" name="formActive.onkeyup"  size="15" onmousedown="stopDarg()" onblur="dargBlur()"></td>
                  </tr>
                  <tr>
                      <td align="right">��꾭��&nbsp</td>
                      <td align="left"><input type="text" title="��꾭��" name="formActive.onkeypress"  size="15" onmousedown="stopDarg()" onblur="dargBlur()"></td>
                      <td align="right">���̼�����&nbsp</td>
                      <td align="left"><input type="text" title="���̼�����" name="formActive.onkeydown"  size="15" onmousedown="stopDarg()" onblur="dargBlur()"></td>
                  </tr>
              </table>
              <table align="center" width="50%">
		          <tr>
		              <td><button type="button" onclick="fun14()">ȷ��</button></td>
		               <td><button type="button" onclick="fun15()">ɾ��</button></td>
		              <td><button type="button" onclick="closePopAlert()">�ر�</button></td>
		             
		          </tr>
		      </table>
		  </div>
		  <div id="tab4" class="tab_hide">
		      <table width="96%" border="0" align="center"  cellpadding="0" cellspacing="0">
                  <tr>
                      <td align="right">�¼�����&nbsp</td>
                      <td align="left">
                          <select name="formActive.calculationType" title="�����¼�����"  onmousedown="stopDarg()" onblur="dargBlur()">
                          <option value=""></option>
                          <option value="onBlur">onBlur</option>
                          <option value="onClick">onClick</option>
                          <option value="onFocus">onFocus</option>
                          <option value="onChange">onChange</option>
                          </select>
                      </td>
                  </tr>
                  <tr>
                      <td align="right">�������㹫ʽ&nbsp;</td>
                      <td colspan="5" align="left"><input type="text" name="formActive.calculation" size="50" readOnly="true" onfocus="fun16('linkageCalculationDiv')" onmousedown="stopDarg()" onblur="dargBlur()"></td>
                  </tr>
              </table>
              <div id="linkageCalculationDiv" class="linkageCalculationDiv" style="display:none">
                  <table width="550px" border="0" cellpadding="0" cellspacing="1" style="border:#CAECD4;" bgcolor="#EAEAEA" align="center">
				    <tr>
				      <td valign="top">
				        <table width="99%" border="1" align="center" cellpadding="5" cellspacing="0">
				          <tr> 
				              <td align="center"><select id="lCformElementSelect"></select></td>
				               <td>
				                <input name="b_insert" type="button" id="b_insert2" value="����" onClick="fun21('lCformElementSelect')" class="btn_80" onmousedown="stopDarg()" onblur="dargBlur()"/>
				              </td>
				          </tr>
				          <tr height="15px"><td colspan="2"></td></tr>
				        </table>
				      </td>
				     </tr>
				     <tr>
				      <td width="100%" valign="top" align="center">
				      	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				          <tr>
				            <td width="80%" align="center">
				            	<table width="80%"  border="1" align="center" cellpadding="0" cellspacing="1">
									<tr align="center" bgcolor="#CAECD4" height="30px"><!-- line 1 -->
										<td width="62px" onClick="fun23('&')" align="center">&</td>
										<td width="62px" onClick="fun23('|')" align="center">|</td>
										<td width="62px" onClick="fun23('!')" align="center">!</td>
						                <td width="62px" onClick="fun23('%')" align="center">%</td>
						                <td width="62px" onClick="fun23('>')" align="center">&gt;</td>
										<td width="62px" onClick="fun23('(')" align="center">(</td>
										<td width="62px" onClick="fun23(')')" align="center">)</td>
									</tr>
									<tr align="center" bgcolor="#CAECD4" height="30px">
					                  <td width="62px" onClick="fun23('7')" align="center">7</td>
					                  <td width="62px" onClick="fun23('8')" align="center">8</td>
					                  <td width="62px" onClick="fun23('9')" align="center">9</td>
					                  <td width="62px" onClick="fun23('/')" align="center">/</td>
					                  <td width="62px" onClick="fun23('<')" align="center">&lt;</td>
									  <td width="62px" onClick="fun23('[')" align="center">[</td>
									  <td width="62px" onClick="fun23(']')" align="center">]</td>
									</tr>
									<tr align="center" bgcolor="#CAECD4" height="30px">
					                  <td width="62px" onClick="fun23('4')" align="center">4</td>
					                  <td width="62px" onClick="fun23('5')" align="center">5</td>
					                  <td width="62px" onClick="fun23('6')" align="center">6</td>
					                  <td width="62px" onClick="fun23('*')" align="center">*</td>
					                  <td width="62px" onClick="fun23('>=')" align="center">��</td>
									  <td width="62px" onClick="fun23('{')" align="center">{</td>
									  <td width="62px" onClick="fun23('}')" align="center">}</td>
									</tr>
									<tr align="center" bgcolor="#CAECD4" height="30px">
					                  <td width="62px" onClick="fun23('1')" align="center">1</td>
					                  <td width="62px" onClick="fun23('2')" align="center">2</td>
					                  <td width="62px" onClick="fun23('3')" align="center">3</td>
					                  <td width="62px" onClick="fun23('-')" align="center">-</td>
					                  <td width="62px" onClick="fun23('<=')" align="center">��</td>
									  <td colspan="2" width="124px" onClick="fun23('$txDt')" align="center">Ӫҵ����</td>
									</tr>
									<tr align="center" bgcolor="#CAECD4" align="center" height="30px">
									  <td colspan="2" width="124px" onClick="fun23('0')" align="center">0</td>
									  <td width="62px" onClick="fun23('.')" align="center">.</td>
									  <td width="62px" onClick="fun23('+')" align="center">+</td>
									  <td width="62px" onClick="fun23('=')" align="center">=</td>
					                  <td width="62px" onClick="fun23(';')"  align="center">;</td>
					                  <td width="62px" onClick="fun24('linkageCalculation')" align="center">��</td>
									</tr>
								</table>
							</td>
							<!-- 
				            <td width="20%">
				           	 	<table width="100%">
					           	 	<tr align="left"><td>
					                	<input name="b_js" type="button" id="b_js" value="��ʽУ��" onClick="cLFormulavalidate()" class="btn_4"/>
					                </td></tr>
					                <tr height="20px"><td></td></tr>
					            </table>
				            </td>
				            -->
				        </tr>
				       </table>
				      </td>
				    </tr>
				    <tr>
				      <td valign="top" align="left" width="100%" height="100%">
				        <textarea name="linkageCalculation" cols="90" rows="8" id="linkageCalculation"></textarea>
				      </td>
				    </tr>
				    <tr style="border-top:0px;">
				    	<td valign="top" align="center">
				          <input type="button" name="Button" value="�������" onClick="fun17()" class="btn_4"/>
				          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				          <input type="button" name="Button" value="�ر�" onClick="closeDiv2('linkageCalculationDiv')" class="btn_80"/>
				        </td>
				    </tr>
				  </table>
              </div>
              <table align="center" width="50%">
		          <tr>
		              <td><button type="button" onclick="fun14()">ȷ��</button></td>
		               <td><button type="button" onclick="fun15()">ɾ��</button></td>
		              <td><button type="button" onclick="closePopAlert()">�ر�</button></td>
		             
		          </tr>
		      </table>
		  </div>
		</div>
		</form>
		<div id="tempDiv" onselectstart="return false" style="cursor: hand; position: absolute; border: 1px solid black; background-color: #cccccc; display: none">
		</div>
	</body>
</html>
