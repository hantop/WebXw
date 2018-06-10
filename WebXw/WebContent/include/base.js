function Page(pageNum) {
	try {
		document.page.currentPage.value = pageNum;
		document.page.submit();
		return true;
	} catch (e) {
		sAlert(e);
	}
}

function openurl(theURL, winName, features) {
	window.open(theURL, winName, features);
}

function my_print(ln){
	self.open(ln,"","height=620,width=700,resizeable=yes,scrollbars=yes");
}

function switch_updown() {
	if (mspan.title == "�ر�����") {
		mspan.title = "������";
		document.all("mtop").style.display = "none";
	} else {
		mspan.title = "�ر�����";
		document.all("mtop").style.display = "";
	}
}

function switch_leftRight() {
	if (mspan.title == "�رտͻ��б�") {
		mspan.title = "�򿪿ͻ��б�";
		document.all("mleft").style.display = "none";
	} else {
		mspan.title = "�رտͻ��б�";
		document.all("mleft").style.display = "";
	}
}

function replaceAll(str, str1, str2) {
	while (str.indexOf(str1) >= 0)
		str = str.replace(str1, str2);

	return str;
}

function getParam(str, leftFlag, rightFlag) {
	var param = "";
	while (str.indexOf(rightFlag) < str.indexOf(leftFlag)) {
		if (str.indexOf(rightFlag) < 0)
			break;
		str = str.substring(str.indexOf(rightFlag) + 1);
	}

	if (str.indexOf(leftFlag) >= 0 && str.indexOf(rightFlag) >= 0) {
		var pos1 = str.indexOf(leftFlag);
		var pos2 = str.indexOf(rightFlag);
		param = str.substring(pos1 + 1, pos2);
	}
	return param;
}

function samepara() {
	kind = document.all["param"].value;
	if (kind == "1") {
		para = document.all["param1"].value;
		document.all["param2"].value = para;
		document.all["param3"].value = para;
		document.all["param4"].value = para;
		document.all["param5"].value = para;
		document.all["param6"].value = para;
		document.all["param7"].value = para;
		document.all["param8"].value = para;
		document.all["param9"].value = para;
		document.all["param10"].value = para;
		document.all["param11"].value = para;
		document.all["param12"].value = para;
	}

}

function setElementValue(src, value) {
	document.all[src].value = value;
}

function setQuery(kind) {
	document.all["query"].value = kind;
}

function displaylayer() {
	laywait.style.visibility = "visible";

}

function popMessage(msg) {
	if (msg != null && msg != "") {
		sAlert(msg);
	}

}

function stat() {
	var a = pageYOffset + window.innerHeight - document.bar.document.height
			- 15;
	document.bar.top = pageYOffset;
	setTimeout('stat()', 2);
}
function iefd(offsetxpos, offsetypos) {
	bar.style.top = document.body.scrollTop + document.body.offsetHeight
			- offsetypos;
	bar.style.left = document.body.scrollLeft + document.body.offsetWidth
			- offsetxpos;
	setTimeout("iefd(" + offsetxpos + "," + offsetypos + ")", 2);
}//<!-- ������ --->
function fix(offsetxpos,offsetypos){
  nome=navigator.appName;
  if(nome=='Netscape'){
    stat();
  }else{
    iefd(offsetxpos,offsetypos);
  }
}

//<!-- ��ձ����� --->
function clearAll(theForm){
	len = theForm.elements.length;
	for(i=0;i<len;i++){
		//alert(theForm.elements[i].type);
		if(theForm.elements[i].type == 'checkbox'){
				theForm.elements[i].checked = false;
		}
		if(theForm.elements[i].type == 'radio'){
			theForm.elements[i].checked = false;
		}
		if(theForm.elements[i].type == 'select-one'){
			theForm.elements[i].value = theForm.elements[i].options[0].value ;
		}
		if(theForm.elements[i].type == 'text')
		  theForm.elements[i].value = "";
		  
		if(theForm.elements[i].type == 'textarea')
		  theForm.elements[i].value = "";
	}
} 

//<!-- ��ո�ѡ�� --->
function clearAllCheckbox(theForm){
	len = theForm.elements.length;
	for(i=0;i<len;i++){
		//alert(theForm.elements[i].type);
		if(theForm.elements[i].type == 'checkbox'){
				theForm.elements[i].checked = false;
		}
	}
} 
//<!-- ѡ�����и�ѡ�� --->
function selAllCheckbox(theForm){
	len = theForm.elements.length;
	for(i=0;i<len;i++){
		//alert(theForm.elements[i].type);
		if(theForm.elements[i].type == 'checkbox'){
				theForm.elements[i].checked = true;
		}
	}
} 

