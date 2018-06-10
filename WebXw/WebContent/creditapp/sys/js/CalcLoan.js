//���������
	    
	    /// ��������PayWay�����ʽ�����㻹���
	    /// <param name="PlayList">�����</param>
		function GetPlayList(oDocument)
		{
			
		var LastSum=oDocument.getElementById("edLastSum").value;
		var BeginYear=0;
		var LoanTimes=parseInt(oDocument.getElementById("edTimes").value);
		var Rate=parseFloat(oDocument.getElementById("edRate").value)/100*1.2;
		var PayWay=oDocument.getElementById("ddlPayWay").value;
		if (oDocument.getElementById("rbPayFreq_0").checked) PayFreq=1;
		else{
			if (oDocument.getElementById("rbPayFreq_1").checked)
				PayFreq=3;
			else
				PayFreq=1;
		}
		
		var result=0;
		var LoanTimesTemp=0;
		LoanTimesTemp=LoanTimes/PayFreq;
		PlayList=new Array();
		var nowdate=new Date();
		var addnowdate=new Date();
		
		addnowdate.setMonth(addnowdate.getMonth()+LoanTimes);
		var s = document.getElementById("xmldso").innerHTML;
		s = s.replace(/<\?.+(?:.|[\r\n])*TA\[|\]\]>(?:.|[\r\n])*<\/root>/g,'');
		alert(s);
		var xmlDoc = new ActiveXObject("Msxml2.DOMDocument.6.0"); 
        //�b�d����
		xmlDoc.async = false; 
		xmlDoc.loadXML(s);
		alert(typeof(xmlDoc));
		switch (PayWay)
		{
			case "1"://�ȶ��
				result=CalcLoanPay(xmlDoc, LastSum,nowdate,LoanTimesTemp,Rate,PayFreq);
				break;
			case "2"://�ȱ�����
				result=ECorpus(xmlDoc, LastSum,nowdate,LoanTimesTemp,Rate,PayFreq);
				break;
			case "3"://һ���Ի�����Ϣ
				result=CalcPayOnce(xmlDoc, LastSum,nowdate,addnowdate,Rate);
				break;
		}
		//return result;
	}
		
//---------------------���ò���-----------------------------------------
/// �ȶ����ֽ�֧��������ƻ�����������  
/// <param name="oXMLDoc">�����</param>
/// <param name="LastSum">ծ�񱾽𣨴����ܶ</param>
/// <param name="BeginYear">ծ��ʼ��ݣ��������ڣ�</param>
/// <param name="times">ծ������ޣ��������ޣ��·�������</param>
/// <param name="Rate">ծ���������</param>
/// <param name="Freq">ծ��ĳ���Ƶ��</param>
function CalcLoanPay(oXMLDoc, LastSum,BeginYear,times,Rate,Freq)
{			
	var root = oXMLDoc.documentElement;
	var elem;
	var node;
	var i, m;
	var fTotalInterest = new Number(0), fTotalSum = new Number(0);
	//���xml�е�����
	m = root.childNodes.length;

	for (i=0;i<m;i++)
	{
		node = root.childNodes.item(0);
		root.removeChild(node);
	}

	i=0;
	var r,M,Inter,C,dtemp;
	r=Rate*Freq/12;
	dtemp=Math.pow((1+r),times);
	if (dtemp!=1)
		M=(LastSum*r*dtemp/(dtemp-1));
	else
		M=LastSum/times;
	for (i=0;i<times;i++) 
	{
		Inter=LastSum*r;
		C=M-Inter;
		mRecTimes=i+1;
		mRecYear=new Date(BeginYear.getYear(), BeginYear.getMonth() + 1, BeginYear.getDate());
		mRecYear.setMonth(mRecYear.getMonth()+(i*Freq));
		LastSum=LastSum-C;
		mRecCorpus=C;
		mRecRateSum=Inter;
		mRecLeavCorpus=LastSum;

		//-----�����ݵ����-----
		// �����ڴ�Times
		// ����ʱ��Year
		// �����ı���Corpus 
		// ������ ��ϢRateSum
		// ʣ��ı���LeavCorpus
		elem = oXMLDoc.createElement("Items");
		root.appendChild(elem);
		node = root.lastChild;

		elem = oXMLDoc.createElement("Times");
		node.appendChild(elem);
		node.lastChild.text = mRecTimes;
	
		elem = oXMLDoc.createElement("Year");
		node.appendChild(elem);
		node.lastChild.text = mRecYear.getYear() + "-" + (mRecYear.getMonth() + 1) + "-" + mRecYear.getDate();

		elem = oXMLDoc.createElement("RateSum");
		node.appendChild(elem);
		node.lastChild.text = (Math.round(mRecRateSum * 100) / 100).toString();
		fTotalInterest += mRecRateSum;//new Number(node.lastChild.text);
	
		elem = oXMLDoc.createElement("Corpus");
		node.appendChild(elem);
		node.lastChild.text = Math.round(mRecCorpus * 100) / 100;
		fTotalSum += mRecCorpus;//new Number(node.lastChild.text);

		elem = oXMLDoc.createElement("CorpusRate");
		node.appendChild(elem);
		node.lastChild.text = Math.round((mRecRateSum + mRecCorpus) * 100) / 100;
	
		elem = oXMLDoc.createElement("LeavCorpus");
		node.appendChild(elem);
		node.lastChild.text = Math.abs(Math.round(mRecLeavCorpus * 100) / 100);		
	}
	elem = oXMLDoc.createElement("Items");
	root.appendChild(elem);
	node = root.lastChild;

	elem = oXMLDoc.createElement("Times");
	node.appendChild(elem);
	node.lastChild.text = "�ϼ�";
	
	elem = oXMLDoc.createElement("Year");
	node.appendChild(elem);

	elem = oXMLDoc.createElement("RateSum");
	node.appendChild(elem);
	node.lastChild.text = (Math.round(fTotalInterest * 100) / 100).toString();
	
	elem = oXMLDoc.createElement("Corpus");
	node.appendChild(elem);
	node.lastChild.text = Math.round(fTotalSum * 100) / 100;

	elem = oXMLDoc.createElement("CorpusRate");
	node.appendChild(elem);
	node.lastChild.text = Math.round((fTotalInterest + fTotalSum) * 100) / 100;
	
	elem = oXMLDoc.createElement("LeavCorpus");
	node.appendChild(elem);
	
	$("#reusltXml").html(oXMLDoc);
}
		
