package  app.creditapp.acc.loan.dao;

import java.util.List;

import app.base.DAOException;
import app.creditapp.acc.loan.entity.AcLnLo;
import app.creditapp.inf.entity.WsOut3203_1;
/**
* Title: AcLnLoDao.java
* Description:
**/
public interface AcLnLoDao {

	public AcLnLo getById(AcLnLo acLnLo) throws DAOException;
	
	public AcLnLo getMinLnLo(AcLnLo acLnLo) throws DAOException;

	public void del(AcLnLo acLnLo) throws DAOException;

	public void insert(AcLnLo acLnLo) throws DAOException;

	public void update(AcLnLo acLnLo) throws DAOException;
	
	public int getCount(AcLnLo acLnLo) throws DAOException;

	public List<AcLnLo > findByPage(AcLnLo acLnLo) throws DAOException;
	
	public AcLnLo getLoAmt(AcLnLo acLnLo) throws DAOException;

	public List<AcLnLo > getListByLoanNo(AcLnLo acLnLo) throws DAOException;
	//�ӿ�ws3202��ѯ�����б�
	public List<WsOut3203_1> findByPageforws3203(AcLnLo acLnLo) throws DAOException;
	//�ӿ�ws3202��ѯ���� ��������������
	public int getCountfor3203(AcLnLo acLnLo) throws DAOException;
	//���ݽ�ݺ� ��ͬ�� ������ȡ����
	public List<AcLnLo> getByLoanPactBrNo(AcLnLo acLnLo) throws DAOException;

	public AcLnLo getAcLnLoByCnt(AcLnLo acLnLo);

}