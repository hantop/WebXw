package accounting.plat.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import accounting.plat.NumberConstant;

public class NumberUtil {

	
	/**
	 * �����������,������������
	 * 
	 * @param left1 ��ʽ��ߵ�һ��
	 * @param left2 ��ʽ��ߵڶ���
	 * @return
	 */
	public static double rateSubs(double left1, double left2) {
		BigDecimal dec1 = getBigDecimal(left1,
				NumberConstant.DEFAULT_RATE_DIG_COUNT + 1);

		BigDecimal dec2 = getBigDecimal(left2,
				NumberConstant.DEFAULT_RATE_DIG_COUNT + 1);
		BigDecimal dec3 = dec1.subtract(dec2);
		
		return getBigDecimal(dec3).doubleValue();
	}
	
	/**
	 * �����������,������������
	 * 
	 * @param left1 ��ʽ��ߵ�һ��
	 * @param left2 ��ʽ��ߵڶ���
	 * @return
	 */
	public static double rateDiv(double left1, double left2) {
		return div(left1, left2, NumberConstant.DEFAULT_RATE_DIG_COUNT);
	}

	/**
	 * �����������,������������
	 * 
	 * @param left1 ��ʽ��ߵ�һ��
	 * @param left2 ��ʽ��ߵڶ���
	 * @param digCount ����С����λ��
	 * @return
	 */
	public static double rateDiv(double left1, double left2, int digCount) {
		return div(left1, left2, digCount);
	}

	/**
	 * �������
	 * 
	 * @param left1 ��ʽ��ߵ�һ��
	 * @param left2 ��ʽ��ߵڶ���
	 * @return
	 */
	public static double rateMult(double left1, double left2) {
		return mult(left1, left2, NumberConstant.DEFAULT_RATE_DIG_COUNT) ;
	}

	/**
	 * �������
	 * 
	 * @param left1 ��ʽ��ߵ�һ��
	 * @param left2 ��ʽ��ߵڶ���
	 * @param digCount С���㱣��λ��
	 * @return
	 */
	public static double rateMult(double left1, double left2,int digCount) {
		return mult(left1, left2, digCount, RoundingMode.HALF_UP ) ;
	}

	/**
	 * �ж����������Ƿ����
	 * 
	 * @param left1 ��ʽ��ߵ�һ��
	 * @param left2 ��ʽ��ߵڶ���
	 * @return
	 */
	public static boolean isRateEqual(double rate1, double rate0) {
		double result = Math.abs(rateSubs(rate1, rate0));
		
		return getDouble(result, NumberConstant.DEFAULT_RATE_DIG_COUNT) <= NumberConstant.DEFAULT_RATE_COMPARE_VALUE;
	}

	/**
	 * rate1�Ƿ����rate0
	 * 
	 * @param rate1
	 * @param rate0
	 * @return
	 */
	public static boolean isRateGreat(double rate1, double rate0) {
		double result = Math.abs(rateSubs(rate1, rate0));

		return getDouble(result, NumberConstant.DEFAULT_RATE_DIG_COUNT) > NumberConstant.DEFAULT_RATE_COMPARE_VALUE;
	}

	/**
	 * ���������
	 * 
	 * @param left1 ��ʽ��ߵ�һ��
	 * @param left2 ��ʽ��ߵڶ���
	 * @return
	 */
	public static double amtSubs(double left1, double left2) {
		BigDecimal dec1 = getBigDecimal(left1,
				NumberConstant.DEFAULT_AMT_COMPARE_DIG_COUNT + 1);
		BigDecimal dec2 = getBigDecimal(left2,
				NumberConstant.DEFAULT_AMT_COMPARE_DIG_COUNT + 1);
		BigDecimal dec3 = dec1.subtract(dec2);
		
		return getBigDecimal(dec3).doubleValue();
	}

	/**
	 * ��������ˡ�
	 * 
	 * @param left1 ��ʽ��ߵ�һ��
	 * @param left2 ��ʽ��ߵڶ���
	 * @return
	 */
	public static double amtMult(double left1, double left2) {
		return mult(left1, left2, NumberConstant.DEFAULT_AMT_COMPARE_DIG_COUNT) ;
	}
	
