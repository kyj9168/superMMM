package controller;
/**
 * ĳ���Ͱ� ������ �ϸ鼭 �߻��ϴ� �̺�Ʈ�� �޴� �������̽� 
 * @author ��տ��� <a href="http://blog.naver.com/kkson50">http://blog.naver.com/kkson50</a>
 *
 */
public interface JumpListener {
	
	/**
	 * ���� �߰��� �̺�Ʈ �߻���. (���� ����ܰ��� �������� �˼� ����)
	 * @param jumpIdx ����idx (1���ͽ�����)
	 * @param jumpy ������ ���ؼ� ����ؾ� �ϴ� ĳ������ Y��ǥ ������
	 */
	public void jumpTimeArrived(int jumpIdx, int jumpy);
	
	/**
	 * ������ �������� �˸� 
	 */
	public void jumpTimeEnded();
	
}
