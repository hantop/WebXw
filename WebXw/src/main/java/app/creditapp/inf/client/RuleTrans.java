package app.creditapp.inf.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.base.SourceTemplate;
import app.creditapp.inf.client.entity.RuleFact;
import app.creditapp.inf.client.entity.RuleReturn;
import app.creditapp.ln.entity.LnApplyMid;
import app.creditapp.ln.entity.PreApply;
import app.creditapp.sys.bo.ParmRewRuleBo;
import app.creditapp.sys.bo.RulesBaseBo;
import app.creditapp.sys.entity.ParmRewRule;
import app.creditapp.sys.entity.RulesBase;
import app.oscache.Datadict;

/**
 * ���������淵�ص�JSON��תΪList
 *
 */
public class RuleTrans {
	
	private RuleReturn ruleReturn;
	private List<RuleReturn> ruleReturnList;
	
	/**
	 * �Զ�����
	 * @param ruleFact
	 * @return
	 */
	public List<RuleReturn> translationAppAuto(RuleFact ruleFact,String prdtNo){
		
//		RulesBaseBo ruleBaseBo = (RulesBaseBo) SourceTemplate.getSpringContextInstance().getBean("rulesBaseBo");
//		RulesBase rulesBase = new RulesBase();
//		rulesBase.setPrdtNo(prdtNo);
//		List<RulesBase> rulesBaseList = null;
//		rulesBaseList = ruleBaseBo.findById(rulesBase);
//		
//		Map<String, String> codeValue = new HashMap<String, String>();
//		Map<String, String> codeDesc = new HashMap<String, String>();
//		Map<String, String> codeSts = new HashMap<String, String>();
//
//		for(int i=0;i<rulesBaseList.size();i++){
//			rulesBase = rulesBaseList.get(i);
//			codeValue.put(rulesBase.getCodeName(), rulesBase.getCodeValue());
//			codeDesc.put(rulesBase.getCodeName(), rulesBase.getCodeDesc());
//			codeSts.put(rulesBase.getCodeName(), rulesBase.getCodeSts());
//		}
//		
//		String appCodeDes = "";
//		ruleReturnList = new ArrayList<RuleReturn>();
//		if("100001".equals(prdtNo)){
//		//1��У��ģ��ֵ1ʵ����֤
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName(codeValue.get("arg1"));
//		ruleReturn.setCodeDes(codeDesc.get("arg1"));
//		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getarg1()));
//		if("01".equals(codeSts.get("arg1"))){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes(codeValue.get("arg1")+"���ϴ���Ҫ��");
//		}else if("02".equals(codeSts.get("arg1"))){
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("�ܾ�����");
//		}else{
//			if("1".equals(ruleFact.getArg1())){
//				ruleReturn.setCodeRes("02");
//				ruleReturn.setCodeResDes(codeValue.get("arg1")+"���ϴ���Ҫ��");
//			}else{
//				ruleReturn.setCodeRes("03");
//				ruleReturn.setCodeResDes(codeValue.get("arg1")+"������Ҫ�󣬾ܾ�����");
//				appCodeDes = appCodeDes + codeValue.get("arg1");
//			}
//		}
//		ruleReturnList.add(ruleReturn);
//		//2��У��ģ��ֵ2����ʱ��
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName(codeValue.get("arg2"));
//		ruleReturn.setCodeDes(codeDesc.get("arg2"));
//		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getarg2()));
//		if("01".equals(codeSts.get("arg2"))){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes(codeValue.get("arg2")+"���ϴ���Ҫ��");
//		}else if("02".equals(codeSts.get("arg2"))){
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("�ܾ�����");
//		}else{
//			if("1".equals(ruleFact.getArg2())){
//				ruleReturn.setCodeRes("02");
//				ruleReturn.setCodeResDes(codeValue.get("arg1")+"���ϴ���Ҫ��");
//			}else{
//				ruleReturn.setCodeRes("03");
//				ruleReturn.setCodeResDes(codeValue.get("arg1")+"������Ҫ�󣬾ܾ�����");
//				appCodeDes = appCodeDes + codeValue.get("arg1");
//			}
//		}
//		ruleReturnList.add(ruleReturn);		
//		//3��У��ģ��ֵ3�ɷ�ϰ��
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName(codeValue.get("arg3"));
//		ruleReturn.setCodeDes(codeDesc.get("arg3"));
//		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getarg3()));
//		if("01".equals(codeSts.get("arg3"))){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes(codeValue.get("arg3")+"���ϴ���Ҫ��");
//		}else if("02".equals(codeSts.get("arg3"))){
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("�ܾ�����");
//		}else{
//			if("1".equals(ruleFact.getArg3())){
//				ruleReturn.setCodeRes("02");
//				ruleReturn.setCodeResDes(codeValue.get("arg3")+"���ϴ���Ҫ��");
//			}else{
//				ruleReturn.setCodeRes("03");
//				ruleReturn.setCodeResDes(codeValue.get("arg3")+"������Ҫ�󣬾ܾ�����");
//				appCodeDes = appCodeDes + codeValue.get("arg3");
//			}
//		}
//		ruleReturnList.add(ruleReturn);		
//		//4��У��ģ��ֵ4ͣ��ʱ��
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName(codeValue.get("arg4"));
//		ruleReturn.setCodeDes(codeDesc.get("arg4"));
//		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getarg4()));
//		if("01".equals(codeSts.get("arg4"))){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes(codeValue.get("arg4")+"���ϴ���Ҫ��");
//		}else if("02".equals(codeSts.get("arg4"))){
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("�ܾ�����");
//		}else{
//			if("1".equals(ruleFact.getArg4())){
//				ruleReturn.setCodeRes("02");
//				ruleReturn.setCodeResDes(codeValue.get("arg1")+"���ϴ���Ҫ��");
//			}else{
//				ruleReturn.setCodeRes("03");
//				ruleReturn.setCodeResDes(codeValue.get("arg1")+"������Ҫ�󣬾ܾ�����");
//				appCodeDes = appCodeDes + codeValue.get("arg1");
//			}
//		}
//		ruleReturnList.add(ruleReturn);		
//		//5��У��ģ��ֵ5�˻�״̬
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName(codeValue.get("arg5"));
//		ruleReturn.setCodeDes(codeDesc.get("arg5"));
//		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getarg5()));
//		if("01".equals(codeSts.get("arg5"))){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes(codeValue.get("arg5")+"���ϴ���Ҫ��");
//		}else if("02".equals(codeSts.get("arg5"))){
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("�ܾ�����");
//		}else{
//			if("1".equals(ruleFact.getArg5())){
//				ruleReturn.setCodeRes("02");
//				ruleReturn.setCodeResDes(codeValue.get("arg5")+"���ϴ���Ҫ��");
//			}else{
//				ruleReturn.setCodeRes("03");
//				ruleReturn.setCodeResDes(codeValue.get("arg5")+"������Ҫ�󣬾ܾ�����");
//				appCodeDes = appCodeDes + codeValue.get("arg5");
//			}
//		}
//		ruleReturnList.add(ruleReturn);		
//		//6��У��ģ��ֵ6ͨ��ʱ��
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName(codeValue.get("arg6"));
//		ruleReturn.setCodeDes(codeDesc.get("arg6"));
//		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getarg6()));
//		if("01".equals(codeSts.get("arg6"))){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes(codeValue.get("arg6")+"���ϴ���Ҫ��");
//		}else if("02".equals(codeSts.get("arg6"))){
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("�ܾ�����");
//		}else{
//			if("1".equals(ruleFact.getArg6())){
//				ruleReturn.setCodeRes("02");
//				ruleReturn.setCodeResDes(codeValue.get("arg6")+"���ϴ���Ҫ��");
//			}else{
//				ruleReturn.setCodeRes("03");
//				ruleReturn.setCodeResDes(codeValue.get("arg6")+"������Ҫ�󣬾ܾ�����");
//				appCodeDes = appCodeDes + codeValue.get("arg6");
//			}
//		}
//		ruleReturnList.add(ruleReturn);		
//		//7��У��ģ��ֵ7���д���
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName(codeValue.get("arg7"));
//		ruleReturn.setCodeDes(codeDesc.get("arg7"));
//		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getarg7()));
//		if("01".equals(codeSts.get("arg7"))){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes(codeValue.get("arg7")+"���ϴ���Ҫ��");
//		}else if("02".equals(codeSts.get("arg7"))){
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("�ܾ�����");
//		}else{
//			if("1".equals(ruleFact.getArg7())){
//				ruleReturn.setCodeRes("02");
//				ruleReturn.setCodeResDes(codeValue.get("arg7")+"���ϴ���Ҫ��");
//			}else{
//				ruleReturn.setCodeRes("03");
//				ruleReturn.setCodeResDes(codeValue.get("arg7")+"������Ҫ�󣬾ܾ�����");
//				appCodeDes = appCodeDes + codeValue.get("arg7");
//			}
//		}
//		ruleReturnList.add(ruleReturn);		
//		//8��У��ģ��ֵ8���д���
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName(codeValue.get("arg8"));
//		ruleReturn.setCodeDes(codeDesc.get("arg8"));
//		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getarg8()));
//		if("01".equals(codeSts.get("arg8"))){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes(codeValue.get("arg8")+"���ϴ���Ҫ��");
//		}else if("02".equals(codeSts.get("arg8"))){
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("�ܾ�����");
//		}else{
//			if("1".equals(ruleFact.getArg8())){
//				ruleReturn.setCodeRes("02");
//				ruleReturn.setCodeResDes(codeValue.get("arg8")+"���ϴ���Ҫ��");
//			}else{
//				ruleReturn.setCodeRes("03");
//				ruleReturn.setCodeResDes(codeValue.get("arg8")+"������Ҫ�󣬾ܾ�����");
//				appCodeDes = appCodeDes + codeValue.get("arg8");
//			}
//		}
//		ruleReturnList.add(ruleReturn);		
//		//9��У��ģ��ֵ9������
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName(codeValue.get("arg9"));
//		ruleReturn.setCodeDes(codeDesc.get("arg9"));
//		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getarg9()));
//		if("01".equals(codeSts.get("arg9"))){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes(codeValue.get("arg9")+"���ϴ���Ҫ��");
//		}else if("02".equals(codeSts.get("arg9"))){
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("�ܾ�����");
//		}else{
//			if("1".equals(ruleFact.getArg9())){
//				ruleReturn.setCodeRes("02");
//				ruleReturn.setCodeResDes(codeValue.get("arg9")+"���ϴ���Ҫ��");
//			}else{
//				ruleReturn.setCodeRes("03");
//				ruleReturn.setCodeResDes(codeValue.get("arg9")+"������Ҫ�󣬾ܾ�����");
//				appCodeDes = appCodeDes + codeValue.get("arg9");
//			}
//		}
//		ruleReturnList.add(ruleReturn);		
//		//10��У��ģ��ֵ10����ʹ����
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName(codeValue.get("arg10"));
//		ruleReturn.setCodeDes(codeDesc.get("arg10"));
//		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getarg10()));
//		if("01".equals(codeSts.get("arg10"))){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes(codeValue.get("arg10")+"���ϴ���Ҫ��");
//		}else if("02".equals(codeSts.get("arg1"))){
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("�ܾ�����");
//		}else{
//			if("1".equals(ruleFact.getArg10())){
//				ruleReturn.setCodeRes("02");
//				ruleReturn.setCodeResDes(codeValue.get("arg10")+"���ϴ���Ҫ��");
//			}else{
//				ruleReturn.setCodeRes("03");
//				ruleReturn.setCodeResDes(codeValue.get("arg10")+"������Ҫ�󣬾ܾ�����");
//				appCodeDes = appCodeDes + codeValue.get("arg10");
//			}
//		}
//		ruleReturnList.add(ruleReturn);		
//		//11��У��ģ��ֵ11��Ĭʱ��
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName(codeValue.get("arg11"));
//		ruleReturn.setCodeDes(codeDesc.get("arg11"));
//		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getarg11()));
//		if("01".equals(codeSts.get("arg11"))){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes(codeValue.get("arg11")+"���ϴ���Ҫ��");
//		}else if("02".equals(codeSts.get("arg1"))){
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("�ܾ�����");
//		}else{
//			if("1".equals(ruleFact.getArg11())){
//				ruleReturn.setCodeRes("02");
//				ruleReturn.setCodeResDes(codeValue.get("arg11")+"���ϴ���Ҫ��");
//			}else{
//				ruleReturn.setCodeRes("03");
//				ruleReturn.setCodeResDes(codeValue.get("arg11")+"������Ҫ�󣬾ܾ�����");
//				appCodeDes = appCodeDes + codeValue.get("arg11");
//			}
//		}
//		ruleReturnList.add(ruleReturn);		
//		//12��У��ģ��ֵ12�û��ʸ�
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName(codeValue.get("arg12"));
//		ruleReturn.setCodeDes(codeDesc.get("arg12"));
//		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getarg12()));
//		if("01".equals(codeSts.get("arg12"))){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes(codeValue.get("arg12")+"���ϴ���Ҫ��");
//		}else if("02".equals(codeSts.get("arg12"))){
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("�ܾ�����");
//		}else{
//			if("1".equals(ruleFact.getArg12())){
//				ruleReturn.setCodeRes("02");
//				ruleReturn.setCodeResDes(codeValue.get("arg12")+"���ϴ���Ҫ��");
//			}else{
//				ruleReturn.setCodeRes("03");
//				ruleReturn.setCodeResDes(codeValue.get("arg12")+"������Ҫ�󣬾ܾ�����");
//				appCodeDes = appCodeDes + codeValue.get("arg12");
//			}
//		}
//		ruleReturnList.add(ruleReturn);						
//		//16���������
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName("�������");
//		ruleReturn.setCodeDes("������Ŀ������Ҫ��ʱ������ͨ��");
////		ruleReturn.setCodeValue(ruleFact.getAppRes());
//		if("02".equals(ruleFact.getAppRes())){
//			ruleReturn.setCodeValue("������Ŀ������Ҫ��");
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes("�Զ�����ͨ��");
//		}else{
//			ruleReturn.setCodeValue(appCodeDes+"�Ȳ�����Ҫ��");
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("�Զ�����������ܾ�����");
//		}
//		ruleReturnList.add(ruleReturn);
////		//1������
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("age"));
////		ruleReturn.setCodeDes(codeDesc.get("age"));
////		ruleReturn.setCodeValue(ruleFact.getAge()+" ��");
////		if("01".equals(codeSts.get("age"))){
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("age")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("age"))){
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getAgeRes())){
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("age")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("age")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("age");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
////		//2���Ա�
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("sex"));
////		ruleReturn.setCodeDes(codeDesc.get("sex"));
////		ruleReturn.setCodeValue(new Datadict("SEX").getDatadictByCode(ruleFact.getSex()));
////		if("01".equals(codeSts.get("sex"))){
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("sex")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("sex"))){
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getSexRes())){
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("sex")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("sex")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("sex");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
////		//3����������
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("workYear"));
////		ruleReturn.setCodeDes(codeDesc.get("workYear"));
////		ruleReturn.setCodeValue(ruleFact.getWorkYear()+" ��");
////		if("01".equals(codeSts.get("workYear"))){
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("workYear")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("workYear"))){
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getWorkYearRes())){
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("workYear")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("workYear")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("workYear");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
////		//4������״��
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("marriage"));
////		ruleReturn.setCodeDes(codeDesc.get("marriage"));
////		ruleReturn.setCodeValue(new Datadict("MARRIAGE").getDatadictByCode(ruleFact.getMarriage()));
////		if("01".equals(codeSts.get("marriage"))){
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("marriage")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("marriage"))){
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getMarriageRes())){
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("marriage")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("marriage")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("marriage");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
////		//4���Ƿ�����Ů
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("children"));
////		ruleReturn.setCodeDes(codeDesc.get("children"));
////		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getChildren()));
////		if("01".equals(codeSts.get("children"))){
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("children")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("children"))){
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getChildrenRes())){
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("children")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("children")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("children");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
////		//5��ѧ��
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("edu"));
////		ruleReturn.setCodeDes(codeDesc.get("edu"));
////		ruleReturn.setCodeValue(new Datadict("EDU").getDatadictByCode(ruleFact.getEdu()));
////		if("01".equals(codeSts.get("edu"))){
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("edu")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("edu"))){
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getEduRes())){
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("edu")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("edu")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("edu");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
////		//6����ҵ����
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("cifType"));
////		ruleReturn.setCodeDes(codeDesc.get("cifType"));
////		ruleReturn.setCodeValue(new Datadict("CIF_TYPE").getDatadictByCode(ruleFact.getCifType()));
////		if("01".equals(codeSts.get("cifType"))){
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("cifType")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("cifType"))){
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getCifTypeRes())){
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("cifType")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("cifType")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("cifType");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
////		//7������״̬
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("ifWork"));
////		ruleReturn.setCodeDes(codeDesc.get("ifWork"));
////		ruleReturn.setCodeValue(new Datadict("WORK_STS").getDatadictByCode(ruleFact.getIfWork()));
////		if("01".equals(codeSts.get("ifWork"))){
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("ifWork")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("ifWork"))){
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getIfWorkRes())){
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("ifWork")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("ifWork")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("ifWork");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
////		//8��������
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("income"));
////		ruleReturn.setCodeDes(codeDesc.get("income"));
////		ruleReturn.setCodeValue(ruleFact.getIncome()+" Ԫ");
////		if("01".equals(codeSts.get("income"))){
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("income")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("income"))){
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getIncomeRes())){
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("income")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("income")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("income");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
////		//9����������
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("ifBendi"));
////		ruleReturn.setCodeDes(codeDesc.get("ifBendi"));
////		ruleReturn.setCodeValue(new Datadict("RULE_CIF_AREA").getDatadictByCode(ruleFact.getIfBendi()));
////		if("01".equals(codeSts.get("ifBendi"))){
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("ifBendi")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("ifBendi"))){
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getIfBendiRes())){
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("ifBendi")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("ifBendi")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("ifBendi");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
////		//10���Ƿ��г�
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("ifCar"));
////		ruleReturn.setCodeDes(codeDesc.get("ifCar"));
////		ruleReturn.setCodeValue(new Datadict("IF_CAR").getDatadictByCode(ruleFact.getIfCar()));
////		if("01".equals(codeSts.get("ifCar"))){
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("ifCar")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("ifCar"))){
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getIfCarRes())){
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("ifCar")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("ifCar")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("ifCar");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
////		//10���Ƿ��а��ҳ���
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("ifCarcred"));
////		ruleReturn.setCodeDes(codeDesc.get("ifCarcred"));
////		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getIfCarcred()));
////		if("01".equals(codeSts.get("ifCarcred"))){
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("ifCarcred")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("ifCarcred"))){
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getIfCarcredRes())){
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("ifCarcred")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("ifCarcred")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("ifCarcred");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
////		//11���Ƿ��з�
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("ifRoom"));
////		ruleReturn.setCodeDes(codeDesc.get("ifRoom"));
////			ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getIfRoom()));
////		if("01".equals(codeSts.get("ifRoom"))){
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("ifRoom")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("ifRoom"))){
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getIfRoomRes())){
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("ifRoom")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("ifRoom")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("ifRoom");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
////		//12���Ƿ��а��ҷ���
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("ifMort"));
////		ruleReturn.setCodeDes(codeDesc.get("ifMort"));
////		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getIfMort()));
////		if("01".equals(codeSts.get("ifMort"))){
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("ifMort")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("ifMort"))){
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getIfMortRes())){
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("ifMort")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("ifMort")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("ifMort");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
////		//12���Ƿ��д��ǿ�
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("ifCard"));
////		ruleReturn.setCodeDes(codeDesc.get("ifCard"));
////		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getIfCard()));
////		if("01".equals(codeSts.get("ifCard"))){
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("ifCard")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("ifCard"))){
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getIfCardRes())){
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("ifCard")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("ifCard")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("ifCard");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
////		//12�����ǿ����
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("cardAmt"));
////		ruleReturn.setCodeDes(codeDesc.get("cardAmt"));
////		ruleReturn.setCodeValue(ruleFact.getCardAmt()+" Ԫ");
////		if("01".equals(codeSts.get("cardAmt"))){
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("cardAmt")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("cardAmt"))){
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getCardAmtRes())){
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("cardAmt")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("cardAmt")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("cardAmt");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
////		//13���Ƿ������
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("ifBlack"));
////		ruleReturn.setCodeDes(codeDesc.get("ifBlack"));
////		if("01".equals(codeSts.get("ifBlack"))){
////			ruleReturn.setCodeValue("�Ǻ������û�");
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("ifBlack")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("ifBlack"))){
////			ruleReturn.setCodeValue("�������û�");
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getIfBlackRes())){
////				ruleReturn.setCodeValue("�Ǻ������û�");
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("ifBlack")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeValue("�������û�");
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("ifBlack")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("ifBlack");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
////
////		//14����ϵ�绰
////		ruleReturn = new RuleReturn();
////		ruleReturn.setCodeName(codeValue.get("ifPhone"));
////		ruleReturn.setCodeDes(codeDesc.get("ifPhone"));
////		ruleReturn.setCodeValue(ruleFact.getIfPhone());
////		if("01".equals(codeSts.get("ifPhone"))){
////			ruleReturn.setCodeRes("02");
////			ruleReturn.setCodeResDes(codeValue.get("ifPhone")+"���ϴ���Ҫ��");
////		}else if("02".equals(codeSts.get("ifPhone"))){
////			ruleReturn.setCodeRes("03");
////			ruleReturn.setCodeResDes("�ܾ�����");
////		}else{
////			if("02".equals(ruleFact.getIfPhoneRes())){
////				ruleReturn.setCodeRes("02");
////				ruleReturn.setCodeResDes(codeValue.get("ifPhone")+"���ϴ���Ҫ��");
////			}else{
////				ruleReturn.setCodeRes("03");
////				ruleReturn.setCodeResDes(codeValue.get("ifPhone")+"������Ҫ�󣬾ܾ�����");
////				appCodeDes = appCodeDes + codeValue.get("ifPhone");
////			}
////		}
////		ruleReturnList.add(ruleReturn);
//		}else{
//			
//		}
//		
//		return ruleReturnList;
		
		//11.20ע��
		RulesBaseBo ruleBaseBo = (RulesBaseBo) SourceTemplate.getSpringContextInstance().getBean("rulesBaseBo");
		RulesBase rulesBase = new RulesBase();
		rulesBase.setPrdtNo("100001");
		List<RulesBase> rulesBaseList = null;
		rulesBaseList = ruleBaseBo.findById(rulesBase);
		
		Map<String, String> codeValue = new HashMap<String, String>();
		Map<String, String> codeDesc = new HashMap<String, String>();
		Map<String, String> codeSts = new HashMap<String, String>();

		for(int i=0;i<rulesBaseList.size();i++){
			rulesBase = rulesBaseList.get(i);
			codeValue.put(rulesBase.getCodeName(), rulesBase.getCodeValue());
			codeDesc.put(rulesBase.getCodeName(), rulesBase.getCodeDesc());
			codeSts.put(rulesBase.getCodeName(), rulesBase.getCodeSts());
		}
		
		String appCodeDes = "";
		ruleReturnList = new ArrayList<RuleReturn>();
		//1������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("age"));
		ruleReturn.setCodeDes(codeDesc.get("age"));
//		ruleReturn.setCodeValue(ruleFact.getAge()+" ��");
		if("01".equals(codeSts.get("age"))){
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("age")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("age"))){
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getAgeRes())){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("age")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("age")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("age");
			}
		}
		ruleReturnList.add(ruleReturn);
		//2���Ա�
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("sex"));
		ruleReturn.setCodeDes(codeDesc.get("sex"));
		ruleReturn.setCodeValue(new Datadict("SEX").getDatadictByCode(ruleFact.getSex()));
		if("01".equals(codeSts.get("sex"))){
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("sex")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("sex"))){
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getSexRes())){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("sex")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("sex")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("sex");
			}
		}
		ruleReturnList.add(ruleReturn);
		//3����������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("workYear"));
		ruleReturn.setCodeDes(codeDesc.get("workYear"));
