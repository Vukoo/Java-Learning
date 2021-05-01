package gadek.com.decorator.main;

import gadek.com.decorator.Coffe;
import gadek.com.decorator.Potion;
import gadek.com.decorator.Tea;
import gadek.com.decorator.component.Milk;
import gadek.com.decorator.component.Sugar;

public class DecoratorRunner {
	 
    public static void main(String[] args) {

        System.out.println("Wzorzec projektowy Dekorator");
        //decorated object
        Potion healt = new Coffe();
        System.out.println("Napoj kawa bez dodatkow: " + String.format("%.4g", healt.getPrice()));
        
        /*
         * Decorating 
         * magic starts here
         */
        healt = new Milk(healt);
        healt = new Sugar(healt);
 
        System.out.println("Napoj wraz z dodatkami: " + String.format("%.4g", healt.getPrice()));
        Potion mana = new Tea();
        System.out.println("Napoj herbata: " + String.format("%.4g", mana.getPrice()));
        mana = new Milk(mana);
        System.out.println("Herbatka z mlekiem: " + String.format("%.4g", mana.getPrice()));
    }		
}