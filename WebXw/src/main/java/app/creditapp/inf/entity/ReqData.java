package app.creditapp.inf.entity;
import java.util.List;


/**
* Title: AllocateReg.java
* @version��1.0
**/
public class ReqData  {

	private MainTransactionCommonDTO  mainTransactionCommonDTO;   //������Ϣ             
	private List<DetailTransactionCommonDTO>  detailTransactionCommonDTOList;      //������ϸlist
	private String  businessFlag;//ҵ���ʾ   
	private String  autoSyncFlag ;//�Զ�ͬ�����������ʾ   
	
	/**
	 * @return the mainTransactionCommonDTO
	 */
	public MainTransactionCommonDTO getMainTransactionCommonDTO() {
		return mainTransactionCommonDTO;
	}
	/**
	 * @param mainTransactionCommonDTO the mainTransactionCommonDTO to set
	 */
	public void setMainTransactionCommonDTO(
			MainTransactionCommonDTO mainTransactionCommonDTO) {
		this.mainTransactionCommonDTO = mainTransactionCommonDTO;
	}
	/**
	 * @return the detailTransactionCommonDTOList
	 */
	public List<DetailTransactionCommonDTO> getDetailTransactionCommonDTOList() {
		return detailTransactionCommonDTOList;
	}
	/**
	 * @param detailTransactionCommonDTOList the detailTransactionCommonDTOList to set
	 */
	public void setDetailTransactionCommonDTOList(
			List<DetailTransactionCommonDTO> detailTransactionCommonDTOList) {
		this.detailTransactionCommonDTOList = detailTransactionCommonDTOList;
	}
	/**
	 * @return the businessFlag
	 */
	public String getBusinessFlag() {
		return businessFlag;
	}
	/**
	 * @param businessFlag the businessFlag to set
	 */
	public void setBusinessFlag(String businessFlag) {
		this.businessFlag = businessFlag;
	}
	public String getAutoSyncFlag() {
		return autoSyncFlag;
	}
	public void setAutoSyncFlag(String autoSyncFlag) {
		this.autoSyncFlag = autoSyncFlag;
	}
	
}