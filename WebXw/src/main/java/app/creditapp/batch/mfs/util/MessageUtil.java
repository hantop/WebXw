package app.creditapp.batch.mfs.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.text.SimpleDateFormat;

import app.util.DBUtils;

public class MessageUtil {

	public void sendMail(String email, String title, String msg) {
		Connection conn = null;
		CallableStatement proc = null;
		//long time = new java.util.Date().getTime();
		System.out.println("MAIL=="+msg);
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date endDate = new java.util.Date(date.getTime()+1000*60);
		try {
			conn = DBUtils.getMessageConnection();
			proc = conn.prepareCall("{ call PORTAL.SEND_INFORMATION(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?) }"); // ���ô洢����
			proc.setString(1, title);// ���ѱ���
			proc.setString(2, msg);// �ı�����
			proc.setString(3, "");// html��������
			proc.setString(4, "");// ������Ϣ·��
			proc.setDate(5, new java.sql.Date(date.getTime()));// ��Ϣ��������
			proc.setDate(6, java.sql.Date.valueOf(sdf.format(date)));// ������Ч��ʼ����
			proc.setDate(7, java.sql.Date.valueOf(sdf.format(endDate)));// ������Ч��������
			proc.setString(8, "");// ��������
			proc.setString(9, "");// ҵ������
			proc.setString(10, "3");// ϵͳID
			proc.setString(11, "");// ��ȫ��
			proc.setString(12, "BITIC");// ���ѷ�����ID
			proc.setString(13, "system");// ����������
			proc.setString(14, "");// URL
			proc.setInt(15, 2);// ��Ϣ��Դ��Ŀ
			proc.setString(16, "1");// ���Ѽ���
			proc.setString(17, "2");// �������� 2�ʼ� 3����
			proc.setString(18, "5");// ���ͷ�Χ 4�ڲ���Ա��5�ⲿ��Ա
			proc.setString(19, "");// ���ͷ�Χֵ
			proc.setString(20, email);// ������ɫ
			proc.registerOutParameter(21, Types.INTEGER);// �ڶ��������������,��VARCHAR���͵�
			proc.execute();// ִ��
			int rv = proc.getInt(21);
			System.out.println("rv=="+rv);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	}

	public void sendMsg(String telNo, String title, String msg) {
		Connection conn = null;
		CallableStatement proc = null;
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date endDate = new java.util.Date(date.getTime()+1000*60);
		try {
			conn = DBUtils.getMessageConnection();
			proc = conn.prepareCall("{ call PORTAL.SEND_INFORMATION(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?) }"); // ���ô洢����
			proc.setString(1, title);// ���ѱ���
			proc.setString(2, msg);// �ı�����
			proc.setString(3, "");// html��������
			proc.setString(4, "");// ������Ϣ·��
			proc.setDate(5, new java.sql.Date(date.getTime()));// ��Ϣ��������
			proc.setDate(6, java.sql.Date.valueOf(sdf.format(date)));// ������Ч��ʼ����
			proc.setDate(7, java.sql.Date.valueOf(sdf.format(endDate)));// ������Ч��������
			proc.setString(8, "");// ��������
			proc.setString(9, "");// ҵ������
			proc.setString(10, "3");// ϵͳID
			proc.setString(11, "");// ��ȫ��
			proc.setString(12, "BITIC");// ���ѷ�����ID
			proc.setString(13, "system");// ����������
			proc.setString(14, "");// URL
			proc.setInt(15, 2);// ��Ϣ��Դ��Ŀ
			proc.setString(16, "1");// ���Ѽ���
			proc.setString(17, "3");// �������� 3����
			proc.setString(18, "5");// ���ͷ�Χ 4�ڲ���Ա��5�ⲿ��Ա
			proc.setString(19, "");// ���ͷ�Χֵ
			proc.setString(20, telNo);// ������ɫ
			proc.registerOutParameter(21, Types.INTEGER);// �ڶ��������������,��VARCHAR���͵�
			proc.execute();// ִ��
			int rv = proc.getInt(21);
			System.out.println("rv=="+rv);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	}
	
	public static void main(String[] args) {
		//new MessageUtil().sendMsg("���Ʒ�#13615380539", "С΢ϵͳ����ִ�гɹ�", "С΢ϵͳ����ִ�гɹ���ʱ�䣺2016.12.14.15.54");
		new MessageUtil().sendMail("С΢ϵͳ����#wsftc001@163.com", "С΢ϵͳ����ִ�гɹ�", "С΢ϵͳ����ִ�гɹ���ʱ�䣺2016.12.14 15.54");
	}
}
