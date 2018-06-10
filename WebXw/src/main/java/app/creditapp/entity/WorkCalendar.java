package app.creditapp.entity;

import app.base.BaseDomain;
      
public class WorkCalendar extends BaseDomain implements java.io.Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public WorkCalendar(){}
//��������
private String make_date;            //��������
private String make_man;             //������
private String title;                //����
private String event_type;           //�¼����ͣ�'1':'�����ƻ�','2':'�ճ̰���','3':'��������','4':'����¼','5':'�����ճ�'��
private String event_date;           //�¼�����
private String event_time;           //�¼�ʱ��
private String event_desc;           //�¼�˵��
private String warn_setup;           //�������ã�'1':'������','2':'��������'��
private String warn_date;            //��������
private String warn_time;            //����ʱ��
private String warn_stop;            //������ֹ
private String end_sts;              //���״̬��1����ɣ�2��δ��ɣ�
private String filler;               //��ע
private String calendar_no;          //�ճ̱��
private String day;					 //��ǰ���� 
private String event_lev;            //�¼��ȼ� 1:���� 2:��Ҫ 3:һ��
public String getMake_date() {
	return make_date;
}
public void setMake_date(String make_date) {
	this.make_date = make_date;
}
public String getMake_man() {
	return make_man;
}
public void setMake_man(String make_man) {
	this.make_man = make_man;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getEvent_type() {
	return event_type;
}
public void setEvent_type(String event_type) {
	this.event_type = event_type;
}
public String getEvent_date() {
	return event_date;
}
public void setEvent_date(String event_date) {
	this.event_date = event_date;
}
public String getEvent_time() {
	return event_time;
}
public void setEvent_time(String event_time) {
	this.event_time = event_time;
}
public String getEvent_desc() {
	return event_desc;
}
public void setEvent_desc(String event_desc) {
	this.event_desc = event_desc;
}
public String getWarn_setup() {
	return warn_setup;
}
public void setWarn_setup(String warn_setup) {
	this.warn_setup = warn_setup;
}
public String getWarn_date() {
	return warn_date;
}
public void setWarn_date(String warn_date) {
	this.warn_date = warn_date;
}
public String getWarn_time() {
	return warn_time;
}
public void setWarn_time(String warn_time) {
	this.warn_time = warn_time;
}
public String getWarn_stop() {
	return warn_stop;
}
public void setWarn_stop(String warn_stop) {
	this.warn_stop = warn_stop;
}
public String getEnd_sts() {
	return end_sts;
}
public void setEnd_sts(String end_sts) {
	this.end_sts = end_sts;
}
public String getFiller() {
	return filler;
}
public void setFiller(String filler) {
	this.filler = filler;
}
public String getCalendar_no() {
	return calendar_no;
}
public void setCalendar_no(String calendar_no) {
	this.calendar_no = calendar_no;
}
public static long getSerialVersionUID() {
	return serialVersionUID;
}
public String getDay() {
	return day;
}
public void setDay(String day) {
	this.day = day;
}
public String getEvent_lev() {
	return event_lev;
}
public void setEvent_lev(String event_lev) {
	this.event_lev = event_lev;
}

}
