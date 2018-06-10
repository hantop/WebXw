		//��ȡ����ֵ
		function GetFundNetValue(fundID,xmlDoc)
		{			
			if(fundID == "")
			{
				alert("δѡ�������ߴ����ѡ���˻���");
				return 0;
			}			
			var xmlroot = xmlDoc.documentElement;
			if(xmlroot == null)
			{
				return 0;
			}		
			var xmlNode;
			/*for(i=0; i<xmlroot.childNodes.length;  i++)
			{
				xmlNode = xmlroot.childNodes.item(i);		
				if(xmlNode.selectSingleNode("CODE").text == fundID)
				{
					return xmlNode.selectSingleNode("NETVALUE").text;
				}
			}
			return 0;*/
			xmlNode = xmlroot.selectSingleNode("OPENFUND[CODE/text()="+fundID+"]/NETVALUE/text()");
			if(xmlNode!=null)
				return xmlNode.text
			else 
				return 0;
		}
		//��ȡ����ֵ������ 
		function GetFundValueDate(fundID,xmlDoc)
		{			
			if(fundID == "")
			{
				alert("δѡ�������ߴ����ѡ���˻���");
				return 0;
			}			
			var xmlroot = xmlDoc.documentElement;
			if(xmlroot == null)
			{
				return 0;
			}		
			var tmp,sDate;
			var xmlNode;
			/*for(i=0; i<xmlroot.childNodes.length;  i++)
			{
				xmlNode = xmlroot.childNodes.item(i);
				if(xmlNode.selectSingleNode("CODE").text == fundID)
				{
					tmp = xmlNode.selectSingleNode("MODIFYDATE").text;
				}
			}*/
			xmlNode = xmlroot.selectSingleNode("OPENFUND[CODE/text()="+fundID+"]/MODIFYDATE/text()");
			if(xmlNode!=null)
			{
					tmp = xmlNode.text
					sDate = tmp.split('-');
					return new Date(sDate[0],new Number(sDate[1])-1,sDate[2]);
			}
			else 
				return 0;
		}
		//����---(����ID) return ������
		function GetFundYield(fundID, xmlDoc)  
		{			
			if(fundID == "")
			{
				alert("δѡ�������ߴ����ѡ���˻���");
				return;
			}	
			var result=0;
			var xmlroot = xmlDoc.documentElement;
			
			//�Ƚ�fundID���ҵ���Ӧ��������
			for(i=0; i<xmlroot.childNodes.length;  i++)
			{
			   	if(xmlroot.childNodes.item(i).childNodes.item(0).text == fundID)	
				{
			   		result = xmlroot.childNodes.item(i).childNodes.item(2).text;
				}
			}
			//�ҵ��˷����ҵ��������ʣ�û���ҵ�����0
			return result;
		}
		
		//�����---(��ʽ������) return ����
		function GetRMBSaveRatio(typeID, period, xmlDoc)  
		{			
			if(typeID == "" || period == "")
			{
				alert("ȱ�ٴ�ʽ�ʹ���");
				return;
			}	
			var find = 0;
			var result=0;
			var xmlroot = xmlDoc.documentElement;
			
			//�Ƚ�TYPEID��ENDTERM���ҵ���Ӧ������
			for(i=0; i<xmlroot.childNodes.length;  i++)
			{
			   	if((xmlroot.childNodes.item(i).childNodes.item(4).text == typeID)	
			   	&& (new Number(period) <= xmlroot.childNodes.item(i).childNodes.item(3).text))
			   	//&& xmlroot.childNodes.item(i).childNodes.item(3).text < period))
				{
					if(find == 0 || new Number(find) >=xmlroot.childNodes.item(i).childNodes.item(3).text )
					{
				   		find =xmlroot.childNodes.item(i).childNodes.item(3).text;
				   		result = xmlroot.childNodes.item(i).childNodes.item(7).text;
				   	}
				}
			}
			//�ҵ��˷����ҵ������ʣ�û���ҵ�����0
			return result;//NBround(result,2) ;
			
		}
		
		//���---(��ʽ������) return ����
		function GetForeignSaveRatio(typeID, moneyID, period, xmlDoc)  
		{	
			if(moneyID == "")
			{
				alert("ȱ�ٱ���ID");
				return;
			}
			if(period == "" && typeID == "")
			{
				alert("ȱ�ٴ��� | ��ʽID");
				return;
			}
			if(typeID == "")
			{
				typeID = "0";
			}
			var result = 0;
			var xmlroot = xmlDoc.documentElement; 
			for(i=0; i<xmlroot.childNodes.length; i++)
			{		
				switch(typeID)
				{
				case "1":		//����	
					if(xmlroot.childNodes.item(i).childNodes.item(0).text == 1
					&& moneyID== xmlroot.childNodes.item(i).childNodes.item(2).text )
					{
						result = xmlroot.childNodes.item(i).childNodes.item(7).text;
					}
					break;
				case "2":		//����		
					if(xmlroot.childNodes.item(i).childNodes.item(0).text == 8
					&& xmlroot.childNodes.item(i).childNodes.item(2).text == moneyID)
					{
						result = xmlroot.childNodes.item(i).childNodes.item(7).text;
					}
					break;
				default:		//����
						if(xmlroot.childNodes.item(i).childNodes.item(0).text != 8 
						&& xmlroot.childNodes.item(i).childNodes.item(0).text != 1
						&& xmlroot.childNodes.item(i).childNodes.item(2).text == moneyID
						&& (new Number(period) > xmlroot.childNodes.item(i).childNodes.item(4).text
						&& new Number(period) <= xmlroot.childNodes.item(i).childNodes.item(5).text))
						{
							result = xmlroot.childNodes.item(i).childNodes.item(7).text;	
						}
					break;
				}
			}
			return result;		
		}
		
		//����---(��ʽ������) return ����
		function GetOtherSaveRatio(type, period, xmlDoc)  
		{			
			if(type == "" && period == "")
			{
				alert("ȱ�ٴ�����ʹ���");
				return;
			}	
			var result = 0;
			var xmlroot = xmlDoc.documentElement; 
			for(i=0; i<xmlroot.childNodes.length; i++)
			{
				if(xmlroot.childNodes.item(i).childNodes.item(1).text == type
				&& new Number(period) ==xmlroot.childNodes.item(i).childNodes.item(4).text)
				{
					result = xmlroot.childNodes.item(i).childNodes.item(5).text;
					break;	
				}
			}
			return result;			
		}
		
		//(����1������2��return ����
		function GetChangeRatio(money1, money2, xmlDoc) 
		{
			if(money1 == "" || money2 == "")
			{
				alert("ȱ�ٱ���1�ͱ���2");
				return;
			}	
			if(money1 == money2) //��ͬ����
				return 1;
				
			var result = 0;
			var xmlroot = xmlDoc.documentElement; 
			if(money1 == 1)	//����� �� ���
			{
				for(i=0; i<xmlroot.childNodes.length; i++)
				{
					if(xmlroot.childNodes.item(i).childNodes.item(0).text == money2)
					{
						result = xmlroot.childNodes.item(i).childNodes.item(2).text;	
						return NBround(result, 2);
					}
				}
			}
			else
			{
				if(money2 == 1)	// ��� �� �����
				{
					for(i=0; i<xmlroot.childNodes.length; i++)
					{
						if(xmlroot.childNodes.item(i).childNodes.item(0).text == money1)
						{
							result = xmlroot.childNodes.item(i).childNodes.item(2).text;	
							return NBround(1/result, 2);
						}
					}	
				}
				else	//��� �� ���
				{	
					var m1, m2;
					m1=m2=0;
					for(i=0; i<xmlroot.childNodes.length; i++)
					{
						if(xmlroot.childNodes.item(i).childNodes.item(0).text == money1)
						{
							m1 = xmlroot.childNodes.item(i).childNodes.item(2).text;
						}
						if(xmlroot.childNodes.item(i).childNodes.item(0).text == money2)
						{
							m2 = xmlroot.childNodes.item(i).childNodes.item(2).text;
						}
					}
					if(m1*m2 != 0)
						return NBround(m2/m1, 2);
					else
						return false;					
				}
			}
			return false;	
		}
		//ȡ�������� return ������ typeID ȡ0:��ͨ����1:��ҵ����2:���������/
		function GetLoanRatio(typeID, period, xmlDoc)  
		{			
			if(typeID == "" || period == "")
			{
				alert("ȱ�ٴ��ʽ�ʹ�������");
				return;
			}	
			var find = 0;
			var result=0;
			var xmlroot = xmlDoc.documentElement;
			var dt = new Date(1900, 1, 1);
			var StartTerm, EndTerm;
			
			//�Ƚ�TYPEID��ENDTERM���ҵ���Ӧ������
			for(i=0; i<xmlroot.childNodes.length;  i++)
			{
				StartTerm = new Number(xmlroot.childNodes.item(i).childNodes.item(1).text);
				EndTerm = new Number(xmlroot.childNodes.item(i).childNodes.item(2).text);
			   	if((xmlroot.childNodes.item(i).childNodes.item(3).text == typeID)	// TypeGroup
			   		&& (new Number(period) <= EndTerm || EndTerm == 0)
			   		&& (new Number(period) > StartTerm) ) // EndTerm
				{
					if(dt <= Date.parse(xmlroot.childNodes.item(i).childNodes.item(4).text.replace(/-/g,"/")))
					{
				   		dt = Date.parse(xmlroot.childNodes.item(i).childNodes.item(4).text.replace(/-/g,"/"));
				   		result = xmlroot.childNodes.item(i).childNodes.item(5).text;
				   	}
				}
			}
			//�ҵ��˷����ҵ������ʣ�û���ҵ�����0
			return result;//NBround(result,2) ;
		}
		//(����1������2��return ���� money1/money2ʹ�ñ�������
		function GetChangeRatioByName(money1, money2, xmlDoc) 
		{
			if(money1 == "" || money2 == "")
			{
				alert("ȱ�ٱ���1�ͱ���2");
				return;
			}	
			if(money1 == money2) //��ͬ����
				return 1;
				
			var result = 0;
			var xmlroot = xmlDoc.documentElement; 
			if(money1 == "�����")	//����� �� ���
			{
				for(i=0; i<xmlroot.childNodes.length; i++)
				{
					if(xmlroot.childNodes.item(i).childNodes.item(1).text == money2)
					{
						result = xmlroot.childNodes.item(i).childNodes.item(2).text;	
						return NBround(result, 4);
					}
				}
			}
			else
			{
				if(money2 == "�����")	// ��� �� �����
				{
					for(i=0; i<xmlroot.childNodes.length; i++)
					{
						if(xmlroot.childNodes.item(i).childNodes.item(1).text == money1)
						{
							result = xmlroot.childNodes.item(i).childNodes.item(2).text;	
							return NBround(1/result, 4);
						}
					}	
				}
				else	//��� �� ���
				{	
					var m1, m2;
					m1=m2=0;
					for(i=0; i<xmlroot.childNodes.length; i++)
					{
						if(xmlroot.childNodes.item(i).childNodes.item(1).text == money1)
						{
							m1 = xmlroot.childNodes.item(i).childNodes.item(2).text;
						}
						if(xmlroot.childNodes.item(i).childNodes.item(1).text == money2)
						{
							m2 = xmlroot.childNodes.item(i).childNodes.item(2).text;
						}
					}
					if(m1*m2 != 0)
						return NBround(m2/m1, 4);
					else
						return false;					
				}
			}
			return false;	
		}
