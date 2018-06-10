var stack = new Stack(); //���ڰ���׺ʽת���ɺ�׺ʽ
var errorMsg = ''; //��¼������Ϣ
var curFormula; //��¼��ǰ�����Ĺ�ʽ
/*
 * ��ʵʱ��֤���������㹫ʽ
 */
function onCalculation(formulas) {
	if (formulas != null && formulas != '') {
		var allResult = 0;
		var funcs = formulas.split(';');
		for ( var i = 0; i < funcs.length; i++) {
			var formula = funcs[i];
			if (formula != null && formula != undefined && formula != '') {
				curFormula = formula;
				var result = func_xcqi_cal(formula);
				//����ֵ�Ƿ�Ϊtrue
				if (!result) {
					allResult = 1;
					//break;
					errorMsg = errorMsg + '\n' + curFormula;
				}
			}
		}
	}
}


//���������
function func_xcqi_cal(formula) {
	formula = xcqi_parseFormula(formula); //�Թ�ʽ���и�ʽ��
	formula = xcqi_transFormula(formula); //�Թ�ʽ����ת��
	var result = xcqi_logic(formula); //�Թ�ʽ�����߼�������������,�����߼�����
	if (result == '') {
		return '';
	}
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
function xcqi_parseFormula(formula) {

	formula = formula.replace(/{/g, '('); //�����е�{}�滻��()
	formula = formula.replace(/}/g, ')');
	formula = formula.replace(/\[/g, '('); //�����е�[]�滻��()
	formula = formula.replace(/\]/g, ')');
	formula = formula.replace(/\&\&/g, '&'); //�����е�&&�滻��&
	formula = formula.replace(/\|\|/g, '|'); //�����е�||�滻��|

	return formula;
}

//�Թ�ʽ����ת��
function xcqi_transFormula(formula) {
	//����ʽ����|��&�ֳ�����
	var strs = formula.split(/\||\&/);
	for ( var i = 0; i < strs.length; i++) {
		var str = strs[i];
		str = xcqi_parseParen(str); //����ֳ���������Ų�ƥ�������
		//����ʽ����>= <= != == > <�ֳ�����,>=Ҫ��>֮ǰ,������1>=2�ֳ� 1,=2
		var eles = str.split(/=/);
		if (eles[0] == undefined || eles[1] == undefined) {
			sAlert('��ʽ' + formula + '���ò���ȷ!');
		}
		var eleLeft = eles[1];
		var resultLeft = xcqi_infixTrans(eleLeft);
		if (typeof resultLeft!="number" && resultLeft == '') {
			return '';
		}
		if (resultLeft != undefined) {
			var obj = document.all(eles[0]);
			if(obj !=undefined){
			var type = obj.getAttribute('datatype');
			}
			//�Խ���ͽ��д���
			if (type == 12) {
				//10000.000
				if (/\./g.test(resultLeft)) {
					resultLeft = resultLeft + '';
					var values = resultLeft.split('.');
					var value = values[0];
					var parValue = '#.' + values[1];
				} else {
					var value = resultLeft;
					var parValue = '#';
				}
				value = value + '';
				if (value.length > 3) {
					for ( var j = value.length - 1; j >= 0; j--) {
						if ((value.length - j) % 3 == 0) {
							//							sAlert(value.substring(j, j+3));
							parValue = parValue.replace('#', '#,' + value
									.substring(j, j + 3));
						}
					}
					if (parValue.substring(0, 2) == '#,') {
						parValue = parValue.substring(2, parValue.length);
					}
					if (value.length % 3 != 0) {
						parValue = value.substring(0, value.length % 3) + ','
								+ parValue;
					}
				} else {
					parValue = value + parValue;
					parValue = parValue.replace(/#/g, '');
				}
				resultLeft = format(resultLeft,'##.00');
			} else if(type==3){
				resultLeft = format(resultLeft,'##.00');
			} else if(type==8){
				resultLeft = format(resultLeft,'##.0000');
			} else if(type==9||type==17||type==18||type==19){
				resultLeft = format(resultLeft,'##.000000');
			} else if(type==1||type==2||type==4){
				resultLeft = format(resultLeft,'##');
			} else if(type==13||type==14||type==15||type==16){
				resultLeft = format(resultLeft,'##.00');
			} 
			if(obj !=undefined){
			obj.value = resultLeft;
			}
		}
	}
	return resultLeft;
}

//������Ų�ƥ�������
function xcqi_parseParen(str) {
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
function xcqi_infixTrans(formula) {
	var first = formula.charAt(0);
	var reg = /\d*\(*\+*-*/;	//����ĸ������,(,+,-
	if (!reg.test(first)) {
		errorMsg=errorMsg.concat(curFormula+'��ʽ��������!\n');
	}
	var outPut = xcqi_doTrans(formula);	//�Թ�ʽ����ת��
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
		strs = xcqi_getValue(strs);			//��ҳ���ȡֵ
		if(strs){
		var result = xcqi_loopCalculate(strs);//ѭ������
		}else {
			return '';
		}
		return result;
	}
}

//��ҳ���ȡֵ
function xcqi_getValue(strs) {
	for ( var i = 0; i < strs.length; i++) {
		var ch = strs[i];
		if (ch != '+' && ch != '-' && ch != '*' && ch != '/' && !/\d/.test(ch)
				&& ch != '@'&&ch!='') {
			var text =0;
			ch=func_xcqi_trim(ch);
			if(ch.charAt(0)!='$'){
				var obj = document.all(ch);
				text = obj.value;
				if(text==undefined||text==null||text==''){
					return false;
				}
				var type=obj.getAttribute('datatype');
				if(type==12){
					text=text.replace(/,/g,'');
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
function xcqi_doTrans(formula) {
	var str = "";
	for ( var i = 0; i < formula.length; i++) {
		var ch = formula.charAt(i);
		switch (ch) {
		case '+':
		case '-':
			str = str.concat('@');
			str = str.concat(xcqi_gotOper(ch, 1));
			break;
		case '*':
		case '/':
			str = str.concat('@');
			str = str.concat(xcqi_gotOper(ch, 2));
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
function xcqi_gotOper(str, prec) {
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
function xcqi_gotParen(sta) {
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
function xcqi_loopCalculate(strs) {
	var length = strs.length;
	while (true) {
		while (length >= 2) {
			for ( var i = 0; i < strs.length; i++) {
				if (strs[i] == '+' || strs[i] == '-' || strs[i] == '*'
						|| strs[i] == '/' || strs[i] == '|' || strs[i] == '&') {
					strs[i - 2] = xcqi_doCalculate(strs[i - 2], strs[i - 1], strs[i]
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
function xcqi_logic(str) {
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
		var result = xcqi_loopCalculate(strs)+'@';
	} else {
		result = str;
	}
	
	return result;
}

//����
function xcqi_doCalculate(left, right, op) {
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

//ȥ����β�ո�
function func_xcqi_trim(str){
	var result='';
	if(str!=null){
	result=str.replace(/^\s|\s$/g,'');
	}
	return result;
}


//��ʽ������  pattern Ϊ 0000.00 ��##.00
function format(number,pattern){
  var str            = number.toString();
  var strInt;
  var strFloat;
  var formatInt;
  var formatFloat;
  if(/\./g.test(pattern)){
      formatInt        = pattern.split('.')[0];
      formatFloat        = pattern.split('.')[1];
  }else{
      formatInt        = pattern;
      formatFloat        = null;
  }
  if(/\./g.test(str)){
      if(formatFloat!=null){
          var tempFloat    = Math.round(parseFloat('0.'+str.split('.')[1])*Math.pow(10,formatFloat.length))/Math.pow(10,formatFloat.length);
          strInt        = (Math.floor(number)+Math.floor(tempFloat)).toString();                
          strFloat    = /\./g.test(tempFloat.toString())?tempFloat.toString().split('.')[1]:'0';            
      }else{
          strInt        = Math.round(number).toString();
          strFloat    = '0';
      }
  }else{
      strInt        = str;
      strFloat    = '0';
  }
  if(formatInt!=null){
      var outputInt    = '';
      var zero        = formatInt.match(/0*$/)[0].length;
      var comma        = null;
      if(/,/g.test(formatInt)){
          comma        = formatInt.match(/,[^,]*/)[0].length-1;
      }
      var newReg        = new RegExp('(\\d{'+comma+'})','g');

      if(strInt.length<zero){
          outputInt        = new Array(zero+1).join('0')+strInt;
          outputInt        = outputInt.substr(outputInt.length-zero,zero)
      }else{
          outputInt        = strInt;
      }

      var 
      outputInt            = outputInt.substr(0,outputInt.length%comma)+outputInt.substring(outputInt.length%comma).replace(newReg,(comma!=null?',':'')+'$1')
      outputInt            = outputInt.replace(/^,/,'');

      strInt    = outputInt;
  }

  if(formatFloat!=null){
      var outputFloat    = '';
      var zero        = formatFloat.match(/^0*/)[0].length;

      if(strFloat.length<zero){
          outputFloat        = strFloat+new Array(zero+1).join('0');
          //outputFloat        = outputFloat.substring(0,formatFloat.length);
          var outputFloat1    = outputFloat.substring(0,zero);
          var outputFloat2    = outputFloat.substring(zero,formatFloat.length);
          outputFloat        = outputFloat1+outputFloat2.replace(/0*$/,'');
      }else{
          outputFloat        = strFloat.substring(0,formatFloat.length);
      }

      strFloat    = outputFloat;
  }else{
      if(pattern!='' || (pattern=='' && strFloat=='0')){
          strFloat    = '';
      }
  }

  return strInt+(strFloat==''?'':'.'+strFloat);
}