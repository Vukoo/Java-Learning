package gadek.com.decorator;

public class Tea extends Potion {
	

	@Override
	public float getPrice() {
		return 5f;
	}

	@Override
	public String getName() {
		return "Zwykła herbata";
	}
	
}
