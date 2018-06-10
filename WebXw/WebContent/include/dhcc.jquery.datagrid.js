//״̬����(0��������1����ѡ���У�2�������޸ģ�3����������)
//��������(0���ַ�����1�������ͣ�4��������(����)��10/6��ѡ����5�������12�������)
/**
 * ΪJS��String������ӷ���
 * @param {Object} s
 * @memberOf {TypeName} 
 * @return {TypeName} 
 */
String.prototype.StartWith=function(s){
  if(s==null||s==""||this.length==0||s.length>this.length)
	  return false;
  if(this.substr(0,s.length)==s)
	  return true;
  else
	  return false;
  return true;
}
/**
 * ��ȡ�����¼�����(����FF)
 * @return {Event} 
 */
function getEvent(){
	if(document.all)
		return window.event;
	func = getEvent.caller;
	while(func!=null){
		var arg0=func.arguments[0];
		if(arg0){
			if((arg0.constructor==Event || arg0.constructor ==MouseEvent)
					|| (typeof(arg0)=="object" && arg0.preventDefault && arg0.stopPropagation)){
				return arg0;
			}
		}
		func=func.caller;
	}
	return null;
}
function deleteRow(){
	var evt = getEvent();
	var obj = evt.srcElement || evt.target;
	if(obj!=null){
		$(obj).parent('td').parent('tr').deleteRow();
	}
}
function editRow(){
	var evt = getEvent();
	var obj = evt.srcElement || evt.target;
	if(obj!=null){
		$(obj).parent('td').parent('tr').editRow();
	}
}
(function($){
	$.fn.VQuerySwitch = function(){
		var v_table = this;
		query_status = v_table.data("query_status");
		if(query_status==null || typeof(query_status) == "undefined"){
			query_status = 1;
		}
		if(query_status == 1){
			$("div[listid]").hide();
			v_table.data("query_status",0);
		}else {
			$("div[listid]").show();
			v_table.data("query_status",1);
		}
	},
	/**
	 * ��ʼ������
	 * @memberOf {TypeName} 
	 */
	$.fn.VEditGrid = function(){
		this.data("v_status",0);
		var v_headers = new Array();
		this.find("thead > tr > th").each(function(){
			var _type = $(this).attr("type");
			if(_type!="5"){	//������ť
				var v_columnData = {
					v_fieldName:$(this).attr("fieldName"),//������
					v_title:$(this).text(),//������
					v_type:_type,//��������
					v_mustinput:$(this).attr("mustinput"),//�Ƿ����
					v_canwrite:$(this).attr("canwrite"),//�Ƿ�ֻ��
					v_dataoption:$(this).attr("dataoption"),//ѡ��������
					v_fieldAlign:$(this).attr("fieldAlign"),//���뷽ʽ
					v_default:$(this).attr("default")//Ĭ��ֵ
				};
				v_headers.push(v_columnData);
			}
		});
		this.find("tbody > tr").each(function(){
			$(this).live("dblclick",function(){$(this).editRow();});
		});
		this.setRowBgClass();
		this.data("v_headers",v_headers);

		var v_options = arguments[0];
		var default_options={
			pageSize:10,
			linkClass:"abatch",
			oddRowClass:"t2",//��������ʽ
			evenRowClass:"t1",//ż������ʽ
			overRowClass:"t3",//����ƶ�����ʽ
			updateUrl:"",
			insertUrl:"",
			deleteUrl:"",
			linkUrlArray:[],//�Զ����������飬��ʽΪ[{name:"�鿴",url:"XX.action",params:["id","name"]},{name:"����",url:"XX.action",params:["id","name"]}]
			listUrl:"",
			onListReload:function(){},
			onInsertRow:function(){},
			onSelectRow:function(){},
			onEditRow:function(){},
			onDeleteRow:function(){}
		};
        // ���鷽���Ƿ����
        if(!v_options) {
			v_options = default_options;
        }else {
			$.extend(default_options,v_options);
		}
		this.data("v_options",default_options);
	},
	/**
	 * �����б�ĸ��л�ɫЧ��
	 * @param {Object} oddRowClass
	 * @param {Object} evenRowClass
	 * @param {Object} overRowClass
	 * @memberOf {TypeName} 
	 */
	$.fn.setRowBgClass = function(oddRowClass,evenRowClass,overRowClass){
		if(typeof(oddRowClass)=="undefined"){
			oddRowClass = "t2";
		}
		if(typeof(evenRowClass)=="undefined"){
			evenRowClass = "t1";
		}
		if(typeof(overRowClass)=="undefined"){
			overRowClass = "t3";
		}
		var _rownum = 1;
		var _table = this;
		_table.find("tbody tr").each(function(){
			var _tclass;
			if(_rownum%2==0){
				_tclass = oddRowClass;
			}else {
				_tclass = evenRowClass;
			}
			$(this).addClass(_tclass);
			if(typeof(overRowClass)!=undefined && overRowClass!=null && overRowClass!=""){
				$(this).bind("mouseover", function(){
					$(this).attr("oldClass",$(this).attr("class"));
					$(this).attr("class",$(this).attr("class").replace(_tclass,overRowClass));
				});
				$(this).bind("mouseout", function(){
					$(this).attr("class",$(this).attr("oldClass"));
				});
			}
			_rownum++;
		});
	},
	/**
	 * ��ȡ�б�����е�HTML
	 * @memberOf {TypeName} 
	 * @return {TypeName} 
	 */
	$.fn.getOperationHTML=function(){
		var v_headers = this.data("v_headers");
		var v_options = this.data("v_options");
		var v_htmlVal = "";
		if(v_options.updateUrl!=null && v_options.updateUrl!=""){
			v_htmlVal += "<a href='javascript:void(0);' class='"+v_options.linkClass+"' onclick=\"javascript:$(this).parent('td').parent('tr').editRow();\">�޸�</a>";
		}
		if(v_options.deleteUrl!=null && v_options.deleteUrl!=""){
			if(v_htmlVal!=""){
				v_htmlVal += "&nbsp;|&nbsp;";
			}
			v_htmlVal += "<a href='javascript:void(0);' class='"+v_options.linkClass+"' onclick=\"javascript:$(this).parent('td').parent('tr').deleteRow();\">ɾ��</a>";
		}
		if(v_options.linkUrlArray!=null){
			for(var i=0;i<v_options.linkUrlArray.length;i++){
				var linkUrlObj = v_options.linkUrlArray[i];
				var paramStr = "";
				
				/*for(var j=0;j<v_headers.length;j++){
					var v_header = v_headers[j];
					if(v_header.v_type!=5){
						for(var k=0;k<linkUrlObj.params.length;k++){
							if(v_header.v_fieldName==linkUrlObj.params[k]){
								
							}
						}
					}
				}*///δ�����
				if(v_htmlVal!=""){
					v_htmlVal += "&nbsp;|&nbsp;";
				}
				v_htmlVal += "<a href='"+linkUrlObj.url+paramStr+"' class='"+v_options.linkClass+"'>"+linkUrlObj.name+"</a>";
			}
		}
		return v_htmlVal;
	},
	/**
	 * ��������/�༭״̬�µĵ��м�¼��������̨
	 * @memberOf {TypeName} 
	 * @return {TypeName} 
	 */
	$.fn.saveRowData=function(){
		var v_status = this.data("v_status");
		var v_options = this.data("v_options");
		var v_row_index = this.data("v_row_index");
		var v_headers = this.data("v_headers");
		var v_table = this;
		var v_url = "";
		if(v_status==2){
			v_url = v_options.updateUrl;
		}else if(v_status==3){
			v_url = v_options.insertUrl;
		}else {
			return;
		}
		var v_data = "";
		var v_tr = v_table.find("tbody > tr:eq("+v_row_index+")");
		var v_colIndex = 0;
		var v_valiv_msg = null;
		v_tr.children().each(function(){
			var hv_varis = v_headers[v_colIndex];
			if(typeof hv_varis != undefined && hv_varis != null){
				v_data += hv_varis.v_fieldName + ":";
				var v_val;
				if(hv_varis.v_canwrite=="1"){
					if(hv_varis.v_type==0 || hv_varis.v_type==4){
						v_val = $(this).find("input:text").val();
					}else if(hv_varis.v_type==10 || hv_varis.v_type==6){
						v_val = $(this).find("select").val();
					}else if(hv_varis.v_type==1){
						v_val = $(this).find("input:text").val()
						v_val = v_val==null?"":v_val.replace(/-/g,"");
					}else if(hv_varis.v_type==12){
						v_val = $(this).find("input:text").val()
						v_val = v_val==null?"":v_val.replace(/,/g,"");
					}
				}else {
					v_val = $.trim($(this).text());
					if(hv_varis.v_type==10 || hv_varis.v_type==6){
						var v_options = eval("("+hv_varis.v_dataoption+")");
						for(var prop in v_options){
							if(v_val==v_options[prop]){
								v_val = prop;
							}
						}
					}else if(hv_varis.v_type==1){
						v_val = v_val.replace(/-/g,"");
					}else if(hv_varis.v_type==12){
						v_val = v_val.replace(/,/g,"");
					}
				}
				if(hv_varis.v_mustinput=="1" && $.trim(v_val)==""){
					v_valiv_msg = "["+hv_varis.v_title+"]����Ϊ��!";
					return ;
				}
				v_data += "'" + v_val + "',";
			}
			v_colIndex++;
		});
		if(v_valiv_msg!=null){
			alert(v_valiv_msg);
			return false;
		}
		if(v_data!=""){
			v_data = "{"+v_data.substr(0,v_data.length-1)+"}";
		}
		$.post(v_url,{ajaxData:encodeURI(v_data)},function(resultStr){
			alert(v_data);
			if(!resultStr.StartWith("success")){
				alert(resultStr);
			}else {
				//v_table.VRestoreRow(true,resultStr);
				VPageGo(v_table.attr("id"));
				v_table.data("v_status",0);
			}
		});
	},
	/**
	 * ɾ����������(��������Ϊ$("tr"))
	 * @memberOf {TypeName} 
	 */
	$.fn.deleteRow = function(){
		var _tr = this;
		var _table = _tr.parent("tbody").parent("table");
		_table = $("#"+_table.attr("id"));
		var _options = _table.data("v_options");
		var _headers = _table.data("v_headers");
		if(confirm("ȷ��ɾ��������¼?")){
			var _data = "";
			var _colIndex = 0;
			_tr.children().each(function(){
				var h_varis = _headers[_colIndex];
				if(typeof h_varis != undefined && h_varis != null){
					if(h_varis.v_type!=9){
						_data += "," + h_varis.v_fieldName + ":'" + $.trim($(this).text()) + "'";
					}
				}
				_colIndex++;
			});
			if(_data!=""){
				_data = "{" + _data.substr(1,_data.length-1) + "}";
				$.post(_options.deleteUrl,{ajaxData:encodeURI(_data)},function(resultStr){
					if(!resultStr.StartWith("success")){
						alert(resultStr);
					}else {
						//_tr.remove();
						alert("�����ɹ�!");
						VPageGo(_table.attr("id"));
						_table.data("v_status",0);
					}
				});
			}
		}
	},
	/**
	 * ��ȡ�б�Ĳ�ѯ��Ϣ
	 * @memberOf {TypeName} 
	 * @return {TypeName} 
	 */
	$.fn.getQueryDate = function(){
		var queryDiv = $("div[listid='"+this.attr("id")+"']");
		var dataStr = "{";
		
		var _texts = queryDiv.find("input:text");
		var _hiddens = queryDiv.find("input:hidden");
		for(var i=0;i<_texts.size();i++){
			var val = $.trim($(_texts.get(i)).val());
			if(val!=""){
				dataStr += ($(_texts.get(i)).attr("name") + ":" + "'" + encodeURI(val) + "',");
			}
		}
		for(var i=0;i<_hiddens.size();i++){
			var val = $.trim($(_hiddens.get(i)).val());
			if(val!=""){
				dataStr += ($(_hiddens.get(i)).attr("name") + ":" + "'" + encodeURI(val) + "',");
			}
		}
		var _selects = queryDiv.find("select option:selected");
		for(var i=0;i<_selects.size();i++){
			var val = $.trim($(_selects.get(i)).val());
			if(val!=""){
				dataStr += ($(_selects.get(i)).parent("select").attr("name") + ":" + "'" + val + "',");
			}
		}
		
		var result = (dataStr.length>1?(dataStr.substr(0,dataStr.length-1)+"}"):dataStr+"}");
		return result;
	},
	$.fn.VRestoreRow = function(dataChanged,returnStr){
		var v_row_index = this.data("v_row_index");
		var v_headers = this.data("v_headers");
		var v_status = this.data("v_status");
		var v_options = this.data("v_options");
		var v_table = this;
		if(typeof(dataChanged)==undefined || dataChanged==null){
			dataChanged = false;
		}
		var v_tr = v_table.find("tbody > tr:eq("+v_row_index+")");
		var v_linkv_html = v_table.getOperationHTML();
		if(v_status==2){
			var v_colIndex = 0;
			v_tr.children().each(function(){
				var hv_varis = v_headers[v_colIndex];
				if(typeof hv_varis != undefined && hv_varis != null){
					if(typeof hv_varis.v_canwrite != undefined && hv_varis.v_canwrite != null && hv_varis.v_canwrite=="1"){
						if(typeof hv_varis != undefined && hv_varis != null){
							var v_oldval = $(this).attr("oldval");
							var v_realVal = "";
							var isHtml = false;
							if(hv_varis.v_type==0){
								if(dataChanged){
									v_oldval = $(this).find("input:text").val();
									v_realVal = v_oldval;
								}
							}else if(hv_varis.v_type==1){
								if(dataChanged){
									v_oldval = $(this).find("input:text").val();
									v_realVal = v_oldval.replace(/-/g,"");
								}
							}else if(hv_varis.v_type==12){
								if(dataChanged){
									v_oldval = $(this).find("input:text").val();
								}
							}else if(hv_varis.v_type==10 || hv_varis.v_type==6){
								if(dataChanged){
									v_oldval = $(this).find("select option:selected").text();
									v_realVal = v_oldval;
								}else {
									var v_options = eval("("+hv_varis.v_dataoption+")");
									for(var prop in v_options){
										if(prop==v_oldval){
											v_oldval = v_options[prop];
										}
									}
								}
							}else if(hv_varis.v_type==5){
								v_oldval = v_linkv_html;
								isHtml = true;
							}
							if(v_realVal!=""){
								$(this).attr("v_val",v_realVal);
							}
							$(this).empty();
							if(isHtml){
								$(v_oldval).appendTo($(this));
							}else {
								$(this).text(v_oldval);
							}
						}
					}
				}
				v_colIndex++;
			});
		}else  if(v_status==3){
			var v_colIndex = 0;
			if(dataChanged){
				var v_keyArray = returnStr.split(",");//����������ʱ���ص���������
				v_tr.children().each(function(){
					var hv_varis = v_headers[v_colIndex];
					if(typeof hv_varis != undefined && hv_varis != null){
						var v_key = null;
						var v_value = null;
						for(var i=0;i<v_keyArray.length;i++){
							var keyValue = v_keyArray[i];
							if(keyValue.indexOf(hv_varis.v_fieldName+":")>=0){
								v_key = hv_varis.v_fieldName;
								v_value = keyValue.replace(hv_varis.v_fieldName+":","");
							}
						}
						if(v_key!=null){
							$(this).empty();
							$(this).text(v_value);
						}else {
							var v_oldval = "";
							if(hv_varis.v_type==0){
								v_oldval = $(this).find("input:text").val();
							}else if(hv_varis.v_type==1){
								v_oldval = $(this).find("input:text").val();
							}else if(hv_varis.v_type==12){
								v_oldval = $(this).find("input:text").val();
							}else if(hv_varis.v_type==10 || hv_varis.v_type==6){
								v_oldval = $(this).find("select option:selected").text();
							}else if(hv_varis.v_type==5){
								v_oldval = v_linkv_html;
							}
							$(this).empty();
							$(this).html(v_oldval);
						}
					}
					v_colIndex++;
				});
				v_tr.bind("dblclick",function(){v_tr.editRow();});
			}else {
				var v_tr = v_table.find("tbody > tr:eq("+v_row_index+")").remove();
			}
		}
		v_table.data("v_status",0);
	},
	$.fn.editRow = function(){
		var v_table = this.parent("tbody").parent("table");
		var v_status = v_table.data("v_status");
		
		if(v_status!=0 && v_status!=1){
			return false;
		}
		var v_row_index = this.prevAll().size();
		var v_headers = v_table.data("v_headers");
		v_table.data("v_status",2);
		v_table.data("v_row_index",v_row_index);
		var v_colIndex = 0;
		this.children().each(function(){
			var hv_varis = v_headers[v_colIndex];
			if(typeof hv_varis != undefined && hv_varis != null){
				if(typeof hv_varis.v_canwrite != undefined && hv_varis.v_canwrite != null && hv_varis.v_canwrite=="1"){//����Ƿ�ֻ��
					var v_oldval = $(this).text();
					$(this).attr("oldval",v_oldval);
					if(hv_varis.v_type==4){//�����ӣ�������
						var v_height = $(this).height() - 5;
						var v_width = $(this).width() - 10;
						$(this).empty();
						$(this).html("<input type='text' name='"+hv_varis.v_fieldName+"' value='"+v_oldval+"' style='width:"+v_width+"px;height:"+v_height+"px;' readonly class='BOTTOM_LINE'/>");
					}else if(hv_varis.v_type==0){//�����ַ���
						var v_height = $(this).height() - 5;
						var v_width = $(this).width() - 10;
						$(this).empty();
						$(this).html("<input type='text' name='"+hv_varis.v_fieldName+"' value='"+v_oldval+"' style='width:"+v_width+"px;height:"+v_height+"px;'/>");
					}else if(hv_varis.v_type==1){//������
						var v_height = $(this).height() - 5;
						var v_width = $(this).width() - 10;
						$(this).empty();
						$(this).html("<input type='text' name='"+hv_varis.v_fieldName+"' value='"+v_oldval+"' style='width:"+v_width+"px;height:"+v_height+"px;' onClick='fPopUpCalendarDlg(this);' class='datelogo' readonly/>");
					}else if(hv_varis.v_type==12){//�����
						var v_height = $(this).height() - 5;
						var v_width = $(this).width() - 10;
						$(this).empty();
						$(this).html("<input type='text' name='"+hv_varis.v_fieldName+"' value='"+v_oldval+"' style='width:"+v_width+"px;height:"+v_height+"px;' onBlur='func_uior_valTypeImm(this);resetTimes();' onFocus='selectInput(this);' onkeyup='toMoney(this)' onmousedown='enterKey()' onkeydown='enterKey();'/>");
					}else if(hv_varis.v_type==10 || hv_varis.v_type==6){//ѡ����
						var v_height = $(this).height() - 5;
						var v_width = $(this).width() - 10;
						var v_selectv_cont = "<select name='"+hv_varis.v_fieldName+"' value='"+v_oldval+"' style='width:"+v_width+"px;height:"+v_height+"px;'>";
						
						v_selectv_cont += "<option value=''></option>";
						var v_options = eval("("+hv_varis.v_dataoption+")");
						for(var prop in v_options){
							if(prop==v_oldval || v_options[prop]==v_oldval){
								v_selectv_cont += "<option value='"+prop+"' selected>"+v_options[prop]+"</option>";
							}else {
								v_selectv_cont += "<option value='"+prop+"'>"+v_options[prop]+"</option>";
							}
						}
						v_selectv_cont += "</select>";
						$(this).empty();
						$(this).html(v_selectv_cont);
					}
				}
			}
			v_colIndex++;
		});
	},
	/**
	 * ����һ���У�
	 * @memberOf {TypeName} 
	 * @return {TypeName} 
	 */
	$.fn.insertRow=function(){
		var v_status = this.data("v_status");
		var v_headers = this.data("v_headers");
		if(v_status!=0 && v_status!=1){
			return false;
		}
		var v_insertv_html = "<tr>";
		for(var i=0;i<v_headers.length;i++){
			v_insertv_html += "<td align=\""+v_headers[i].v_fieldAlign+"\"></td>";
		}
		v_insertv_html += "</tr>";
		$(v_insertv_html).prependTo(this.find("tbody"));
		this.find("tbody tr:first").editRow();
		this.data("v_row_index",0);
		this.data("v_status",3);
		this.data("v_options").onInsertRow();
	},
	/**
	 * ��ȡ�б����ݣ�ˢ����ʾ
	 * @param {Object} v_data �б��ѯ����
	 * @param {Object} v_pageNo �ڼ�ҳ
	 * @param {Object} v_pageSize ÿҳ��¼��
	 * @memberOf {TypeName} 
	 */
	$.fn.getPageList = function(v_data,v_pageNo,v_pageSize){
		var v_table = this;
		var listid = this.attr("id");
		var v_pageform = $("table[listid='"+listid+"']");
		listUrl = v_table.attr("action");
		var data = v_table.getQueryDate();
		if(typeof v_pageNo == undefined || v_pageNo==null || isNaN(v_pageNo)){
			v_pageNo = v_pageform.find("input[name=eadis_page]").val();
		}
		if(typeof v_pageNo == undefined || v_pageNo==null || isNaN(v_pageNo)){
			v_pageNo = 1;
		}else {
			v_pageNo = parseInt(v_pageNo,10);
		}
		if(typeof v_pageSize == undefined || v_pageSize==null || isNaN(v_pageSize)){
			v_pageSize = v_pageform.find("input[name=pageSize]").val();
		}
		if(typeof v_pageSize == undefined || v_pageSize==null || isNaN(v_pageSize)){
			v_pageSize = 10;
		}else {
			v_pageSize = parseInt(v_pageSize,10);
		}
		if(v_data==null){
			v_data = v_table.getQueryDate();
		}
		$.post(listUrl,{ajaxData:v_data,eadis_page:v_pageNo,pageSize:v_pageSize},function(data){
			data = $.trim(data);
			if(data!="fail"){
				try{
					var returnObj = eval("(" + data + ")");
					VTransJsonToHtml(v_table, returnObj.list);
					if(returnObj.ipage!=null && typeof(returnObj.ipage)!="undifined"){
						VChangeEadis(v_table, returnObj.ipage,v_pageNo,v_pageSize);
					}
				} catch(e) {
					//alert(e);
				}
			}else {
				alert("�б�ˢ�²�ѯʧ��!");
			}
		});
	}
})(jQuery);
function VChangeEadis(v_table, v_ipage, v_pageNo, v_pageSize){
	var listid = v_table.attr("id");
	var action = v_table.attr("action");
	var pagev_form = $("table[listid='"+listid+"']").find("div.page_wn").find("ul");
	if(pagev_form.get(0)){
		if(v_ipage.hasNext){
			pagev_form.find("li:eq(5)").attr("class","nextPage");
			pagev_form.find("li:eq(5)").bind("click",function(){VPageGo(listid,action,v_pageNo+1);});
			pagev_form.find("li:eq(6)").attr("class","lastPage");
			pagev_form.find("li:eq(6)").bind("click",function(){VPageGo(listid,action,v_ipage.pageSum);});
			if(!v_ipage.hasPrevious){
				pagev_form.find("li:eq(3)").attr("class","prevPageDisabled");
				pagev_form.find("li:eq(3)").unbind("click");
			}
			if(v_pageNo==1){
				pagev_form.find("li:eq(2)").attr("class","firstPageDisabled");
				pagev_form.find("li:eq(2)").unbind("click");
			}
			//pagev_form.find("li:eq(5)").html("<a href='javascript:void(0)' onclick=\"VPageGo('"+listid+"','"+action+"',"+(v_pageNo+1)+");\"><span class=\"nextPage\"/></a>");
			//pagev_form.find("li:eq(6)").html("<a href='javascript:void(0)' onclick=\"VPageGo('"+listid+"','"+action+"',"+(v_ipage.pageSum)+");\"><span class=\"lastPage\"/></a>");
			//if(!v_ipage.hasPrevious){
			//	pagev_form.find("li:eq(3)").html("<span class=\"prevPageDisabled\"/>");
			//}
			//if(v_pageNo==1){
			//	pagev_form.find("li:eq(2)").html("<span class=\"firstPageDisabled\"/>");
			//}
		}
		if(v_ipage.hasPrevious){
			pagev_form.find("li:eq(3)").attr("class","prevPage");
			pagev_form.find("li:eq(3)").bind("click",function(){VPageGo(listid,action,v_pageNo-1);});
			pagev_form.find("li:eq(2)").attr("class","firstPage");
			pagev_form.find("li:eq(2)").bind("click",function(){VPageGo(listid,action,1);});
			if(!v_ipage.hasNext){
				pagev_form.find("li:eq(5)").attr("class","nextPageDisabled");
				pagev_form.find("li:eq(5)").unbind("click")
			}
			if(v_pageNo==v_ipage.pageSum){
				pagev_form.find("li:eq(6)").attr("class","lastPageDisabled");
				pagev_form.find("li:eq(6)").unbind("click")
			}
		}
		pagev_form.find("li:eq(0)").find("span").text(v_ipage.pageSum);
		pagev_form.find("li:eq(1)").find("span").text(v_ipage.pageCounts);
		
		pagev_form.find("li:eq(4)").find("span").text(v_pageNo + "/" + v_ipage.pageSum);
		pagev_form.find("input[name='eadis_page']").val(v_pageNo);
	}
}
/**
 * ���б����ݽ���չ��
 * @param {Object} v_table
 * @param {Object} jsonStr
 * @return {TypeName} 
 */
