package app.creditapp.proj.bo.impl;

import java.text.DecimalFormat;
import java.util.List;

import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.inf.bo.AllocateRegServiceBo;
import app.creditapp.inf.client.AllocateRegService;
import app.creditapp.inf.dao.AllocateRegWsInDao;
import app.creditapp.inf.entity.AllocateRegWsIn;
import app.creditapp.inf.entity.DetailTransactionCommonDTO;
import app.creditapp.inf.entity.MainTransactionCommonDTO;
import app.creditapp.inf.entity.ReqData;
import app.creditapp.inf.entity.ResData;
import app.creditapp.proj.bo.ProjAcctBo;
import app.creditapp.proj.dao.AllocateRegDao;
import app.creditapp.proj.dao.ProjAcctDao;
import app.creditapp.proj.dao.ProjBaseDao;
import app.creditapp.proj.entity.ProjAcct;
import app.creditapp.proj.entity.ProjBase;
import app.creditapp.sys.dao.InterfaceBackMegDao;
import app.creditapp.sys.entity.InterfaceBackMeg;
import app.util.User;
import app.util.toolkit.Ipage;

import com.alibaba.fastjson.JSON;

import flex.messaging.io.ArrayList;

/**
 * Title: ProjAcctBoImplImpl.java Description:
 * 
 **/
public class ProjAcctBoImpl extends BaseService implements ProjAcctBo {
	private ProjBaseDao projBaseDao;
	private ProjAcctDao projAcctDao;
	private AllocateRegDao allocateRegDao;
	private AllocateRegServiceBo allocateRegServiceBo;
	private InterfaceBackMegDao interfaceBackMegDao;
	private AllocateRegService allocateRegService;
	private AllocateRegWsIn allocateRegWsIn;
	private AllocateRegWsInDao allocateRegWsInDao;