/// �ȱ�������ֽ�֧��������ƻ����������ɣ����𻹿�� 
/// <param name="oXMLDoc">�����</param> 
/// <param name="LastSum">ծ�񱾽𣨴����ܶ</param>
/// <param name="BeginYear">ծ��ʼ��ݣ��������ڣ�</param>
/// <param name="times">ծ������ޣ��������ޣ��·�������</param>
/// <param name="Rate">ծ���������</param>
/// <param name="Freq">ծ��ĳ���Ƶ��</param>
function ECorpus(oXMLDoc,LastSum,BeginYear,times,Rate,Freq)
{
	var r,Inter,c;
	var i=0,result=0;
	var TotalLoan=LastSum;
	
	var root = oXMLDoc.documentElement;
	var elem;
	var node;
	var i, m;
	var fTotalInterest = new Number(0), fTotalSum = new Number(0);
	//���xml�е�����
	m = root.childNodes.length;
	for (i=0;i<m;i++)
	{
		node = root.childNodes.item(0);
		root.removeChild(node);
	}
	
	r=Rate*Freq/12;
	if (times!=0)
		c=LastSum/times;
	else
		c=0;
	for (i=0;i<times;i++)
	{
		RecTimes=i+1;
		//RecYear=BeginYear;
		//RecYear.setMonth(BeginYear.getMonth()+(i*Freq));
		RecYear=new Date(BeginYear.getYear(), BeginYear.getMonth() + 1, BeginYear.getDate());
		RecYear.setMonth(RecYear.getMonth()+(i*Freq));
		Inter=LastSum*r;
		LastSum=LastSum-c;
		RecCorpus=c;
		RecRateSum=Inter;
		RecLeavCorpus=LastSum;
		
		//-----�����ݵ����-----
		// �����ڴ�Times
		// ����ʱ��Year
		// �����ı���Corpus 
		// ������ ��ϢRateSum
		// ʣ��ı���LeavCorpus					
		elem = oXMLDoc.createElement("Items");
		root.appendChild(elem);
		node = root.lastChild;

		elem = oXMLDoc.createElement("Times");
		node.appendChild(elem);
		node.lastChild.text = RecTimes;
	
		elem = oXMLDoc.createElement("Year");
		node.appendChild(elem);
		node.lastChild.text = RecYear.getYear() + "-" + (RecYear.getMonth() + 1) + "-" + RecYear.getDate();

		elem = oXMLDoc.createElement("RateSum");
		node.appendChild(elem);
		node.lastChild.text = (Math.round(RecRateSum * 100) / 100).toString();
		fTotalInterest += RecRateSum;//new Number(node.lastChild.text);
	
		elem = oXMLDoc.createElement("Corpus");
		node.appendChild(elem);
		
		node.lastChild.text = Math.round(RecCorpus * 100) / 100;
		fTotalSum += RecCorpus;//new Number(node.lastChild.text);

		elem = oXMLDoc.createElement("CorpusRate");
		node.appendChild(elem);
		node.lastChild.text = Math.round((RecRateSum + RecCorpus) * 100) / 100;
	
		elem = oXMLDoc.createElement("LeavCorpus");
		node.appendChild(elem);
		node.lastChild.text = Math.abs(Math.round(RecLeavCorpus * 100) / 100);
	}
	elem = oXMLDoc.createElement("Items");
	root.appendChild(elem);
	node = root.lastChild;

	elem = oXMLDoc.createElement("Times");
	node.appendChild(elem);
	node.lastChild.text = "�ϼ�";
	
	elem = oXMLDoc.createElement("Year");
	node.appendChild(elem);

	elem = oXMLDoc.createElement("RateSum");
	node.appendChild(elem);
	node.lastChild.text = (Math.round(fTotalInterest * 100) / 100).toString();
	
	elem = oXMLDoc.createElement("Corpus");
	node.appendChild(elem);
	node.lastChild.text = Math.round(fTotalSum * 100) / 100;

	elem = oXMLDoc.createElement("CorpusRate");
	node.appendChild(elem);
	node.lastChild.text = Math.round((fTotalInterest + fTotalSum) * 100) / 100;
	
	elem = oXMLDoc.createElement("LeavCorpus");
	node.appendChild(elem);
}
		
