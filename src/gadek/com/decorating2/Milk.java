package gadek.com.decorator.decorating2;

import gadek.com.decorator2.Potion;

public class Milk extends Additives {
	
	public Milk(Potion potion) {
		this.potion = potion;
	}

	@Override
	public float getPrice() {
		return this.potion.getPrice()+ 2f;
	}
	
	@Override
	public String getName() {
		return this.potion.getName() + " z mlekiem";
	}
}
