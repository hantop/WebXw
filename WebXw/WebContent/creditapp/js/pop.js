function func_reset(lk){
	if( lk!=null && lk!="" ){
		if( lk.indexOf(",") > -1 ){
			var arr = lk.split(",");
			for( var i=0;i<arr.length;i++ ){
				document.getElementsByName(arr[i])[0].value="";
			}
		}else{
			document.getElementsByName(lk)[0].value="";
		}
	}else{
		return false;
	}
}
function showDialog(url,width,height){
	if(!width)width = screen.availWidth;
	if(!height) height = screen.availHeight-30;
	if (url.indexOf('?') != -1){
		url+='&';
	}else{
		url+='?';
	}
	url+="isDialog=1";
	var sFeatures;
    if (window.showModalDialog) {
        sFeatures = "dialogWidth:"+width+"px;dialogHeight:"+height+"px;dialogLeft=0px;dialogTop=0px;center=no;resizable=no;scrollbars=no;status:yes;help:no;";
        var returnResult = window.showModalDialog(url, window, sFeatures);
        if (returnResult) {
            return returnResult;
        }
    } else {
        sFeatures = "status=no,width="+width+"px,height="+height+"px,menubar=no,scrollbars=no";
       // window.margs = vArguments;
        window.open(url, "_blank", sFeatures);
    }
}
function showViewDialog(url){
	showNewDailogWindow(url,true,null,null,null,"dialogWidth=60;dialogHeight=32;center:yes;help:no;minimize:no;maximize:no;border:thin;statusbar:no");
	//window.showModalDialog(url,window,"dialogWidth=60;dialogHeight=32;center:yes;help:no;minimize:no;maximize:no;border:thin;statusbar:no");
	/*
	var width = screen.availWidth;
	var height = screen.availHeight-30;
	
	var sFeatures;
    if (window.showModalDialog) {
        sFeatures = "dialogWidth:"+width+"px;dialogHeight:"+height+"px;dialogLeft=0px;dialogTop=0px;center=no;resizable=no;scrollbars=no;status:yes;help:no;";
        var returnResult = window.showModalDialog(url, window, sFeatures);
        if (returnResult) {
            return returnResult;
        }
    } else {
        sFeatures = "status=no,width="+width+"px,height="+height+"px,menubar=no,scrollbars=no";
        window.open(url, "_blank", sFeatures);
    }
    */
	
	
}
function showViewDialogSmall(url){
	showNewDailogWindow(url,true,null,null,null,"dialogWidth=40;dialogHeight=15;center:yes;help:no;minimize:no;maximize:no;border:thin;statusbar:no");
}
function showDialog2(url,width,height){
	if(!width)width = screen.availWidth;
	if(!height) height = screen.availHeight-30;
	
	var sFeatures;
    if (window.showModalDialog) {
        sFeatures = "dialogWidth:"+width+"px;dialogHeight:"+height+"px;dialogLeft=0px;dialogTop=0px;center=no;resizable=no;scrollbars=no;status:yes;help:no;";
        var returnResult = window.showModalDialog(url, window, sFeatures);
        if (returnResult) {
            return returnResult;
        }
    } else {
        sFeatures = "status=no,width="+width+"px,height="+height+"px,menubar=no,scrollbars=no";
       // window.margs = vArguments;
        window.open(url, "_blank", sFeatures);
    }
}
function openWindow(url,width,height,isReload){
	if(!width)width = screen.availWidth-10;
	if(!height) height = screen.availHeight - 40;
	var iTop =Math.abs((screen.availHeight-40-height))/2; //��ô��ڵĴ�ֱλ��;
	var iLeft = Math.abs(screen.availWidth-10-width)/2; //��ô��ڵ�ˮƽλ��;
	
	var sFeatures = "status=no,width="+width+"px,height="+height+"px,top="+iTop+"px,left="+iLeft+"px,menubar=no,scrollbars=no,alwaysLowered=yes;resizable=yes";
    var winObj = window.open(url, "_blank", sFeatures);
    if(isReload){
    	var loop = setInterval(function(){
        	if(winObj.closed){
        		clearInterval(loop);
        		window.location.reload();
        	}
        });
    }
}

function openWindowForRpt(url){
	var sFeatures = "height=800, width=1000, top=0, left=0, resizable=yes, scrollbars=yes, alwaysLowered=yes,menubar=no,status=no";
    window.open(url, "_blank", sFeatures);
}
//�ͻ���Ϣ
function funcCifPop(parNames, popNames,flag) {
	var url = "CifOpRelAction_findCifPop.action?parNames=" + parNames
			+ "&popNames=" + popNames;
	showDialog(url);
}

//��ѯCifCorpInfpop
function funcCorpPop(parNames, popNames) {
	var url = "CifCorpInfAction_findCorpPop.action?parNames=" + parNames
	+ "&popNames=" + popNames;
	showDialog(url);
}


//��֤�˿ͻ���Ϣ
function funcPromPop(parNames, popNames) {
    var url = "CifOpRelAction_findPromPop.action?parNames=" + parNames + "&popNames=" + popNames;
    showDialog(url);
}

//��Ѻ�˿ͻ���Ϣ
function funcGawnPop(parNames, popNames) {
    var url = "CifOpRelAction_findGawnPop.action?parNames=" + parNames + "&popNames=" + popNames;
    
    showDialog(url);
}

//��Ѻ�˿ͻ���Ϣ
function funcPawnPop(parNames, popNames) {
    var url = "CifOpRelAction_findPawnPop.action?parNames=" + parNames + "&popNames=" + popNames;
    showDialog(url);
}
//����ҳ���ͻ��ŵ����ͻ�����
function showCifDetail(str) {
	var url = "CifBaseAction_getDetail.action?" + str.split("?")[1];
	showDialog(url);
}
//����ҳ���ͻ��ŵ����ͻ�����	����ר��
function showCifDetailForGrt(lk) {
	var cifNo;
	if(lk.split("=")[1]==""){
		cifNo = document.getElementsByName("cifNo")[0].value;
		if(cifNo==""){
			sAlert("����ѡ��ͻ���");
			return false;
		}else{
			var url = "CifBaseAction_getDetail.action?cifNo=" + cifNo;
			showDialog(url);
		}
	}else{
		var url = "CifBaseAction_getDetail.action" + lk.split("#")[1];
		showDialog(url);
	}
}

//��ѯ���пͻ�������Ϣ--wanggang 20150618
function showMangNoPop(param) {
    var url = "SysUserAction_findMangNoPop.action?param=" + param;
    window.showModalDialog(url,window,"dialogWidth=55;dialogHeight=32;center:yes;help:no;minimize:no;maximize:no;border:thin;statusbar:no");
}