//<!-- ����ѡ�����и�ѡ����� --->
function countCheckbox(theForm){
	sum = 0;
	len = theForm.elements.length;
	for(i=0;i<len;i++){
		//alert(theForm.elements[i].type);
		if(theForm.elements[i].type == 'checkbox' && theForm.elements[i].checked == true){
				sum ++ ;
		}
	}
	return sum;
} 

//<!-- �õ�ѡ������ı� -->
	function getSelectText(src){
		return src.options[src.selectedIndex].text;
	}

//<!-- ȷ��ִ�в��� -->
function lkconfirm(lk){
  flag=window.confirm("��ȷ���Ƿ�Ҫִ�д˲���������ȡ������ʾ�����д˲�����");
  if(flag){
  	location.href = lk;
  	//location.href.click();
  }
}

//<!-- POP�������� -->
function poptest(lk){
  	var valueStr=lk.split("?")[1].split("&");
	var scene_id=valueStr[0].split("=")[1];//�������]
	var check_flag = scene_id.substring(0,1);
	var if_checkbox=valueStr[1].split("=")[1];//�Ƿ��ѡ
	if(if_checkbox!='1'){
		func_popRadio(scene_id,'');
	}else{
		if(check_flag=='D'){    // ���Ҷ�ѡ��
			func_pop(scene_id,'','');
		}else{
			func_popCheckbox(scene_id,'');
		}
	}
}

//��������ȷ�ϲ���
function lkconfirmWithLock(lk){
  flag=window.confirm("��ȷ���Ƿ�Ҫִ�д˲���������ȡ������ʾ�����д˲�����");
  if(flag){
	screenLock();
  	location.href = lk;
  }
}
//<!-- ����ҳ���еĲ鿴��ť���� -->
function fromInfoView(fieldName,fieldValue,lk){
	if(fieldValue=='' ||fieldValue==null ){
		sAlert(fieldName+"Ϊ�գ��븳ֵ����ܲ鿴!");
		return;
	}
	window.open(lk,"window","status:no;help:no;border:thin;statusbar:no,left=100,top=30,resizable=yes,width=1200,height=600");
 
}
//<!-- TABLE�а�ťִ��JS���� -->
function buttonforward(lk){
  	location.href = lk;
  	//location.href.click();
}
//<!--��������ύ����-->
function func_submitconfirm(lk) {
	var strs=lk.split("&");
	var str=strs[1];
	var temps=str.split("=");
	var status=temps[1];

	if (confirm('�ύ��Ͳ����޸�,ȷ���ύ��')) {
		if (status == "0" ||status == "2") {
			location.href = lk;
			//location.href.click();
		} else {
			sAlert('���������ύ��');
			return;
		}
	}
}

//<!-- ����url -->
function linkUrl(lk,win){
  	location.href = lk;
  	location.href.target = '_blank';
  	//location.href.click();
}


//the page could invoke history.goback(-1) to goback last page while isGoBack is not null
//but please specify the var isGoBack's value in your page, eg: isGoBack = true;
var isGoBack; 

function historyForward() {
	if(  isGoBack == "undefined" || isGoBack == null ) {
		window.history.forward(50);
	}
}

historyForward();

