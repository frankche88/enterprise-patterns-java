package app.bankAccounts.domain.entity;

import app.common.domain.valueObject.Money;
import app.customers.domain.entity.Customer;

public class BankAccount {
	
	private long Id;
    private String Number;
    private Money Balance;
    private boolean Locked;
	private Customer Customer;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public Money getBalance() {
		return Balance;
	}
	public void setBalance(Money balance) {
		Balance = balance;
	}
	public boolean isLocked() {
		return Locked;
	}
	public void setLocked(boolean locked) {
		Locked = locked;
	}
	public Customer getCustomer() {
		return Customer;
	}
	public void setCustomer(Customer customer) {
		Customer = customer;
	}
	

}
