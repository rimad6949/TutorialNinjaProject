package com.tutorialninja.pages;

class Person {
	 String firstname; String lastname; String emailadd; String ph; String password; String confirmPass;

	public Person(String firstname, String lastname, String emailadd, String ph, String password,
			String confirmPass) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailadd = emailadd;
		this.ph = ph;
		this.password = password;
		this.confirmPass = confirmPass;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmailadd() {
		return emailadd;
	}

	public String getPh() {
		return ph;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPass() {
		return confirmPass;
	}
	
	

}
