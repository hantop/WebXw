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
	
/**
 * ��������ת��Ϊ���ǧ��λ��
 * @param intInput
 * @param intLength
 * @returns
 */
function commafy(intInput, intLength) {
	var strInput;
	if(intInput==null || intInput==""){
		return intInput;
	}else if(intInput=="NaN"){
		return "0";
	} else {
		//���������ת��Ϊ�ַ�����ʽ
		strInput = Math.abs(intInput).toString();
		strInput = strInput.replace(/,/g,'');
		var reg = /^[0-9]+\.{0,1}[0-9]*$/;
		if(!reg.test(strInput)){
			return intInput;
		}
	}
	
	//�����С������С��������ȡ����
	var strXS = "";
	if (strInput.indexOf(".", 0) != -1) {
		strXS = strInput.substring(strInput.split(".")[0].length,
				strInput.length);
		if (strXS.length < intLength) {
			for ( var m = strXS.length; m < intLength; m++) {
				strXS = strXS + "0";
			}
		} else {
			strXS = strXS.substr(0, 4);
		}

		strInput = strInput.split(".")[0];
	} else {
		for ( var n = 0; n < intLength; n++) {
			if (strXS == "") {
				strXS = ".0";
			} else {
				strXS = strXS + "0";
			}
		}
	}
	//��ȡ��������ĳ���
	var iLen = strInput.length;
	//�����������ĳ���С�ڵ���3����ֱ�ӷ���
	//�����ٽ��д���
	if (iLen <= 3) {
		return intInput;
	} else {
		//����ȡģ������Ϊ��ʼ�㣬ÿ3λ��ȡһ�δ������飬����ٽ���ƴ�ӷ���
		var iMod = iLen % 3;
		//ÿ3λ��ȡ����ʼ��  
		var iStart = iMod;
		//ÿ3λ��ȡ�Ĵ洢����
		var aryReturn = [];

		//ѭ������ÿ3λ��ȡһ�� �洢������
		while (iStart + 3 <= iLen) {
			aryReturn[aryReturn.length] = strInput
					.substring(iStart, iStart + 3);
			iStart = iStart + 3;
		}
		//�������е�������������
		aryReturn = aryReturn.join(",");

		//��������������Ȳ���3�ı��������
		if (iMod != 0) {
			aryReturn = strInput.substring(0, iMod) + "," + aryReturn;
		}
		//�����������
		if (intInput < 0) {
			aryReturn = "-" + aryReturn;
		}
		if (intLength > 0) {
			return aryReturn + strXS;
		} else {
			return aryReturn;
		}
	}
}