	/**
	 * �������˷�
	 * 
	 * @param left1 ��ʽ��ߵ�һ��
	 * @param left2 ��ʽ��ߵڶ���
	 * @param digCount  ����λ��
	 * @param mode      С���㱣����ʽ
	 * 
	 * @return 
	 */
	public static double mult(double left1, double left2, int digCount, RoundingMode mode) {
		BigDecimal dec1 = BigDecimal.valueOf(left1) ;
		BigDecimal dec2 = BigDecimal.valueOf(left2) ;

		BigDecimal dec3 = dec1.multiply(dec2) ;

		dec3 = dec3.setScale(digCount, mode);
		
		return dec3.doubleValue();
	}
	
	/**
	 * ���������,��������
	 * 
	 * @param left1 ��ʽ��ߵ�һ��
	 * @param left2 ��ʽ��ߵڶ���
	 * @param digCount  ����λ��
	 * @return
	 */
	public static double mult(double left1, double left2, int digCount) {
		return mult(left1, left2, digCount, RoundingMode.HALF_UP);
	}

	/**
	 * ���������
	 * 
	 * @param left1 ��ʽ��ߵ�һ��
	 * @param left2 ��ʽ��ߵڶ���
	 * @param digCount  ����λ��
	 * @param roundingMode ����������
	 * @return
	 */
	
	public static double amtMult(double left1, double left2, int digCount, RoundingMode roundingMode) {
		BigDecimal amt = getBigDecimal(left1 * left2, digCount + 1, roundingMode);

		return amt.doubleValue();
	}
	
	public static void main(String[] args) {
		System.out.println(amtMult(0.0345, 0.0345, 3, RoundingMode.HALF_UP));
	}

	/**
	 * ����������,��������
	 * 
	 * @param left1 ��ʽ��ߵ�һ��
	 * @param left2 ��ʽ��ߵڶ���
	 * @param digCount  ����λ��
	 * 
	 * @return 
	 */
	public static double div(double left1, double left2, int digCount){

		return div(left1, left2, digCount, RoundingMode.HALF_UP) ;
	}
	
	/**
	 * �����������
	 * 
	 * @param left1 ��ʽ��ߵ�һ��
	 * @param left2 ��ʽ��ߵڶ���
	 * @param digCount  ����λ��
	 * @param mode      С���㱣����ʽ
	 * 
	 * @return 
	 */
	public static double div(double left1, double left2, int digCount, RoundingMode mode) {
		BigDecimal dec1 = getBigDecimal(left1, digCount+1, mode);
		BigDecimal dec2 = getBigDecimal(left2, digCount+1, mode);
		
		BigDecimal dec3 = dec1.divide(dec2, digCount, mode);
		
		return dec3.doubleValue();
	}

	
	/**
	 * ����������
	 * 
	 * @param left1 ��ʽ��ߵ�һ��
	 * @param left2 ��ʽ��ߵڶ���
	 * 
	 * @return 
	 */
	public static double amtDiv(double left1, double left2) {

		return div(left1, left2, NumberConstant.DEFAULT_AMT_COMPARE_DIG_COUNT);
	}
	
	/**
	 * ����������,����С����λ��
	 * 
	 * @param left1 ��ʽ��ߵ�һ��
	 * @param left2 ��ʽ��ߵڶ���
	 * @param dig С����λ��
	 * 
	 * @return 
	 */
	public static double amtDiv(double left1, double left2, int dig) {

		return div(left1, left2, dig);
	}

	/**
	 * ��ȡ����������
	 * 
	 * @param amt   ���
	 * @return
	 */
	public static double getDouble(double amt) {
		
		return getDouble(amt, RoundingMode.HALF_UP) ;
	}

	/**
	 * ���ո�ʽ����ȡ���
	 * 
	 * @param amt    ���
	 * @param mode   С���㱣����ʽ
	 * @return
	 */
	public static double getDouble(double amt, RoundingMode mode) {
		BigDecimal dec1 = BigDecimal.valueOf(amt);
		dec1 = dec1.setScale(NumberConstant.DEFAULT_AMT_COMPARE_DIG_COUNT, mode);
		
		return dec1.doubleValue();
	}

