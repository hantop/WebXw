package app.creditapp.ln.worker;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import app.base.SourceTemplate;
import app.base.httpclient.entity.SendMessageEntity;
import app.base.httpclient.entity.SendMessageType;
import app.base.httpclient.work.SendMessageMain;
import app.creditapp.aft.entity.aftMessage.PasSubTypeEntity;
import app.creditapp.corp.bo.CorpBaseBo;
import app.creditapp.corp.entity.CorpBase;
import app.creditapp.inf.client.RuleTrans;
import app.creditapp.inf.client.RulesService;
import app.creditapp.inf.client.entity.Request;
import app.creditapp.inf.client.entity.RequestObj;
import app.creditapp.inf.client.entity.ReturnObj;
import app.creditapp.inf.client.entity.RuleFact;
import app.creditapp.ln.bo.LnApplyBo;
import app.creditapp.ln.bo.LnApplyMidBo;
import app.creditapp.ln.bo.LnApplyRegBo;
import app.creditapp.ln.entity.LnApply;
import app.creditapp.ln.entity.LnApplyMid;
import app.creditapp.ln.entity.LnApplyReg;
import app.creditapp.proj.bo.ProjMangBo;
import app.creditapp.proj.entity.ProjMang;
import app.creditapp.redis.util.RedisUtil;
import app.creditapp.sys.bo.PrdtBaseBo;
import app.creditapp.sys.entity.PrdtBase;
import app.creditapp.sys.entity.SysOrg;
import app.creditapp.sys.entity.SysPath;
import app.util.syslog.bo.SysExceptionBo;

import com.alibaba.fastjson.JSON;

/**
 * @���� DHCC-SONG
 * @���� Jun 6, 2016
 * @���� ҵ����C�ڵ� �Զ���������
 */
public class WorkCforApprove implements Runnable {
	Logger logger = Logger.getLogger(WorkCforApprove.class);
	// private CorpBase corpBase;
	// private CorpBaseBo corpBaseBo;
	private LnApplyMid lnApplyMid;
	private LnApplyReg lnApplyReg;

	public WorkCforApprove(LnApplyMid lnApplyMid) {
		this.lnApplyMid = lnApplyMid;
	}

