package gadek.com.singleton;

/*
 * We initialize Singleton into memory
 * when we use method getInstance
 * but it can be destroyed with Java reflection
 */
public class SingletonBillPugh {

	private SingletonBillPugh () {
	}
	public static SingletonBillPugh getInstance() {
		return SingletonHolder.INSTANCE;
	}
	private static class SingletonHolder{
		private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
	}
}
