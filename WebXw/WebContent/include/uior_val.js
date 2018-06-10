var stack = new Stack(); //���ڰ���׺ʽת���ɺ�׺ʽ
var errorMsg = ''; //��¼������Ϣ
var curFormula; //��¼��ǰ�����Ĺ�ʽ
/*
 * �ύ������ʱ��֤�������������,��֤���ڹ�ʽ
 */
function func_uior_calAll(frm) {
	var allResult = 0;
	errorMsg = func_uior_valForm(frm);	//��֤������
	if (errorMsg == '' || errorMsg == 'undefined') {
		var formulasObj = frm.elements['formulavalidate'];
		if (formulasObj != undefined && formulasObj != null) {
			var formulas = formulasObj.value;
			var funcs = formulas.split(';');
			for ( var i = 0; i < funcs.length; i++) {
				var formula = funcs[i];
				if (formula != null && formula != undefined && formula != '') {
					curFormula = formula;
					var result = func_uior_cal(formula, frm);
					//����ֵ�Ƿ�Ϊtrue
					if (!result) {
						allResult = 1;
						curFormula = parseFormula(curFormula);
						var strs = curFormula
								.split(/\||\&>=|<=|!=|=|>|<|\+|-|\*|\/|\(|\)/);
						for ( var j = 0; j < strs.length; j++) {
							var title = '';
							var obj = document.all(strs[j]);
							if (strs[j].charAt(0) == '$') {
								obj = document.getElementById("sysDate");
								title = "ϵͳӪҵ����";
							} else {
								if(typeof obj == "NodeList" && obj.length>0){
									obj = obj.item(0);
									title = obj.getAttribute('title');
								} else {
									if(obj){
										title = obj.getAttribute('title');
									}else {
										title = strs[j];
									}
								}
							}
							if(obj && title){
								curFormula = curFormula.replace(strs[j], title);
							}
						}
						if(errorMsg!=''){
							errorMsg = errorMsg + "\nУ������:[ "+curFormula+" ]������!";
						} else {
							errorMsg = "У������:[ "+curFormula+" ]������!";
						}
						break;
					}
				}
			}
		}
	}
	//�д�����Ϣ,���ʾûͨ��У��
	if (errorMsg != '') {
		sAlert(errorMsg);
		return false;
	} else {
		//������й�ʽ������true
		if (allResult == 0) {
			return true;
		} else {
			return false;
		}
	}

}

//���������
function func_uior_cal(formula, frm) {
	formula = parseFormula(formula); //�Թ�ʽ���и�ʽ��
	formula = transFormula(formula, frm); //�Թ�ʽ����ת��
	var result = logic(formula); //�Թ�ʽ�����߼�������������,�����߼�����
	if (/@/.test(result)) { //�����߼����㷵�ص�ֵΪ 1@��0@������������������Ϊ1,0�����
		var flag = result.charAt(0);
		if (flag == 1) {
			result = true;
		} else {
			result = false;
		} 
	}

	return result;
}

//�Թ�ʽ���и�ʽ��
function parseFormula(formula) {

	formula = formula.replace(/{/g, '('); //�����е�{}�滻��()
	formula = formula.replace(/}/g, ')');
	formula = formula.replace(/\[/g, '('); //�����е�[]�滻��()
	formula = formula.replace(/\]/g, ')');
	formula = formula.replace(/\&\&/g, '&'); //�����е�&&�滻��&
	formula = formula.replace(/\|\|/g, '|'); //�����е�||�滻��|

	return formula;
}