	public void run() {
		String _auto_app_sts = "02"; // Ĭ���Զ�����ͨ�� ����״̬[01δ����02ͨ��03���04������ͬ]
		String _up_result = "0";// ����״̬�ɹ���־��Ĭ��ʧ��
		String rgsp = "01";
		try {
			if (lnApplyMid == null) {
				logger.error("C������ʧ��,���յ�����Ϊ�գ�");
			} else {
				logger.info("APPID:" + lnApplyMid.getAppId() + " WORK C ����ʼ");
				// ������ʽ������Ϣ
				// sendMessage();
				// ���ù�������ӿڽ����Զ�����[��ͬ�Ĳ�Ʒ�����Ų�ͬ]
//				ReturnObj re = appAuto(lnApplyMid);
				String sRe = "0000";
				if (sRe == null || "".equals(sRe)) {
					logger.info("C����-���ù�������ʧ��,reΪ�գ�[������AppId="
							+ lnApplyMid.getAppId() + ",��ͬ��PactNo="
							+ lnApplyMid.getPactNo() + ",���κ�BatchNo="
							+ lnApplyMid.getBatchNo() + "]");
				} else {
					if ("0000".equals(sRe)) {
						_auto_app_sts = "02";
						 //��resultId����lnapplyMid��
//						 lnApplyUpdate(lnApplyMid.getAppId(),sRe);
						// ���ô洢���̸���״̬
						_up_result = lnStage(lnApplyMid.getAppId(), sRe);
						// ������ʧ��������resultId����lnapplymid��
						lnApplyMidUpdate(lnApplyMid.getAppId(), sRe);

						if ("1".equals(_up_result)) { // ���³ɹ��ļ�¼
							// �Զ�����ͨ���ļ�¼
							if ("02".equals(_auto_app_sts)) {
								String _appr_type = "01"; // ��������[01�Զ�02�˹�]
															// Ĭ��Ϊ01�Զ�
								// ������������ж��Ƿ���Ҫ�˹����� ���ݲ�Ʒ�Ż�ȡ�˹����˱���
								_appr_type = this.getRandomType(lnApplyMid
										.getProjNo()); // �����ȡ�˹����˱���
								ReturnObj ro = null;
								// ͨ�������������Ҫ�˹����˵ĵ����˹����˲���
								if ("01".equals(_appr_type)) {
									// ���ù��������ж��Ƿ���Ҫ�����˹�����
									ro = appManual(lnApplyMid);
									if (ro != null) {
										_appr_type = ro.getResponse()
												.getRuleFact().get(0)
												.getAppType();
									} else {
										rgsp = "02";
									}
								}
								if ("01".equals(_appr_type)) {
									logger.info("C�����ж�Ϊ�Զ�����-[������AppId="
											+ lnApplyMid.getAppId()
											+ ",��ͬ��PactNo="
											+ lnApplyMid.getPactNo()
											+ ",���κ�BatchNo="
											+ lnApplyMid.getBatchNo() + "]");
								} else {
									logger.info("C�����ж�Ϊ�˹�����-[������AppId="
											+ lnApplyMid.getAppId()
											+ ",��ͬ��PactNo="
											+ lnApplyMid.getPactNo()
											+ ",���κ�BatchNo="
											+ lnApplyMid.getBatchNo() + "]");
								}
								if ("01".equals(rgsp)) {
									lnApplyMid.setApprType(_appr_type);
									// push��4����Ϣ����
									Jedis jedis = RedisUtil.getJedis();
									jedis.lpush(RedisUtil.QUEUE4,
											JSON.toJSONString(lnApplyMid));
									jedis.close();
									logger.info("C������ɹ�-[������AppId="
											+ lnApplyMid.getAppId()
											+ ",��ͬ��PactNo="
											+ lnApplyMid.getPactNo()
											+ ",���κ�BatchNo="
											+ lnApplyMid.getBatchNo() + "]");
								} else {
									logger.info("C������ʧ�ܣ����������˹��������Գ���-[������AppId="
											+ lnApplyMid.getAppId()
											+ ",��ͬ��PactNo="
											+ lnApplyMid.getPactNo()
											+ ",���κ�BatchNo="
											+ lnApplyMid.getBatchNo() + "]");
								}
							} else {
								logger.info("C����-�Զ��������-[������AppId="
										+ lnApplyMid.getAppId() + ",��ͬ��PactNo"
										+ lnApplyMid.getPactNo()
										+ ",���κ�BatchNo="
										+ lnApplyMid.getBatchNo() + "]");
							}
						} else {
							logger.info("C����-����״̬ʧ��-PKG_LN_APPROVE.PROC_UP_STATUS-[������AppId="
									+ lnApplyMid.getAppId()
									+ ",��ͬ��PactNo="
									+ lnApplyMid.getPactNo()
									+ ",���κ�BatchNo="
									+ lnApplyMid.getBatchNo() + "]");
						}
					} else {
						logger.info("C����-���ù�������ʧ�ܣ�"
								 + "[������AppId="
								+ lnApplyMid.getAppId() + ",��ͬ��PactNo="
								+ lnApplyMid.getPactNo() + ",���κ�BatchNo="
								+ lnApplyMid.getBatchNo() + "]");
					}
				}
			}
		} catch (Exception e) {
			SysExceptionBo sysExceptionBo = (SysExceptionBo) SourceTemplate
					.getSpringContextInstance().getBean("sysExceptionBo");
			sysExceptionBo.insertNewWorkExceptionLog(e, lnApplyMid.getAppId());
			e.printStackTrace();
		}
	}

	/***
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @���� wangtao
	 * @���� Jul 12, 2016
	 * @����˵�������ù�������ӿڽ����Զ�����[��ͬ�Ĳ�Ʒ�����Ų�ͬ]
	 * @���ز��� 02ͨ��03���
	 */
	public ReturnObj appAuto(LnApplyMid ln) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		// ƴ�Ӵ�������
		RequestObj requestObj = new RequestObj();
		Request request = new Request();
		RuleFact ruleFact = new RuleFact();

