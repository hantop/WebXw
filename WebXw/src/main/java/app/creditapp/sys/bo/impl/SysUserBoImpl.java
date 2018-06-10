package  app.creditapp.sys.bo.impl;

import org.apache.struts2.ServletActionContext;
import org.dbunit.util.Base64;

import app.base.BaseService;
import app.base.PUBParm;
import app.base.ServiceException;
import app.creditapp.batch.bo.BatchExeBo;
import app.creditapp.sys.bo.SysUserBo;
import app.creditapp.sys.bo.SysUserRoleBo;
import app.creditapp.sys.dao.SysUserDao;
import app.creditapp.sys.entity.SysUser;
import app.creditapp.sys.entity.SysUserRole;
import app.util.User;
import app.util.toolkit.Ipage;
/**
* Title: SysUserBoImplImpl.java
* Description:
**/
public class SysUserBoImpl extends BaseService implements SysUserBo {

	private SysUserDao SysUserDao;
	private BatchExeBo batchExeBo;
	private SysUserRoleBo sysUserRoleBo;

	public void del(SysUser SysUser) throws ServiceException {
		try {
			SysUserDao.del(SysUser);
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setUser_no(SysUser.getUser_no());
			sysUserRoleBo.delByLoginId(sysUserRole);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public String getBatchSuccessFlag() throws ServiceException {
		String flag = "";
		try {
			int batchCount = batchExeBo.getCountByBtchDate();
			if( batchCount > 0){
				int iCount = batchExeBo.getFailBatchNodeCount(PUBParm.NODE_STATUS_2);//ִ����
				int failCount = batchExeBo.getFailBatchNodeCount(PUBParm.NODE_STATUS_3);//ִ��ʧ��
				if(iCount > 0){
					flag = "ϵͳ�����������������У����Ժ��½��";
				}else if(failCount > 0){
					flag = "ϵͳ������������ʧ�ܣ�����ϵ�Ƽ���ϵͳ����Ա��";
				}
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return flag;
	}

	public Ipage findByPage(Ipage ipg, SysUser SysUser)throws ServiceException {
		try {
			SysUser sysUser = new SysUser();
			sysUser.setUser_no(User.getLoginid(ServletActionContext.getRequest()));
			sysUser = SysUserDao.getById(sysUser);

			ipg.initPageCounts(new Integer[] { (Integer) SysUserDao
					.getCount(SysUser) });// ��ʼ����ҳ��
			SysUser.setStartNumAndEndNum (ipg);
			ipg.setResult(SysUserDao.findByPage(SysUser));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	public Ipage findByPageForPop(Ipage ipg, SysUser SysUser)throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) SysUserDao
					.getCountForPop(SysUser) });// ��ʼ����ҳ��
			SysUser.setStartNumAndEndNum (ipg);
			ipg.setResult(SysUserDao.findByPageForPop(SysUser));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	public Ipage findMangNoPop(Ipage ipg, SysUser SysUser)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) SysUserDao
					.getMangNoPopCount(SysUser) });// ��ʼ����ҳ��
			SysUser.setStartNumAndEndNum (ipg);
			ipg.setResult(SysUserDao.findMangNoPop(SysUser));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public SysUser getById(SysUser SysUser) throws ServiceException {
		try {
			SysUser = SysUserDao.getById(SysUser);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return SysUser;
	}

	public void insert(SysUser SysUser) throws ServiceException {
		try {
			SysUserDao.insert(SysUser);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void update(SysUser SysUser) throws ServiceException {
		try {
			SysUserDao.update(SysUser);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	 * @����˵��:�޸��û�״̬
	 * @param SysUser
	 * @throws ServiceException 
	 * @see app.creditapp.sys.bo.SysUserBo#updateOpSts(app.creditapp.sys.entity.SysUser)
	 * @�޸�˵��:
	 */
	public void updateUserSts(SysUser SysUser) throws ServiceException {
		try {
			SysUserDao.updateUserSts(SysUser);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	 * @����˵��:�û������޸�
	 * @param pwInfo
	 * @return
	 * @throws ServiceException 
	 * @see app.creditapp.sys.bo.SysUserBo#changePassWord(java.lang.String)
	 * @�޸�˵��:
	 */
	public String changePassWord(String pwInfo) throws ServiceException {
		String prompt = "";
		String[] pwd = pwInfo.split("/");
		String oldpwd = pwd[0];
		String newpwd = pwd[1];
//		String user_no = pwd[2];
		try {
//			String user_no = User.getLoginid(ServletActionContext.getRequest());
//			if(pwd.length == 4 && pwd[3]!=null && pwd[3].length()>0){
//				user_no = pwd[3];
//			}
			SysUser SysUser = new SysUser();
			SysUser.setUser_no(User.getLoginid(ServletActionContext.getRequest()));
			SysUser = SysUserDao.getById(SysUser);
			if(SysUser == null){
				return "����δ��¼��";
			}
//			String rcmes = securityInterface.SecurityChangePwd(SysUser.getUser_no(), pwd[1]);//��ȫ�������У��
//			if(!Boolean.TRUE.toString().equals(rcmes))return rcmes;
			System.out.println(oldpwd);
			System.out.println(SysUser.getPass_word());
			System.out.println(Base64.decodeToString(SysUser.getPass_word()));
			if (oldpwd.equals(Base64.decodeToString(SysUser.getPass_word()))) {
				SysUser.setPass_word(Base64.encodeString(newpwd));
				SysUserDao.update(SysUser);
				return "";
			} else {
				prompt = "ԭʼ�������";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return prompt;
	}
	
	public SysUserDao getSysUserDao() {
		return SysUserDao;
	}

	public void setSysUserDao(SysUserDao SysUserDao) {
		this.SysUserDao = SysUserDao;
	}

		
	//ͨѶ¼
	public Ipage findPageForAddressBook(Ipage ipg, SysUser tou) throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) SysUserDao
					.getCountForAddressBook(tou) });// ��ʼ����ҳ��
			if(tou == null)
				tou = new SysUser();
			tou.setStartNumAndEndNum(ipg);
			ipg.setResult(SysUserDao.findPageForAddressBook(tou));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	public SysUser getByLoginId(SysUser SysUser) throws ServiceException {
		try {
			SysUser = SysUserDao.getByLoginId(SysUser);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return SysUser;
	}
	
	public void updateAddressBookInfo(SysUser SysUser) {
		try {
			SysUserDao.updateAddressBookInfo(SysUser);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void updateSkin(SysUser op) throws ServiceException {
		
		try {
			SysUserDao.updateSkin(op);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findZt(Ipage ipage, SysUser SysUser)
			throws ServiceException {
		try {
			ipage.initPageCounts(new Integer[] { (Integer) SysUserDao
					.getCountZt(SysUser) });// ��ʼ����ҳ��
			SysUser.setStartNumAndEndNum (ipage);
			ipage.setResult(SysUserDao.findZt(SysUser));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipage;
	}

	public BatchExeBo getBatchExeBo() {
		return batchExeBo;
	}

	public void setBatchExeBo(BatchExeBo batchExeBo) {
		this.batchExeBo = batchExeBo;
	}

	public SysUserRoleBo getSysUserRoleBo() {
		return sysUserRoleBo;
	}

	public void setSysUserRoleBo(SysUserRoleBo sysUserRoleBo) {
		this.sysUserRoleBo = sysUserRoleBo;
	}
}