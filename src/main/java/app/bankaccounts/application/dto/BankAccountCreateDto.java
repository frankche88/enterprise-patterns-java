package app.bankaccounts.application.dto;

import java.math.BigDecimal;

import app.common.application.enumeration.Currency;

public class BankAccountCreateDto {

	private String Number;
	private BigDecimal Balance;
	private Currency Currency;
	private boolean Locked;
	private long CustomerId;

	public BankAccountCreateDto() {
		Locked = false;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public BigDecimal getBalance() {
		return Balance;
	}

	public void setBalance(BigDecimal balance) {
		Balance = balance;
	}

	public Currency getCurrency() {
		return Currency;
	}

	public void setCurrency(Currency currency) {
		Currency = currency;
	}

	public boolean isLocked() {
		return Locked;
	}

	public void setLocked(boolean locked) {
		Locked = locked;
	}

	public long getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(long customerId) {
		CustomerId = customerId;
	}
	

}