function funcSupPrdPop(parNames, popNames) {
	var url = "PrdModelAction_findPrdModelPopForDeal.action?parNames=" + parNames
	+ "&popNames=" + popNames;
	showDialog(url);
}
function funcPrdBasePop(parNames, popNames) {
    var url = "PrdBaseAction_findPop.action?";
    url = url + "parNames=" + parNames + "&popNames=" + popNames;
    showDialog(url);
}

//������pop start
function funcWkfApprovalRolePop(parNames, popNames) {
	var url = "WkfApprovalRoleAction_findByPagePop.action?parNames=" + parNames+ "&popNames=" + popNames;
	showNewDailogWindow(url);
	//showDialog(url);
}
function funcWkfPop(obj)
{
	var wfId=selectProcess();
	if(null!=wfId&&""!=wfId&&"null"!=wfId)
	{
		obj.value=wfId;
	}
}
function funcWkfApprovalUserPop(parNames, popNames,taskId) {
	var url = "WkfApprovalUserAction_findByPagePop.action?parNames=" + parNames+ "&popNames=" + popNames+"&taskId="+taskId;
	showDialog(url);
}
function funcWkfApprovalUserMapPop(parNames, popNames) {
	var url = "WkfApprovalUserAction_findByPageMapPop.action?parNames=" + parNames+ "&popNames=" + popNames;
	showDialog(url);
}
function funcWkfApprovalUserForReAssignPop(parNames, popNames,taskId) {
	var url = "WkfApprovalUserAction_findByPagePop.action?parNames=" + parNames+ "&popNames=" + popNames+"&taskId="+taskId;
	showDialog(url);
}
//������pop end

//�û�pop
function funcTblOrgUserPop(parNames, popNames){
	var url = "TblOrgUserAction_findByPageForPop.action?parNames=" + parNames + "&popNames=" + popNames;
	
	showDialog(url);
}

//ѡ�����������Ŀ,��ѯ������Ŀ���
function funcRewPreventRiskPop(parNames, popNames) {
    var url = "RewPreventRiskAction_findByPageForPop.action?parNames=" + parNames + "&popNames=" + popNames;
    showDialog(url);
}
//����Ԥ������,��ѯģ�����
function funcRewTempParmPop(parNames, popNames, schemeId) {
    var schemeId = document.getElementsByName("schemeId")[0].value;
    var url = "RewTempParmAction_findByPage.action?parNames=" + parNames + "&popNames=" + popNames + "&schemeId=" + schemeId;
    showDialog(url);
}
//����Ԥ������,���÷��շ�ֵ
function funcRewThresholdPop(parNames, popNames, schemeId) {
    var schemeId = document.getElementsByName("schemeId")[0].value;
    var url = "RewThresholdAction_findByPage.action?parNames=" + parNames + "&popNames=" + popNames + "&schemeId=" + schemeId;
    showDialog(url);
}
//������������,����������Ŀ,��ѯԤ����������,���
function funcRewSchemePop(parNames, popNames, schemeId) {
    var url = "RewSchemeAction_temp.action?parNames=" + parNames + "&popNames=" + popNames;
    showDialog(url);
}

//pop���ص��õķ���
function funcPopReturn(lk) {
    var parNames = document.getElementsByName('parNames')[0].value.split(',');
    var popNames = document.getElementsByName('popNames')[0].value.split(',');
    var obj = document.getElementsByName('returnMethod')[0];
    var returnMethod = "";
    if (typeof(obj) != "undefined") {
        returnMethod = obj.value;
    }
    var temps = lk.split("?");
    var pars = temps[1];
    var strs = pars.split("&");
	if(window.dialogArguments == null){//ʹ��window.open�ķ�ʽ�����´���ʱȡ�ø�����
		var doc = window.opener.document;
	}else{//ʹ��window.showModalDialog�ķ�ʽ�����´���ʱȡ�ø�����
		var doc = dialogArguments.document;
	}
    
    for (var i = 0; i < strs.length; i++) {
        for (var j = 0; j < popNames.length; j++) {
            var ss = strs[i].split('=');
            var name = ss[0];
            if (name == popNames[j]) {
                var obj = doc.getElementsByName(parNames[j])[0];
                
                obj.value = ss[1];
                
                obj.readonly = true;
            }
        }
    }
    if (typeof(returnMethod) != "undefined" && returnMethod != "") {
        dialogArguments[returnMethod]();
    }
    window.close();
}

function func_cif_pop(url){
		//window.showModalDialog(url, window, "dialogWidth="+(screen.availWidth)+";dialogHeight="+(screen.availHeight-30)+";center:yes;resizable=no;scrollbars=no;status:no;help:no;location:yes");
		//window.open(url,"window","status:no;help:no;border:thin;statusbar:no,left=0,top=0,resizable=yes,width="+(screen.availWidth)+"px,height="+(screen.availHeight-30)+"px");
		openWindow(url);
}
	
//ҵ��ģ��pop
function funcBusiModulePop(){
	var module_type = document.getElementsByName("module_type")[0].value;
	var url = "BusiModuleAction_findForPop.action?module_type=" + module_type;
	window.showModalDialog(url, window, "dialogWidth=60;dialogHeight=30;resizable=no;scrollbars=no;status:no;help:no;");
}
//ҵ����ģ��pop
function funcBusiSubModelPop(){
	var module_type = document.getElementsByName("module_type")[0].value;
	var url = "BusiSubModelAction_findForPop.action?module_type=" + module_type;
	window.showModalDialog(url, window, "dialogWidth=60;dialogHeight=30;resizable=no;scrollbars=no;status:no;help:no;");
}
/**
*	ͨ������Ĳ�����ȡ�ò�����ֵ����Ϊ�ո�����ʾ
*/
function returnParms(query_parm){
	var isEmpty = true; 
	var val = "";
	var parms = "";
	if( query_parm.indexOf(",")>0 ){//where �����ж����ѯ������
		var arr = query_parm.split(",");
		for( var i=0;i<arr.length;i++ ){
			if( arr[i].indexOf("@")>0 ){
				val = document.getElementsByName(arr[i].split("@")[0])[0].value ;
			}else{
				val = document.getElementsByName(arr[i])[0].value ;
			}
			if( val != null && val != "" && typeof(val)!='undefined' ){
				val = val.replace(/\,/g,"");
				parms += arr[i]+"="+val ;
				parms += ",";
				isEmpty=false;
				if(isHadChineseChart(val)){
					var len = getStrLength(val);
					if(len < 4){
						sAlert("�����������������ֽ��в�ѯ!");
						return false;
					}
				}
			}
		}
		if( isEmpty ){
			//sAlert("������Ӧҳ����������ֵ���ٵ���Ŵ󾵲�ѯ!");
			//return false;
		}
	}else {//ֻ��һ����ѯ������
		if( query_parm != "" ){
			if( query_parm.indexOf("@")>0 ){
				val = document.getElementsByName(query_parm.split("@")[0])[0].value ;
			}else{
				val = document.getElementsByName(query_parm)[0].value ;
				val = val.replace(/\,/g,"");
			}
			if( val == "" ){
				//sAlert("������Ӧҳ����������ֵ���ٵ���Ŵ󾵲�ѯ!");
				//return false;
			}else{
				parms = query_parm + "=" + val;
			}
		}
	}
	return parms;
}