//		ruleReturn.setCodeValue(ruleFact.getWorkYear()+" ��");
		if("01".equals(codeSts.get("workYear"))){
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("workYear")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("workYear"))){
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getWorkYearRes())){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("workYear")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("workYear")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("workYear");
			}
		}
		ruleReturnList.add(ruleReturn);
		//4������״��
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("marriage"));
		ruleReturn.setCodeDes(codeDesc.get("marriage"));
		ruleReturn.setCodeValue(new Datadict("MARRIAGE").getDatadictByCode(ruleFact.getMarriage()));
		if("01".equals(codeSts.get("marriage"))){
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("marriage")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("marriage"))){
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getMarriageRes())){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("marriage")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("marriage")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("marriage");
			}
		}
		ruleReturnList.add(ruleReturn);
		//4���Ƿ�����Ů
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("children"));
		ruleReturn.setCodeDes(codeDesc.get("children"));
		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getChildren()));
		if("01".equals(codeSts.get("children"))){
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("children")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("children"))){
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getChildrenRes())){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("children")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("children")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("children");
			}
		}
		ruleReturnList.add(ruleReturn);
		//5��ѧ��
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("edu"));
		ruleReturn.setCodeDes(codeDesc.get("edu"));
		ruleReturn.setCodeValue(new Datadict("EDU").getDatadictByCode(ruleFact.getEdu()));
		if("01".equals(codeSts.get("edu"))){
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("edu")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("edu"))){
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getEduRes())){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("edu")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("edu")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("edu");
			}
		}
		ruleReturnList.add(ruleReturn);
		//6����ҵ����
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("cifType"));
		ruleReturn.setCodeDes(codeDesc.get("cifType"));
		ruleReturn.setCodeValue(new Datadict("CIF_TYPE").getDatadictByCode(ruleFact.getCifType()));
		if("01".equals(codeSts.get("cifType"))){
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("cifType")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("cifType"))){
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getCifTypeRes())){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("cifType")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("cifType")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("cifType");
			}
		}
		ruleReturnList.add(ruleReturn);
		//7������״̬
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("ifWork"));
		ruleReturn.setCodeDes(codeDesc.get("ifWork"));
		ruleReturn.setCodeValue(new Datadict("WORK_STS").getDatadictByCode(ruleFact.getIfWork()));
		if("01".equals(codeSts.get("ifWork"))){
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("ifWork")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("ifWork"))){
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getIfWorkRes())){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("ifWork")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("ifWork")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("ifWork");
			}
		}
		ruleReturnList.add(ruleReturn);
		//8��������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("income"));
		ruleReturn.setCodeDes(codeDesc.get("income"));
