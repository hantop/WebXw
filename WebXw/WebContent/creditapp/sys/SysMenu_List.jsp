<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK" %>
<%@ include file="../../include/tld.jsp"%>
<html>
	<head>
		<title>�˵��б�</title>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/creditapp/js/tree/TreePanel.css" type="text/css" />
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/sysMgrDwr.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
	</head>
	<body bgcolor=#FFFFFF alink=#333333 vlink=#333333 link=#333333 topmargin=0 leftmargin=0 onload="" onkeydown="if(event.keyCode==13)event.keyCode=9">
		<div class="right_bg">
		<div class="right_w">
		<s:form  action="Sys_MenuAction_sysMgrDwr">
		<!-- 
			<table width="100%" cellpadding="0" cellspacing=0 align="center" class="navigator">
				<tr>
				    <td class="mytitle1">�˵�����&gt;&gt;�˵�ά��</td>
				</tr>
			</table>
		 -->
			<table  align="center">
			    <tr> <td>&nbsp;</td>
			    </tr>
				<tr>
					<td class="title"><font size="4">�˵�ά��</font></td>
				</tr>
				<tr><td>&nbsp;</td></tr>
			</table>
			<table width="80%"  height="380"  border="0" align="center" class="TDstyle01">
				<tr>
			   		<td align="left" colspan="2" heigth="20" class="TDstyle02">
			   			<div class="from_btn" style="text-align: left;">
			   			<input type="button" class="btn_80" value="չ��" onclick="javascript:expandAll();">
			   			<input type="button" class="btn_80" value="�۵�" onclick="javascript:collapseAll();">
			   			</div>
			   		</td>
				</tr>
				<tr>
					<td valign="top" align="left" width="60%" class="TDstyle02">
					<div id="menuTree"></div>
					</td>
					<td valign="top" align="left" width="40%" class="TDstyle02">
					<div id="menuMod">
						�˵�&nbsp;I&nbsp;D&nbsp;��<input type="text" name="menuid" id="menuid" size="20" readonly  value="" onblur="caleLvl(this.value);"><br>
						�˵����ƣ�<input type="text" name="menuname" id="menuname"  size="20"  value=""><br>
						�˵�URL��<input type="text" name="menuurl" id="menuurl"  size="20"  value=""><br>
						�˵�����<input type="text" name="menulvl" id="menulvl"  size="20" maxlength="1" value="" readonly><br>
						�˵���ID��<input type="text" name="menuparent" id="menuparent"  size="20"  value="" readonly><br>
						�˵�״̬��<select name="menustats" id="menustats" style="width:130px">
								<option value="1">����</option>
								<option value="0">ͣ��</option>
								</select><br><br>
						<div class="from_btn">
						<input type="button" name="modbtn" id="modbtn" value="�޸�" onclick="modTree();" class="btn_80">
						<input type="button" name="addbtn" id="addbtn" value="����" onclick="addTreeView();" class="btn_80">
						<input type="button" name="delbtn" id="delbtn"  value="ɾ��" onclick="delTree();" class="btn_80"><p><span id="spanMsg" style="color: red"></span></p><br>
						</div>
					</div>
					<div id="menuAdd" style="display:none">
					<br>
						�˵�ID��&nbsp;&nbsp;&nbsp;<input type="text" name="addmenuid" id="addmenuid" size="6" value="" onblur="caleLvl(this.value);"><br>
						�˵����ƣ�<input type="text" name="addmenuname" id="addmenuname"  size="20"  value=""><br>
						�˵�URL��<input type="text" name="addmenuurl" id="addmenuurl"  size="20"  value=""><br>
						�˵�����<input type="text" name="addmenulvl" id="addmenulvl"  size="20"  readonly><br>
						�˵���ID��<input type="text" name="addmenuparent" id="addmenuparent"  size="20"  readonly><br><br>
						<input type="button" name="delbtn" id="delbtn"  value="����" onclick="addTree();" class="btn_80">
					</div>
					</td>
				</tr>
			</table>
		</s:form>
		</div>
		</div>
		<%
		String trees=(String)request.getAttribute("menuStr");
		%>
		</body>
		<script type=text/javascript src="<%=request.getContextPath()%>/creditapp/js/tree/common-min.js"></script>
		<script type=text/javascript src="<%=request.getContextPath()%>/creditapp/js/tree/TreePanel.js"></script>
		<script type="text/javascript" charset="GBK">
		var treeMenuNode = {};
		function createMenuNode(node){
			treeMenuNode.menuid=document.getElementById("menuid").value;
			treeMenuNode.menuname=document.getElementById("menuname").value;
			treeMenuNode.menuurl=document.getElementById("menuurl").value;
			treeMenuNode.menulvl=document.getElementById("menulvl").value;
			treeMenuNode.menuparent=document.getElementById("menuparent").value;
			treeMenuNode.menustats=document.getElementById("menustats").value;
		}
		var root=<%=trees%>
		//������ѡ��
		root.isbok=false;
		tree = new TreePanel({
				'root' : root,
				'renderTo':'menuTree',
				'handler':seeFocusNode
			});
			tree.render();
			
			function getMenus(){
				var menu='';
				for(var k in tree.nodeHash){
					var node = tree.nodeHash[k];
					if(node.checked==1){
						var value = node.attributes['id']
						if(value != null){
							menu+=value+",";
						}
					}
				}
				document.getElementById("menus").value=menu;
			}
			function seeFocusNode(node){
				if(node!=null){
					document.getElementById("menuid").value=node.attributes.id;
					document.getElementById("menuname").value=node.attributes.text;
					document.getElementById("menuurl").value=node.attributes.url;
					document.getElementById("menulvl").value=node.attributes.lvl;
					document.getElementById("menuparent").value=node.attributes.parent;	
					document.getElementById("menustats").value=node.attributes.sts;
					document.getElementById("spanMsg").innerHTML="";
				}else{
					alert('û��ѡ�нڵ�')
				}
			}
			function delTree(){
				if(!confirm("ȷʵ��ɾ����?")){
					return ;
				}
				var node = tree.focusNode;
				if(node){
					if(!node.isLeaf()){
						alert('���Ӳ˵����޷�ɾ��');
						return false;
					}
					createMenuNode(node);
					var parentNode = node.parentNode;
					if(parentNode){
						sysMgrDwr.menuTreeUpdate("3",treeMenuNode.menuid,treeMenuNode.menuname,treeMenuNode.menuurl,treeMenuNode.menulvl,treeMenuNode.menuparent,treeMenuNode.menustats,function(data){
						if(data==1){
							parentNode.removeChild(node);
							showMsg("ɾ��");
						}else{
							alert('���󣺲˵���Ϣ����');
						}
						});					
					}
				}else{
					alert('�޷�ɾ��');
				}
			}
			function addTreeView(){
				var node = tree.focusNode;
				if(node){
					document.getElementById("menuAdd").style.display="block";
					document.getElementById("addmenulvl").value=parseInt(node.attributes.lvl)+1;
					document.getElementById("addmenuparent").value=node.attributes.id;
				}else{
					alert("��ѡ��Ҫ�����˵��ĸ��˵�!");
				}
			}
			function addTree(){
				var node = tree.focusNode;
				if(node!=null){
					var newNode = createNewNode(node);
					if(tree.getNodeById(document.getElementById("addmenuid").value)!=null){
						alert("�˵�["+document.getElementById("addmenuid").value+"]�Ѿ�����");
						return false;
					}
					sysMgrDwr.menuTreeUpdate("1",document.getElementById("addmenuid").value,document.getElementById("addmenuname").value,document.getElementById("addmenuurl").value,document.getElementById("addmenulvl").value,document.getElementById("addmenuparent").value,"1",function(data){
						if(data==1){
							node.appendChild(newNode);
							document.getElementById("menuAdd").style.display="none";
							showMsg("����");
						}else{
							alert('���󣺲˵���Ϣ����');
						}
					});			
				}else{
					alert('û��ѡ�нڵ�')
				}
			}
			function modTree(){
				var node = tree.focusNode;
				if(node!=null){
					var newNode = createNode(node);
					createMenuNode(node);
					sysMgrDwr.menuTreeUpdate("2",treeMenuNode.menuid,treeMenuNode.menuname,treeMenuNode.menuurl,treeMenuNode.menulvl,treeMenuNode.menuparent,treeMenuNode.menustats,function(data){
						if(data==1){
							node.modChild(newNode);
							showMsg("�޸�");
						}else{
							alert('���󣺲˵���Ϣ����');
						}
					});	
				}else{
					alert('û��ѡ�нڵ�');
				}
			}
			function createNode(node){
				var id=document.getElementById("menuid").value;
				var name=document.getElementById("menuname").value;
				var url=document.getElementById("menuurl").value;
				var lvl=document.getElementById("menulvl").value;
				var parent=node.id;
				var newNode = new TreeNode({'text':name,'id':id,'url':url,'lvl':lvl,'parent':parent,'checked':'0','children':[]});
				return newNode;
			}
			function createNewNode(){
				var id=document.getElementById("addmenuid").value;
				var name=document.getElementById("addmenuname").value;
				var url=document.getElementById("addmenuurl").value;
				var lvl=document.getElementById("addmenulvl").value;
				var parent=document.getElementById("addmenuparent").value;
				var newNode = new TreeNode({'text':name,'id':id,'url':url,'lvl':lvl,'parent':parent,'checked':'null','children':[]});
				return newNode;
			}
			function caleLvl(val){
				if(val.length!=0){
					document.getElementById("menulvl").value = val.length;
				}
			}
			function showMsg(str){
				document.getElementById("spanMsg").innerHTML=str+"�����ɹ�!";
			}
			function expandAll(){
				tree.expandAll();
			}
			function collapseAll(){
				tree.collapseAll();
			}
		</script>
</html>