function isHadChineseChart(str){
	if(/.*[\u4e00-\u9fa5]+.*$/.test(str)){
		return true;
	}
	return false;
}

function getStrLength(str){
	if(str == null)return 0;
	if(typeof str != "string"){
		str += "";
	}
	return str.replace(/[^\x00-\xff]/g,"01").length;
}

/** ����pop����ҳ����ѡ��
*	����1��ʾ����ID
*   ����2��ʾҪ��ҳ�洫��ֵ��SQL���where���������
**/
function func_popRadio(scene_id,query_parm,callFun){
	var parms = returnParms(query_parm);
	var returnVal;
	$.ajax({ 
	    type:"POST", //����ʽ
	    url:"PopParmConfAction_findByPop.action", //����·��
	    cache: false, 
	    async: false,
	    data:{'scene_id':scene_id, 'parms':encodeURI(parms)}, 
	    contentType: "application/x-www-form-urlencoded; charset=utf-8",   
	    dataType: 'json',   
	    success:function(json){  
       		var db_rel = json.rel;
       		var sql = json.sql;
       		var col_name = json.col_name;
       		var size = json.size;
       		var query_name = json.query_name;
       		var disName = json.disName;
       		var pageNo = json.pageNo;
       		var query_sql= json.query_sql;
       		var hidden_col = json.hidden_col;
       		var if_query = json.if_query;
       		sql = sql.replace(/\%/g,"@");
       		sql = sql.replace(/\?/g,"%3F");
       		if( query_sql!=null ){
       			query_sql = query_sql.replace(/\%/g,"@");
       			query_sql = query_sql.replace(/\?/g,"%3F");
       		}
       		var url = "creditapp/dev/Pop_frame.jsp?rel="+db_rel+"&sql="+sql+"&col_name="+col_name+
       					"&size="+size+"&query_name="+query_name+"&disName="+disName+"&pageNo="+pageNo+"&scene_id="+scene_id+
       					"&query_sql="+query_sql+"&hidden_col="+hidden_col+"&if_query="+if_query;
       		
       		var returnVal;
       		var agent = navigator.userAgent.toLowerCase();
       		if (agent.indexOf("chrome") > 0 || agent.indexOf("firefox") > 0) {
       			var width = screen.availWidth;
       			var height = screen.availHeight;
       			var sFeatures = "status=no,width="+width+"px,height="+height+"px,top=0px,left=0px,menubar=no,scrollbars=no,alwaysLowered=yes;resizable=yes";
       		    var winObj = window.open(url, "_blank", sFeatures);
       		    var loop = setInterval(function(){
		        	if(winObj.closed){
		        		clearInterval(loop);
		        		if(typeof callFun == "function"){
		           			callFun.call();
		           		}
		        	}
		        });
    		}else{
           		returnVal = window.showModalDialog(url,window,"dialogWidth=70;dialogHeight=38;center:yes;help:no;minimize:no;maximize:no;border:thin;status:no");
           		callFun.call();
    		}
	    }
    });
	return returnVal;
}
function func_popTzList(scene_id,query_parm){
	var parms = '';
	if('TZ34'==scene_id ||'TZ35'==scene_id||'TZ36'==scene_id){
		parms=query_parm;
	}else{
		parms = returnParms(query_parm);
	}
	var returnVal;
	$.ajax({ 
	    type:"POST", //����ʽ
	    url:"TaiZhangAction_tzList.action", //����·��
	    cache: false, 
	    async: false,
	    data:{'scene_id':scene_id, 'parms':encodeURI(parms)}, 
	    contentType: "application/x-www-form-urlencoded; charset=utf-8",   
	    dataType: 'json',   
	    success:function(json){  
       		var db_rel = json.rel;
       		var sql = json.sql;
       		var col_name = json.col_name;
       		var size = json.size;
       		var query_name = json.query_name;
       		var disName = json.disName;
       		var pageNo = json.pageNo;
       		var query_sql= json.query_sql;
       		var hidden_col = json.hidden_col;
       		sql = sql.replace(/\%/g,"@");
       		sql = sql.replace(/\?/g,"%3F");
       		if( query_sql!=null ){
       			query_sql = query_sql.replace(/\%/g,"@");
       			query_sql = query_sql.replace(/\?/g,"%3F");
       		}
       		var url='';
       		if('TZ34'==scene_id || 'TZ35'==scene_id ||'TZ36'==scene_id){
       			var cif_no=parms.split("=")[1].split(",")[0];
       			url = "creditapp/dev/Pop_frameTz.jsp?rel="+db_rel+"&sql="+sql+"&col_name="+col_name+
       					"&size="+size+"&query_name="+query_name+"&disName="+disName+"&pageNo="+pageNo+"&scene_id="+scene_id+"&query_sql="+query_sql+"&hidden_col="+hidden_col+"&cif_no="+cif_no;
       		}else{
       		url = "creditapp/dev/Pop_frameTz.jsp?rel="+db_rel+"&sql="+sql+"&col_name="+col_name+
       					"&size="+size+"&query_name="+query_name+"&disName="+disName+"&pageNo="+pageNo+"&scene_id="+scene_id+"&query_sql="+query_sql+"&hidden_col="+hidden_col;
       		}
       		returnVal = window.showModalDialog(url,window,"dialogWidth="+screen.availWidth+";dialogHeight="+(screen.availHeight-30)+";scroll:yes;center:yes;help:no;minimize:no;maximize:no;border:thin;statusbar:no");
	   		//returnVal=showDialog(url);
	    }
    });
	return returnVal;
}

