package gadek.com.singleton;

public class Main {
    public static void main(String[] args) {
    	
    	//enum Singleton
        Singleton singleton = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;
        SingletonBillPugh bill = SingletonBillPugh.getInstance();
        SingletonBillPugh Pugh = SingletonBillPugh.getInstance();
        if (singleton == singleton2) {

            System.out.println("Two enum objects are same");

        } else {

            System.out.println("Two enum objects are not same");

        }
        
        if (bill == Pugh) {

            System.out.println("Two  objects are same");

        } else {

            System.out.println("Two objects are not same");

        }

    }
}
