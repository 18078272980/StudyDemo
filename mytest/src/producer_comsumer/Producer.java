package producer_comsumer;

public class Producer implements Runnable {
	private final Storage storage = new Storage();

	public void run() {
		// TODO Auto-generated method stub
		storage.produce();

	}

}
