package gadek.com.decorator.main;

import gadek.com.decorator.Bike;
import gadek.com.decorator.CityBike;
import gadek.com.decorator.RoadBike;
import gadek.com.decorator.decorating.BicycleBell;
import gadek.com.decorator.decorating.BottleCage;
import gadek.com.decorator.decorating.Carrier;
import gadek.com.decorator.decorating.FrontFender;
import gadek.com.decorator.decorating.RearFender;
import gadek.com.decorator.decorating2.Milk;
import gadek.com.decorator.decorating2.Sugar;
import gadek.com.decorator2.Coffe;
import gadek.com.decorator2.Potion;
import gadek.com.decorator2.Tea;

public class DecoratorRunner {
	 
    public static void main(String[] args) {
        System.out.println("Wzorzec projektowy Dekorator");
 
        Bike cityBike = new CityBike();
        System.out.println("Waga roweru miejskiego bez akcesoriów: " + String.format("%.4g", cityBike.getWeight()));
        
        //dekorowanie
        cityBike = new Carrier(cityBike);
        cityBike = new RearFender(cityBike);
        cityBike = new FrontFender(cityBike);
        cityBike = new BicycleBell(cityBike);
 
        System.out.println("Waga roweru miejskiego z akcesoriami: " + String.format("%.4g", cityBike.getWeight()));
 
        Bike roadBike = new RoadBike();
        System.out.println("Waga roweru szosowego bez akcesoriów: " + String.format("%.4g", roadBike.getWeight()));
 
        roadBike = new BottleCage(roadBike);
 
        System.out.println("Waga roweru szosowego z akcesoriami: " + String.format("%.4g", roadBike.getWeight()));
        
        
        
        System.out.println("Wzorzec projektowy Dekorator");
        //obiekt dekorowany
        Potion healt = new Coffe();
        System.out.println("Napój kawa bez dodatków: " + String.format("%.4g", healt.getPrice()));
        
        //dekorowanie
        healt = new Milk(healt);
        healt = new Sugar(healt);
 
        System.out.println("Napój wraz z dodatkami: " + String.format("%.4g", healt.getPrice()));
 
        Potion mana = new Tea();
        System.out.println("Napój herbata: " + String.format("%.4g", mana.getPrice()));
 
        mana = new Milk(mana);
 
        System.out.println("Herbatka z mlekiem: " + String.format("%.4g", mana.getPrice()));
    }		
}