function VTransJsonToHtml(v_table, jsonList){
	v_table.find("tbody").empty();
	var rowHtmlStr;
	for(var i=0;i<jsonList.length;i++){//����������
		rowHtmlStr = "<tr>";
		var rowData = jsonList[i];
		for(var j=0;j<rowData.length;j++){//�������еĵ�Ԫ����������
			rowHtmlStr += "<td";
			var data = rowData[j];
			var align = data['align'];
			var td_width = data['width'];
			if(typeof(td_width)!="undefined"){
				rowHtmlStr += " width=\""+td_width+"\"";
			}
			rowHtmlStr += " align=\""+align+"\"";
			rowHtmlStr += ">";
			rowHtmlStr += data['data'];
			rowHtmlStr += "</td>";
		}
		rowHtmlStr += "</tr>";
		v_table.find("tbody").append(rowHtmlStr);
	}
	v_table.find("tbody > tr").each(function(){
		$(this).dblclick(function(){$(this).editRow();});
	});
	v_table.setRowBgClass();
}
function VPageGo(listid,action,pageNo){
	if(pageNo==null || typeof(pageNo)=="undefined"){
		pageNo = action;
	}
	var v_table = $("#" + listid);
	var v_pageform = $("table[listid='"+listid+"']");
	if(typeof(pageNo)=="undefined" || pageNo==null){
		var pageNo = v_pageform.find("input[name=eadis_page]").val();
	}
	var v_pageSize = v_pageform.find("input[name=pageSize]").val();
	v_table.getPageList(null,pageNo,v_pageSize);
}
$.fn.saveRow=function(){
	var v_status = this.data("v_status");
	var v_options = this.data("v_options");
	var v_row_index = this.data("v_row_index");
	var v_headers = this.data("v_headers");
	var v_table = this;
	var v_url = "";
	if(v_status==2){
		v_url = v_options.updateUrl;
	}else if(v_status==3){
		v_url = v_options.insertUrl;
	}else {
		return;
	}
	var v_data = "";
	var v_tr = v_table.find("tbody > tr:eq("+v_row_index+")");
	var v_colIndex = 0;
	var v_valiv_msg = null;
	v_tr.children().each(function(){
		var hv_varis = v_headers[v_colIndex];
		if(typeof hv_varis != undefined && hv_varis != null){
			v_data += hv_varis.v_fieldName + ":";
			var v_val;
			if(hv_varis.v_canwrite=="1"){
				if(hv_varis.v_type==0 || hv_varis.v_type==4){
					v_val = $(this).find("input:text").val();
				}else if(hv_varis.v_type==10 || hv_varis.v_type==6){
					v_val = $(this).find("select").val();
				}else if(hv_varis.v_type==1){
					v_val = $(this).find("input:text").val()
					v_val = v_val==null?"":v_val.replace(/-/g,"");
				}else if(hv_varis.v_type==12){
					v_val = $(this).find("input:text").val()
					v_val = v_val==null?"":v_val.replace(/,/g,"");
				}
			}else {
				v_val = $.trim($(this).text());
				if(hv_varis.v_type==10 || hv_varis.v_type==6){
					var v_options = eval("("+hv_varis.v_dataoption+")");
					for(var prop in v_options){
						if(v_val==v_options[prop]){
							v_val = prop;
						}
					}
				}else if(hv_varis.v_type==1){
					v_val = v_val.replace(/-/g,"");
				}else if(hv_varis.v_type==12){
					v_val = v_val.replace(/,/g,"");
				}
			}
			if(hv_varis.v_mustinput=="1" && $.trim(v_val)==""){
				v_valiv_msg = "["+hv_varis.v_title+"]����Ϊ��!";
				return ;
			}
			v_data += "'" + v_val + "',";
		}
		v_colIndex++;
	});
	if(v_valiv_msg!=null){
		alert(v_valiv_msg);
		return false;
	}
	if(v_data!=""){
		v_data = "{"+v_data.substr(0,v_data.length-1)+"}";
	}
	$.post(v_url,{ajaxData:encodeURI(v_data)},function(resultStr){
		if(!resultStr.StartWith("success")){
			alert(resultStr);
		}else {
			//v_table.VRestoreRow(true,resultStr);
			VPageGo(v_table.attr("id"));
			v_table.data("v_status",0);
			window.location.reload();
		}
	});
}