//<!-- ��ҳJS -->
 function doEadisPage(url,v){
	
	  url = trim(url);
	  var formself;
	  var formfirst;
	  var forms = document.getElementsByTagName("form");
	  for(var i=0;i<forms.length;i++){
			var form = forms[i];
			if(form.action==url&& (form.name=='null'||form.name=='formBean')||form.name=='tableDataBean'){
					formself=form;
			}
			if(form.name!='null' && form.name!='formBean' && form.name!='tableDataBean'){
				if(form.action.indexOf("/")>=0){
	                var tempUrl =  form.action.substring(form.action.lastIndexOf("/")+1,form.action.length);
	                tempUrl = trim(tempUrl);
	                if(tempUrl==url){
	                	formfirst = form;
	                }
	            }else{
	            	 tempUrl = trim(form.action);
	                if(tempUrl==url){
	                	formfirst = form;
	                }
	            }
			}
	  }
	  
      if(formfirst){
    	   var eles=formfirst.elements;
		 	var esubmit;
            for(i=0;i<eles.length;i++){
               e=eles[i];
               if(e.name=='eadis_page'){
            	   e.value=v;
               }
               if(e.name=='formPage'){
            	   e.value=v;
               }
                if(e.name=='submitgo'){
            	   esubmit=e;
               }
            }
            esubmit.click();
      }else {
    		  var eles=formself.elements;
		 	var esubmit;
             for(i=0;i<eles.length;i++){
               e=eles[i];
                if(e.name=='formPage'){
            	   e.value=v;
               }
               if(e.name=='eadis_page'){
            	   e.value=v;
               }
                if(e.name=='submitgo'){
            	   esubmit=e;
               }
            }
               esubmit.click();
      }
 }
 function trim(oValue){
		oValue = oValue.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
		return oValue;
	}
	/**
	*	���������ֵ������ʾ����
	*/ 
	function makeOptions(objName, allowOptionStr) {
		var obj = document.getElementsByName(objName)[0];
		var allowOptionStr = allowOptionStr.split(","); 
		if(obj){
			var options=obj.options;
			if(options){
			for ( var i = options.length - 1; i >= 0; i--) {
				var k = 0;
				//���ݷ���ֵ�Ƴ���������ؿ������κδ���
				if (allowOptionStr != '' && options[i].value != '' ) {
					for(var j=0 ; j<allowOptionStr.length;j++){
						if(options[i].value !=allowOptionStr[j]){
							k ++;
						}
					}
					if(k !=allowOptionStr.length-1){
						options.remove(i);
					}
				}
			}
			}
		}
	}
	
	function getCursorPsn(inObject){
		var position = 0; 
		var domObj = inObject;
		if (document.selection) {	//for IE
			domObj.focus();
			var sel = document.selection.createRange();
			sel.moveStart('character', -domObj.value.length);
	
			position = sel.text.length;
		} else if (domObj.selectionStart || domObj.selectionStart == '0') {
			position = domObj.selectionStart;
		}
		return position;
	}
	
	function getOstr(inObject,position){
		var sumOstr = 0;
		var inStr = inObject.value;
		if(inStr.length > 0){
			var lStr = inStr.substring(0,position);
			for(var i=0; i<lStr.length; i++){
				var v = lStr.charAt(i);
				if(isNaN(v)){
					sumOstr++;
				}
			}
		}
		return sumOstr;
	}
		//<!-- ǧ��λ --> //wusheng
	function toMoney(inObject) {
		//��ȡ���λ��
		var position = getCursorPsn(inObject);
		//��ȡ���ǰ�����ָ���
		var sumOstr = getOstr(inObject,position);
		
		var inStr = inObject.value;
		var i, charValue, outStr, id = 0,fs=0;
		//var fsInStr ="";

		for (i = 0; i < inStr.length; i++) {
			charValue = inStr.charAt(i);
			//alert("charValue:"+charValue+":"+i+":"+inStr.length);
			if (isNaN(parseInt(charValue, 10)) && (charValue != ".")
					&& (charValue != ",") && (charValue != "-")) {
				if(fs==1)
					inObject.value = "-"+inStr.substring(0, i)+inStr.substring(i+1, inStr.length);
				else
					inObject.value = inStr.substring(0, i)+inStr.substring(i+1, inStr.length);
				return;
			}
			if (i>0 && charValue == "-") {
				if(fs==1)
					inObject.value = "-"+inStr.substring(0, i)+inStr.substring(i+1, inStr.length);
				else
					inObject.value = inStr.substring(0, i)+inStr.substring(i+1, inStr.length);
				return;
			}
			if (i==0 && charValue == "-") {
				fs = 1;
				inStr = inStr.substr(1, inStr.length);
				i=-1;
			}
			if (charValue != "0") {
				id = 1;
			}
		
			if (id == 0 && i == 1 && charValue == "0") {
				inStr = inStr.substr(1, inStr.length - 1);
				i = 0;
			}
		}
		
		var valueArr;

		valueArr = inStr.split(".");

		if (valueArr.length > 2) {
			sAlert(inStr + " �Ƿ����!");
			inObject.focus();
			inObject.select();
			return;
		}

		var dotStr, dotValue;

		if (valueArr.length == 2) {
			dotValue = valueArr[1];
			if (dotValue.length == 0) {
				dotStr = "";
			} else {
				if (dotValue.length == 1)
					dotStr = dotValue+ "";
				else
					dotStr = dotValue.substring(0, dotValue.length);
			}
		}	
		
		var intArr;

		intArr = valueArr[0].split(",");

		var intValue = "";

		for (i = 0; i < intArr.length; i++) {
			intValue += intArr[i];
		}
		var intStr = "";

		if (intValue.length > 1 && intValue.charAt(0) == "0"
				&& intValue.charAt(1) != ".") {
			intValue = intValue.substr(1, intValue.length - 1);
		}

		while (intValue.length > 3) {
			intStr = ","
					+ intValue.substring(intValue.length - 3, intValue.length)
					+ intStr;
			intValue = intValue.substring(0, intValue.length - 3);
		}
		intStr = intValue + intStr;

		if (dotStr == null)
			outStr = intStr;
		else
			outStr = intStr + "." + dotStr;
		
		if(fs==1){
			outStr = "-" + outStr;
		}

		inObject.value = outStr;
		
		var esumOstr = getOstr(inObject,position);
		
		//���ù��λ��
		position = position + (esumOstr - sumOstr);
		setgetCursorPsn(inObject,position);
		
		return;
	}
	
	function setgetCursorPsn(domObj,position){
		if (document.selection) {	//for IE
			domObj.focus();
			var sel = document.selection.createRange();
			var r = domObj.createTextRange();   
			r.collapse(true);  
			r.moveStart('character', position);
			r.select();   
			
		} else  {
			domObj.selectionStart = position;
		}
	}
	
	
	function toDouble(inObject) {
		var inStr = inObject.value;
		var i, charValue, outStr, id = 0,fs=0;
		for (i = 0; i < inStr.length; i++) {
			charValue = inStr.charAt(i);
			if (isNaN(parseInt(charValue, 10)) && (charValue != ".")
					&& (charValue != ",") && (charValue != "-")) {
				if(fs==1)
					inObject.value = "-"+inStr.substring(0, i)+inStr.substring(i+1, inStr.length);
				else
					inObject.value = inStr.substring(0, i)+inStr.substring(i+1, inStr.length);
				return;
			}
			if (i>0 && charValue == "-") {
				if(fs==1)
					inObject.value = "-"+inStr.substring(0, i)+inStr.substring(i+1, inStr.length);
				else
					inObject.value = inStr.substring(0, i)+inStr.substring(i+1, inStr.length);
				return;
			}
			if (i==0 && charValue == "-") {
				fs = 1;
				inStr = inStr.substr(1, inStr.length);
				i=-1;
			}
			if (charValue != "0") {
				id = 1;
			}
			if (id == 0 && i == 1 && charValue == "0") {
				inStr = inStr.substr(1, inStr.length - 1);
				i = 0;
			}
		}
		var valueArr;
		valueArr = inStr.split(".");
		if (valueArr.length > 2) {
			sAlert(inStr + " �Ƿ���ֵ!");
			inObject.focus();
			inObject.select();
			return;
		}
		var dotStr, dotValue;
		if (valueArr.length == 2) {
			dotValue = valueArr[1];
			if (dotValue.length == 0) {
				dotStr = "";
			} else {
				if (dotValue.length == 1)
					dotStr = dotValue+ "";
				else
					dotStr = dotValue.substring(0, dotValue.length);
			}
		}	
		var intArr;
		intArr = valueArr[0].split(",");
		var intValue = "";
		for (i = 0; i < intArr.length; i++) {
			intValue += intArr[i];
		}
		var intStr = "";
		if (intValue.length > 1 && intValue.charAt(0) == "0"
			&& intValue.charAt(1) != ".") {
			intValue = intValue.substr(1, intValue.length - 1);
		}
		while (intValue.length > 3) {
			intStr = intValue.substring(intValue.length - 3, intValue.length) + intStr;
			intValue = intValue.substring(0, intValue.length - 3);
		}
		intStr = intValue + intStr;
		if (dotStr == null)
			outStr = intStr;
		else
			outStr = intStr + "." + dotStr;
		if(fs==1){
			outStr = "-" + outStr;
		}
		inObject.value = outStr;
		return;
	}

	function lastMoney(inObject) {
		var inStr = inObject.value;
		
		var i, charValue, id = 0,fs=0;
		for (i = 0; i < inStr.length; i++) {
			charValue = inStr.charAt(i);
			// alert("charValue:"+charValue+":"+i+":"+inStr.length);
			if (isNaN(parseInt(charValue, 10)) && (charValue != ".")
					&& (charValue != ",") && (charValue != "-")) {
				if(fs==1)
					inStr = "-"+inStr.substring(0, i);
				else
					inStr = inStr.substring(0, i);
			}
			if (i>0 && charValue == "-") {
				if(fs==1)
					inStr = "-"+inStr.substring(0, i);
				else
					inStr = inStr.substring(0, i);
			}
			if (i==0 && charValue == "-") {
				fs = 1;
				inStr = inStr.substr(1, inStr.length);
				i=-1;
			}
			if (charValue != "0") {
				id = 1;
			}
		
			if (id == 0 && i == 1 && charValue == "0") {
				inStr = inStr.substr(1, inStr.length - 1);
				i = 0;
			}
		}
		
		var valueArr = inStr.split(".");

		if (valueArr.length > 2) {
			sAlert(inStr + " �Ƿ����!");
			inObject.focus();
			inObject.select();
			return;
		}

		var dotStr="", dotValue;

		if (valueArr.length == 2) {
			dotValue = valueArr[1];
			if (dotValue.length == 0) {
				dotStr = "";
			} else {
				if (dotValue.length == 1)
					dotStr = dotValue+ "";
				else
					dotStr = dotValue.substring(0, dotValue.length);
			}
		}	
		
		var intArr;

		intArr = valueArr[0].split(",");

		var intValue = "";

		for (i = 0; i < intArr.length; i++) {
			intValue += intArr[i];
		}
		var intStr = "";

		if (intValue.length > 1 && intValue.charAt(0) == "0"
				&& intValue.charAt(1) != ".") {
			intValue = intValue.substr(1, intValue.length - 1);
		}

		while (intValue.length > 3) {
			intStr = ","
					+ intValue.substring(intValue.length - 3, intValue.length)
					+ intStr;
			intValue = intValue.substring(0, intValue.length - 3);
		}
		intStr = intValue + intStr;

		if (dotStr == "")
			inStr = intStr;
		else
			inStr = intStr + "." + dotStr;
		
		if(fs==1){
			inStr = "-" + inStr;
		}
		var outStr;

		var valueArr = inStr.split(".");

		var dotStr="", dotValue;

		if (valueArr.length == 2) {
			dotValue = valueArr[1];
			if (dotValue.length == 0) {
				dotStr = "00";
			} else {
				if (dotValue.length == 1)
					dotStr = dotValue + "0";
				else{
					var is0 = 0;
					for (i = dotValue.length-1; i >= 2; i--) {
						var charValue = dotValue.charAt(i);
						if(charValue!="0" || is0!=0){
							if(charValue!=",")
								dotStr = charValue + dotStr;
							is0 = 1;
						}
					}
					dotStr = dotValue.substring(0, 2) + dotStr;
					if(dotStr.length > 6)
						dotStr = dotStr.substring(0, 6);
					else
						dotStr = dotStr.substring(0, dotStr.length);
					//dotStr = dotValue.substring(0, 2);
				}
			}
		} else {
			dotStr = "00";
		}

		var intStr = valueArr[0];

		if (intStr == "" || intStr == null)
			intStr = "0";

		outStr = intStr + "." + dotStr;

		if (outStr == "" || outStr == null || outStr == ".00"
				|| outStr == "0.00" || outStr == ".")
			inObject.value = "";
		else
			inObject.value = outStr;

		return;
	}
	function enterKey()
	{
		if (event.keyCode==13 && event.srcElement.type.toLowerCase()!="textarea") 
	   {
	       event.keyCode=9;
	   }
	   return;
	}

	function enterKeyEmpty()
	{
	}