///һ���Ի�����Ϣ���ֽ�֧��������ƻ����������� 
/// <param name="oXMLDoc">�����</param>
/// <param name="LastSum">ծ�񱾽𣨴����ܶ</param>
/// <param name="BeginYear"> ծ��ʼ��ݣ��������ڣ�</param>
/// <param name="EndYear">ծ�������ݣ��������ڣ�</param>
/// <param name="Rate">ծ���������</param>
function CalcPayOnce(oXMLDoc,LastSum,BeginYear,EndYear,Rate)
{
	var result=0;
	var r;
	var days;
			
	var root = oXMLDoc.documentElement;
	var elem;
	var node;
	var i, m;
	//���xml�е�����
	m = root.childNodes.length;
	for (i=0;i<m;i++)
	{
		node = root.childNodes.item(0);
		root.removeChild(node);
	}
	
	r=Rate;
	days=GetDayLen(EndYear,BeginYear);//����ծ�����ޣ�������
	RecYear=EndYear;
	RecTimes =1;
	RecCorpus=new Number(LastSum);
	RecRateSum=RecCorpus*r/360*days;
	RecLeavCorpus=0;

	//-----�����ݵ����-----	
	// �����ڴ�Times
	// ����ʱ��Year
	// �����ı���Corpus 
	// ������ ��ϢRateSum
	// ʣ��ı���LeavCorpus
	
	elem = oXMLDoc.createElement("Items");
	root.appendChild(elem);
	node = root.lastChild;

	elem = oXMLDoc.createElement("Times");
	node.appendChild(elem);
	node.lastChild.text = RecTimes;
	
	elem = oXMLDoc.createElement("Year");
	node.appendChild(elem);
	node.lastChild.text = RecYear.getYear() + "-" + (RecYear.getMonth() + 1) + "-" + RecYear.getDate();

	elem = oXMLDoc.createElement("RateSum");
	node.appendChild(elem);
	node.lastChild.text = (Math.round(RecRateSum * 100) / 100).toString();

	elem = oXMLDoc.createElement("Corpus");
	node.appendChild(elem);
	node.lastChild.text = Math.round(RecCorpus * 100) / 100;

	elem = oXMLDoc.createElement("CorpusRate");
	node.appendChild(elem);
	node.lastChild.text = Math.round((RecRateSum + RecCorpus) * 100) / 100;
	
	elem = oXMLDoc.createElement("LeavCorpus");
	node.appendChild(elem);
	node.lastChild.text = Math.abs(Math.round(RecLeavCorpus * 100) / 100);
}
			
		/// ����κ��Ϣ����
		/// <param name="StartDate">ծ���������</param>
		/// <param name="StandDate">ծ��ʼ���ڻ��߱�׼���ڣ�1999��11��1�գ�</param>
		/// <returns></returns>
function GetDayLen(StartDate,StandDate)
{
//��ÿ��30����һ�£�һ��Ϊ360��
	return (StartDate.getYear()-StandDate.getYear())*360+(StartDate.getMonth()-StandDate.getMonth())*30+(StartDate.getDate()-StandDate.getDate());
}