function showtrigerType(){
			var trigerType =  $("#trigerType").val();
			if(trigerType=='1'){
				$("#interval").show();
				$("#timing").hide();
			}else if(trigerType=='2'){
				$("#interval").hide();
				$("#timing").show();
			}
		}
		function showtimingMode(){
			var timingMode = $("#timingMode").val();
			if(timingMode=='0'){//��
				$("#min").show();
				$("#hour").hide();
				$("#day").hide();
				$("#week").hide();
				$("#month").hide();
				$("#year").hide();
			}else if(timingMode=='1'){//ʱ
				$("#min").hide();
				$("#hour").show();
				$("#day").hide();
				$("#week").hide();
				$("#month").hide();
				$("#year").hide();
			}else if(timingMode=='2'){//��
				$("#min").hide();
				$("#hour").hide();
				$("#day").show();
				$("#week").hide();
				$("#month").hide();
				$("#year").hide();
			}else if(timingMode=='3'){//��
				$("#min").hide();
				$("#hour").hide();
				$("#day").hide();
				$("#week").show();
				$("#month").hide();
				$("#year").hide();
			}else if(timingMode=='4'){//��
				$("#min").hide();
				$("#hour").hide();
				$("#day").hide();
				$("#week").hide();
				$("#month").show();
				$("#year").hide();
			}else if(timingMode=='5'){//��
				$("#min").hide();
				$("#hour").hide();
				$("#day").hide();
				$("#week").hide();
				$("#month").hide();
				$("#year").show();
			}
		}
		function splitweek(obj){
			
			var arr = new Array();
			arr = obj.split(",");
			for(var i=0;i<arr.length;i++){
				if(arr[i]=='2'){
					document.getElementById("week2").checked = true;
				}
				if(arr[i]=='3'){
					document.getElementById("week3").checked = true;
				}
				if(arr[i]=='4'){
					document.getElementById("week4").checked = true;
				}
				if(arr[i]=='5'){
					document.getElementById("week5").checked = true;
				}
				if(arr[i]=='6'){
					document.getElementById("week6").checked = true;
				}
				if(arr[i]=='7'){
					document.getElementById("week7").checked = true;
				}
				if(arr[i]=='1'){
					document.getElementById("week1").checked = true;
				}
				
			}
	}
	function testJobName(){
		var jobName = document.getElementsByName("tcName")[0].value;
		var reg = /^[0-9a-zA-Z]*$/g;
		
		var bl = reg.test(jobName);
		if(!bl){
			sAlert("��������ֻ����Ӣ�Ļ���ĸ");
			document.cms_form.elements["tcName"].value = "";
			return false;
		}
	}	
	function checkNumber(obj){
		var day = obj.value;
		var reg = /[0-9]+$/g;
		if(obj.value==''){
			sAlert("����Ϊ��");
			return false;
		}
		if(!reg.test(day)){
			sAlert("ֻ��Ϊ����");
			
			return false;
		}
	}
	function checkMin(obj){
		var min = obj.value;
		if(min==''){
			sAlert("����Ϊ��");
			return false;
		}
		if(min<=0||min>60){
			sAlert('������Ϸ��������Ҳ���Ϊ0');
			return false;
		}
	}
	function checkAll(){
		var result = true;
		var tcName = $("#tcName").val();
		if(tcName==''){
			sAlert('�������Ʋ���Ϊ��');
			result = false;
		}
		
		if(!checkTime()){
			result = false;
		}
		var trigerType = $("#trigerType").val();
		if(trigerType=='1'){
			var intervalTime = document.getElementsByName("intervalTime");
			if(!checkMonth(intervalTime[1].value)){
				result = false;
			}
			if(!checkWeekDay(intervalTime[2].value)){
				result = false;
			}
			if(!checkDay(intervalTime[3].value)){
				result = false;
			}
			if(!checkHour(intervalTime[4].value)){
				result = false;
			}
			if(!checkMin(intervalTime[5].value)){
				result = false;
			}
			if(!checkSecond(intervalTime[6].value)){
				result = false;
			}
			for(var i=0;i<intervalTime.length;i++){
				
				if(intervalTime[i].value==''){
					sAlert('���ʱ�䲻��Ϊ��');
					result = false;
				}
			}
		}
		return result;
		//result = false;
	}

	function checkMonth(value) {
		if (value < 0 || value > 12) {
			alert("���ʱ�䣺�·�Ӧ����1-12֮�䡣��");	
			return false;
		}
		return true;
	}
	function checkWeekDay(value) {
		if (value < 0 || value > 7) {
			alert("���ʱ�䣺����Ӧ����1-7֮�䡣��");	
			return false;
		}
		return true;
	}
	function checkDay(value) {
		if (value < 0 || value > 30) {		
			alert("���ʱ�䣺����Ӧ����1-30֮�䡣��");		
			return false;
		}
		return true;
	}
	function checkHour(value) {
		if (value < 0 || value >= 24) {
			alert("���ʱ�䣺СʱӦ����0-24֮�䡣��");	
			return false;
		}
		return true;
	}
	function checkMin(value) {
		if (value < 0 || value >= 60) {		
			alert("���ʱ�䣺������Ӧ����00-60֮�䡣��");	
			return false;
		}
		return true;
	}
	function checkSecond(value) {
		if (value < 0 || value >= 60) {
			alert("���ʱ�䣺����Ӧ����00-60֮�䡣��");	
			return false;
		}
		return true;
	}
