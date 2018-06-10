package app.creditapp.acc.option.dao.impl;

import java.util.List;
import java.util.Map;

import accounting.domain.sys.AcComHoliday;
import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.creditapp.acc.option.dao.AcComHolidayDao;

public class AcComHolidayDaoImpl extends BaseIbatisDao implements
		AcComHolidayDao {

	public void del(AcComHoliday acComHoliday) throws DAOException {
		try {
			System.out.println(getSqlMapClientTemplate().delete("AcComHoliday.del", acComHoliday));
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("ɾ��ʧ��");
		}
	}

	public AcComHoliday find(AcComHoliday acComHoliday) throws DAOException {
		try {
			acComHoliday = (AcComHoliday) this.getSqlMapClientTemplate().queryForList("AcComHoliday.find",acComHoliday);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯʧ��");
		}
		return acComHoliday;	
	}

	public List<AcComHoliday> findByPage(Map map) throws DAOException {
		List<AcComHoliday> acComHolidayList = null;
	    try {
	    	acComHolidayList = this.getSqlMapClientTemplate().queryForList("AcComHoliday.findByPage",map);
	    } catch (Exception e) {
	      log.error(e);
	      throw new DAOException("��ҳ��ѯʧ��");
	    }
	    return acComHolidayList;
	}

	public AcComHoliday getById(AcComHoliday acComHoliday) throws DAOException {
		try {
			acComHoliday = (AcComHoliday) this.getSqlMapClientTemplate().queryForObject("AcComHoliday.getById",acComHoliday);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯʧ��");
		}
		return acComHoliday;
	}
	
	public AcComHoliday getByDay(String day) throws DAOException {
		AcComHoliday acComHoliday = new AcComHoliday();
		try {
			acComHoliday = (AcComHoliday) this.getSqlMapClientTemplate().queryForObject("AcComHoliday.getByDay",day);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯʧ��");
		}
		return acComHoliday;
	}

	public int getCount(AcComHoliday acComHoliday) throws DAOException {
		int count = 0;
	    try {
	      count = (Integer)getSqlMapClientTemplate().queryForObject("AcComHoliday.findPage.count",acComHoliday);
	    } catch (Exception e) {
	      log.error(e);
	      throw new DAOException("��ѯͳ��ʧ��");
	    }
	    return count;
	}

	public void insert(AcComHoliday acComHoliday) throws DAOException {
		try {
		      getSqlMapClientTemplate().insert("AcComHoliday.insert", acComHoliday);
		    }catch (Exception e) {
		      log.error(e);
		      throw new DAOException("����ʧ��");
		    }
	}

	public void update(AcComHoliday acComHoliday) throws DAOException {
		try {
		      getSqlMapClientTemplate().insert("AcComHoliday.update", acComHoliday);
		    } catch (Exception e) {
		      log.error(e);
		      throw new DAOException("����ʧ��");
		    } 
	}
	
	public void delByBegDt(String begDt) throws DAOException {
		try {
			getSqlMapClientTemplate().delete("AcComHoliday.delByBegDt", begDt);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}
	
	public List<AcComHoliday> getListByBegDt(String begDt) throws DAOException {
		List acComHolidayList = null;
		try {
			acComHolidayList = getSqlMapClientTemplate().queryForList(
					"AcComHoliday.getListByBegDt", begDt);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return acComHolidayList;
	}
	public List<AcComHoliday> findHolidayBySysDate(String sysDate){
		List acComHolidayList = null;
		try {
			acComHolidayList = getSqlMapClientTemplate().queryForList(
					"AcComHoliday.findHolidayBySysDate", sysDate);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return acComHolidayList;
	}
}
