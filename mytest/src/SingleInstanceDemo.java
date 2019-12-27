
/**
 * Single instance demo
 * @author cheqni
 *
 */
public class SingleInstanceDemo {
	// 定义一个私有的构造方法,无法在类外实例化
	private SingleInstanceDemo(){}
	/**
	 * 需要volatile关键字的原因是:在并发情况下，如果没有volatile关键字,当线程A 做new （//5行时）
	 * 此时如果线程b刚走到第一重判空，就会取到对象不为空，此时就会直接跳return到一个未初始化的值。
	 * 
	 */
	private volatile static SingleInstanceDemo mSingleInstance = null;
	
	//饿汉式（饥汉式）
	private final static SingleInstanceDemo mSingleInstanceHung = new SingleInstanceDemo();
	
	/**
	 * 饿汉式写法
	 * 在类加载的时候就初始化值
	 */
	public synchronized static SingleInstanceDemo getHungInstance() {
		return mSingleInstanceHung;
	}
	
	/**
	 * 懒汉式(饱汉式)
	 * @return
	 */
	public static SingleInstanceDemo getLazyInstance() {//1
		//第一重锁：提高效率避免不必要的等待。
		if (mSingleInstance == null) {//2
			synchronized(SingleInstanceDemo.class) {//3
				//此时线程a在new，线程b在等待，等线程b进来后就无需重新new，不判空会出现多次new对象的情况
				if (mSingleInstance ==  null) {//4
					mSingleInstance = new SingleInstanceDemo();//5
				}
			}
		}
		return mSingleInstance;
	}
	
}
