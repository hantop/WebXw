package app.creditapp.trade.entity;
import app.base.BaseDomain;
/**
* Title: CipRule.java
* Description:
* @version��1.0
**/
public class CipRule extends BaseDomain {
	private String rule_no;//������
	private String trade_id;//���׺�
	private String col_name;//�ֶ���
	private String ch_col;//�����ֶ�CH_COL
	private String rule_type;//�ֶδ�������
	private String col_length;//����
	private String dec_length;//С�����0�ĸ���
	private String if_param;//�Ƿ��������
	private String if_send;//�Ƿ����ֶ� 1��0��
	private String key_col;//��ǩ�ֶ�
	private String trade_name;//������

	/**
	 * @return ������
	 */
	public String getRule_no() {
	 	return rule_no;
	}
	/**
	 * @���� ������
	 * @param rule_no
	 */
	public void setRule_no(String rule_no) {
	 	this.rule_no = rule_no;
	}
	/**
	 * @return ���׺�
	 */
	public String getTrade_id() {
	 	return trade_id;
	}
	/**
	 * @���� ���׺�
	 * @param trade_id
	 */
	public void setTrade_id(String trade_id) {
	 	this.trade_id = trade_id;
	}
	/**
	 * @return �ֶ���
	 */
	public String getCol_name() {
	 	return col_name;
	}
	/**
	 * @���� �ֶ���
	 * @param col_name
	 */
	public void setCol_name(String col_name) {
	 	this.col_name = col_name;
	}
	/**
	 * @return �����ֶ�
	 */
	public String getCh_col() {
	 	return ch_col;
	}
	/**
	 * @���� �����ֶ�
	 * @param ch_col
	 */
	public void setCh_col(String ch_col) {
	 	this.ch_col = ch_col;
	}
	/**
	 * @return �ֶδ�������
	 */
	public String getRule_type() {
	 	return rule_type;
	}
	/**
	 * @���� �ֶδ�������
	 * @param rule_type
	 */
	public void setRule_type(String rule_type) {
	 	this.rule_type = rule_type;
	}
	/**
	 * @return ����
	 */
	public String getCol_length() {
	 	return col_length;
	}
	/**
	 * @���� ����
	 * @param col_length
	 */
	public void setCol_length(String col_length) {
	 	this.col_length = col_length;
	}
	/**
	 * @return С�����0�ĸ���
	 */
	public String getDec_length() {
	 	return dec_length;
	}
	/**
	 * @���� С�����0�ĸ���
	 * @param dec_length
	 */
	public void setDec_length(String dec_length) {
	 	this.dec_length = dec_length;
	}
	/**
	 * @return �Ƿ��������
	 */
	public String getIf_param() {
	 	return if_param;
	}
	/**
	 * @���� �Ƿ��������
	 * @param if_param
	 */
	public void setIf_param(String if_param) {
	 	this.if_param = if_param;
	}
	/**
	 * @return �Ƿ����ֶ� 1��0��
	 */
	public String getIf_send() {
	 	return if_send;
	}
	/**
	 * @���� �Ƿ����ֶ� 1��0��
	 * @param if_send
	 */
	public void setIf_send(String if_send) {
	 	this.if_send = if_send;
	}
	/**
	 * @return ��ǩ�ֶ�
	 */
	public String getKey_col() {
	 	return key_col;
	}
	/**
	 * @���� ��ǩ�ֶ�
	 * @param key_col
	 */
	public void setKey_col(String key_col) {
	 	this.key_col = key_col;
	}
	public String getTrade_name() {
		return trade_name;
	}
	public void setTrade_name(String trade_name) {
		this.trade_name = trade_name;
	}
}