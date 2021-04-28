package gadek.com.decorator.decorator;

public class Coffe extends Potion {
	
	@Override
	public float getPrice() {
		return 10f;
	}

	@Override
	public String getName() {
		return "Zwykła kawa";
	}
	

}
