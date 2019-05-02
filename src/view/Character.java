package view;
import javax.swing.ImageIcon;

import controller.Debuggable;


/**
 * ĳ���� Ŭ���� 
 * (���ӿ��� �����̴� ĳ������ ��ǥ�� ���� ���� ������ ���� ����)
 * @author ��տ��� <a href="http://blog.naver.com/kkson50">http://blog.naver.com/kkson50</a>
 *
 */
public class Character {

	/**
     * ���ΰ��� X��ǥ
     */
	int x = 50;
    
    /**
     * ���ΰ��� Y��ǥ
     */
    int y;
    
	/**
	 * ĳ������ ���� (�������� �����ִ����� ����)
	 */
	boolean isRight;
	
	/**
	 * ĳ���� �̹����� ��ȣ  
	 */
	int imageNum;
	
	/**
	 * ĳ���� �̹����� ������
	 */
	public static int IMAGENUM_SIZE=8;
	
	/**
	 * ĳ������ �ִϸ��̼��� ��� ����
	 */
	ImageIcon[] icons=new ImageIcon[IMAGENUM_SIZE];
	
	/**
	 * ĳ������ ����
	 */
	int height;
	
	/**
	 * ĳ������ ����
	 */
	int width;
	
    /**
     * �����ϴ� ������ �˰� �ִ� ����
     */
    int jumpdirection=0; 
    
    /**
     * ���� ������ �� ���� (0�̸� �������Ѱ��̰�, 1�̻��̸� ������ �ϴ� ����) 
     */
    int jumpIdx=0;
    
	/**
	 * ���Ű� ������ �������α׷� 
	 */
	Debuggable debuggable;
	
	/**
	 * �ʱ������
	 * @param debuggable ����װ� ������ �������α׷�
	 */
	public Character(Debuggable debuggable) {
		
		this.debuggable=debuggable;
		
		for (int i=0;i<IMAGENUM_SIZE;++i) {
			String path="images\\mario" + i + ".gif";
			this.debuggable.debug(path);
			this.icons[i]=new ImageIcon(path);
		}
		this.width=this.icons[0].getIconWidth();
		this.height=this.icons[0].getIconHeight();
	}

	
	/**
	 * ������ ���¿� ���� �̹����� ������ 
	 * @return ImageIcon
	 */
	public ImageIcon getImageIcon() {
		
		switch (this.jumpIdx) {
			case 0:
				return this.icons[0];
				
			case 1:
				return this.icons[1];
				
			case 2:
				return this.icons[1];
				
			case 3:
				return this.icons[1];
				
			case 4:
				return this.icons[2];
				
			case 5:
				return this.icons[3];
				
			case 6:
				return this.icons[3];
				
			case 7:
				return this.icons[3];
			
			case 8:
				return this.icons[4];
			
			case 9:
				return this.icons[5];
			
			
			default:
				return this.icons[0];
		}
	}
	
	/**
	 * ���̸� �����Ѵ�.
	 * @return ����
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * ���̸� �����Ѵ�.
	 * @return ����
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * ������ ���¸� ������
	 * @return �����ε���
	 */
	public int getJumpIdx() {
		return this.jumpIdx;
	}
	
	/**
	 * ������ ���¸� ������ 
	 * @param jumpIdx �����ε���
	 */
	public void setJumpIdx(int jumpIdx) {
		this.jumpIdx=jumpIdx;
	}
	
	/**
	 * ������ ������ ������ 
	 * @return ��������(�����ʹ����̸� ���, ���ʹ����̸� ����)
	 */
	public int getJumpDirection() {
		return this.jumpdirection;
	}
	
	/**
	 * ������ ������ ������ (������? ����?)
	 * @param jumpDirection
	 */
	public void setJumpDirection (int jumpDirection) {
		this.jumpdirection=jumpDirection;
	}
	
	/**
	 * ������ �ϴ��������� ����
	 * @return ������ �ϸ� true
	 */
	public boolean isJumping() {
		if (this.jumpIdx==0) return false;
		return true;
	}

	/**
	 * x�·Ḧ ������Ų��.
	 * @param add ������Ű���� ��
	 */
	public void addX(int add) {
		this.x+=add;
	}
	
	/**
	 * y��ǥ�� ������Ų��. 
	 * @param add ������Ű���� �� 
	 */
	public void addY(int add) {
		this.y+=add;
	}
	
	/**
	 * x�·Ḧ �����Ѵ�.
	 * @param x x��ǥ 
	 */
	public void setX(int x) {
		this.x=x;		
	}

	/**
	 * y��ǥ�� �����Ѵ�.
	 * @param y y��ǥ
	 */
	public void setY(int y) {
		this.y=y;
	}	
	
	/**
	 * x��ǥ�� ��ȸ�Ѵ�.
	 * @return x��ǥ
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * y��ǥ�� ��ȸ�Ѵ�.
	 * @return y��ǥ
	 */
	public int getY() {
		return this.y;
	}
}
