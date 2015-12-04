package class4;

import java.util.Date;


class Fruit{
	
}

class Mango extends Fruit{
	
}

class Apple extends Fruit{
	String color;
}


public class Account {
	private String accountNumber;
	protected Double balance;
	private Date dateOfOpening;
	private Transactions transactions;
	private boolean isJointlyHeldWithAnotherPerson;
}

class CheckingAccount extends Account{
	public Double getBalance(){
		return balance;
	}
}

class SavingsAccount extends Account{
	public Double getBalance(){
		return balance + 0.02 * balance;
	}
}

class Transactions {

}
