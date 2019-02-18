package gadek.com.builder;


public class BuilderMain {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee.Builder().setCountry("Poland")
				.setFirstName("Piotr")
				.setLastName("G¹dek")
				.setGender(Gender.MALE)
				.setZipCode("32-860")
				.setBirth(26).build();
		System.out.println(emp1.toString());
	}
	
}