	/**
	 * ��ȡ��Сֵ��
	 * 
	 * @param amt0
	 * @param amt1
	 * @return
	 */
	public static double getMin(double amt0, double amt1) {
		if (isAmtGreat(amt1, amt0)) {
			return amt0;
		}// С�ڵ���
		return amt1;
	}
	
	/**
	 * ָ������λ�����������롣
	 * 
	 * @param amt        ��� 
	 * @param digCount   С���㱣��λ��
	 * @return double
	 */
	public static double getDouble(double amt, int digCount) {
		
		return getDouble(amt, digCount, RoundingMode.HALF_UP) ;
	}

	/**
	 * ָ������λ����С���㱣����ʽ��
	 * 
	 * @param amt        ��� 
	 * @param digCount   С���㱣��λ��
	 * @param mode   	 С���㱣����ʽ
	 * @return double
	 */
	public static double getDouble(double amt, int digCount, RoundingMode mode) {
		BigDecimal dec1 = BigDecimal.valueOf(amt);
		dec1 = dec1.setScale(digCount, mode);
		
		return dec1.doubleValue();
	}
	
	/**
	 * ָ������λ�����������롣
	 * 
	 * @param amt        ��� 
	 * @param digCount   С���㱣��λ��
	 * 
	 * @return BigDecimal
	 */
	public static BigDecimal getBigDecimal(double amt, int digCount) {
		BigDecimal dec1 = getBigDecimal(amt, digCount, RoundingMode.HALF_UP);
		
		return dec1;
	}

	/**
	 * ָ������λ����С���㱣����ʽ��
	 * 
	 * @param amt        ��� 
	 * @param digCount   С���㱣��λ��
	 * @param mode   	 С���㱣����ʽ
	 * 
	 * @return BigDecimal
	 */
	public static BigDecimal getBigDecimal(double amt, int digCount, RoundingMode mode) {
		BigDecimal dec1 = BigDecimal.valueOf(amt);
		dec1 = dec1.setScale(digCount, mode);
		
		return dec1;
	}

	/**
	 * doubleתBigDecimal��Ĭ�Ͻ���λ����������
	 * 
	 * @param amt        ��� 
	 * 
	 * @return BigDecimal
	 */
	public static BigDecimal getBigDecimal(double amt) {
		BigDecimal dec1 = getBigDecimal(amt, RoundingMode.HALF_UP);
		
		return dec1;
	}

	/**
	 * doubleתBigDecimal��Ĭ�Ͻ���λ��
	 * 
	 * @param amt        ��� 
	 * @param mode       С���㱣����ʽ
	 * 
	 * @return BigDecimal
	 */
	public static BigDecimal getBigDecimal(double amt, RoundingMode mode) {
		BigDecimal dec1 = BigDecimal.valueOf(amt);
		dec1 = dec1.setScale(NumberConstant.DEFAULT_AMT_COMPARE_DIG_COUNT, mode);
		
		return dec1;
	}

	/**
	 * BigDecimal�������룬����Ĭ�Ͻ��λ��
	 * 
	 * @param amt        ��� 
	 * 
	 * @return BigDecimal
	 */
	public static BigDecimal getBigDecimal(BigDecimal amt) {
		amt = getBigDecimal(amt, RoundingMode.HALF_UP);
		
		return amt;
	}

	/**
	 * BigDecimal������Ĭ�Ͻ��λ��
	 * 
	 * @param amt        ���
	 * @param mode       С���㱣����ʽ 
	 * 
	 * @return BigDecimal
	 */
	public static BigDecimal getBigDecimal(BigDecimal amt, RoundingMode mode) {
		amt = amt.setScale(NumberConstant.DEFAULT_AMT_COMPARE_DIG_COUNT, mode);
		
		return amt;
	}

	/**
	 * �������
	 * @param left1 ��ʽ��ߵ�һ��
	 * @param left2 ��ʽ��ߵڶ���
	 * @return
	 */
	public static double amtAdd(double left1, double left2) {
		
		BigDecimal dec1 = getBigDecimal(left1,
				NumberConstant.DEFAULT_AMT_COMPARE_DIG_COUNT + 1);
		BigDecimal dec2 = getBigDecimal(left2,
				NumberConstant.DEFAULT_AMT_COMPARE_DIG_COUNT + 1);
		BigDecimal dec3 = dec1.add(dec2);
		
		return getBigDecimal(dec3).doubleValue();
	}

