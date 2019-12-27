package producer_comsumer;

import java.util.concurrent.LinkedBlockingQueue;

public class Storage {
	//仓库存储载体
	private static LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>(10);
	public void produce() {
		try {
			list.put(new Object());
			System.out.println("【生产者" + Thread.currentThread().getName()
	                + "】生产一个产品，现库存" + list.size());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void comsume(){
		try {
			if(list != null && list.size() > 0) {
				list.take();
				System.out.println("【消费者" + Thread.currentThread().getName()
		                 + "】消费了一个产品，现库存" + list.size());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