//		ruleReturn.setCodeValue(ruleFact.getIncome()+" Ԫ");
		if("01".equals(codeSts.get("income"))){
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("income")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("income"))){
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getIncomeRes())){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("income")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("income")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("income");
			}
		}
		ruleReturnList.add(ruleReturn);
		//9����������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("ifBendi"));
		ruleReturn.setCodeDes(codeDesc.get("ifBendi"));
		ruleReturn.setCodeValue(new Datadict("RULE_CIF_AREA").getDatadictByCode(ruleFact.getIfBendi()));
		if("01".equals(codeSts.get("ifBendi"))){
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("ifBendi")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("ifBendi"))){
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getIfBendiRes())){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("ifBendi")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("ifBendi")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("ifBendi");
			}
		}
		ruleReturnList.add(ruleReturn);
		//10���Ƿ��г�
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("ifCar"));
		ruleReturn.setCodeDes(codeDesc.get("ifCar"));
		ruleReturn.setCodeValue(new Datadict("IF_CAR").getDatadictByCode(ruleFact.getIfCar()));
		if("01".equals(codeSts.get("ifCar"))){
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("ifCar")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("ifCar"))){
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getIfCarRes())){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("ifCar")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("ifCar")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("ifCar");
			}
		}
		ruleReturnList.add(ruleReturn);
		//10���Ƿ��а��ҳ���
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("ifCarcred"));
		ruleReturn.setCodeDes(codeDesc.get("ifCarcred"));
		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getIfCarcred()));
		if("01".equals(codeSts.get("ifCarcred"))){
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("ifCarcred")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("ifCarcred"))){
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getIfCarcredRes())){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("ifCarcred")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("ifCarcred")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("ifCarcred");
			}
		}
		ruleReturnList.add(ruleReturn);
		//11���Ƿ��з�
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("ifRoom"));
		ruleReturn.setCodeDes(codeDesc.get("ifRoom"));
			ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getIfRoom()));
		if("01".equals(codeSts.get("ifRoom"))){
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("ifRoom")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("ifRoom"))){
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getIfRoomRes())){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("ifRoom")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("ifRoom")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("ifRoom");
			}
		}
		ruleReturnList.add(ruleReturn);
		//12���Ƿ��а��ҷ���
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("ifMort"));
		ruleReturn.setCodeDes(codeDesc.get("ifMort"));
		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getIfMort()));
		if("01".equals(codeSts.get("ifMort"))){
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("ifMort")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("ifMort"))){
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getIfMortRes())){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("ifMort")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("ifMort")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("ifMort");
			}
		}
		ruleReturnList.add(ruleReturn);
		//12���Ƿ��д��ǿ�
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("ifCard"));
		ruleReturn.setCodeDes(codeDesc.get("ifCard"));
		ruleReturn.setCodeValue(new Datadict("YES_NO").getDatadictByCode(ruleFact.getIfCard()));
		if("01".equals(codeSts.get("ifCard"))){
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("ifCard")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("ifCard"))){
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getIfCardRes())){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("ifCard")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("ifCard")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("ifCard");
			}
		}
		ruleReturnList.add(ruleReturn);
		//12�����ǿ����
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("cardAmt"));
		ruleReturn.setCodeDes(codeDesc.get("cardAmt"));