	/**
	 * ��һ�����ǱȽϵڶ����� ������>�ұ߷���1 ������ ����0 ������<�ұ߷��ظ���
	 * 
	 * @param left1
	 * @param left2
	 * @return
	 */
	public static int amtCompare(double left1, double left2) {
		double result = amtSubs(left1, left2);
		if (result > NumberConstant.DEFAULT_AMOUNT_ZERO_VALUE) {
			return 1;
		}
		if (Math.abs(result) <= NumberConstant.DEFAULT_AMOUNT_ZERO_VALUE)
			return 0;
		return -1;
	}
	/**
	 * �ж���������Ƿ���ȣ�����true��false
	 * 
	 * @param amt1
	 * @param amt2
	 * 
	 * @return boolean
	 */
	public static boolean isAmtEqual(double amt1, double amt0) {
		double result = Math.abs(amtSubs(amt1, amt0));
		return getDouble(result, 2) < NumberConstant.DEFAULT_AMOUNT_ZERO_VALUE;
	}

	/**
	 * ��һ�����Ƿ���ڵڶ�����������true��false
	 * 
	 * @param amt1
	 * @param amt0
	 * 
	 * @return boolean
	 */
	public static boolean isAmtGreat(double amt1, double amt0) {
		double result = amtSubs(amt1, amt0);
		if (result > NumberConstant.DEFAULT_AMOUNT_ZERO_VALUE) {
			return true;
		}
		return false;
	}

	/**
	 * ��һ�����Ƿ���ڵ��ڵڶ�����������true��false
	 * 
	 * @param amt1
	 * @param amt0
	 * 
	 * @return boolean
	 */
	public static boolean isAmtGreatAndEqual(double amt1, double amt0) {
		double result = amtSubs(amt1, amt0);
		if (result >= -NumberConstant.DEFAULT_AMOUNT_ZERO_VALUE) {
			return true;
		}
		return false;
	}

	/**
	 * ��һ�����Ƿ���ڵ��ڵڶ�����������true��false
	 * 
	 * @param amt1
	 * @param amt0
	 * 
	 * @return boolean
	 */
	public static boolean isAmtGreatEqual(double amt1, double amt0) {
		return isAmtGreatAndEqual(amt1, amt0);
	}

	/**
	 * �жϽ���Ƿ����0������true��false
	 * 
	 * @param amt
	 * 
	 * @return boolean
	 */
	public static boolean isAmtGreatThanZero(double amt) {
		if (amt > NumberConstant.DEFAULT_AMOUNT_ZERO_VALUE) {
			return true;
		}
		return false;
	}
	
	/**
	 * �жϽ���Ƿ�С��0������true��false
	 * 
	 * @param amt
	 * 
	 * @return boolean
	 */
	public static boolean isAmtLessThanZero(double amt) {
		return amt < -NumberConstant.DEFAULT_AMOUNT_ZERO_VALUE;
	}

	/**
	 * �ж�һ������Ƿ�<=0;
	 * 
	 * @param amt
	 * 
	 * @return boolean
	 */
	public static boolean isAmtLessThanOrEqualZero(double amt) {
		if (amt <= NumberConstant.DEFAULT_AMOUNT_ZERO_VALUE) {
			return true;
		}
		return false;
	}

	/**
	 * �жϽ���Ƿ�=0,����true��false
	 * 
	 * @param amt
	 * 
	 * @return boolean
	 */
	public static boolean isAmtEqualZero(double amt) {
		if (Math.abs(amt) <= NumberConstant.DEFAULT_AMOUNT_ZERO_VALUE) {
			return true;
		}
		return false;
	}

	/**
	 * ��ʽ����������
	 * 
	 * @param d
	 * @param count��λ
	 * @return
	 */
	public static String formatDec(double d, int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append("0");
		}
		NumberFormat format = new DecimalFormat("#0." + sb.toString());
		return format.format(d);
	}

}
