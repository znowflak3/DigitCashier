package CashierSystem;

public class Employee extends Person {

	public int employeeID;
	
	public Employee(int eID, String fn, String sn, String idn, String ad, String c, int pc) {
		super(fn, sn, idn, ad, c, pc);
		employeeID = eID;
	}

}
