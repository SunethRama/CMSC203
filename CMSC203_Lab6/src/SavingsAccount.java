public class SavingsAccount extends BankAccount {
	
	private double rate = 2.5/100;
	private int savingsNumber = 0;
	private String accountNumber;
	
	public SavingsAccount(String name, double amount){
		super(name, amount);
		this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
	}
	
	public SavingsAccount(SavingsAccount originalSavingsAccount, double amount) {
		super(originalSavingsAccount, amount);
		this.savingsNumber = ++originalSavingsAccount.savingsNumber;
		this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
	}
	
	public void postInterest(){
		super.deposit(super.getBalance()* (rate/12));
	}
	
	@Override
	public String getAccountNumber(){
		return accountNumber;
	}
}