//�Թ�ʽ����ת��
function transFormula(formula, frm) {
	//����ʽ����|��&�ֳ�����
	var strs = formula.split(/\||\&/);
	for ( var i = 0; i < strs.length; i++) {
		var str = strs[i];
		str = parseParen(str); //����ֳ���������Ų�ƥ�������
		//����ʽ����>= <= != == > <�ֳ�����,>=Ҫ��>֮ǰ,������1>=2�ֳ� 1,=2
		var eles = str.split(/>=|<=|!=|=|>|</);
		//�������>1˵���������Ϸ���
		if (eles.length > 1) {
			var eleLeft = eles[0];
			var eleRight = eles[1];
			//����벿�ֵ�����������н�����������
			var resultLeft = infixTrans(eleLeft, frm);
			//���Ұ벿�ֵ�����������н�����������
			var resultRight = infixTrans(eleRight, frm);
			//��ò�����
			var index = str.indexOf(eleLeft) + eleLeft.length;
			var op = str.substring(index, index + 2);
			//�ж���>=����,����>����
			if (op.charAt(1) != '=') {
				op = op.charAt(0);
			}
			//�����߼�����
			var result = doCalculate(resultLeft, resultRight, op);
			formula = formula.replace(str, result);
			if (strs.length == 1) {
				formula = formula + '@';
			}
		} else if (eles.length == 1) { //ֻ��������������
			var eleLeft = eles[0];
			var resultLeft = infixTrans(eleLeft, frm);
			formula = resultLeft;
		}
	}
	return formula;
}

//������Ų�ƥ�������
function parseParen(str) {
	var left = 0;
	var right = 0;
	for ( var i = 0; i < str.length; i++) {
		var ch = str.charAt(i);
		if (ch == '(') {
			left++;
		}
		if (ch == ')') {
			right++;
		}
	}
	var temp = left - right;
	if (temp > 0) {
		return str.substring(temp);
	} else if (temp < 0) {
		return str.substring(0, str.length + temp);
	} else {
		return str;
	}
}

