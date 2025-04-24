package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
//FakerUtility is used for generating fake data. It avoids duplication.It will generate duplicate data when it is called
	
	Faker faker = new Faker();
	
	public String generateName() {
		return faker.name().fullName();
	}
	
	public String generateAddress() {
		return faker.address().fullAddress();
	}
	
	public String generatePhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}
	
	public String generateEmailID() {
		return faker.internet().emailAddress();
	}
	
	public String generateJob() {
		return faker.job().field();
	}
	
	public Long generateRandomNumber() {
		return faker.number().randomNumber();
	}
	
	public String generateRandomCountry() {
		return faker.country().name();
	}
	
	public String generateRandomPIN() {
		return faker.address().zipCode();
	}
}
