package app.creditapp.pac.bo;

import java.util.List;

import app.base.ServiceException;
import app.creditapp.pac.entity.PacBase;
import app.util.toolkit.Ipage;

/**
 * Title: PacBaseBo.java Description:
 * 
 **/
public interface PacBaseBo {

//    public PacBase getById(PacBase pacBase) throws ServiceException;
//
//    public void del(PacBase pacBase) throws ServiceException;

    public void insert(PacBase pacBase) throws ServiceException;

//    public void update(PacBase pacBase) throws ServiceException;
//
//    public Ipage findByPage(Ipage ipg, PacBase pacBase) throws ServiceException;
//
//    /**
//     * @����˵��: ��������ѯ����Ӱ��洢��Ϣ
//     * @param pacBase
//     * @return
//     * @return List<PacBase>
//     * @�޸�˵��:
//     */
//    public List<PacBase> listPacBase(PacBase pacBase) throws ServiceException;
//
//    /**
//     * @����˵��: �������ش���
//     * @param pacId
//     * @return  void
//     * @�޸�˵��:
//     */
//    public void updateDownCnt(String pacId) throws ServiceException;
//    
//    /**
//     * ��ȡ���µ�һ����¼
//     * @param pacBase
//     * @return
//     * @throws ServiceException
//     */
//    public PacBase getLastPacBase(PacBase pacBase) throws ServiceException;
//    
//    //��ȡҵ����
//    public PacBase getBusiNo(String pac_type_no,String busi_no,String pacScene, PacBase pac) throws ServiceException;
//    
//    //��ȡ��ɫ���ڳ�����ӦӰ����Ƿ�ֻ��Ȩ��
//    public String getReadOnly(String role_no, String pacScene) throws ServiceException;
//    
//    public List<PacBase> getyn(PacBase pacBase) throws ServiceException;
//    
//    public int getCount(PacBase pacBase) throws ServiceException;

}