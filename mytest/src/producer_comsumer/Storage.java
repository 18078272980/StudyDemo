package producer_comsumer;

import java.util.concurrent.LinkedBlockingQueue;

public class Storage {
	//�ֿ�洢����
	private static LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>(10);
	public void produce() {
		try {
			list.put(new Object());
			System.out.println("��������" + Thread.currentThread().getName()
	                + "������һ����Ʒ���ֿ��" + list.size());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void comsume(){
		try {
			if(list != null && list.size() > 0) {
				list.take();
				System.out.println("��������" + Thread.currentThread().getName()
		                 + "��������һ����Ʒ���ֿ��" + list.size());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