		ruleFact.setPrdtNo(ln.getPrdtNo());
		// ruleFact.setAge(birthToAge(ln.getBirthDay()));
		// ruleFact.setEdu(ln.getEdu());
		// ruleFact.setCifType(ln.getCifType());
		// if(ln.getWorkSts()==null||"".equals(ln.getWorkSts())){
		// ruleFact.setIfWork("99");
		// }else{
		// ruleFact.setIfWork(ln.getWorkSts());
		// }
		// ruleFact.setIfRoom(ln.getIfRoom());
		// ruleFact.setIfBlack(ln.getChkRes());
		// ruleFact.setIfPhone("");
		// if(!(ln.getResTel()==null||"".equals(ln.getResTel()))){
		// ruleFact.setIfPhone(ln.getResTel());
		// }
		// if(!(ln.getPhoneNo()==null||"".equals(ln.getPhoneNo()))){
		// ruleFact.setIfPhone(ln.getPhoneNo());
		// }
		// ruleFact.setAgeRes("");
		// ruleFact.setEduRes("");
		// ruleFact.setCifTypeRes("");
		// ruleFact.setIfWorkRes("");
		// ruleFact.setIfBendiRes("");
		// ruleFact.setIfRoomRes("");
		// ruleFact.setIfBlackRes("");
		// ruleFact.setIfPhoneRes("");
		//
		//
		// ruleFact.setSex(ln.getSex());
		// ruleFact.setWorkYear(dateToYear(ln.getWorkYear())+"");
		// ruleFact.setMarriage(ln.getMarriage());
		// ruleFact.setChildren(ln.getChildren()+"");
		// ruleFact.setIncome(ln.getIncome());
		// ruleFact.setIfBendi("");
		// if((ln.getAppArea().equals(ln.getCifArea()))){
		// ruleFact.setIfBendi("01");
		// }
		// ruleFact.setIfCar(ln.getIfCar());
		// ruleFact.setIfCard(ln.getIfCard());
		// ruleFact.setCardAmt(ln.getCardAmt());
		// ruleFact.setIfCarcred(ln.getIfCarcred());
		// ruleFact.setIfMort(ln.getIfMort());
		// �ֲ�����ֶβ���̬��ֵ
		/*
		 * Field f; if(ln.getArgs().length()>0){ String[]
		 * sArr=(ln.getArgs()).split("@"); for(int i = 0; i < sArr.length; i++){
		 * //args ��ֵ f = ruleFact.getClass().getDeclaredField("arg"+(i+1));
		 * f.setAccessible(true); f.set(ruleFact, sArr[i]); //argsRes ��ֵ // f =
		 * ruleFact.getClass().getDeclaredField("arg"+(i+1)+"Res"); //
		 * f.setAccessible(true); // f.set(ruleFact, ""); } }
		 */
		ruleFact.setAppRes("");
		List<RuleFact> list = new ArrayList<RuleFact>();
		list.add(0, ruleFact);

		String rulesName = WorkUtils.getRulesNameMap().get(
				lnApplyMid.getPrdtNo());
		if (rulesName == null) {
			PrdtBaseBo prdtBaseBo = (PrdtBaseBo) SourceTemplate
					.getSpringContextInstance().getBean("prdtBaseBo");
			PrdtBase prdtBase = new PrdtBase();
			prdtBase.setPrdtNo(lnApplyMid.getPrdtNo());
			prdtBase = prdtBaseBo.getByPrdtNo(prdtBase);
			rulesName = prdtBase.getRulesName();
			WorkUtils.getRulesNameMap().put(lnApplyMid.getPrdtNo(), rulesName);
		}

