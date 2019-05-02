package controller;

/**
 * ����� ������ ���α׷��̳�
 * @author ��տ��� <a href="http://blog.naver.com/kkson50">http://blog.naver.com/kkson50</a>
 *
 */
public interface Debuggable {
	
	/**
	 * ����� ��� (���� �̺�Ʈ�� �߿��� ������ ����ϴ� ����)
	 */
	public static int MODE_DEBUG=0;
	
	/**
	 * ������ ��� (����� ���� ���� ���)
	 */
	public static int MODE_RELEASE=1;
	
		
	/**
	 * ����Ÿ� �ϱ� ���ؼ� �����ΰ��� ǥ����
	 * @param s
	 */
	public void debug(String s);
}
