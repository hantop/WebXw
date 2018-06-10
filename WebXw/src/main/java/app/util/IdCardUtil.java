package app.util;

import java.text.NumberFormat;
import java.util.Random;

/** */
/**
 * 
 */
public class IdCardUtil {
	// λȨֵ����
	private static byte[] Wi = new byte[17];
	// ���֤ǰ�����ַ���
	private static final byte fPart = 6;
	// ���֤�㷨��ģ�ؼ�ֵ
	private static final byte fMod = 11;
	// �����֤����
	private static final byte oldIDLen = 15;
	// �����֤����
	private static final byte newIDLen = 18;
	// �����֤��ݱ�־
	private static final String yearFlag = "19";
	// У���봮
	private static final String CheckCode = "10X98765432";
	// ��С������������
	private static final int minCode = 150000;
	// ��������������
	private static final int maxCode = 700000;

	private static void setWiBuffer() {
		for (int i = 0; i < Wi.length; i++) {
			int k = (int) Math.pow(2, (Wi.length - i));
			Wi[i] = (byte) (k % fMod);
		}
	}

	// ��ȡ�����֤�����һλ:����λ
	private static String getCheckFlag(String idCard) {
		int sum = 0;
		// ���м�Ȩ���
		for (int i = 0; i < 17; i++) {
			sum += Integer.parseInt(idCard.substring(i, i + 1)) * Wi[i];
		}
		// ȡģ���㣬�õ�ģֵ
		byte iCode = (byte) (sum % fMod);
		return CheckCode.substring(iCode, iCode + 1);
	}

	// �жϴ����ȵĺϷ���
	private static boolean checkLength(final String idCard, boolean newIDFlag) {
		// �ж��ǲ�����Ч�� λ��
		boolean right = (idCard.length() == oldIDLen) || (idCard.length() == newIDLen);
		return right;
	}

	// ��ȡʱ�䴮
	public static String getIDDate(final String idCard, boolean newIDFlag) {
		String dateStr = "";
		if (newIDFlag)
			dateStr = idCard.substring(fPart, fPart + 8);
		else
			dateStr = yearFlag + idCard.substring(fPart, fPart + 6);
		return dateStr;
	}

	// �ж�ʱ��Ϸ���
	private static boolean checkDate(final String dateSource) {
		String dateStr = dateSource.substring(0, 4) + "-" + dateSource.substring(4, 6) + "-"
				+ dateSource.substring(6, 8);
		System.out.println(dateStr);
		boolean a = false;
		boolean b = false;
		String year = dateSource.substring(0, 4);
		int years = Integer.parseInt(year);
		String month = dateSource.substring(4, 6);
		int months = Integer.parseInt(month);
		String day = dateSource.substring(6, 8);
		int days = Integer.parseInt(day);
		if (years % 4 == 0 && years % 100 != 0 || years % 400 == 0) {// �ж��ǲ�������
			b = true;
		} else {
			b = false;
		}
		if (months <= 12) {
			if (b) {
				if (months == 2) {// ����2��
					if (days <= 29) {
						a = true;
					} else {
						a = false;
					}
				}
			} else {
				if (months == 2) {// ������2��
					if (days <= 28) {
						a = true;
					} else {
						a = false;
					}
				}
			}

			if (months == 1 || months == 3 || months == 5 || months == 7 || months == 8 || months == 10 || months == 12) {
				if (days <= 31) {
					a = true;
				} else {
					a = false;
				}
			} else if (months != 2) {
				if (days <= 30) {
					a = true;
				} else {
					a = false;
				}
			}
		} else {
			a = false;
		}

		return a;
	}

	// �����֤ת���������֤����
	public static String getNewIDCard(final String oldIDCard) {
		// ��ʼ������
		IdCardUtil.setWiBuffer();
		if (!checkIDCard(oldIDCard)) {
			return oldIDCard;
		}
		String newIDCard = oldIDCard.substring(0, fPart);
		newIDCard += yearFlag;
		newIDCard += oldIDCard.substring(fPart, oldIDCard.length());
		String ch = getCheckFlag(newIDCard);
		newIDCard += ch;
		return newIDCard;
	}

	// �����֤ת���ɾ����֤����
	public static String getOldIDCard(final String newIDCard) {
		// ��ʼ������
		IdCardUtil.setWiBuffer();
		String oldIDCard = newIDCard.substring(0, fPart)
				+ newIDCard.substring(fPart + yearFlag.length(), newIDCard.length() - 1);
		return oldIDCard;
	}

