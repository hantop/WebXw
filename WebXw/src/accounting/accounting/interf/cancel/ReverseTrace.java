package accounting.interf.cancel;

import accounting.domain.sys.AfferentDomain;

/**
 * �����������ݴ������
 *
 */
public class ReverseTrace extends AfferentDomain {

		private long reverseTraceNo;	//��������ˮ��

		/**
		 * @return ��������ˮ�� 
		 */
		public long getReverseTraceNo() {
			return reverseTraceNo;
		}

		/**
		 * @����     ��������ˮ��
		 * @param ��������ˮ�� 
		 */
		public void setReverseTraceNo(long reverseTraceNo) {
			this.reverseTraceNo = reverseTraceNo;
		}
		
		
		
}