//������������
function infixTrans(formula,frm) {
	var first = formula.charAt(0);
	var reg = /\d*\(*\+*-*/;	//����ĸ������,(,+,-
	if (!reg.test(first)) {
		errorMsg=errorMsg.concat(curFormula+'��ʽ��������!\n');
	}
	var outPut = doTrans(formula);	//�Թ�ʽ����ת��
	var regTest = /(\(+)|(\)+)/;	//ת����Ĺ�ʽ������()
	if (regTest.test(outPut)) {
		errorMsg=errorMsg.concat(curFormula+'��ʽ��������!\n');
	} else {
		var fir = outPut.charAt(0);	//�����λ����������
		if (fir == '@') {
			outPut = outPut.replace(fir, '0' + fir);
		}
		outPut = outPut.replace(/@$/, '');
		outPut = outPut.replace(/@@/g, '@');
		var strs = outPut.split('@');
		if(strs.length%2!=1){
			errorMsg=errorMsg.concat(curFormula+'���ʽ����ȷ!\n');
			return '';
		}
		strs = getValue(strs,frm);			//��ҳ���ȡֵ

		var result = loopCalculate(strs);//ѭ������

		return result;
	}
}

//��ҳ���ȡֵ
function getValue(strs,frm) {
	for ( var i = 0; i < strs.length; i++) {
		var ch = strs[i];
		if (ch != '+' && ch != '-' && ch != '*' && ch != '/' && !/\d/.test(ch)
				&& ch != '@'&&ch!='') {
			var text =0;
			ch=func_uior_trim(ch);
			if(ch.charAt(0)!='$'){
				var obj = frm.elements[ch];
				text = obj.value;
				var type=obj.getAttribute('datatype');
				if(type==12){
					text=text.replace(/,/g,'');
				}else if(type==6){
					text=text.replace(/-/g,'');
				}
			}else{
				text = document.getElementById("sysDate").value;
			}
			var num = parseFloat(text);
			if (isNaN(num)) {
			strs[i] = text;
			}else{
			strs[i] = num;
			}
		}
	}
	return strs;
}
//����׺���ʽת���ɺ�׺���ʽ
function doTrans(formula) {
	var str = "";
	for ( var i = 0; i < formula.length; i++) {
		var ch = formula.charAt(i);
		switch (ch) {
		case '+':
		case '-':
			str = str.concat('@');
			str = str.concat(gotOper(ch, 1));
			break;
		case '*':
		case '/':
			str = str.concat('@');
			str = str.concat(gotOper(ch, 2));
			break;
		case '(':
			stack.push(ch);
			break;
		case ')':
			str = str.concat(gotParen(stack));
			break;
		default:
			str = str.concat(ch);
		}
		if (i == formula.length - 1)
			str = str.concat('@');
	}

	while (!stack.isEmpty()) {
		str = str.concat(stack.pop() + '@');
	}

	return str;
}

//��ͨ��������
function gotOper(str, prec) {
	var outPut = "";
	if (stack.isEmpty()) {
		stack.push(str);
		return outPut;
	}
	while (!stack.isEmpty()) {
		var top = stack.peek();
		if (top == '(') {
			stack.push(str);
			break;
		} else {
			var precTop;
			if (top == '+' || top == '-') {
				precTop = 1;
			} else {
				precTop = 2;
			}
			if (precTop < prec) {
				stack.push(str);
				break;
			} else {
				outPut = outPut.concat(stack.pop() + '@');
				stack.push(str);
				break;
			}
		}
	}

	return outPut;
}

//���(����
function gotParen(sta) {
	var outPut = "";
	while (!sta.isEmpty()) {
		var ch = sta.pop();
		if (ch == '(') {
			break;
		} else {
			outPut = outPut.concat('@' + ch);
		}
	}

	return outPut;
}

//ѭ������
function loopCalculate(strs) {
	var length = strs.length;
	while (true) {
		while (length >= 2) {
			for ( var i = 0; i < strs.length; i++) {
				if (strs[i] == '+' || strs[i] == '-' || strs[i] == '*'
						|| strs[i] == '/' || strs[i] == '|' || strs[i] == '&') {
					strs[i - 2] = doCalculate(strs[i - 2], strs[i - 1], strs[i]
							.toString());
					for ( var j = i; j < strs.length - 1; j++) {
						strs[j - 1] = strs[j + 1];
					}
					break;
				}
			}
			length -= 2;
		}
		break;
	}
	return strs[0];
}

//�����߼�����
function logic(str) {
	var reg = /\||\&/;
	if (reg.test(str)) {
		var logOut = "";
		var logStack = new Stack();
		for ( var i = 0; i < str.length; i++) {
			var ch = str.charAt(i);
			switch (ch) {
			case '(':
				logStack.push(ch);
				break;
			case ')':
				logOut = logOut.concat(gotParen(logStack) + '@');
				break;
			case '|':
			case '&':
				logStack.push(ch);
				break;
			default:
				logOut = logOut.concat(ch + '@');
			}

			if (i == str.length - 1)
				logOut = logOut.concat('@');
		}
		while (!logStack.isEmpty()) {
			logOut = logOut.concat(logStack.pop());
		}
		logOut = logOut.replace(/@@/g, '@');
		var strs = logOut.split('@');
		if(strs.length%2!=1){
			errorMsg=errorMsg.concat(curFormula+'���ʽ����ȷ!\n');
			return ;
		}
		var result = loopCalculate(strs)+'@';
	} else {
		result = str;
	}
	
	return result;
}

//����
function doCalculate(left, right, op) {
	left = parseFloat(left);
	right = parseFloat(right);
	if(isNaN(left)||isNaN(right)){
		return ;
	}
	if (op == '+') {
		var r1,r2,m; 
		try{r1=left.toString().split(".")[1].length}catch(e){r1=0} 
		try{r2=right.toString().split(".")[1].length}catch(e){r2=0} 
		m=Math.pow(10,Math.max(r1,r2)) 
		return (left*m+right*m)/m ;
	}
	if (op == '-') {
		var r1,r2,m,n; 
		try{r1=left.toString().split(".")[1].length}catch(e){r1=0} 
		try{r2=right.toString().split(".")[1].length}catch(e){r2=0} 
		m=Math.pow(10,Math.max(r1,r2)); 
		//��̬���ƾ��ȳ��� 
		n=(r1>=r2)?r1:r2; 
		return ((left*m-right*m)/m).toFixed(n); 
	}
	if (op == '*') {
		var m=0,s1=left.toString(),s2=right.toString(); 
		try{m+=s1.split(".")[1].length}catch(e){} ;
		try{m+=s2.split(".")[1].length}catch(e){} ;
		return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m) ;
	}
	if (op == '/') {
		var t1=0,t2=0,r1,r2; 
		try{t1=left.toString().split(".")[1].length}catch(e){} 
		try{t2=right.toString().split(".")[1].length}catch(e){} 
		r1=Number(left.toString().replace(".","")) ;
		r2=Number(right.toString().replace(".","")) ;
		return (r1/r2)*Math.pow(10,t2-t1); 
	}
	if (op == '>') {
		if (left > right) {
			return 1;
		}
		return 0;
	}
	if (op == '<') {
		if (left < right) {
			return 1;
		}
		return 0;
	}
	if (op == '>=') {
		if (left >= right) {
			return 1;
		}
		return 0;
	}
	if (op == '<=') {
		if (left <= right) {
			return 1;
		}
		return 0;
	}
	if (op == '!=') {
		if (left != right) {
			return 1;
		}
		return 0;

	}
	if (op == '==') {
		if (left == right) {
			return 1;
		}
		return 0;
	}
	if (op == '|') {
		return left | right;
	}
	if (op == '&') {
		return left & right;
	}
	if (op == '=') {
		if (left == right) {
			return 1;
		}
		return 0;
	}
}

