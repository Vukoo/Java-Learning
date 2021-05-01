package gadek.com.decorator.component;

import gadek.com.decorator.Potion;

public class Sugar extends Additives {
	
	public Sugar(Potion potion) {
		this.potion = potion;
	}
	
	@Override
	public float getPrice() {
		return this.potion.getPrice() + 1f;
	}
	
	@Override
	public String getName() {
		return this.potion.getName() + " z cukrem";
	}
}