		request.setRuleName(rulesName);
		ruleFact.setAge(birthToAge(ln.getBirthDay()));
		request.setRuleFact(list);
		requestObj.setUser("1001");
		requestObj.setPassword("1");
		requestObj.setRequest(request);
		ReturnObj ro = null;
		try {
			// ���ӹ�������
			RulesService rs = (RulesService) SourceTemplate
					.getSpringContextInstance().getBean("RulesService");
			// ���ù�������õ����ص��ַ���
			String str = rs.executeRule(JSON.toJSONString(requestObj));
			// �����ص��ַ���תΪObject��ȡ���������
			ro = (ReturnObj) JSON.parseObject(str, ReturnObj.class);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("�Զ��������ù�������ʧ��");
		}
		return ro;
	}

	/***
	 * @���� wangtao
	 * @���� Jul 12, 2016
	 * @����˵����������ת��Ϊ����
	 * @���ز��� ����
	 */
	public int birthToAge(String birth) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(new Date());
		Date birthDate = null;
		Date currentTime = null;
		try {
			birthDate = formatter.parse(birth);
			currentTime = formatter.parse(dateString);
		} catch (Exception e) {
		}
		long day = (currentTime.getTime() - birthDate.getTime())
				/ (24 * 60 * 60 * 1000);
		int year = (int) day / 365;
		return year;
	}

	/***
	 * @���� wangtao
	 * @���� Jul 12, 2016
	 * @����˵����������ת��Ϊ����
	 * @���ز��� ����
	 */
	public int dateToYear(String da) {
		if ("".equals(da) || da == null) {
			return 0;
		} else {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
			String dateString = formatter.format(new Date());
			int year = Integer.parseInt(dateString) - Integer.parseInt(da);
			return year;
		}
	}

	/***
	 * @���� wangtao
	 * @���� Jul 12, 2016
	 * @����˵�������ù�������ӿ��ж��Ƿ���Ҫ�����˹�����
	 * @���ز��� 01�Զ�02�˹�
	 */
	public ReturnObj appManual(LnApplyMid ln) {
		// ���ӹ�������
		RequestObj requestObj = new RequestObj();
		Request request = new Request();
		RuleFact ruleFact = new RuleFact();
		ruleFact.setAppAmt(ln.getPactAmt());
		ruleFact.setAppType("");
		ruleFact.setVouType(ln.getVouType());
		List<RuleFact> list = new ArrayList<RuleFact>();
		list.add(0, ruleFact);
		request.setRuleName("appManual");
		request.setRuleFact(list);
		requestObj.setUser("1001");
		requestObj.setPassword("1");
		requestObj.setRequest(request);
		// ���ù�������õ����ص��ַ���
		// �����ص��ַ���תΪObject��ȡ���������
		ReturnObj ro = null;
		try {
			// ���ӹ�������
			RulesService rs = (RulesService) SourceTemplate
					.getSpringContextInstance().getBean("RulesService");
			// ���ù�������õ����ص��ַ���
			String str = rs.executeRule(JSON.toJSONString(requestObj));
			// �����ص��ַ���תΪObject��ȡ���������
			ro = (ReturnObj) JSON.parseObject(str, ReturnObj.class);
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("�˹��������Ե��ù�������ʧ��");
		}
		return ro;
	}

	/**
	 * @���� DHCC-SONG
	 * @���� Jul 2, 2016
	 * @����˵�������ݲ�Ʒ���ȡ�˹����˱��������Ƿ���Ҫ�˹�����
	 * @���ز��� ��������[01�Զ�02�˹�]
	 */
	public String getRandomType(String projNo) {
		Float d = null;
		d = WorkUtils.getRgAppRateMap().get(lnApplyMid.getPrdtNo());
		if (d == null) {
			PrdtBaseBo prdtBaseBo = (PrdtBaseBo) SourceTemplate
					.getSpringContextInstance().getBean("prdtBaseBo");
			PrdtBase prdtBase = new PrdtBase();
			prdtBase.setPrdtNo(lnApplyMid.getPrdtNo());
			prdtBase = prdtBaseBo.getByPrdtNo(prdtBase);
			d = prdtBase.getRgAppRate();
			WorkUtils.getRgAppRateMap().put(lnApplyMid.getPrdtNo(), d);
		}

		int val = (int) (Math.random() * 100);
		if (val < d) {
			return "02";
		} else {
			return "01";
		}
	}

	/***
	 * @���� wangtao
	 * @���� Jul 25, 2016
	 * @����˵�������������������ln_apply_mid���� ��������ID�ͺ�ͬ�Ÿ���
	 * @���ز��� ��
	 */
	public int lnApplyUpdate(String appId, String resultId) {
		// ������Ҫ���µ��ֶ�ֵ
		LnApply lnApply = new LnApply();
		lnApply.setAppId(appId);
		lnApply.setResultId(resultId);
		// ʹ��Bo��cifEval����и���
		LnApplyBo lnApplyBo = (LnApplyBo) SourceTemplate
				.getSpringContextInstance().getBean("lnApplyBo");
		int result = lnApplyBo.resultIdUpdate(lnApply);
		return result;
	}

	/***
	 * @���� wangtao
	 * @���� Jul 25, 2016
	 * @����˵�������������������ln_apply_mid���� ��������ID�ͺ�ͬ�Ÿ���
	 * @���ز��� ��
	 */
	public int lnApplyMidUpdate(String appId, String re) {
		int result = 0;
		String appRes = "02";
		String resId = "6bef5ac38b";
		if ("02".equals(appRes)) {
			LnApplyMid lnApplyMid = new LnApplyMid();
			lnApplyMid.setAppId(appId);
			lnApplyMid.setChkRes("01");
			lnApplyMid.setChkDesc("ɸ��ͨ��,�Զ�����ͨ��");
			lnApplyMid.setIfFlag(resId);
			// ʹ��Bo��cifEval����и���
			LnApplyMidBo lnApplyMidBo = (LnApplyMidBo) SourceTemplate
					.getSpringContextInstance().getBean("lnApplyMidBo");
			result = lnApplyMidBo.resultIdUpdate(lnApplyMid);

			// ����lnapplyReg��
			LnApplyReg lnApplyReg = new LnApplyReg();
			lnApplyReg.setAppId(appId);
			lnApplyReg.setApprSts(appRes);
			LnApplyRegBo lnApplyRegBo = (LnApplyRegBo) SourceTemplate
					.getSpringContextInstance().getBean("lnApplyRegBo");
			result = lnApplyRegBo.resultIdUpdate(lnApplyReg);

		} else {
			RuleTrans ru = new RuleTrans();
			String reError = "����ʧ��";
			// ������Ҫ���µ��ֶ�ֵ
			LnApplyMid lnApplyMid = new LnApplyMid();
			lnApplyMid.setAppId(appId);
			lnApplyMid.setChkRes("16");
			lnApplyMid.setChkDesc(reError);
			lnApplyMid.setIfFlag(resId);
			// ʹ��Bo��cifEval����и���
			LnApplyMidBo lnApplyMidBo = (LnApplyMidBo) SourceTemplate
					.getSpringContextInstance().getBean("lnApplyMidBo");
			result = lnApplyMidBo.resultIdUpdate(lnApplyMid);

			// ����lnapplyReg��
			LnApplyReg lnApplyReg = new LnApplyReg();
			lnApplyReg.setAppId(appId);
			lnApplyReg.setApprSts("03");
			LnApplyRegBo lnApplyRegBo = (LnApplyRegBo) SourceTemplate
					.getSpringContextInstance().getBean("lnApplyRegBo");
			result = lnApplyRegBo.resultIdUpdate(lnApplyReg);

		}
		return result;
	}

	/***
	 * @���� wangtao
	 * @���� Jul 25, 2016
	 * @����˵�������������������ln_apply_mid���� ��������ID�ͺ�ͬ�Ÿ���
	 * @���ز��� ��
	 */
	public String lnStage(String appId, String re) {
		String _up_result = null;
		String appRes = "02";
		if ("02".equals(appRes)) {
			_up_result = WorkUtils.getInstance().proc_up_status(
					lnApplyMid.getAppId(), appRes, "�Զ�����ͨ��");
		} else {
			String reError = "�������";
			_up_result = WorkUtils.getInstance().proc_up_status(
					lnApplyMid.getAppId(), appRes, "�Զ��������," + reError);
		}

		/*
		 * RuleTrans ru = new RuleTrans(); String reError =
		 * ru.resultError(re.getResponse().getRuleFact().get(0)); //������Ҫ���µ��ֶ�ֵ
		 * LnApplyMid lnApplyMid = new LnApplyMid(); lnApplyMid.setAppId(appId);
		 * lnApplyMid.setChkRes("16"); lnApplyMid.setChkDesc(reError);
		 * //ʹ��Bo��cifEval����и��� LnApplyMidBo lnApplyMidBo = (LnApplyMidBo)
		 * SourceTemplate.getSpringContextInstance().getBean("lnApplyMidBo");
		 * int result = lnApplyMidBo.resultIdUpdate(lnApplyMid);
		 */
		return _up_result;
	}

	public void sendMessage() {

		// ������ʽ������Ϣ
		String s = lnApplyMid.getBrNo();
		CorpBaseBo corpBaseBo = (CorpBaseBo) SourceTemplate
				.getSpringContextInstance().getBean("corpBaseBo");
		CorpBase corpBase = new CorpBase();
		corpBase.setBrNo(s);
		corpBase = corpBaseBo.getById(corpBase);
		// System.out.println("333333333");
		String brname = corpBase.getBrName();
		String a = lnApplyMid.getProjNo();
		// System.out.println(a);
		// List<String> list = new ArrayList<String>();
		// Connection conn=DBUtil.getConnection();
		// Statement stmt=null;
		// ResultSet rs = null;
		// String sql ="select login_id from proj_mang where proj_no="+a;
		// stmt = conn.createStatement();
		// rs = stmt.executeQuery(sql);
		// while(rs.next()){
		// list.add(rs.getString(1));
		// }
		// conn.close();
		// rs.close();
		// stmt.close();
		ProjMang projMang = new ProjMang();
		projMang.setProjNo(a);

		ProjMangBo projMangBo = (ProjMangBo) SourceTemplate
				.getSpringContextInstance().getBean("projMangBo");
		projMangBo.getByIdLoginId(projMang);
		List<ProjMang> projMangList = null;

		projMangList = projMangBo.getByIdLoginId(projMang);
		if (projMangList.equals(null)) {

		} else {
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < projMangList.size(); i++) {
				list.add(projMangList.get(i).getLoginId());
			}
			String user[] = (String[]) list.toArray(new String[list.size()]);
			// String[] user = (String[]) list.toArray();
			SendMessageEntity sendMessageEntity = new SendMessageEntity();
			// System.out.println("11111111111111111");
			// System.out.println(user[1]);
			String title = "��ʽ����";
			String contet = brname + "������";
			sendMessageEntity.setTitle(title);
			sendMessageEntity.setContet(contet);
			sendMessageEntity.setReciveUserNos(user);
			sendMessageEntity.setSendType(SendMessageType.MESSAGE);
			sendMessageEntity
					.setPasSubTypeEntity(PasSubTypeEntity.RewFundMessage);
			try {
				SendMessageMain.sendMessage(sendMessageEntity);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	// ��д����ķ���
	public String toString() {
		String ret = "";
		if (lnApplyMid != null) {
			ret = "ҵ��ID��" + lnApplyMid.getAppId() + ",��ͬ��ţ�"
					+ lnApplyMid.getPactNo();
		}
		return ret;
	}

	// public CorpBase getCorpBase() {
	// return corpBase;
	// }
	//
	// public void setCorpBase(CorpBase corpBase) {
	// this.corpBase = corpBase;
	// }

	// public CorpBaseBo getCorpBaseBo() {
	// return corpBaseBo;
	// }
	//
	// public void setCorpBaseBo(CorpBaseBo corpBaseBo) {
	// this.corpBaseBo = corpBaseBo;
	// }

}