//�Զ���ջ,������Ų�����
function Stack() {
	this.stack = new Array();
	this.push = function(value) {
		var length = this.stack.length;
		this.stack[length] = value;
	}, this.pop = function() {
		return this.stack.pop();
	}, this.peek = function() {
		return this.stack[this.stack.length - 1];
	}
	this.isEmpty = function() {
		var length = this.stack.length;
		if (length == 0) {
			return true;
		} else {
			return false;
		}
	}
}



//��֤������
function func_uior_valForm(frm){
	var msg='';
	for(var i=0;i<frm.length;i++){
		var obj=frm.elements[i];
		var value=obj.value;
		var mustInput=obj.getAttribute('mustinput');
		if(mustInput=='1'){
			$(obj.parentNode).prev("td").css({"color":"black","font-weight":"normal"});
			if(value=='undefined'||func_uior_trim(value)==''){
				var name=obj.getAttribute('title');
				msg=msg.concat('�ύ�ı�������Ϊ��'+name+'����Ԫ��δ��ֵ!\n<br/>');
				if(obj!=null && obj.tagName!=null && (obj.tagName=="textarea"||obj.tagName=="TEXTAREA")){
					$(obj).parent("div").parent("td").prev("td").css({"color":"red","font-weight":"bolder"});
				}else {
					$(obj.parentNode).prev("td").css({"color":"red","font-weight":"bolder"});
				}
			}else{
			msg=msg.concat(func_uior_valStringType(obj));
			}
		}
		msg=msg.concat(func_uior_valLength(obj));
	}
	
	
	return msg;
}

function func_uior_isNum(obj){
	var str=obj.value;
	var msg='';
	var reuslt=isNaN(parseFloat(str));
	if(!result){
		msg=obj.getAttribute('title')+'�е����ݲ�������\n';
		obj.value="0";
	}
	
	return msg;
}