/**
 * ����ֱ��ҳ��ˢ�£�div��tld.jsp�ж��壩
 */
function screenLock() {
	$("#screenLockDiv").css({"width" : document.body.scrollWidth,
		"height" : document.body.scrollHeight,
		"opacity" : "0.5"
	}).fadeIn('normal');
	if(document.getElementsByTagName('body') && document.getElementsByTagName('body')[0]){
		document.getElementsByTagName('body')[0].style.overflow = 'hidden'; // ���ع�����
	}
		
}

/**
 * �������
 */
function screenUnlock() {
	$("#screenLockDiv").fadeOut('normal');
	document.getElementsByTagName('body')[0].style.overflow = 'auto'; // ��ʾ������
}


function submitJsMethod(form, otherExtend) {
	screenLock();
	if (func_uior_calAll(form)) {
		try {
			if (otherExtend == "" || otherExtend == 'null'
					|| otherExtend == 'undefined' || otherExtend == null) {
				screenUnlock();
				return true;
			}
			var flag = true;
			var otherExtendGroup = otherExtend.split(";");
			for (var k = 0; k < otherExtendGroup.length; k++) {
				if (otherExtendGroup[k] != null
						&& otherExtendGroup[k] != undefined
						&& otherExtendGroup[k] != '') {
					flag = eval(otherExtendGroup[k]);
					if (!flag) {
						screenUnlock();
						return false;
					}
				}
			}
			screenUnlock();
			return flag;
		} catch (e) {
			screenUnlock();
			return false;
		}
	} else {
		screenUnlock();
		return false;
	}
}
function firstEadisPageFlag(){
	document.all('eadis_page').value='1';
	return true;
}
/**
 * ����ҳ���� ��������Ҫ�ػ�ȡ����ʱ����ȫ��ѡ��Ч�����ٴε���ı��򣬿��ڶ�λ�ı�������λ�á�
 */