//		ruleReturn.setCodeValue(ruleFact.getCardAmt()+" Ԫ");
		if("01".equals(codeSts.get("cardAmt"))){
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("cardAmt")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("cardAmt"))){
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getCardAmtRes())){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("cardAmt")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("cardAmt")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("cardAmt");
			}
		}
		ruleReturnList.add(ruleReturn);
		//13���Ƿ������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("ifBlack"));
		ruleReturn.setCodeDes(codeDesc.get("ifBlack"));
		if("01".equals(codeSts.get("ifBlack"))){
			ruleReturn.setCodeValue("�Ǻ������û�");
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("ifBlack")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("ifBlack"))){
			ruleReturn.setCodeValue("�������û�");
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getIfBlackRes())){
				ruleReturn.setCodeValue("�Ǻ������û�");
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("ifBlack")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeValue("�������û�");
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("ifBlack")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("ifBlack");
			}
		}
		ruleReturnList.add(ruleReturn);

		//14����ϵ�绰
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName(codeValue.get("ifPhone"));
		ruleReturn.setCodeDes(codeDesc.get("ifPhone"));
		ruleReturn.setCodeValue(ruleFact.getIfPhone());
		if("01".equals(codeSts.get("ifPhone"))){
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(codeValue.get("ifPhone")+"���ϴ���Ҫ��");
		}else if("02".equals(codeSts.get("ifPhone"))){
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�ܾ�����");
		}else{
			if("02".equals(ruleFact.getIfPhoneRes())){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes(codeValue.get("ifPhone")+"���ϴ���Ҫ��");
			}else{
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes(codeValue.get("ifPhone")+"������Ҫ�󣬾ܾ�����");
				appCodeDes = appCodeDes + codeValue.get("ifPhone");
			}
		}
		ruleReturnList.add(ruleReturn);
		
		//15���������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("�������");
		ruleReturn.setCodeDes("������Ŀ������Ҫ��ʱ������ͨ��");
//		ruleReturn.setCodeValue(ruleFact.getAppRes());
		if("02".equals(ruleFact.getAppRes())){
			ruleReturn.setCodeValue("������Ŀ������Ҫ��");
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes("�Զ�����ͨ��");
		}else{
//			ruleReturn.setCodeValue(appCodeDes+"�Ȳ�����Ҫ��");
			ruleReturn.setCodeRes("03");
			ruleReturn.setCodeResDes("�Զ�����������ܾ�����");
		}
		ruleReturnList.add(ruleReturn);
//		
		return ruleReturnList;
	}
