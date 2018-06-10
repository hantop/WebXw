package app.creditapp.aft.manager;

import app.creditapp.gage.bo.LnGageBo;
import app.creditapp.gage.entity.LnGage;
import app.creditapp.proj.bo.ProjBaseBo;
import app.creditapp.proj.entity.ProjBase;
import app.util.DateUtil;

public class AftMessageManager implements AftManagerManagerInterface{
	private ProjBaseBo projBaseBo;
	private LnGageBo lnGageBo;
	
	public boolean disposeMessage(ManagerEntity entity){
		try {
			switch (entity.getParmRewType()) {
			case Cash_Not_Suff_Funds:
				//�ʽ��ֽ��˻�����
				changeProjSts(entity.getProjNo());
				return true;
			case Vuser_Not_Suff_Funds:
				//TODO  ��Ŀ���⻧����Ԥ��  �벦������
				break;
			case Cash_Due_Audit:
				//ֻ�к��ԣ�����Ҫ������ť�����ڴ��������
				break;
			case Real_time_transaction_Rate:
				changeProjSts(entity.getProjNo());
				break;
			case Entrust_Collection:
				//ֻ�к��ԣ�����Ҫ������ť�����ڴ��������
				break;
			case Suser_Not_Suff_Funds:
				changeProjSts(entity.getProjNo());
				return true;
			case Proj_compensatory_Rate:
				changeProjSts(entity.getProjNo());
				return true;
			case Proj_buy_back_Rate:
				changeProjSts(entity.getProjNo());
				return true;
			case Proj_Overdue_Rate:
				changeProjSts(entity.getProjNo());
				return true;
			case Payback_Datum_Not_Upload:
				//ֻ�к��ԣ�����Ҫ������ť�����ڴ��������
				break;
			case Image_Datum_Not_Upload:
				//ֻ�к��ԣ�����Ҫ������ť�������
				break;
			case Funds_Due_Settlement:
				//ֻ�к��ԣ�����Ҫ������ť�������
				break;
			case Funds_Due_Exchange:
				//ֻ�к��ԣ�����Ҫ������ť�������
				break;
			case Proj_Overdue_Payback:
				//ֻ�к��ԣ�����Ҫ������ť�������
				break;
			case Guar_Release:
				LnGage lnGage = new LnGage();
				lnGage.setGageId(entity.getRelId());
				lnGage.setGageSts("03");
				lnGage.setGageOutdate(DateUtil.getSysGlobal().getSys_date());
				lnGageBo.updateSts(lnGage);
				break;
			case Pending_Approval:
				//TODO �������������� 
				break;
			case Split_Bill_Fail:
				changeProjSts(entity.getProjNo());
				return true;
			default:
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void changeProjSts(String projNo) throws Exception{
		ProjBase projBase = new ProjBase();
		projBase.setProjNo(projNo);
		projBase.setProjSts("03");
		projBaseBo.updateSts(projBase);	
	}

	public void setProjBaseBo(ProjBaseBo projBaseBo) {
		this.projBaseBo = projBaseBo;
	}

	public void setLnGageBo(LnGageBo lnGageBo) {
		this.lnGageBo = lnGageBo;
	}
}	