var numericaltimes = 0;
function selectInput(obj){
	if(++numericaltimes==1){
		obj.select();
	}
}

function resetTimes(){
	numericaltimes = 0;
}
/**
 * ��JSδʹ��
 */
function out(obj){
		//obj.style.color = "black";
}
/**
 * ��JSδʹ��
 */
function over(obj){
		//obj.style.color = "#06F";
}

/**
 * ��ʾtextareaʣ������뺺������Div��onfoucs�¼���div��/include/tld.jsp�ж��壩
 * @param textarea �����ı������
 */
function showCharsInfo(textarea) {
	if (textarea.maxlength && !document.getElementById(textarea.name).readOnly) {
		var obj = document.getElementById(textarea.name + "-charsdiv");
		if( obj ) {
			obj.style.display = "inline";
		}
		textareaInputCount(textarea);
	}
}
/**
 * ����textareaʣ������뺺������Div��onblur�¼���div��/include/tld.jsp�ж��壩
 * @param textarea �����ı������
 */
function hideCharsInfo(textarea) {
	if (textarea.maxlength && !document.getElementById(textarea.name).readOnly) {
		var obj = document.getElementById(textarea.name + "-charsdiv");
		if( obj ) {
			obj.style.display = "none";
		}
	}
}
/**
 * ���㲢����textarea�������ֽ�����onkeyup�¼���div��/include/tld.jsp�ж��壬һ�����ֵ��������ֽڣ�
 * @param textarea �����ı������
 */
