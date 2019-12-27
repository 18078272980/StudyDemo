
/**
 * Single instance demo
 * @author cheqni
 *
 */
public class SingleInstanceDemo {
	// ����һ��˽�еĹ��췽��,�޷�������ʵ����
	private SingleInstanceDemo(){}
	/**
	 * ��Ҫvolatile�ؼ��ֵ�ԭ����:�ڲ�������£����û��volatile�ؼ���,���߳�A ��new ��//5��ʱ��
	 * ��ʱ����߳�b���ߵ���һ���пգ��ͻ�ȡ������Ϊ�գ���ʱ�ͻ�ֱ����return��һ��δ��ʼ����ֵ��
	 * 
	 */
	private volatile static SingleInstanceDemo mSingleInstance = null;
	
	//����ʽ������ʽ��
	private final static SingleInstanceDemo mSingleInstanceHung = new SingleInstanceDemo();
	
	/**
	 * ����ʽд��
	 * ������ص�ʱ��ͳ�ʼ��ֵ
	 */
	public synchronized static SingleInstanceDemo getHungInstance() {
		return mSingleInstanceHung;
	}
	
	/**
	 * ����ʽ(����ʽ)
	 * @return
	 */
	public static SingleInstanceDemo getLazyInstance() {//1
		//��һ���������Ч�ʱ��ⲻ��Ҫ�ĵȴ���
		if (mSingleInstance == null) {//2
			synchronized(SingleInstanceDemo.class) {//3
				//��ʱ�߳�a��new���߳�b�ڵȴ������߳�b���������������new�����пջ���ֶ��new��������
				if (mSingleInstance ==  null) {//4
					mSingleInstance = new SingleInstanceDemo();//5
				}
			}
		}
		return mSingleInstance;
	}
	
}
