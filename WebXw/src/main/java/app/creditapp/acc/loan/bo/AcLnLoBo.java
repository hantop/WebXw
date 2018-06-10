package  app.creditapp.acc.loan.bo;

import java.util.List;

import app.base.ServiceException;
import app.creditapp.acc.loan.entity.AcLnLo;
import app.creditapp.inf.entity.ResponseParm;
import app.creditapp.inf.entity.WsIn3203;
import app.creditapp.inf.entity.WsOut3203_1;
import app.util.toolkit.Ipage;

/**
* Title: AcLnLoBo.java
* Description:
**/
public interface AcLnLoBo {

	public AcLnLo getById(AcLnLo acLnLo) throws ServiceException;
	
	public AcLnLo getLoAmt(AcLnLo acLnLo) throws ServiceException;

	public void del(AcLnLo acLnLo) throws ServiceException;

	public void insert(AcLnLo acLnLo) throws ServiceException;

	public void update(AcLnLo acLnLo) throws ServiceException;

	public Ipage findByPage(Ipage ipg, AcLnLo acLnLo) throws ServiceException;
	//�ӿ�ws3203У��
	public ResponseParm getresponseParm(WsIn3203 wsIn3203)throws ServiceException;
	//�ӿ�ws3203���ϲ������� ���ط�ҳ��Ϣ
	public Ipage findByPageforws3203(Ipage ipg, AcLnLo acLnLo)throws ServiceException;
	//�ӿ�ws3203���ϲ������� ������������
	public int  getCountforws3203(AcLnLo acLnLo) throws ServiceException;

	public AcLnLo getAcLnLoByCnt(AcLnLo acLnLo);

}