/** ����pop����ҳ����ѡ��=================>>>����������
*	����1��ʾ����ID
*   ����2��ʾҪ��ҳ�洫��ֵ��SQL���where���������

function func_popRadio_bak(scene_id,query_parm,val){
	if( val!=null && val!="" ){
	  	var a = document.getElementsByName(val)[0].value;
	  	if( a=="" || typeof(a)=="undefined" ){
	  		sAlert("�����������ٵ���Ŵ󾵲�ѯ");
	  		return false;
	  	}
	}
	var parms = "";
	if( query_parm!=null && query_parm!="" ){
		parms = returnParms(query_parm);
		if( parms == false){
			return false;
		}
	}
	$.ajax({ 
	    type:"POST", //����ʽ
	    url:"PopParmConfAction_queryAjax.action", //����·��
	    cache: false,   
	    data:{'scene_id':scene_id, 'parms':encodeURI(parms)}, 
	    contentType: "application/x-www-form-urlencoded; charset=utf-8",   
	    dataType: 'json',   
	    success:function(json){  
       	if( json.size=="1" ){
       			db_rel = json.rel;
       			var db_rel_arr = db_rel.split(",");
				var value = "";
				var temp = "";
				for( var i=0;i<db_rel_arr.length;i++ ){
					var db_r_arr_split = db_rel_arr[i].split("-");
					for(var key in json){  
        				if( key==db_r_arr_split[0] ){
        					document.getElementsByName(db_r_arr_split[1])[0].value = json[key];
        				}
    				}   
				}
       		}else if( json.size=="0" ){
       			sAlert("û�в�ѯ�����������Ľ��!");
       			return false;
       		}else{
       			var db_rel = json.rel;
       			var sql = json.sql;
       			var col_name = json.col_name;
       			sql = sql.replace(/\%/g,"@");
       			var url = "creditapp/dev/PopCommRadio_List.jsp?rel="+db_rel+"&sql="+sql+"&col_name="+col_name;
    			window.showModalDialog(url,window,"dialogWidth=55;dialogHeight=40;center:yes;help:no;minimize:no;maximize:no;border:thin;statusbar:no");
       		}
       }
    });
}
**/
/**
 * ���ڼ��ż�������ҳ�� ������ѡ��
 * @param {Object} scene_id
 * @param {Object} query_parm
 */
function func_popForFamily(scene_id,query_parm){
	var parms = returnParms(query_parm);
	$.ajax({ 
	    type:"POST", //����ʽ
	    url:"PopParmConfAction_findByPop.action", //����·��
	    cache: false,   
	    data:{'scene_id':scene_id, 'parms':encodeURI(parms)}, 
	    contentType: "application/x-www-form-urlencoded; charset=utf-8",   
	    dataType: 'json',   
	    success:function(json){  
       		var db_rel = json.rel;
       		var sql = json.sql;
       		var col_name = json.col_name;
       		var size = json.size;
       		var query_name = json.query_name;
       		var disName = json.disName;
       		var pageNo = json.pageNo;
       		var query_sql= json.query_sql;
       		sql = sql.replace(/\%/g,"@");
       		sql = sql.replace(/\?/g,"%3F");
       		if( query_sql!=null ){
       			query_sql = query_sql.replace(/\%/g,"@");
       			query_sql = query_sql.replace(/\?/g,"%3F");
       		}
       		var url = "creditapp/dev/Pop_frameForFamily.jsp?rel="+db_rel+"&sql="+sql+"&col_name="+col_name+
       					"&size="+size+"&query_name="+query_name+"&disName="+disName+"&pageNo="+pageNo+"&scene_id="+scene_id+"&query_sql="+query_sql;
    		window.showModalDialog(url,window,"dialogWidth=70;dialogHeight=38;center:yes;help:no;minimize:no;maximize:no;border:thin;statusbar:no");
       }
    });
}
/** ����pop����ҳ����ѡ��
*	����1��ʾ����ID
*   ����2��ʾҪ��ҳ�洫��ֵ��SQL���where���������
**/
function func_pop(scene_id,query_parm,entity){
	var parms = "";
	var returnVal ;
	if( query_parm!=null && query_parm!="" ){
		parms = returnParms(query_parm);
		if( parms == "" || parms==null ){
			sAlert("�����ڷŴ󾵶�Ӧ�����������ֵ���ٵ����ѯ��");
			return false;
		}
	}
	var entity_val = "";
	if( entity!=null && entity!="" ){
		entity_val = document.getElementsByName(entity)[0].value;
	}
	
	$.ajax({ 
	    type:"POST", //����ʽ
	    url:"PopParmConfAction_findByPopChB.action", //����·��
	    cache: false,   
	    async: false,
	    data:{'scene_id':scene_id, 'parms':encodeURI(parms)}, 
	    contentType: "application/x-www-form-urlencoded; charset=utf-8",   
	    dataType: 'json',   
	    success:function(json){  
       		var db_rel = json.rel;
       		var sql = json.sql;
       		var size = json.size;
       		sql = sql.replace(/\%/g,"@");
       		sql = sql.replace(/\?/g,"%3F");
       		var url = "creditapp/dev/Pop_CheckBox.jsp?rel="+db_rel+"&sql="+sql+"&scene_id="+scene_id+"&size="+size+"&entity_val="+entity_val;
    		returnVal = window.showModalDialog(url,window,"dialogWidth=65;dialogHeight=35;center:yes;help:no;minimize:no;maximize:no;border:thin;statusbar:no");
       }
    });
	return returnVal;
}
/** ���ڼ��ż�������ҳ�� ����
function func_popForFamily(scene_id,query_parm){
	var parms = "";
	if( query_parm!=null && query_parm!="" ){
		parms = returnParms(query_parm);
		if( parms == false){
			return false;
		}
	}
	$.ajax({ 
	    type:"POST", //����ʽ
	    url:"PopParmConfAction_queryAjax.action", //����·��
	    cache: false,   
	    data:{'scene_id':scene_id, 'parms':encodeURI(parms)}, 
	    contentType: "application/x-www-form-urlencoded; charset=utf-8",   
	    dataType: 'json',   
	    success:function(json){  
       	if( json.size=="1" ){
       			db_rel = json.rel;
       			var db_rel_arr = db_rel.split(",");
				var value = "";
				var temp = "";
				for( var i=0;i<db_rel_arr.length;i++ ){
					var db_r_arr_split = db_rel_arr[i].split("-");
					for(var key in json){  
        				if( key==db_r_arr_split[0] ){
        					document.getElementsByName(db_r_arr_split[1])[0].value = json[key];
        				}
    				}   
				}
       		}else if( json.size=="0" ){
       			sAlert("û�в�ѯ�����������Ľ��!");
       			return false;
       		}else{
       			var db_rel = json.rel;
       			var sql = json.sql;
       			var col_name = json.col_name;
       			sql = sql.replace(/\%/g,"@");
       			var url = "creditapp/dev/PopCommRadio_ListForFamily.jsp?rel="+db_rel+"&sql="+sql+"&col_name="+col_name;
    			window.showModalDialog(url,window,"dialogWidth=55;dialogHeight=30;center:yes;help:no;minimize:no;maximize:no;border:thin;statusbar:no");
       		}
       }
    });
}
**/
/** ����pop����ҳ����ѡ��
*	����1��ʾ����ID
*   ����2��ʾҪ��ҳ�洫��ֵ��SQL���where���������
**/
function func_popCheckbox(scene_id,query_parm){
	var parms = returnParms(query_parm);
	if( parms!="" ){
		if(parms==false){
			return false;
		}
	}
	$.ajax({ 
	    type:"POST", 
	    url:"PopParmConfAction_createSql.action", 
	    cache: false,   
	    data:{'scene_id':scene_id, 'parms':encodeURI(parms)}, 
	    contentType: "application/x-www-form-urlencoded; charset=utf-8",   
	    dataType: 'json',   
	    success:function(json){  
       		var db_rel = json.rel;
       		var sql = json.sql;
       		var col_name = json.col_name;
       		sql = sql.replace(/\%/g,"@");
       		var url = "creditapp/dev/PopCommCheckbox_List.jsp?rel="+db_rel+"&sql="+sql+"&col_name="+col_name+"&parms="+parms;
       		//window.showModalDialog(url,window,"dialogWidth=55;dialogHeight=30;center:yes;help:no;minimize:no;maximize:no;border:thin;statusbar:no");
       		showNewDailogWindow(url,false,null,null,null,"dialogWidth=55;dialogHeight=30;center:yes;help:no;minimize:no;maximize:no;border:thin;statusbar:no");
	    }
    });
}

