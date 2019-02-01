package gadek.com.decorator.component;

import gadek.com.decorator.Potion;

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