	public void del(ProjAcct projAcct) throws ServiceException {
		try {
			projAcctDao.del(projAcct);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public int getCount(ProjAcct projAcct) throws ServiceException{
		int count = 0;
		try {
			count = projAcctDao.getCount(projAcct);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
	}
	public int getCountForX(ProjAcct projAcct) throws ServiceException{
		int count = 0;
		try {
			count = projAcctDao.getCountForX(projAcct);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
		
	}
	public String getProjId(ProjAcct projAcct) throws ServiceException{
		String projId = "";
		try {
			projId = projAcctDao.getProjId(projAcct);
		} catch (Exception e) {
			e.printStackTrace() ;
		}
		return projId;
	}
	public void getInfForAcct(ProjAcct projAcct) throws ServiceException{
		
		try {
			projAcctDao.getInfForAcct(projAcct);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public List<ProjAcct> findListByProjNo(ProjAcct projAcct) throws ServiceException{
		List<ProjAcct> projAcctList = null;
		try {
			projAcctList = projAcctDao.findListByProjNo(projAcct);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return projAcctList;
	}
	
	public Ipage findByPage(Ipage ipg, ProjAcct projAcct) throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) projAcctDao.getCount(projAcct) });// ��ʼ����ҳ��
			projAcct.setStartNumAndEndNum(ipg);
			ipg.setResult(projAcctDao.findByPage(projAcct));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public Ipage findByPageForPop(Ipage ipg, ProjAcct projAcct) throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) projAcctDao.getCountForPop(projAcct) });// ��ʼ����ҳ��
			projAcct.setStartNumAndEndNum(ipg);
			ipg.setResult(projAcctDao.findByPageForPop(projAcct));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	//��ȡ ����Ŀ�µ� ר���� �����˺���Ϣ
	public int getCountForProj(ProjAcct projAcct) throws ServiceException {
		int count = 0;
		try {
			count =  projAcctDao.getCount(projAcct);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
	}

	public ProjAcct getById(ProjAcct projAcct) throws ServiceException {
		try {
			projAcct = projAcctDao.getById(projAcct);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return projAcct;
	}

	public ProjAcct getByProjNoAndAcctType(ProjAcct projAcct) throws ServiceException {
		try {
			projAcct = projAcctDao.getByProjNoAndAcctType(projAcct);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return projAcct;
	}

	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-8-25
	 * @����˵���������˻�Ԥ����
	 * @���ز��� ProjAcct
	 */
	public ProjAcct virtual_AllocateReg(AllocateRegWsIn allocateRegWsIn) throws ServiceException {
		ProjAcct projAcct = new ProjAcct();
		try {
			double acctBal = 0.00;
			projAcct.setProjNo(allocateRegWsIn.getProjectid());
			projAcct.setAcctType("01");
			projAcct = projAcctDao.getByProjNoAndAcctType(projAcct);

			acctBal = projAcct.getAcctBal() - Double.valueOf(allocateRegWsIn.getAmount());
			// ���⻧��Ϣ
			ProjAcct projAcct1 = new ProjAcct();
			projAcct1.setAcctId(allocateRegWsIn.getAcctId());
			projAcct1 = projAcctDao.getInterfaceById(projAcct1);
			if (acctBal > 0) {
				// �����ղ���ӿڱ�
				allocateRegWsInDao.insert(allocateRegWsIn);
				allocateRegWsIn.setSdtime(User.gethnTime());
				// ����
				ResData resData = new ResData();
				//ErrorMsgDTO errorMsgDTO = new ErrorMsgDTO();
				// ���ýӿ�
				resData = allocateRegService(allocateRegWsIn);
				String status = resData.getStatus();
				if ("1".equals(status)) {
					// �޸�ר�����
//					projAcct.setAcctBal(acctBal);
//					projAcctDao.update(projAcct);
//					// �޸����⻧���
//					ProjAcct projAcct2 = new ProjAcct();
//					projAcct2.setAcctId(allocateRegWsIn.getAcctId());
//					projAcct2 = projAcctDao.getById(projAcct1);
//					projAcct2.setAcctBal(projAcct2.getAcctBal() + Double.valueOf(allocateRegWsIn.getAmount()));
//					projAcctDao.update(projAcct2);
//					// �������⻧��ϸ��
//					AllocateReg allocateReg = new AllocateReg();
//					allocateReg.setAcctId(allocateRegWsIn.getAcctId());
//					allocateReg.setAcctNo("");
//					allocateReg.setProjNo(allocateRegWsIn.getProjectid());
//					allocateReg.setTxAmt(Double.valueOf(allocateRegWsIn.getAmount()));
//					allocateReg.setFAcctNo(projAcct.getAcctNo());
//					allocateReg.setOpNo(allocateRegWsIn.getUserCode());
//					allocateRegDao.insert(allocateReg);
					
					allocateRegWsIn.setWssts("1");
					allocateRegWsIn.setTransid(resData.getTransID());
					allocateRegWsInDao.update(allocateRegWsIn);
					projAcct.setFiller("��ͨϵͳ������Ϣ:Ԥ����ɹ�");
				} else {
					allocateRegWsIn.setWssts("2");
					allocateRegWsIn.setRemarks(resData.getErrorCopeType()+" code:"+resData.getErrorCode());
					allocateRegWsInDao.update(allocateRegWsIn);
					//errorMsgDTO = resData.getErrorMsgDTO();
					InterfaceBackMeg interfaceBackMeg = new InterfaceBackMeg();
					interfaceBackMeg.setInterfaceName("�ղ���ӿ�");
					interfaceBackMeg.setBackMegKey(resData.getErrorCode());
					interfaceBackMeg = interfaceBackMegDao.getById(interfaceBackMeg);
					projAcct.setFiller("��ͨϵͳ������Ϣ:"+resData.getErrorCode()+"-"+interfaceBackMeg.getBackMegDes());
				}
			} else {
				projAcct.setFiller("ר������");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return projAcct;
	}

	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-8-25
	 * @����˵����Ԥ����service���ýӿڷ���
	 * @���ز��� String
	 */
	public ResData allocateRegService(AllocateRegWsIn allocateRegWsIn) throws ServiceException {
		// ���
		ReqData reqData = new ReqData();
		// ����
		ResData resData = new ResData();
		// ������Ϣ
		MainTransactionCommonDTO mainTransactionCommonDTO = new MainTransactionCommonDTO();
		// ��ϸlist
		List<DetailTransactionCommonDTO> detailTransactionCommonDTOList = new ArrayList();
		try {
			allocateRegWsIn = allocateRegWsInDao.getById(allocateRegWsIn);
			// ������Ϣ
			mainTransactionCommonDTO.setId(allocateRegWsIn.getId());
			mainTransactionCommonDTO.setProjectID(allocateRegWsIn.getProjectid());
			if(allocateRegWsIn.getDdtype()==null){
				mainTransactionCommonDTO.setDdType("");
			}else{
				mainTransactionCommonDTO.setDdType(allocateRegWsIn.getDdtype());
			}
			mainTransactionCommonDTO.setTransDate(allocateRegWsIn.getTransdate());
			mainTransactionCommonDTO.setTransReason(allocateRegWsIn.getTransreason());
			mainTransactionCommonDTO.setPurpose(allocateRegWsIn.getPurpose());
			mainTransactionCommonDTO.setMemo(allocateRegWsIn.getMemo());
//			mainTransactionCommonDTO.setUserCode("zhangluting");
			mainTransactionCommonDTO.setUserCode(allocateRegWsIn.getUserCode());
			mainTransactionCommonDTO.setStaffApp(allocateRegWsIn.getStaffapp());
			// ��ϸlist
			DetailTransactionCommonDTO detailTransactionCommonDTO = new DetailTransactionCommonDTO();
			detailTransactionCommonDTO.setId(allocateRegWsIn.getId());
			detailTransactionCommonDTO.setAmount(allocateRegWsIn.getAmount());
			detailTransactionCommonDTO.setBkTransTypeCode(allocateRegWsIn.getBktranstypecode());
			detailTransactionCommonDTO.setSkTransTypeCode(allocateRegWsIn.getSktranstypecode());
			detailTransactionCommonDTO.setFeeTypeCode(allocateRegWsIn.getFeetypecode());
			detailTransactionCommonDTO.setTaxTypeCode(allocateRegWsIn.getTaxtypecode());
			detailTransactionCommonDTO.setCustomID(allocateRegWsIn.getCustomid());
			detailTransactionCommonDTO.setAccountID(allocateRegWsIn.getAccountid());
			// detailTransactionCommonDTO.setOpBankAcntID(allocateRegWsIn.getOpbankacntid());
			detailTransactionCommonDTO.setOpBankAcntNO(allocateRegWsIn.getOpbankacntno());
			detailTransactionCommonDTO.setOpBankName(allocateRegWsIn.getOpbankname());
			detailTransactionCommonDTO.setOpBankAcntName(allocateRegWsIn.getOpbankacntname());
			detailTransactionCommonDTO.setOpBankProvince(allocateRegWsIn.getOpbankprovince());
			detailTransactionCommonDTO.setOpBankCity(allocateRegWsIn.getOpbankcity());
			detailTransactionCommonDTO.setRepayTypeID(allocateRegWsIn.getRepaytypeid());
			detailTransactionCommonDTO.setAppUserCode(allocateRegWsIn.getAppusercode());
			// ������Ϣ
			detailTransactionCommonDTO.setPersonnel("");
			detailTransactionCommonDTO.setProject(allocateRegWsIn.getProject());
			detailTransactionCommonDTO.setCustomer(allocateRegWsIn.getCustomer());
			detailTransactionCommonDTO.setCashFlow("");
			detailTransactionCommonDTO.setVirtualAccount("");
			detailTransactionCommonDTO.setContractNumber("");
			detailTransactionCommonDTO.setStockCode("");
			detailTransactionCommonDTO.setFundAccount("");
			detailTransactionCommonDTO.setSalesDepartment("");
			detailTransactionCommonDTO.setCheckNumber("");
			detailTransactionCommonDTO.setBusinessType("");
			detailTransactionCommonDTO.setCashFlowStatement("");
			detailTransactionCommonDTO.setTaxCategory("");
			detailTransactionCommonDTO.setInterestRate("");
			detailTransactionCommonDTO.setIndustry(allocateRegWsIn.getIndustry());
			detailTransactionCommonDTO.setStock("");
			detailTransactionCommonDTO.setAssetName("");
			detailTransactionCommonDTO.setProductName("");
			detailTransactionCommonDTO.setClientOrBeneficiary("");
			detailTransactionCommonDTO.setShareholder("");
			detailTransactionCommonDTO.setEntrustContractNumber("");
			detailTransactionCommonDTO.setTradingPurpose("");
			detailTransactionCommonDTO.setContractVariety("");
			detailTransactionCommonDTO.setDateOfReceipt("");
			detailTransactionCommonDTO.setInterestDate("");
			detailTransactionCommonDTO.setDueDate("");
			detailTransactionCommonDTO.setInOrOut("");
			detailTransactionCommonDTO.setBillNumber("");

			// ��������
			detailTransactionCommonDTOList.add(detailTransactionCommonDTO);

			// ���

			reqData.setBusinessFlag("1");// 1:�˻����2�����и���Ӫ��3���˻��տ4:��Ӫ���棬5:���и����ϻ���6�����˻�����
			reqData.setAutoSyncFlag("2");//�Զ�ͬ�����������ʾ   
			reqData.setMainTransactionCommonDTO(mainTransactionCommonDTO);
			reqData.setDetailTransactionCommonDTOList(detailTransactionCommonDTOList);

			// ����webservice�ӿ�
			// AllocateRegServiceBo allocateRegServiceBo =
			// (AllocateRegServiceBo)SourceTemplate.getSpringContextInstance().getBean("allocateRegServiceBo");
			String backData = allocateRegServiceBo.saveActTransactionInfos(reqData);
			// String Data = JSON.toJSONString(reqData);
			// String backData =
			// allocateRegService.saveActTransactionInfos(Data);
			resData = JSON.parseObject(backData, ResData.class);

		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}

		return resData;
	}

	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-8-25
	 * @����˵�����ղ���ӿ�ʵ������ -----�˷��������� ��ֵ-100���� by wsf
	 * @���ز��� String
	 */
	public AllocateRegWsIn insert_allocateRegWsIn(String projNo, double txAmt, String acctId, String opNo,
			String tradeCode) throws ServiceException {
		String transtypecode = "";// �������ͱ���(��ֵ-100-4224;�ſ�ɹ�-200-4258;��Ϣ-201-4271;��Ϣ-202-2731;����-203-290)
		String bktranstypecode = "";// ����Ľ������ͱ���(����ʱ����)
		String sktranstypecode = "";// �տ�Ľ������ͱ��� (����������и���Ӫ�����տ��ʱ����)
		String businessflag = "";// �ղ�������1:�˻����2�����и���Ӫ��3���˻��տ4:��Ӫ���棬5:���и����ϻ���6�����˻�����
		String autoSyncFlag = "";//�Զ�ͬ�����������ʾ   
		// ������
		//String accountid = "";// �ʽ����÷��˺�ID/���I
		//String project = "";// ��Ŀ����
		//String customer = "";// �ͻ����ƣ������������ƣ�
		String industry = "";// ��ҵ
		// ���λ��ת��
		String txamt = new DecimalFormat("#.00").format(txAmt);
		allocateRegWsIn = new AllocateRegWsIn();
		//���⻧
		ProjAcct projAcct = new ProjAcct();
		projAcct.setAcctId(acctId);
		//��Ŀ
		ProjBase projBase = new ProjBase();
		projBase.setProjNo(projNo);
		//ר��
		//ProjAcct projAcctZH = new ProjAcct();

		try {
			projAcct = projAcctDao.getInterfaceById(projAcct);
			projBase = projBaseDao.getById(projBase);
			/*projAcctZH.setProjNo(projNo);
			projAcctZH.setAcctType("01");
			projAcctZH = projAcctDao.getByProjNoAndAcctType(projAcctZH);*/
			transtypecode = "4224";
			businessflag = "1";
			autoSyncFlag = "2";
			bktranstypecode = transtypecode;
			//��ȡ��ͨ�ʽ����÷��˺�ID/���ID
			ProjAcct projAcct1 = new ProjAcct();
			projAcct1.setProjNo(projNo);
			
			projAcct1 = projAcctDao.VW_ACT_ACCOUNTINFO(projAcct1);
			
			// ������Ϣ
			String id = allocateRegWsInDao.getByid();
			allocateRegWsIn.setId(id);
			allocateRegWsIn.setBusinessflag(businessflag);
			allocateRegWsIn.setAutoSyncFlag(autoSyncFlag);
			allocateRegWsIn.setProjectid(projBase.getProjId());
			allocateRegWsIn.setDdtype("");
			allocateRegWsIn.setTransdate(projAcct.getTxDate());
			allocateRegWsIn.setTransreason("С΢ϵͳ��ֵ");
			allocateRegWsIn.setPurpose(projAcct.getAcctUse());
			allocateRegWsIn.setMemo("С΢ϵͳԤ����");
			allocateRegWsIn.setUserCode(opNo);
			allocateRegWsIn.setStaffapp("");
			// ��ϸlist
			allocateRegWsIn.setAmount(txamt);
			allocateRegWsIn.setBktranstypecode(bktranstypecode);
			allocateRegWsIn.setSktranstypecode(sktranstypecode);
			allocateRegWsIn.setFeetypecode("");
			allocateRegWsIn.setTaxtypecode("");
			allocateRegWsIn.setCustomid("");
			if(projAcct1 != null){
				allocateRegWsIn.setAccountid(projAcct1.getAcctId());
			}
			// allocateRegWsIn.setOpbankacntid("");
			allocateRegWsIn.setOpbankacntno(projAcct.getCardNo());
			allocateRegWsIn.setOpbankname(projAcct.getOpnBank());
			allocateRegWsIn.setOpbankacntname(projAcct.getCardName());
			allocateRegWsIn.setOpbankprovince(projAcct.getBankProv());
			allocateRegWsIn.setOpbankcity(projAcct.getBankCity());
			allocateRegWsIn.setRepaytypeid("");
			allocateRegWsIn.setAppusercode("");
			// ��������Ϊ������������
			allocateRegWsIn.setPersonnel("");
			allocateRegWsIn.setProject(projBase.getProjName());
			allocateRegWsIn.setCustomer("");
			allocateRegWsIn.setCashflow("");
			allocateRegWsIn.setVirtualaccount("");
			allocateRegWsIn.setContractnumber("");
			allocateRegWsIn.setStockcode("");
			allocateRegWsIn.setFundaccount("");
			allocateRegWsIn.setSalesdepartment("");
			allocateRegWsIn.setChecknumber("");
			allocateRegWsIn.setBusinesstype("");
			allocateRegWsIn.setCashflowstatement("");
			allocateRegWsIn.setTaxcategory("");
			allocateRegWsIn.setInterestrate("");
			allocateRegWsIn.setIndustry(industry);
			allocateRegWsIn.setStock("");
			allocateRegWsIn.setAssetname("");
			allocateRegWsIn.setProductname("");
			allocateRegWsIn.setClientorbeneficiary("");
			allocateRegWsIn.setShareholder("");
			allocateRegWsIn.setEntrustcontractnumber("");
			allocateRegWsIn.setTradingpurpose("");
			allocateRegWsIn.setContractvariety("");
			allocateRegWsIn.setDateofreceipt("");
			allocateRegWsIn.setInterestdate("");
			allocateRegWsIn.setDuedate("");
			allocateRegWsIn.setInorout("");
			allocateRegWsIn.setBillnumber("");
			// �����ղ���ӿڱ�
			// allocateRegWsInDao.insert(allocateRegWsIn);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return allocateRegWsIn;
	}

	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-8-25
	 * @����˵�����Զ������ղ���ӿڷ���
	 * @���ز��� String
	 */
	public void auto_allocateRegWsIn(String projNo, double txAmt, String acctId, String opNo, String tradeCode)
			throws ServiceException {
		try {
			// �������������ղ���ʵ��������
			allocateRegWsIn = new AllocateRegWsIn();
			allocateRegWsIn = insert_allocateRegWsIn(projNo, txAmt, acctId, opNo, tradeCode);
			// ����allocateRegService
			virtual_AllocateReg(allocateRegWsIn);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void insert(ProjAcct projAcct) throws ServiceException {
		try {
			/**
			 * ������Ŀ��Ϣ���˻���������
			 */
			projAcct.setAcctId(projAcctDao.getKey());
			projAcctDao.insert(projAcct);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(ProjAcct projAcct) throws ServiceException {
		try {
			projAcctDao.update(projAcct);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void updateSts(ProjAcct projAcct) throws ServiceException {
		try {
			projAcctDao.updateSts(projAcct);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void updateAcctBal(ProjAcct projAcct) throws ServiceException {
		try {
			projAcctDao.updateAcctBal(projAcct);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public Ipage findByPageQuotaForCorp(Ipage ipage, ProjAcct projAcct) throws ServiceException {
		try {
			ipage.initPageCounts(new Integer[] { (Integer) projAcctDao.getCountQuotaForCorp(projAcct) });// ��ʼ����ҳ��
			projAcct.setStartNumAndEndNum(ipage);
			ipage.setResult(projAcctDao.findByPageQuotaForCorp(projAcct));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipage;
	}

	public Ipage findByProjNoAndAcctType(Ipage ipg, ProjAcct projAcct) throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) projAcctDao.getCount(projAcct) });// ��ʼ����ҳ��
			projAcct.setStartNumAndEndNum(ipg);
			ipg.setResult(projAcctDao.findByProjNoAndAcctType(projAcct));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	
	public int getByProjNo(ProjAcct acct) throws ServiceException {
		int size = 0;
		try{
			size = projAcctDao.getByProjNo(acct);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return size;
	}
	public ProjAcctDao getProjAcctDao() {
		return projAcctDao;
	}

	public void setProjAcctDao(ProjAcctDao projAcctDao) {
		this.projAcctDao = projAcctDao;
	}

	/**
	 * @return the allocateRegDao
	 */
	public AllocateRegDao getAllocateRegDao() {
		return allocateRegDao;
	}

	/**
	 * @param allocateRegDao
	 *            the allocateRegDao to set
	 */
	public void setAllocateRegDao(AllocateRegDao allocateRegDao) {
		this.allocateRegDao = allocateRegDao;
	}

	/**
	 * @return the allocateRegServiceBo
	 */
	public AllocateRegServiceBo getAllocateRegServiceBo() {
		return allocateRegServiceBo;
	}

	/**
	 * @param allocateRegServiceBo
	 *            the allocateRegServiceBo to set
	 */
	public void setAllocateRegServiceBo(AllocateRegServiceBo allocateRegServiceBo) {
		this.allocateRegServiceBo = allocateRegServiceBo;
	}

	/**
	 * @return the interfaceBackMegDao
	 */
	public InterfaceBackMegDao getInterfaceBackMegDao() {
		return interfaceBackMegDao;
	}

	/**
	 * @param interfaceBackMegDao
	 *            the interfaceBackMegDao to set
	 */
	public void setInterfaceBackMegDao(InterfaceBackMegDao interfaceBackMegDao) {
		this.interfaceBackMegDao = interfaceBackMegDao;
	}

	/**
	 * @return the allocateRegService
	 */
	public AllocateRegService getAllocateRegService() {
		return allocateRegService;
	}

	/**
	 * @param allocateRegService
	 *            the allocateRegService to set
	 */
	public void setAllocateRegService(AllocateRegService allocateRegService) {
		this.allocateRegService = allocateRegService;
	}

	/**
	 * @return the allocateRegWsIn
	 */
	public AllocateRegWsIn getAllocateRegWsIn() {
		return allocateRegWsIn;
	}

	/**
	 * @param allocateRegWsIn
	 *            the allocateRegWsIn to set
	 */
	public void setAllocateRegWsIn(AllocateRegWsIn allocateRegWsIn) {
		this.allocateRegWsIn = allocateRegWsIn;
	}

	/**
	 * @return the allocateRegWsInDao
	 */
	public AllocateRegWsInDao getAllocateRegWsInDao() {
		return allocateRegWsInDao;
	}

	/**
	 * @param allocateRegWsInDao
	 *            the allocateRegWsInDao to set
	 */
	public void setAllocateRegWsInDao(AllocateRegWsInDao allocateRegWsInDao) {
		this.allocateRegWsInDao = allocateRegWsInDao;
	}

	public ProjBaseDao getProjBaseDao() {
		return projBaseDao;
	}

	public void setProjBaseDao(ProjBaseDao projBaseDao) {
		this.projBaseDao = projBaseDao;
	}
	

}