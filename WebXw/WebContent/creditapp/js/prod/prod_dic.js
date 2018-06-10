	//jquery��dwr.util��ͻ����
	var jq = jQuery.noConflict();
	//�������������б�change��Ӧ�¼�
	function func_query() {
		var model_id = jq("input[type=text][name=model_id]").val();
		if( model_id == "" ) {
			sAlert("��ѡ��ģ����!");
			return false;
		}
		var key_name = jq("input[type=text][name=key_name]").val();
		if( key_name == "" ) {
			sAlert("������Ԫ����!");
			return false;
		}
		
		$.post("ProdDicAction_getProdDicListForQuery.action", 
				{ model_id: model_id, key_name: key_name },     
				function(data) {
					if(data != null) {
						var pos = data.indexOf("}||{");
						var parm_dic_result = data.substr(0,(pos+1));
						var prod_dic_result = data.substr((pos+3));
						fillLeftTable(parm_dic_result);
						fillRightTable(prod_dic_result);
					} else {
						jq("#prod_parm_body").empty();
					}
				}
		);
	}
	//��ʼ��left_table������
	function fillLeftTable(parm_dic_result) {
		if( parm_dic_result == "{}" ) {
			jq("#prod_parm_body").empty();
			return false;
		}
		var results = eval("["+parm_dic_result+"]");//��json��ת��Ϊjs����
		var length = results.length;
		var strHtml = "", key_name = "",opt_code="",opt_name="", seqn;
		for(var i = 0; i < length; i++) {
			seqn = (1000 + parseInt(results[i].seqn));//��ֹ��right_table.tr��id�ظ�
			opt_code = results[i].opt_code;
			opt_name = results[i].opt_name;
			var style='';
			if((i+1)%2==0){
				style='background-color:#F3FAF3;height:21px; line-height:21px;'
			}else{
				style='background-color:#fff;height:21px; line-height:21px;';
			}
			strHtml += "<tr id=\"left_tr_" + seqn + "\" style="+style+" >";
			strHtml += "<td align='center'><input type=\"checkbox\" id=\"left_checkbox_";
			strHtml += seqn + "\" value='" + seqn + "' /></td>";
			strHtml += "<td id=\"left_td_" + seqn + "\" align='center' onclick=\"left_td_click(this)\">";
			strHtml += "" + opt_code + "</td>";//Ҫ�ر���
			strHtml += "<td onclick=\"left_td_click(this)\">";
			strHtml += "" + opt_name + "</td>";//Ҫ��������
			strHtml += "<input type=\"hidden\" id=\"left_col_name_"+seqn+"\" value='"+opt_name+"' />";//Ҫ����
			strHtml += "</tr>";
		}
		jq("#prod_parm_body").html(strHtml);
	}
	
	//��ʼ��right_table������
	function fillRightTable(prod_dic_result) {
		if( prod_dic_result == "{}" ) {
			jq("#prod_item_body").empty();
			return false;
		}
		var results = eval("["+prod_dic_result+"]");
		var length = results.length;
		var strHtml = "", key_name = "",opt_code="",opt_name="", seqn;
		for(var i = 0; i < length; i++) {
			seqn = results[i].seqn;
			key_name = results[i].key_name;
			opt_code = results[i].opt_code;
			opt_name = results[i].opt_name;
			var style='';
			if((i+1)%2==0){//�����б���ɫ
				style='background-color:#F3FAF3;'
			}else{
				style='background-color:#fff;';
			}
	    	strHtml += "<tr id=\"right_tr_" + seqn + "\" style="+style+">";
			strHtml += "<td   align=\"center\"><input type=\"checkbox\" id=\"right_checkbox_";
			strHtml += seqn + "\" value='" + seqn + "'/></td>";
			strHtml += "<td id=\"right_td_" + seqn + "\" onclick=\"right_td_click(this)\" align=\"center\">" + opt_code+"</td>";//Ҫ����������
			strHtml += "<td   align=\"center\">" + opt_name + "</td>";//������
			strHtml += "<td   align=\"center\">" + seqn + "</td>";//�д�
			strHtml += "<input type=\"hidden\" id=\"right_col_code_"+seqn+"\" value='"+opt_code+"' />";//Ҫ����
			strHtml += "<input type=\"hidden\" id=\"right_col_name_"+seqn+"\" value='"+opt_name+"' />";//Ҫ����
			strHtml += "</tr>";//���
		}
		jq("#prod_item_body").html(strHtml);
	}	
	
	//���ģ���е�Ԫ�񵥻���Ӧ�¼�
	function left_td_click(obj) {
		var hasSelected = !(jq(obj).parents("tr").find(":checkbox").attr("checked"));
		if(hasSelected) {
			jq(obj).parents("tr").children().removeClass("TDstyle01");
			jq(obj).parents("tr").css("background-color","#cccccc");
			jq(obj).parents("tr").css("font-size","12px");
		} else {
			jq(obj).parents("tr").children().addClass("TDstyle01");
		}
		jq(obj).parents("tr").find(":checkbox").attr("checked",hasSelected);
	}
	
	//�ұ�ģ���е�Ԫ�񵥻���Ӧ�¼�
	function right_td_click(obj) {
		var hasSelected = !(jq(obj).parents("tr").find(":checkbox").attr("checked"));
		if(hasSelected) {
			jq(obj).parents("tr").children().removeClass("TDstyle01");
			jq(obj).parents("tr").css("background-color","#cccccc");
			jq(obj).parents("tr").css("font-size","12px");
		} else {
			jq(obj).parents("tr").children().addClass("TDstyle01");
		}
		jq(obj).parents("tr").find(":checkbox").attr("checked",hasSelected);
	}	
	
	//���ģ���и�ѡ����Ӧ�¼�
	function left_checkbox_click(obj,group_no) {
		var tr_obj = jq(obj).parents("tr");
		var hasSelected = obj.checked;
		if( group_no != ""&&group_no!="null" ) {
			jq(("input[type=hidden][name=left_group_"+group_no+"]")).each(
				function() {
					var tr_obj = jq(this).parents("tr");
					if(hasSelected) {
						jq(tr_obj).children().removeClass("TDstyle01");
						jq(tr_obj).css("background-color","#cccccc");
						jq(tr_obj).css("font-size","12px");
					} else {
						jq(tr_obj).children().addClass("TDstyle01");
						jq(tr_obj).css("font-size","12px");
					}
					jq(tr_obj).find(":checkbox").attr("checked",hasSelected);
				}
			);
		} else {
			if(hasSelected) {
			jq(tr_obj).children().removeClass("TDstyle01");
			jq(tr_obj).css("background-color","#cccccc");
			jq(obj).parents("tr").css("font-size","12px");
			} else {
				jq(tr_obj).children().addClass("TDstyle01");
			}
			obj.checked=hasSelected;
		}
	}
	
	//�ұ�ģ���и�ѡ����Ӧ�¼�
	function right_checkbox_click(obj,group_no) {
		var tr_obj = jq(obj).parents("tr");
		var hasSelected = obj.checked;
		if( group_no != ""&&group_no!="null" ) {
			jq(("input[type=hidden][name=right_group_"+group_no+"]")).each(
				function() {
					var tr_obj = jq(this).parents("tr");
					if(hasSelected) {
						jq(tr_obj).children().removeClass("TDstyle01");
						jq(tr_obj).css("background-color","#cccccc");
						jq(tr_obj).css("font-size","12px");
					} else {
						jq(tr_obj).children().addClass("TDstyle01");
						jq(tr_obj).css("font-size","12px");
					}
					jq(tr_obj).find(":checkbox").attr("checked",hasSelected);
				}
			);
		} else {	
			if(hasSelected) {
				jq(tr_obj).children().removeClass("TDstyle01");
				jq(tr_obj).css("background-color","#cccccc");
				jq(obj).parents("tr").css("font-size","12px");
			} else {
				jq(tr_obj).children().addClass("TDstyle01");
			}
			obj.checked=hasSelected;
		}
	}	
	
	//�����ƶ�ѡ��ģ��
	function func_toright() {
		var total = jq("input[type=checkbox][id*=left_checkbox_][checked]").length;
    	if(total <= 0) {
      		sAlert("��ѡ��һ����¼");
	      	return false;
	    }
	    jq("input[type=checkbox][id*=left_checkbox_][checked]").each(function() {
	    	var left_tr = jq(this).parents("tr");
	    	//��ȡ��ѡ���е�seqn��col_name
	    	var seqn = jq(this).val();
	    	var opt_code = jq(("#left_td_"+seqn)).text();
	    	var opt_name = jq("input[type=hidden][id=left_col_name_"+seqn+"]").val();
	    	//׷�ӵ�right_table��
	    	var strHtml = "";
	    	strHtml += "<tr id=\"right_tr_" + seqn + "\" >";
			strHtml += "<td class=\"TDstyle01\" align=\"center\"><input type=\"checkbox\" id=\"right_checkbox_";
			strHtml += seqn + "\" value='" + seqn + "'/></td>";
			strHtml += "<td id=\"right_td_" + seqn + "\" class=\"TDstyle01\" align=\"center\" onclick=\"right_td_click(this)\">" + opt_code + "</td>";//Ҫ����������
			strHtml += "<td class=\"TDstyle01\" align=\"center\">" + opt_name + "</td>";//�ɷ�Ϊ��
			strHtml += "<td class=\"TDstyle01\" align=\"center\">&nbsp;</td>";//�д�
			strHtml += "<input type=\"hidden\" id=\"right_col_code_"+seqn+"\" value='"+opt_code+"' />";//Ҫ����
			strHtml += "<input type=\"hidden\" id=\"right_col_name_"+seqn+"\" value='"+opt_name+"' />";//Ҫ����
			strHtml += "</tr>";//��
	    	jq("#prod_item_body").append(strHtml);
	    	//ɾ����ѡ����
	    	jq(left_tr).remove();
	    	reorg_table("prod_item_body");
	    });
	}
	
	//�����ƶ�ѡ��ģ��
	function func_toleft() {
		var total = jq("input[type=checkbox][id*=right_checkbox_][checked]").length;
    	if(total <= 0) {
      		sAlert("��ѡ��һ����¼");
	      	return false;
	    }
	    jq("input[type=checkbox][id*=right_checkbox_][checked]").each(function() {
	    	var right_tr = jq(this).parents("tr");
	    	//��ȡ��ѡ���е�seqn��col_name
	    	var seqn = jq(this).val();
	    	var opt_code = jq(("#right_td_"+seqn)).text();
	    	var opt_name = jq("input[type=hidden][id=right_col_name_"+seqn+"]").val();
	    	//׷�ӵ�left_table��
	    	var strHtml = "";
	    	strHtml += "<tr id=\"left_tr_" + seqn + "\" >";
			strHtml += "<td class=\"TDstyle01\" align='center'><input type=\"checkbox\" id=\"left_checkbox_";
			strHtml += seqn + "\" value='" + seqn + "'/></td>";
			strHtml += "<td id=\"left_td_" + seqn + "\" class=\"TDstyle01\" align='center' onclick=\"left_td_click(this)\">" + opt_code + "</td>";//Ҫ��������
			strHtml += "<td class=\"TDstyle01\">" + opt_name + "</td>";//Ҫ��������
			strHtml += "<input type=\"hidden\" id=\"left_col_name_"+seqn+"\" value='"+opt_name+"' />";//Ҫ����
			strHtml += "</tr>";//��
			jq("#prod_parm_body").append(strHtml);
	    	//ɾ����ѡ����
	    	jq(right_tr).remove();
	    	reorg_table("prod_item_body");
	    });
	}
	
	//�����ƶ�ѡ����
	function func_moveup() {
		var total = jq("input[type=checkbox][id*=right_checkbox_][checked]").length;
    	if(total <= 0) {
      		sAlert("��ѡ��һ����¼");
	      	return false;
	    }
	    if( total > 1 ) {
	    	sAlert("�Բ���ֻ��ѡ��һ�м�¼�ƶ�λ�ã�");
	      	return false;
	    }
	    var checkbox_obj = (jq("input[type=checkbox][id*=right_checkbox_][checked]"))[0];
	    moveUp(checkbox_obj);
	}
	
	//�����ƶ�ѡ����
	function func_movedown() {
		var total = jq("input[type=checkbox][id*=right_checkbox_][checked]").length;
    	if(total <= 0) {
      		sAlert("��ѡ��һ����¼");
	      	return false;
	    }
	    if( total > 1 ) {
	    	sAlert("�Բ���ֻ��ѡ��һ�м�¼�ƶ�λ�ã�");
	      	return false;
	    }
	    var checkbox_obj = (jq("input[type=checkbox][id*=right_checkbox_][checked]"))[0];
	    moveDown(checkbox_obj);
	}	
	
	//ʹ��������ƣ����ղ���Ϊ��Ԫ���ڵĶ���(��ǰ�Ǹ�ѡ��)
	function moveUp(checkbox_obj) {
		//ͨ����ѡ������ȡ����е�����
 		var tr_obj=checkbox_obj.parentNode.parentNode;
 		//������ǵ�һ�У�������һ�н���˳��
 		if(tr_obj.previousSibling)swapNode(tr_obj,tr_obj.previousSibling);
	}
	
	//ʹ��������ƣ����ղ���Ϊ��Ԫ���ڵĶ���(��ǰ�Ǹ�ѡ��)
	function moveDown(checkbox_obj) {
 		//ͨ����ѡ������ȡ����е�����
 		var tr_obj=checkbox_obj.parentNode.parentNode;
 		//����������һ�У�������һ�н���˳��
 		if(tr_obj.nextSibling)swapNode(tr_obj,tr_obj.nextSibling);
	}
	
	//����ͨ�õĺ���������������λ��
	function swapNode(node1,node2) {
 		//��ȡ�����
		var _parent=node1.parentNode;
		//��ȡ�����������λ��
		var _t1=node1.nextSibling;
		var _t2=node2.nextSibling;
		//��node2���뵽ԭ��node1��λ��
		if(_t1)_parent.insertBefore(node2,_t1);
		else _parent.appendChild(node2);
		//��node1���뵽ԭ��node2��λ��
		if(_t2)_parent.insertBefore(node1,_t2);
		else _parent.appendChild(node1);
		reorg_table("prod_item_body");
	}
	
	//���ڲ�Ʒ����Ҫ������֮��ı��棨����󲢲�������һ������ҳ����ǽ����˴����ã�
	function func_save() {
		var model_id = jq("input[type=text][name=model_id]").val();
		if(model_id == "") {
      		sAlert("��ѡ��ģ����!");
	      	return false;
	    }
	    var key_name = jq("input[type=text][name=key_name]").val();
		if( key_name == "" ) {
			sAlert("��ѡ��Ҫ������!");
			return false;
		}
		var total = jq("input[type=checkbox][id*=right_checkbox_]").length;
    	if(total <= 0) {
      		sAlert("�����߱����ѡ���¼������Ʒģ��!");
	      	return false;
	    }
	    var seqn_number = 1;
	    var opt_code = "", opt_name = "";
	    var str_seqn = "", str_opt_code = "", str_opt_name = "";
	    var select_obj;
	    jq("input[type=checkbox][id*=right_checkbox_]").each(function() {
	    	var right_tr = jq(this).parents("tr");
	    	//��ȡ��ѡ���е�seqn��col_name
	    	seqn = jq(this).val();
	    	opt_code = jq("input[type=hidden][id=right_col_code_"+seqn+"]").val();;
	    	str_opt_code += opt_code + ",";
	    	//Ҫ����
	    	opt_name = jq("input[type=hidden][id=right_col_name_"+seqn+"]").val();
	    	str_opt_name += opt_name + ",";
	    	//ƴ�д�
	    	str_seqn += seqn_number + ",";
	    	seqn_number++;
	    });
	    jq("#prodDic_model_id").val(model_id);
	    jq("#prodDic_key_name").val(key_name);
	    jq("#prodDic_opt_code").val(str_opt_code);
	    jq("#prodDic_opt_name").val(str_opt_name);
	    jq("#prodDic_seqnString").val(str_seqn);
	    
	    document.operform.action = "ProdDicAction_insertOrUpdate.action";
	    document.operform.submit();
	}
	
	//����right_table(tbody)�е��У������������д�
	function reorg_table(obj_id) {
		jq(("#"+obj_id+">tr")).each(function() {
	    	var row_number = (jq(this)[0]).rowIndex;
	    	jq(this).find("td:eq(3)").html(row_number);
	    });
	}
	
