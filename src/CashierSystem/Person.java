package CashierSystem;

public class Person {
	public String firstName;
	public String surName;
	public String identificationNumber;
	public String adress;
	public String city;
	public int postalCode;
	
	public Person(String fn, String sn, String idn, String ad, String c, int pc)
	{
		firstName = fn;
		surName = sn;
		identificationNumber = idn;
		adress = ad;
		city = c;
		postalCode = pc;
	}

}
