package app.creditapp.batch.veiw;

/**
 *  ��������ҵ��Ϣ���� ������
 */
public class BatchMessage {
	private static StringBuilder msg = null; // ��̬�����ڴ�����
	private static boolean running = false;

	public static StringBuilder getInstance() {
		if (msg == null) {
			msg = new StringBuilder();
		}
		return msg;
	}

	public static boolean isRunning() {
		return running;
	}

	public static void setRunning(boolean running) {
		BatchMessage.running = running;
	}
}