function showNewDailogWindow(url,isView,width,height,config,ieConifg){
	if(!width)width = screen.availWidth-20;
	if(!height)height = screen.availHeight-80;
	var iTop = (screen.availHeight-height)/2; //��ô��ڵĴ�ֱλ��;
	var iLeft = (screen.availWidth-10-width)/2; //��ô��ڵ�ˮƽλ��;
	
	var isIe = true;
	var agent = navigator.userAgent.toLowerCase();
	if (agent.indexOf("chrome") > 0 || agent.indexOf("firefox") > 0) {
		isIe = false;
	}
    if (isIe) {
    	if(ieConifg)config = ieConifg;
    	else if(isView)config = "dialogWidth=25;dialogHeight=30;center:yes;help:no;minimize:no;maximize:no;border:thin;statusbar:no";
    	else if(!config)config = "dialogWidth:"+width+"px;dialogHeight:"+height+"px;dialogLeft=0px;dialogTop=0px;center=no;resizable=no;scrollbars=no;status:yes;help:no;";
    	var returnResult = window.showModalDialog(url, window, config);
        if (returnResult) {
            return returnResult;
        }
    } else {
    	if(!config)config = "status=no,width="+width+"px,height="+height+"px,menubar=no,scrollbars=no,top="+iTop+",left="+iLeft+",status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no";
        var returnResult = window.open(url, "_blank", config);
    }
}

/** ����������ҳ����ѡ��
*	����1��ʾ����ID
*   ����2��ʾҪ��ҳ�洫��ֵ��SQL���where���������
**/
function func_PopTree(scene_id,query_parm,call_func){
	var parms = returnParms(query_parm);
	if( parms!="" ){
		if(parms==false){
			return false;
		}
	}
	url="TreeConfAction_getTree.action?scene_id="+scene_id+"&parms="+encodeURI(parms)+"&call_func="+call_func;
//	window.showModalDialog(url,window,"dialogWidth=25;dialogHeight=30;center:yes;help:no;minimize:no;maximize:no;border:thin;statusbar:no");
	showNewDailogWindow(url,true,600,700);
}
//����pop��
function func_PopTreePot(scene_id,query_parm,call_func){
	var parms = returnParms(query_parm);
	if( parms!="" ){
		if(parms==false){
			return false;
		}
	}
	url="TreeConfAction_getTreePot.action?scene_id="+scene_id+"&parms="+encodeURI(parms)+"&call_func="+call_func;
    //window.showModalDialog(url,window,"dialogWidth=25;dialogHeight=30;center:yes;help:no;minimize:no;maximize:no;border:thin;statusbar:no");
	showNewDailogWindow(url,true,600,700);
}
/**
 * �����ͨ�ţ��˺Ų�ѯ����ȡ��Ӧ�Ľ��
 */
function getAccBal(paramNames){
	var paramArr = paramNames.split(",");
	var acc_no = "";
	var br_no = "";	
	var amt = "";
	var cur_no = "";
	acc_no = $("[name='"+paramArr[0]+"']").val();
	cur_no = $("[name='"+paramArr[1]+"']").val();
    if(acc_no=="" || acc_no==null){
    	sAlert("�������˺ţ�");
    	return false;
    } else if(cur_no=="" || cur_no==null){
    	sAlert("�����뱣֤����֣�");
    	return false;
    }
    var result="";
    var url = "TradeInterAction_getAccNoList.action?acc_no="+acc_no+"&cur_no="+cur_no;
    screenLock();
	$.when(getAjax(url)).done(function(result){
		screenUnlock();
		var msgArr = result.split("@");
		var msg1 = msgArr[0];
		var msg2 = msgArr[1];
		if (msg1 == '0'){
			sAlert(msg2);
			$("[name='"+paramArr[0]+"']").val('');
			return false;
		} else if(msg1 == '1'){
			if(paramArr[1]!=null||paramArr[1]!=''){
				//$("[name='"+paramArr[2]+"']").val(msg2);
				sAlert("��ȡ�˻����ɹ����˻��������Ϊ"+msg2);
			} else {
				sAlert("�˺�У��ɹ�");
			}
		} else {
			sAlert("ͨ���쳣");
		}
	})
}

/**
 * �����ͨ�ţ��˺Ų�ѯ����ȡ��Ӧ���˻�����
 */