	// �ж����֤����ĺϷ���
	public static boolean checkIDCard(String idCard) {
		// ��ʼ������
		IdCardUtil.setWiBuffer();
		boolean isNew = false;
		boolean a = true;
		if (!checkLength(idCard, isNew)) {//ID�����쳣
			a = false;
		} else {
			isNew = (idCard.length() == newIDLen);
			String idDate = getIDDate(idCard, isNew);
			if (!checkDate(idDate)) {//IDʱ���쳣
				a = false;
			}
			if (isNew) {
				String checkFlag = getCheckFlag(idCard);
				String theFlag = idCard.substring(idCard.length() - 1, idCard.length());
				if (!checkFlag.equals(theFlag)) {//�����֤У��λ�쳣
					a = false;
				}
			}
		}
		return a;
	}

	// �ж����֤����ĺϷ��� Ϊ�˴�����ִ�����ʾ
	public static String checkIDCard2(String idCard) {
		// ��ʼ������
		IdCardUtil.setWiBuffer();
		boolean isNew = false;
		if (!checkLength(idCard, isNew)) {//ID�����쳣
			return "1";
		} else {
			isNew = (idCard.length() == newIDLen);
			String idDate = getIDDate(idCard, isNew);
			if (!checkDate(idDate)) {//IDʱ���쳣
				return "2";
			} else {
				if (isNew) {
					String checkFlag = getCheckFlag(idCard);
					String theFlag = idCard.substring(idCard.length() - 1, idCard.length());
					if (!checkFlag.equals(theFlag)) {//�����֤У��λ�쳣
						return "3";
					}
				}
			}
		}
		return "5";
	}

	// ��ȡһ�������"α"���֤����
	public static String getRandomIDCard(final boolean idNewID) {
		// ��ʼ������
		IdCardUtil.setWiBuffer();
		Random ran = new Random();
		String idCard = getAddressCode(ran) + getRandomDate(ran, idNewID) + getIDOrder(ran);
		if (idNewID) {
			String ch = getCheckFlag(idCard);
			idCard += ch;
		}
		return idCard;
	}

	// ��������ĵ�������
	private static String getAddressCode(Random ran) {
		if (ran == null) {
			return "";
		} else {
			int addrCode = minCode + ran.nextInt(maxCode - minCode);
			return Integer.toString(addrCode);
		}
	}

	// ��������ĳ�������
	private static String getRandomDate(Random ran, boolean idNewID) {
		if (ran == null) {
			return "";
		}
		int year = 0;
		if (idNewID) {
			year = 1900 + ran.nextInt(2007 - 1900);
		} else {
			year = 1 + ran.nextInt(99);
		}
		int month = 1 + ran.nextInt(12);
		int day = 0;
		if (month == 2) {
			day = 1 + ran.nextInt(28);
		} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			day = 1 + ran.nextInt(31);
		} else {
			day = 1 + ran.nextInt(30);
		}
		NumberFormat nf = NumberFormat.getIntegerInstance();
		nf.setMaximumIntegerDigits(2);
		nf.setMinimumIntegerDigits(2);
		String dateStr = Integer.toString(year) + nf.format(month) + nf.format(day);
		return dateStr;
	}

	// ������������к�
	private static String getIDOrder(Random ran) {
		NumberFormat nf = NumberFormat.getIntegerInstance();
		nf.setMaximumIntegerDigits(3);
		nf.setMinimumIntegerDigits(3);
		if (ran == null) {
			return "";
		} else {
			int order = 1 + ran.nextInt(999);
			return nf.format(order);
		}
	}
	
	/**
	 * ���������������֤���ж��Ա� true �� false Ů add by zhaomin date 2011-07-14
	 */
	public static String getSexFromIdCard(String idCard) {
		char temp;
		int temp_int;
		if (idCard.length() == 18) {
			temp = idCard.charAt(16);
		} else {
			temp = idCard.charAt(14);
		}
		temp_int = Integer.valueOf(temp) % 2;
		if (temp_int == 0) {
			return "1";
		} else {
			return "0";
		}
	}
	//�������֤�Ż�ȡ��������
    public static String getBirthdayFromIdCard(String idCard){
    	if(idCard != null){
    		if(idCard.length() == 18){
    			return idCard.substring(6,14);
    		}else {
				return "19" + idCard.substring(6,12);
			}
    	}else {
			return null;
		}
	
	
}
	
	public IdCardUtil() {
		setWiBuffer();
	}

	public static void main(String[] args) {
		String randomID = IdCardUtil.getRandomIDCard(true);
		System.out.println("������֤��" + randomID);
	}
}