//	/**
//	 * �Զ�����
//	 * @param ruleFact
//	 * @return
//	 */
//	public List<RuleReturn> translationAppAuto(RuleFact ruleFact){
//		String appCodeDes = "";
//		ruleReturnList = new ArrayList<RuleReturn>();
//		//1������
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName("����");
//		ruleReturn.setCodeDes("�������18��������С��65");
//		ruleReturn.setCodeValue(ruleFact.getAge()+" ��");
//		if("02".equals(ruleFact.getAgeRes())){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes("������ϴ���Ҫ��");
//		}else{
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("���䲻����Ҫ�󣬾ܾ�����");
//			appCodeDes = appCodeDes + "����";
//		}
//		ruleReturnList.add(ruleReturn);
//		//2��ѧ��
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName("ѧ��");
//		ruleReturn.setCodeDes("ѧ����Ϊ��ä�����ä");
//		ruleReturn.setCodeValue(new Datadict("EDU").getDatadictByCode(ruleFact.getEdu()));
//		if("02".equals(ruleFact.getEduRes())){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes("ѧ�����ϴ���Ҫ��");
//		}else{
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("ѧ��������Ҫ�󣬾ܾ�����");
//			appCodeDes = appCodeDes + "ѧ����";
//		}
//		ruleReturnList.add(ruleReturn);
//		//3����ҵ����
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName("��ҵ����");
//		ruleReturn.setCodeDes("��ҵ���Ͳ�����Ϊũ��������");
//		ruleReturn.setCodeValue(new Datadict("CIF_TYPE").getDatadictByCode(ruleFact.getCifType()));
//		if("02".equals(ruleFact.getCifTypeRes())){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes("��ҵ���ͷ��ϴ���Ҫ��");
//		}else{
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("��ҵ���Ͳ�����Ҫ�󣬾ܾ�����");
//			appCodeDes = appCodeDes + "��ҵ���͡�";
//		}
//		ruleReturnList.add(ruleReturn);
//		//4��������
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName("������");
//		ruleReturn.setCodeDes("�����벻�õ���5000Ԫ");
//		ruleReturn.setCodeValue(ruleFact.getIncome()+" Ԫ");
//		if("02".equals(ruleFact.getIncomeRes())){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes("��������ϴ���Ҫ��");
//		}else{
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("�����벻����Ҫ�󣬾ܾ�����");
//			appCodeDes = appCodeDes + "�����롢";
//		}
//		ruleReturnList.add(ruleReturn);
//		//5����������
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName("��������");
//		ruleReturn.setCodeDes("�Ǳ��ؼ����ڲ�������");
//		ruleReturn.setCodeValue(new Datadict("RULE_CIF_AREA").getDatadictByCode(ruleFact.getIfbendi()));
//		if("02".equals(ruleFact.getIfbendiRes())){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes("�������Է��ϴ���Ҫ��");
//		}else{
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("�������Բ�����Ҫ�󣬾ܾ�����");
//			appCodeDes = appCodeDes + "�������ԡ�";
//		}
//		ruleReturnList.add(ruleReturn);
//		//6����ϵ�绰
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName("��ϵ�绰");
//		ruleReturn.setCodeDes("��ϵ�绰����Ϊ��"); 
//		ruleReturn.setCodeValue(ruleFact.getIfPhone());
//		if("02".equals(ruleFact.getIfphoneRes())){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes("��ϵ�绰���ϴ���Ҫ��");
//		}else{
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("��ϵ�绰������Ҫ�󣬾ܾ�����");
//			appCodeDes = appCodeDes + "��ϵ�绰��";
//		}
//		ruleReturnList.add(ruleReturn);
//		//7���Ƿ��г�
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName("�Ƿ��г�");
//		ruleReturn.setCodeDes("�Ƿ��г�����Ϊ��");
//		ruleReturn.setCodeValue(new Datadict("IF_CAR").getDatadictByCode(ruleFact.getIfCar()));
//		if("02".equals(ruleFact.getIfCarRes())){
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes("�г����ϴ���Ҫ��");
//		}else{
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("�Ƿ��г�����Ϊ�գ��ܾ�����");
//			appCodeDes = appCodeDes + "�Ƿ��г���";
//		}
//		ruleReturnList.add(ruleReturn);
//		//8���������
//		ruleReturn = new RuleReturn();
//		ruleReturn.setCodeName("�������");
//		ruleReturn.setCodeDes("������Ŀ������Ҫ��ʱ������ͨ��");
////		ruleReturn.setCodeValue(ruleFact.getAppRes());
//		if("02".equals(ruleFact.getAppRes())){
//			ruleReturn.setCodeValue("������Ŀ������Ҫ��");
//			ruleReturn.setCodeRes("02");
//			ruleReturn.setCodeResDes("�Զ�����ͨ��");
//		}else{
//			ruleReturn.setCodeValue(appCodeDes+"�Ȳ�����Ҫ��");
//			ruleReturn.setCodeRes("03");
//			ruleReturn.setCodeResDes("�Զ�����������ܾ�����");
//		}
//		ruleReturnList.add(ruleReturn);
//		return ruleReturnList;
//	}

	/**
	 * �ͻ�����
	 * @param ruleFact
	 * @return
	 */
	public List<RuleReturn> translationCifEval(RuleFact ruleFact){
		ruleReturnList = new ArrayList<RuleReturn>();
		//1���û���
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("�û���");
		ruleReturn.setCodeDes("�û�������Ϊ��");
		ruleReturn.setCodeValue(ruleFact.getCifName());
		ruleReturn.setCodeRes(ruleFact.getCifNameScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getCifNameScore()+" ��");
		ruleReturnList.add(ruleReturn);
		//2������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("����");
		ruleReturn.setCodeDes("����Ӧ����18��С��65��");
		ruleReturn.setCodeValue(ruleFact.getAge()+" ��");
		ruleReturn.setCodeRes(ruleFact.getAgeScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getAgeScore()+" ��");
		ruleReturnList.add(ruleReturn);
		//3���ͻ������ܷ�
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("�ͻ������ܷ�");
		ruleReturn.setCodeDes("�ͻ������ܷ�Ϊ���е÷�֮��");
		ruleReturn.setCodeValue("һ��������������");
		ruleReturn.setCodeRes((ruleFact.getCifNameScore()+ruleFact.getAgeScore())+"");
		ruleReturn.setCodeResDes("�ܵ÷�Ϊ: "+(ruleFact.getCifNameScore()+ruleFact.getAgeScore())+" ��");
		ruleReturnList.add(ruleReturn);
		return ruleReturnList;
	}
	/**
	 * ������������
	 * @param ruleFact
	 * @return
	 */
	public List<RuleReturn> translationCorpEval(RuleFact ruleFact){
		ruleReturnList = new ArrayList<RuleReturn>();
		Double score = 0.00;
		//1����ȹ����ʲ���ģ
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("��ȹ����ʲ�");
		ruleReturn.setCodeValue("��ȹ����ʲ�Ϊ: "+ruleFact.getNdgyzc()+"��Ԫ");
		ruleReturn.setCodeRes(ruleFact.getNdgyzcScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getNdgyzcScore()+" ��");
		score = score + ruleFact.getNdgyzcScore();
		ruleReturnList.add(ruleReturn);
		//2�����������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("���������");
		ruleReturn.setCodeValue("���������Ϊ: "+ruleFact.getDkdcl()+"%");
		ruleReturn.setCodeRes(ruleFact.getDkdclScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getDkdclScore()+" ��");
		score = score + ruleFact.getDkdclScore();
		ruleReturnList.add(ruleReturn);
		//3������ع���
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("����ع���");
		ruleReturn.setCodeValue("����ع���Ϊ: "+ruleFact.getDkhgl()+"%");
		ruleReturn.setCodeRes(ruleFact.getDkhglScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getDkhglScore()+" ��");
		score = score + ruleFact.getDkhglScore();
		ruleReturnList.add(ruleReturn);
		//4������������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("����������");
		ruleReturn.setCodeValue("����������Ϊ: "+ruleFact.getBldkl()+"%");
		ruleReturn.setCodeRes(ruleFact.getBldklScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getBldklScore()+" ��");
		score = score + ruleFact.getBldklScore();
		ruleReturnList.add(ruleReturn);
		//5���۷�������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("�۷�������");
		ruleReturn.setCodeValue("�۷�������Ϊ: "+ruleFact.getLfzzl()+"%");
		ruleReturn.setCodeRes(ruleFact.getLfzzlScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getLfzzlScore()+" ��");
		score = score + ruleFact.getLfzzlScore();
		ruleReturnList.add(ruleReturn);
		//6��������Ϣ��
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("������Ϣ��");
		ruleReturn.setCodeValue("������Ϣ��Ϊ: "+ruleFact.getDksxl()+"%");
		ruleReturn.setCodeRes(ruleFact.getDksxlScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getDksxlScore()+" ��");
		score = score + ruleFact.getDksxlScore();
		ruleReturnList.add(ruleReturn);
		//7����ʧ׼����
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("��ʧ׼����");
		ruleReturn.setCodeValue("��ʧ׼����Ϊ: "+ruleFact.getSszbl()+"%");
		ruleReturn.setCodeRes(ruleFact.getSszblScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getSszblScore()+" ��");
		score = score + ruleFact.getSszblScore();
		ruleReturnList.add(ruleReturn);
		//8�������ͻ���
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("�����ͻ���");
		ruleReturn.setCodeValue("�����ͻ���Ϊ: "+ruleFact.getXzkhl()+"%");
		ruleReturn.setCodeRes(ruleFact.getXzkhlScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getXzkhlScore()+" ��");
		score = score + ruleFact.getXzkhlScore();
		ruleReturnList.add(ruleReturn);
		//9�����������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("���������");
		ruleReturn.setCodeValue("���������Ϊ: "+ruleFact.getYezzl()+"%");
		ruleReturn.setCodeRes(ruleFact.getYezzlScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getYezzlScore()+" ��");
		score = score + ruleFact.getYezzlScore();
		ruleReturnList.add(ruleReturn);
		//10�������������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("�����������");
		ruleReturn.setCodeValue("�����������Ϊ: "+ruleFact.getJzdkbz()+"%");
		ruleReturn.setCodeRes(ruleFact.getJzdkbzScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getJzdkbzScore()+" ��");
		score = score + ruleFact.getJzdkbzScore();
		ruleReturnList.add(ruleReturn);
		//11���ɶ��������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("�ɶ��������");
		ruleReturn.setCodeValue("�ɶ��������Ϊ: "+ruleFact.getGddkbz()+"%");
		ruleReturn.setCodeRes(ruleFact.getGddkbzScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getGddkbzScore()+" ��");
		score = score + ruleFact.getGddkbzScore();
		ruleReturnList.add(ruleReturn);
		//12����һ�������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("��һ�������");
		ruleReturn.setCodeValue("��һ�������Ϊ: "+ruleFact.getDydkbz()+"%");
		ruleReturn.setCodeRes(ruleFact.getDydkbzScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getDydkbzScore()+" ��");
		score = score + ruleFact.getDydkbzScore();
		ruleReturnList.add(ruleReturn);
		//13��ǰʮ�������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("ǰʮ�������");
		ruleReturn.setCodeValue("ǰʮ�������Ϊ: "+ruleFact.getQsdkbz()+"%");
		ruleReturn.setCodeRes(ruleFact.getQsdkbzScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getQsdkbzScore()+" ��");
		score = score + ruleFact.getQsdkbzScore();
		ruleReturnList.add(ruleReturn);
		//14����ũ�������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("��ũ�������");
		ruleReturn.setCodeValue("��ũ�������Ϊ: "+ruleFact.getSndkbz()+"%");
		ruleReturn.setCodeRes(ruleFact.getSndkbzScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getSndkbzScore()+" ��");
		score = score + ruleFact.getSndkbzScore();
		ruleReturnList.add(ruleReturn);
		//15��С΢�������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("С΢�������");
		ruleReturn.setCodeValue("С΢�������Ϊ: "+ruleFact.getXwdkbz()+"%");
		ruleReturn.setCodeRes(ruleFact.getXwdkbzScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getXwdkbzScore()+" ��");
		score = score + ruleFact.getXwdkbzScore();
		ruleReturnList.add(ruleReturn);
		//16���������ޱ���
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("�������ޱ���");
		ruleReturn.setCodeValue("�������ޱ���Ϊ: "+ruleFact.getDkqxbz()+"%");
		ruleReturn.setCodeRes(ruleFact.getDkqxbzScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getDkqxbzScore()+" ��");
		score = score + ruleFact.getDkqxbzScore();
		ruleReturnList.add(ruleReturn);
		//17��ע���ʱ�
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("ע���ʱ�");
		ruleReturn.setCodeValue("ע���ʱ�Ϊ: "+ruleFact.getZczb()+"��Ԫ");
		ruleReturn.setCodeRes(ruleFact.getZczbScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getZczbScore()+" ��");
		score = score + ruleFact.getZczbScore();
		ruleReturnList.add(ruleReturn);
		//18����������
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("��������");
		ruleReturn.setCodeValue("��������Ϊ: "+ruleFact.getZzkg()+"%");
		ruleReturn.setCodeRes(ruleFact.getZzkgScore()+"");
		ruleReturn.setCodeResDes(ruleFact.getZzkgScore()+" ��");
		score = score + ruleFact.getZzkgScore();
		ruleReturnList.add(ruleReturn);
		//19���ܷ�
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("�����ܵ÷�");
		ruleReturn.setCodeValue("�����ܵ÷�Ϊ���е÷���֮��");
		ruleReturn.setCodeRes(score+"");
		ruleReturn.setScore(score);
		ruleReturn.setCodeResDes(score+" ��");
		ruleReturnList.add(ruleReturn);
		
		return ruleReturnList;
	}
	/**
	 * ��ʽ����ɸ��
	 * @param ruleFact
	 * @return
	 */
	public List<RuleReturn> translationLnChk(LnApplyMid lnApplyMid){
		//�����Ƿ�����ɸ��	0ͣ�� 	1����
		ParmRewRuleBo parmRewRuleBo = (ParmRewRuleBo)SourceTemplate.getSpringContextInstance().getBean("parmRewRuleBo");
		ParmRewRule parmRewRule = new ParmRewRule();
		parmRewRule.setSceneNo("02");
		List<ParmRewRule> parmRewRuleList = parmRewRuleBo.findAll(parmRewRule);
		Map<String, String> parm = new HashMap<String, String>();
		for(int i=0;i<parmRewRuleList.size();i++){
			parm.put(parmRewRuleList.get(i).getRuleId(), parmRewRuleList.get(i).getRuleSts());
		}
		
		ruleReturnList = new ArrayList<RuleReturn>();
		String chkRes = lnApplyMid.getChkRes();
		String finalChkDesc = "";
		if("1".equals(parm.get("R0010"))){
			//1���ظ�����
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("�����Ƿ��ظ�");
			ruleReturn.setCodeValue(chkRes);
			if("07".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("�ظ�������ɸ��δͨ��");
				finalChkDesc = "�����ظ�������ɸ��δͨ��";
			}else{
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("�������ظ���ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0009"))){
			//2��������
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("�Ƿ�������û�");
			ruleReturn.setCodeValue(chkRes);
			if("04".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("�������û���ɸ��δͨ��");
				finalChkDesc = "���ں������û���ɸ��δͨ��";
			}else if("07".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("�Ƿ�������û�δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("�Ǻ������û���ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0011"))){
			//3������״��
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("�ѻ��û����������ż��Ϣ");
			ruleReturn.setCodeValue(chkRes);
			if("08".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("����״��Ϊ�ѻ飬����ż��Ϣ��������ɸ��δͨ��");
				finalChkDesc = "���ڻ���״��Ϊ�ѻ飬����ż��Ϣ��������ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("����״��δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("����״������Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0012"))){
			//4������������������������Ч
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("����������������������Ч");
			ruleReturn.setCodeValue(chkRes);
			if("09".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("�������������Ч��ɸ��δͨ��");
				finalChkDesc = "���ں������������Ч��ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)||"08".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("������������δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("���������������Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
			//4��������������������˻�
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("����������������˻���Ϣ");
			ruleReturn.setCodeValue(chkRes);
			if("17".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("�����������˻���Ϣ��ɸ��δͨ��");
				finalChkDesc = "���ں����������˻���Ϣ��ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)||"08".equals(chkRes)||"09".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("���������˻���Ϣδɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("�������������˻���Ϣ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
			//4�����������������������
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("���������������������Ϣ");
			ruleReturn.setCodeValue(chkRes);
			if("18".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("����������������Ϣ��ɸ��δͨ��");
				finalChkDesc = "���ں���������������Ϣ��ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)||"08".equals(chkRes)||"09".equals(chkRes)||"17".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("��������������Ϣδɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("������������������Ϣ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0013"))){
			//5��������Ŀ��ű�����ڡ���Ч������������������Ӧ
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("������Ŀ��ű�����ڡ���Ч������������������Ӧ");
			ruleReturn.setCodeValue(chkRes);
			if("10".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("������Ŀ�����Ч�����������������Ų�����ɸ��δͨ��");
				finalChkDesc = "����������Ŀ�����Ч�����������������Ų�����ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)||"08".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("������Ŀ���δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("������Ŀ��ŷ���Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0020"))){
			//5����Ŀ�����ʽ���Ϣ
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("��Ŀ��������ʽ���Ϣ");
			ruleReturn.setCodeValue(chkRes);
			if("20".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("��Ŀ�����ʽ���Ϣ��ɸ��δͨ��");
				finalChkDesc = "��Ŀ�����ʽ���Ϣ��ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)||"08".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)||"10".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("������Ŀ���δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("������Ŀ��ŷ���Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0022"))){
			//5����Ŀ�����ʽ���Ϣ
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("��Ŀ���������뺬��Ч�����⻧��Ϣ");
			ruleReturn.setCodeValue(chkRes);
			if("21".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("����Ŀ������������Ч�����⻧��Ϣ");
				finalChkDesc = "����Ŀ������������Ч�����⻧��Ϣ";
			}else if("04".equals(chkRes)||"07".equals(chkRes)||"08".equals(chkRes)||"21".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)||"10".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("������Ŀ���δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("������Ŀ��ŷ���Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0014"))){
			//6����Ʒ�ű����������Ч
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("��Ʒ�ű����������Ч");
			ruleReturn.setCodeValue(chkRes);
			if("11".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("��Ʒ�Ų����ڣ����߲�Ʒ����Ч");
				finalChkDesc = "���ڲ�Ʒ�Ų����ڣ����߲�Ʒ����Ч��ɸ��δͨ��";
			}else if("04".equals(chkRes)||"21".equals(chkRes)||"07".equals(chkRes)||"08".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)||"10".equals(chkRes)||"20".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("��Ʒ��δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("��Ʒ�ŷ���Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0015"))){
			//7��������ʽΪ��Ѻ�����������Ч��ѺƷ��Ϣ
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("������ʽΪ��Ѻ�����������Ч��ѺƷ��Ϣ");
			ruleReturn.setCodeValue(chkRes);
			if("12".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("������ʽΪ��Ѻ�����ǲ�����ѺƷ��Ϣ");
				finalChkDesc = "���ڲ�����ѺƷ��Ϣ��ɸ��δͨ��";
			}else if("04".equals(chkRes)||"21".equals(chkRes)||"07".equals(chkRes)||"08".equals(chkRes)||"20".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)||"10".equals(chkRes)||"11".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("ѺƷ��Ϣδɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("������ʽΪ��Ѻ��ѺƷ��Ϣ����Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
			//8��������ʽΪ��Ѻ����Ѻ�����ں�ͬ���
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("������ʽΪ��Ѻ����Ѻ�����ں�ͬ���");
			ruleReturn.setCodeValue(chkRes);
			if("13".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("������ʽΪ��Ѻ�����ǵ�Ѻ���С�ں�ͬ���");
				finalChkDesc = "���ڵ�Ѻ���С�ں�ͬ��ɸ��δͨ��";
			}else if("04".equals(chkRes)||"21".equals(chkRes)||"07".equals(chkRes)||"20".equals(chkRes)||"08".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)||"10".equals(chkRes)||"11".equals(chkRes)||"12".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("��Ѻ���δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("������ʽΪ��Ѻ����Ѻ������Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0016"))){
			//9���˻���Ϣ��������
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("�˻���Ϣ��������");
			ruleReturn.setCodeValue(chkRes);
			if("14".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("�˻���Ϣ��������ɸ��δͨ��");
				finalChkDesc = "�����˻���Ϣ��������ɸ��δͨ��";
			}else if("04".equals(chkRes)||"21".equals(chkRes)||"07".equals(chkRes)||"20".equals(chkRes)||"08".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)||"10".equals(chkRes)||"11".equals(chkRes)||"12".equals(chkRes)||"13".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("�˻���Ϣδɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("�˻���Ϣ����Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
			//10���ſ����ܺ͵��ں�ͬ���
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("�ſ����ܺ͵��ں�ͬ���");
			ruleReturn.setCodeValue(chkRes);
			if("15".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("�˻��ſ����ܺͲ����ں�ͬ��ɸ��δͨ��");
				finalChkDesc = "�����˻��ſ����ܺͲ����ں�ͬ��ɸ��δͨ��";
			}else if("04".equals(chkRes)||"21".equals(chkRes)||"07".equals(chkRes)||"20".equals(chkRes)||"08".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)||"10".equals(chkRes)||"11".equals(chkRes)||"12".equals(chkRes)||"13".equals(chkRes)||"14".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("�ſ������ͬ���δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("�ſ������ͬ������Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0018"))){
			//6����Ʒ�������չҵ���������������ص�
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("��Ʒ�������չҵ���������������ص�");
			ruleReturn.setCodeValue(chkRes);
			if("19".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("��Ʒ�������չҵ����������������ص�");
				finalChkDesc = "���ڲ�Ʒ�������չҵ����������������ص㣬ɸ��δͨ��";
			}else if("04".equals(chkRes)||"21".equals(chkRes)||"07".equals(chkRes)||"20".equals(chkRes)||"08".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)||"10".equals(chkRes)||"11".equals(chkRes)||"12".equals(chkRes)||"13".equals(chkRes)||"14".equals(chkRes)||"15".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("��Ʒչҵ����δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("��Ʒ�������չҵ�������ú�����ص㣬ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		//zlc 20170904
		if("1".equals(parm.get("R0023"))){
			//6����ͬ������Ӱ����Ϣ�����ϴ�
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("��ͬ������Ӱ����Ϣ�����ϴ�");
			ruleReturn.setCodeValue(chkRes);
			if("23".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("��ͬ������Ӱ����Ϣ�����ϴ�");
				finalChkDesc = "���ں�ͬ������Ӱ����Ϣδ�ϴ���ɸ��δͨ��";
			}else if("04".equals(chkRes)||"21".equals(chkRes)||"07".equals(chkRes)||"20".equals(chkRes)||"08".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)||"10".equals(chkRes)||"11".equals(chkRes)||"12".equals(chkRes)||"13".equals(chkRes)||"14".equals(chkRes)||"15".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("��ͬ������Ӱ����Ϣδɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("��ͬ������Ӱ����Ϣ�Ѿ��ϴ���ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		//zlc 20170904
		if("1".equals(parm.get("R0024"))){
			//6�������ֶ��в�����������ȷ
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("�����ֶ��в�������������ڲ�Ʒ�����ò�������");
			ruleReturn.setCodeValue(chkRes);
			if("24".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("�����ֶ��в�������������ڲ�Ʒ�����ò�������");
				finalChkDesc = "���ڲ����ֶ��в������������ڲ�Ʒ�����ò���������ɸ��δͨ��";
			}else if("04".equals(chkRes)||"21".equals(chkRes)||"07".equals(chkRes)||"20".equals(chkRes)||"08".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)||"10".equals(chkRes)||"11".equals(chkRes)||"12".equals(chkRes)||"13".equals(chkRes)||"14".equals(chkRes)||"15".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("�����ֶ��в�������δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("�����ֶ��в����������ڲ�Ʒ�����ò���������ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		//11���ܽ��
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("���ս��");
		ruleReturn.setCodeValue(chkRes);
		if("".equals(finalChkDesc)){
			ruleReturn.setCodeRes("04");
			ruleReturn.setCodeResDes("�û���ͨ������ɸ�飬������һ���׶�");
		}else {
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(finalChkDesc);
		}
		ruleReturnList.add(ruleReturn);
		return ruleReturnList;
	}
	/**
	 * Ԥ����ɸ��
	 * @param ruleFact
	 * @return
	 */
	public List<RuleReturn> translationPreChk(PreApply preApply){
		//�����Ƿ�����ɸ��	0ͣ�� 	1����
		ParmRewRuleBo parmRewRuleBo = (ParmRewRuleBo)SourceTemplate.getSpringContextInstance().getBean("parmRewRuleBo");
		ParmRewRule parmRewRule = new ParmRewRule();
		parmRewRule.setSceneNo("01");
		List<ParmRewRule> parmRewRuleList = parmRewRuleBo.findAll(parmRewRule);
		Map<String, String> parm = new HashMap<String, String>();
		for(int i=0;i<parmRewRuleList.size();i++){
			parm.put(parmRewRuleList.get(i).getRuleId(), parmRewRuleList.get(i).getRuleSts());
		}
		ruleReturnList = new ArrayList<RuleReturn>();
		String chkRes = preApply.getChkRes();
		String finalChkDesc = "";
		
		if("1".equals(parm.get("R0001"))){
			//1��������
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("�Ƿ�������û�");
			ruleReturn.setCodeValue(chkRes);
			if("04".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("�������û���ɸ��δͨ��");
				finalChkDesc = "���ں������û���ɸ��δͨ��";
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("�Ǻ������û���ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0002"))){
			//2���ظ���ͬ
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("��ͬ�Ƿ��ظ�");
			ruleReturn.setCodeValue(chkRes);
			if("07".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("�ظ���ͬ��ɸ��δͨ��");
				finalChkDesc = "���ں�ͬ�ظ���ɸ��δͨ��";
			}else if("04".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("��ͬ�Ƿ��ظ�δɸ��");
			}else{
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("��ͬ���ظ���ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0003"))){
			//3������״��
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("�ѻ��û����������ż��Ϣ");
			ruleReturn.setCodeValue(chkRes);
			if("08".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("����״��Ϊ�ѻ飬����ż��Ϣ��������ɸ��δͨ��");
				finalChkDesc = "������ż��Ϣ��������ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("����״��δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("����״������Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0004"))){
			//4������������������������Ч
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("����������������������Ч");
			ruleReturn.setCodeValue(chkRes);
			if("09".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("�������������Ч��ɸ��δͨ��");
				finalChkDesc = "���ں������������Ч��ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)||"08".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("������������δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("���������������Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
			//4��������������������˻�
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("����������������˻���Ϣ");
			ruleReturn.setCodeValue(chkRes);
			if("17".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("�����������˻���Ϣ��ɸ��δͨ��");
				finalChkDesc = "���ں����������˻���Ϣ��ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)||"08".equals(chkRes)||"09".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("���������˻���Ϣδɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("�������������˻���Ϣ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
			//4�����������������������
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("���������������������Ϣ");
			ruleReturn.setCodeValue(chkRes);
			if("17".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("����������������Ϣ��ɸ��δͨ��");
				finalChkDesc = "���ں���������������Ϣ��ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)||"08".equals(chkRes)||"09".equals(chkRes)||"17".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("��������������Ϣδɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("������������������Ϣ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0005"))){
			//5��������Ŀ��ű�����ڡ���Ч������������������Ӧ
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("������Ŀ��ű�����ڡ���Ч������������������Ӧ");
			ruleReturn.setCodeValue(chkRes);
			if("10".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("������Ŀ�����Ч�����������������Ų�����ɸ��δͨ��");
				finalChkDesc = "����������Ŀ�����Ч�����������������Ų�����ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)||"08".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("������Ŀ���δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("������Ŀ��ŷ���Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0019"))){
			//5����Ŀ��������ʽ���Ϣ
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("��Ŀ��������ʽ���Ϣ");
			ruleReturn.setCodeValue(chkRes);
			if("20".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("��Ŀδ�����ʽ���Ϣ��ɸ��δͨ��");
				finalChkDesc = "��Ŀδ�����ʽ���Ϣ��ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)||"20".equals(chkRes)||"08".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("������Ŀ���δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("������Ŀ��ŷ���Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0006"))){
			//6����Ʒ�ű����������Ч
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("��Ʒ�ű����������Ч");
			ruleReturn.setCodeValue(chkRes);
			if("11".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("��Ʒ�Ų����ڣ����߲�Ʒ����Ч");
				finalChkDesc = "���ڲ�Ʒ�Ų����ڣ����߲�Ʒ����Ч��ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)||"20".equals(chkRes)||"08".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)||"10".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("��Ʒ��δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("��Ʒ�ŷ���Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0007"))){
			//7��������ʽΪ��Ѻ�����������Ч��ѺƷ��Ϣ
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("������ʽΪ��Ѻ�����������Ч��ѺƷ��Ϣ");
			ruleReturn.setCodeValue(chkRes);
			if("12".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("������ʽΪ��Ѻ�����ǲ�����ѺƷ��Ϣ");
				finalChkDesc = "���ڲ�����ѺƷ��Ϣ��ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)||"20".equals(chkRes)||"08".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)||"10".equals(chkRes)||"11".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("ѺƷ��Ϣδɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("������ʽΪ��Ѻ��ѺƷ��Ϣ����Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
			//8��������ʽΪ��Ѻ����Ѻ�����ں�ͬ���
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("������ʽΪ��Ѻ����Ѻ�����ں�ͬ���");
			ruleReturn.setCodeValue(chkRes);
			if("13".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("������ʽΪ��Ѻ�����ǵ�Ѻ���С�ں�ͬ���");
				finalChkDesc = "���ڵ�Ѻ���С�ں�ͬ��ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)||"20".equals(chkRes)||"08".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)||"10".equals(chkRes)||"11".equals(chkRes)||"12".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("��Ѻ���δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("������ʽΪ��Ѻ����Ѻ������Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0008"))){
			//9���˻���Ϣ��������
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("�˻���Ϣ��������");
			ruleReturn.setCodeValue(chkRes);
			if("14".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("�˻���Ϣ��������ɸ��δͨ��");
				finalChkDesc = "�����˻���Ϣ��������ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)||"20".equals(chkRes)||"08".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)||"10".equals(chkRes)||"11".equals(chkRes)||"12".equals(chkRes)||"13".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("�˻���Ϣδɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("�˻���Ϣ����Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
			//10���ſ����ܺ͵��ں�ͬ���
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("�ſ����ܺ͵��ں�ͬ���");
			ruleReturn.setCodeValue(chkRes);
			if("15".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("�˻��ſ����ܺͲ����ں�ͬ��ɸ��δͨ��");
				finalChkDesc = "�����˻��ſ����ܺͲ����ں�ͬ��ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)||"20".equals(chkRes)||"08".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)||"10".equals(chkRes)||"11".equals(chkRes)||"12".equals(chkRes)||"13".equals(chkRes)||"14".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("�ſ������ͬ���δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("�ſ������ͬ������Ҫ��ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		if("1".equals(parm.get("R0017"))){
			//6����Ʒ�������չҵ���������������ص�
			ruleReturn = new RuleReturn();
			ruleReturn.setCodeName("��Ʒ�������չҵ���������������ص�");
			ruleReturn.setCodeValue(chkRes);
			if("19".equals(chkRes)){
				ruleReturn.setCodeRes("02");
				ruleReturn.setCodeResDes("��Ʒ�������չҵ����������������ص�");
				finalChkDesc = "���ڲ�Ʒ�������չҵ����������������ص㣬ɸ��δͨ��";
			}else if("04".equals(chkRes)||"07".equals(chkRes)||"20".equals(chkRes)||"08".equals(chkRes)||"17".equals(chkRes)||"18".equals(chkRes)||"09".equals(chkRes)||"10".equals(chkRes)||"11".equals(chkRes)||"12".equals(chkRes)||"13".equals(chkRes)||"14".equals(chkRes)||"15".equals(chkRes)){
				ruleReturn.setCodeRes("03");
				ruleReturn.setCodeResDes("��Ʒչҵ����δɸ��");
			}else {
				ruleReturn.setCodeRes("01");
				ruleReturn.setCodeResDes("��Ʒ�������չҵ�������ú�����ص㣬ɸ��ͨ��");
			}
			ruleReturnList.add(ruleReturn);
		}
		//11���ܽ��
		ruleReturn = new RuleReturn();
		ruleReturn.setCodeName("���ս��");
		ruleReturn.setCodeValue(chkRes);
		if("".equals(finalChkDesc)){
			ruleReturn.setCodeRes("04");
			ruleReturn.setCodeResDes("�û���ͨ������ɸ�飬������һ���׶�");
		}else {
			ruleReturn.setCodeRes("02");
			ruleReturn.setCodeResDes(finalChkDesc);
		}
		ruleReturnList.add(ruleReturn);
		parm.clear();
		parm=null;
		return ruleReturnList;
	}
	/**
	 * Ԥ����ɸ��
	 * @param ruleFact
	 * @return
	 */
	public String resultError(RuleFact ruleFact){
		
		String s = null;
		//1������
		if("03".equals(ruleFact.getAgeRes())){
			s = "���䲻����Ҫ��";
		}
		//2��ѧ��
		if("03".equals(ruleFact.getEduRes())){
			s = "ѧ��������Ҫ��";
		}
		//3����ҵ����
		if("03".equals(ruleFact.getCifTypeRes())){
			s = "��ҵ���Ͳ�����Ҫ��";
		}
		//4��������
		if("03".equals(ruleFact.getIncomeRes())){
			s = "�����벻����Ҫ��";
		}
		//5����������
		if("03".equals(ruleFact.getIfBendiRes())){
			s = "�������Բ�����Ҫ��";
		}
		//6����ϵ�绰
		if("03".equals(ruleFact.getIfPhoneRes())){
			s = "��ϵ�绰������Ҫ��";
		}
		//7���Ƿ��г�
		if("03".equals(ruleFact.getIfCarRes())){
			s = "�Ƿ��г�������Ҫ��";
		}
		//�찲δ��У��ģ��
		//1��ʵ����֤
		if("03".equals(ruleFact.getIfCarRes())){
			s = "ʵ����֤������Ҫ��";
		}
		//2������ʱ��
		if("03".equals(ruleFact.getIfCarRes())){
			s = "����ʱ�䲻����Ҫ��";
		}		
		//3���ɷ�ϰ��
		if("03".equals(ruleFact.getIfCarRes())){
			s = "�ɷ�ϰ�߲�����Ҫ��";
		}	
		//4��ͣ��ʱ��
		if("03".equals(ruleFact.getIfCarRes())){
			s = "ͣ��ʱ�䲻����Ҫ��";
		}	
		//5���˻�״̬
		if("03".equals(ruleFact.getIfCarRes())){
			s = "�˻�״̬������Ҫ��";
		}	
		//6��ͨ��ʱ��
		if("03".equals(ruleFact.getIfCarRes())){
			s = "ͨ��ʱ��������Ҫ��";
		}
		//7�����д���
		if("03".equals(ruleFact.getIfCarRes())){
			s = "���д���������Ҫ��";
		}
		//8�����д���
		if("03".equals(ruleFact.getIfCarRes())){
			s = "���д���������Ҫ��";
		}
		//9��������
		if("03".equals(ruleFact.getIfCarRes())){
			s = "������������Ҫ��";
		}
		//10������ʹ����
		if("03".equals(ruleFact.getIfCarRes())){
			s = "����ʹ����������Ҫ��";
		}
		//11����Ĭʱ��
		if("03".equals(ruleFact.getIfCarRes())){
			s = "��Ĭʱ�䲻����Ҫ��";
		}
		//12���û��ʸ�
		if("03".equals(ruleFact.getIfCarRes())){
			s = "�û��ʸ񲻷���Ҫ��";
		}		
		return s;
	}
}
