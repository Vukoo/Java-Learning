package gadek.com.decorator.main;

import gadek.com.decorator.component.Milk;
import gadek.com.decorator.component.Sugar;
import gadek.com.decorator.decorator.Coffe;
import gadek.com.decorator.decorator.Potion;
import gadek.com.decorator.decorator.Tea;

public class DecoratorRunner {
	 
    public static void main(String[] args) {
 
        System.out.println("Wzorzec projektowy Dekorator");
        //Decorated object
        Potion healt = new Coffe();
        System.out.println("Napój kawa bez dodatków: " + String.format("%.4g", healt.getPrice()));
        
        /*
        *Decorating object
        * magic starts here
        */
        healt = new Milk(healt);
        healt = new Sugar(healt);
 
        System.out.println("Napój wraz z dodatkami: " + String.format("%.4g", healt.getPrice()));
 
        Potion mana = new Tea();
        System.out.println("Napój herbata: " + String.format("%.4g", mana.getPrice()));
 
        mana = new Milk(mana);
 
        System.out.println("Herbatka z mlekiem: " + String.format("%.4g", mana.getPrice()));
    }		
}