function textareaInputCount(textarea) {
	var strValue = textarea.value; // ��ǰ�ı���ֵ
	var strMaxlength = textarea.maxlength; // ����������ֽ���
	if(!strMaxlength || strMaxlength==null){
		strMaxlength = $(textarea).prop("maxlength");
	}
    var byteCount = 0; // �Ѿ�������ֽ���
	var remainlength = strMaxlength; // ʣ���ֽ���
    for (var i = 0; i < strValue.length; i++) {
        var c = strValue.charCodeAt(i);
        if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
            byteCount++; //���ֽڼ�1
        } else {
            byteCount += 2;
        }
		remainlength = strMaxlength - byteCount;
		if (byteCount > strMaxlength) {
			textarea.value = strValue.substring(0, i);
			byteCount = strMaxlength;
			remainlength = 0;
			break;
		}
	}
    if (document.getElementById(textarea.name + "-charsdiv")) {
    	document.getElementById(textarea.name + "-charsdiv").innerHTML = parseInt(remainlength/2);
    }
}

/*
 * To custom css style for td of table.
 */
function setTableTdCSS(tableId, attrName, attrValue) {
	$( (tableId + " tr>td") ).each(function(){
		$(this).css(attrName, attrValue);
	});
}


//���ת��Ϊȫ�Ǻ��� 
function halfToFullWidth(obj) {
var	txtstring = obj.value;
var tmp = ""; 
	for(var i=0;i<txtstring.length;i++) { 
		if(txtstring.charCodeAt(i)==32) { 
		tmp= tmp+ String.fromCharCode(12288); 
		} else if(txtstring.charCodeAt(i)<127 && txtstring.charCodeAt(i)>32) { 
		 	tmp=tmp+String.fromCharCode(txtstring.charCodeAt(i)+65248); 
		} else{
			tmp += String.fromCharCode(txtstring.charCodeAt(i));
		}
	} 
obj.value=tmp;
} 
//ȫ��ת��Ϊ��Ǻ��� 
function fullToHalfWidth(obj) { 
var str = obj.value;
var tmp = ""; 
for(var i=0;i<str.length;i++) { 
	if(str.charCodeAt(i)==12288) { 
		tmp= tmp+ String.fromCharCode(32); 
	} else if(str.charCodeAt(i)>65280&&str.charCodeAt(i)<65375) { 
		tmp += String.fromCharCode(str.charCodeAt(i)-65248); 
	} else { 
		tmp += String.fromCharCode(str.charCodeAt(i)); 
	} 
} 
obj.value=tmp;
}