function func_uior_valStringType(obj){
	var str=obj.value;
	var type=obj.getAttribute('datatype');
	var msg='';
	if(type!='undefined'&&func_uior_trim(type)!=''){	
		if(type==1){
		var reg=/^-?[1-9]\d*|0$/;
			if(!reg.test(str)){
			msg=obj.getAttribute('title')+'�е����ݲ�������!\n';
		obj.value="0";
			}	
		}else if(type==2){
			var reg=/^-?[1-9]\d*|0$/;
			if(!reg.test(str)){
			msg=obj.getAttribute('title')+'�е����ݲ��ǳ�����!\n';
		obj.value="0";
			}	
		}else if(type==3 ||type==8 || type==9 ||type==13||type==14||type==15||type==16||type==17||type==18||type==19){
			var reg=/^-?([1-9]\d*|[1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0)$/;
			if(!reg.test(str)){
				msg=obj.getAttribute('title')+'�е����ݲ�������!\n'
		obj.value="0";
			}
		}else if(type==4){
			var reg=/^[1-9]\d*|[1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0$/;
			if(!reg.test(str)){
				msg=obj.getAttribute('title')+'�е����ݲ�������(����)!\n';
		obj.value="0";
			}
		}else if(type==5){
			if(str!='true'&&str!='false'){
				msg=obj.getAttribute('title')+'�е����ݲ��ǲ���ֵ!\n';
			}
		}else if(type==6){
			if(str.length==10 || str.length==8){
   			 	var yy=0,mm=0,dd=0;
        		if(str.length==8){
        			yy = parseInt(str.substring(0,4), 10);
	        		mm = parseInt(str.substring(4,6), 10);
	        		dd = parseInt(str.substring(6,8), 10);
        		}else {
        			yy = parseInt(str.substring(0,4), 10);
	        		mm = parseInt(str.substring(5,7), 10);
	        		dd = parseInt(str.substring(8,10), 10);
        		}
        		if(mm > 12 || mm <= 0 || dd <= 0 || dd > 31) 
        			return obj.getAttribute('title')+'�е����ݲ�������!\n';
       		 	var rndd = ((yy%4==0)&&(yy%100!=0)||(yy%400 == 0))?29:28;
        		switch(mm){	
         			 case 4:
          			case 6:
          			case 9:
          			case 11:
            		if(dd > 30 || dd<=0)
              			msg=obj.getAttribute('title')+'�е����ݲ�������!\n';
            			break;
          			case 1:
          			case 3:
          			case 5:
          			case 7:
          			case 8:
          			case 10:
          			case 12:
            		if(dd>31 || dd<=0)
                		msg=obj.getAttribute('title')+'�е����ݲ�������!\n';
            		break;
          			case 2:
            			if(dd > rndd || dd <= 0)
                		msg=obj.getAttribute('title')+'�е����ݲ�������!\n';
            		break;
       				}
				}else{
   					msg=obj.getAttribute('title')+'�е����ݲ�������!\n';
   				}
		}else if(type==12){
//			������� 0.00;1.00;1,000.00;1,000;1
			var reg=/^([+-]?)((\d{1,3}(,\d{3})*)|(\d+))(\.\d*)?$/;
			if(!reg.test(str)){
				if(str==""){
					obj.value="0.00";
				}else{
					msg=obj.getAttribute('title')+'�е����ݲ��ǽ������!\n';
					obj.value="0.00";
				}
			}
		}
	}	
	return msg;
}

function func_uior_valLength(obj){
	var type=obj.getAttribute('datatype');
	if((type!=0 && type!="0") || (obj.getAttribute("type")!="TEXT" && obj.getAttribute("type")!="text")){
		return '';
	}
	var str=obj.value;
	var msg='';
	var maxLengthStr=$(obj).attr('maxLength');
	if(maxLengthStr=="null" || maxLengthStr==null || maxLengthStr=='undefined' || !isNaN(maxLengthStr)){
		maxLengthStr = $(obj).attr('maxlength');
	}
	var reg=/^[1-9]*|0$/;
	if(maxLengthStr && maxLengthStr!='undefined' && reg.test(maxLengthStr)){
		var maxLength =parseInt(maxLengthStr, 10);
		//var reg=/[^\x00-\xff]/g;
		//str=str.replace(reg,'a');
		str = str.replace(/[\u4e00-\u9fa5]/g,'mm');//�������ַ�����ת��
		str = str.replace(/[^\x00-\xff]/g,'qq');//��ȫ���ַ�����ת��
		if(str.length>maxLength){
			msg=obj.getAttribute('title')+'�е����ݳ��ȴ���'+maxLength+'!\n';
		}
	}
	
	return msg;
}

//�����������*��
//function func_uior_addMust(name){
//	var objs=document.getElementsByName(name);
//	var obj=objs[0];
//	var text=obj.innerHTML;
//	var add='<font color="red">*</font>';
//	obj.innerHTML=text+add;
//}

//ȥ����β�ո�
function func_uior_trim(str){
	var result='';
	if(str!=null){
	result=str.replace(/^\s|\s$/g,'');
	}
	return result;
}

//����ʱʱ��֤��������
function func_uior_valTypeImm(obj){
	var str=obj.value;
	var type=obj.getAttribute('datatype');
	var msg='';
	if(str!=undefined){
	if(type!='undefined'&&func_uior_trim(type)!=''){	
		if(type==1){
			if(str==""){
				obj.value="0";
			} else {
				//var reg=/^-?[1-9]\d*|0$/;
				var reg=/^-?[0-9]*$/;//��д���������ַ�Ϊ0
				if(!reg.test(str)){
					msg=obj.getAttribute('title')+'�е����ݲ�������!\n';
					obj.value="0";
				}	
			}
		}else if(type==2){
			if(str==""){
				obj.value="0";
			} else {
				var reg=/^-?[1-9]\d*|0$/;
				if(!reg.test(str)){
				msg=obj.getAttribute('title')+'�е����ݲ��ǳ�����!\n';
				obj.value="0";
				}	
			}
		}else if(type==3 ||type==8 || type==9 ||type==13||type==14||type==15||type==16||type==17||type==18||type==19){
			if(str==""){
				obj.value="0.00";
			} else {
				var reg=/^-?([1-9]\d*|[1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0)$/;
				if(!reg.test(str)){
					msg=obj.getAttribute('title')+'�е����ݲ�������!\n';
					obj.value="0";
				}
			}
		}else if(type==4){
			if(str==""){
				obj.value="0.00";
			} else {
				var reg=/^[1-9]\d*|[1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0$/;
				if(!reg.test(str)){
					msg=obj.getAttribute('title')+'�е����ݲ�������(����)!\n';
					obj.value="0";
				}
			}
		}else if(type==5){
			if(str==""){
				obj.value="";
			} else {
				if(str!='true'&&str!='false'){
					msg=obj.getAttribute('title')+'�е����ݲ��ǲ���ֵ!\n';
				}
			}
		}else if(type==6){
//		if(str.length==10){
//   			 	var yy = parseInt(str.substring(0,4));
//        		var mm = parseInt(str.substring(5,7));
//        		var dd = parseInt(str.substring(8,10));
//        		if(mm > 12 || mm <= 0 || dd <= 0 || dd > 31) 
//        			return obj.getAttribute('title')+'�е����ݲ�������!\n';
//       		 	var rndd = ((yy%4==0)&&(yy%100!=0)||(yy%400 == 0))?29:28;
//        		switch(mm){	
//         			 case 4:
//          			case 6:
//          			case 9:
//          			case 11:
//            		if(dd > 30 || dd<=0)
//              			msg=obj.getAttribute('title')+'�е����ݲ�������!\n'
//            			break;
//          			case 1:
//          			case 3:
//          			case 5:
//          			case 7:
//          			case 8:
//          			case 10:
//          			case 12:
//            		if(dd>31 || dd<=0)
//                		msg=obj.getAttribute('title')+'�е����ݲ�������!\n'
//            		break;
//          			case 2:
//            			if(dd > rndd || dd <= 0)
//                		msg=obj.getAttribute('title')+'�е����ݲ�������!\n'
//            		break;
//       				}
//				}else{
//   				msg=obj.getAttribute('title')+'�е����ݲ�������!\n'
//   				}
		}else if(type==12){
			var reg=/^([+-]?)((\d{1,3}(,\d{3})*)|(\d+))(\.\d*)?$/;
			if(!reg.test(str)){
				if(str==""){
					obj.value="0.00";
				}else{
					msg = obj.getAttribute('title')+'�е����ݲ��ǽ������!\n';
					obj.value="0.00";
				}
			} else {
				//Ϊ����������ĩβ���.00
				var strPoints = str.split("\.").length;	//�ж��ַ�����������С�������
				if (strPoints==2){
					var endStr = str.substring(str.length-3,str.length);
					var endStr12 = str.substring(str.length-2,str.length);
					if(endStr12==".0") {
						obj.value = str+"0";
					}
				} else if(strPoints==1){
					obj.value = str+".00";
				} else {
					msg = obj.getAttribute('title')+'�е����ݲ��ǽ������!\n';
					obj.value="0.00";
				}
			}
		}
	}	
	}
	
	msg=msg.concat(func_uior_valLength(obj));
	if(msg!=""){
		obj.value='';
		sAlert(msg);
	}
	if(obj.value!=''&&obj.getAttribute('datatype')!='undifined')
	{
		if(obj.tagName=='SELECT'){
			$(obj.parentNode).prev().css({"color":"black","font-weight":"normal"});
		}else if(obj.tagName=='TEXTAREA' || obj.tagName=='SELECT'){
			$(obj.parentNode.parentNode).prev("td").css({"color":"black","font-weight":"normal"});
		}else{
			$(obj.parentNode).prev("td").css({"color":"black","font-weight":"normal"});
		}
	}
}