function getAccName(paramNames){
	var paramArr = paramNames.split(",");
	var acc_no = "";
	var cif_name = "";	
	var cur_no = "";
	acc_no = $("[name='"+paramArr[0]+"']").val();
	cur_no = $("[name='"+paramArr[1]+"']").val();
	cif_name = $("[name='"+paramArr[2]+"']").val();
    if(acc_no=="" || acc_no==null){
    	sAlert("�������˺ţ�");
    	return false;
    } else if(cur_no=="" || cur_no==null){
    	sAlert("������ҵ����֣�");
    	return false;
    }
    var result="";
    var url = "TradeInterAction_getAccNameList.action?acc_no="+acc_no+"&cif_name="+cif_name+"&cur_no="+cur_no;
    screenLock();
	$.when(getAjax(url)).done(function(result){
		screenUnlock();
		var msgArr = result.split("@");
		var msg1 = msgArr[0];
		var msg2 = msgArr[1];
		if (msg1 == '0'){
			sAlert(msg2);
			$("[name='"+paramArr[0]+"']").val('');
			return false;
		} else if(msg1 == '1'){
			if(paramArr[2]!=null||paramArr[2]!=''){
				sAlert("��ȡ�˻���"+acc_no+"���˻����ơ�"+msg2+"���ɹ�");
				$("[name='"+paramArr[3]+"']").val(msg2);
			} else {
				sAlert("�˺�У��ɹ�");
			}
		} else {
			sAlert("ͨ���쳣");
			return false;
		}
	})
}

/**
 * �����ͨ�ţ��˺Ų�ѯ����ȡ��Ӧ���˻����ƺͽ��
 */
function getAccNameAndAmt(paramNames){
	var paramArr = paramNames.split(",");
	var acc_no = "";
	var br_no = "";	
	var cur_no = "";
	acc_no = $("[name='"+paramArr[0]+"']").val();
	cur_no = $("[name='"+paramArr[1]+"']").val();
    if(acc_no=="" || acc_no==null){
    	sAlert("�������˺ţ�");
    	return false;
    } else if(cur_no=="" || cur_no==null){
    	sAlert("�����뱣֤����֣�");
    	return false;
    }
    var result="";
    var url = "TradeInterAction_getAccNameAndAmt.action?acc_no="+acc_no+"&cur_no="+cur_no;
    screenLock();
	$.when(getAjax(url)).done(function(result){
		screenUnlock();
		var msgArr = result.split("@");
		var msg1 = msgArr[0];
		var msg2 = msgArr[1];
		if (msg1 == '0'){
			sAlert(msg2);
			$("[name='"+paramArr[0]+"']").val('');
			return false;
		} else if(msg1 == '1'){
			var parmValues = msg2.split("#");
			if(paramArr[1]!=null||paramArr[1]!=''){
				$("[name='"+paramArr[2]+"']").val(parmValues[0]);
				//$("[name='"+paramArr[3]+"']").val(parmValues[1]);
				sAlert("�˺�У��ɹ����˻��������Ϊ"+parmValues[1]);
			} else {
				sAlert("�˺�У��ɹ�");
			}
		} else {
			sAlert("ͨ���쳣");
			return false;
		}
	})
}
/**
 * ���Ʊϵͳͨ�ţ��ж�Ʊ����Ϣ��ѯ
 */
function getBillInfo(paramNames){
    var paramArr = paramNames.split(",");
	var bill_no = "";
	var cif_name = "";
	var bill_flag = "";
	bill_no = $("[name='"+paramArr[0]+"']").val();
	cif_name = $("[name='"+paramArr[1]+"']").val();
	bill_flag = $("[name='"+paramArr[2]+"']").val();
    if(bill_no=="" || bill_no==null){
    	sAlert("������Ʊ���˺ţ�");
    	return false;
    } else if(cif_name=="" || cif_name==null){
    	sAlert("�������տ�������");
    	return false;
    } else if(bill_flag=="" || bill_flag==null){
    	sAlert("������Ʊ�����ͣ�");
    	return false;
    }
    if(bill_flag =='1'){
    	var result=null;
	    var url = "TradeInterAction_getBillInfoList.action?bill_no="+bill_no+"&cif_name="+cif_name;
	    screenLock();
		$.when(getAjax(url)).done(function(result){
			screenUnlock();
			var msgArr = result.split("@");
			var msg1 = msgArr[0];
			var msg2 = msgArr[1];
			if (msg1 == '0'){
				sAlert(msg2);
				$("[name='"+paramArr[0]+"']").val('');
				return false;
			} else {
				var parmValues = msg2.split("#");
				$("[name='"+paramArr[3]+"']").val(parmValues[0]);
				$("[name='"+paramArr[4]+"']").val(parmValues[1]);
				$("[name='"+paramArr[5]+"']").val(parmValues[2]);
				$("[name='"+paramArr[6]+"']").val(parmValues[3]);
				$("[name='"+paramArr[7]+"']").val(parmValues[4]);
				$("[name='"+paramArr[8]+"']").val(parmValues[5]);
				sAlert("��ȡƱ����Ϣ�ɹ�");
			} 
		})
    } else {
    	sAlert("Ʊ������ΪֽƱ���������д���������Ϣ");
    }
}
/**
 * �����ͨ�ţ������Ϣ��ѯ 
 */
function getDueInfo(paramNames,dueFlag){
	var paramArr = paramNames.split(",");
	var due_no = $("[name='"+paramArr[0]+"']").val();
    if(due_no=="" || due_no==null){
    	alert("�������ݺţ�");
    	return false;
    }
    var result="";
    var url = "TradeInterAction_getDueInfo.action?due_no="+due_no+"&dueFlag="+dueFlag;
    screenLock();
	$.when(getAjax(url)).done(function(result){
		screenUnlock();
		var msgArr = result.split("@");
		var msg1 = msgArr[0];
		var msg2 = msgArr[1];
		if (msg1 == '0'){
			alert(msg2);
			$("[name='"+paramArr[0]+"']").val('');
			return false;
		} else if(msg1 == '1'){
			var parmValues = msg2.split("#");
			alert("��ȡ��������Ϣ�ɹ���");
			$("[name='"+paramArr[1]+"']").val(parmValues[0]);
			$("[name='"+paramArr[2]+"']").val(parmValues[1]);
			$("[name='"+paramArr[3]+"']").val(parmValues[2]);
			$("[name='"+paramArr[4]+"']").val(parmValues[3]);
			$("[name='"+paramArr[5]+"']").val('3');
		} 
	})
}
//������
function getAjax(url){
	var defer = $.Deferred();	
	$.ajax({ 
	   type: "post", 
	   url: url, 
	   success: function(data){
			defer.resolve(data);
		} 
    });
	return defer.promise();
}
/**
 * ���ʲ���--����ͨ��
 */