//�������ֹ�ֶ��޸�
	function banUpdate(){
		sAlert("��ֹ�ֶ��޸�!");
		return false;
	}

//����ҳ�رպ�ˢ�¸�ҳ��
	function show_dialog(href,reloadUrl){
		showDialog(href);
		if(reloadUrl){
			location.href = reloadUrl;
		}else{
			if(document.cms_form){
				document.cms_form.submit();
			}else{
				window.location.reload();
			}
		}
	}
//showDialog����ҳ��ʱ,��ִ����ת���ᵱǰҳ����ת�������ֵ����µ�ҳ�棬�ô˷�������� ���<base target="_self"> ʹ��
	function go_link(url){
	    var link = document.createElement("a");
		link.href=url;
		document.body.appendChild(link);
		link.click();
	}
	function printOpen(lk){
		var sFeatures = "height=800, width=1500, top=0, left=0, resizable=yes, scrollbars=yes, alwaysLowered=yes,menubar=no,status=no";
	    window.open(lk, "_blank", sFeatures);
	}
	if (!Array.prototype.indexOf)
	{
	    Array.prototype.indexOf = function(elt /*, from*/)
	    {
	        var len = this.length >>> 0;
	        var from = Number(arguments[1]) || 0;
	        from = (from < 0)
	            ? Math.ceil(from)
	            : Math.floor(from);
	        if (from < 0)
	            from += len;
	        for (; from < len; from++)
	        {
	            if (from in this &&
	                this[from] === elt)
	                return from;
	        }
	        return -1;
	    };
	}
    function Money(obj){//��֤���Ⱥͽ�����Ϳ���Ϊ13λ�Ľ������
				var  mone=obj.value;
				if(mone.length>20){
					sAlert("�������13λ");
					obj.value="";
				}
			}
    
function changeButtonPic(){
	if(arguments.length<2)return;
	var className = arguments[0];
	if(!className)className="btn_50";
	var buttonName;
	for(var index = 1;index<arguments.length;index++){
		buttonName = arguments[index];
		if(document.getElementsByName(buttonName)){
			var $button = $(document.getElementsByName(buttonName)).next();
			$button.attr("class",className);
		}
	}
}

// �����������
function checkInt(mythis){
	var title = mythis.title;
	if (isNaN(mythis.value)){
		sAlert(title + "��������,������!");
		mythis.value="0"
		mythis.focus();
		return false;
	}else{
		return true;
	}
}
/*
 * ����ʽ��
 */
function formatAmt(value) {
	if( value == undefined || typeof(value) == "undefined" || null == value ) {
		document.write("0.00");
		return;
	}
	var amt = String(parseFloat(String(value)).toFixed(2));
	if( parseFloat(amt) < 1000 ) {
		document.write(amt);
		return;
	}
	var r1 = /\d{4}\./;
	if(r1.test(amt))
		amt = amt.replace(/(\d)(\d{3}\.)/,"$1,$2");
	else
		amt = amt.replace(/(\d)(\d{3})$/, "$1,$2");
	var r2 = /\d{4},/;
	while(r2.test(amt))
		amt = amt.replace(/(\d)(\d{3},)/, "$1,$2");
	document.write(amt);
}

//���ת�� ,s--ת������  n-��ȷλ��
function fmoney(s, n)   
{   
   n = n > 0 && n <= 20 ? n : 2;   
   s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";   
   var l = s.split(".")[0].split("").reverse(),   
   r = s.split(".")[1];   
   t = "";   
   for(i = 0; i < l.length; i ++ )   
   {   
      t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");   
   }   
   return t.split("").reverse().join("") + "." + r;   
} 