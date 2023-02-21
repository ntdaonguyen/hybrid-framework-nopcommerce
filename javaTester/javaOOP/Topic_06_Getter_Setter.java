package javaOOP;

public class Topic_06_Getter_Setter {
	public String personName;
	public int personAge;
	private int personPhone;
	private float personBankAccountAmount;
	
	
	
	public String getPersonName() {
		return personName;
	}



	public void setPersonName(String personName) {
		if (personName == null || personName.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be blank!");
		} else {
			this.personName = personName;
		}
	}



	public int getPersonAge() {
		return personAge;
	}



	public void setPersonAge(int personAge) {
		if (personAge < 15 || personAge > 60) {
			throw new IllegalArgumentException("Age is invalid!");
		} else {
			this.personAge = personAge;
		}
	}



	public int getPersonPhone() {
		return personPhone;
	}



	public void setPersonPhone(int personPhone) {
		if(!String.valueOf(personPhone).startsWith("0")) {
			throw new IllegalArgumentException("Phone number must start with 0!");
		} else if (personPhone < 10 || personPhone > 11) {
			throw new IllegalArgumentException("Phone number be 10 numbers!");

		}
		this.personPhone = personPhone;
	}



	public float getPersonBankAccountAmount() {
		return personBankAccountAmount;
	}



	public void setPersonBankAccountAmount(float personBankAccountAmount) {
		this.personBankAccountAmount = personBankAccountAmount;
	}



	public void showPersonInfo() {
		System.out.println(this.personName);
		System.out.println(this.personAge);
	}
	
}
