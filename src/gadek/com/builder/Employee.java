package gadek.com.builder;


public class Employee {

	private String firstName;
	private String lastName;
	private Gender gender;
	private String country;
	private Integer age;
	private String zipCode;
	
	private Employee(String firstName, String lastName, Gender gender, String country, Integer age, String zipCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.country = country;
		this.age = age;
		this.zipCode = zipCode;
	}
	 

		public static class Builder {
	    	private String firstName;
	    	private String lastName;
	    	private Gender gender;
	    	private String country;
	    	private Integer age;
	    	private String zipCode;
	    	
	    	public Builder() {
	    	}

			public Builder setFirstName(String firstName) {
				this.firstName = firstName;
				return this;
			}

			public Builder  setLastName(String lastName) {
				this.lastName = lastName;
				return this;
			}

			public Builder  setGender(Gender gender) {
				this.gender = gender;
				return this;
			}

			public Builder  setCountry(String country) {
				this.country = country;
				return this;

			}

			public Builder  setBirth(Integer age) {
				this.age = age;
				return this;
			}

			public Builder  setZipCode(String zipCode) {
				this.zipCode = zipCode;
				return this;
			}
	        
			public Employee build() {
				return new Employee(firstName, lastName, gender, country, age, zipCode);
			}
	    }
	    
	 public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public String getCountry() {
		return country;
	}

	public Integer getAge() {
		return age;
	}

	public String getZipCode() {
		return zipCode;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", country="
				+ country + ", age=" + age + ", zipCode=" + zipCode + "]";
	}  
}
