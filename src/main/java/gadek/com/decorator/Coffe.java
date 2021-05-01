package gadek.com.decorator;

public class Coffe extends Potion {
	
	@Override
	public float getPrice() {
		return 10f;
	}

	@Override
	public String getName() {
		return "Zwykla kawa";
	}
	

}
