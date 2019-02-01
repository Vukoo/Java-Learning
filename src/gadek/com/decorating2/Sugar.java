package gadek.com.decorator.decorating2;

import gadek.com.decorator2.Potion;

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