function trialRate(paramNames){
	var paramArr = paramNames.split(",");
	var sec_prod_no = $("[name='"+paramArr[0]+"']").val();   //��֤���ⲿ��Ʒ��
	var cur_no = $("[name='"+paramArr[1]+"']").val();        //����
	var sec_term_type = $("[name='"+paramArr[2]+"']").val(); //��֤��洢����
	var sec_amt = $("[name='"+paramArr[3]+"']").val();       //���
	var is_per_rate = $("[name='"+paramArr[4]+"']").val();   //�Żݱ�־
	var cif_no = $("[name='"+paramArr[5]+"']").val();        //�ͻ���
	var sec_acc = $("[name='"+paramArr[6]+"']").val();       //�˺�        
	var base_rate = $("[name='"+paramArr[7]+"']").val();     //��׼����      
	var rate_flt_per = $("[name='"+paramArr[8]+"']").val();  //���ʸ����ٷֱ�
	var rate_flt_point = $("[name='"+paramArr[9]+"']").val();//���ʸ�������  
	var pre_rate_per = $("[name='"+paramArr[10]+"']").val();  //�����Żݱ���  
	var pre_rate_point = $("[name='"+paramArr[11]+"']").val();//�����Żݵ���  
	var ln_rate = $("[name='"+paramArr[12]+"']").val();       //�˺�ִ������
    if(sec_acc=="" || sec_acc==null){
    	sAlert("�˺Ų���Ϊ�գ�");
    	return false;
    } else if(sec_prod_no=="" || sec_prod_no==null){
    	sAlert("��֤���ⲿ��Ʒ�Ų���Ϊ�գ�");
    	return false;
    } else if(sec_term_type=="" || sec_term_type==null){
    	sAlert("��֤��洢���Ͳ���Ϊ�գ�");
    	return false;
    } else if(is_per_rate=="" || is_per_rate==null){
    	sAlert("��ѡ���Ƿ��Żݣ�");
    	return false;
    } else if(sec_amt=="" || sec_amt==null){
    	sAlert("��֤��ר������Ϊ�գ�");
    	return false;
    } else if(cur_no=="" || cur_no==null){
    	sAlert("��֤����ֲ���Ϊ�գ�");
    	return false;
    }
    var result="";
    screenLock();
	$.when(trialRateAjax(sec_prod_no,cur_no,sec_term_type,sec_amt,is_per_rate,cif_no,sec_acc,ln_rate)).done(function(result){
		screenUnlock();
		var msgArr = result.split("@");
		var msg1 = msgArr[0];
		var msg2 = msgArr[1];
		
		if (msg1 == '0'){
			sAlert(msg2);
			return false;
		}  else if(msg1 == '1'){
			if(sec_prod_no=='0030'){
				sAlert("���ֹ�������Ϣ��ִ�С����桿����!");
			}else{
				var parmValues = msg2.split("#");
				$("[name='"+paramArr[7]+"']").val(parmValues[0]);
				$("[name='"+paramArr[8]+"']").val(parmValues[1]);
				$("[name='"+paramArr[9]+"']").val(parmValues[2]);
				$("[name='"+paramArr[10]+"']").val(parmValues[3]);
				$("[name='"+paramArr[11]+"']").val(parmValues[4]);
				$("[name='"+paramArr[12]+"']").val(parmValues[5]);
				sAlert("���ʲ���ɹ�");
			}
		} else {
			sAlert("ͨ���쳣");
		}
	})
}
//������
function trialRateAjax(sec_prod_no,cur_no,sec_term_type,sec_amt,is_per_rate,cif_no,sec_acc,ln_rate){
	var defer = $.Deferred();	
	$.post("TradeInterAction_trialRate.action", {
	    sec_prod_no:sec_prod_no,
		cur_no:cur_no,
		sec_term_type:sec_term_type,
		sec_amt:sec_amt,
		is_per_rate:is_per_rate,
		cif_no:cif_no,
		sec_acc:sec_acc,
		ln_rate:ln_rate
		}, function(data) {
			defer.resolve(data);
	});
	return defer.promise();
}
/**
 * �Ƿ�����ǰ������Ϣ���㡢������ǰ������Ϣ����
 * @param {Object} paramNames
 * @return {TypeName} 
 * getMess;pop;earlierTrialRate('acc_no,return_type,pay_inte_way,pay_amt,chane_plan_way,pay_inte,');
 */
function earlierTrialRate(paramNames){
	var paramArr = paramNames.split(",");
	var acc_no = $("[name='"+paramArr[0]+"']").val();     //�����˺�
	var return_type = $("[name='"+paramArr[1]+"']").val();   //�������ࣺ1-���ֹ黹/2-ȫ���黹 
	var pay_inte_way = $("[name='"+paramArr[2]+"']").val(); //��Ϣ��ʽ
	var pay_amt = $("[name='"+paramArr[3]+"']").val(); //����
	var chane_plan_way = $("[name='"+paramArr[4]+"']").val(); //�����ʽ
	var pay_sum = $("[name='"+paramArr[6]+"']").val(); //�黹�ܽ��
	var due_no = $("[name='"+paramArr[8]+"']").val(); //��ݺ�
	var if_cs = $("[name='"+paramArr[8]+"']").val(); //�Ƿ������Ϣ
	
	if(acc_no=="" || acc_no==null){
    	sAlert("�˺Ų���Ϊ�գ�");
    	return false;
    } else if(return_type=="" || return_type==null){
    	sAlert("�������಻��Ϊ�գ�");
    	return false;
    } else if(pay_inte_way=="" || pay_inte_way==null){
    	sAlert("��Ϣ��ʽ����Ϊ�գ�");
    	return false;
    } else if(pay_sum=="" || pay_sum==null){
    	sAlert("�黹�ܽ���Ϊ�գ�");
    	return false;
    }
	if(pay_inte_way == "1"){
    		sAlert("��Ϣ��ʽΪ[������]ʱ,����Ҫ������Ϣ!");
    		return false;
    	}
    var result="";
    screenLock();
	$.when(earlierTrialRateAjax(acc_no,return_type,pay_inte_way,pay_amt,chane_plan_way,pay_sum,due_no,if_cs)).done(function(result){
		screenUnlock();
		var msgArr = result.split("@");
		var msg1 = msgArr[0];
		var msg2 = msgArr[1];
		if (msg1 == '0'){
			sAlert(msg2);
			var parmValues = msg2.split("#");
			$("[name='"+paramArr[5]+"']").val('');//��Ϣ
			$("[name='"+paramArr[9]+"']").val('');//�Ƿ��Ѿ�������Ϣ��ʾ  Y ����
			return false;
		}  else if(msg1 == '1'){
			var parmValues = msg2.split("#");
			$("[name='"+paramArr[5]+"']").val(parmValues[0]);//��Ϣ
			$("[name='"+paramArr[3]+"']").val(parmValues[1]);//����
			$("[name='"+paramArr[6]+"']").val(parmValues[2]);//�ܽ��
			$("[name='"+paramArr[7]+"']").val(parmValues[3]);//ΥԼ��
			$("[name='"+paramArr[9]+"']").val('Y');//�Ƿ��Ѿ�������Ϣ��ʾ  Y ����
			sAlert("��ǰ������Ϣ����ɹ�");
		} else {
			sAlert("ͨ���쳣");
		}
	})	
}
//������
function earlierTrialRateAjax(acc_no,return_type,pay_inte_way,pay_amt,chane_plan_way,pay_sum,due_no){
	var defer = $.Deferred();	
	$.post("TradeInterAction_earlierTrialRate.action", {
	    acc_no:acc_no,
		return_type:return_type,
		pay_inte_way:pay_inte_way,
		pay_amt:pay_amt,
		chane_plan_way:chane_plan_way,
		pay_sum:pay_sum,
		due_no:due_no
		}, function(data) {
			defer.resolve(data);
	});
	return defer.promise();
}

function selectSql(parNames,popNames){
		var url = "LgsqlConfAction_findByPagePop.action?parNames=" + parNames
			+ "&popNames=" + popNames;
		window
		.showModalDialog(
				url,
				window,
				"dialogWidth=1080px;dialogHeight=500px;resizable=no;scrollbars=no;status:yes;help:no;");
}

function selectSQLScheme(parNames,popNames){
		var url = "LgschemeConfAction_findByPageForPop.action?parNames=" + parNames
			+ "&popNames=" + popNames;
		window
		.showModalDialog(
				url,
				window,
				"dialogWidth=1080px;dialogHeight=500px;resizable=no;scrollbars=no;status:yes;help:no;");
}
function getSecAmtTotal(paramNames){
	var paramArr = paramNames.split(",");
	var key_no = $("[name='"+paramArr[0]+"']").val();
	var scene_no = $("[name='scene_no']").val();
	var url = ""; 
	if(scene_no=="1"){
		url = "ApplyBaseAction_getSecAmtTotal.action?app_no="+key_no;
	}else if(scene_no=="3"){
		url = "LnPactAction_getSecAmtTotal.action?pact_no="+key_no;
	}
	$.when(getAjax(url)).done(function(result){
		screenUnlock();
		$("[name='"+paramArr[1]+"']").val(result);
	});
	
}
function forEndDateByBegDate(){
	fPopUpCalendarDlg();
	if($("[name='LN_PACT.BEG_DATE']").length>0){
		if($("[name='LN_PACT.BEG_DATE']").length>0){
			$("[name='LN_PACT.END_DATE']").val($("[name='LN_PACT.BEG_DATE']").val());
		}
	}
}

//�����Ʒ���pop
//function funcAcLnParmForPop(parNames,popNames){
//	var url="AcGlParmAction_findByPageForPop.action?parNames="+parNames+"&popNames="+popNames;
//	showDialog(url);
//}
function funcAcLnParmForPop(parNames,popNames){
	var url="AcLnParmAction_findByPageForPop.action?parNames="+parNames+"&popNames="+popNames;
	showDialog(url);
}
//����˳�����pop,��Ϣ����˳�����pop�����ڻ���˳�����pop
function funcAcLnRepaySeqForPop(parNames,popNames){
	var url="AcLnRepaySeqAction_findByPageForPop.action?parNames=" + parNames + "&popNames=" + popNames;
	showDialog(url);
}
//���ñ��pop
function funcAcChrgTypForPop(parNames,popNames){
	var url="AcChrgTypAction_findForPop.action?parNames=" + parNames + "&popNames=" + popNames;
	showDialog(url);
}
//�Ŵ���Ʒ���pop
function funcAcPrdtMapForPop(parNames,popNames){
	var url="AcPrdtMapAction_findForPop.action?parNames=" + parNames + "&popNames=" + popNames;
	showDialog(url);
}
//���ʱ��pop
function funGetAcComChrgRate(parNames,popNames){
	var url="AcComChrgRateAction_findByPageForPop.action?parNames=" + parNames + "&popNames=" + popNames;
	showDialog(url);
}
//�������ļ�pop
function funSelectAcLnMst(parNames,popNames){
	var url="AcLnMstAction_LoanAcctAdj_findByPageForPop.action?parNames=" + parNames + "&popNames=" + popNames;
	showDialog(url);
}

//����Ǽǲ�pop
function funSelectAcFactReg(parNames,popNames){
	var url="AcFactRegAction_findByPageForPop.action?parNames=" + parNames + "&popNames=" + popNames;
	//showDialog(url);
	window.showModalDialog(
				url,
				window,
				"dialogWidth=1080px;dialogHeight=500px;resizable=no;scrollbars=no;status:yes;help:no;");
}

//20151117���� -��ѯ���������Ϣpop
function funcGetFinBrNoPop(){
	var url = "AcSysFinOrgInfoAction_listPop.action";
	var temp = window.showModalDialog(url, window, "dialogWidth=20;dialogHeight=30;resizable=no;scrollbars=no;status:no;help:no;");
	if("undefined" == typeof(temp)){
		document.getElementsByName('fin_br_no')[0].value = '';
	}else{
		document.getElementsByName('fin_br_no')[0].value = temp;
	}
}
//���ڲ�Ʒ����ѡȡ�����Ʒ���
function funcAcGlPop(parNames, popNames) {
    var url = "AcGlParmAction_findByPageForPop.action?";
    url = url + "parNames=" + parNames + "&popNames=" + popNames;
    showDialog(url);
}
//��ȡ����ƻ���ʽ
function funcGetReplan(parNames,popNames){
	var url ="AcReplanFormulaAction_findByPageForPop.action?parNames="+parNames+"&popNames="+popNames;
	showDialog(url);
}
//������ѺƷ��ϢPOP
function funcGageRegGuaPop(parNames, popNames) {
	var gage_way = document.getElementsByName('gage_way')[0].value;
	var url = "GageRegAction_findByPageForGuaPop.action?parNames=" + parNames + "&popNames=" + popNames + "&gage_way=" + gage_way;
	showDialog(url);
}
//��ծ�����ѺƷ
function funcAftAssetPop(parNames,popNames,cifNo){
	var url ="LnGageAction_findByPageForPop.action?parNames="+parNames+"&popNames="+popNames+"&cifNo="+cifNo ;
	showDialog(url);
}
//�û���ͼ
function funcSysUserPop(parNames,popNames){
	var url ="SysUserAction_findByPageForPop.action?parNames="+parNames+"&popNames="+popNames ;
	showDialog(url);
}
//Ԥ����
function funcProjAcctPop(parNames,popNames,projNo){
	var url ="../../ProjAcctAction_findByPageForPop.action?parNames="+parNames+"&popNames="+popNames+"&projNo="+projNo ;
	showDialog(url);
}
